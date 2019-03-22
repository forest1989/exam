$ns("paperauto.views");

//paperauto、TestPaperGridView在编译时将自动替换为实际值，设计过程中不要随意修改

paperauto.views.TestPaperGridViewController = function(){
	var me = $extend(mx.views.ViewController);
	me.typeName="paperauto.views.TestPaperGridViewController";
	me.getController=function(key){
		return me.getLinkViewController("paperauto.views."+key+"Controller");
	};
	me.getView = function() {
		if(me.view == null) {
			me.view = new paperauto.views.TestPaperGridView({ controller: me });
		}
		return me.view;
	};
	
	/*************公共函数库定义****************************/
	if(typeof(me.utils)=="undefined"||me.utils==null)
		me.utils={};
	/*************公共函数*******************************/	
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
	
	/*展示详细信息View对话框*/
	me.utils.showDetailViewWindow = function(primaryValue,detailController,formId,title){		
		var detailForm = detailController.getView().findControlById(formId);
		detailForm.load(primaryValue);
		var _win=	detailController.getView().getWindow();	
		if(typeof(title) == "string")
			_win.setTitle(title);
		_win.showDialog();
	};
	
	/*主从场景下，为从表创建新记录*/
	me.utils.createSlaveDataGridItem = function(primaryValue,slaveGrid){
		var params = {};
		var cols = slaveGrid.columns;
		var len = cols.length;
		for(var i = 0; i < len; i++) {
			if("value" in cols[i]) {
				params[cols[i]["name"]] =cols[i]["value"]; 
			}
		}
		var entityContainer = slaveGrid.entityContainer;
		var newItem = entityContainer.create(params);
		entityContainer.setValue(newItem, slaveGrid.filterPropertyForMaster, primaryValue);		
	};
	
	/*主从场景下，根据表单记录为从表创建新记录*/
	me.utils.createSlaveDataGridItem4Form = function(masterForm,slaveGrid){
		if(masterForm.isNew()) {
			mx.indicate("info", "请先保存表单数据！");
			return;
		}
		var primaryValue = masterForm.entityContainer.getValue(masterForm.entityContainer.primaryKey);
		me.utils.createSlaveDataGridItem(primaryValue,slaveGrid);
	};
	
	/*主从场景下，根据表单记录保存从表数据*/
	me.utils.saveSlaveDataGridItems4Form = function(masterForm,slaveGrid){
		if(masterForm.isNew()) {
			mx.indicate("info", "请先保存表单数据！");
			return;
		}
		slaveGrid.save();
	};
	
	/*主从场景下，更新从表记录和工具栏状态*/
	me.utils.syncSlaveDataGrid = function(primaryValue,slaveGrid,slaveToolBar,filterProperty){	
		//if($notEmpty(slaveGrid.searchBox))
			//slaveGrid.searchBox.reset();		
		if(primaryValue==null){		
			slaveToolBar.setEnabled(false);
			slaveGrid.setFilter(null);
			slaveGrid.clearItems();
		}else{
			slaveToolBar.setEnabled(true);	
			if(typeof(filterProperty) != "string")
				filterProperty=slaveGrid.filterPropertyForMaster;
			var obj = jQuery.parseJSON('{"'+filterProperty+'":"'+primaryValue+'"}');
			slaveGrid.setFilter(obj);
			slaveGrid.load();
		}			
	};
	/*主从场景下，根据表单记录同步更新从表记录和工具栏状态*/
	me.utils.syncSlaveDataGrid4Form = function(masterForm,slaveGrid,slaveToolbar){
		var primaryValue = null;
		if(!masterForm.isNew()){
			primaryValue = masterForm.entityContainer.getValue(masterForm.entityContainer.primaryKey);
		}
		me.utils.syncSlaveDataGrid(primaryValue,slaveGrid,slaveToolbar);
	};
	/*************公共函数库结束****************************/
	
	var MainDataGrid = null;
	var DetailViewController = null;
	me._onactivate = function(e) {
		MainDataGrid = me.getView().findControlById("DataGrid");
		MainDataGrid.load();
		DetailViewController = me.getController("TestPaperFormView");
	};

	me._NewButton_onclick = function() {
	    me.utils.showDetailViewWindow(null,DetailViewController,"DataForm","新增");
	};
	
	me._DelButton_onclick = function() {
	    me.utils.removeDataGridSelections(MainDataGrid);
	};

	me._EditButton_onclick = function() {
	    if(MainDataGrid.displayCheckBox) {//数据项之前带选择框
			if (MainDataGrid.getCheckedItems().length > 1 || MainDataGrid.getCheckedItems().length == 0) {
	        	mx.indicate("info", "请勾选一条待编辑记录。");
	            return;
	        }
		}
	    var primaryValue = MainDataGrid.getCheckedItems()[0].id;
	    me.utils.showDetailViewWindow(primaryValue,DetailViewController,"DataForm","编辑");
	};
	
	/**
     * 打印
     */
	me._PrintButton_onclick = function(e) {
		MainDataGrid.printGrid(true);
	};
	
	
	return me.endOfClass(arguments);
};