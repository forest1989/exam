
$import("mx.containers.HSplit");				
$import("mx.containers.Container");				
$import("mx.controls.ToolBar");				
$import("mx.datacontrols.DataGrid");
$import("mx.datacontainers.GridEntityContainer");
$import("mx.datacontrols.PageNaviBar");				
$import("mx.windows.Window");				
$import("wxImages.views.WxImageConfGridView");				
$import("wxImages.views.WxImageConfGridViewController");				
$import("wxImages.views.WxImageConfGridViewUserController");				
$import("mx.datacontrols.DataForm");
$import("mx.datacontainers.FormEntityContainer");				
$import("wxImages.views.WxImageConfFormView");				
$import("wxImages.views.WxImageConfFormViewController");				
$import("wxImages.views.WxImageConfFormViewUserController");				

mx.weblets.WebletManager.register(
{
    id: "wxImages",
    name: "wxImages",
    requires: [],
    onload: function (e) {
		
    }, 
    onstart: function (e) {
    	var mvc = new wxImages.views.WxImageConfGridViewUserController();
		e.context.rootViewPort.setViewController(mvc);
    }
});