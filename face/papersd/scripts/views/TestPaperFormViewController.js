$ns("papersd.views");

//papersd、TestPaperFormView在编译时将自动替换为实际值，设计过程中不要随意修改

papersd.views.TestPaperFormViewController = function(){
	var me = $extend(mx.views.ViewController);
	me.typeName="papersd.views.TestPaperFormViewController";
	me.getController=function(key){
		return me.getLinkViewController("papersd.views."+key+"Controller");
	};
	me.getView = function() {
		if (me.view == null) {
			me.view = new papersd.views.TestPaperFormView({ controller: me });
		}
		return me.view;
	};

	/*************公共函数库定义****************************/
	//引入外部定义的公共函数库,me.getLinkViewController、me.getController二选其一	
	me.utils=me.getController("TestPaperGridView").utils;
	if(typeof(me.utils)=="undefined"||me.utils==null)
		me.utils={};
	/*************公共函数库结束****************************/
	
	var MainViewController = null;
	var DataForm = null;
	var BottomToolBar = null;
	var DataGrid = null;
	
	me._onactivate = function(e) {
  		DataGrid = me.getView().findControlById("DataGrid");
  		var filterProp = DataGrid.filterPropertyForMaster;
  		if($isEmpty(filterProp)) {
  			mx.indicate("info", "从表的外键为空，不能实现主从关联，请检查！");
  			return;
  		}
  		
  		MainViewController = me.getController("TestPaperGridView");
  		DataForm = me.getView().findControlById("DataForm");
  		BottomToolBar = me.getView().findControlById("BottomToolBar");
  		DataForm.entityContainer.on("saved", function(e) {
    		me.utils.syncSlaveDataGrid4Form(DataForm, DataGrid, BottomToolBar);
    		MainViewController.getView().findControlById("DataGrid").load();
    		mx.indicate("info", "保存成功");
  		});
  		
	};
	
	/**
     * 保存表单数据
     */
	me._TopSaveButton_onclick = function() {
	    DataForm.save();
	};

	/**
     * 新增从表记录
     */
	me._BottomNewButton_onclick = function() {
	    me.utils.createSlaveDataGridItem4Form(DataForm,DataGrid);
	};

	/**
     * 删除从表记录
     */
	me._BottomDelButton_onclick = function() {
	    me.utils.removeDataGridSelections(DataGrid);
	};

	/**
     * 保存从表记录
     */
	me._BottomSaveButton_onclick = function() {
	    me.utils.saveSlaveDataGridItems4Form(DataForm, DataGrid);
	};
	
	/**
     * 打印
     */
	me._BottomPrintButton_onclick = function(e) {
		DataGrid.printGrid(true);
	};
	
	/**
     * 表单加载的事件，重置从表状态并加载从表数据
     */
	me._DataForm_onload = function(e)	{
		DataForm = me.getView().findControlById("DataForm");
  		BottomToolBar = me.getView().findControlById("BottomToolBar");
  		DataGrid = me.getView().findControlById("DataGrid");
		me.utils.syncSlaveDataGrid4Form(DataForm, DataGrid, BottomToolBar);
	};

	
	
	return me.endOfClass(arguments);
};