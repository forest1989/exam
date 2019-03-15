<%@ page contentType="text/html;charset=utf-8"%>

<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.*"%>
<%@ page import="com.sgcc.uap.integrate.isc.ims.entity.ImsUser"%>
<%@ page import="com.sgcc.exam.common.utils.ISCOrgInfo"%>

<%
	String app = request.getContextPath();
 	app=app.replaceAll("tec_framework","bsp");
 	//== 
 	//ImsUser user2 = (ImsUser) session.getAttribute("userObj");
 	
 	//u.put("bm", user2.getOrgsPath().get(0).getName());
 	//u.put("dw", user2.getOrgsPath().get(1).getName());
 	//System.out.println(session.getAttribute("userObj").toString());
 	
 	//== 
 	//String userId = user2.getId();
 	//String orgName = user2.getOrgsPath().get(0).getName();
 	//String comment = user2.getOrgsPath().get(0).getComment();
 	//String unicode = user2.getOrgsPath().get(0).getUnicode();
 	
 	//String baseOrgId = user2.getBaseOrgId();
 	//System.out.println("orgName==========" +orgName);
 	
 	//System.out.println("unicode==========" +unicode);
 	
 	//== 
 	//session.setAttribute("userId", userId);
 	//session.setAttribute("userName", userName);
 	//	session.setAttribute("name", user2.getName());
 	//session.setAttribute("baseOrgId", baseOrgId);
 	//session.setAttribute("orgName", orgName);
	//	session.setAttribute("unicode", unicode);
 	//== 
 	//ISCOrgInfo add = new ISCOrgInfo();
 	//== 
 	String xml11 = null ;//add.test(request);
 	//== 
 	//List<String> syss = add.getOrgInfo(userId);
 	//== 
 	//session.setAttribute("sys1", syss.get(0));
 	//== 
 	//session.setAttribute("sys2", syss.get(1));
 	//== 
 	//session.setAttribute("sysRoles", syss.get(2));
 	//System.out.println("dddddddddddddddd===" +xml11);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>信息安全考试管理系统</title>
