$ns("testpaper.views");

//testpaper、TestPaperFormView在编译时将自动替换为实际值，设计过程中不要随意修改

testpaper.views.ExamInfoGridViewUserController = function(){

	var me = $extend(testpaper.views.ExamInfoGridViewController);
	
    return me.endOfClass(arguments);

};