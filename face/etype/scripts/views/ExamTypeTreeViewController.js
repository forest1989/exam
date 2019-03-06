$ns("etype.views");

//etype、ExamTypeTreeView在编译时将替换为实际值，设计过程中不要随意修改

etype.views.ExamTypeTreeViewController = function() {
	var me = $extend(mx.views.ViewController);
	me.getView = function() {
		if (me.view == null) {
			me.view = new etype.views.ExamTypeTreeView({ controller: me });
		}
		return me.view;
	};

	var selectedNode = null;
	me._onactivate = function(e) {
		//加载树根节点
		var _DataTree = me.view.findControlById("DataTree");
		_DataTree.loadRootNodes();

		var _form = me.view.findControlById("DataForm");
		_form.entityContainer.on("saved", function(e) {
			mx.indicate("info", "保存成功");
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
	};

	me._DataTree_onnodeclick = function(e) {
		var _form = me.view.findControlById("DataForm");
    	
    	if (_form == null) return;
		//响应左侧树某一类节点的单击操作，在右侧展示相关表单信息。
    	if (e.node.itemType == "2cbe6fa7-e5af-435b-985e-33591d98c795") {
			selectedNode = e.node;
    		//form对象中保存树节点id值
    		_form.objID = e.node.id;
			_form.load(_form.objID);    		
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