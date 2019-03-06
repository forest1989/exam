$ns("etype.views");

//etype、ExamTypeFormView在编译时将自动替换为实际值，设计过程中不要随意修改

etype.views.ExamTypeFormViewController = function(){
	var me = $extend(mx.views.ViewController);
	me.typeName="etype.views.ExamTypeFormViewController";
	me.getController=function(key){
		return me.getLinkViewController("etype.views."+key+"Controller");
	};
	me.getView = function(){
		if (me.view == null){
			me.view = new etype.views.ExamTypeFormView({ controller: me });
		}
		return me.view;
	};
	
	
	var detailForm = null;
	me._onactivate = function(e){
		detailForm = me.getView().findControlById("DataForm");
		var mainViewController = me.getController("ExamTypeGridView");
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
	
	
	
	return me.endOfClass(arguments);
};