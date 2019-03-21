$ns("paperzd.views");

paperzd.views.TestPaperFormView=function(){
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
	var _TopHSplit = null;
	var _TopHSplitArea0 = null;
	var _TopToolBar = null;
	var _TopHSplitArea1 = null;
	var _DataForm = null;
	var _HSplitArea1 = null;
	var _BottomHSplit = null;
	var _BottomHSplitArea0 = null;
	var _BottomToolBar = null;
	var _BottomHSplitArea1 = null;
	var _DataGrid = null;
	var _Window = null;
	
	function _initControls(){
		//---调用初始化函数-----
		_init_HSplit();
		_init_HSplitArea0();
		_init_TopHSplit();
		_init_TopHSplitArea0();
		_init_TopToolBar();
		_init_TopHSplitArea1();
		_init_DataForm();
		_init_HSplitArea1();
		_init_BottomHSplit();
		_init_BottomHSplitArea0();
		_init_BottomToolBar();
		_init_BottomHSplitArea1();
		_init_DataGrid();
	  
		me.on("activate", me.controller._onactivate);
	}
	
	//-----定义初始化函数-----
	function _init_HSplit(){
		_HSplit=new mx.containers.HSplit({borderThick:"0",orientation:"horizontal",resizable:true,width:"100%",id:"HSplit",rows:"40%,60%",height:"100%"});
		me.addControl(_HSplit);
	}
	
	function _init_HSplitArea0(){
		_HSplitArea0 = new mx.containers.Container({
			layout:"mx.layouts.AbsoluteLayout",
			id:"HSplitArea0"
		});
		
		_HSplit.addControl(_HSplitArea0, 0);
	}
	
	function _init_TopHSplit(){
		_TopHSplit=new mx.containers.HSplit({borderThick:"0",padding:"0",orientation:"horizontal",width:"100%",layoutConfigs:{},id:"TopHSplit",rows:"25,auto",height:"100%"});
		_HSplitArea0.addControl(_TopHSplit);
	}
	
	function _init_TopHSplitArea0(){
		_TopHSplitArea0 = new mx.containers.Container({
			layout:"mx.layouts.AbsoluteLayout",
			id:"TopHSplitArea0"
		});
		
		_TopHSplit.addControl(_TopHSplitArea0, 0);
	}
	
	function _init_TopToolBar(){		
		_TopToolBar = new mx.controls.ToolBar({
			itemAlign:"right",
			width:"100%",
			layoutConfigs:{},
			id:"TopToolBar",
			direction:"horizontal",
			height:"24",
			items:[
				{imageKey:"save",width:"60",id:"TopSaveButton",text:"保存",height:"20",onclick:me.controller._TopSaveButton_onclick}
			]
		});
		
		_TopHSplitArea0.addControl(_TopToolBar);
	}
	
	function _init_TopHSplitArea1(){
		_TopHSplitArea1 = new mx.containers.Container({
			layout:"mx.layouts.AbsoluteLayout",
			id:"TopHSplitArea1"
		});
		
		_TopHSplit.addControl(_TopHSplitArea1, 1);
	}
	
	function _init_DataForm(){
		var formEntityContainer = new mx.datacontainers.FormEntityContainer({
			baseUrl:paperzd.mappath("~/rest/testPaper/"),
			loadMeta:false,
			iscID:"-1",
			primaryKey:"testPaperId",
			meta:
			[
				{readOnly:false,nullable:true,visible:true,valueType:"string",name:"testPaperName",caption:"试卷名称"},
				{readOnly:false,nullable:true,visible:true,valueType:"string",caption:"答题时间",name:"answerTime"},
				{readOnly:false,nullable:true,visible:true,valueType:"string",name:"testPaperType",caption:"试卷生成类型(自动手动)"}
			]
		});
		
		_DataForm = new mx.datacontrols.DataForm({
			displayPrimaryKey:false,
			width:"100%",
			layoutConfigs:{},
			id:"DataForm",
			maxCols:1,
			height:"100%",
			fields:
			[
				[
					"[默认]",true,
					{lineBreak:false,name:"testPaperName",caption:"试卷名称",labelWidth:120,readOnly:false,id:"testPaperName",height:"22",editorType:"TextEditor"},
					{formatString:"yyyy-MM-dd HH:mm:ss",displayTime:true,lineBreak:false,name:"answerTime",caption:"答题时间",labelWidth:120,readOnly:false,id:"answerTime",height:"22",editorType:"DateTimeEditor"},
					{lineBreak:false,name:"testPaperType",caption:"试卷生成类型(自动手动)",labelWidth:120,readOnly:false,id:"testPaperType",height:"22",editorType:"TextEditor"}
				]
			],
			entityContainer: formEntityContainer
		});
		
		_DataForm.on("load", me.controller._DataForm_onload);
		_TopHSplitArea1.addControl(_DataForm);
	}
	
	function _init_HSplitArea1(){
		_HSplitArea1 = new mx.containers.Container({
			layout:"mx.layouts.AbsoluteLayout",
			id:"HSplitArea1"
		});
		
		_HSplit.addControl(_HSplitArea1, 1);
	}
	
	function _init_BottomHSplit(){
		_BottomHSplit=new mx.containers.HSplit({borderThick:"0",padding:"0",orientation:"horizontal",width:"100%",layoutConfigs:{},id:"BottomHSplit",rows:"25,auto",height:"100%"});
		_HSplitArea1.addControl(_BottomHSplit);
	}
	
	function _init_BottomHSplitArea0(){
		_BottomHSplitArea0 = new mx.containers.Container({
			layout:"mx.layouts.AbsoluteLayout",
			id:"BottomHSplitArea0"
		});
		
		_BottomHSplit.addControl(_BottomHSplitArea0, 0);
	}
	
	function _init_BottomToolBar(){		
		_BottomToolBar = new mx.controls.ToolBar({
			itemAlign:"right",
			width:"100%",
			layoutConfigs:{},
			id:"BottomToolBar",
			direction:"horizontal",
			height:"24",
			items:[
				{imageKey:"add",width:"60",id:"BottomNewButton",text:"新建",height:"20",onclick:me.controller._BottomNewButton_onclick},
				{imageKey:"delete",width:"60",id:"BottomDelButton",text:"删除",height:"20",onclick:me.controller._BottomDelButton_onclick},
				{imageKey:"save",width:"60",id:"BottomSaveButton",text:"保存",height:"20",onclick:me.controller._BottomSaveButton_onclick},
				{imageKey:"print",width:"60",id:"BottomPrintButton",text:"打印",droppedDown:false,useSymbol:true,height:"20",onclick:me.controller._BottomPrintButton_onclick}
			]
		});
		
		_BottomHSplitArea0.addControl(_BottomToolBar);
	}
	
	function _init_BottomHSplitArea1(){
		_BottomHSplitArea1 = new mx.containers.Container({
			layout:"mx.layouts.AbsoluteLayout",
			id:"BottomHSplitArea1"
		});
		
		_BottomHSplit.addControl(_BottomHSplitArea1, 1);
	}
	
	function _init_DataGrid(){
		var gridEntityContainer = new mx.datacontainers.GridEntityContainer({
			baseUrl:paperzd.mappath("~/rest/manualRule/"),
			loadMeta:false,
			iscID:"-1",
			primaryKey:"manualRuleId"
		});
		
		_DataGrid = new mx.datacontrols.DataGrid({
			columns:[
				{dataType:"string",name:"manualRuleId",width:"120",caption:"手动规则试卷内容",readOnly:false,id:"manualRuleId",editorType:"TextEditor",nullable:false},
				{dataType:"string",name:"examTypeId",width:"120",caption:"试题类型ID",readOnly:false,id:"examTypeId",editorType:"TextEditor"},
				{dataType:"string",name:"examIds",width:"120",caption:"试题ID集合",readOnly:false,id:"examIds",editorType:"TextEditor"}
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
			filterPropertyForMaster:"testpaper.testPaperId",
			height:"100%",
			pageNaviBar:new mx.datacontrols.PageNaviBar({
				pageIndex:1,
				pageSize:20,
				id:"PageNaviBar",
				height:"24"
			}),
			entityContainer: gridEntityContainer
		});
		
		_BottomHSplitArea1.addControl(_DataGrid);
	}
	
	function _init_Window() {		
		if(_Window == null || ((_Window.reusable==false) && _Window.disposed==true)) {
			_Window = paperzd.context.windowManager.create({
				title:"详细信息",
				reusable:true
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