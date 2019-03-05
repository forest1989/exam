
$import("mx.containers.HSplit");				
$import("mx.containers.Container");				
$import("mx.controls.ToolBar");				
$import("mx.datacontrols.DataGrid");
$import("mx.datacontainers.GridEntityContainer");
$import("mx.datacontrols.PageNaviBar");				
$import("mx.windows.Window");				
$import("etype.views.ExamTypeGridView");				
$import("etype.views.ExamTypeGridViewController");				
$import("etype.views.ExamTypeGridViewUserController");				

mx.weblets.WebletManager.register(
{
    id: "etype",
    name: "etype",
    requires: [],
    onload: function (e) {
		
    }, 
    onstart: function (e) {
    	var mvc = new etype.views.ExamTypeGridViewUserController();
		e.context.rootViewPort.setViewController(mvc);
    }
});