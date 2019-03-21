
$import("mx.containers.HSplit");				
$import("mx.containers.Container");				
$import("mx.controls.ToolBar");				
$import("mx.datacontrols.DataGrid");
$import("mx.datacontainers.GridEntityContainer");
$import("mx.datacontrols.PageNaviBar");				
$import("mx.windows.Window");				
$import("paperzd.views.TestPaperGridView");				
$import("paperzd.views.TestPaperGridViewController");				
$import("paperzd.views.TestPaperGridViewUserController");				
$import("mx.datacontrols.DataForm");
$import("mx.datacontainers.FormEntityContainer");				
$import("paperzd.views.TestPaperFormView");				
$import("paperzd.views.TestPaperFormViewController");				
$import("paperzd.views.TestPaperFormViewUserController");				

mx.weblets.WebletManager.register(
{
    id: "paperzd",
    name: "paperzd",
    requires: [],
    onload: function (e) {
		
    }, 
    onstart: function (e) {
    	var mvc = new paperzd.views.TestPaperGridViewUserController();
		e.context.rootViewPort.setViewController(mvc);
    }
});