__CreateJSPath = function (js) {
    var scripts = document.getElementsByTagName("script");
    var path = "";
    for (var i = 0, l = scripts.length; i < l; i++) {
        var src = scripts[i].src;
        if (src.indexOf(js) != -1) {
            var ss = src.split(js);
            path = ss[0];
            break;
        }
    }
    var href = location.href;
    href = href.split("#")[0];
    href = href.split("?")[0];
    var ss = href.split("/");
    ss.length = ss.length - 1;
    href = ss.join("/");
    if (path.indexOf("https:") == -1 && path.indexOf("http:") == -1 && path.indexOf("file:") == -1 && path.indexOf("\/") != 0) {
        path = href + "/" + path;
    }
    return path;
}


var startPATH = __CreateJSPath("start.js");
startPATH=startPATH.substr(0,startPATH.indexOf("project"));
   

//dtui
document.write('<script src="' + startPATH + 'easy/jquery.min.js" type="text/javascript"></sc' + 'ript>');
document.write('<script src="' + startPATH + 'easy/jquery.easyui.min.js" type="text/javascript" ></sc' + 'ript>'); 
document.write('<script src="' + startPATH + 'easy/locale/easyui-lang-zh_CN.js" type="text/javascript" ></sc' + 'ript>');
document.write('<script src="' + startPATH + 'easy/ext/jquery.ribbon.js" type="text/javascript" ></sc' + 'ript>'); 
document.write('<link href="' + startPATH + 'easy/themes/default/easyui.css" rel="stylesheet" type="text/css" />');
document.write('<link href="' + startPATH + 'easy/themes/icon.css" rel="stylesheet" type="text/css" />');
document.write('<link href="' + startPATH + 'easy/ext/ribbon.css" rel="stylesheet" type="text/css" />');
document.write('<link href="' + startPATH + 'easy/ext/ribbon-icon.css" rel="stylesheet" type="text/css" />');
document.write('<link href="' + startPATH + 'easy/themes/icon.css" rel="stylesheet" type="text/css" />');

 


//skin

var _sys_skin = getCookie("bzSkin");
if (_sys_skin) {
    document.write('<link href="' + startPATH + 'easy/themes/' + _sys_skin + '/easyui.css" rel="stylesheet" type="text/css" />');
}


////////////////////////////////////////////////////////////////////////////////////////
function getCookie(sName) {
    var aCookie = document.cookie.split("; ");
    var lastMatch = null;
    for (var i = 0; i < aCookie.length; i++) {
        var aCrumb = aCookie[i].split("=");
        if (sName == aCrumb[0]) {
            lastMatch = aCrumb;
        }
    }
    if (lastMatch) {
        var v = lastMatch[1];
        if (v === undefined) return v;
        return unescape(v);
    }
    return null;
}

function SetCookie(name,value)
{
var Days = 30; //此 cookie 将被保存 30 天
var exp = new Date();
exp.setTime(exp.getTime() + Days*24*60*60*1000);
document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}
function removeCookie(name){
	
	SetCookie(name, 1, -1);
}