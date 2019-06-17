/**
 * 表单序列化为json字符串
 */
$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

/**
 * 获得访问根目录
 */
function rootPath() {
    var curWwwPath = window.document.location.href;
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    var localhostPath = curWwwPath.substring(0, pos);
    var projectName = pathName
        .substring(0, pathName.substr(1).indexOf('/') + 1);
    var basePath = localhostPath + projectName;
    return basePath;
}

/**
 * 获取地址路径中的指定参数值
 * 如：http://xxx.xxx.com?id=1  , $.getUrlParam("id") = 1
 * @param name 参数名
 * @returns {*}
 */
$.getUrlParam = function (name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}