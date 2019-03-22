package com.sgcc.exam.api.bizc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sgcc.exam.api.po.APIPaperHistory;
import com.sgcc.exam.api.po.APIPaperHistory;
import com.sgcc.uap.mdd.runtime.base.BizCDefaultImpl;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
 

public class APIPaperHistoryBizc  extends BizCDefaultImpl<APIPaperHistory, Serializable> implements  IAPIPaperHistoryBizc {
	/**
	 * 获取手动生成试卷信息
	 */
	@Override
	public List<Map<String, Object>> getHandExamInfos(Integer examId) {
		// TODO Auto-generated method stub
		String sql = "SELECT  GROUP_CONCAT(exam_ids) AS ids FROM MANUAL_RULE WHERE test_paper_id="+examId+" GROUP BY test_paper_id";
		//先根据examId，查询手动配置的各个类型的试题id集合
		String ids =(String) this.hibernateDao.queryForObjectWithSql(sql,String.class);
		//根据ids集合获取试题详细信息
		sql = "SELECT ex.exam_id AS examid,ex.EXAM_ANSWER AS result,rt.`reading_code` AS readcode, rt.`reading_img` AS readimg,rt.`reading_text` AS readtext,ex.`exam_content_img` AS contentimg,ex.`exam_content_text` AS contenttext,ex.`exam_subject` AS examsubject,ex.`exam_grades` AS examgrades,ex.`exam_mark` AS exammark, op.`options_a_img` AS aimg,op.`options_a_text` AS atext,op.`options_b_img` AS bimg,op.`options_b_text` AS btext,op.`options_c_img` AS cimg,op.`options_c_text` AS ctext,op.`options_d_img` AS dimg,op.`options_d_text` AS dtext,op.`options_e_img` AS eimg,op.`options_e_text` AS etext,op.`options_f_img` AS fimg,op.`options_f_text` AS ftext FROM  examinfo ex  LEFT JOIN exam_options op  ON ex.`exam_id` = op.`exam_id` LEFT JOIN reading_text rt ON ex.`reading_id` = rt.`reading_id` WHERE   ex.exam_id IN("+ids+")";

		return this.hibernateDao.queryForListWithSql(sql);
	}
	/**
	 * 根据试卷id查出自动生成试卷
	 */
	@Override
	public List<Map<String, Object>> getAutoExamInfos(int examId) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> tempList = new ArrayList<Map<String,Object>>();
		//查出试卷对应的所有规则
		List<Map<String, Object>> ruleList = this.hibernateDao.queryForListWithSql("select  EXAM_TYPE_ID as eType,EXAM_COUNT  as cnt from automatic_rule where test_paper_id = ?", new Object[]{examId});
		int len = ruleList.size();
		//没有配置规则
		if(len == 0){
			return null;
		}else{
			for(int i=0;i<len;i++){
				//tempList置空，用于暂时性存储，最终由list保存结果返回
				tempList = new ArrayList<Map<String,Object>>();
				tempList =   this.hibernateDao.queryForListWithSql("select ex.exam_id as examid,ex.EXAM_ANSWER as result,rt.`reading_code` as readcode, rt.`reading_img` as readimg,rt.`reading_text` as readtext,ex.`exam_content_img` as contentimg,ex.`exam_content_text` as contenttext,ex.`exam_subject` as examsubject,ex.`exam_grades` as examgrades,ex.`exam_mark` as exammark, op.`options_a_img` as aimg,op.`options_a_text` as atext,op.`options_b_img` as bimg,op.`options_b_text` as btext,op.`options_c_img` as cimg,op.`options_c_text` as ctext,op.`options_d_img` as dimg,op.`options_d_text` as dtext,op.`options_e_img` as eimg,op.`options_e_text` as etext,op.`options_f_img` as fimg,op.`options_f_text` as ftext from  examinfo ex  left join exam_options op  on ex.`exam_id` = op.`exam_id`  left join reading_text rt on ex.`reading_id` = rt.`reading_id` where   ex.exam_type_id=? group by examid order by rand()*100 limit 0,? ",
						new Object[]{ Integer.valueOf(ruleList.get(i).get("eType").toString()),Integer.valueOf(ruleList.get(i).get("cnt").toString())} );
				for(Map<String, Object> m : tempList){
					list.add(m);
				}
			}
		}
		return list;
	}
	
	
	@Override
	public String getPaperType(Integer paperId) {
		// TODO Auto-generated method stub
		String sql ="SELECT TEST_PAPER_TYPE FROM test_paper WHERE test_paper_id="+paperId;
		return (String) this.hibernateDao.queryForObjectWithSql(sql, String.class);
	}
	
	//根据名称查询试卷列表信息
	@Override
	public List<Map<String, Object>> getPaperListByName(String paperName, int start, int size) {
		// TODO Auto-generated method stub
		return this.hibernateDao.queryForListWithSql(" select test_paper_id as id ,test_paper_name as name,stru_id as struid, answer_time as astime,test_paper_type as papertype,remarks as remarks,create_date as createdate,create_by as createby,update_by as updateby,update_date as updatedate from test_paper where del_flag=0 and test_paper_name=? order by test_paper_id desc limit ?,?",new Object[]{paperName, start,  size});
	}
	//查询考试记录
	@Override
	public List<Map<String, Object>> getPaperHistoryTitle(int userId, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return this.hibernateDao.queryForListWithSql("SELECT m_user_id as userId,test_paper_id as paperId,mark,create_date as createDate FROM TEST_PAPER_HISTORY WHERE m_user_id=? ORDER BY CREATE_DATE DESC LIMIT ?,?",new Object[]{ userId,  pageNum,  pageSize});
	}
	/*
	 * 查询试卷列表信息
	 */
	@Override
	public List<Map<String, Object>> getPaperList(int start, int size) {
		// TODO Auto-generated method stub
		return this.hibernateDao.queryForListWithSql(" select test_paper_id as id ,test_paper_name as name,stru_id as struid, answer_time as astime,test_paper_type as papertype,remarks as remarks,create_date as createdate,create_by as createby,update_by as updateby,update_date as updatedate from test_paper where del_flag=0 order by test_paper_id desc limit ?,?",new Object[]{ start,  size});
	}
	/**************** 标准方法执行前后事件,默认全部返回true *******************/
	@Override
	protected void afterDelete(APIPaperHistory entity) {
		// 自定义逻辑
	
	}

	@Override
	protected void afterAdd(APIPaperHistory entity) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeDelete(APIPaperHistory entity) {
		// 自定义逻辑
		
		return true;
	}

	@Override
	protected boolean beforeAdd(APIPaperHistory entity) {
		// 自定义逻辑
		return true;
	}

	@Override
	protected void afterUpdate(APIPaperHistory entity ,Serializable pk) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeUpdate(APIPaperHistory entity, Serializable pk) {
		// 自定义逻辑
		return true;
	}


	

	
	
}