<link href="../resources/css/index.css" rel="stylesheet" type="text/css" />
<link href="../resources/css/top.css" rel="stylesheet" type="text/css" />
<link href="../resources/scripts/easy/themes/stategrid1/easyui.css" rel="stylesheet" type="text/css" />
<link href="css/zTreeStyle/zTreeStyle.css" type="text/css" rel="stylesheet" >
<script type="text/javascript" src="../resources/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="../resources/scripts/project/start.js"></script>
<script type="text/javascript" src="../resources/js/jquery.ztree.core-3.5.js"></script>
<style type="text/css">
	.accordion{overflow:hidden;border-width:1px;border-style:solid;}.accordion .accordion-header{border-width:0 0 1px;cursor:pointer;}.accordion .accordion-body{border-width:0 0 1px;}.accordion-noborder{border-width:0;}.accordion-noborder .accordion-header{border-width:0 0 1px;}.accordion-noborder .accordion-body{border-width:0 0 1px;}.accordion-collapse{background:url('../resources/images/accordion_arrows.png') no-repeat 0 0;}.accordion-expand{background:url('../resources/images/accordion_arrows.png') no-repeat -16px 0;}.accordion{background:#ffffff;border-color:#7bb6b4;}.accordion .accordion-header{background:#d9eeeb;filter:none;height:26px;background-image:url(../resources/images2/s_30.jpg);background-repeat:no-repeat;}.accordion .accordion-header-selected{background:#f9e9bd;height:26px;background-image:url(../resources/images2/s_344.jpg);background-repeat:no-repeat;}.accordion .accordion-header-selected .panel-title{color:#000000;font-size:14px;font-family:"宋体";font-weight:normal;margin-top:0px;margin-left:50px;}.accordion .accordion-header .panel-title{color:#000000;font-size:14px;font-family:"宋体";font-weight:normal;margin-top:0px;margin-left:50px;line-height:26px;}
</style>
</head>
<body id='bbb' class="easyui-layout">
	<div data-options="region:'north',border:false" height="116">
		<table width="100%" border="0" class="kj_head_bg">
			<tr>
				<td>
					<table width="100" border="0" align="right" valign=middle cellpadding="0" cellspacing="0">
						<tr>
							<td width=20px; align=""center""><img src="../resources/images2/f_04.jpg" alt="" width="6" height="63" /></td>
							<td align="center" style="width: 30px">
								<div class="btnImg"> <img src="../resources/images2/s4.fw.png" alt="" /></div>
							</td>
							<td align="center" style="width: 30px">
								<div class="easyui-linkbutton" data-options="plain:true" style="margin-top: -3px;">
									<font color=#005e5e><a href="../main/logout.jsp?id=1" style="text-decoration: none;">退&nbsp;&nbsp;出</a></font>
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<div width="100%" id="top_row"></div>
	</div>

	<div id="sss2" data-options="region:'west',split:false" style="width: 228px; margin-top: 2px;">
		<div id="leftAccordion" class="easyui-accordion" data-options="fit:true,border:false"></div>
	</div>
	<div data-options="region:'center',border:false">
		<div id="main-tabs" data-options="border:false,plain:true,tabHeight:38,fit:true" class="easyui-tabs">
			<div title="欢迎页面" style="padding: 10px" data-options="href:'welcome.html'"></div>
		</div>
	</div>
	<div id="addDlg"></div>
	<script type="text/javascript">
		function banBackSpace(e){ 
		    var ev = e || window.event;//获取event对象   
			var obj = ev.target || ev.srcElement;//获取事件源   
			var t = obj.type || obj.getAttribute('type');//获取事件源类型  
			//获取作为判断条件的事件类型
			var vReadOnly = obj.getAttribute('readonly');
			//处理null值情况
			vReadOnly = (vReadOnly == "") ? false : vReadOnly;
			//当敲Backspace键时，事件源类型为密码或单行、多行文本的，
			//并且readonly属性为true或enabled属性为false的，则退格键失效
			var flag1=(ev.keyCode == 8 && (t=="password" || t=="text" || t=="textarea") && vReadOnly=="readonly")?true:false;
			//当敲Backspace键时，事件源类型非密码或单行、多行文本的，则退格键失效
			var flag2=(ev.keyCode == 8 && t != "password" && t != "text" && t != "textarea")?true:false;        
			//判断
			if(flag2){
			     return false;
			}
			if(flag1){   
			     return false;   
			}   
		}
		window.onload=function(){
		//禁止后退键 作用于Firefox、Opera
		document.onkeypress=banBackSpace;
		//禁止后退键  作用于IE、Chrome
		document.onkeydown=banBackSpace;
	}
	</script>
	
	<script type="text/javascript">
		var setting = {
			view: {
					showLine: false
					//fontCss: getFont
			},	 
			data: {
				simpleData: {   
					enable: true
				}
			}, 
			callback: { 
				onMouseDown: onMouseDown
			}
		};
		function cascadeTree( xmlTreeNode, ztreeArray,_i,expandLevel){
	    	var obj = xmlTreeNode.childNodes;
		    if(obj){
		  	  var expend = false;  
			  for(var i = 0; i < obj.length; i++){
				  if(i == 0){
					  if(!expandLevel[1])expandLevel[1]=0;
		      			expandLevel[1]=expandLevel[1]+1;
		      			if(expandLevel[1]<expandLevel[0]) expend=true;
					  }	 
				  var onode=obj[i];
				  var _text=onode.getAttribute("text");
		
				  if("查询我的个人信息"==_text||"我的个性化菜单"==_text||"管理人力资源组织结构"==_text||"组织结构回溯"==_text){				    
		              continue;
				  }
				  if(_text.length>11){ _text=(_text.substr(0,11))+".."  ;}
				  if(expend){
				  		ztreeArray.push({ id:onode.getAttribute("id") ,open:true, pId:_i, name:_text,uurl:onode.getAttribute("url"),pnode:xmlTreeNode.getAttribute("id"),tget:onode.getAttribute("targetframe"),iconImg:onode.getAttribute("iconImg"),icon:'../resources/images/icons/16/Outline.ico',iconOpen:"../resources/images/icons/16/Folder.ico", iconClose:"../resources/images/icons/16/Folder-Closed.ico" });
				  } else
				  ztreeArray.push({ id:onode.getAttribute("id") , pId:_i, name:_text,uurl:onode.getAttribute("url"),pnode:xmlTreeNode.getAttribute("id"),tget:onode.getAttribute("targetframe"),iconImg:onode.getAttribute("iconImg") ,icon:'../resources/images/icons/16/Outline.ico',iconOpen:"../resources/images/icons/16/Folder.ico", iconClose:"../resources/images/icons/16/Folder-Closed.ico" });
				    
				 cascadeTree(onode,ztreeArray,onode.getAttribute("id"),expandLevel); 
			 	} 
			}
		}
	
	</script>
	<script type="text/javascript">
	function addTab(_tile,_icon,_url){
		var _tab=$('#main-tabs').tabs("getTab",_tile);
		if(_tab){
			$('#main-tabs').tabs("select",_tile);
		}else{
			//debugger;
			$('#main-tabs').tabs('add',{
			    title:_tile,
			    height:'900px',
			    //href:_url,
			    //cache:false,
			    content:'<iframe scrolling="yes"   border="0"     frmeborder="0" src="'+_url+'" style="width:100%;height:99%;border:0;"></iframe>',
			    closable:true
			    
			});
		}
	}
	</script>
	<script>
		var _data_test ='<xmlmenu>'+
		'<menu id="01100" url="../ggl/index.jsp" text="试题管理" targetframe="main" type="0" link="" selected="false" enable="true" noborderColor="false">'+
			'<menu id="01101" url="../ggl/index.jsp" text="试题管理" targetframe="main" type="0" link="" selected="false" enable="true" noborderColor="false">'+
				'<menu id="01106" url="../stgl/index.jsp" text="试题管理" targetframe="main" type="0" link="" selected="false" enable="true" noborderColor="false" iconImg="bt5"/>'+
			 '<menu id="01107" url="../readtext/index.jsp" text="阅读列表" targetframe="main" type="0" link="" selected="false" enable="true" noborderColor="false" iconImg="bt5"/>'+
			 '</menu>'+
			
		'</menu>'+
		
			'<menu id="01100" url="../ggl/index.jsp" text="用户管理" targetframe="main" type="0" link="" selected="false" enable="true" noborderColor="false">'+
			'<menu id="01101" url="../ggl/index.jsp" text="用户管理" targetframe="main" type="0" link="" selected="false" enable="true" noborderColor="false">'+
				'<menu id="01106" url="../rguser/index.jsp" text="用户管理" targetframe="main" type="0" link="" selected="false" enable="true" noborderColor="false" iconImg="bt6"/>'+
			'</menu>'+
			
		'</menu>'+
			'<menu id="02101" url="../bookInfoYD/index.jsp" text="试卷管理" targetframe="main" type="0" link="" selected="false" enable="true" noborderColor="false">'+
				'<menu id="02102" url="../wjtz/xx" text="试卷库管理" targetframe="main" type="0" link="" selected="false" enable="true" noborderColor="false" >'+
				'<menu id="02103" url="../testpaper/index.jsp" text="试卷列表" targetframe="main" type="0" link="" selected="false" enable="true" noborderColor="false" iconImg="bt7"/>'+
				'</menu>'+
			'</menu>'+
			'<menu id="04101" url="../hdglmovie/index.jsp" text="试题分类" targetframe="main" type="0" link="" selected="false" enable="true" noborderColor="false">'+
				'<menu id="04102" url="../hdglmovie/index.jsp" text="试题分类管理" targetframe="main" type="0" link="" selected="false" enable="true" noborderColor="false" >'+
				'<menu id="04103" url="../etTree/index.jsp" text="试题分类" targetframe="main" type="0" link="" selected="false" enable="true" noborderColor="false" />'+
			'</menu>'+
		'</menu>'+
		'</xmlmenu>';
		var parseXml;
		if (typeof window.DOMParser != "undefined") {
		    parseXml = function(xmlStr) {
		        return ( new window.DOMParser() ).parseFromString(xmlStr, "text/xml");
		    };
		} else if (typeof window.ActiveXObject != "undefined" && new window.ActiveXObject("Microsoft.XMLDOM")) {parseXml = function(xmlStr) {
		        var xmlDoc2 = new window.ActiveXObject("Microsoft.XMLDOM");
		        xmlDoc2.async = "false";
		        xmlDoc2.loadXML(xmlStr);
		        return xmlDoc2;
		    };
		} else {
		    throw new Error("No XML parser found");
		}
		function loadData (url,param) {
		    var xmlDoc;
			xmlDoc=parseXml(url);
			if(xmlDoc.childNodes[0]!=null){
				var _rsNodes=xmlDoc.childNodes[0];
		        //=================剔除灰色 但用户拥有的权限=====================
				var _removeNode__=[]; 
				for(var i=0;i<_rsNodes.childNodes.length;i++){
					var onode=_rsNodes.childNodes[i]; 
					if(onode.getAttribute("targetframe")=='disabled'){
				        //判断是否有权限，如果没有就用灰色表示
				        var isIgnor=false;
				        for(var _mmx=0;_mmx<_rsNodes.childNodes.length;_mmx++){
				        	var _mmxNode=_rsNodes.childNodes[_mmx];
				        	if(_mmxNode.getAttribute("text")==onode.getAttribute("text")&&_mmxNode.getAttribute("targetframe")!='disabled'){
				        		isIgnor=true; 
				            }			      
				        }
				        if(isIgnor)_removeNode__.push(onode);//表示有权限 就不用灰色来表示了 
				    } 
				}
				for(var i=0;i<_removeNode__.length;i++){ 
					_rsNodes.removeChild(_removeNode__[i]);
				}
				 //=================剔除灰色 但用户拥有的权限=====================
				return _rsNodes;
			}
			return null;
		}
		
		var _data='<%=xml11%>';
		_data = _data_test;
		top.menuData = loadData(_data, 1);
		if (top.menuData == null) {
			//document.location=document.location;
		}
		top.currentMenuIndex = 0;
		top._menuNavIndexMove = 0;
		top.addtb_name = "";
		top.addtb_url = "";
		top.addtb_id = "";
	</script>
	
	<script type="text/javascript">
		var _currM = null;
		function changeMenu(_this, _url) {
			var xmldoc = top.menuData;
			var ooj = xmldoc.childNodes[top.currentMenuIndex];
			for (var i = 0; i < ooj.childNodes.length; i++) {
				var onode = ooj.childNodes[i];
				var _text = onode.getAttribute("text") + "";
				try {
					$('#leftAccordion').accordion('remove', _text);
				} catch (e) {}
			}
			//将样式统一设置为默认状态
			for (var i = 1; i < 100; i++) {
				var m = document.getElementById('m' + i);
				if (m) {
					//菜单为灰色
					//if(i==4||i==5||i==6){
					//	m.className = 'btnFont_disable';
					//}else{
					m.className = 'btnFont2';
					//}
	
				}
			}
			_this.className = 'btnFont22';
			_currM = _this;
			top.currentMenuIndex = 0;
			var _numStr = _this.id + "";
			_numStr = _numStr.substr(1, _numStr.length);
			var _num = _numStr - 1;
			top.currentMenuIndex = _num;
			ooj = xmldoc.childNodes[top.currentMenuIndex];
			for (var i = 0; i < ooj.childNodes.length; i++) {
				var onode = ooj.childNodes[i];
				var _text = onode.getAttribute("text") + "";
				//var _id=  onode.getAttribute("id")+"";
				var zNodes_sub = [];
				cascadeTree(onode, zNodes_sub, 0, [ 2, 0 ]);//不全部展开
				var _html = "<div style=\"padding:10px\">";
				for (var _ii = 0; _ii < zNodes_sub.length; _ii++) {
					_html += "<a id='menu_btn_"
							+ zNodes_sub[_ii].name
							+ "'class=\"easyui-linkbutton\" data-options=\"plain:true,iconCls:'"
							+ zNodes_sub[_ii].iconImg
							+ "',size:'large',iconAlign:'top'\" style=\"width:48%;  \" onclick=\"toggle_btn(this);addTab('"
							+ zNodes_sub[_ii].name + "','bt1_mini','"
							+ zNodes_sub[_ii].uurl + "')\">"
							+ zNodes_sub[_ii].name + "</a>";
				}
				_html += "</div>";
				var isSelect = (i == 0);
				try {
					$('#leftAccordion').accordion('add', {
						title : _text,
						content : _html,
						/*
						content:"<div style=\"padding:10px\">"+
						"<ul   id=\"tree"+_text+"\" class=\"ztree\"></ul>"+
						"</div>",  
						 */
						selected : isSelect
					});
				} catch (e) {
					alert(e)
				}
				//$.fn.zTree.init($(("#tree"+_text)), setting, zNodes_sub);
			}
		}
	
		function menuMouseOver(_this) {
			_this.className = 'btnFont22';
		}
		function menuMouseOut(_this) {			
			if (_this != _currM) {
				_this.className = 'btnFont2';
			}
		}
		var zNodes2 = [];
		function createFileds() {
			var xmldoc = top.menuData;
			if (typeof xmldoc == "undefined")
				return;
			var _htmlStr = '<table width="100%" height="44px" border="0" class="kj_head_bg2"><tr valign=middle><td width="3%" align="center"> </td>';
			for (var i = 0; i < xmldoc.childNodes.length; i++) {
				var onode = xmldoc.childNodes[i];
				if (i != 0) {
					_htmlStr += '<td width="1%" align="center"><img src="../resources/images2/f_26.png" alt="" width="6" height="31" /></td>';
				}
				var selectedCls = "btnFont2";
				var onMouseOver_Str = "onMouseOver=\"menuMouseOver(this)\"";
				var onMouseOut_Str = "onMouseOut=\"menuMouseOut(this)\"";
				if (i == 0) {
					selectedCls = "btnFont22";
				}
				//限定是否为灰色 i ==3||i ==4||i ==5
				if (i == 100) {
					selectedCls = "btnFont_disable";
					onMouseOut_Str = "";
					onMouseOver_Str = "";
					_htmlStr += '<td width="8%" align="center"  ><table  id="m'
							+ (i + 1) + '"  class="' + selectedCls + '" '
							+ onMouseOver_Str + onMouseOut_Str
							+ ' ><tr align=center><td>'
							+ onode.getAttribute("text")
							+ '</td></tr></table></td>';
				} else {
					_htmlStr += '<td width="8%" align="center"  ><a href="#" style="cursor:hand;text-decoration: none;"><table  id="m'
							+ (i + 1)
							+ '"  class="'
							+ selectedCls
							+ '" '
							+ onMouseOver_Str
							+ ' onClick="changeMenu(this,\''
							+ onode.getAttribute("url")
							+ '\')" '
							+ onMouseOut_Str
							+ ' ><tr align=center><td>'
							+ onode.getAttribute("text")
							+ '</td></tr></table></a></td>';
				}
			}
			_htmlStr += '<td width="20%" align="center"></td></tr></table>';
			document.getElementById("top_row").innerHTML = _htmlStr;
		}
		function toggle_btn(_this) {
			var xmldoc = top.menuData;
			var ooj = xmldoc.childNodes[top.currentMenuIndex];
			for (var i = 0; i < ooj.childNodes.length; i++) {
				var onode = ooj.childNodes[i];
				var _text = onode.getAttribute("text") + "";
				var zNodes_sub = [];
				cascadeTree(onode, zNodes_sub, 0, [ 2, 0 ]);//不全部展开			 
				var _html = "<div style=\"padding:10px\">";
				for (var _ii = 0; _ii < zNodes_sub.length; _ii++) {
					var _id = 'menu_btn_' + zNodes_sub[_ii].name;
					if (_this.id == _id) {
						$('#' + _id).linkbutton({
							selected : true
						});
					} else {
						$('#' + _id).linkbutton({
							selected : false
						});
					}
				}
			}
		}
		//创建菜单
		createFileds();
		//激活第一个菜单 必须要等leftAccordion初始化后才能进行
		$(document).ready(function() {
			var url = getContextPath();
			changeMenu(document.getElementById('m1'), null);
			
			function getContextPath() {
				var pathName = document.location.pathname;
				var index = pathName.substr(1).lastIndexOf("/");
				var result = pathName.substr(0, index + 1);
				index = result.substr(1).lastIndexOf("/");
				result = result.substr(0, index + 1);
				return result;
			}
		});
	</script>
</body>
</html>