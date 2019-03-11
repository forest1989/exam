$ns("testpaper.views");

//testpaper、TestPaperGridView在编译时将自动替换为实际值，设计过程中不要随意修改

testpaper.views.TestPaperGridViewController = function(){
	var me = $extend(mx.views.ViewController);
	me.typeName="testpaper.views.TestPaperGridViewController";
	me.getController=function(key){
		return me.getLinkViewController("testpaper.views."+key+"Controller");
	};
	me.getView = function(){
		if (me.view == null){
			me.view = new testpaper.views.TestPaperGridView({ controller: me });
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
	me._onactivate = function(e){
		dataGrid = me.getView().findControlById("DataGrid");
		dataGrid.load();		
	};

	/**
     * 新增
     */
	me._NewButton_onclick = function() {
		var detailController = me.getController("TestPaperFormView");
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
		var detailController = me.getController("TestPaperFormView");
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
	
	
	return me.endOfClass(arguments);
};