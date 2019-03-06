
$import("mx.containers.HSplit");				
$import("mx.containers.Container");				
$import("mx.controls.ToolBar");				
$import("mx.datacontrols.DataGrid");
$import("mx.datacontainers.GridEntityContainer");
$import("mx.datacontrols.PageNaviBar");				
$import("mx.windows.Window");				
$import("rguser.views.MUserGridView");				
$import("rguser.views.MUserGridViewController");				
$import("rguser.views.MUserGridViewUserController");				

mx.weblets.WebletManager.register(
{
    id: "rguser",
    name: "rguser",
    requires: [],
    onload: function (e) {
		
    }, 
    onstart: function (e) {
    	var mvc = new rguser.views.MUserGridViewUserController();
		e.context.rootViewPort.setViewController(mvc);
    }
});