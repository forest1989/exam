$ns("stgl.views");

stgl.views.ExaminfoGridView=function(){
	var me = $extend(mx.views.View);
	var base = {};
	base.init = me.init;
	me.init = function () {
		me.permissionID = "-1";
		base.init();
		_initControls();
	};
	
	//----声明mx组件变量------
	var _HSplit = null;
	var _HSplitArea0 = null;
	var _MainToolBar = null;
	var _HSplitArea1 = null;
	var _DataGrid = null;
	var _Window = null;
	
	function _initControls(){
		//---调用初始化函数-----
		_init_HSplit();
		_init_HSplitArea0();
		_init_MainToolBar();
		_init_HSplitArea1();
		_init_DataGrid();
	  
		me.on("activate", me.controller._onactivate);
	}
	
	//-----定义初始化函数-----
	function _init_HSplit(){
		_HSplit=new mx.containers.HSplit({borderThick:"0",padding:"0",orientation:"horizontal",width:"100%",id:"HSplit",rows:"25,auto",height:"100%"});
		me.addControl(_HSplit);
	}
	
	function _init_HSplitArea0(){
		_HSplitArea0 = new mx.containers.Container({
			layout:"mx.layouts.AbsoluteLayout",
			id:"HSplitArea0"
		});
		
		_HSplit.addControl(_HSplitArea0, 0);
	}
	
	function _init_MainToolBar(){		
		_MainToolBar = new mx.controls.ToolBar({
			itemAlign:"right",
			width:"100%",
			layoutConfigs:{},
			id:"MainToolBar",
			direction:"horizontal",
			height:"24",
			items:[
				{imageKey:"add",width:"60",id:"NewButton",text:"新建",droppedDown:false,useSymbol:true,height:"20",onclick:me.controller._NewButton_onclick},
				{imageKey:"delete",width:"60",id:"DelButton",text:"删除",droppedDown:false,useSymbol:true,height:"20",onclick:me.controller._DelButton_onclick},
				{imageKey:"edit",width:"60",id:"EditButton",text:"编辑",droppedDown:false,useSymbol:true,height:"20",onclick:me.controller._EditButton_onclick},
				{imageKey:"print",width:"60",id:"PrintButton",text:"打印",droppedDown:false,useSymbol:true,height:"20",onclick:me.controller._PrintButton_onclick}
			]
		});
		
		_HSplitArea0.addControl(_MainToolBar);
	}
	
	function _init_HSplitArea1(){
		_HSplitArea1 = new mx.containers.Container({
			layout:"mx.layouts.AbsoluteLayout",
			id:"HSplitArea1"
		});
		
		_HSplit.addControl(_HSplitArea1, 1);
	}
	
	function _init_DataGrid(){
		var gridEntityContainer = new mx.datacontainers.GridEntityContainer({
			baseUrl:stgl.mappath("~/rest/examinfo/"),
			loadMeta:false,
			iscID:"-1",
			primaryKey:"examId"
		});
		
		_DataGrid = new mx.datacontrols.DataGrid({
			searchBox:new mx.datacontrols.DataGridSearchBox({
				width:"100%",
				id:"DataGridSearchBox1",
				fields:[
					{lineBreak:false,valueType:"string",name:"examGrades",caption:"难易程度",labelWidth:100,readOnly:false,id:"examGrades",editorType:"DropDownEditor",nullable:false,
						displayMember: "name", valueMember: "id",  
						items: [ { name: "容易", id: "01" },
							     { name: "偏易", id: "02" },
							     { name: "适中", id: "03" },
							     { name: "偏难", id: "04" },
						         { name:"复杂", id: "05" }
						       ],height:"22"},
					{lineBreak:false,valueType:"string",name:"examSubject",caption:"试题类型",labelWidth:100,readOnly:false,id:"examSubject",editorType:"DropDownEditor",nullable:false,
									displayMember: "name", valueMember: "id",  
									items: [ { name: "单选", id: "1" }, 
									         { name:"多选", id: "2" }
									       ],height:"22"}
    			]
			}),
			columns:[
				{dataType:"clob",name:"examContentText",width:"120",caption:"试题内容(文本)",readOnly:false,id:"examContentText",editorType:"RichTextEditor"},
				{dataType:"clob",name:"examContentImg",width:"120",caption:"试题内容(图片)",readOnly:false,id:"examContentImg",editorType:"RichTextEditor"},
				{dataType:"string",name:"examAnswer",width:"120",caption:"试题答案",readOnly:false,id:"examAnswer",editorType:"TextEditor"},
				{dataType:"clob",name:"answerAnalyze",width:"120",caption:"答案解析",readOnly:false,id:"answerAnalyze",editorType:"RichTextEditor"},
				{dataType:"string",name:"examSubject",width:"120",caption:"试题类型单选多选",readOnly:false,id:"examSubject",editorType:"TextEditor",
					renderCell: function(p_item, $p_cell) { 
					var value = null;
					if (p_item.getValue("examSubject") == '1') { 
						
						value = "单选";
					}else if(p_item.getValue("examSubject") == '2') { 
						value = "多选";
					}
					$p_cell.text(value);  
				} },
				{dataType:"string",name:"examGrades",width:"120",caption:"难易程度难度等级",readOnly:false,id:"examGrades",editorType:"TextEditor",
					renderCell: function(p_item, $p_cell) { 
						var value = null;
						if (p_item.getValue("examGrades") == '01') { 
							value = "容易";
						}else if(p_item.getValue("examGrades") == '02') { 
							value = "偏易";
						}else if(p_item.getValue("examGrades") == '03') { 
							value = "适中";
						}else if(p_item.getValue("examGrades") == '04') { 
							value = "偏难";
						}else if(p_item.getValue("examGrades") == '05') { 
							value = "复杂";
						}
						$p_cell.text(value);  
					} },
				{dataType:"string",name:"examMark",width:"120",caption:"试题分数",readOnly:false,id:"examMark",editorType:"TextEditor"}
			],
			
			allowEditing:false,
			allowPaging:true,
			pageIndex:1,
			width:"100%",
			layoutConfigs:{},
			pageSize:20,
			displayCheckBox:true,
			id:"DataGrid",
			height:"100%",
			pageNaviBar:new mx.datacontrols.PageNaviBar({
				pageIndex:1,
				pageSize:20,
				id:"PageNaviBar",
				height:"24"
			}),
			entityContainer: gridEntityContainer
		});
		
		_DataGrid.on("itemdoubleclick", me.controller._DataGrid_onitemdoubleclick);
		_HSplitArea1.addControl(_DataGrid);
	}
	
	function _init_Window() {		
		if(_Window == null || ((_Window.reusable==false) && _Window.disposed==true)) {
			_Window = stgl.context.windowManager.create({
				entry:true
			});
		}
		_Window.on("activate", function() {
			_Window.setView(me);
		});
		_Window.on("close", function(e){
		    $.each(_Window.controls, function(i, o){
				o.$e.detach();
			});
		});
	}
	
	me.getWindow = function() {
		_init_Window();
		return _Window;
	};
	
	
	me.findControlById = function(controlId){
		try{
			return me.findControl("id", controlId);
		} catch(err) {
			mx.indicate("info","未找到对应的mx控件:    "+ err.message);
			return null;
		}	
	};
    return me.endOfClass(arguments);
};