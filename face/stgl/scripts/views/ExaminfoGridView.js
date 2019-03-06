$ns("stgl.views");

stgl.views.ExaminfoGridView=function(){
	var me = $extend(mx.views.View);
	var base = {};
	base.init = me.init;
	me.init = function () {
		me.permissionID = "-1";
		base.init();
		_initControls();
	};
	
	//----声明mx组件变量------
	var _HSplit = null;
	var _HSplitArea0 = null;
	var _ToolBar = null;
	var _HSplitArea1 = null;
	var _DataGrid = null;
	var _Window = null;
	
	function _initControls(){
		//---调用初始化函数-----
		_init_HSplit();
		_init_HSplitArea0();
		_init_ToolBar();
		_init_HSplitArea1();
		_init_DataGrid();
	  
		me.on("activate", me.controller._onactivate);
	}
	
	//-----定义初始化函数-----
	function _init_HSplit(){
		_HSplit=new mx.containers.HSplit({borderThick:"0",padding:"0",orientation:"horizontal",width:"100%",id:"HSplit",rows:"25,auto",height:"100%"});
		me.addControl(_HSplit);
	}
	
	function _init_HSplitArea0(){
		_HSplitArea0 = new mx.containers.Container({
			layout:"mx.layouts.AbsoluteLayout",
			id:"HSplitArea0"
		});
		
		_HSplit.addControl(_HSplitArea0, 0);
	}
	
	function _init_ToolBar(){		
		_ToolBar = new mx.controls.ToolBar({
			itemAlign:"right",
			width:"100%",
			layoutConfigs:{},
			id:"ToolBar",
			direction:"horizontal",
			height:"24",
			items:[
				{imageKey:"add",name:"NewButton",width:"60",id:"NewButton",text:"新增",height:"20",onclick:me.controller._NewButton_onclick},
				{imageKey:"save",name:"SaveButton",width:"60",id:"SaveButton",text:"保存",height:"20",onclick:me.controller._SaveButton_onclick},
				{imageKey:"delete",name:"DelButton",width:"60",id:"DelButton",text:"删除",height:"20",onclick:me.controller._DelButton_onclick},
				{imageKey:"print",width:"60",id:"PrintButton",text:"打印",droppedDown:false,useSymbol:true,height:"20",onclick:me.controller._PrintButton_onclick}
			]
		});
		
		_HSplitArea0.addControl(_ToolBar);
	}
	
	function _init_HSplitArea1(){
		_HSplitArea1 = new mx.containers.Container({
			layout:"mx.layouts.AbsoluteLayout",
			id:"HSplitArea1"
		});
		
		_HSplit.addControl(_HSplitArea1, 1);
	}
	
	function _init_DataGrid(){
		var gridEntityContainer = new mx.datacontainers.GridEntityContainer({
			baseUrl:stgl.mappath("~/rest/examinfo/"),
			loadMeta:false,
			iscID:"-1",
			primaryKey:"examId"
		});
		
		_DataGrid = new mx.datacontrols.DataGrid({
			columns:[
				{dataType:"string",name:"examId",width:"120",caption:"试题ID",readOnly:false,id:"examId",editorType:"TextEditor",nullable:false},
				{dataType:"string",name:"struId",width:"120",caption:"组织ID",readOnly:false,id:"struId",editorType:"TextEditor"},
				{dataType:"string",name:"areaId",width:"120",caption:"区域ID",readOnly:false,id:"areaId",editorType:"TextEditor"},
				{dataType:"string",name:"readingId",width:"120",caption:"阅读内容ID",readOnly:false,id:"readingId",editorType:"TextEditor"},
				{dataType:"clob",name:"examContentText",width:"120",caption:"试题内容(文本)",readOnly:false,id:"examContentText",editorType:"RichTextEditor"},
				{dataType:"clob",name:"examContentImg",width:"120",caption:"试题内容(图片)",readOnly:false,id:"examContentImg",editorType:"RichTextEditor"},
				{dataType:"string",name:"examAnswer",width:"120",caption:"试题答案",readOnly:false,id:"examAnswer",editorType:"TextEditor"},
				{dataType:"clob",name:"answerAnalyze",width:"120",caption:"答案解析",readOnly:false,id:"answerAnalyze",editorType:"RichTextEditor"},
				{dataType:"string",name:"examSubject",width:"120",caption:"试题类型单选多选",readOnly:false,id:"examSubject",editorType:"TextEditor"},
				{dataType:"string",name:"examGrades",width:"120",caption:"难易程度难度等级暂定",readOnly:false,id:"examGrades",editorType:"TextEditor"},
				{dataType:"string",name:"examMark",width:"120",caption:"试题分数",readOnly:false,id:"examMark",editorType:"TextEditor"},
				{dataType:"string",name:"examTypeId",width:"120",caption:"试题分类ID",readOnly:false,id:"examTypeId",editorType:"TextEditor"},
				{formatString:"yyyy-MM-dd HH:mm:ss",displayTime:true,dataType:"timestamp",name:"createDate",width:"120",caption:"创建时间",readOnly:false,id:"createDate",editorType:"DateTimeEditor"},
				{dataType:"string",name:"createBy",width:"120",caption:"创建者",readOnly:false,id:"createBy",editorType:"TextEditor"},
				{dataType:"string",name:"updateBy",width:"120",caption:"更新者",readOnly:false,id:"updateBy",editorType:"TextEditor"},
				{formatString:"yyyy-MM-dd HH:mm:ss",displayTime:true,dataType:"timestamp",name:"updateDate",width:"120",caption:"更新时间",readOnly:false,id:"updateDate",editorType:"DateTimeEditor"},
				{dataType:"string",name:"delFlag",width:"120",caption:"删除标记",readOnly:true,id:"delFlag",editorType:"TextEditor",value:"0"}
			],
			
			allowEditing:true,
			allowPaging:true,
			validateOnSaving:true,
			pageIndex:1,
			width:"100%",
			layoutConfigs:{},
			pageSize:20,
			displayCheckBox:true,
			id:"DataGrid",
			height:"100%",
			pageNaviBar:new mx.datacontrols.PageNaviBar({
				pageIndex:1,
				pageSize:20,
				id:"PageNaviBar1",
				height:"24"
			}),
			entityContainer: gridEntityContainer
		});
		
		_HSplitArea1.addControl(_DataGrid);
	}
	
	function _init_Window() {		
		if(_Window == null || ((_Window.reusable==false) && _Window.disposed==true)) {
			_Window = stgl.context.windowManager.create({
				entry:true
			});
		}
		_Window.on("activate", function() {
			_Window.setView(me);
		});
		_Window.on("close", function(e){
		    $.each(_Window.controls, function(i, o){
				o.$e.detach();
			});
		});
	}
	
	me.getWindow = function() {
		_init_Window();
		return _Window;
	};
	
	
	me.findControlById = function(controlId){
		try{
			return me.findControl("id", controlId);
		} catch(err) {
			mx.indicate("info","未找到对应的mx控件:    "+ err.message);
			return null;
		}	
	};
    return me.endOfClass(arguments);
};