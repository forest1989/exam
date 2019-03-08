package com.sgcc.exam.examInfo;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sgcc.exam.etype.bizc.IExamTypeBizc;
import com.sgcc.exam.etype.po.ExamType;
import com.sgcc.exam.examInfo.bizc.IExamOptionsBizc;
import com.sgcc.exam.examInfo.bizc.IExaminfoBizc;
import com.sgcc.uap.rest.annotation.ItemResponseBody;
import com.sgcc.uap.rest.annotation.VoidResponseBody;
import java.io.Serializable;
import org.springframework.http.server.ServletServerHttpRequest;
import com.sgcc.uap.rest.annotation.attribute.ViewAttributeData;
import com.sgcc.uap.service.validator.ServiceValidatorBaseException;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.exam.examInfo.po.ExamOptions;
import com.sgcc.exam.examInfo.po.Examinfo;
import com.sgcc.uap.mdd.runtime.validate.IValidateService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sgcc.uap.rest.annotation.QueryRequestParam;
import com.sgcc.uap.rest.annotation.ColumnResponseBody;
import com.sgcc.uap.rest.annotation.IdRequestBody;
import org.springframework.web.client.RestClientException;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.annotation.ColumnRequestParam;
import com.sgcc.uap.mdd.runtime.utils.BeanUtils;
import com.sgcc.uap.mdd.runtime.meta.IMetadataService;
import java.util.*;
import com.sgcc.uap.mdd.runtime.utils.BodyReaderRequestWrapper;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.mdd.runtime.utils.HttpMessageConverter;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import com.sgcc.uap.bizc.sysbizc.datadictionary.IDataDictionaryBizC;


@Controller
@RequestMapping("/examinfo")
public class ExaminfoController {

	@Resource
	private IExaminfoBizc examinfoBizc;
	@Resource
	private IExamOptionsBizc examoptionsBizc;
	@Resource
	private IExamTypeBizc examtypeBizc;
	@Resource
	private IDataDictionaryBizC dataDictionaryBizC;
	
