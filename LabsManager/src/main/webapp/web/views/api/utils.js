function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) == 0) return c.substring(name.length,c.length);
    }
    return "";
}

function resetMessages() {
	$("#notificationmessages").addClass("collapse");
    $("#info-alert").addClass("collapse");
    $("#error-alert").addClass("collapse");
    $("#info-alert-message").text("");
    $("#error-alert-message").text("");
}

function showErrorMessage(message) {
    $("#info-alert").addClass("collapse");
    $("#info-alert").hide();
    $("#notificationmessages").removeClass("collapse");
    $("#error-alert").show();
    $("#error-alert").removeClass("collapse");
    $("#error-alert-message").text(message);
}

function showInformatioinMessage(message) {
    $("#error-alert").addClass("collapse");
    $("#error-alert").hide();
    $("#notificationmessages").removeClass("collapse");
    $("#info-alert").show();
    $("#info-alert").removeClass("collapse");
    $("#info-alert-message").text(message);
}

function resetValues() {
	$("#age").val =0;
}