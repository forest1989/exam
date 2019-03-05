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
<title>消息</title>
</head>
<% 
    String id=new com.hoperun.server.xss.XssHttpServletRequestWrapper(request).getParameter("id");
	ITbAuditBizc tbBizc = (ITbAuditBizc)ComponentFactory.getBean("tbauditBizc", request);
    tbBizc.findMessageById(request, id);
%>
<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
<body>
 <input type="button" value="返回" onclick="retu()" style="float:right"/>
 <div class="contentmsg"><c:out value='${auditMap.audit_content }'/></div>
</body>
<script>
	function retu(){
		history.back();
	}
</script>
<style type="text/css">
    .im_contactcard{line-height: 20px;width:600px;margin-bottom:10px; }
    .im_contactcard dt{border-bottom: dashed 1px #ddd;margin-bottom: 10px;padding-bottom:10px;}
    .im_contactcard dt a.approve{background-position:-18px 0; }
    .im_contactcard dt b{font-size:24px;font-weight: bold;color:#000;font-weight:normal;margin-right:10px;font-family: "microsoft yahei"; }
    .im_contactcard i{font-style: normal;color:#666 !important;}
    .im_contactcard h4{line-height: 40px;border-bottom: dashed 1px #ddd;font-size: 14px;margin-bottom:10px;}
    .im_contactcard h4 a{font-size: 12px;}
    .im_mycard{padding:15px 20px;border:solid 1px #b7b7b7;border-top:solid 2px #000;width:300px;margin:5px 0;background: #fff;}
    .im_mycard a.cc{color:#999;text-decoration: none;padding-left:15px;margin-right:10px;}
    .im_mycard a.cc:hover{text-decoration: underline;color:#666;}
    .im_mycard a.cc.atocard:hover{background-position: 0 -188px;}
    .im_mycard a.cc.aqrcode:hover{background-position:  0 -142px;}
    .contentmsg {
	FONT-SIZE: 14px; LINE-HEIGHT: 1.6em ; border:1px solid black ; margin-left:40px
	}
	.contentmsg TD {
		FONT-SIZE: 14px; LINE-HEIGHT: 1.6em
	}
	.contentmsg * {
		LINE-HEIGHT: 1.6em
	}
	.contentmsg A {
		COLOR: #069
	}
	.contentmsg LI {
		MARGIN-LEFT: 2em
	}
	.contentmsg EM {
		FONT-STYLE: italic
	}
	.contentmsg SUP {
		MARGIN-LEFT: 1px; COLOR: #090
	}
	.contentmsg IMG {
		max-width: 760px
	}
	.contentmsg {
	PADDING: 10px; OVERFLOW-X: hidden; MIN-HEIGHT: 10px! important; HEIGHT: auto! important
	}
	.contentmsg * {
		LINE-HEIGHT: normal
	}
	.contentmsg H2 {
		FONT-SIZE: 1.17em; MARGIN-BOTTOM: 0.5em
	}
	.contentmsg .box {
		BORDER: 0px; MARGIN: 5px 0px
	}
	.contentmsg .box TBODY TH {
		BORDER-TOP-COLOR: #e8e8e8
	}
	.contentmsg .box TBODY TD {
		BORDER-TOP-COLOR: #e8e8e8
	}
</style>
</html>