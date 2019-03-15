$ns("etype.views");

//etype、ExamTypeGridView在编译时将自动替换为实际值，设计过程中不要随意修改

etype.views.ExamTypeGridViewController = function(){
	var me = $extend(mx.views.ViewController);
	me.typeName="etype.views.ExamTypeGridViewController";
	me.getController=function(key){
		return me.getLinkViewController("etype.views."+key+"Controller");
	};
	me.getView = function(){
		if (me.view == null){
			me.view = new etype.views.ExamTypeGridView({ controller: me });
		}
		return me.view;
	};
	
	/*************公共函数库定义****************************/
	//引入外部定义的公共函数库,me.getLinkViewController、me.getController二选其一	
	//me.utils=me.getController("abcView").utils;
	//me.utils=me.getLinkViewController("aaWeblet.views.bbViewController").utils;
	if(typeof(me.utils)=="undefined"||me.utils==null)
		me.utils={};
	/*************公共函数*******************************/
	/*展示详细信息View对话框*/
	me.utils.showDetailViewWindow = function(primaryValue,detailController,formId,title){		
		var detailForm = detailController.getView().findControlById(formId);
		detailForm.load(primaryValue);
		var _win = detailController.getView().getWindow();	
		if(typeof(title) == "string")
			_win.setTitle(title);
		_win.showDialog();
	};
	/*移除DataGrid的选中记录*/
	me.utils.removeDataGridSelections = function(datagrid){
		if(datagrid.displayCheckBox) {//数据项之前带选择框
			if (datagrid.getCheckedItems().length == 0) {
	        	mx.indicate("info", "请至少勾选一条待删除记录。");
	            return;
	        }
			if (confirm("您确认删除数据吗？")) {
				datagrid.removeItems(datagrid.getCheckedItems());
			}
		}else {//数据项之前不带选择框
			if(datagrid.selection == null) {
				mx.indicate("info", "请选择一条待删除记录。");
	            return;
			}
			if (confirm("您确认删除数据吗？")) {
				datagrid.removeItem(datagrid.selection);
			}
		}
	};
	/*************公共函数库结束****************************/
	
	var dataGrid = null;
	var _DataTree = null;
	me._onactivate = function(e){
		dataGrid = me.getView().findControlById("DataGrid");
		dataGrid.load();
		// 加载dataTree
		_DataTree = me.getView().findControlById("DataTree");
		_DataTree.load();
	};
	
	me._DataTree_onnodeclick = function(e) {
		var _grid = me.view.findControlById("DataGrid");
    	
    	if (_grid == null) return;
		//响应左侧树某一类节点的单击操作，在右侧展示相关表单信息。
    	if (e.node.itemType == "examType") {
			selectedNode = e.node;
			dataGrid.objID = e.node.id;
			//debugger;
			//alert(dataGrid.objID); 
			dataGrid.load(dataGrid.objID);    
    	}
	};
	
	/**
     * 新增
     */
	me._NewButton_onclick = function() {
		var detailController = me.getController("ExamTypeFormView");
		me.utils.showDetailViewWindow(null, detailController, "DataForm");
	};

	/**
     * 删除
     */
	me._DelButton_onclick = function() {
		me.utils.removeDataGridSelections(dataGrid);
	};
	
	/**
     * 修改
     */
	me._EditButton_onclick = function() {
		if(dataGrid.selection == null) {
			mx.indicate("info", "请选择一条待编辑记录。");
			return;
		}
		
		var primaryKey = dataGrid.entityContainer.primaryKey;
		var primaryValue = dataGrid.selection.getValue(primaryKey);
		var detailController = me.getController("ExamTypeFormView");
		me.utils.showDetailViewWindow(primaryValue, detailController, "DataForm");
	};
	
	/**
     * 双击进行修改
     */
	me._DataGrid_onitemdoubleclick = function(e){
		me._EditButton_onclick();
	};
	
	/**
     * 打印
     */
	me._PrintButton_onclick = function(e) {
		dataGrid.printGrid(true);
	};
	
	
	me._ToolBar3_btn_add_onclick = function(e)	{
		var detailController = me.getController("ExamTypeFormView");
		me.utils.showDetailViewWindow(null, detailController, "DataForm");
	};

	me._ToolBar3_btn_update_onclick = function(e)	{
		if(dataGrid.selection == null) {
			mx.indicate("info", "请选择一条待编辑记录。");
			return;
		}
		
		var primaryKey = dataGrid.entityContainer.primaryKey;
		var primaryValue = dataGrid.selection.getValue(primaryKey);
		var detailController = me.getController("ExamTypeFormView");
		me.utils.showDetailViewWindow(primaryValue, detailController, "DataForm");
	};

	me._ToolBar3_btn_delete_onclick = function(e)	{
		me.utils.removeDataGridSelections(dataGrid);
	};

	me._ToolBar3_btn_query_onclick = function(e)	{

	};

	return me.endOfClass(arguments);
};