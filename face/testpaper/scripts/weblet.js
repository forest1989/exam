
$import("mx.containers.HSplit");				
$import("mx.containers.Container");				
$import("mx.controls.ToolBar");				
$import("mx.datacontrols.DataGrid");
$import("mx.datacontainers.GridEntityContainer");
$import("mx.datacontrols.PageNaviBar");				
$import("mx.windows.Window");				
$import("testpaper.views.TestPaperGridView");				
$import("testpaper.views.TestPaperGridViewController");				
$import("testpaper.views.TestPaperGridViewUserController");				
$import("mx.datacontrols.DataForm");
$import("mx.datacontainers.FormEntityContainer");				
$import("testpaper.views.TestPaperFormView");				
$import("testpaper.views.TestPaperFormViewController");				
$import("testpaper.views.TestPaperFormViewUserController");	
$import("testpaper.views.ExamInfoGridView");				
$import("testpaper.views.ExamInfoGridViewController");				
$import("testpaper.views.ExamInfoGridViewUserController");		

mx.weblets.WebletManager.register(
{
    id: "testpaper",
    name: "testpaper",
    requires: [],
    onload: function (e) {
		
    }, 
    onstart: function (e) {
    	var mvc = new testpaper.views.TestPaperGridViewUserController();
		e.context.rootViewPort.setViewController(mvc);
    }
});