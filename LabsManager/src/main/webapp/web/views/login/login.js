function login () {
    //Reset messages
    resetMessages();
   
    //validate user input
    if( !$("#inputUsername").val() ) {
        showErrorMessage("Please specify Username");
        return;
    }

    if( !$("#inputPassword").val() ) {
        showErrorMessage("Please specify Password");
        return;
    }

   // $("#loading").show();
    
    var request = new Login();
    request.set("Password", $("#inputPassword").val());
    request.set("Username" , $("#inputUsername").val());

    request.save(null, {
        success: loggedIn,
        error: loggedInFailed
    });
}

function loggedIn(data) {
	alert("loggedIn");
//	$("#loading").hide();
    if (data.get("Status") == "SUCCESS")
    {
    	setCookie("targetUsername", data.get("Username"), 1);
    	showRegisterPatientPage();
     }
    else
    {
    	alert();
        showErrorMessage(data.get("Reason"));
    }
}

function loggedInFailed() {
	//$("#loading").hide();
    showErrorMessage("Invalid Credentials");
}
