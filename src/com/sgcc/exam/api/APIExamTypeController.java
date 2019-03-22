package com.sgcc.exam.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sgcc.exam.api.bizc.IAPIExamTypeBizc;
import com.sgcc.exam.api.po.APIExamType;
import com.sgcc.exam.api.po.Option;
import com.sgcc.uap.rest.annotation.ItemResponseBody;
import com.sgcc.uap.rest.support.WrappedResult;

@Controller
@RequestMapping("/apiExamInfoType")
public class APIExamTypeController {
	@Resource
	private IAPIExamTypeBizc apiExamInfoTypeBizc;
	
	
	/**
	 * 查询前三个专项训练信息，父级类型
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	public @ResponseBody WrappedResult getParents(HttpServletRequest request,HttpServletResponse response){
		WrappedResult result = new WrappedResult();
		response.setHeader("Access-Control-Allow-Origin",request.getHeader("origin"));
		response.setHeader("Access-Control-Allow-Methods","POST,GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age","3600");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,Cache-Control,Pragma,Content-Type,Token");
		response.setHeader("Access-Control-Allow-Credentials","true");
		List<APIExamType> list = null;
		try{
			  list = apiExamInfoTypeBizc.getParents();
		}catch(Exception e){
			result.setSuccessful(false);
			result.setResultHint("查询异常");
			e.printStackTrace();
			return result;
		}
		result.setSuccessful(true);
		result.setResultHint("操作成功");
		result.setResultValue(list);
		return result;
	}
	
	/**
	 * 根据父级id,查找其所属的子试卷类型
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public @ResponseBody WrappedResult getSons(HttpServletRequest request,HttpServletResponse response,@PathVariable String id){
		response.setHeader("Access-Control-Allow-Origin",request.getHeader("origin"));
		response.setHeader("Access-Control-Allow-Methods","POST,GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age","3600");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,Cache-Control,Pragma,Content-Type,Token");
		response.setHeader("Access-Control-Allow-Credentials","true");
		WrappedResult result = new WrappedResult();
		List<APIExamType> list = null;
		try{
			  list = apiExamInfoTypeBizc.getSons(id);
		}catch(Exception e){
			result.setSuccessful(false);
			result.setResultHint("查询异常");
			e.printStackTrace();
			return result;
		}
		result.setSuccessful(true);
		result.setResultHint("操作成功");
		result.setResultValue(list);
		return result;
	}
	
	/**
	 * 随机刷题，返回随机的20条
	 * @param size
	 * @return
	 */
	@RequestMapping(value="/getExamInfos",method=RequestMethod.POST)
	public @ResponseBody WrappedResult getExamInfos( String size){
		List<Map<String , Object>> listMs = new ArrayList<Map<String,Object>>();
		WrappedResult result = new WrappedResult();
		List<Map<String,Object>> list = null;
		//默认20条
		if(null == size || "".equals(size)) {
			size="20";
		}
		try{
			  list = apiExamInfoTypeBizc.getExamInfos(size);
		}catch(Exception e){
			result.setSuccessful(false);
			result.setResultHint("查询异常");
			e.printStackTrace();
			return result;
		}
		result.setSuccessful(true);
		result.setResultHint("操作成功");
		result.setResultValue(resetList(list));
		return result;
	}
	
	
	
