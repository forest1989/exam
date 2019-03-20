let pageNum=1;
let pageSize=2;
let paperListDataIsSuc=true;

let questionPageNum=1;
let questionPageSize=2;
let questionListDataIsSuc=true;


$(function () {
    ShowPage(0);


    getPaperListData();



    $("#btn-chooser-testpaper").click(function () {
        ShowPage(2);
    });

    $("#addTestPaper").click(function () {
        ShowPage(1);
    });

    $("#addTestPaper-return").click(function () {
        ShowPage(0);
    });

    $("#testPaper-chooser-return").click(function () {
        ShowPage(1);
    });




    $("#pestpaper-gennerate-type").change(function () {

        if ($('#pestpaper-gennerate-type').val() == 0) {
            $('#handler-view').css('display', 'inline');
            // $('#auto-view').css('display','none');
        } else {
            $('#handler-view').css('display', 'none');
        }

    });


    $("#testlist-provious").click(function () {
        if(paperListDataIsSuc){
            if(pageNum>1){
                pageNum--;
            }
            getPaperListData();
        }else{
            alert("暂无数据");
        }
    });

    $("#testlist-next").click(function () {

        if(paperListDataIsSuc){
            pageNum++;
            getPaperListData();
        }else{
            alert("暂无数据");
        }
    });

    $("#questionlist-provious").click(function () {
        if(questionListDataIsSuc){
            if(questionPageNum>1){
                questionPageNum--;
            }
            getQuestionListData();
        }else{
            alert("暂无数据");
        }
    });

    $("#questionlist-next").click(function () {

        if(questionListDataIsSuc){
            questionPageNum++;
            getQuestionListData();
        }else{
            alert("暂无数据");
        }
    });


});

function getPaperListData() {
    get(api.testpaper+"?pageNum="+pageNum+"&pageSize="+pageSize+"&paperName=",function (data) {
        if(data.resultValue.length>0){
            setListData(data);
            paperListDataIsSuc=true;
            $("#curpage").html(pageNum);

        }else{
            paperListDataIsSuc=false;
            alert("暂无数据");
        }
    });
}

function getQuestionListData() {
    get(api.testpaper+"?pageNum="+pageNum+"&pageSize="+pageSize+"&paperName=",function (data) {
        if(data.resultValue.length>0){
            setQuestionListData(data);
            questionListDataIsSuc=true;
            $("#questioncurpage").html(questionPageNum);
        }else{
            questionListDataIsSuc=false;
            alert("暂无数据");
        }
    });
}
function getQuestionTypeOneData() {
    get(api.testpaper+"?pageNum="+pageNum+"&pageSize="+pageSize+"&paperName=",function (data) {
        if(data.resultValue.length>0){
            setQuestionListData(data);
            questionListDataIsSuc=true;
            $("#questioncurpage").html(questionPageNum);
        }else{
            questionListDataIsSuc=false;
            alert("暂无数据");
        }
    });
}



function ShowPage(pageShow) {
    //0显示首页 1试卷生成页面；

            // $('#home').css('display', 'none');
            // $('#testPaperGenerate').css('display', 'none');

    switch (pageShow) {
        case 0:
            $('#home').css('display', 'inline');
            $('#testPaperGenerate').css('display', 'none');
            $('#testPaper-chooser').css('display', 'none');
            break;
        case 1:
            $('#home').css('display', 'none');
            $('#testPaperGenerate').css('display', 'inline');
            $('#testPaper-chooser').css('display', 'none');
            break;
        case 2:
            $('#home').css('display', 'none');
            $('#testPaperGenerate').css('display', 'none');
            $('#testPaper-chooser').css('display', 'inline');
            setQuestionListData();
            break;
    }

}


function setListData(data) {
    console.log("setListData:" + JSON.stringify(data));

    let tableid = $("#tableid");
    tableid.empty();

   let head='<tr class="max-width">' +
        '<td>试卷名称</td>' +
        // '<td>区域ID</td>' +
        '<td>组织ID</td>' +
        '<td>答题时间</td>' +
        '<td>试卷生成类型(自动手动)</td>' +
        '<td>备注</td>' +
        '<td>创建者</td>' +
        '<td>更新者</td>' +
        '</tr>';

    tableid.append(head);
    $.each(data.resultValue, function (i, item) {
        var html = '';
        var html1 = '';

        html1 += "<td >" + item.name + "</td>";
        // html1 += "<td >" + item.areaId + "</td>";
        html1 += "<td >" + item.struid + "</td>";
        html1 += "<td >" + item.astime + "</td>";
        html1 += "<td >" + item.papertype + "</td>";
        html1 += "<td >" + item.remarks + "</td>";
        html1 += "<td >" + item.createby + "</td>";
        html1 += "<td >" + item.updateby + "</td>";

        html += "<tr  class='max-width'>" + html1 + "</tr>";
        console.log("i:" + i);
        tableid.append(html);
    });
}


