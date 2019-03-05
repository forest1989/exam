package com.sgcc.exam.common.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sgcc.isc.core.orm.identity.Department;
import com.sgcc.isc.core.orm.identity.User;
import com.sgcc.isc.core.orm.organization.BusinessOrganization;
import com.sgcc.isc.framework.common.constant.Constants;
import com.sgcc.isc.service.adapter.factory.AdapterFactory;
import com.sgcc.isc.service.adapter.helper.IExternService;
import com.sgcc.isc.service.adapter.helper.IIdentityService;
import com.sgcc.uap.config.util.PlatformConfigUtil;
import com.sgcc.uap.persistence.IHibernateDao;
import com.sgcc.uap.utils.ComponentFactory;

public class ISCOrgUtil {
	private static final Log logger = LogFactory.getLog(ISCOrgUtil.class);
	public static String audit_type1 = "业务事件";
	public static String audit_type2 = "系统事件";
	public static String audit_result1 = "成功";
	public static String audit_result2 = "失败";
	private static IHibernateDao hibernateDao = (IHibernateDao) ComponentFactory.getBean("hibernateDao");

	public static User getUserByUserId(String userId) throws Exception {
		IIdentityService idService = (IIdentityService) AdapterFactory.getInstance(Constants.CLASS_IDENTITY);
		List<User> userList = idService.getUserByIds(new String[] { userId });
		return userList.get(0);
	}

