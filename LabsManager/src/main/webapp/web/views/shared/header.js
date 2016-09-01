$(document).ready(function() {
    /*var targetUsername = getCookie("targetUsername");
    $("#targetUsername").html(targetUsername);
    */
});

function logout() {

    //Reset messages
    resetMessages();
    var request = new Logout();
    var targetUsername = getCookie("targetUsername");

    request.set("Username" , targetUsername);

    request.save(null, {
        success: loggedOut,
        error: loggedOutFailed
    });
}

function loggedOut(data) {

    if (data.get("Status") == "SUCCESS")
    {
        showLogin();
    }
    else
    {
        showErrorMessage(data.get("Reason"));
    }
}

function loggedOutFailed() {
    showErrorMessage("AJAX request failed");
}
