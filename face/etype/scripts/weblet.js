
$import("mx.containers.VSplit");				
$import("mx.containers.Container");				
$import("mx.datacontrols.DataTree");
$import("mx.datacontainers.TreeEntityContainer");				
$import("mx.datacontrols.DataGrid");
$import("mx.datacontainers.GridEntityContainer");
$import("mx.datacontrols.PageNaviBar");				
$import("mx.controls.ToolBar");				
$import("mx.windows.Window");				
$import("etype.views.ExamTypeGridView");				
$import("etype.views.ExamTypeGridViewController");				
$import("etype.views.ExamTypeGridViewUserController");				
$import("mx.containers.HSplit");				
$import("mx.datacontrols.DataForm");
$import("mx.datacontainers.FormEntityContainer");				
$import("etype.views.ExamTypeFormView");				
$import("etype.views.ExamTypeFormViewController");				
$import("etype.views.ExamTypeFormViewUserController");				

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