package com.sgcc.exam.testJene;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sgcc.uap.rest.annotation.ItemResponseBody;
import com.sgcc.uap.rest.annotation.VoidResponseBody;
import java.io.Serializable;
import org.springframework.http.server.ServletServerHttpRequest;
import com.sgcc.uap.rest.annotation.attribute.ViewAttributeData;
import com.sgcc.uap.service.validator.ServiceValidatorBaseException;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.mdd.runtime.validate.IValidateService;
import javax.servlet.http.HttpServletRequest;
import com.sgcc.uap.mdd.runtime.base.validator.ValidateResult;
import java.net.URL;
import org.osgi.framework.FrameworkUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sgcc.uap.rest.annotation.ItemsRequestBody;
import com.sgcc.uap.rest.annotation.QueryRequestParam;
import org.osgi.framework.Bundle;
import com.sgcc.uap.rest.annotation.ColumnResponseBody;
import com.sgcc.exam.etype.bizc.IExamTypeBizc;
import com.sgcc.exam.etype.po.ExamType;
import com.sgcc.exam.testJene.bizc.IAutomaticRuleBizc;
import com.sgcc.uap.rest.annotation.IdRequestBody;
import org.springframework.web.client.RestClientException;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.annotation.ColumnRequestParam;
import com.sgcc.uap.mdd.runtime.utils.BeanUtils;
import com.sgcc.exam.testJene.po.AutomaticRule;
import com.sgcc.exam.testJene.po.ManualRule;
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
@RequestMapping("/automaticRule")
public class AutomaticRuleController {

	@Resource
	private IAutomaticRuleBizc automaticruleBizc;
	
	@Resource
	private IDataDictionaryBizC dataDictionaryBizC;
	@Resource
	private IExamTypeBizc examtypeBizc;
	@Resource
	private IMetadataService metadataService;
	@Resource
	private IValidateService validateService;
	@Resource
	private HttpMessageConverter coverter;
	@RequestMapping("/meta")
	public @ColumnResponseBody List<ViewAttributeData> getPropertyMeta(@ColumnRequestParam("params") String[] filterPropertys) throws Exception {
	
		List<ViewAttributeData> datas = null;
		datas = metadataService.getPropertyMeta(this.getClass(), "com.sgcc.exam.testJene.po.AutomaticRule", filterPropertys);
		return datas;
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ItemResponseBody List<AutomaticRule> save(HttpServletRequest request_){
		try {
			//获取servlet API
			ServletServerHttpRequest servlet = new BodyReaderRequestWrapper(request_);
	        //将模型转换为java对象
			AutomaticRule[] automaticrules = coverter.converter(new AutomaticRule[0], servlet);
		    List<Map<String,Object>> changedProperies = coverter.converter(new ArrayList<Map<String,Object>>(), servlet);
	        List<AutomaticRule> voList = new ArrayList<AutomaticRule>();
	        //对所有属性进行后端校验
			validateService.validateWithException(AutomaticRule.class, changedProperies);
			//遍历表单数据, 如果当前数据在数据库里存在, 则做修改, 否则做新增处理
			for (int i = 0; i < automaticrules.length; i++) {
				AutomaticRule automaticrule= automaticrules[i];
				Serializable pkValue = automaticrule.getAutomaticRuleId();
				Map<String,Object> changedProperty = coverter.flatHandle(AutomaticRule.class,changedProperies.get(i));
				if (null != pkValue) {
					AutomaticRule old = automaticruleBizc.get(pkValue);

	 				BeanUtils.populate(old, changedProperty);
	 				
	                automaticruleBizc.update(old, pkValue);
					voList.add(automaticrule);
	
				}else{
					BeanUtils.populate(automaticrule, changedProperty);
					automaticruleBizc.add(automaticrule);
					voList.add(automaticrule);
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
			automaticruleBizc.delete(java.lang.Integer.valueOf(id));
		}
		return null;
	}

	@RequestMapping("/{id}")
    public @ItemResponseBody QueryResultObject get(@PathVariable String id) {
		AutomaticRule automaticrule ;
		if("null".equals(id)){
			automaticrule = null;
		}else {
			automaticrule = automaticruleBizc.get(java.lang.Integer.valueOf(id));
		}
		QueryResultObject qObject = new QueryResultObject();
		List items = new ArrayList();
		items.add(automaticrule);
		qObject.setItems(items);

    	return qObject;
    }


	@RequestMapping("/")
    public @ItemResponseBody QueryResultObject query(@QueryRequestParam("params") RequestCondition queryCondition){
	    QueryResultObject queryResult = automaticruleBizc.query(queryCondition);

	    
//	    QueryResultObject queryResult = manualruleBizc.query(queryCondition);
	    List<AutomaticRule> lit=queryResult.getItems();
        List<AutomaticRule> items =new ArrayList<AutomaticRule>();
        for (int i = 0; i < lit.size(); i++) {
        	AutomaticRule mr=lit.get(i);
        	ExamType et = examtypeBizc.getExamtype(Integer.valueOf(mr.getExamTypeId()));
        	mr.setExamTypeId(et.getTypeName());
        	items.add(mr);
        	mr=new AutomaticRule();
		}
        queryResult.setItems(items);
	    
	    return queryResult;
    }


	
}
