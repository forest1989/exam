package com.sgcc.exam.api;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sgcc.exam.api.po.Area;
import com.sgcc.exam.common.utils.WXUtil; 
import com.sgcc.exam.rguser.bizc.IMUserBizc;
import com.sgcc.exam.rguser.po.MUser;
import com.sgcc.uap.rest.annotation.ItemResponseBody;
import com.sgcc.uap.rest.annotation.VoidResponseBody;

import java.io.IOException;
import java.io.Serializable;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.mapping.Array;
import org.springframework.http.server.ServletServerHttpRequest;
import com.sgcc.uap.rest.annotation.attribute.ViewAttributeData;
import com.sgcc.uap.service.validator.ServiceValidatorBaseException;
import com.sgcc.uap.rest.support.QueryResultObject;
import com.sgcc.uap.mdd.runtime.validate.IValidateService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sgcc.exam.api.bizc.IAreaBizc;
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
import com.sgcc.uap.rest.support.WrappedResult;
import com.sgcc.uap.rest.utils.JsonUtils;
import com.sgcc.uap.mdd.runtime.utils.HttpMessageConverter;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import com.sgcc.uap.bizc.sysbizc.datadictionary.IDataDictionaryBizC;


@Controller
@RequestMapping("/area")
public class AreaController {