	public static User getUsersByLoginCode1(String userName, HttpServletRequest request) {
		User user = new User();
		IIdentityService idService = (IIdentityService) AdapterFactory.getInstance(Constants.CLASS_IDENTITY);
		List<User> userList = null;
		try {
			userList = idService.getUsersByLoginCode(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (userList.size() == 0) {
			return user;
		} else {
			return userList.get(0);
		}
	}

	public static User getUsersByLoginCode(String userName, HttpServletRequest request) throws Exception {
		User user = new User();
		IIdentityService idService = (IIdentityService) AdapterFactory.getInstance(Constants.CLASS_IDENTITY);
		List<User> userList = null;
		if (userName != null || ("").equals("userName")) {
			try {
				userList = idService.getUsersByLoginCode(userName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (userList.size() == 0 || userList == null) {
				User u = null;
				if (!"".equals(userName) || userName != null) {
					Map<String, String> user1 = (Map) request.getSession().getAttribute("user");
					String name = user1.get("name");
					List<User> userList1 = null;
					String province_id = null;
					try {
						userList1 = idService.getUsersByLoginCode(name);
					} catch (Exception e) {
						e.printStackTrace();
					}
					if (userList1.size() == 0) {
					} else {
						province_id = userList1.get(0).getResExt().get("provinceid").toString();
					}
					LinkedHashMap<String, Object> relist = getUserByNameCode(userName, province_id);
					// System.out.println("获取从账号信息+=+++" + relist);
					String loginname = null;
					if (relist != null) {
						loginname = relist.get("userName").toString();
						// System.out.println("主账号为+++++" + loginname);
						try {
							u = ISCOrgUtil.getUsersByLoginCodes(loginname);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				if (u == null) {
					return user;
				} else {
					return u;
				}
			} else {
				return userList.get(0);
			}
		} else {
			return user;
		}
	}

	/**
	 * 获取机构所属省市县机构id
	 * 
	 * @param struid
	 *            当前机构id
	 * @return
	 */

	public static Map<String, String> getStruId(String struid) {
		String idsheng = ""; // 省份
		String iddishi = ""; // 地市
		String idxian = ""; // 县区

		Map<String, String> map = new HashMap<String, String>();
		try {
			String orgNamepath = ISCOrgUtil.getOrgPathStruidName(struid);
			String[] orgNam = orgNamepath.split("###");
			int number = orgNam.length;
			String orgIdpath = ISCOrgUtil.getOrgPathStruid(struid);
			String[] orgId = orgIdpath.split("###");
			/* orgNam[orgNam.length-1] = ""; */
			int flag = 0;
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < orgNam.length; i++) {
				if (flag > 0) {
					flag++;
				}
				if ("国家电网公司".equals(orgNam[i])) {
					map.put("guo", orgId[i + 1]);
					flag++;
				}
				if (flag == 2) {
					map.put("sheng", orgId[i + 1]);
				}
				if (flag == 3) {
					map.put("dishi", orgId[i + 1]);
				}
				if (flag == 4) {
					map.put("xian", orgId[i + 1]);
				}
			}

		} catch (Exception e) {
			logger.error("isc信息获取异常", e);
		}

		return map;
	}

	/**
	 * 根据用户登录名 得到ISC中的User 实体对象
	 * 
	 * @param userNames
	 * @return
	 * @throws Exception
	 */
	public static User getUsersByLoginCode(String userName) {
		User user = new User();
		IIdentityService idService = (IIdentityService) AdapterFactory.getInstance(Constants.CLASS_IDENTITY);
		List<User> userList = null;
		try {
			userList = idService.getUsersByLoginCode(userName);
		} catch (Exception e) {
			logger.error("isc信息获取异常", e);
		}
		if (userList.size() == 0) {
			// 获取当前人员的登录曾层级

			String id = "555";
			user.setId(id);
			return user;
		} else
			return userList.get(0);
	}

	public static Map<String, String> getStruname(String struid) {
		String namesheng = "";
		String namedishi = "";
		String namexian = "";
		Map<String, String> map = new HashMap<String, String>();
		try {
			String orgNamepath = ISCOrgUtil.getOrgPathStruidName(struid);
			String[] orgNam = orgNamepath.split("###");
			int number = orgNam.length;
			if (orgNam[number - 1] == "国家电网公司" || ("国家电网公司").equals(orgNam[number - 1])) {
				if (number - 2 >= 0) {
					namesheng = orgNam[number - 2];
				}
				if (number - 3 >= 0) {
					namedishi = orgNam[number - 3];
				}
				if (number - 4 >= 0) {
					namexian = orgNam[number - 4];
				}
			} else {
				if (orgNam[0] == "国家电网公司" || ("国家电网公司").equals(orgNam[0])) {
					if (number > 1) {
						namesheng = orgNam[1];
					}
					if (number > 2) {
						namedishi = orgNam[2];
					}
					if (number > 3) {
						namexian = orgNam[3];
					}
				} else {
					if (number > 0) {
						namesheng = orgNam[0];
					}
					if (number > 1) {
						namedishi = orgNam[1];
					}
					if (number > 2) {
						namexian = orgNam[2];
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("sheng", namesheng);
		map.put("dishi", namedishi);
		map.put("xian", namexian);
		return map;
	}

	public static User getUsersByLoginCodes(String userName) {
		User user = new User();
		IIdentityService idService = (IIdentityService) AdapterFactory.getInstance(Constants.CLASS_IDENTITY);
		List<User> userList = null;
		try {
			userList = idService.getUsersByLoginCode(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (userList.size() == 0) {
			return user;
		} else {
			return userList.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public static LinkedHashMap<String, Object> getUserByNameCode(String userName, String struId) {
		IExternService service = AdapterFactory.getExternService();
		String uri = "/userList/getUserByNameCode";
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("namecode", userName);
		map.put("province_id", struId);
		LinkedHashMap<String, Object> result = null;
		try {
			result = null;//(List<Map<String, Object>>) service.callService(uri, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			return null;
		} else {
			return result;
		}
	}

	public static Department getDepartment(HttpServletRequest request) {
		Department department = null;
		try {
			String userId = getUserId(request);
			User user = getUserByUserId(userId);
			IIdentityService service = (IIdentityService) AdapterFactory.getInstance(Constants.CLASS_IDENTITY);
			department = service.getDepartmentById(user.getBaseOrgId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return department;
	}

	public static Department getDepartmentByUserId(String userId) {
		Department department = null;
		User user;
		try {
			user = getUserByUserId(userId);
			IIdentityService service = (IIdentityService) AdapterFactory.getInstance(Constants.CLASS_IDENTITY);
			department = service.getDepartmentById(user.getBaseOrgId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return department;
	}

	public static Department getDepartmentByUserName(String userName) {
		Department department = new Department();
		User user = null;
		try {
			IIdentityService service = (IIdentityService) AdapterFactory.getInstance(Constants.CLASS_IDENTITY);
			if (PublicUtil.nvl(user)) {
				return department;
			} else {
				department = service.getDepartmentById(user.getBaseOrgId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return department;
	}

	@SuppressWarnings("rawtypes")
	public static String getUserId(HttpServletRequest request) throws Exception {
		Map userMap = (Map) request.getSession().getAttribute("user");
		String userId = (String) userMap.get("id");
		return userId;
	}

	public static User getUser(HttpServletRequest request) {
		String userId = null;
		User user = null;
		try {
			userId = getUserId(request);
			user = getUserByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public static List<Department> getSubDepartment(String deptId) throws Exception {
		IIdentityService service = (IIdentityService) AdapterFactory.getInstance(Constants.CLASS_IDENTITY);
		List<Department> list = service.getSubDepartment(deptId, Constants.DEPARTMENT_PROPERTY_CORPORATION);
		return list;
	}

	public static Department getDepartmentById(String deptId) throws Exception {
		IIdentityService service = (IIdentityService) AdapterFactory.getInstance(Constants.CLASS_IDENTITY);
		Department department = service.getDepartmentById(deptId);
		return department;
	}

	public static List<User> getUsersByOrg(String orgId) throws Exception {
		String systemId = PlatformConfigUtil.getString("ISC_APPID");
		IIdentityService service = (IIdentityService) AdapterFactory.getInstance(Constants.CLASS_IDENTITY);
		Map<String, String> map = new HashMap<String, String>();
		List<User> list = service.getUsersByOrg(systemId, orgId, map, new String[] {});
		return list;
	}

	public static List<BusinessOrganization> getBusinessOrgByUserId(String appId, String userId) throws Exception {
		try {
			List<BusinessOrganization> listOrg = AdapterFactory.getOrganizationService().getBusiOrgByUserId(userId,
					appId);
			return listOrg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getIscAppId() {
		return PlatformConfigUtil.getString("ISC_APPID");
	}

	public static String getOrgPathStruid(String struid) {
		List<BusinessOrganization> listOrg2;
		String struidpath = "";
		String struid2 = "";
		String orgName = "";
		try {
			listOrg2 = AdapterFactory.getOrganizationService().getOrgPathByOrgId(struid);
			if (listOrg2.size() == 1 || listOrg2.size() == 2) {
				int i = 0;
				do {
					i++;
					listOrg2 = AdapterFactory.getOrganizationService().getOrgPathByOrgId(struid);
					if (listOrg2.size() == 1 || listOrg2.size() == 2) {
						struid2 = listOrg2.get(listOrg2.size() - 1).getId();
						orgName = listOrg2.get(listOrg2.size() - 1).getName();
						struid = listOrg2.get(listOrg2.size() - 1).getParentId();
						if (i == 1) {
							struidpath = struidpath + "###" + struid2;
							// System.out.println("+++++++++++11111微电影" +
							// struidpath);
						} else {
							struidpath = struidpath + "###" + struid2;
							// System.out.println("+++++++++++2222微电影" +
							// struidpath);
						}
					}
				} while (!"国家电网公司".equals(orgName) && i < 5);
			} else {
				for (int i = 0; i < listOrg2.size(); i++) {
					struid2 = listOrg2.get(i).getId();
					if (i == 0) {
						struidpath = struidpath + "###" + struid2;
						// System.out.println("+++++++++++3333微电影" +
						// struidpath);
					} else {
						struidpath = struidpath + "###" + struid2;
						// System.out.println("+++++++++++4444微电影" +
						// struidpath);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return struidpath;
	}

	public static String getOrgPathStruidu(String struidu) {
		List<BusinessOrganization> listOrg2;
		String struidpath = struidu;
		String struid2 = "";
		String orgName = "";
		try {
			listOrg2 = AdapterFactory.getOrganizationService().getOrgPathByOrgId(struidu);
			if (listOrg2.size() == 1) {
			} else if (listOrg2.size() == 1 || listOrg2.size() == 2) {
				int i = 0;
				do {
					i++;
					listOrg2 = AdapterFactory.getOrganizationService().getOrgPathByOrgId(struidu);
					if (listOrg2.size() == 1 || listOrg2.size() == 2) {
						struid2 = listOrg2.get(listOrg2.size() - 1).getId();
						orgName = listOrg2.get(listOrg2.size() - 1).getName();
						struidu = listOrg2.get(listOrg2.size() - 1).getParentId();
						if (i == 1) {
							struidpath = struidpath + "###" + struid2;
							// System.out.println("+++++++++++11111首页活动" +
							// struidpath);
						} else {
							struidpath = struidpath + "###" + struid2;
							// System.out.println("+++++++++++2222首页活动" +
							// struidpath);
						}
					}
				} while (!"国家电网公司".equals(orgName) && i < 5);
			} else {
				for (int i = 0; i < listOrg2.size(); i++) {
					struid2 = listOrg2.get(i).getId();
					if (i == 0) {
						struidpath = struid2;
						// System.out.println("+++++++++++3333首页活动" +
						// struidpath);
					} else {
						struidpath = struidpath + "###" + struid2;
						// System.out.println("+++++++++++4444首页活动" +
						// struidpath);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return struidpath;
	}

	public static String getOrgPathStruidact(String struid) {
		List<BusinessOrganization> listOrg2;
		String struidpath = struid;
		String struid2 = "";
		String orgName = "";
		try {
			listOrg2 = AdapterFactory.getOrganizationService().getOrgPathByOrgId(struid);
			// System.out.println("++++++++++++++第一次接口获取到机构信息 listOrg2=" +
			// listOrg2);
			if (listOrg2.size() == 1 || listOrg2.size() == 2) {
				int i = 0;
				do {
					i++;
					listOrg2 = AdapterFactory.getOrganizationService().getOrgPathByOrgId(struid);
					// System.out.println("++++++++++++++第一次接口获取到机构信息 listOrg2="
					// + listOrg2);
					if (listOrg2.size() != 0) {
						struid2 = listOrg2.get(listOrg2.size() - 1).getId();
						orgName = listOrg2.get(listOrg2.size() - 1).getName();
						struid = listOrg2.get(listOrg2.size() - 1).getParentId();
						if (i == 1) {
							struidpath = struidpath + "###" + struid2;
							// System.out.println("++++++++++++++第一种
							// struidpath=" + struidpath);
						} else {
							struidpath = struidpath + "###" + struid2;
							// System.out.println("++++++++++++++第二种
							// struidpath=" + struidpath);
						}
					}
				} while (!"国家电网公司".equals(orgName) && i < 5);
			} else {
				for (int i = 0; i < listOrg2.size(); i++) {
					struid2 = listOrg2.get(i).getId();
					if (i == 0) {
						struidpath = struidpath + "###" + struid2;
						// System.out.println("++++++++++++++直接跳入for循环——————————————
						// struidpath=" + struidpath);
					} else {
						struidpath = struidpath + "###" + struid2;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return struidpath;
	}

	public static String getOrgPathStruids(String struid) {
		List<BusinessOrganization> listOrg2;
		String struidpath = struid;
		String struid2 = "";
		String orgName = "";
		try {
			listOrg2 = AdapterFactory.getOrganizationService().getOrgPathByOrgId(struid);
			if (listOrg2.size() == 1 || listOrg2.size() == 2) {
				int i = 0;
				do {
					i++;
					listOrg2 = AdapterFactory.getOrganizationService().getOrgPathByOrgId(struid);
					if (listOrg2.size() != 0) {
						struid2 = listOrg2.get(listOrg2.size() - 1).getId();
						orgName = listOrg2.get(listOrg2.size() - 1).getName();
						struid = listOrg2.get(listOrg2.size() - 1).getParentId();
						if (i == 1) {
							struidpath = struidpath + "###" + struid2;
						} else {
							struidpath = struidpath + "###" + struid2;
						}
					}
				} while (!"国家电网公司".equals(orgName) && i < 5);
			} else {
				for (int i = 0; i < listOrg2.size(); i++) {
					struid2 = listOrg2.get(i).getId();
					if (i == 0) {
						struidpath = struidpath + "###" + struid2;
					} else {
						struidpath = struidpath + "###" + struid2;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return struidpath;
	}

	public static String getStruid(HttpServletRequest request) {
		String struid = "";
		Map<String, String> user = (Map) request.getSession().getAttribute("user");
		String userid = user.get("id");
		try {
			String appid = PlatformConfigUtil.getString("ISC_APPID");
			List<BusinessOrganization> listOrg = AdapterFactory.getOrganizationService().getBusiOrgByUserId(userid,
					appid);
			struid = listOrg.get(0).getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return struid;
	}

	public static String getOrgPathStruidName(String struid) {
		List<BusinessOrganization> listOrg2;
		String orgNamepath = "";
		String orgName = "";
		try {
			listOrg2 = AdapterFactory.getOrganizationService().getOrgPathByOrgId(struid);
			if (listOrg2.size() == 1 || listOrg2.size() == 2) {
				int i = 0;
				do {
					i++;
					listOrg2 = AdapterFactory.getOrganizationService().getOrgPathByOrgId(struid);
					if (listOrg2.size() == 1 || listOrg2.size() == 2) {
						orgName = listOrg2.get(listOrg2.size() - 1).getName();
						struid = listOrg2.get(listOrg2.size() - 1).getParentId();
						if (i == 1) {
							orgNamepath = listOrg2.get(listOrg2.size() - 1).getName();
							// System.out.println("+++++++++++111111上层级单位名称" +
							// orgNamepath);
						} else {
							orgNamepath = orgNamepath + "###" + listOrg2.get(listOrg2.size() - 1).getName();
							// System.out.println("+++++++++++2222上层级单位名称" +
							// orgNamepath);
						}
					}
				} while (!"国家电网公司".equals(orgName) && i < 5);
			} else {
				for (int i = 0; i < listOrg2.size(); i++) {
					orgName = listOrg2.get(i).getName();
					if (i == 0) {
						orgNamepath = orgName;
						// System.out.println("+++++++++++3333上层级单位名称" +
						// orgNamepath);
					} else {
						orgNamepath = orgNamepath + "###" + orgName;
						// System.out.println("+++++++++++444444层级单位名称" +
						// orgNamepath);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orgNamepath;
	}

	public static List getStaffByCode(String userName, HttpServletRequest request) {
		new HashMap<String, Object>();
		Map<String, String> user1 = (Map) request.getSession().getAttribute("user");
		String userid = user1.get("id");
		String appid = PlatformConfigUtil.getString("ISC_APPID");
		List<BusinessOrganization> listOrg = null;
		try {
			listOrg = AdapterFactory.getOrganizationService().getBusiOrgByUserId(userid, appid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String struid = listOrg.get(0).getId();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT staff_id,staff_name, staff_sex, staff_deptname, staff_department, staff_tel");
		sql.append(" FROM tb_staff_account");
		sql.append(" where staff_struid= ? and staff_account=?  and staff_status='已激活'");
		List<Map<String, String>> list2 = hibernateDao.queryForListWithSql(sql.toString(),
				new Object[] { struid, userName });
		return list2;
	}

	public static User getUserListByLoginCode(String userName, HttpServletRequest request) throws Exception {
		User user = new User();
		IIdentityService idService = (IIdentityService) AdapterFactory.getInstance(Constants.CLASS_IDENTITY);
		List<User> userList = null;
		if (userName != null || ("").equals("userName")) {
			try {
				userList = idService.getUsersByLoginCode(userName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (userList.size() == 0 || userList == null) {
				User u = null;
				if (!"".equals(userName) || userName != null) {
					IExternService service = AdapterFactory.getExternService();
					String uri = "/user/getDefUsersByorgId";
					HashMap<Object, Object> map = new HashMap<Object, Object>();
					map.put("orgId", "EC287011B24C0964E0430100007FAC3D");
					map.put("systemId", "4028fd8c4aeb3c41014aeb58189a0004");
					List<Map<String, Object>> userList2 = null;
					try {
						userList2 = null;//(List<Map<String, Object>>) service.callService(uri, map);
					} catch (Exception e) {
						e.printStackTrace();
					}
					String name3 = userList2.get(0).get("userName").toString();
					Map<String, String> user1 = (Map) request.getSession().getAttribute("user");
					user1.get("name");
					List<User> userList1 = null;
					String province_id = null;
					try {
						userList1 = idService.getUsersByLoginCode(name3);
					} catch (Exception e) {
						e.printStackTrace();
					}
					if (userList1.size() == 0) {
					} else {
						province_id = userList1.get(0).getResExt().get("provinceid").toString();
					}
					LinkedHashMap<String, Object> relist = getUserListByNameCode(userName, province_id);
					// System.out.println("获取从账号信息+=+++" + relist);
					String loginname = null;
					if (relist != null) {
						loginname = relist.get("userName").toString();
						// System.out.println("主账号为+++++" + loginname);
						try {
							u = ISCOrgUtil.getUsersByLoginCodes(loginname);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				if (u == null) {
					return user;
				} else {
					return u;
				}
			} else {
				return userList.get(0);
			}
		} else {
			return user;
		}
	}

	public static User getUserListByLoginCode(String userName, HttpServletRequest request, String struId)
			throws Exception {
		User user = new User();
		IIdentityService idService = (IIdentityService) AdapterFactory.getInstance(Constants.CLASS_IDENTITY);
		List<User> userList = null;
		if (userName != null || ("").equals("userName")) {
			try {
				userList = idService.getUsersByLoginCode(userName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (userList.size() == 0 || userList == null) {
				User u = null;
				if (!"".equals(userName) || userName != null) {
					String appid = PlatformConfigUtil.getString("ISC_APPID");
					IExternService service = AdapterFactory.getExternService();
					String uri = "/user/getDefUsersByorgId";
					HashMap<Object, Object> map = new HashMap<Object, Object>();
					map.put("orgId", struId);
					map.put("systemId", appid);
					List<Map<String, Object>> userList2 = null;
					try {
						userList2 = null;//(List<Map<String, Object>>) service.callService(uri, map);
					} catch (Exception e) {
						e.printStackTrace();
					}
					String name3 = userList2.get(0).get("userName").toString();
					Map<String, String> user1 = (Map) request.getSession().getAttribute("user");
					user1.get("name");
					List<User> userList1 = null;
					String province_id = null;
					try {
						userList1 = idService.getUsersByLoginCode(name3);
					} catch (Exception e) {
						e.printStackTrace();
					}
					if (userList1.size() == 0) {
					} else {
						province_id = userList1.get(0).getResExt().get("provinceid").toString();
					}
					LinkedHashMap<String, Object> relist = getUserListByNameCode(userName, province_id);
					// System.out.println("获取从账号信息+=+++" + relist);
					String loginname = null;
					if (relist != null) {
						loginname = relist.get("userName").toString();
						// System.out.println("主账号为+++++" + loginname);
						try {
							u = ISCOrgUtil.getUsersByLoginCodes(loginname);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				if (u == null) {
					return user;
				} else {
					return u;
				}
			} else {
				return userList.get(0);
			}
		} else {
			return user;
		}
	}

	@SuppressWarnings("unchecked")
	public static LinkedHashMap<String, Object> getUserListByNameCode(String userName, String struId) {
		IExternService service = AdapterFactory.getExternService();
		String uri = "/userList/getUserByNameCode";
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("namecode", userName);
		map.put("province_id", struId);
		LinkedHashMap<String, Object> result = null;
		try {
			result = null;//(List<Map<String, Object>>) service.callService(uri, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			return null;
		} else {
			return result;
		}
	}

	public static Map<String, String> getStruname2(String struId) {
		String namesheng = "";
		String namedishi = "";
		String namexian = "";
		Map<String, String> map = new HashMap<String, String>();
		String struName = "";
		String parentId = struId;
		int n = 0;
		do {
			String sql = "select stru_name,parent_id from tb_sum_tongji where stru_id =?";
			List<Map<String, Object>> list = hibernateDao.queryForListWithSql(sql, new Object[] { parentId });
			if (list.size() != 0) {
				if (n != 0) {
					struName = struName + "###" + (String) list.get(0).get("stru_name");
				} else {
					struName = (String) list.get(0).get("stru_name");
				}
				parentId = (String) list.get(0).get("parent_id");
			}
			n++;
		} while ((!"4028819f5c5bcc97015cc85068353466".equals(parentId)) && (!"null".equals(parentId))
				&& (parentId != null));
		String[] struArray = struName.split("###");
		if (n == 4) {
			namexian = struArray[0];
			namedishi = struArray[1];
			namesheng = struArray[2];
		} else if (n == 3) {
			namexian = "";
			namedishi = struArray[0];
			namesheng = struArray[1];
		} else if (n == 2) {
			namexian = "";
			namedishi = "";
			namesheng = struArray[0];
		}
		map.put("sheng", namesheng);
		map.put("dishi", namedishi);
		map.put("xian", namexian);
		return map;
	}

	public static String setAudit(HttpServletRequest request, String audit_name, String audit_handle, String audit_type,
			String audit_result, String audit_content) {
		String auditId = UUID.randomUUID().toString();
		String userId = "";
		String userLoginName = "";
		String deName = "";
		String userName = "";
		try {
			userId = getUserId(request);
			User user = getUser(request);
			Department depart = getDepartment(request);
			userLoginName = user.getResExt() == null ? "" : (String) user.getResExt().get("namecode");
			deName = depart.getName();
			userName = user.getName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String ip = getIpAddr(request);
		Date date = new Date();
		String dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		audit_content = "用户[" + userName + "]于[" + dateFormat + "]在[" + audit_name + "]执行[" + audit_handle + "]操作["
				+ audit_result + "],操作内容为[" + audit_content + "]";
		String insertSql = "insert into tb_audit(audit_id,audit_name,audit_handle,audit_type,audit_result,audit_person,audit_time,audit_content,audit_struid,person_id,login_name,login_ip) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		hibernateDao.executeSqlUpdate(insertSql, new Object[] { auditId, audit_name, audit_handle, audit_type,
				audit_result, userName, dateFormat, audit_content, deName, userId, userLoginName, ip });
		// 插入数据后进行数据查询，覆盖6个月前的一条数据
		String querySql = "select * from tb_audit where date_part('day',now()::timestamp-audit_time::timestamp)>=60 limit 1";
		List<Map<String, Object>> resultList = hibernateDao.queryForListWithSql(querySql.toString());
		if (resultList.size() > 0) {
			String deleteSql = "delete from tb_audit where audit_id=?";
			for (Map<String, Object> chMap : resultList) {
				int result = hibernateDao.executeSqlUpdate(deleteSql.toString(),
						new Object[] { chMap.get("audit_id") });
			}
			// 删除6个月前的一条数据

		}
		return null;
	}

	public static String getIpAddr(HttpServletRequest request) {
		/*
		 * String ip = null; ip = request.getHeader("x-forwarded-for"); if (ip
		 * == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { ip =
		 * request.getHeader("Proxy-Client-IP"); } if (ip == null || ip.length()
		 * == 0 || "unknown".equalsIgnoreCase(ip)) { ip =
		 * request.getHeader("WL-Proxy-Client-IP"); } if (ip == null ||
		 * ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { ip =
		 * request.getRemoteAddr(); if (ip.equals("127.0.0.1")) { InetAddress
		 * inet = null; try { inet = InetAddress.getLocalHost(); } catch
		 * (UnknownHostException e) { } if(inet != null){ ip =
		 * inet.getHostAddress(); } } } if (ip != null && ip.length() > 15) { //
		 * "***.***.***.***".length() if (ip.indexOf(",") > 0) { ip =
		 * ip.substring(0, ip.indexOf(",")); } } return ip;
		 */
		String ip = request.getRemoteAddr();
		if (ip.equals("127.0.0.1")) {
			InetAddress inet = null;
			try {
				inet = InetAddress.getLocalHost();
			} catch (UnknownHostException e) {
			}
			if (inet != null) {
				ip = inet.getHostAddress();
			}
		}
		if (ip != null && ip.length() > 15) { // "***.***.***.***".length()
			if (ip.indexOf(",") > 0) {
				ip = ip.substring(0, ip.indexOf(","));
			}
		}
		return ip;
	}
}
