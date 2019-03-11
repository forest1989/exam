
$import("mx.containers.VSplit");				
$import("mx.containers.Container");				
$import("mx.datacontrols.DataTree");
$import("mx.datacontainers.TreeEntityContainer");				
$import("mx.containers.HSplit");				
$import("mx.controls.ToolBar");				
$import("mx.datacontrols.DataForm");
$import("mx.datacontainers.FormEntityContainer");				
$import("mx.windows.Window");				
$import("etTree.views.ExamTypeTreeView");				
$import("etTree.views.ExamTypeTreeViewController");				
$import("etTree.views.ExamTypeTreeViewUserController");				

mx.weblets.WebletManager.register(
{
    id: "etTree",
    name: "etTree",
    requires: [],
    onload: function (e) {
		
    }, 
    onstart: function (e) {
    	var mvc = new etTree.views.ExamTypeTreeViewUserController();
		e.context.rootViewPort.setViewController(mvc);
    }
});