$ns("wxImages.views");

wxImages.views.WxImageConfFormView=function(){
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
			baseUrl:wxImages.mappath("~/rest/wxImageConf/"),
			loadMeta:false,
			iscID:"-1",
			primaryKey:"id",
			meta:
			[
				{readOnly:false,nullable:false,visible:true,valueType:"string",name:"wxIdentify",caption:"图标标识"},
				{readOnly:false,nullable:false,visible:true,valueType:"string",name:"wxImage",caption:"图标名称"}
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
					{lineBreak:false,name:"wxIdentify",caption:"图标标识",labelWidth:120,readOnly:false,id:"wxIdentify",height:"22",editorType:"DropDownEditor",nullable:false,
						displayMember: "name", valueMember: "id",  
						items: [ { name: "头部视图", id: "headerImg" },
							     { name: "专项练习", id: "specialImg" },
							     { name: "模拟试题", id: "mockTestImg" },
							     { name: "专项练习1", id: "specialImg1" },
							     { name: "模拟试题1", id: "mockTestImg1" },
							     { name: "错题本", id: "errorTopicImg" },
							     { name: "错题历史", id: "errorHisImg" }
						       ]}
					,
					{lineBreak:false,name:"wxImage",caption:"图标名称",labelWidth:120,readOnly:false,id:"wxImage",height:"30",editorType:"PictureManagerEditor",filePath:"\examContentImg",
						allowTypes:"jpg,png",displayCheckBox:true,filesLimit:"1",
						windowHeight: 400,
					    windowWidth: 500,
					    width:300,
						height:200,
						name: "wxImage",
			            caption: "图标名称",
			            type: "form",//类型声明为 form
			            uploadMode: "file",//保存方式为file，文件会保存到服务器指定磁盘路径；为blob会保存到数据库的BLOB类型字段中。
			            tableName: "EXAMINFO",//数据对应的表名，必须是数据库中的物理表名
			            primaryKey: "EXAM_ID",//数据表的主键字段名
			            colName: "EXAM_CONTENT_IMG"//当前字段在数据库中的物理名称
			            	}
				]
			],
			entityContainer: formEntityContainer
		});
		
		_HSplitArea1.addControl(_DataForm);
	}
	
	function _init_Window() {		
		if(_Window == null || ((_Window.reusable==false) && _Window.disposed==true)) {
			_Window = wxImages.context.windowManager.create({
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