	@Resource
	private IAreaBizc areaBizc;
	@Resource
	private IMUserBizc iMUserBizc;
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
		datas = metadataService.getPropertyMeta(this.getClass(), "com.sgcc.exam.api.po.Area", filterPropertys);
		return datas;
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ItemResponseBody List<Area> save(HttpServletRequest request_){
		try {
			//获取servlet API
			ServletServerHttpRequest servlet = new BodyReaderRequestWrapper(request_);
	        //将模型转换为java对象
			Area[] areas = coverter.converter(new Area[0], servlet);
		    List<Map<String,Object>> changedProperies = coverter.converter(new ArrayList<Map<String,Object>>(), servlet);
	        List<Area> voList = new ArrayList<Area>();
	        //对所有属性进行后端校验
			validateService.validateWithException(Area.class, changedProperies);
			//遍历表单数据, 如果当前数据在数据库里存在, 则做修改, 否则做新增处理
			for (int i = 0; i < areas.length; i++) {
				Area area= areas[i];
				Serializable pkValue = area.getAreaId();
				Map<String,Object> changedProperty = coverter.flatHandle(Area.class,changedProperies.get(i));
				if (null != pkValue) {
					Area old = areaBizc.get(pkValue);

	 				BeanUtils.populate(old, changedProperty);
	 				
	                areaBizc.update(old, pkValue);
					voList.add(area);
	
				}else{
					BeanUtils.populate(area, changedProperty);
					areaBizc.add(area);
					voList.add(area);
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
			areaBizc.delete(java.lang.String.valueOf(id));
		}
		return null;
	}

	@RequestMapping("/{id}")
    public @ItemResponseBody QueryResultObject get(@PathVariable String id) {
		Area area ;
		if("null".equals(id)){
			area = null;
		}else {
			area = areaBizc.get(java.lang.String.valueOf(id));
		}
		QueryResultObject qObject = new QueryResultObject();
		List items = new ArrayList();
		items.add(area);
		qObject.setItems(items);
    	return qObject;
    }


	@RequestMapping("/")
    public @ItemResponseBody QueryResultObject query(@QueryRequestParam("params") RequestCondition queryCondition){
	    QueryResultObject queryResult = areaBizc.query(queryCondition);

	    return queryResult;
    }

//----------------------------------------
	//用户登录   code--用户code      user--用户信息
	@RequestMapping(value = "/userInfo", method = RequestMethod.POST)
	public @ResponseBody WrappedResult getCode(String code,String user){
		//判断参数是否满足条件
		if(code != null && !"".equals(code) && user!=null && !"".equals(user) ){
		    MUser muser = new MUser();
		    Integer userId = null;
		    String openid = "";
			ObjectMapper mapper = new ObjectMapper();  
			 Map<String, String> userMap = new HashMap<String, String>(); 
		        try {  
		        	userMap = mapper.readValue(user, Map.class);  
		        } catch (Exception e) {
		            e.printStackTrace();  
		        } 
		        Map<String,String> openIdMap = new HashMap<String, String>();
		        	openIdMap = WXUtil.getUserMap(code);
		        //将用户信息Map手动转化为bean
		        if(userMap.containsKey("nickName")){//判断用户信息格式是否符合要求
		        	 muser.setGender(java.lang.String.valueOf(userMap.get("gender")).equals("1")?"m":"g");//性别
				     muser.setLoginDate(new Date());//最后登录时间
				     muser.setPhotoUrl(userMap.get("avatarUrl"));//头像路径
				     muser.setNickName(userMap.get("nickName"));//用户昵称
		        }else{
		        	return WrappedResult.failedWrappedResult("用户信息格式错误！");
		        }
		        if(openIdMap.containsKey("openid")){//判断获取openid是否成功
		        	//判断是否已存在用户
		        	if(openIdMap.get("openid")!=null &&!"".equals(openIdMap.get("openid"))){
				    	openid= java.lang.String.valueOf(openIdMap.get("openid"));
				    	userId=areaBizc.getUserId(openid);//查询用户ID
				    	muser.setOpenId(openid);//用户微信唯一标识
				    	if(userId==null){
				    		//不存在则添加 并返回userId
				    		iMUserBizc.add(muser);//添加用户
				    		userId=areaBizc.getUserId(openid);//获取新添加用户ID
				    		//return WrappedResult.successWrapedResult(userId);
				    	}else{
				    		//存在则更新用户信息
				    		Serializable pkValue = muser.getmUserId();
				    		muser.setmUserId(userId);
				    		iMUserBizc.update(muser,pkValue);//根据主键更新用户信息
				    	}
				    }else{
				    	return WrappedResult.failedWrappedResult("登录失败！");
				    }
		        }else{
		        	return WrappedResult.failedWrappedResult("微信请求失败！");
		        }
		    	return WrappedResult.successWrapedResult(userId);
		}
		return WrappedResult.failedWrappedResult("登录失败！");
	}
	//获取试卷列表    GET请求
	@RequestMapping(value = "/paper", method = RequestMethod.GET)
	public  @ResponseBody WrappedResult getPaper(){ 
		return WrappedResult.successWrapedResult(areaBizc.getPaper());
	}
	
	// 获取指定试卷   testPaperId--试卷ID    testPaperType--书卷生成规则
	@RequestMapping(value = "/ListPaper", method = RequestMethod.POST)
	public  @ResponseBody WrappedResult getListPaper(String testPaperId , String testPaperType){ 
		//根据试卷ID 及生成规则  获取对应试题类型ID  和试题道数（生成规则为自动时）  或 试题Id集合（生成规则为手动时）
		List<Map<String , Object>> list = areaBizc.getexamTypeId(testPaperId,testPaperType);
		
		List<Map<String , Object>> listTwo = new ArrayList<Map<String,Object>>();
		 if(list!=null && list.size() > 0){
			 Map<String , Object> map = list.get(0);
			 
			 	if(map!=null && map.size()>0){
			 		//传入生成规则 及 返回的map  根据生成规则 获取map中指定key的值 获取随机生成的试题   或者指定试题集合的试题
			 		List<Map<String , Object>> listPaper = areaBizc.getListPaper(map,testPaperType);
			 		// 返回前端前 转json前 格式改造开始---------------
			 		List<Map<String , Object>> listM = new ArrayList<Map<String,Object>>();
			 		List<Map<String , Object>> listMs = new ArrayList<Map<String,Object>>();
			 		for(Map<String , Object> maps:listPaper){
			 			if(maps.get("aimg")!=null || maps.get("atext")!=null){
			 				Map<String , Object > m = new HashMap<String, Object>();
			 				m.put("options", "A");
				 			m.put("aimg",maps.get("aimg")==null?"":maps.get("aimg"));
				 			m.put("atext",maps.get("atext")==null?"":maps.get("atext"));
				 			listM.add(m);
			 			}
			 			
			 			if(maps.get("bimg")!=null || maps.get("btext")!=null){
			 				Map<String , Object > m = new HashMap<String, Object>();
			 				m.put("options", "B");
			 				m.put("bimg",maps.get("bimg")==null?"":maps.get("bimg"));
			 				m.put("btext",maps.get("btext")==null?"":maps.get("btext"));
			 				listM.add(m);
			 			}
			 			
			 			if(maps.get("cimg")!=null || maps.get("ctext")!=null){
			 				Map<String , Object > m = new HashMap<String, Object>();
			 				m.put("options", "C");
			 				m.put("cimg",maps.get("cimg")==null?"":maps.get("cimg"));
			 				m.put("ctext",maps.get("ctext")==null?"":maps.get("ctext"));
			 				listM.add(m);
			 			}
			 			
			 			if(maps.get("dimg")!=null || maps.get("dtext")!=null){
			 				Map<String , Object > m = new HashMap<String, Object>();
			 				m.put("options", "D");
			 				m.put("dimg",maps.get("dimg")==null?"":maps.get("dimg"));
			 				m.put("dtext",maps.get("dtext")==null?"":maps.get("dtext"));
			 				listM.add(m);
			 			}
			 			
			 			if(maps.get("eimg")!=null || maps.get("etext")!=null){
			 				Map<String , Object > m = new HashMap<String, Object>();
			 				m.put("options", "E");
			 				m.put("eimg",maps.get("eimg")==null?"":maps.get("eimg"));
			 				m.put("etext",maps.get("etext")==null?"":maps.get("etext"));
			 				listM.add(m);
			 			}
			 			
			 			if(maps.get("fimg")!=null || maps.get("ftext")!=null){
			 				Map<String , Object > m = new HashMap<String, Object>();
			 				m.put("options", "F");
			 				m.put("fimg",maps.get("fimg")==null?"":maps.get("fimg"));
			 				m.put("ftext",maps.get("ftext")==null?"":maps.get("ftext"));
			 				listM.add(m);
			 			}
			 			//删除原maps 中的指定Key及其值
			 			Iterator<String> iterator = maps.keySet().iterator();// map中key（键）的迭代器对象
		 		        while (iterator.hasNext()){// 循环取键值进行判断
		 		            String key = iterator.next();// 键
		 		            if(key.startsWith("aimg") || key.startsWith("atext") || key.startsWith("bimg") || key.startsWith("btext") 
		 		            		|| key.startsWith("cimg") || key.startsWith("ctext") || key.startsWith("dimg") || key.startsWith("dtext") 
		 		            		|| key.startsWith("eimg") || key.startsWith("etext") || key.startsWith("fimg") || key.startsWith("ftext")){
		 		                iterator.remove();
		 		            }
		 		        }
			 			maps.put("daan", listM);
			 			listMs.add(maps);
			 		}
			 	// 返回前端前 转json前 格式改造开始---------------
			 		//封装转换格式后的返回值为json 返回前端
			 		return WrappedResult.successWrapedResult(listPaper);
			 	}
		 }
		return WrappedResult.failedWrappedResult("试卷未准备好！");
	}
	
	/*//保存自动生成的试卷规则
	@RequestMapping(value = "/saveAutoPaperConfig", method = RequestMethod.POST)
	public  @ResponseBody WrappedResult saveAutoPaperConfig(
			HttpServletRequest request,HttpServletResponse response,
			String paperName , String longTime, String listStr,
			String creater){
		response.setHeader("Access-Control-Allow-Origin",request.getHeader("origin"));
		response.setHeader("Access-Control-Allow-Methods","POST,GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age","3600");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,Cache-Control,Pragma,Content-Type,Token");
		response.setHeader("Access-Control-Allow-Credentials","true");
		WrappedResult result = new WrappedResult();
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		try {
			list = (List<Map<String, String>>) JsonUtils.json2Object(listStr, List.class);
			
		} catch (Exception e1) {
			e1.printStackTrace();
			result.setSuccessful(false);
			result.setResultHint("保存异常");
			return result;
		}
		
		
		return result;
	}*/
	
	
}
