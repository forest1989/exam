$ns("etTree.views");

etTree.views.ExamTypeTreeView=function(){
	var me = $extend(mx.views.View);
	var base = {};
	base.init = me.init;
	me.init = function () {
		me.permissionID = "-1";
		base.init();
		_initControls();
	};
	
	//----声明mx组件变量------
	var _VSplit = null;
	var _VSplitArea0 = null;
	var _DataTree = null;
	var _VSplitArea1 = null;
	var _HSplit = null;
	var _HSplitArea0 = null;
	var _ToolBar = null;
	var _HSplitArea1 = null;
	var _DataForm = null;
	var _Window = null;
	
	function _initControls(){
		//---调用初始化函数-----
		_init_VSplit();
		_init_VSplitArea0();
		_init_DataTree();
		_init_VSplitArea1();
		_init_HSplit();
		_init_HSplitArea0();
		_init_ToolBar();
		_init_HSplitArea1();
		_init_DataForm();
	  
		me.on("activate", me.controller._onactivate);
	}
	
	//-----定义初始化函数-----
	function _init_VSplit(){
		_VSplit=new mx.containers.VSplit({borderThick:"0",orientation:"vertical",resizable:true,width:"100%",id:"VSplit",cols:"20%,auto",height:"100%"});
		me.addControl(_VSplit);
	}
	
	function _init_VSplitArea0(){
		_VSplitArea0 = new mx.containers.Container({
			id:"VSplitArea0"
		});
		
		_VSplit.addControl(_VSplitArea0, 0);
	}
	
	function _init_DataTree(){
    	var treeEntityContainer = new mx.datacontainers.TreeEntityContainer({
            baseUrl: etTree.mappath("~/rest/examTypeTree/tree"),
            type:"remote"
        });
		_DataTree = new mx.datacontrols.DataTree({
			loadRootNodes:_DataTree_RootNodes,
			width:"100%",
			id:"DataTree",
			nodeMenu:{
                items: [
                    { 
                        name: "new", text: "新建"
                    },    
                    { name: "delete", text: "删除", imageKey: "delete" }  // 使用“~/icons”目录中的“open.png”图片
                ],
                onitemclick: me.controller._contextMenuItem_click
            },
			showDefaultContextMenu:false,
			height:"100%",
			entityContainer: treeEntityContainer
		});
		
		_DataTree.on("nodeclick", me.controller._DataTree_onnodeclick);
		_DataTree.on("expanding",_DataTree_expanding);
		_DataTree.on("menushowing",_DataTree_menushowing);
		_VSplitArea0.addControl(_DataTree);
	}
	
	/**
     * 获取树形控件
     */
    me.getTreeView = function(){
    	return _DataTree;
    }
	function _DataTree_RootNodes() {
		var rootNodes = {nodes:[
				{
					itemType:"70fc383b-622c-4eb7-9ed7-11f09e30e65f",
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
	
	function _init_VSplitArea1(){
		_VSplitArea1 = new mx.containers.Container({
			id:"VSplitArea1"
		});
		
		_VSplit.addControl(_VSplitArea1, 1);
	}
	
	function _init_HSplit(){
		_HSplit=new mx.containers.HSplit({borderThick:"0",padding:"0",orientation:"horizontal",width:"100%",id:"HSplit",rows:"25,auto",height:"100%"});
		_VSplitArea1.addControl(_HSplit);
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
				{imageKey:"save",name:"save",width:"60",toolTip:"保存",id:"saveButton",text:"保存",height:"20",onclick:me.controller._saveButton_onclick}
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
	
	function _init_DataForm(){
		var formEntityContainer = new mx.datacontainers.FormEntityContainer({
			baseUrl:etTree.mappath("~/rest/examType/"),
			loadMeta:false,
			iscID:"-1",
			primaryKey:"examTypeId",
			meta:
			[
				{readOnly:false,nullable:true,visible:true,valueType:"string",name:"parentId",caption:"父级编号"},
				{readOnly:false,nullable:false,visible:true,valueType:"string",name:"typeName",caption:"分类名称"},
				{readOnly:false,nullable:false,visible:true,valueType:"string",name:"typeCode",caption:"分类编码"},
				{readOnly:false,nullable:true,visible:true,valueType:"string",name:"remarks",caption:"备注"}
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
					{lineBreak:false,valueType:"string",name:"parentId",caption:"上级分类",labelWidth:120,readOnly:false,id:"parentId",height:"22",editorType:"DropDownEditor"},
					{lineBreak:false,valueType:"string",name:"typeName",caption:"分类名称",labelWidth:120,readOnly:false,id:"typeName",height:"22",editorType:"TextEditor",nullable:false},
					{lineBreak:false,valueType:"string",name:"typeCode",caption:"分类编码",labelWidth:120,readOnly:false,id:"typeCode",height:"22",editorType:"TextEditor",nullable:false},
					{lineBreak:false,valueType:"string",name:"remarks",caption:"备注",textMode:"multiline",labelWidth:120,readOnly:false,id:"remarks",height:"66",editorType:"TextEditor"}
				]
			],
			entityContainer: formEntityContainer
		});
		
		_HSplitArea1.addControl(_DataForm);
	}
	
	function _init_Window() {		
		if(_Window == null || ((_Window.reusable==false) && _Window.disposed==true)) {
			_Window = etTree.context.windowManager.create({
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