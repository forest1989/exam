package com.sgcc.exam.api.bizc;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.sgcc.exam.api.po.APIExamType;
import com.sgcc.exam.etype.po.ExamType;
import com.sgcc.exam.api.po.APIExamType;
import com.sgcc.uap.mdd.runtime.base.BizCDefaultImpl;
import com.sgcc.uap.persistence.IHibernateDao;


public class APIExamTypeBizc extends BizCDefaultImpl<APIExamType, Serializable> implements IAPIExamTypeBizc {
	
	
	@Override
	public List<Map<String, Object>> getChooseExamInfos(String ids) {
		// TODO Auto-generated method stub
		String sql = "SELECT ex.exam_id AS examid,ex.EXAM_ANSWER AS result,rt.`reading_code` AS readcode, rt.`reading_img` AS readimg,rt.`reading_text` AS readtext,ex.`exam_content_img` AS contentimg,ex.`exam_content_text` AS contenttext,ex.`exam_subject` AS examsubject,ex.`exam_grades` AS examgrades,ex.`exam_mark` AS exammark, op.`options_a_img` AS aimg,op.`options_a_text` AS atext,op.`options_b_img` AS bimg,op.`options_b_text` AS btext,op.`options_c_img` AS cimg,op.`options_c_text` AS ctext,op.`options_d_img` AS dimg,op.`options_d_text` AS dtext,op.`options_e_img` AS eimg,op.`options_e_text` AS etext,op.`options_f_img` AS fimg,op.`options_f_text` AS ftext FROM  examinfo ex  LEFT JOIN exam_options op  ON ex.`exam_id` = op.`exam_id` LEFT JOIN reading_text rt ON ex.`reading_id` = rt.`reading_id` WHERE   ex.exam_id IN("+ids+") ";
		return this.hibernateDao.queryForListWithSql(sql);
	}

	
	@Autowired
	private IHibernateDao hibernateDao;
	
	/**************** 标准方法执行前后事件,默认全部返回true *******************/
	@Override
	protected void afterDelete(APIExamType examtype) {
		// 自定义逻辑
	
	}

	@Override
	protected void afterAdd(APIExamType examtype) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeDelete(APIExamType examtype) {
		// 自定义逻辑
		
		return true;
	}

	@Override
	protected boolean beforeAdd(APIExamType examtype) {
		// 自定义逻辑
		return true;
	}

	@Override
	protected void afterUpdate(APIExamType examtype ,Serializable pk) {
		// 自定义逻辑
	}

	@Override
	protected boolean beforeUpdate(APIExamType examtype, Serializable pk) {
		// 自定义逻辑
		return true;
	}

	 

	@Override
	public APIExamType getExamtype(Integer valueOf) {
		int n=this.hibernateDao.queryForIntWithSql("select count(*) from  exam_type where EXAM_TYPE_ID=?", new Object[]{valueOf});
		if(n>0){
			return (APIExamType) this.hibernateDao.queryForObjectWithSql("select * from  exam_type where EXAM_TYPE_ID=?", new Object[]{valueOf}, ParameterizedBeanPropertyRowMapper.newInstance(APIExamType.class));
		}else{
			return null;
		}
	}
	
	@Override
	public List<APIExamType> getParents() {
		return this.hibernateDao.queryForListWithSql("select * from exam_type where del_flag=0  and parent_id=0  ");
	}

	@Override
	public List<APIExamType> getSons(String id) {
		// TODO Auto-generated method stub
		return this.hibernateDao.queryForListWithSql("select * from exam_type where del_flag=0  and parent_id=?",new Object[]{id});
	}

	@Override
	public List<Map<String,Object>> getExamTypeInfos(String id, String size) {
		// TODO Auto-generated method stub
		return this.hibernateDao.queryForListWithSql("select ex.exam_id as examid,ex.EXAM_ANSWER as result,rt.`reading_code` as readcode, rt.`reading_img` as readimg,rt.`reading_text` as readtext,ex.`exam_content_img` as contentimg,ex.`exam_content_text` as contenttext,ex.`exam_subject` as examsubject,ex.`exam_grades` as examgrades,ex.`exam_mark` as exammark, op.`options_a_img` as aimg,op.`options_a_text` as atext,op.`options_b_img` as bimg,op.`options_b_text` as btext,op.`options_c_img` as cimg,op.`options_c_text` as ctext,op.`options_d_img` as dimg,op.`options_d_text` as dtext,op.`options_e_img` as eimg,op.`options_e_text` as etext,op.`options_f_img` as fimg,op.`options_f_text` as ftext from  examinfo ex  left join exam_options op  on ex.`exam_id` = op.`exam_id`  left join reading_text rt on ex.`reading_id` = rt.`reading_id` where   ex.exam_type_id=? group by examid order by rand()*100 limit 0,? ",new Object[]{Integer.valueOf(id),Integer.valueOf(size)} );
	}

	@Override
	public List<Map<String, Object>> getExamInfos(String size) {
		// TODO Auto-generated method stub
		return this.hibernateDao.queryForListWithSql("select ex.exam_id as examid,ex.EXAM_ANSWER as result,rt.`reading_code` as readcode, rt.`reading_img` as readimg,rt.`reading_text` as readtext,ex.`exam_content_img` as contentimg,ex.`exam_content_text` as contenttext,ex.`exam_subject` as examsubject,ex.`exam_grades` as examgrades,ex.`exam_mark` as exammark, op.`options_a_img` as aimg,op.`options_a_text` as atext,op.`options_b_img` as bimg,op.`options_b_text` as btext,op.`options_c_img` as cimg,op.`options_c_text` as ctext,op.`options_d_img` as dimg,op.`options_d_text` as dtext,op.`options_e_img` as eimg,op.`options_e_text` as etext,op.`options_f_img` as fimg,op.`options_f_text` as ftext from  examinfo ex  left join exam_options op  on ex.`exam_id` = op.`exam_id`  left join reading_text rt on ex.`reading_id` = rt.`reading_id`  group by examid order by rand()*100 limit 0,? ",new Object[]{Integer.valueOf(size)} );
	}

	@Override
	public List<Map<String, Object>> getExamResult(String ids) {
		/* String[] strarr = ids.split(",");
		Integer[] intarra = new Integer[strarr.length];
		for(int i=0;i<strarr.length;i++)
		{
			intarra[i] = Integer.parseInt(strarr[i]);
		}
		System.out.println(intarra.toString()); */
		String sql = "  select exam_id as examId , exam_answer as answerOptions, exam_mark as mark,EXAM_TYPE_ID as examTypeId  from examinfo where exam_id in ("+ ids +")";
		//List<Map<String, Object>> ll = this.hibernateDao.queryForListWithSql("  select exam_id as examId , exam_answer as answerOptions, exam_mark as mark,EXAM_TYPE_ID as examTypeId  from examinfo where exam_id in (?)",new Object[]{intarra});
		 // System.out.println(ll);
		//System.out.println(this.hibernateDao.queryForListWithSql("select exam_id as examId , exam_answer as answerOptions, exam_mark as mark,EXAM_TYPE_ID as examTypeId  from examinfo where exam_id in (6,14)"));
		return this.hibernateDao.queryForListWithSql(sql);
	//	return ll;
	}

	
	
	 

	 

	 
	
}