	@Resource
	private IMetadataService metadataService;
	@Resource
	private IValidateService validateService;
	@Resource
	private HttpMessageConverter coverter;
	@RequestMapping("/meta")
	public @ColumnResponseBody List<ViewAttributeData> getPropertyMeta(@ColumnRequestParam("params") String[] filterPropertys) throws Exception {
	
		List<ViewAttributeData> datas = null;
		datas = metadataService.getPropertyMeta(this.getClass(), "com.sgcc.exam.examInfo.po.Examinfo", filterPropertys);
		return datas;
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ItemResponseBody List<Examinfo> save(HttpServletRequest request_){
		try {
			//获取servlet API
			ServletServerHttpRequest servlet = new BodyReaderRequestWrapper(request_);
	        //将模型转换为java对象
			Examinfo[] examinfos = coverter.converter(new Examinfo[0], servlet);
		    List<Map<String,Object>> changedProperies = coverter.converter(new ArrayList<Map<String,Object>>(), servlet);
	        List<Examinfo> voList = new ArrayList<Examinfo>();
	        //对所有属性进行后端校验
			validateService.validateWithException(Examinfo.class, changedProperies);
			//遍历表单数据, 如果当前数据在数据库里存在, 则做修改, 否则做新增处理
			for (int i = 0; i < examinfos.length; i++) {
				Examinfo examinfo= examinfos[i];
				Serializable pkValue = examinfo.getExamId();
				Map<String,Object> changedProperty = coverter.flatHandle(Examinfo.class,changedProperies.get(i));
				if (null != pkValue) {
					int examId = examinfo.getExamId();
					Examinfo old = examinfoBizc.get(pkValue);
	 				BeanUtils.populate(old, changedProperty);
	                examinfoBizc.update(old, pkValue);
	                //试题选项表判断
	                ExamOptions oldEx = examoptionsBizc.getInfo(examId);
	                if(oldEx==null){
	                	oldEx=new ExamOptions();
	                	oldEx.setExamId(examId);
		 				BeanUtils.populate(oldEx, changedProperty);
		 				examoptionsBizc.add(oldEx);
	                }else{
	                	BeanUtils.populate(oldEx, changedProperty);
		 				examoptionsBizc.update(oldEx, examId);
	                }
	                
					voList.add(examinfo);
				}else{
					BeanUtils.populate(examinfo, changedProperty);
					examinfoBizc.add(examinfo);
				    //试题选项表判断
					/*Examinfo exinfo = examinfoBizc.select();*/
                    ExamOptions oldEx =new ExamOptions();
                	oldEx.setExamId(examinfo.getExamId());
	 				BeanUtils.populate(oldEx, changedProperty);
	 				examoptionsBizc.add(oldEx);
					voList.add(examinfo);
				}
			}
			return voList;
		}catch (ServiceValidatorBaseException e) {
			throw e;
		}catch (Exception e) {
			throw new RestClientException("保存方法异常", e);
		}
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @VoidResponseBody Object delete(@IdRequestBody IDRequestObject idObject){
		String[] ids = idObject.getIds();
		for (String id : ids) {
			int n=examoptionsBizc.deleteExid(java.lang.Integer.valueOf(id));
			if(n>0){
				examinfoBizc.delete(java.lang.Integer.valueOf(id));
			}
		}
		return null;
	}

	@RequestMapping("/{id}")
    public @ItemResponseBody QueryResultObject get(@PathVariable String id) {
		Examinfo examinfo ;
		if("null".equals(id)){
			examinfo = null;
		}else {
			examinfo = examinfoBizc.get(java.lang.Integer.valueOf(id));
			Object mp = examoptionsBizc.getOpId(java.lang.Integer.valueOf(id));
			ExamType et = examtypeBizc.getExamtype(Integer.valueOf(examinfo.getExamTypeId()));
			if(mp!=null){
				ExamOptions	wp=(ExamOptions)mp;
				examinfo.setOptionsAImg(wp.getOptionsAImg());
				examinfo.setOptionsAText(wp.getOptionsAText());
				examinfo.setOptionsBImg(wp.getOptionsBImg());
				examinfo.setOptionsBText(wp.getOptionsBText());
				examinfo.setOptionsCImg(wp.getOptionsCImg());
				examinfo.setOptionsCText(wp.getOptionsCText());
				examinfo.setOptionsDImg(wp.getOptionsDImg());
				examinfo.setOptionsDText(wp.getOptionsDText());
				examinfo.setOptionsEImg(wp.getOptionsEImg());
				examinfo.setOptionsEText(wp.getOptionsEText());
				examinfo.setOptionsFImg(wp.getOptionsFImg());
				examinfo.setOptionsFText(wp.getOptionsFText());
			}
			if(et!=null){
				examinfo.setExamTypeId(et.getTypeName());
			}
		}
		QueryResultObject qObject = new QueryResultObject();
		List items = new ArrayList();
		items.add(examinfo);
		qObject.setItems(items);

    	return qObject;
    }


	@RequestMapping("/")
    public @ItemResponseBody QueryResultObject query(@QueryRequestParam("params") RequestCondition queryCondition){
	    QueryResultObject queryResult = examinfoBizc.query(queryCondition);
        List<Examinfo> lit=queryResult.getItems();
        List<Examinfo> items =new ArrayList<Examinfo>();
        for (int i = 0; i < lit.size(); i++) {
        	Examinfo sExaminfo=lit.get(i);
        	ExamType et = examtypeBizc.getExamtype(Integer.valueOf(sExaminfo.getExamTypeId()));
        	sExaminfo.setExamTypeId(et.getTypeName());
        	items.add(sExaminfo);
        	sExaminfo=new Examinfo();
		}
        queryResult.setItems(items);
	    return queryResult;
    }


	
}
