package com.sgcc.exam.examInfo;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sgcc.exam.examInfo.bizc.IExaminfoBizc;
import com.sgcc.uap.rest.annotation.ItemResponseBody;
import com.sgcc.uap.rest.annotation.VoidResponseBody;
import java.io.Serializable;
import org.springframework.http.server.ServletServerHttpRequest;
import com.sgcc.uap.rest.annotation.attribute.ViewAttributeData;
import com.sgcc.uap.service.validator.ServiceValidatorBaseException;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.exam.examInfo.po.Examinfo;
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
					Examinfo old = examinfoBizc.get(pkValue);

	 				BeanUtils.populate(old, changedProperty);
	 				
	                examinfoBizc.update(old, pkValue);
					voList.add(examinfo);
	
				}else{
					BeanUtils.populate(examinfo, changedProperty);
					examinfoBizc.add(examinfo);
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
			examinfoBizc.delete(java.lang.Integer.valueOf(id));
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

	    return queryResult;
    }


	
}