function setQuestionListData(data) {


    let data1=[{"item1":"试题内容","item2":"试题内容(图片)","item3":"试题类型（单选，多选）","item4":"难易程度（难度等级暂定）"
    ,"item5":"试题分类ID","item6":"试题答案","item7":"答案解析","item8":"试题分数"},{"item1":"试题内容","item2":"试题内容(图片)","item3":"试题类型（单选，多选）","item4":"难易程度（难度等级暂定）"
        ,"item5":"试题分类ID","item6":"试题答案","item7":"答案解析","item8":"试题分数"},{"item1":"试题内容","item2":"试题内容(图片)","item3":"试题类型（单选，多选）","item4":"难易程度（难度等级暂定）"
        ,"item5":"试题分类ID","item6":"试题答案","item7":"答案解析","item8":"试题分数"},{"item1":"试题内容","item2":"试题内容(图片)","item3":"试题类型（单选，多选）","item4":"难易程度（难度等级暂定）"
        ,"item5":"试题分类ID","item6":"试题答案","item7":"答案解析","item8":"试题分数"},{"item1":"试题内容","item2":"试题内容(图片)","item3":"试题类型（单选，多选）","item4":"难易程度（难度等级暂定）"
        ,"item5":"试题分类ID","item6":"试题答案","item7":"答案解析","item8":"试题分数"}];
    console.log("setListData:" + JSON.stringify(data));

    let tableid = $("#table-question");
    tableid.empty();

    let head='<tr class="max-width">' +
        '<td>选择</td>' +

        '<td>试题内容(文本)</td>' +
        '<td>试题内容(图片)</td>' +
        '<td>试题类型（单选，多选）</td>' +
        '<td>难易程度（难度等级暂定）</td>' +
        '<td>试题分类ID</td>' +
        '<td>试题答案</td>' +
        '<td>答案解析</td>' +
        '<td>试题分数</td>' +
        '</tr>';

    tableid.append(head);
    $.each(data1, function (i, item) {
        var html = '';
        var html1 = '';

        html1 += "<td ><input type='checkbox'></td>";
        html1 += "<td >" + item.item1 + "</td>";
        html1 += "<td >" + item.item2 + "</td>";
        html1 += "<td >" + item.item3 + "</td>";
        html1 += "<td >" + item.item4 + "</td>";
        html1 += "<td >" + item.item5 + "</td>";
        html1 += "<td >" + item.item6 + "</td>";
        html1 += "<td >" + item.item7 + "</td>";
        html1 += "<td >" + item.item8 + "</td>";

        html += "<tr  class='max-width'>" + html1 + "</tr>";
        console.log("i:" + i);
        tableid.append(html);
    });
}











// let data = {
//     "successful": true, "resultValue": {
//         "items": [{
//             "testPaperId": 3,
//             "testPaperName": "kaoshi1",
//             "areaId": "1",
//             "struId": "42342342",
//             "answerTime": 60,
//             "testPaperType": "1",
//             "remarks": "wer",
//             "createDate": "2018-10-11 12:11:45",
//             "createBy": "zhangsan",
//             "updateBy": "lisi",
//             "updateDate": "2018-10-11 12:11:45",
//             "delFlag": "d",
//             "mxVirtualId": null
//         }, {
//             "testPaperId": 4,
//             "testPaperName": "kaoshi1",
//             "areaId": "1",
//             "struId": "42342342",
//             "answerTime": 60,
//             "testPaperType": "1",
//             "remarks": "wer",
//             "createDate": "2018-10-11 12:11:45",
//             "createBy": "zhangsan",
//             "updateBy": "lisi",
//             "updateDate": "2018-10-11 12:11:45",
//             "delFlag": "d",
//             "mxVirtualId": null
//         }, {
//             "testPaperId": 5,
//             "testPaperName": "kaoshi1",
//             "areaId": "1",
//             "struId": "42342342",
//             "answerTime": 60,
//             "testPaperType": "1",
//             "remarks": "wer",
//             "createDate": "2018-10-11 12:11:45",
//             "createBy": "zhangsan",
//             "updateBy": "lisi",
//             "updateDate": "2018-10-11 12:11:45",
//             "delFlag": "d",
//             "mxVirtualId": null
//         }, {
//             "testPaperId": 6,
//             "testPaperName": "shiyan1",
//             "areaId": "2",
//             "struId": "3",
//             "answerTime": 50,
//             "testPaperType": "2",
//             "remarks": "daaa",
//             "createDate": "2019-03-13 14:21:28",
//             "createBy": "ssss",
//             "updateBy": "bbbb",
//             "updateDate": "2019-03-13 14:21:32",
//             "delFlag": "0",
//             "mxVirtualId": null
//         }, {
//             "testPaperId": 7,
//             "testPaperName": null,
//             "areaId": null,
//             "struId": null,
//             "answerTime": null,
//             "testPaperType": "2",
//             "remarks": null,
//             "createDate": null,
//             "createBy": null,
//             "updateBy": null,
//             "updateDate": null,
//             "delFlag": "0",
//             "mxVirtualId": null
//         }, {
//             "testPaperId": 9,
//             "testPaperName": "testpaper111",
//             "areaId": "1",
//             "struId": "2",
//             "answerTime": 60,
//             "testPaperType": "1",
//             "remarks": "dfdfd",
//             "createDate": "2019-03-18 12:45:25",
//             "createBy": "aaa",
//             "updateBy": "ssss",
//             "updateDate": "2019-03-18 12:45:28",
//             "delFlag": "0",
//             "mxVirtualId": null
//         }, {
//             "testPaperId": 10,
//             "testPaperName": "testpaper222",
//             "areaId": "2",
//             "struId": "456",
//             "answerTime": 12,
//             "testPaperType": "1",
//             "remarks": "aaaa",
//             "createDate": "2019-03-18 13:37:55",
//             "createBy": "aasss",
//             "updateBy": "aaa",
//             "updateDate": "2019-03-18 13:38:02",
//             "delFlag": "0",
//             "mxVirtualId": null
//         }, {
//             "testPaperId": 11,
//             "testPaperName": "restpaper333",
//             "areaId": "3",
//             "struId": "32",
//             "answerTime": 45,
//             "testPaperType": "1",
//             "remarks": "aa",
//             "createDate": "2019-03-18 13:50:48",
//             "createBy": "fdfd",
//             "updateBy": "aaa",
//             "updateDate": "2019-03-18 13:50:54",
//             "delFlag": "0",
//             "mxVirtualId": null
//         }], "itemCount": 8, "dicts": []
//     }, "resultHint": "", "errorPage": "", "type": ""
// };