
$import("mx.containers.HSplit");				
$import("mx.containers.Container");				
$import("mx.controls.ToolBar");				
$import("mx.datacontrols.DataGrid");
$import("mx.datacontainers.GridEntityContainer");
$import("mx.datacontrols.PageNaviBar");				
$import("mx.windows.Window");				
$import("papersd.views.TestPaperGridView");				
$import("papersd.views.TestPaperGridViewController");				
$import("papersd.views.TestPaperGridViewUserController");				
$import("mx.datacontrols.DataForm");
$import("mx.datacontainers.FormEntityContainer");				
$import("papersd.views.TestPaperFormView");				
$import("papersd.views.TestPaperFormViewController");				
$import("papersd.views.TestPaperFormViewUserController");				

mx.weblets.WebletManager.register(
{
    id: "papersd",
    name: "papersd",
    requires: [],
    onload: function (e) {
		
    }, 
    onstart: function (e) {
    	var mvc = new papersd.views.TestPaperGridViewUserController();
		e.context.rootViewPort.setViewController(mvc);
    }
});