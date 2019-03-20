$ns("testpaper.views");

//testpaper、TestPaperFormView在编译时将自动替换为实际值，设计过程中不要随意修改

testpaper.views.TestPaperFormViewController = function(){
	var me = $extend(mx.views.ViewController);
	me.typeName="testpaper.views.TestPaperFormViewController";
	me.getController=function(key){
		return me.getLinkViewController("testpaper.views."+key+"Controller");
	};
	me.getView = function(){
		if (me.view == null){
			me.view = new testpaper.views.TestPaperFormView({ controller: me });
		}
		return me.view;
	};
	
	
	var detailForm = null;
	me._onactivate = function(e){
		detailForm = me.getView().findControlById("DataForm");
		var mainViewController = me.getController("TestPaperGridView");
		var dataGrid = mainViewController.getView().findControlById("DataGrid");
		detailForm.entityContainer.on("saved", function(e){
			me.getView().getWindow().hide();
			dataGrid.load();
		});
		
	};

	//事件处理函数写在这里
	me._saveButton_onclick = function() {
		
		
		detailForm.save();
	};
	
	me._addExaminButton_onclick = function() {
//		var detailController = me.getController("ExaminfoGridView");
//		console.log("detailController:"+detailController);
//		var _win = detailController.getView().getWindow();	
//		_win.showDialog();
		
		var detailController = me.getController("ManualRuleGridView");
//		detailController.load();
		var _win = detailController.getView().getWindow();	
		_win.showDialog();
		
		
//		var detailForm = detailController.getView().findControlById(formId);
//		detailForm.load(primaryValue);
//		var _win = detailController.getView().getWindow();	
//		if(typeof(title) == "string")
//			_win.setTitle(title);
//		_win.showDialog();
		
//		var primaryKey = dataGrid.entityContainer.primaryKey;
//		var primaryValue = dataGrid.selection.getValue(primaryKey);
//		var detailController = me.getController("TestPaperFormView");
//		me.utils.showDetailViewWindow(primaryValue, detailController, "DataForm");
	};
	
	me._queryButton_onclick = function() {
		console.log("_queryButton_onclick");
//		detailForm.save();
	};
	
	
	
	
	return me.endOfClass(arguments);
};