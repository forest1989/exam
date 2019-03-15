 
$import("mx.containers.HSplit");				
$import("mx.containers.Container");				
$import("mx.controls.ToolBar");				
$import("mx.datacontrols.DataGrid");
$import("mx.datacontainers.GridEntityContainer");
$import("mx.datacontrols.PageNaviBar");				
$import("mx.windows.Window");				
$import("readtext.views.ReadingTextGridView");				
$import("readtext.views.ReadingTextGridViewController");				
$import("readtext.views.ReadingTextGridViewUserController");				
$import("mx.datacontrols.DataForm");
$import("mx.datacontainers.FormEntityContainer");				
$import("readtext.views.ReadingTextFormView");				
$import("readtext.views.ReadingTextFormViewController");				
$import("readtext.views.ReadingTextFormViewUserController"); 


mx.weblets.WebletManager.register(
{
    id: "readtext",
    name: "readtext",
    requires: [],
    onload: function (e) {
		
    }, 
    onstart: function (e) {
    	var mvc = new readtext.views.ReadingTextGridViewUserController();
		e.context.rootViewPort.setViewController(mvc);
    }
});