
$import("mx.containers.HSplit");				
$import("mx.containers.Container");				
$import("mx.controls.ToolBar");				
$import("mx.datacontrols.DataGrid");
$import("mx.datacontainers.GridEntityContainer");
$import("mx.datacontrols.PageNaviBar");				
$import("mx.windows.Window");				
$import("testpaper.views.TestPaperGridView");				
$import("testpaper.views.TestPaperGridViewController");				
$import("testpaper.views.TestPaperGridViewUserController");				
$import("mx.datacontrols.DataForm");
$import("mx.datacontainers.FormEntityContainer");				
$import("testpaper.views.TestPaperFormView");				
$import("testpaper.views.TestPaperFormViewController");				
$import("testpaper.views.TestPaperFormViewUserController");		

$import("testpaper.views.ExaminfoGridView");
$import("testpaper.views.ExaminfoGridViewController");
$import("testpaper.views.ExaminfoGridViewUserController");

$import("testpaper.views.ManualRuleGridView");
$import("testpaper.views.ManualRuleGridViewController");
$import("testpaper.views.ManualRuleGridViewUserController");

$import("testpaper.views.ManualRuleFormView");
$import("testpaper.views.ManualRuleFormViewController");
$import("testpaper.views.ManualRuleFormViewUserController");

mx.weblets.WebletManager.register(
{
    id: "testpaper",
    name: "testpaper",
    requires: [],
    onload: function (e) {
		
    }, 
    onstart: function (e) {
    	var mvc = new testpaper.views.TestPaperGridViewUserController();
		e.context.rootViewPort.setViewController(mvc);
    }
});