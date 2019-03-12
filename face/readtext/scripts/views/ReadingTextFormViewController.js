$ns("readtext.views");

//readtext、ReadingTextFormView在编译时将自动替换为实际值，设计过程中不要随意修改

readtext.views.ReadingTextFormViewController = function(){
	var me = $extend(mx.views.ViewController);
	me.typeName="readtext.views.ReadingTextFormViewController";
	me.getController=function(key){
		return me.getLinkViewController("readtext.views."+key+"Controller");
	};
	me.getView = function(){
		if (me.view == null){
			me.view = new readtext.views.ReadingTextFormView({ controller: me });
		}
		return me.view;
	};
	
	
	var detailForm = null;
	me._onactivate = function(e){
		detailForm = me.getView().findControlById("DataForm");
		var mainViewController = me.getController("ReadingTextGridView");
		var dataGrid = mainViewController.getView().findControlById("DataGrid");
		detailForm.entityContainer.on("saved", function(e){
		
			me.getView().getWindow().hide();
			dataGrid.load(); 
	
		});
		
	};

	//事件处理函数写在这里
	me._saveButton_onclick = function() {  
		
		console.log("save clicked");  
//		readtext.mappath("~/rest/save/");
		detailForm.save();
	};
	
	
	
	return me.endOfClass(arguments);
};