package com.sgcc.exam.testpaper;
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
import org.springframework.web.bind.annotation.RequestMapping;
import com.sgcc.uap.rest.annotation.QueryRequestParam;
import com.sgcc.uap.rest.annotation.ColumnResponseBody;
import com.sgcc.uap.rest.annotation.IdRequestBody;
import org.springframework.web.client.RestClientException;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.rest.annotation.ColumnRequestParam;
import com.sgcc.exam.testpaper.bizc.IAPITestPaperBizc;
import com.sgcc.exam.testpaper.po.APITestPaper;
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
@RequestMapping("/apiTestPaper")
public class APITestPaperController {

	@Resource
	private IAPITestPaperBizc apitestpaperBizc;
	
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
		System.out.println("testPaper:meta");
		List<ViewAttributeData> datas = null;
		datas = metadataService.getPropertyMeta(this.getClass(), "com.sgcc.exam.testpaper.po.TestPaper", filterPropertys);
		return datas;
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ItemResponseBody List<APITestPaper> save(HttpServletRequest request_){
		System.out.println("testPaper:save");
		try {
			//获取servlet API
			ServletServerHttpRequest servlet = new BodyReaderRequestWrapper(request_);
	        //将模型转换为java对象
			APITestPaper[] testpapers = coverter.converter(new APITestPaper[0], servlet);
		    List<Map<String,Object>> changedProperies = coverter.converter(new ArrayList<Map<String,Object>>(), servlet);
	        List<APITestPaper> voList = new ArrayList<APITestPaper>();
	        //对所有属性进行后端校验
			validateService.validateWithException(APITestPaper.class, changedProperies);
			//遍历表单数据, 如果当前数据在数据库里存在, 则做修改, 否则做新增处理
			for (int i = 0; i < testpapers.length; i++) {
				APITestPaper testpaper= testpapers[i];
				Serializable pkValue = testpaper.getTestPaperId();
				Map<String,Object> changedProperty = coverter.flatHandle(APITestPaper.class,changedProperies.get(i));
				if (null != pkValue) {
					APITestPaper old = apitestpaperBizc.get(pkValue);

	 				BeanUtils.populate(old, changedProperty);
	 				
	                apitestpaperBizc.update(old, pkValue);
					voList.add(testpaper);
	
				}else{
					BeanUtils.populate(testpaper, changedProperty);
					apitestpaperBizc.add(testpaper);
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
		System.out.println("testPaper:delete");
		String[] ids = idObject.getIds();
		for (String id : ids) {
			apitestpaperBizc.delete(java.lang.Integer.valueOf(id));
		}
		return null;
	}

	@RequestMapping("/{id}")
    public @ItemResponseBody QueryResultObject get(@PathVariable String id) {
		System.out.println("testPaper:id");
		APITestPaper testpaper ;
		if("null".equals(id)){
			testpaper = null;
		}else {
			testpaper = apitestpaperBizc.get(java.lang.Integer.valueOf(id));
		}
		QueryResultObject qObject = new QueryResultObject();
		List items = new ArrayList();
		items.add(testpaper);
		qObject.setItems(items);

    	return qObject;
    }


	@RequestMapping("/")
    public @ItemResponseBody QueryResultObject query(@QueryRequestParam("params") RequestCondition queryCondition){
		System.out.println("testPaper:query");
		QueryResultObject queryResult = apitestpaperBizc.query(queryCondition);

	    return queryResult;
    }


	
}
