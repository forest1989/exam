
$import("mx.containers.HSplit");				
$import("mx.containers.Container");				
$import("mx.controls.ToolBar");				
$import("mx.datacontrols.DataGrid");
$import("mx.datacontainers.GridEntityContainer");
$import("mx.datacontrols.PageNaviBar");				
$import("mx.windows.Window");				
$import("stgl.views.ExaminfoGridView");				
$import("stgl.views.ExaminfoGridViewController");				
$import("stgl.views.ExaminfoGridViewUserController");				

mx.weblets.WebletManager.register(
{
    id: "stgl",
    name: "stgl",
    requires: [],
    onload: function (e) {
		
    }, 
    onstart: function (e) {
    	var mvc = new stgl.views.ExaminfoGridViewUserController();
		e.context.rootViewPort.setViewController(mvc);
    }
});