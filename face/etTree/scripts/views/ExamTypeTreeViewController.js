$ns("etTree.views");

//etTree、ExamTypeTreeView在编译时将替换为实际值，设计过程中不要随意修改

etTree.views.ExamTypeTreeViewController = function() {
	var me = $extend(mx.views.ViewController);
	me.getView = function() {
		if (me.view == null) {
			me.view = new etTree.views.ExamTypeTreeView({ controller: me });
		}
		return me.view;
	};

	var selectedNode = null;
	var dataForm = null;
	me._onactivate = function(e) {
		//加载树根节点
		var _DataTree = me.view.findControlById("DataTree");
		_DataTree.loadRootNodes();

		var _form = me.view.findControlById("DataForm");
		_form.entityContainer.on("saved", function(e) {
			mx.indicate("info", "保存成功");
			var _DataTree = me.view.findControlById("DataTree");
			_DataTree.load();
			var nodeTextProp = _form.getEditor("typeName");
			var nodeTextPropValue = null;
			if($notEmpty(nodeTextProp)){
			    nodeTextPropValue = nodeTextProp.getValue();
			}
			if($notEmpty(_DataTree) && $notEmpty(_DataTree.selection)){
				if($notEmpty(nodeTextPropValue)){
					_DataTree.selection.setText(nodeTextPropValue);
				}
			}
		});
		// 加载dataTree
		dataForm = me.getView().findControlById("DataForm");
		dataForm.load();
	};

	me._DataTree_onnodeclick = function(e) {
		var _form = me.view.findControlById("DataForm");
    	
    	if (_form == null) return;
		//响应左侧树某一类节点的单击操作，在右侧展示相关表单信息。
    	if (e.node.itemType == "examType") {
			selectedNode = e.node;
    		//form对象中保存树节点id值
    		_form.objID = e.node.id;
			_form.load(_form.objID);    		
    	}
	};
	
	me._contextMenuItem_click = function(e)
    {
    	switch(e.item.name)
        {
        	case "refresh":
        		_btnRefresh_onclick();
        		break;
			case "new":
				// 加载dataTree
				dataForm = me.getView().findControlById("DataForm");
				dataForm.load();
				break;
			case "delete":
				_btnDelete_onclick();
				break;
        }
    };
    
    function _btnDelete_onclick(){
    	if (me.view.getTreeView().selection)
    	{
    	    var selectedNode = me.view.getTreeView().selection; 
    	    if (selectedNode != null)
    	    {
    	    	if(selectedNode.childNodes.length > 0){
    	    		mx.indicate("info", "请先删除子节点！");
    	    	}else{
    	    		if (confirm("您确认删除数据吗？")) {
        	    		var client = new mx.rpc.RESTClient({
        	    			baseUrl : etTree.mappath("~/rest/examType")
        	    		});
        	    		client.post("/deleteById?id=" + selectedNode.id, function(ret) {
        	    			if (ret.successful) {
        	    				mx.indicate("info", "删除成功！");
        	    				var _DataTree = me.view.findControlById("DataTree");
        	    				_DataTree.load();
        	    				// 加载dataTree
        	    				dataForm = me.getView().findControlById("DataForm");
        	    				dataForm.load();
        	    			} else {
        	    				mx.indicate("info", "删除失败！");
        	    			}
        	    		});  	    	
        	    		//alert(selectedNode.id);
        			}
    	    	}
    	    	
    	    }
    	}
    }
    
    function _btnRefresh_onclick()
    {
        if (me.view.getTreeView().selection)
    	{
    	    var selectedNode =me.view.getTreeView().selection; 
    	    if (selectedNode != null)
    	    {
    	        selectedNode.refresh();
    	    }
    	}
    };
    
    
	/**
     * 保存
     */
	me._saveButton_onclick = function(e) {
		me.view.findControlById("DataForm").save();
	};

	return me.endOfClass(arguments);
};