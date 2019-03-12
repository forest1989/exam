$ns("testpaper.views");

//testpaper、TestPaperFormView在编译时将自动替换为实际值，设计过程中不要随意修改

testpaper.views.ExamInfoGridViewController = function(){
	var me = $extend(mx.views.ViewController);
	me.typeName="testpaper.views.TestPaperFormViewController";

	
	return me.endOfClass(arguments);
};