package com.sgcc.exam.wxImages;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sgcc.uap.rest.annotation.ItemResponseBody;
import com.sgcc.uap.rest.annotation.VoidResponseBody;
import java.io.Serializable;
import org.springframework.http.server.ServletServerHttpRequest;
import com.sgcc.exam.wxImages.bizc.IWxImageConfBizc;
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
import com.sgcc.exam.wxImages.po.WxImageConf;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import com.sgcc.uap.bizc.sysbizc.datadictionary.IDataDictionaryBizC;


@Controller
@RequestMapping("/wxImageConf")
public class WxImageConfController {

	@Resource
	private IWxImageConfBizc wximageconfBizc;
	
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
		datas = metadataService.getPropertyMeta(this.getClass(), "com.sgcc.exam.wxImages.po.WxImageConf", filterPropertys);
		return datas;
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ItemResponseBody List<WxImageConf> save(HttpServletRequest request_){
		try {
			//获取servlet API
			ServletServerHttpRequest servlet = new BodyReaderRequestWrapper(request_);
	        //将模型转换为java对象
			WxImageConf[] wximageconfs = coverter.converter(new WxImageConf[0], servlet);
		    List<Map<String,Object>> changedProperies = coverter.converter(new ArrayList<Map<String,Object>>(), servlet);
	        List<WxImageConf> voList = new ArrayList<WxImageConf>();
	        //对所有属性进行后端校验
			validateService.validateWithException(WxImageConf.class, changedProperies);
			//遍历表单数据, 如果当前数据在数据库里存在, 则做修改, 否则做新增处理
			for (int i = 0; i < wximageconfs.length; i++) {
				WxImageConf wximageconf= wximageconfs[i];
				Serializable pkValue = wximageconf.getId();
				Map<String,Object> changedProperty = coverter.flatHandle(WxImageConf.class,changedProperies.get(i));
				if (null != pkValue) {
					WxImageConf old = wximageconfBizc.get(pkValue);

	 				BeanUtils.populate(old, changedProperty);
	 				
	                wximageconfBizc.update(old, pkValue);
					voList.add(wximageconf);
	
				}else{
					BeanUtils.populate(wximageconf, changedProperty);
					wximageconfBizc.add(wximageconf);
					voList.add(wximageconf);
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
			wximageconfBizc.delete(java.lang.Integer.valueOf(id));
		}
		return null;
	}

	@RequestMapping("/{id}")
    public @ItemResponseBody QueryResultObject get(@PathVariable String id) {
		WxImageConf wximageconf ;
		if("null".equals(id)){
			wximageconf = null;
		}else {
			wximageconf = wximageconfBizc.get(java.lang.Integer.valueOf(id));
		}
		QueryResultObject qObject = new QueryResultObject();
		List items = new ArrayList();
		items.add(wximageconf);
		qObject.setItems(items);

    	return qObject;
    }


	@RequestMapping("/")
    public @ItemResponseBody QueryResultObject query(@QueryRequestParam("params") RequestCondition queryCondition){
	    QueryResultObject queryResult = wximageconfBizc.query(queryCondition);

	    return queryResult;
    }


	
}
