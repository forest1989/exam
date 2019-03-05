package com.sgcc.exam.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.sgcc.isc.core.orm.complex.FunctionNode;
import com.sgcc.isc.core.orm.complex.FunctionTree;
import com.sgcc.isc.core.orm.resource.Function;
import com.sgcc.isc.core.orm.role.OrganizationalRole;
import com.sgcc.isc.service.adapter.factory.AdapterFactory;
import com.sgcc.isc.service.adapter.impl.RoleService;
import com.sgcc.uap.config.util.PlatformConfigUtil;
import com.sgcc.uap.persistence.IHibernateDao;
import com.sgcc.uap.utils.ComponentFactory;
import com.sgcc.uap.utils.StringUtils;
import com.sgcc.isc.framework.common.constant.Constants;

public class ISCOrgInfo {
	String xml = "<xmlmenu>";
	public String test(HttpServletRequest request) throws Exception {
		String appID = PlatformConfigUtil.getString("ISC_APPID").trim();
		String userID = request.getSession().getAttribute("userId") == null ? "" : request.getSession().getAttribute("userId").toString();
		FunctionTree funct = AdapterFactory.getResourceService().getFuncTree(userID, appID, "001");
		if (null != funct) {
			List<FunctionNode> list = funct.getFuncNode();
			xml = buildMenuTree(list, false);
		}
		xml = xml + "</xmlmenu>";
		if (xml.indexOf("审计日志") != -1) {
			request.setAttribute("sjFlag", "1");
			String querySql = "select count(audit_id) from tb_audit where audit_name = '审计管理' and read_type = '0' ";
			IHibernateDao hibernateDao = (IHibernateDao) ComponentFactory.getBean("hibernateDao");
			int result = hibernateDao.queryForIntWithSql(querySql);
			request.setAttribute("sjCount", result);
		} else {
			request.setAttribute("sjFlag", "0");
		}
		return xml;
	}

	private String buildMenuTree(List<FunctionNode> nodeTree, boolean isFirstLevel) throws Exception {
		if (nodeTree == null) {
			return "";
		}
		String menuURL = null;
		String menuID = null;
		String menuText = null;
		for (FunctionNode node : nodeTree) {
			if (canMenuShow(node.getCurrentNode())) {
				menuID = node.getCurrentNode().getBusiCode();
				menuURL = node.getCurrentNode().getUrl();
				menuText = node.getCurrentNode().getName();
				Object iconStr = node.getCurrentNode().getExtValue("PS");
				if (iconStr == null || iconStr.toString().length() == 0) {
					iconStr = "bt18";
				}
				if (isFirstLevel) {
					xml = xml + "<menu id=\"001\" url=\"" + menuURL + "\" text=\"" + menuText
							+ "\" targetframe=\"main\" type=\"0\" link=\"\" selected=\"false\" enable=\"true\" noborderColor=\"false\"  iconImg=\"" + iconStr + "\" >";
				}
				xml = xml + "<menu id=\"" + menuID + "\" url=\"" + menuURL + "\" text=\"" + menuText + "\" targetframe=\"main\" type=\"0\" link=\"\" selected=\"false\" enable=\"true\" noborderColor=\"false\" iconImg=\"" + iconStr + "\" >";
				buildMenuTree(node.getNextNode(), false);
				xml = xml + "</menu>";
				if (isFirstLevel) {
					xml = xml + "</menu>";
				}
			}
		}
		return xml;
	}

	public List<String> getOrgInfo(String userId) throws Exception {
		List<String> syss = new ArrayList<String>();
		String sys1 = "";
		String sys2 = "";
		String orgCoded = "";
		String systemId = PlatformConfigUtil.getString("ISC_APPID");
		RoleService roleService = (RoleService) AdapterFactory.getInstance(Constants.CLASS_ROLE);
		Map<String, String> params = new HashMap<String, String>();
		List<OrganizationalRole> orgRoleList = roleService.getOrgRolesByUserId(userId, systemId, params);
		if (orgRoleList.size() > 0) {
			OrganizationalRole organRole = orgRoleList.get(0);
			String ss = organRole.getCode();
			orgCoded = ss;
			if (ss != null && ss != "" && ss.length() > 4) {
				String syscode1 = ss.substring(2, 4);
				String syscode2 = ss.substring(0, 4);
				if (syscode1 == "cw" || syscode1.equals("cw")) {
					sys1 = "CW";
				} else if (syscode1 == "ws" || syscode1.equals("ws")) {
					sys1 = "CG";
				} else if (syscode1 == "rs" || syscode1.equals("rs")) {
					sys1 = "RS";
				} else if (syscode1 == "dd" || syscode1.equals("dd")) {
					sys1 = "DD";
				} else if (syscode1 == "gw" || syscode1.equals("gw")) {
					sys1 = "GW";
				} else if (syscode1 == "yx" || syscode1.equals("yx")) {
					sys1 = "YX";
				}
				if (syscode2 == "bzcw" || syscode2.equals("zbcw")) {
					sys2 = "ZBCW";
				}
			}
		}
		syss.add(sys1);
		syss.add(sys2);
		syss.add(orgCoded.toUpperCase());
		return syss;
	}
	private static boolean canMenuShow(Function p_func) {
		boolean result = true;
		if (p_func.getIsAvaliable() == null) {
			result = true;
		} else {
			result = StringUtils.equals(p_func.getIsAvaliable(), "Y");
		}
		return result;
	}
}
