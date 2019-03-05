<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<%@ taglib uri="/tags/mx-framework" prefix="mx" %>
<%@ page import="java.util.*" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import= "com.sgcc.uap.rest.support.*" %>
<%@ page import= "com.hoperun.server.commons.util.*" %>
<%@ page import="com.sgcc.uap.utils.ComponentFactory" %>
<%@ page import="com.hoperun.server.audit.bizc.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消息列表</title>
</head>
<% 
	ITbAuditBizc tbBizc = (ITbAuditBizc)ComponentFactory.getBean("tbauditBizc", request);
    tbBizc.queryMessageList(request,response);
%>
<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
<body>
<dl class="im_contactcard">
    <dt><b>未读消息列表</b></dt>
    <c:forEach items="${noreadResultList }" var="map">
    <dd >主题：<i><c:out value='${map.audit_handle}'/></i> &nbsp;时间：<i><c:out value='${map.audit_time}'/></i> <a  onclick="find('<c:out value="${map.audit_id}"/>')"> &nbsp;查看详情>></a></dd>
    </c:forEach>
    <dt><b>已读消息列表</b></dt>
    <c:forEach items="${readResultList }" var="map">
    <dd >主题：<i><c:out value='${map.audit_handle}'/></i> &nbsp;时间：<i><c:out value='${map.audit_time}'/></i> <a  onclick="find('<c:out value="${map.audit_id}"/>')"> &nbsp;查看详情>></a></dd>
    </c:forEach>
</dl>
</body>
<script type="text/javascript">
  function find(id){
	  window.location.href = "message.jsp?id="+id;
  }
</script>
<style type="text/css">
    .im_contactcard{line-height: 25px;float: left;width:600px;margin-bottom:10px;cursor:default }
    .im_contactcard dt{border-bottom: dashed 1px #ddd;margin:10px 0;padding-bottom:10px;}
    .im_contactcard dt a.approve{background-position:-18px 0; }
    .im_contactcard dt b{font-size:24px;font-weight: bold;color:#000;font-weight:normal;margin-right:10px;font-family: "microsoft yahei"; }
    .im_contactcard dd a{cursor:pointer;float:right}
    .im_contactcard i{font-style: normal;color:#666 !important;}
    .im_contactcard h4{line-height: 40px;border-bottom: dashed 1px #ddd;font-size: 14px;margin-bottom:10px;}
    .im_contactcard h4 a{font-size: 12px;}
    .im_mycard{padding:15px 20px;border:solid 1px #b7b7b7;border-top:solid 2px #000;width:300px;margin:5px 0;background: #fff;}
    .im_mycard a.cc{color:#999;text-decoration: none;padding-left:15px;margin-right:10px;}
    .im_mycard a.cc:hover{text-decoration: underline;color:#666;}
    .im_mycard a.cc.atocard:hover{background-position: 0 -188px;}
    .im_mycard a.cc.aqrcode:hover{background-position:  0 -142px;}
</style>
</html>