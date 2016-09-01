function registerUser(){
	//Reset messages
    resetMessages();
    
    if (!$("#fullName").val()) {
        showErrorMessage("Please specify Full Name");
        return;
    }
    if (!$("#fatherName").val()) {
        showErrorMessage("Please specify Father Name");
        return;
    }
    if (!$("#mobileNo").val()) {
        showErrorMessage("Please specify mobile No.");
        return;
    }
    var phoneno = /^\d{10}$/;
    if(!$("#mobileNo").val().match(phoneno)){
    	showErrorMessage("Please enter mobile of 10 digits.");
    	return;  
    }  
  
    if (!$("#emailId").val()) {
        showErrorMessage("Please specify Email Id");
        return;
    }
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if(!$("#emailId").val().match(re)){
    	showErrorMessage("Please enter valid email Id");
    	return;  
    }  
    
    if (!$("#inputPassword").val()) {
        showErrorMessage("Please specify Password");
        return;
    }
    if (!$("#confirmPassword").val()) {
        showErrorMessage("Please specify Confirm Password");
        return;
    }
    
    if($("#inputPassword").val() != $("#confirmPassword").val()){
    	showErrorMessage("Password and Confirm Password did not match");
        return;
    }
    
    //password between 7 to 15 characters which contain at least one numeric digit and a special character
    var paswd=  /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$/;  
    if(!$("#inputPassword").val().match(paswd))   
    {   
    	showErrorMessage("Please enter password between 7 to 15 characters which contain at least one numeric digit and a special character");
    	return;  
    }  
    
    if (!$("#countryName").val()) {
        showErrorMessage("Please specify Country Name");
        return;
    }
    if (!$("#state").val()) {
        showErrorMessage("Please specify State Name");
        return;
    }
    if (!$("#distt").val()) {
        showErrorMessage("Please specify District Name");
        return;
    }
   
    if (!$("#dob").val()) {
        showErrorMessage("Please specify Date of birth");
        return;
    }
    
    var role = $('input:radio[name=optradio]:checked').val();
    if(role == null){
    	showErrorMessage("Please specify Role");
        return;
    }
    
    if (!$("#address").val()) {
        showErrorMessage("Please specify Address");
        return;
    }
    
    var gender = $('input:radio[name=optionsRadios]:checked').val();
    if(gender == null){
    	showErrorMessage("Please specify Gender");
        return;
    }
    
    var request = new RegisterdUser();
    
    request.set("fullName" , $("#fullName").val());
    request.set("fatherName" , $("#fatherName").val());
    request.set("mobileNo", $("#mobileNo").val());
    request.set("emailId", $("#emailId").val());
    request.set("inputPassword", $("#inputPassword").val());
    request.set("confirmPassword", $("#confirmPassword").val());
    request.set("countryName", $("#countryName").val());
    request.set("state", $("#state").val());
    request.set("distt", $("#distt").val());
    
    var startDateParts = $("#dob").val().split('-');
    var dob = startDateParts[2]+'-'+startDateParts[1]+'-'+ startDateParts[0];
    request.set("dob", dob);
   
    request.set("role", role);
    
    request.set("address",$("#address").val());
    
    request.set("gender",gender);
    
    request.save(null, {
        success: registrationDone,
        error: requestFailed
    });
}

function registrationDone(data){
	if (data.get("Status") == "SUCCESS")
    {
		alert(data.get("Reason"));
		showLogin();
    }
	else
    {
        showErrorMessage(data.get("Reason"));
    }
}

function requestFailed() {
    showErrorMessage("Request failed");
}
