let base_url;
getUri('lilong');
api = {};
api.testpaper = base_url + 'answers/getPaperList';
api.testpaper = base_url + 'answers/getPaperList';


function getUri(type) {
    var httpPrefix = "http://";
    var ip;

    switch (type) {
        case "quliang":
            ip = "192.168.1.3";
            break;

        case "lilong":
            ip = "192.168.1.9";
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

    base_url = (httpPrefix + ip + ":8080") + "/ise/exam/rest/";

}


function get(url, sucCall, failCall) {
    ajaxNet(url, 'get','', sucCall, failCall);
}


function post(url, data, sucCall, failCall) {
    ajaxNet(url, 'post', data, sucCall, failCall);
}

function ajaxNet(url, netType, data, sucCall, failCall) {
    console.log("url:" + url);
    $.ajax({
        headers: {
            'content-type': 'application/x-www-form-urlencoded'
        },
        data:data,
        url: url,
        dataType: "json",
        type: netType,
        success: function (data) {
            console.log("ajaxHttp_response:" + JSON.stringify(data));
            if(data.successful){
                sucCall(data);
            }
        },
        error: function (xhr, type, errorThrown) {
            console.log("xhr:" + JSON.stringify(xhr));
            console.log("xhr:" + JSON.stringify(type));
            console.log("xhr:" + JSON.stringify(errorThrown));
        },
        async: true
    });

}