	private List<Map<String,Object>>  resetList(List<Map<String,Object>> list){
		//String str="http://192.168.1.7:9000/ise/mx/servlets/dataFileUpload?option=download&tableName=EXAMINFO&pkVal=%s&colName=EXAM_CONTENT_IMG&fileName=%s&uploadMode=file&filePath=examContentImg";
		if(null == list || list.size() ==0){
			return new ArrayList<Map<String,Object>>();
		}
		List<Map<String,Object>> destList =new ArrayList();
		List<Option> optionList =new ArrayList();
		int len = list.size();
		Option option = new Option();
		HashMap<String,Object> map = new HashMap();
		for(int i=0;i<len;i++){
			Map<String,Object> temp = list.get(i);
			map = new HashMap();
			map.put("examid", temp.get("examid")==null?"":temp.get("examid"));
			map.put("readcode", temp.get("readcode")==null?"":temp.get("readcode"));
			map.put("readimg", temp.get("readimg")==null?"":temp.get("readimg"));
			map.put("readtext", temp.get("readtext")==null?"":temp.get("readtext"));
			map.put("contentimg", temp.get("contentimg")==null?"":temp.get("contentimg"));
			map.put("contenttext", temp.get("contenttext")==null?"":temp.get("contenttext"));
			map.put("examsubject", temp.get("examsubject")==null?"":temp.get("examsubject"));
			map.put("examgrades", temp.get("examgrades")==null?"":temp.get("examgrades"));
			map.put("exammark", temp.get("exammark")==null?"":temp.get("exammark"));
			optionList = new ArrayList();
			/**
			 * 
			 */
			if(temp.get("aimg") == null && temp.get("atext") == null ){
				
			}else{
				option = new Option();
				option.setImg(temp.get("aimg") == null ? "" :
					"http://192.168.1.7:9000/ise/mx/servlets/dataFileUpload?option=download&tableName=EXAMINFO&pkVal="+temp.get("examid").toString()+"&colName=EXAM_CONTENT_IMG&fileName="+temp.get("aimg")+"&uploadMode=file&filePath=examContentImg"	);
				option.setText(temp.get("atext") == null ? "" : temp.get("atext").toString());
				option.setOption("A");
				optionList.add(option);
			}
			
			if(temp.get("bimg") == null && temp.get("btext") == null ){
				
			}else{
				option = new Option();
				option.setImg(temp.get("bimg") == null ? "":
					"http://192.168.1.7:9000/ise/mx/servlets/dataFileUpload?option=download&tableName=EXAMINFO&pkVal="+temp.get("examid").toString()+"&colName=EXAM_CONTENT_IMG&fileName="+temp.get("bimg")+"&uploadMode=file&filePath=examContentImg"
					);
				option.setText(temp.get("btext") == null ? "": temp.get("btext").toString());
				option.setOption("B");
				optionList.add(option);
			}
			
			if(temp.get("cimg") == null && temp.get("ctext") == null ){
				
			}else{
				option = new Option();
				option.setImg(temp.get("cimg") == null ? "":
					"http://192.168.1.7:9000/ise/mx/servlets/dataFileUpload?option=download&tableName=EXAMINFO&pkVal="+temp.get("examid").toString()+"&colName=EXAM_CONTENT_IMG&fileName="+temp.get("cimg")+"&uploadMode=file&filePath=examContentImg");
				option.setText(temp.get("ctext") == null ? "": temp.get("ctext").toString());
				option.setOption("C");
				optionList.add(option);
			}
			
			if(temp.get("dimg") == null && temp.get("dtext") == null ){
				
			}else{
				
				option = new Option();
				option.setImg(temp.get("dimg") == null ? "":"http://192.168.1.7:9000/ise/mx/servlets/dataFileUpload?option=download&tableName=EXAMINFO&pkVal="+temp.get("examid").toString()+"&colName=EXAM_CONTENT_IMG&fileName="+temp.get("dimg")+"&uploadMode=file&filePath=examContentImg"	);
				option.setText(temp.get("dtext") == null ? "": temp.get("dtext").toString());
				option.setOption("D");
				optionList.add(option);
			}
			
			if(temp.get("eimg") == null && temp.get("etext") == null ){
				
			}else{
				option = new Option();
				option.setImg(temp.get("eimg") == null ? "":   "http://192.168.1.7:9000/ise/mx/servlets/dataFileUpload?option=download&tableName=EXAMINFO&pkVal="+temp.get("examid").toString()+"&colName=EXAM_CONTENT_IMG&fileName="+temp.get("eimg")+"&uploadMode=file&filePath=examContentImg"	);
				option.setText(temp.get("etext") == null ? "": temp.get("etext").toString());
				option.setOption("E");
				optionList.add(option);
			}
			
			if(temp.get("fimg") == null && temp.get("ftext") == null ){
				
			}else{
				option = new Option();
				option.setImg(temp.get("fimg") == null ? "":"http://192.168.1.7:9000/ise/mx/servlets/dataFileUpload?option=download&tableName=EXAMINFO&pkVal="+temp.get("examid").toString()+"&colName=EXAM_CONTENT_IMG&fileName="+temp.get("fimg")+"&uploadMode=file&filePath=examContentImg"	);
				option.setText(temp.get("etext") == null ? "": temp.get("ftext").toString());
				option.setOption("F");
				optionList.add(option);
			}
			 
			map.put("options", optionList);
			destList.add(map);
		}
		return destList;
	}
	
	/**
	 * 根据试题分类id查询具体的题目
	 */
	@RequestMapping(value="/getExamTypeInfos",method=RequestMethod.POST)
	public @ResponseBody WrappedResult getExamTypeInfos( String id, String size){

		WrappedResult result = new WrappedResult();
		List<Map<String,Object>> list = null;
		//默认20条
		if(null == size || "".equals(size)) {
			size="20";
		}
		if(null == id || "".equals(id)){
			result.setSuccessful(false);
			result.setResultHint("参数错误，请检查入参!");
			return result;
		}
		try{
			list = apiExamInfoTypeBizc.getExamTypeInfos(id,size);
		}catch(Exception e){
			result.setSuccessful(false);
			result.setResultHint("查询异常");
			e.printStackTrace();
			return result;
		}
		result.setSuccessful(true);
		result.setResultHint("操作成功");
		result.setResultValue(list);
		return result;
	}
	
	
}
