$(function () {
    ShowPage(1);
    // let param = {
    //     "columns": "testPaperId,testPaperName,areaId,struId,answerTime,testPaperType,remarks,createDate,createBy," +
    //         "updateBy,updateDate,delFlag", "pageIndex": 1, "pageSize": 20
    // };
    //
    // console.log("CONS:" + JSON.stringify(param));
    console.log("CONS11:");

    let data = {
        "successful": true, "resultValue": {
            "items": [{
                "testPaperId": 3,
                "testPaperName": "kaoshi1",
                "areaId": "1",
                "struId": "42342342",
                "answerTime": 60,
                "testPaperType": "1",
                "remarks": "wer",
                "createDate": "2018-10-11 12:11:45",
                "createBy": "zhangsan",
                "updateBy": "lisi",
                "updateDate": "2018-10-11 12:11:45",
                "delFlag": "d",
                "mxVirtualId": null
            }, {
                "testPaperId": 4,
                "testPaperName": "kaoshi1",
                "areaId": "1",
                "struId": "42342342",
                "answerTime": 60,
                "testPaperType": "1",
                "remarks": "wer",
                "createDate": "2018-10-11 12:11:45",
                "createBy": "zhangsan",
                "updateBy": "lisi",
                "updateDate": "2018-10-11 12:11:45",
                "delFlag": "d",
                "mxVirtualId": null
            }, {
                "testPaperId": 5,
                "testPaperName": "kaoshi1",
                "areaId": "1",
                "struId": "42342342",
                "answerTime": 60,
                "testPaperType": "1",
                "remarks": "wer",
                "createDate": "2018-10-11 12:11:45",
                "createBy": "zhangsan",
                "updateBy": "lisi",
                "updateDate": "2018-10-11 12:11:45",
                "delFlag": "d",
                "mxVirtualId": null
            }, {
                "testPaperId": 6,
                "testPaperName": "shiyan1",
                "areaId": "2",
                "struId": "3",
                "answerTime": 50,
                "testPaperType": "2",
                "remarks": "daaa",
                "createDate": "2019-03-13 14:21:28",
                "createBy": "ssss",
                "updateBy": "bbbb",
                "updateDate": "2019-03-13 14:21:32",
                "delFlag": "0",
                "mxVirtualId": null
            }, {
                "testPaperId": 7,
                "testPaperName": null,
                "areaId": null,
                "struId": null,
                "answerTime": null,
                "testPaperType": "2",
                "remarks": null,
                "createDate": null,
                "createBy": null,
                "updateBy": null,
                "updateDate": null,
                "delFlag": "0",
                "mxVirtualId": null
            }, {
                "testPaperId": 9,
                "testPaperName": "testpaper111",
                "areaId": "1",
                "struId": "2",
                "answerTime": 60,
                "testPaperType": "1",
                "remarks": "dfdfd",
                "createDate": "2019-03-18 12:45:25",
                "createBy": "aaa",
                "updateBy": "ssss",
                "updateDate": "2019-03-18 12:45:28",
                "delFlag": "0",
                "mxVirtualId": null
            }, {
                "testPaperId": 10,
                "testPaperName": "testpaper222",
                "areaId": "2",
                "struId": "456",
                "answerTime": 12,
                "testPaperType": "1",
                "remarks": "aaaa",
                "createDate": "2019-03-18 13:37:55",
                "createBy": "aasss",
                "updateBy": "aaa",
                "updateDate": "2019-03-18 13:38:02",
                "delFlag": "0",
                "mxVirtualId": null
            }, {
                "testPaperId": 11,
                "testPaperName": "restpaper333",
                "areaId": "3",
                "struId": "32",
                "answerTime": 45,
                "testPaperType": "1",
                "remarks": "aa",
                "createDate": "2019-03-18 13:50:48",
                "createBy": "fdfd",
                "updateBy": "aaa",
                "updateDate": "2019-03-18 13:50:54",
                "delFlag": "0",
                "mxVirtualId": null
            }], "itemCount": 8, "dicts": []
        }, "resultHint": "", "errorPage": "", "type": ""
    };

    setListData(data);


    $("#addTestPaper").click(function () {
        ShowPage(1);
    });

    $("#addTestPaper-return").click(function () {
        ShowPage(0);
    });


    $("#pestpaper-gennerate-type").change(function () {


        if ($('#pestpaper-gennerate-type').val() == 0) {
            $('#handler-view').css('display', 'inline');
            // $('#auto-view').css('display','none');
        } else {
            $('#handler-view').css('display', 'none');
        }

    });
});


function ShowPage(pageShow) {
    //0显示首页 1试卷生成页面；

            $('#home').css('display', 'none');
            $('#testPaperGenerate').css('display', 'none');

    // switch (pageShow) {
    //     case 0:
    //         $('#home').css('display', 'inline');
    //         $('#testPaperGenerate').css('display', 'none');
    //         break;
    //     case 1:
    //         $('#home').css('display', 'none');
    //         $('#testPaperGenerate').css('display', 'inline');
    //         break;
    // }

}


function setListData(data) {

    console.log("setListData:" + JSON.stringify(data));

    let tableid = $("#tableid");
    $.each(data.resultValue.items, function (i, item) {
        var html = '';
        var html1 = '';

        html1 += "<td >" + item.testPaperName + "</td>";
        html1 += "<td >" + item.areaId + "</td>";
        html1 += "<td >" + item.struId + "</td>";
        html1 += "<td >" + item.answerTime + "</td>";
        html1 += "<td >" + item.testPaperType + "</td>";
        html1 += "<td >" + item.remarks + "</td>";
        html1 += "<td >" + item.createBy + "</td>";
        html1 += "<td >" + item.updateBy + "</td>";

        html += "<tr  class='max-width'>" + html1 + "</td>";

        console.log("i:" + i);
        tableid.append(html);
    });


}






