package com.sgcc.exam.api;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sgcc.exam.api.bizc.IAPIExamTypeBizc;
import com.sgcc.exam.api.bizc.IAPIHistoryBizc;
import com.sgcc.exam.api.bizc.IAPIPaperHistoryBizc;
import com.sgcc.exam.api.po.APIAnswerHistory;
import com.sgcc.exam.api.po.APIPaperHistory;
import com.sgcc.exam.api.po.Option;
import com.sgcc.exam.common.utils.DateUtils;
import com.sgcc.uap.rest.support.WrappedResult;
import com.sgcc.uap.rest.utils.JsonUtils;

 
@Controller
@RequestMapping("/answers")
public class APIAnswerHistoryController {
	
	@Resource
	private IAPIExamTypeBizc apiExamInfoTypeBizc;
	
	@Resource 
	private IAPIHistoryBizc historyBizc;
	
	@Resource
	private IAPIPaperHistoryBizc paperBizc;
	
	/**
	 * 历史错题类别及错题总数
	 */
	@RequestMapping(value="/getErrorExamTypeInfo" ,method = RequestMethod.GET)
	public @ResponseBody WrappedResult getErrorExamTypeInfo(HttpServletRequest request,HttpServletResponse response, String userId){
		WrappedResult result = new WrappedResult();
		
		return result;
	}
	/**
	 * 页面请求试卷详情，用于在线考试
	 */
	@RequestMapping(value="/getTheExamInfo" ,method = RequestMethod.GET)
	public @ResponseBody WrappedResult getTheExamInfo(HttpServletRequest request,HttpServletResponse response, String paperId){
		response.setHeader("Access-Control-Allow-Origin",request.getHeader("origin"));
		response.setHeader("Access-Control-Allow-Methods","POST,GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age","3600");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,Cache-Control,Pragma,Content-Type,Token");
		response.setHeader("Access-Control-Allow-Credentials","true");
		WrappedResult result = new WrappedResult();
		//根据试卷id查询试卷是自动生成还是手动生成
		String AutoType = paperBizc.getPaperType(Integer.valueOf(paperId));
		//根据自动(1)还是手动(2)，进行不同的查询，最终返回一个待json转换的list
		//把所有的examId查询出
		
		List<Map<String,Object>> templist = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try{
			if("1".equals(AutoType)){//自动
				templist = paperBizc.getAutoExamInfos(Integer.valueOf(paperId));
			}else{//手动
				templist = paperBizc.getHandExamInfos(Integer.valueOf(paperId));
			}
			list = resetList(templist);
			result.setSuccessful(true);
			result.setResultValue(list);
			result.setResultHint("试卷调取成功");
			return result;
		}catch(Exception e){
			e.printStackTrace();
			result.setSuccessful(false);
			result.setResultHint("试卷调取失败");
			return result;
		}
	}
	/**
	 * 查询题库信息
	 */
	@RequestMapping(value="/getExamInfoList" ,method = RequestMethod.GET)
	public @ResponseBody WrappedResult getExamInfoList(HttpServletRequest request,HttpServletResponse response, String typeId,String grade,String subject,
			String pageNum,String pageSize){
		
		response.setHeader("Access-Control-Allow-Origin",request.getHeader("origin"));
		response.setHeader("Access-Control-Allow-Methods","POST,GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age","3600");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,Cache-Control,Pragma,Content-Type,Token");
		response.setHeader("Access-Control-Allow-Credentials","true");
		WrappedResult result = new WrappedResult();
		try {
			List<Map<String,Object>> list =historyBizc.getExamInfoList(typeId,grade,subject,pageNum,pageSize);
			result.setResultValue(list);
			result.setSuccessful(true);
			result.setResultHint("查询成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setResultHint("查询异常");
			result.setSuccessful(false);
			return result;
		}
		return result;
	}

	
	/**
	 * 获取试卷列表
	 */
	@RequestMapping(value="/getPaperList" ,method = RequestMethod.GET)
	public @ResponseBody WrappedResult getPaperList(HttpServletRequest request,HttpServletResponse response, String paperName,String pageNum,String pageSize){
		WrappedResult result = new WrappedResult();
		response.setHeader("Access-Control-Allow-Origin",request.getHeader("origin"));
		response.setHeader("Access-Control-Allow-Methods","POST,GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age","3600");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,Cache-Control,Pragma,Content-Type,Token");
		response.setHeader("Access-Control-Allow-Credentials","true");
		try{
			List<Map<String,Object>> list  = new ArrayList<Map<String,Object>>();
			if(null == paperName || "".equals(paperName)){
				list = paperBizc.getPaperList((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize),Integer.valueOf(pageSize));

			}else{
				list = paperBizc.getPaperListByName(paperName,(Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize),Integer.valueOf(pageSize));

			}
			result.setResultValue(list);
			result.setResultHint("查询成功");
			result.setSuccessful(true);
			return result;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setResultHint("查询异常");
			result.setSuccessful(false);
			return result;
		}
	}
	
	/**
	 * 保存用户答题内容
	 */
	@RequestMapping(value="/addAnswerInfos" ,method = RequestMethod.POST)
	public @ResponseBody WrappedResult addAnswerInfos(  String userId,
			  String paperId,    String listStr){
		WrappedResult result = new WrappedResult();
		HashMap<String,Object> resultMap = new HashMap();
		//判断是否有试卷号，如果存在试卷号，则为考试题，否则为练习
		List<Map<String, String>> list = new ArrayList();
		try {
			list = (List<Map<String, String>>) JsonUtils.json2Object(listStr, List.class);
		} catch (JsonParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Map<String,String> hp = new HashMap();
		
		hp = list.get(0);
		 //考试题，存在试卷编号
		if(null != paperId && !"".equals(paperId)){
			resultMap = getScoreInfo( userId, paperId,  list) ;
			APIPaperHistory paper = new APIPaperHistory();
			paper.setDelFlag("0");
			paper.setCreateDate(new Date());
			paper.setTestPaperId(Integer.valueOf(paperId));
			paper.setmUserId(Integer.valueOf(userId));
			List<APIAnswerHistory> destList = (List<APIAnswerHistory>) resultMap.get("destList");
			Integer score = (Integer) resultMap.get("score");
			paper.setMark(score);
			try{ 
				hp.clear();
				historyBizc.addHistory(destList);
				paperBizc.add(paper);
				result.setResultHint("提交成功！");
				result.setSuccessful(true);
				hp.put("score", String.valueOf(score));
				result.setResultValue(hp);
			} catch (Exception e) {
				// TODO: handle exception
				result.setResultHint("网络异常，DB提交失败！");
				result.setSuccessful(false);
			}
		} else {
			//练习题，没有试卷编号
			resultMap = getScoreInfo( userId, null,  list) ;
			try{
				List<APIAnswerHistory> destList = (List<APIAnswerHistory>) resultMap.get("destList");
				historyBizc.addHistory(destList);
				result.setResultHint("提交成功！");
				result.setSuccessful(true);
			}catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
				result.setResultHint("网络异常，提交失败！");
				result.setSuccessful(false);
			}
		}
		return result;
	}
	
	//查询用户的答题历史记录
	@RequestMapping(value = "/getTestHistoryTitle",method = RequestMethod.GET)
	public @ResponseBody WrappedResult userAnswerHistoryTitle(String userId, String pageNum,String PageSize){
		//用户id，页数，页条数
		WrappedResult result = new WrappedResult();
		 
		try{
			List<Map<String,Object>> list = historyBizc.getTestHistoryTitle(Integer.valueOf(userId) , (Integer.valueOf(pageNum)-1)*Integer.valueOf(PageSize), Integer.valueOf(PageSize));
			result.setResultValue(list);
			result.setResultHint("请求成功！");
			result.setSuccessful(true);
			return result;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setResultHint("网络异常，请求失败！");
			result.setSuccessful(false);
			return result;
		}
	}
	//查询具体的历史练习题记录
	@RequestMapping(value = "/getTestHistory",method = RequestMethod.GET)
	public @ResponseBody WrappedResult userAnswerHistory(String userId, String createDate){
		//用户id，页数，页条数
		WrappedResult result = new WrappedResult();
		try{
			List<Map<String,Object>> hlist = historyBizc.getTestHistory(Integer.valueOf(userId) , createDate);
			//将examId拼接，用于在题库里查找对应的题目
			StringBuilder sb = new StringBuilder();
			int len = hlist.size();
			for(int i=0;i<len;i++){
				sb.append(hlist.get(i).get("examId"));
				if(i != len-1){
					sb.append(",");
				}
			}
			//查询题库里对应的内容
			List<Map<String,Object>> elist = apiExamInfoTypeBizc.getChooseExamInfos(sb.toString());
			List<Map<String,Object>> eelist = resetList(elist);
			List<Map<String,Object>> list = resetAnswerHistory(hlist,eelist);
			
			result.setResultValue(list);
			result.setResultHint("请求成功！");
			result.setSuccessful(true);
			return result;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setResultHint("网络异常，请求失败！");
			result.setSuccessful(false);
			return result;
		}
	}
	
	//查询具体的历史练习题记录
	@RequestMapping(value = "/getPaperHistory",method = RequestMethod.GET)
	public @ResponseBody WrappedResult userPaperHistory(String userId, String paperId){
		//用户id，页数，页条数
		WrappedResult result = new WrappedResult();
		try{
			List<Map<String,Object>> hlist = historyBizc.getPaperHistory(Integer.valueOf(userId) , Integer.valueOf(paperId));
			//将examId拼接，用于在题库里查找对应的题目
			StringBuilder sb = new StringBuilder();
			int len = hlist.size();
			for(int i=0;i<len;i++){
				sb.append(hlist.get(i).get("examId"));
				if(i != len-1){
					sb.append(",");
				}
			}
			//查询题库里对应的内容
			List<Map<String,Object>> elist = apiExamInfoTypeBizc.getChooseExamInfos(sb.toString());
			List<Map<String,Object>> eelist = resetList(elist);
			List<Map<String,Object>> list = resetAnswerHistory(hlist,eelist);
			
			result.setResultValue(list);
			result.setResultHint("请求成功！");
			result.setSuccessful(true);
			return result;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setResultHint("网络异常，请求失败！");
			result.setSuccessful(false);
			return result;
		}
	}

	//考试历史记录
	@RequestMapping(value = "/getPaperHistoryTitle",method = RequestMethod.GET)
	public @ResponseBody WrappedResult userPaperHistoryTitle(String userId, String pageNum,String PageSize){
		//用户id，页数，页条数
		WrappedResult result = new WrappedResult();
		 
		try{
			List<Map<String,Object>> list = paperBizc.getPaperHistoryTitle(Integer.valueOf(userId) , (Integer.valueOf(pageNum)-1)*Integer.valueOf(PageSize), Integer.valueOf(PageSize));
			result.setResultValue(list);
			result.setResultHint("请求成功！");
			result.setSuccessful(true);
			return result;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setResultHint("网络异常，请求失败！");
			result.setSuccessful(false);
			return result;
		}
	}
	//将题库内容和答题结果进行整合
	private List<Map<String, Object>> resetAnswerHistory(List<Map<String, Object>> hlist,
			List<Map<String, Object>> elist) {
		// TODO Auto-generated method stub
		int hlen = hlist.size();
		int elen = elist.size();
		if(hlen == 0 || elen == 0){return null;}
		List<Map<String, Object>> list = new ArrayList();
		Map<String, Object> temp = new HashMap();
		Map<String, Object> etemp = new HashMap();
		//按照历史记录的顺序把试题信息封装进
		for(int i = 0; i < hlen; i++){
			for(int j = 0; j < elen; j++){
				temp = hlist.get(i);
				etemp = elist.get(j);
				if(temp.get("examId").toString().equals(elist.get(j).get("examid").toString())){
					temp.put("options", etemp.get("options")== null ? "":etemp.get("options"));//所有的选项信息
					temp.put("readcode", etemp.get("readcode")== null ? "":etemp.get("readcode"));
					temp.put("readimg", etemp.get("readimg")== null ? "":etemp.get("readimg"));
					temp.put("readtext", etemp.get("readtext")== null ? "":etemp.get("readtext"));
					temp.put("contentimg", etemp.get("contentimg") == null ? "":etemp.get("contentimg"));
					temp.put("contenttext", etemp.get("contenttext")== null ? "":etemp.get("contenttext"));
					temp.put("examsubject", etemp.get("examsubject")== null ? "":etemp.get("examsubject"));
					temp.put("examgrades", etemp.get("examgrades")== null ? "":etemp.get("examgrades"));
					temp.put("exammark", etemp.get("exammark")== null ? "":etemp.get("exammark")); 
					temp.put("examresult", etemp.get("result")== null ? "":etemp.get("result"));
					list.add(temp);
					break;
				}
			}
		}
		return list;
	}
	//统计答题结果
	private HashMap<String,Object> getScoreInfo( String userid,String paperId,List<Map<String,String>> list){
		HashMap<String, Object> map = new HashMap<String, Object>();
		StringBuilder sb = new StringBuilder();
		int len = list.size();
		if(len == 0){
			return null;
		}
		//找出所有的题号，用于查询答案和各个题的分数
		for(int i=0;i<len;i++){
			sb.append(list.get(i).get("examId"));
			sb.append(",");
		}
		//查询答案和分数
		List<Map<String, Object>> rlist =  apiExamInfoTypeBizc.getExamResult( sb.toString().substring(0, sb.toString().length()-1));
		List<APIAnswerHistory> destList = new ArrayList();
		int rlen = rlist.size();
		int total = 0;
		int score = 0;
		String[] arr = null;
		String[] rarr = null;
		Boolean flag = (paperId==null||"".equals(paperId))? false:true;
		HashSet h1 = new HashSet();
		HashSet h2 = new HashSet();
		Map<String, Object> temp = new HashMap();
		APIAnswerHistory history = new APIAnswerHistory();
		Date date = new Date();
		//比对两个list,对答题结果和答案对比，计算得分和总分
		for(int i=0;i<len;i++){
			for(int j=0;j<rlen;j++){
				if(list.get(i).get("examId").toString().equals(rlist.get(j).get("examId").toString())){
					h1.clear();
					h2.clear();
					history = new APIAnswerHistory();
					//试卷id
					if(flag){
						history.setTestPaperId(Integer.valueOf(paperId));
					} 
					temp = new HashMap();
					temp = rlist.get(j);
					arr = list.get(i).get("answerOptions").split(",");
					//存储最初查询的内容
					history.setExamId(Integer.valueOf(temp.get("examId").toString()));
					history.setAnswerResult(String.valueOf(temp.get("history")));
					history.setExamTypeId(Integer.valueOf(temp.get("examTypeId").toString()));
					
					for(int m =0;m<arr.length;m++){
						h1.add(arr[m]);
					}
					rarr = rlist.get(j).get("answerOptions").toString().split(",");
					for(int n =0;n<rarr.length;n++){
						h2.add(rarr[n]);
					}
					
					//用户选择结果
					//temp.put("answerOptions", list.get(i).get("answerOptions").toString());
					history.setAnswerOptions( list.get(i).get("answerOptions").toString());
					//如果选择正确 
					if(h1.equals(h2) && arr.length == rarr.length){
						//1.加得分
						score += Integer.parseInt( rlist.get(j).get("mark").toString());
						//2.得分不变，总分加
						total += Integer.parseInt( rlist.get(j).get("mark").toString());
						//3.答题结果为对
						history.setAnswerResult("1");
					} else {
						//得分不变，总分加
						total += Integer.parseInt( rlist.get(j).get("mark").toString());
						//答题错误
						history.setAnswerResult("0");
					}
					//加入用户id
					history.setmUserId(Integer.valueOf(userid));
					//设置为未删除
					history.setDelFlag("0");
					//设置创建时间
					history.setCreateDate(date);
					destList.add(history);
					break;
				}
			}
		}
		map.put("total", total);
		map.put("destList", destList);
		map.put("score", score);
		return map;
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
}
