package com.sgcc.exam.api.bizc;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;


import com.sgcc.exam.api.po.APIAnswerHistory;
import com.sgcc.uap.mdd.runtime.base.BizCDefaultImpl;

public  class APIHistoryBizc extends BizCDefaultImpl<APIAnswerHistory, Serializable> implements IAPIHistoryBizc{

	@Override
	public List<Map<String, Object>> getExamInfoList(String typeId, String grade, String subject, String pageNum,
			String pageSize) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("select ex.EXAM_ID as id ,ex.EXAM_CONTENT_TEXT as context,ex.exam_subject as subject, ex.EXAM_GRADES as grade,ex.exam_mark as mark, EXAM_TYPE.TYPE_NAME as typeName  from examinfo ex left join EXAM_TYPE   on ex.`EXAM_TYPE_ID` = EXAM_TYPE.`EXAM_TYPE_ID` where 1=1 ");
 		// "and ex.EXAM_TYPE_ID =1 and ex.EXAM_GRADES=01 and ex.exam_subject=1 ";
 		int len =2;
		if(null != typeId && !"".equals(typeId)){
 			 sb.append("and ex.EXAM_TYPE_ID =? ");
 			len+=1;
 		 }
 		 if(null != grade && !"".equals(grade)){
 			 sb.append("and ex.EXAM_GRADES =? ");
 			len+=1;
 		 }
 		 if(null != subject && !"".equals(subject)){
 			sb.append("and ex.exam_subject=? ");
 			len+=1;
 		 }
 		sb.append("limit ?,?");
 		Object[] oarr = new Object[len];
 		int m = 0;
 		if(null != typeId && !"".equals(typeId)){
 			oarr[m++] = Integer.valueOf(typeId);
		 }
		 if(null != grade && !"".equals(grade)){
			 oarr[m++] = grade;
		 }
		 if(null != subject && !"".equals(subject)){
			 oarr[m++] = subject;
		 }
		 oarr[m++] = (Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize);
		 oarr[m] = Integer.valueOf(pageSize);
		 
		return this.hibernateDao.queryForListWithSql(sb.toString(),oarr);
	}
	@Override
	public int addHistory(List<APIAnswerHistory> list) {
		// TODO Auto-generated method stub
		APIAnswerHistory temp = new APIAnswerHistory();
		int cnt =0;
		for(int i=0;i<list.size();i++){
			temp = list.get(i);
			this.hibernateDao.saveObject(temp);
			cnt += 1;
		}
		return cnt;
	}
	/**
	 * 查询练习题提交的历史记录
	 */
	@Override
	public List<Map<String, Object>> getTestHistoryTitle(int userId, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return this.hibernateDao.queryForListWithSql("SELECT M_USER_ID as mUserId,COUNT(1) AS total,SUM(ANSWER_RESULT) AS score,create_date FROM answer_history WHERE test_paper_id=0 AND m_user_id=? GROUP BY create_date,m_user_id    ORDER BY create_date DESC limit ?,?", new Object[]{ userId,  pageNum,  pageSize});
	}
	 
	
	/**
	 * 查询练习题提交的历史详情
	 */
	@Override
	public List<Map<String, Object>> getTestHistory(int userId, String date) {
		// TODO Auto-generated method stub
		return this.hibernateDao.queryForListWithSql("SELECT exam_id as examId,answer_options as answerOptions,ANSWER_RESULT as result FROM answer_history  WHERE     m_user_id=?  AND  DATE_FORMAT(create_date,'%Y-%m-%d %H:%M:%S') = DATE_FORMAT(?,'%Y-%m-%d %H:%M:%S')", new Object[]{ userId,  date}); 
	}
	/**
	 * 查询考试题提交的历史详情
	 */
	@Override
	public List<Map<String, Object>> getPaperHistory(int userId, int paperId) {
		// TODO Auto-generated method stub
		return this.hibernateDao.queryForListWithSql("SELECT exam_id as examId,answer_options as answerOptions,ANSWER_RESULT as result FROM answer_history  WHERE     m_user_id=?  AND test_paper_id = ?", new Object[]{ userId,  paperId}); 
	}
	
	@Override
	protected void afterAdd(APIAnswerHistory arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void afterDelete(APIAnswerHistory arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void afterUpdate(APIAnswerHistory arg0, Serializable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean beforeAdd(APIAnswerHistory arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean beforeDelete(APIAnswerHistory arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean beforeUpdate(APIAnswerHistory arg0, Serializable arg1) {
		// TODO Auto-generated method stub
		return false;
	}
}
