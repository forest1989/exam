$ns("readtext.views");

readtext.views.ReadingTextFormView=function(){
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
			baseUrl:readtext.mappath("~/rest/readingText/"),
			loadMeta:false,
			iscID:"-1",
			primaryKey:"readingId",
			meta:
			[
				{readOnly:false,nullable:false,visible:true,valueType:"string",name:"readingId",caption:"阅读内容ID"},
				{readOnly:false,nullable:false,visible:true,valueType:"string",name:"readingCode",caption:"阅读内容编码"},
				{readOnly:false,nullable:false,visible:true,valueType:"string",name:"readingImg",caption:"阅读图片内容"},
				{readOnly:false,nullable:false,visible:true,valueType:"string",name:"readingText",caption:"阅读文本内容"}
				/*{readOnly:false,nullable:true,visible:true,valueType:"string",name:"remarks",caption:"备注"},
				{readOnly:false,nullable:true,visible:true,valueType:"string",caption:"创建时间",name:"createDate"},
				{readOnly:false,nullable:true,visible:true,valueType:"string",name:"createBy",caption:"创建者"},
				{readOnly:false,nullable:true,visible:true,valueType:"string",name:"updateBy",caption:"更新者"},
				{readOnly:false,nullable:true,visible:true,valueType:"string",caption:"更新时间",name:"updateDate"},
				{readOnly:false,nullable:true,visible:true,valueType:"string",name:"delFlag",caption:"删除标记"}
			*/] 
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
					{lineBreak:false,name:"readingId",caption:"阅读内容ID",labelWidth:120,readOnly:false,id:"readingId",height:"22",editorType:"TextEditor",nullable:false},
					{lineBreak:false,name:"readingCode",caption:"阅读内容编码",labelWidth:120,readOnly:false,id:"readingCode",height:"22",editorType:"TextEditor",nullable:false},
					{lineBreak:false,name:"readingImg",caption:"阅读图片内容",labelWidth:120,readOnly:false,id:"readingImg",height:"22",editorType:"TextEditor",nullable:false},
					{lineBreak:false,name:"readingText",caption:"阅读文本内容",labelWidth:120,readOnly:false,id:"readingText",height:"100",editorType:"RichTextEditor",nullable:false}
				/*	{lineBreak:false,name:"remarks",caption:"备注",labelWidth:120,readOnly:false,id:"remarks",height:"22",editorType:"TextEditor"},
					{formatString:"yyyy-MM-dd HH:mm:ss",displayTime:true,lineBreak:false,name:"createDate",caption:"创建时间",labelWidth:120,readOnly:false,id:"createDate",height:"22",editorType:"DateTimeEditor"},
					{lineBreak:false,name:"createBy",caption:"创建者",labelWidth:120,readOnly:false,id:"createBy",height:"22",editorType:"TextEditor"},
					{lineBreak:false,name:"updateBy",caption:"更新者",labelWidth:120,readOnly:false,id:"updateBy",height:"22",editorType:"TextEditor"},
					{formatString:"yyyy-MM-dd HH:mm:ss",displayTime:true,lineBreak:false,name:"updateDate",caption:"更新时间",labelWidth:120,readOnly:false,id:"updateDate",height:"22",editorType:"DateTimeEditor"},
					{lineBreak:false,n
					ame:"delFlag",caption:"删除标记",labelWidth:120,readOnly:false,id:"delFlag",value:"0",height:"22",editorType:"TextEditor"}
				*/]
			],
			entityContainer: formEntityContainer
		});
		
		_HSplitArea1.addControl(_DataForm);
	}
	
	function _init_Window() {		
		if(_Window == null || ((_Window.reusable==false) && _Window.disposed==true)) {
			_Window = readtext.context.windowManager.create({
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