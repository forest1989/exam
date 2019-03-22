$ns("wxImages.views");

wxImages.views.WxImageConfGridView=function(){
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
	var _MainToolBar = null;
	var _HSplitArea1 = null;
	var _DataGrid = null;
	var _Window = null;
	
	function _initControls(){
		//---调用初始化函数-----
		_init_HSplit();
		_init_HSplitArea0();
		_init_MainToolBar();
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
	
	function _init_MainToolBar(){		
		_MainToolBar = new mx.controls.ToolBar({
			itemAlign:"right",
			width:"100%",
			layoutConfigs:{},
			id:"MainToolBar",
			direction:"horizontal",
			height:"24",
			items:[
				{imageKey:"add",width:"60",id:"NewButton",text:"新建",droppedDown:false,useSymbol:true,height:"20",onclick:me.controller._NewButton_onclick},
				{imageKey:"delete",width:"60",id:"DelButton",text:"删除",droppedDown:false,useSymbol:true,height:"20",onclick:me.controller._DelButton_onclick},
				{imageKey:"edit",width:"60",id:"EditButton",text:"编辑",droppedDown:false,useSymbol:true,height:"20",onclick:me.controller._EditButton_onclick},
				{imageKey:"print",width:"60",id:"PrintButton",text:"打印",droppedDown:false,useSymbol:true,height:"20",onclick:me.controller._PrintButton_onclick}
			]
		});
		
		_HSplitArea0.addControl(_MainToolBar);
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
			baseUrl:wxImages.mappath("~/rest/wxImageConf/"),
			loadMeta:false,
			iscID:"-1",
			primaryKey:"id"
		});
		
		_DataGrid = new mx.datacontrols.DataGrid({
			columns:[
				{dataType:"string",name:"id",width:"120",caption:"图标序列",readOnly:false,id:"id",editorType:"TextEditor",nullable:false},
				{dataType:"string",name:"wxIdentify",width:"120",caption:"图标标识",readOnly:false,id:"wxIdentify",editorType:"TextEditor"},
				{dataType:"string",name:"wxImage",width:"120",caption:"图标名称",readOnly:false,id:"wxImage",editorType:"TextEditor"}
			],
			
			allowEditing:false,
			allowPaging:true,
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
				id:"PageNaviBar",
				height:"24"
			}),
			entityContainer: gridEntityContainer
		});
		
		_DataGrid.on("itemdoubleclick", me.controller._DataGrid_onitemdoubleclick);
		_HSplitArea1.addControl(_DataGrid);
	}
	
	function _init_Window() {		
		if(_Window == null || ((_Window.reusable==false) && _Window.disposed==true)) {
			_Window = wxImages.context.windowManager.create({
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