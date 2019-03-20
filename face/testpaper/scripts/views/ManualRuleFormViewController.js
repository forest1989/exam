$ns("testpaper.views");

//manualrule、ManualRuleFormView在编译时将自动替换为实际值，设计过程中不要随意修改

testpaper.views.ManualRuleFormViewController = function(){
	var me = $extend(mx.views.ViewController);
	me.typeName="testpaper.views.ManualRuleFormViewController";
	me.getController=function(key){
		return me.getLinkViewController("testpaper.views."+key+"Controller");
	};
	me.getView = function(){
		if (me.view == null){
			me.view = new testpaper.views.ManualRuleFormView({ controller: me });
		}
		return me.view;
	};
	
	
	var detailForm = null;
	me._onactivate = function(e){
		detailForm = me.getView().findControlById("DataForm");
		testpaper.manualRuleFormView_DataForm=detailForm;
		
		var mainViewController = me.getController("ManualRuleGridView");
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
	//事件处理函数写在这里
	me._selectButton_onclick = function() {
		var detailController = me.getController("ExaminfoGridView");
		console.log("detailController:"+detailController);
		var _win = detailController.getView().getWindow();	
		_win.showDialog();
		
		
		
		
		
		
	};
	
	
	return me.endOfClass(arguments);
};