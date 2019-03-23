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
import com.sgcc.uap.rest.annotation.IdRequestBody;
import org.springframework.web.client.RestClientException;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.annotation.ColumnRequestParam;
import com.sgcc.uap.mdd.runtime.utils.BeanUtils;
import com.sgcc.exam.testJene.po.TestPaper;
import com.sgcc.uap.mdd.runtime.meta.IMetadataService;
import java.util.*;
import com.sgcc.uap.mdd.runtime.utils.BodyReaderRequestWrapper;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.mdd.runtime.utils.HttpMessageConverter;
import javax.annotation.Resource;
import com.sgcc.exam.testJene.bizc.ITestPaperBizc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import com.sgcc.uap.bizc.sysbizc.datadictionary.IDataDictionaryBizC;


@Controller
@RequestMapping("/testPaper2")
public class TestPaperController2 {

	@Resource
	private ITestPaperBizc testpaperBizc;
	
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
		datas = metadataService.getPropertyMeta(this.getClass(), "com.sgcc.exam.testJene.po.TestPaper", filterPropertys);
		return datas;
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ItemResponseBody List<TestPaper> save(HttpServletRequest request_){
		try {
			//获取servlet API
			ServletServerHttpRequest servlet = new BodyReaderRequestWrapper(request_);
	        //将模型转换为java对象
			TestPaper[] testpapers = coverter.converter(new TestPaper[0], servlet);
		    List<Map<String,Object>> changedProperies = coverter.converter(new ArrayList<Map<String,Object>>(), servlet);
	        List<TestPaper> voList = new ArrayList<TestPaper>();
	        //对所有属性进行后端校验
			validateService.validateWithException(TestPaper.class, changedProperies);
			//遍历表单数据, 如果当前数据在数据库里存在, 则做修改, 否则做新增处理
			for (int i = 0; i < testpapers.length; i++) {
				TestPaper testpaper= testpapers[i];
				Serializable pkValue = testpaper.getTestPaperId();
				Map<String,Object> changedProperty = coverter.flatHandle(TestPaper.class,changedProperies.get(i));
				if (null != pkValue) {
					TestPaper old = testpaperBizc.get(pkValue);

	 				BeanUtils.populate(old, changedProperty);
	 				
	                testpaperBizc.update(old, pkValue);
					voList.add(testpaper);
	
				}else{
					BeanUtils.populate(testpaper, changedProperty);
					testpaperBizc.add(testpaper);
					voList.add(testpaper);
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
			testpaperBizc.delete(java.lang.Integer.valueOf(id));
		}
		return null;
	}

	@RequestMapping("/{id}")
    public @ItemResponseBody QueryResultObject get(@PathVariable String id) {
		TestPaper testpaper ;
		if("null".equals(id)){
			testpaper = null;
		}else {
			testpaper = testpaperBizc.get(java.lang.Integer.valueOf(id));
		}
		QueryResultObject qObject = new QueryResultObject();
		List items = new ArrayList();
		items.add(testpaper);
		qObject.setItems(items);

    	return qObject;
    }


	@RequestMapping("/")
    public @ItemResponseBody QueryResultObject query(@QueryRequestParam("params") RequestCondition queryCondition){
	    QueryResultObject queryResult = testpaperBizc.query(queryCondition);
	    List<TestPaper> lit=queryResult.getItems();
        List<TestPaper> items =new ArrayList<TestPaper>();
        for (int i = 0; i < lit.size(); i++) {
        	TestPaper mr=lit.get(i);
        	if(mr.getTestPaperType().equals("2")){
        		items.add(mr);
        	}
        	mr=new TestPaper();
		}
        queryResult.setItemCount(items.size());
        queryResult.setItems(items);
	    return queryResult;
    }


	
}
