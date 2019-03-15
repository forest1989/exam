$ns("etype.views");

etype.views.ExamTypeGridView=function(){
	var me = $extend(mx.views.View);
	var base = {};
	base.init = me.init;
	me.init = function () {
		me.permissionID = "-1";
		base.init();
		_initControls();
	};
	
	//----声明mx组件变量------
	var _VSplit2 = null;
	var _VSplit2Area0 = null;
	var _DataTree = null;
	var _VSplit2Area1 = null;
	var _DataGrid = null;
	var _ToolBar3 = null;
	var _Window = null;
	
	function _initControls(){
		//---调用初始化函数-----
		_init_VSplit2();
		_init_VSplit2Area0();
		_init_DataTree();
		_init_VSplit2Area1();
		_init_DataGrid();
		_init_ToolBar3();
	  
		me.on("activate", me.controller._onactivate);
	}
	
	//-----定义初始化函数-----
	function _init_VSplit2(){
		_VSplit2=new mx.containers.VSplit({orientation:"vertical",width:"100%",id:"VSplit2",cols:"20%,80%",height:"100%"});
		me.addControl(_VSplit2);
	}
	
	function _init_VSplit2Area0(){
		_VSplit2Area0 = new mx.containers.Container({
			layout:"mx.layouts.AbsoluteLayout",
			id:"VSplit2Area0"
		});
		
		_VSplit2.addControl(_VSplit2Area0, 0);
	}
	function _init_DataTree(){
    	var treeEntityContainer = new mx.datacontainers.TreeEntityContainer({
            baseUrl: etype.mappath("~/rest/examTypeTree/tree"),
            type:"remote"
        });
		_DataTree = new mx.datacontrols.DataTree({
			loadRootNodes:_DataTree_RootNodes,
			size:"[宽:100% 高:100%]",
			top:"-2",
			left:"1",
			width:"100%",
			x:"1",
			y:"-2",
			id:"DataTree",
			showDefaultContextMenu:false,
			height:"100%",
			entityContainer: treeEntityContainer
		});
		// 默认展开第一个节点
		_DataTree.load({}, function(){
			_DataTree.findNode("li:first-child").expand(function(){
			});
        });
		_DataTree.on("nodeclick",me.controller._DataTree_onnodeclick);
		_DataTree.on("expanding",_DataTree_expanding);
		_DataTree.on("menushowing",_DataTree_menushowing);
		_VSplit2Area0.addControl(_DataTree);
	}
	
	function _contextMenuItem_click(e){
	    mx.indicate("info", "您双击了我" );
	}
	function _DataTree_RootNodes() {
		var rootNodes = {nodes:[
				{
					itemType:"examType",
					classDisplayName:"ExamType",
					nodeTextProp:"typeName",
					className:"ExamType",
					nodeIDProp:"examTypeId",
					displayMode:"entityNode",
					nodes:[]
				}
		]};
		
		_DataTree.load(rootNodes);
	}
	
	function _DataTree_expanding(args) {
		var node = args.node;
		var params = null;
		node.queryParams = params;
	};
	
	var _DataTree_menushowing = function(p_args){
		var node = p_args.node;
	};
	
	function _init_VSplit2Area1(){
		_VSplit2Area1 = new mx.containers.Container({
			layout:"mx.layouts.AbsoluteLayout",
			id:"VSplit2Area1"
		});
		
		_VSplit2.addControl(_VSplit2Area1, 1);
	}
	
	function _init_DataGrid(){
		var gridEntityContainer = new mx.datacontainers.GridEntityContainer({
			baseUrl:etype.mappath("~/rest/examType/"),
			loadMeta:false,
			iscID:"-1",
			primaryKey:"examTypeId"
		});
		
		_DataGrid = new mx.datacontrols.DataGrid({
			searchBox:new mx.datacontrols.DataGridSearchBox({
				width:"100%",
				id:"DataGridSearchBox1",
				fields:[
					{lineBreak:false,valueType:"string",name:"typeName",caption:"分类名称",labelWidth:100,readOnly:false,id:"typeName",editorType:"TextEditor",height:"22"},
					{lineBreak:false,valueType:"string",name:"typeCode",caption:"分类编码",labelWidth:100,readOnly:false,id:"typeCode",editorType:"TextEditor",height:"22"}
    			]
			}),
			columns:[
				{valueType:"string",dataType:"string",name:"parentId",width:"120",caption:"上级分类",readOnly:false,id:"parentId",editorType:"DropDownEditor"},
				{valueType:"string",dataType:"string",name:"typeName",width:"120",caption:"分类名称",readOnly:false,id:"typeName",editorType:"TextEditor",nullable:false},
				{valueType:"string",dataType:"string",name:"typeCode",width:"120",caption:"分类编码",readOnly:false,id:"typeCode",editorType:"TextEditor",nullable:false},
				{valueType:"string",dataType:"string",name:"remarks",width:"120",caption:"备注",textMode:"multiline",readOnly:false,id:"remarks",editorType:"TextEditor"}
			],
			
			allowEditing:false,
			allowPaging:true,
			pageSize:20,
			pageIndex:1,
			width:"100%",
			layoutConfigs:{left:1,top:28},
			displayCheckBox:true,
			id:"DataGrid",
			height:"93%",
			pageNaviBar:new mx.datacontrols.PageNaviBar({
				pageIndex:1,
				pageSize:20,
				id:"PageNaviBar1"
			}),
			entityContainer: gridEntityContainer
		});
		
		_VSplit2Area1.addControl(_DataGrid);
	}
	
	function _init_ToolBar3(){		
		_ToolBar3 = new mx.controls.ToolBar({
			itemAlign:"right",
			width:"100%",
			layoutConfigs:{left:-2,top:-1},
			id:"ToolBar3",
			direction:"horizontal",
			height:"30",
			items:[
				{imageKey:"add",name:"NewButton",width:"60",id:"ToolBarItem5",text:"新增",height:"20",onclick:me.controller._NewButton_onclick},
				{imageKey:"edit",width:"60",id:"ToolBarItem6",text:"编辑",droppedDown:false,useSymbol:true,height:"20",onclick:me.controller._EditButton_onclick},
				{imageKey:"delete",name:"DelButton",width:"60",id:"ToolBarItem7",text:"删除",height:"20",onclick:me.controller._DelButton_onclick}
			]
		});
		
		_VSplit2Area1.addControl(_ToolBar3);
	}
	
	function _init_Window() {		
		if(_Window == null || ((_Window.reusable==false) && _Window.disposed==true)) {
			_Window = etype.context.windowManager.create({
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
	

	/**
	 * 对于自嵌套实体节点，获取该类节点第一层过滤条件
	 * @param filter 对应于设计时属性selfLoopTopFilter的值
	 * @param itemtype 当前节点的类型标示
	 * @param pnode 当前节点的父节点
	 * @param hasPropGroup 该实体节点是否有属性分组
	 */
	function _resolveLoopEntityNodeTopFilter(filter, itemtype, pnode, hasPropGroup) {
		if(filter == "") return "";
		if(hasPropGroup) filter = filter + " and ";
		
		var _node = _getParentInstantTreeNode(pnode);
		if(_node == null) return filter;
		if(_node.itemType == itemtype) {
			return "";
		}
		return filter;
	}

	/**
	 * 获取当前节点所属的实体节点(entityNode)或枚举节点(enumNode)，
	 * 如果当前节点是实体节点或枚举节点，则直接返回。
	 * @param node 当前节点
	 */
	function _getParentInstantTreeNode(node) {
		if(node == null) return "";
		if(node.displayMode == "entityNode" || node.displayMode == "enumNode") return node;
		
		while(node && node.getParentNode()) {
			if(node.getParentNode().displayMode == "entityNode" 
					|| node.getParentNode().displayMode == "enumNode") {
				return node.getParentNode();
			}
			node = node.getParentNode();
		}
		return null;
	}

	/**
	 * 获取当前节点所属的实体节点(entityNode)或枚举节点(enumNode)的id值
	 * @param node 当前节点
	 */
	function _getParentInstantTreeNodeID(node) {
		var pnode = _getParentInstantTreeNode(node);
		if(pnode == null) return "";
		else return pnode.id;
	}

	/**
	 * 获取与上级节点相关联的实体属性
	 * @param foreignKeyProp 对应设计时属性foreignKeyProp
	 * @param selfLoopProp  对应设计时属性selfLoopProp
	 * @param itemtype 当前节点的类型标示
	 * @param pnode 当前节点的父节点
	 */
	function _resolveforeignKeyProp(foreignKeyProp, selfLoopProp, itemtype, pnode) {
		var _node = _getParentInstantTreeNode(pnode);
		if(_node == null) return foreignKeyProp;
		if(_node.itemType == itemtype) {
			return selfLoopProp;
		}
		return foreignKeyProp;
	}
	
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