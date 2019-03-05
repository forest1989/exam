
$import("mx.containers.VSplit");				
$import("mx.containers.Container");				
$import("mx.datacontrols.DataTree");
$import("mx.datacontainers.TreeEntityContainer");				
$import("mx.containers.HSplit");				
$import("mx.controls.ToolBar");				
$import("mx.datacontrols.DataForm");
$import("mx.datacontainers.FormEntityContainer");				
$import("mx.windows.Window");				
$import("etype.views.ExamTypeTreeView");				
$import("etype.views.ExamTypeTreeViewController");				
$import("etype.views.ExamTypeTreeViewUserController");				

mx.weblets.WebletManager.register(
{
    id: "etype",
    name: "etype",
    requires: [],
    onload: function (e) {
		
    }, 
    onstart: function (e) {
    	var mvc = new etype.views.ExamTypeTreeViewUserController();
		e.context.rootViewPort.setViewController(mvc);
    }
});