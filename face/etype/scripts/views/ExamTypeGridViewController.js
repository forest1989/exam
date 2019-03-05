$ns("etype.views");

//etype、ExamTypeGridView在编译时将替换为实际值，设计过程中不要随意修改

etype.views.ExamTypeGridViewController = function() {
	var me = $extend(mx.views.ViewController);
	me.getView = function() {
		if (me.view == null) {
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
	me._onactivate = function(e) {
		dataGrid = me.getView().findControlById("DataGrid");
		dataGrid.load();
	};

	//事件处理函数写在这里
	me._NewButton_onclick = function(e) {
		dataGrid.appendItem();
	};

	me._SaveButton_onclick = function(e) {
		dataGrid.save();
	};

	me._DelButton_onclick = function(e) {
		me.utils.removeDataGridSelections(dataGrid);
	};
	
	/**
     * 打印
     */
	me._PrintButton_onclick = function(e) {
		dataGrid.printGrid(true);
	};

	return me.endOfClass(arguments);
};