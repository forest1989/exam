
$import("mx.containers.HSplit");				
$import("mx.containers.Container");				
$import("mx.controls.ToolBar");				
$import("mx.datacontrols.DataGrid");
$import("mx.datacontainers.GridEntityContainer");
$import("mx.datacontrols.PageNaviBar");				
$import("mx.windows.Window");				
$import("paperauto.views.TestPaperGridView");				
$import("paperauto.views.TestPaperGridViewController");				
$import("paperauto.views.TestPaperGridViewUserController");				
$import("mx.datacontrols.DataForm");
$import("mx.datacontainers.FormEntityContainer");				
$import("paperauto.views.TestPaperFormView");				
$import("paperauto.views.TestPaperFormViewController");				
$import("paperauto.views.TestPaperFormViewUserController");				

mx.weblets.WebletManager.register(
{
    id: "paperauto",
    name: "paperauto",
    requires: [],
    onload: function (e) {
		
    }, 
    onstart: function (e) {
    	var mvc = new paperauto.views.TestPaperGridViewUserController();
		e.context.rootViewPort.setViewController(mvc);
    }
});