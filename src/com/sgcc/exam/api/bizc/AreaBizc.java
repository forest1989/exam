package com.sgcc.exam.api.bizc;
import java.util.*;

import javax.annotation.Resource;

import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.exam.api.po.Area;
import com.sgcc.exam.common.utils.WXUtil;
import com.sgcc.exam.rguser.po.MUser;
import com.sgcc.exam.testpaper.po.APITestPaper;
import com.sgcc.uap.mdd.runtime.base.BizCDefaultImpl;
import com.sgcc.uap.persistence.IHibernateDao;

import java.io.Serializable;


public class AreaBizc extends BizCDefaultImpl<Area, Serializable> implements IAreaBizc {
	@Resource
	IHibernateDao hibernateDao;
	/**************** 标准方法执行前后事件,默认全部返回true *******************/
	@Override
	protected void afterDelete(Area area) {
		// 自定义逻辑
	
	}

	@Override
	protected void afterAdd(Area area) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeDelete(Area area) {
		// 自定义逻辑
		
		return true;
	}

	@Override
	protected boolean beforeAdd(Area area) {
		// 自定义逻辑
		return true;
	}

	@Override
	protected void afterUpdate(Area area ,Serializable pk) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeUpdate(Area area, Serializable pk) {
		// 自定义逻辑
		return true;
	}

	/**
	 * 根据openId查询用户是否存在
	 * */
	@Override
	public Integer getUserId(String openId) {
		// TODO Auto-generated method stub
		Object[] obj= new Object[1];
		obj[0] = openId;
		List<MUser> list = hibernateDao.executeSqlQuery("select m_User_Id,open_Id,area_Id,nick_Name,photo_Url,gender,login_Date from m_user where open_Id=?", obj, MUser.class);
		if(list!=null && list.size()>0){
			return list.get(0).getmUserId();
		}
			return null;
	}

	/**
	 * 获取试卷列表
	 * */
	@Override
	public List<APITestPaper> getPaper() {
		// TODO Auto-generated method stub
		return hibernateDao.queryForListWithSql("select TEST_PAPER_ID,TEST_PAPER_NAME,ANSWER_TIME,TEST_PAPER_TYPE,REMARKS,CREATE_DATE,CREATE_BY,UPDATE_BY,UPDATE_DATE from TEST_PAPER");
	}
	
	/**
	 * 根据试卷ID获取试题类型
	 * */
	@Override
	public List<Map<String , Object>> getexamTypeId(String testPaperId ,  String testPaperType) {
		// TODO Auto-generated method stub
		Object[] obj= new Object[1];
		obj[0] = testPaperId;
		String sql = "select EXAM_TYPE_ID , %s from %s where TEST_PAPER_ID = ?";
		if("z".equalsIgnoreCase(testPaperType)){//生成规则 --> 自动时 查询AUTOMATIC_RULE表 返回字段为EXAM_COUNT
			sql = String.format(sql, "EXAM_COUNT" , "AUTOMATIC_RULE");
		}else{//生成规则 --> 手动时  查询MANUAL_RULE表 返回字段为EXAM_IDS
			sql = String.format(sql, "EXAM_IDS" , "MANUAL_RULE");
		}
		return  hibernateDao.executeSqlQuery(sql , obj);
	}
	
	/**
	 * 获取指定试卷
	 * */
	@Override
	public List<Map<String, Object>> getListPaper(Map<String, Object> map , String testPaperType) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list= null;
		String examTypeId = String.valueOf(map.get("exam_type_id")); 
		if("z".equalsIgnoreCase(testPaperType)){//生成规则  --> 自动时  获取map中EXAM_COUNT的值为自动生成试题得到数量
			String examCount = String.valueOf(map.get("EXAM_COUNT"));
			list = hibernateDao.queryForListWithSql("select ex.exam_id as examid,rt.`reading_code` as readcode, rt.`reading_img` as readimg,rt.`reading_text` as readtext,ex.`exam_content_img` as contentimg,ex.`exam_content_text` as contenttext,ex.`exam_subject` as examsubject,ex.`exam_grades` as examgrades,ex.`exam_mark` as exammark, op.`options_a_img` as aimg,op.`options_a_text` as atext,op.`options_b_img` as bimg,op.`options_b_text` as btext,op.`options_c_img` as cimg,op.`options_c_text` as ctext,op.`options_d_img` as dimg,op.`options_d_text` as dtext,op.`options_e_img` as eimg,op.`options_e_text` as etext,op.`options_f_img` as fimg,op.`options_f_text` as ftext from  examinfo ex  left join exam_options op  on ex.`exam_id` = op.`exam_id`  left join reading_text rt on ex.`reading_id` = rt.`reading_id` where   ex.exam_type_id=? group by examid order by rand()*100 limit 0,? ",new Object[]{Integer.valueOf(examTypeId),Integer.valueOf(examCount)} );
		}else{//生成规则  --> 手动时  获取map中EXAM_IDS的值为指定试题的ID集合
			String examIds = String.valueOf(map.get("EXAM_IDS"));
			String[] ids = examIds.split(","); //数组化参数
			Integer[] result = new Integer[ids.length];//数组类型转化
			List<Integer> listId = new ArrayList<Integer>();
			for(int i=0;i<ids.length;i++)
			{
			   result[i] = Integer.parseInt(ids[i]);//
			}
			list = hibernateDao.queryForListWithSql("select ex.exam_id as examid,rt.`reading_code` as readcode, rt.`reading_img` as readimg,rt.`reading_text` as readtext,ex.`exam_content_img` as contentimg,ex.`exam_content_text` as contenttext,ex.`exam_subject` as examsubject,ex.`exam_grades` as examgrades,ex.`exam_mark` as exammark, op.`options_a_img` as aimg,op.`options_a_text` as atext,op.`options_b_img` as bimg,op.`options_b_text` as btext,op.`options_c_img` as cimg,op.`options_c_text` as ctext,op.`options_d_img` as dimg,op.`options_d_text` as dtext,op.`options_e_img` as eimg,op.`options_e_text` as etext,op.`options_f_img` as fimg,op.`options_f_text` as ftext from  examinfo ex  left join exam_options op  on ex.`exam_id` = op.`exam_id`  left join reading_text rt on ex.`reading_id` = rt.`reading_id` where   ex.exam_type_id=? and ex.EXAM_ID in (?) group by examid order by rand()*100 ", 
			new Object[]{Integer.valueOf(examTypeId),result});
		}
		return list;
	}

	
}
