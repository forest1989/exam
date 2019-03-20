$ns("manualrule.views");

manualrule.views.ManualRuleFormView=function(){
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
	var _DetailToolBar = null;
	var _HSplitArea1 = null;
	var _DataForm = null;
	var _Window = null;
	
	function _initControls(){
		//---调用初始化函数-----
		_init_HSplit();
		_init_HSplitArea0();
		_init_DetailToolBar();
		_init_HSplitArea1();
		_init_DataForm();
	  
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
	
	function _init_DetailToolBar(){		
		_DetailToolBar = new mx.controls.ToolBar({
			itemAlign:"right",
			width:"100%",
			layoutConfigs:{},
			id:"DetailToolBar",
			direction:"horizontal",
			height:"24",
			items:[
				{imageKey:"save",width:"60",id:"SaveButton",text:"保存",droppedDown:false,useSymbol:true,height:"20",onclick:me.controller._saveButton_onclick}
			]
		});
		
		_HSplitArea0.addControl(_DetailToolBar);
	}
	
	function _init_HSplitArea1(){
		_HSplitArea1 = new mx.containers.Container({
			layout:"mx.layouts.AbsoluteLayout",
			id:"HSplitArea1"
		});
		
		_HSplit.addControl(_HSplitArea1, 1);
	}
	
	function _init_DataForm(){
		var formEntityContainer = new mx.datacontainers.FormEntityContainer({
			baseUrl:manualrule.mappath("~/rest/manualRule/"),
			loadMeta:false,
			iscID:"-1",
			primaryKey:"manualRuleId",
			meta:
			[
				{readOnly:false,nullable:false,visible:true,valueType:"string",name:"manualRuleId",caption:"手动规则试卷内容"},
				{readOnly:false,nullable:true,visible:true,valueType:"string",name:"testPaperId",caption:"试卷ID"},
				{readOnly:false,nullable:true,visible:true,valueType:"string",name:"examTypeId",caption:"试题类型ID"},
				{readOnly:false,nullable:true,visible:true,valueType:"string",name:"examIds",caption:"试题ID集合"},
				{readOnly:false,nullable:true,visible:true,valueType:"string",name:"delFlag",caption:"删除标记"}
			]
		});
		
		_DataForm = new mx.datacontrols.DataForm({
			width:"100%",
			layoutConfigs:{},
			id:"DataForm",
			maxCols:1,
			height:"100%",
			fields:
			[
				[
					"[默认]",true,
					{lineBreak:false,name:"manualRuleId",caption:"手动规则试卷内容",labelWidth:120,readOnly:false,id:"manualRuleId",height:"22",editorType:"TextEditor",nullable:false},
					{lineBreak:false,name:"testPaperId",caption:"试卷ID",labelWidth:120,readOnly:false,id:"testPaperId",height:"22",editorType:"TextEditor"},
					{lineBreak:false,name:"examTypeId",caption:"试题类型ID",labelWidth:120,readOnly:false,id:"examTypeId",height:"22",editorType:"TextEditor"},
					{lineBreak:false,name:"examIds",caption:"试题ID集合",labelWidth:120,readOnly:false,id:"examIds",height:"22",editorType:"TextEditor"},
					{lineBreak:false,name:"delFlag",caption:"删除标记",labelWidth:120,readOnly:false,id:"delFlag",value:"0",height:"22",editorType:"TextEditor"}
				]
			],
			entityContainer: formEntityContainer
		});
		
		_HSplitArea1.addControl(_DataForm);
	}
	
	function _init_Window() {		
		if(_Window == null || ((_Window.reusable==false) && _Window.disposed==true)) {
			_Window = manualrule.context.windowManager.create({
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