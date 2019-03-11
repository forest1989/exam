$ns("testpaper.views");

testpaper.views.TestPaperFormView=function(){
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
			baseUrl:testpaper.mappath("~/rest/testPaper/"),
			loadMeta:false,
			iscID:"-1",
			primaryKey:"testPaperId",
			meta:
			[
				{readOnly:false,nullable:false,visible:true,valueType:"string",name:"testPaperId",caption:"试卷ID"},
				{readOnly:false,nullable:true,visible:true,valueType:"string",name:"testPaperName",caption:"试卷名称"},
				{readOnly:false,nullable:true,visible:true,valueType:"string",name:"areaId",caption:"区域ID"},
				{readOnly:false,nullable:true,visible:true,valueType:"string",name:"struId",caption:"组织ID"},
				{readOnly:false,nullable:true,visible:true,valueType:"string",caption:"答题时间",name:"answerTime"},
				{readOnly:false,nullable:true,visible:true,valueType:"string",name:"testPaperType",caption:"试卷生成类型"},
				{readOnly:false,nullable:true,visible:false,valueType:"string",name:"remarks",caption:"备注"},
				{readOnly:false,nullable:true,visible:false,valueType:"string",caption:"创建时间",name:"createDate"},
				{readOnly:false,nullable:true,visible:false,valueType:"string",name:"createBy",caption:"创建者"},
				{readOnly:false,nullable:true,visible:false,valueType:"string",name:"updateBy",caption:"更新者"},
				{readOnly:false,nullable:true,visible:false,valueType:"string",caption:"更新时间",name:"updateDate"},
				{readOnly:false,nullable:true,visible:false,valueType:"string",name:"delFlag",caption:"删除标记"}
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
					{lineBreak:false,name:"testPaperId",caption:"试卷ID",labelWidth:120,readOnly:false,id:"testPaperId",height:"22",editorType:"TextEditor",nullable:false},
					{lineBreak:false,name:"testPaperName",caption:"试卷名称",labelWidth:120,readOnly:false,id:"testPaperName",height:"22",editorType:"TextEditor"},
					{lineBreak:false,name:"areaId",caption:"区域ID",labelWidth:120,readOnly:false,id:"areaId",height:"22",editorType:"TextEditor"},
					{lineBreak:false,name:"struId",caption:"组织ID",labelWidth:120,readOnly:false,id:"struId",height:"22",editorType:"TextEditor"},
					{formatString:"yyyy-MM-dd HH:mm:ss",displayTime:true,lineBreak:false,name:"answerTime",caption:"答题开始时间",labelWidth:120,readOnly:false,id:"answerTime",height:"22",editorType:"DateTimeEditor"},
					{formatString:"yyyy-MM-dd HH:mm:ss",displayTime:true,lineBreak:false,name:"answerTimeEnd",caption:"答题结束时间",labelWidth:120,readOnly:false,id:"answerTimeEnd",height:"22",editorType:"DateTimeEditor"},
					{lineBreak:false,name:"testPaperType",caption:"试卷生成类型",labelWidth:120,readOnly:false,id:"testPaperType",height:"22",editorType: "DropDownEditor", displayMember: "name",valueMember: "value",
		            	 items: [
	            	         { name: "手动", value: "1" },
	            	         { name: "自动", value: "2" }
	            	     ]},
					{lineBreak:false,name:"remarks",caption:"备注",labelWidth:120,readOnly:false,id:"remarks",height:"22",editorType:"TextEditor"},
					{formatString:"yyyy-MM-dd HH:mm:ss",displayTime:true,lineBreak:false,name:"createDate",caption:"创建时间",labelWidth:120,readOnly:false,id:"createDate",height:"22",editorType:"DateTimeEditor"},
					{lineBreak:false,name:"createBy",caption:"创建者",labelWidth:120,readOnly:false,id:"createBy",height:"22",editorType:"TextEditor"},
					{lineBreak:false,name:"updateBy",caption:"更新者",labelWidth:120,readOnly:false,id:"updateBy",height:"22",editorType:"TextEditor"},
					{formatString:"yyyy-MM-dd HH:mm:ss",displayTime:true,lineBreak:false,name:"updateDate",caption:"更新时间",labelWidth:120,readOnly:false,id:"updateDate",height:"22",editorType:"DateTimeEditor"},
					{lineBreak:false,name:"delFlag",caption:"删除标记",labelWidth:120,readOnly:false,id:"delFlag",value:"0",height:"22",editorType:"TextEditor"},
					{lineBreak:false,name:"testPaperCategory",caption:"试卷分类",labelWidth:120,readOnly:false,id:"testPaperCategory",height:"22",editorType: "DropDownEditor", displayMember: "name",valueMember: "value",
		            	 items: [
	            	         { name: "信息安全", value: "1" },
	            	         { name: "网络安全", value: "2" }
	            	     ]},
	            	     {lineBreak:false,name:"testPaperLevel",caption:"难易程度",labelWidth:120,readOnly:false,id:"testPaperLevel",height:"22",editorType: "DropDownEditor", displayMember: "name",valueMember: "value",
			            	 items: [
		            	         { name: "容易", value: "1" },
		            	         { name: "偏易", value: "2" },
		            	         { name: "适中", value: "3" },
		            	         { name: "偏南", value: "4" },
		            	         { name: "复杂", value: "5" }
		            	     ]},
		            	     {lineBreak:false,name:"testPaperNum",caption:"试题道数",labelWidth:120,readOnly:false,id:"testPaperNum",height:"22",editorType: "NumberEditor", valueMember: "value",
		            	    	 items: 
			            	         { name: "容易", value: "1" }
			            	     
			            	     }
				]
			],
			entityContainer: formEntityContainer
		});
		
		_HSplitArea1.addControl(_DataForm);
	}
	
	function _init_Window() {		
		if(_Window == null || ((_Window.reusable==false) && _Window.disposed==true)) {
			_Window = testpaper.context.windowManager.create({
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