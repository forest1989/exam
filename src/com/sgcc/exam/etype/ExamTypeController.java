package com.sgcc.exam.etype;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestClientException;

import com.sgcc.exam.etype.bizc.IExamTypeBizc;
import com.sgcc.exam.etype.po.ExamType;
import com.sgcc.uap.bizc.sysbizc.datadictionary.IDataDictionaryBizC;
import com.sgcc.uap.mdd.runtime.meta.IMetadataService;
import com.sgcc.uap.mdd.runtime.utils.BeanUtils;
import com.sgcc.uap.mdd.runtime.utils.BodyReaderRequestWrapper;
import com.sgcc.uap.mdd.runtime.utils.HttpMessageConverter;
import com.sgcc.uap.mdd.runtime.validate.IValidateService;
import com.sgcc.uap.rest.annotation.ColumnRequestParam;
import com.sgcc.uap.rest.annotation.ColumnResponseBody;
import com.sgcc.uap.rest.annotation.IdRequestBody;
import com.sgcc.uap.rest.annotation.ItemRequestParam;
import com.sgcc.uap.rest.annotation.ItemResponseBody;
import com.sgcc.uap.rest.annotation.QueryRequestParam;
import com.sgcc.uap.rest.annotation.TreeResponseBody;
import com.sgcc.uap.rest.annotation.VoidResponseBody;
import com.sgcc.uap.rest.annotation.attribute.ViewAttributeData;
import com.sgcc.uap.rest.support.DicItems;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.support.TreeNode;
import com.sgcc.uap.service.validator.ServiceValidatorBaseException;


@Controller
@RequestMapping("/examType")
public class ExamTypeController {

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
		datas = metadataService.getPropertyMeta(this.getClass(), "com.sgcc.exam.etype.po.ExamType", filterPropertys);
		return datas;
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ItemResponseBody List<ExamType> save(HttpServletRequest request_){
		try {
			//获取servlet API
			ServletServerHttpRequest servlet = new BodyReaderRequestWrapper(request_);
	        //将模型转换为java对象
			ExamType[] examtypes = coverter.converter(new ExamType[0], servlet);
		    List<Map<String,Object>> changedProperies = coverter.converter(new ArrayList<Map<String,Object>>(), servlet);
	        List<ExamType> voList = new ArrayList<ExamType>();
	        //对所有属性进行后端校验
			validateService.validateWithException(ExamType.class, changedProperies);
			//遍历表单数据, 如果当前数据在数据库里存在, 则做修改, 否则做新增处理
			for (int i = 0; i < examtypes.length; i++) {
				ExamType examtype= examtypes[i];
				Serializable pkValue = examtype.getExamTypeId();
				Map<String,Object> changedProperty = coverter.flatHandle(ExamType.class,changedProperies.get(i));
				if (null != pkValue) {
					ExamType old = examtypeBizc.get(pkValue);

	 				BeanUtils.populate(old, changedProperty);
	 				
	                examtypeBizc.update(old, pkValue);
					voList.add(examtype);
	
				}else{
					BeanUtils.populate(examtype, changedProperty);
					examtypeBizc.add(examtype);
					voList.add(examtype);
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
			examtypeBizc.delete(Integer.valueOf(id));
		}
		return null;
	}

	@RequestMapping(value = "/deleteById", method = RequestMethod.POST)
	public @VoidResponseBody Object deleteById(HttpServletRequest request_){
		String id = request_.getParameter("id");
		examtypeBizc.delete(Integer.valueOf(id));
		return null;
	}
	
	@RequestMapping("/{id}")
    public @ItemResponseBody QueryResultObject get(@PathVariable String id) {
		ExamType examtype ;
		if("null".equals(id)){
			examtype = null;
		}else {
			examtype = examtypeBizc.get(Integer.valueOf(id));
		}
		QueryResultObject qObject = new QueryResultObject();
		List items = new ArrayList();
		items.add(examtype);
		qObject.setItems(items);

    	return qObject.addDicItems(wrapDictList());
    }


	private List<DicItems> wrapDictList() {
		List<DicItems> dicts = new ArrayList<DicItems>();
		DicItems dictExamTypeParentId = new DicItems();
		dictExamTypeParentId.setName("parentId");
		dictExamTypeParentId.setValues(dataDictionaryBizC.translateFromDB("com.sgcc.exam.etype.po.ExamType ExamType", "value", "text", "examTypeId", "typeName",""));

		dicts.add(dictExamTypeParentId);
		return dicts;
	}

	
	@RequestMapping("/")
    public @ItemResponseBody QueryResultObject query(@QueryRequestParam("params") RequestCondition queryCondition, 
    		HttpServletRequest request){
		String etId = request.getParameter("etId");
	    QueryResultObject queryResult = examtypeBizc.query(queryCondition);
	    return queryResult.addDicItems(wrapDictList());
    }

}
