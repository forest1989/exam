let base_url;
getUri('quliang');
api={};
api.testpaper=base_url+'testPaper/';





function getUri(type) {
    var httpPrefix = "http://";
    var ip;

    switch (type) {
        case "quliang":
            ip = "192.168.1.3";
            break;

        case "shaobo":
            ip = "192.168.1.138";
            break;

        case "taoyonggang":
            ip = "10.50.30.244";
            break;

        case "puhua":
            ip = "10.10.220.111";
            break;

        case "diankeyuan":
            ip = "59.1.4.40";
            break;

        case "diankeyuan":
            ip = "59.1.4.40";
            break;

        default:
            ip = "10.50.30.160";

            break
    }

    base_url =  (httpPrefix + ip + ":8080") + "/ise/exam/rest/";

}


function get(url,sucCall,failCall) {
    ajaxNet(url,'get',sucCall,failCall);
}


function post(url,data,sucCall,failCall) {
    ajaxNet(url,'post',data,sucCall,failCall);
}

function ajaxNet(url,netType,data,sucCall,failCall){

    $.ajax({
        url: url,
        data: netType=='post'?"":data,
        dataType: 'jsonp',
        type: netType,
        success: function (data) {
            console.log("ajaxHttp_response:" + JSON.stringify(data));
        },
        error: function (xhr, type, errorThrown) {
            console.log("xhr:" + xhr.toString());

        },
        async: true
    });

}

