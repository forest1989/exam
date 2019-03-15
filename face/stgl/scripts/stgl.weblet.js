$import("mx.containers.HSplit");$import("mx.containers.Container");$import("mx.controls.ToolBar");$import("mx.datacontrols.DataGrid");$import("mx.datacontainers.GridEntityContainer");$import("mx.datacontrols.PageNaviBar");$import("mx.windows.Window");$import("stgl.views.ExaminfoGridView");$import("stgl.views.ExaminfoGridViewController");$import("stgl.views.ExaminfoGridViewUserController");$import("mx.datacontrols.DataForm");$import("mx.datacontainers.FormEntityContainer");$import("stgl.views.ExaminfoFormView");
$import("stgl.views.ExaminfoFormViewController");$import("stgl.views.ExaminfoFormViewUserController");mx.weblets.WebletManager.register({id:"stgl",name:"stgl",requires:[],onload:function(){},onstart:function(a){var b=new stgl.views.ExaminfoGridViewUserController;a.context.rootViewPort.setViewController(b)}});$ns("stgl.views");
stgl.views.ExaminfoFormView=function(){function i(){if(a==null||a.reusable==!1&&a.disposed==!0)a=stgl.context.windowManager.create({title:"\u8be6\u7ec6\u4fe1\u606f",reusable:!0});a.on("activate",function(){a.setView(b)});a.on("close",function(){$.each(a.controls,function(b,a){a.$e.detach()})})}var b=$extend(mx.views.View),f={};f.init=b.init;b.init=function(){b.permissionID="-1";f.init();c=new mx.containers.HSplit({borderThick:"0",padding:"0",orientation:"horizontal",width:"100%",id:"HSplit",rows:"25,auto",
height:"100%"});b.addControl(c);d=new mx.containers.Container({layout:"mx.layouts.AbsoluteLayout",id:"HSplitArea0"});c.addControl(d,0);g=new mx.controls.ToolBar({itemAlign:"right",width:"100%",layoutConfigs:{},id:"DetailToolBar",direction:"horizontal",height:"24",items:[{imageKey:"save",width:"60",id:"SaveButton",text:"\u4fdd\u5b58",droppedDown:!1,useSymbol:!0,height:"20",onclick:b.controller._saveButton_onclick}]});d.addControl(g);e=new mx.containers.Container({layout:"mx.layouts.AbsoluteLayout",
id:"HSplitArea1"});c.addControl(e,1);var a=new mx.datacontainers.FormEntityContainer({baseUrl:stgl.mappath("~/rest/examinfo/"),loadMeta:!1,iscID:"-1",primaryKey:"examId",meta:[{readOnly:!1,nullable:!1,visible:!0,valueType:"string",name:"readingId",caption:"\u9605\u8bfb\u5185\u5bb9ID"},{readOnly:!1,nullable:!0,visible:!0,valueType:"string",name:"examContentText",caption:"\u8bd5\u9898\u5185\u5bb9(\u6587\u672c)"},{readOnly:!1,nullable:!0,visible:!0,valueType:"string",name:"examContentImg",caption:"\u8bd5\u9898\u5185\u5bb9(\u56fe\u7247)"},
{readOnly:!1,nullable:!1,visible:!0,valueType:"string",name:"examTypeId",caption:"\u8bd5\u9898\u5206\u7c7b"},{readOnly:!1,nullable:!0,visible:!0,valueType:"string",name:"examAnswer",caption:"\u8bd5\u9898\u7b54\u6848"},{readOnly:!1,nullable:!0,visible:!0,valueType:"string",name:"answerAnalyze",caption:"\u7b54\u6848\u89e3\u6790"},{readOnly:!1,nullable:!1,visible:!0,valueType:"string",name:"examSubject",caption:"\u8bd5\u9898\u7c7b\u578b\u5355\u9009\u591a\u9009"},{readOnly:!1,nullable:!1,visible:!0,valueType:"string",
name:"examGrades",caption:"\u96be\u6613\u7a0b\u5ea6\u96be\u5ea6\u7b49\u7ea7"},{readOnly:!1,nullable:!0,visible:!0,valueType:"string",name:"examMark",caption:"\u8bd5\u9898\u5206\u6570"},{readOnly:!1,nullable:!1,visible:!0,valueType:"string",caption:"\u521b\u5efa\u65f6\u95f4",name:"createDate"},{readOnly:!1,nullable:!1,visible:!0,valueType:"string",name:"updateBy",caption:"\u66f4\u65b0\u8005"}]});h=new mx.datacontrols.DataForm({width:"100%",layoutConfigs:{},id:"DataForm",maxCols:1,height:"100%",fields:[["[\u9ed8\u8ba4]",
!0,{lineBreak:!1,name:"readingId",caption:"\u9605\u8bfb\u5185\u5bb9\u7f16\u7801",labelWidth:120,readOnly:!1,id:"readingId",height:"22",editorType:"DropDownGridEditor",nullable:!1,displayCheckBox:!1,valueColumn:"readingId",displayColumn:"readingCode",dataGrid:{columns:[{name:"readingId",caption:"\u9605\u8bfb\u5185\u5bb9ID",editorType:"TextEditor",visible:!0},{name:"readingCode",caption:"\u9605\u8bfb\u5185\u5bb9\u7f16\u7801",editorType:"TextEditor",visible:!0},{name:"readingText",caption:"\u9605\u8bfb\u6587\u672c\u5185\u5bb9",
editorType:"RichTextEditor",visible:!0}],displayPrimaryKey:!1,pageSize:10,primaryKey:"readingId",width:"300",baseUrl:stgl.mappath("~/rest/readingText/")}},{lineBreak:!1,name:"examContentText",caption:"\u8bd5\u9898\u5185\u5bb9(\u6587\u672c)",labelWidth:120,readOnly:!1,id:"examContentText",height:"100",editorType:"RichTextEditor"},{lineBreak:!1,name:"examContentImg",caption:"\u8bd5\u9898\u5185\u5bb9(\u56fe\u7247)",labelWidth:120,readOnly:!1,id:"examContentImg",height:"100",editorType:"RichTextEditor"},
{lineBreak:!1,name:"examTypeId",caption:"\u8bd5\u9898\u5206\u7c7b",labelWidth:120,readOnly:!1,id:"examTypeId",height:"22",editorType:"DropDownTreeEditor",nullable:!1,displayCheckBox:!1,url:stgl.mappath("~/rest/examTypeTree/tree")},{lineBreak:!1,name:"examAnswer",caption:"\u8bd5\u9898\u7b54\u6848",labelWidth:120,readOnly:!1,id:"examAnswer",height:"22",editorType:"TextEditor"},{lineBreak:!1,name:"answerAnalyze",caption:"\u7b54\u6848\u89e3\u6790",labelWidth:120,readOnly:!1,id:"answerAnalyze",height:"100",
editorType:"RichTextEditor"},{lineBreak:!1,name:"examSubject",caption:"\u8bd5\u9898\u7c7b\u578b\u5355\u9009\u591a\u9009",labelWidth:120,readOnly:!1,id:"examSubject",height:"22",editorType:"DropDownEditor",nullable:!1,displayMember:"name",valueMember:"id",items:[{name:"\u5355\u9009",id:"1"},{name:"\u591a\u9009",id:"2"}]},{lineBreak:!1,name:"examGrades",caption:"\u96be\u6613\u7a0b\u5ea6\u96be\u5ea6\u7b49\u7ea7",labelWidth:120,readOnly:!1,id:"examGrades",height:"22",editorType:"DropDownEditor",nullable:!1,
displayMember:"name",valueMember:"id",items:[{name:"\u5bb9\u6613",id:"01"},{name:"\u504f\u6613",id:"02"},{name:"\u9002\u4e2d",id:"03"},{name:"\u504f\u96be",id:"04"},{name:"\u590d\u6742",id:"05"}]},{lineBreak:!1,name:"examMark",caption:"\u8bd5\u9898\u5206\u6570",labelWidth:120,readOnly:!1,id:"examMark",height:"22",editorType:"TextEditor"},{lineBreak:!1,name:"optionsAText",caption:"\u8bd5\u9898\u9009\u9879A\u5185\u5bb9(\u6587\u672c)",labelWidth:120,readOnly:!1,id:"optionsAText",height:"120",editorType:"RichTextEditor"},
{lineBreak:!1,name:"optionsAImg",caption:"\u8bd5\u9898\u9009\u9879A\u5185\u5bb9(\u56fe\u7247)",labelWidth:120,readOnly:!1,id:"optionsAImg",height:"120",editorType:"RichTextEditor"},{lineBreak:!1,name:"optionsBText",caption:"\u8bd5\u9898\u9009\u9879B\u5185\u5bb9(\u6587\u672c)",labelWidth:120,readOnly:!1,id:"optionsBText",height:"120",editorType:"RichTextEditor"},{lineBreak:!1,name:"optionsBImg",caption:"\u8bd5\u9898\u9009\u9879B\u5185\u5bb9(\u56fe\u7247)",labelWidth:120,readOnly:!1,id:"optionsBText",
height:"120",editorType:"RichTextEditor"},{lineBreak:!1,name:"optionsCText",caption:"\u8bd5\u9898\u9009\u9879C\u5185\u5bb9(\u6587\u672c)",labelWidth:120,readOnly:!1,id:"optionsCImg",height:"120",editorType:"RichTextEditor"},{lineBreak:!1,name:"optionsCImg",caption:"\u8bd5\u9898\u9009\u9879C\u5185\u5bb9(\u56fe\u7247)",labelWidth:120,readOnly:!1,id:"optionsCImg",height:"120",editorType:"RichTextEditor"},{lineBreak:!1,name:"optionsDText",caption:"\u8bd5\u9898\u9009\u9879D\u5185\u5bb9(\u6587\u672c)",
labelWidth:120,readOnly:!1,id:"optionsDImg",height:"120",editorType:"RichTextEditor"},{lineBreak:!1,name:"optionsDImg",caption:"\u8bd5\u9898\u9009\u9879D\u5185\u5bb9(\u56fe\u7247)",labelWidth:120,readOnly:!1,id:"optionsDImg",height:"120",editorType:"RichTextEditor"},{lineBreak:!1,name:"optionsEText",caption:"\u8bd5\u9898\u9009\u9879E\u5185\u5bb9(\u6587\u672c)",labelWidth:120,readOnly:!1,id:"optionsEImg",height:"120",editorType:"RichTextEditor"},{lineBreak:!1,name:"optionsEImg",caption:"\u8bd5\u9898\u9009\u9879E\u5185\u5bb9(\u56fe\u7247)",
labelWidth:120,readOnly:!1,id:"optionsEImg",height:"120",editorType:"RichTextEditor"},{lineBreak:!1,name:"optionsFText",caption:"\u8bd5\u9898\u9009\u9879F\u5185\u5bb9(\u6587\u672c)",labelWidth:120,readOnly:!1,id:"optionsFImg",height:"120",editorType:"RichTextEditor"},{lineBreak:!1,name:"optionsFImg",caption:"\u8bd5\u9898\u9009\u9879F\u5185\u5bb9(\u56fe\u7247)",labelWidth:120,readOnly:!1,id:"optionsFImg",height:"120",editorType:"RichTextEditor"},{formatString:"yyyy-MM-dd HH:mm:ss",displayTime:!0,lineBreak:!1,
name:"createDate",caption:"\u521b\u5efa\u65f6\u95f4",labelWidth:120,readOnly:!1,id:"createDate",height:"22",editorType:"DateTimeEditor",nullable:!1},{lineBreak:!1,name:"updateBy",caption:"\u66f4\u65b0\u8005",labelWidth:120,readOnly:!1,id:"updateBy",height:"22",editorType:"TextEditor",nullable:!1}]],entityContainer:a});e.addControl(h);b.on("activate",b.controller._onactivate)};var c=null,d=null,g=null,e=null,h=null,a=null;b.getWindow=function(){i();return a};b.findControlById=function(a){try{return b.findControl("id",
a)}catch(c){return mx.indicate("info","\u672a\u627e\u5230\u5bf9\u5e94\u7684mx\u63a7\u4ef6:    "+c.message),null}};return b.endOfClass(arguments)};$ns("stgl.views");
stgl.views.ExaminfoFormViewController=function(){var a=$extend(mx.views.ViewController);a.typeName="stgl.views.ExaminfoFormViewController";a.getController=function(b){return a.getLinkViewController("stgl.views."+b+"Controller")};a.getView=function(){if(a.view==null)a.view=new stgl.views.ExaminfoFormView({controller:a});return a.view};var b=null;a._onactivate=function(){b=a.getView().findControlById("DataForm");var c=a.getController("ExaminfoGridView").getView().findControlById("DataGrid");b.entityContainer.on("saved",
function(){a.getView().getWindow().hide();c.load()})};a._saveButton_onclick=function(){b.save()};return a.endOfClass(arguments)};$ns("stgl.views");stgl.views.ExaminfoFormViewUserController=function(){return $extend(stgl.views.ExaminfoFormViewController).endOfClass(arguments)};$ns("stgl.views");
stgl.views.ExaminfoGridView=function(){function j(){var b=new mx.datacontainers.GridEntityContainer({baseUrl:stgl.mappath("~/rest/examinfo/"),loadMeta:!1,iscID:"-1",primaryKey:"examId"});e=new mx.datacontrols.DataGrid({searchBox:new mx.datacontrols.DataGridSearchBox({width:"100%",id:"DataGridSearchBox1",fields:[{lineBreak:!1,valueType:"string",name:"examGrades",caption:"\u96be\u6613\u7a0b\u5ea6",labelWidth:100,readOnly:!1,id:"examGrades",editorType:"DropDownEditor",nullable:!1,displayMember:"name",valueMember:"id",
items:[{name:"\u5bb9\u6613",id:"01"},{name:"\u504f\u6613",id:"02"},{name:"\u9002\u4e2d",id:"03"},{name:"\u504f\u96be",id:"04"},{name:"\u590d\u6742",id:"05"}],height:"22"},{lineBreak:!1,valueType:"string",name:"examSubject",caption:"\u8bd5\u9898\u7c7b\u578b",labelWidth:100,readOnly:!1,id:"examSubject",editorType:"DropDownEditor",nullable:!1,displayMember:"name",valueMember:"id",items:[{name:"\u5355\u9009",id:"1"},{name:"\u591a\u9009",id:"2"}],height:"22"}]}),columns:[{dataType:"clob",name:"examContentText",
width:"120",caption:"\u8bd5\u9898\u5185\u5bb9(\u6587\u672c)",readOnly:!1,id:"examContentText",editorType:"RichTextEditor"},{dataType:"clob",name:"examContentImg",width:"120",caption:"\u8bd5\u9898\u5185\u5bb9(\u56fe\u7247)",readOnly:!1,id:"examContentImg",editorType:"RichTextEditor"},{dataType:"string",name:"examTypeId",width:"120",caption:"\u8bd5\u9898\u5206\u7c7b",readOnly:!1,id:"examTypeId",editorType:"TextEditor"},{dataType:"string",name:"examAnswer",width:"120",caption:"\u8bd5\u9898\u7b54\u6848",
readOnly:!1,id:"examAnswer",editorType:"TextEditor"},{dataType:"string",name:"examSubject",width:"120",caption:"\u8bd5\u9898\u7c7b\u578b\u5355\u9009\u591a\u9009",readOnly:!1,id:"examSubject",editorType:"TextEditor",renderCell:function(a,b){var c=null;a.getValue("examSubject")=="1"?c="\u5355\u9009":a.getValue("examSubject")=="2"&&(c="\u591a\u9009");b.text(c)}},{dataType:"string",name:"examGrades",width:"120",caption:"\u96be\u6613\u7a0b\u5ea6\u96be\u5ea6\u7b49\u7ea7",readOnly:!1,id:"examGrades",editorType:"TextEditor",
renderCell:function(a,b){var c=null;a.getValue("examGrades")=="01"?c="\u5bb9\u6613":a.getValue("examGrades")=="02"?c="\u504f\u6613":a.getValue("examGrades")=="03"?c="\u9002\u4e2d":a.getValue("examGrades")=="04"?c="\u504f\u96be":a.getValue("examGrades")=="05"&&(c="\u590d\u6742");b.text(c)}},{dataType:"clob",name:"answerAnalyze",width:"120",caption:"\u7b54\u6848\u89e3\u6790",readOnly:!1,id:"answerAnalyze",editorType:"RichTextEditor"},{dataType:"string",name:"examMark",width:"120",caption:"\u8bd5\u9898\u5206\u6570",
readOnly:!1,id:"examMark",editorType:"TextEditor"}],allowEditing:!1,allowPaging:!0,pageIndex:1,width:"100%",layoutConfigs:{},pageSize:20,displayCheckBox:!0,id:"DataGrid",height:"100%",pageNaviBar:new mx.datacontrols.PageNaviBar({pageIndex:1,pageSize:20,id:"PageNaviBar",height:"24"}),entityContainer:b});e.on("itemdoubleclick",a.controller._DataGrid_onitemdoubleclick);f.addControl(e)}function k(){if(b==null||b.reusable==!1&&b.disposed==!0)b=stgl.context.windowManager.create({entry:!0});b.on("activate",
function(){b.setView(a)});b.on("close",function(){$.each(b.controls,function(a,b){b.$e.detach()})})}var a=$extend(mx.views.View),h={};h.init=a.init;a.init=function(){a.permissionID="-1";h.init();d=new mx.containers.HSplit({borderThick:"0",padding:"0",orientation:"horizontal",width:"100%",id:"HSplit",rows:"25,auto",height:"100%"});a.addControl(d);g=new mx.containers.Container({layout:"mx.layouts.AbsoluteLayout",id:"HSplitArea0"});d.addControl(g,0);i=new mx.controls.ToolBar({itemAlign:"right",width:"100%",
layoutConfigs:{},id:"MainToolBar",direction:"horizontal",height:"24",items:[{imageKey:"add",width:"60",id:"NewButton",text:"\u65b0\u5efa",droppedDown:!1,useSymbol:!0,height:"20",onclick:a.controller._NewButton_onclick},{imageKey:"delete",width:"60",id:"DelButton",text:"\u5220\u9664",droppedDown:!1,useSymbol:!0,height:"20",onclick:a.controller._DelButton_onclick},{imageKey:"edit",width:"60",id:"EditButton",text:"\u7f16\u8f91",droppedDown:!1,useSymbol:!0,height:"20",onclick:a.controller._EditButton_onclick},
{imageKey:"print",width:"60",id:"PrintButton",text:"\u6253\u5370",droppedDown:!1,useSymbol:!0,height:"20",onclick:a.controller._PrintButton_onclick}]});g.addControl(i);f=new mx.containers.Container({layout:"mx.layouts.AbsoluteLayout",id:"HSplitArea1"});d.addControl(f,1);j();a.on("activate",a.controller._onactivate)};var d=null,g=null,i=null,f=null,e=null,b=null;a.getWindow=function(){k();return b};a.findControlById=function(b){try{return a.findControl("id",b)}catch(d){return mx.indicate("info","\u672a\u627e\u5230\u5bf9\u5e94\u7684mx\u63a7\u4ef6:    "+
d.message),null}};return a.endOfClass(arguments)};$ns("stgl.views");
stgl.views.ExaminfoGridViewController=function(){var a=$extend(mx.views.ViewController);a.typeName="stgl.views.ExaminfoGridViewController";a.getController=function(c){return a.getLinkViewController("stgl.views."+c+"Controller")};a.getView=function(){if(a.view==null)a.view=new stgl.views.ExaminfoGridView({controller:a});return a.view};if(typeof a.utils=="undefined"||a.utils==null)a.utils={};a.utils.showDetailViewWindow=function(a,b,f,d){b.getView().findControlById(f).load(a);a=b.getView().getWindow();typeof d==
"string"&&a.setTitle(d);a.showDialog()};a.utils.removeDataGridSelections=function(a){a.displayCheckBox?a.getCheckedItems().length==0?mx.indicate("info","\u8bf7\u81f3\u5c11\u52fe\u9009\u4e00\u6761\u5f85\u5220\u9664\u8bb0\u5f55\u3002"):confirm("\u60a8\u786e\u8ba4\u5220\u9664\u6570\u636e\u5417\uff1f")&&a.removeItems(a.getCheckedItems()):a.selection==null?mx.indicate("info","\u8bf7\u9009\u62e9\u4e00\u6761\u5f85\u5220\u9664\u8bb0\u5f55\u3002"):confirm("\u60a8\u786e\u8ba4\u5220\u9664\u6570\u636e\u5417\uff1f")&&
a.removeItem(a.selection)};var b=null;a._onactivate=function(){b=a.getView().findControlById("DataGrid");b.load()};a._NewButton_onclick=function(){var b=a.getController("ExaminfoFormView");a.utils.showDetailViewWindow(null,b,"DataForm")};a._DelButton_onclick=function(){a.utils.removeDataGridSelections(b)};a._EditButton_onclick=function(){if(b.selection==null)mx.indicate("info","\u8bf7\u9009\u62e9\u4e00\u6761\u5f85\u7f16\u8f91\u8bb0\u5f55\u3002");else{var c=b.selection.getValue(b.entityContainer.primaryKey),
e=a.getController("ExaminfoFormView");a.utils.showDetailViewWindow(c,e,"DataForm")}};a._DataGrid_onitemdoubleclick=function(){a._EditButton_onclick()};a._PrintButton_onclick=function(){b.printGrid(!0)};return a.endOfClass(arguments)};$ns("stgl.views");stgl.views.ExaminfoGridViewUserController=function(){return $extend(stgl.views.ExaminfoGridViewController).endOfClass(arguments)};