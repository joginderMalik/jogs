function showTodaysCustomer() {
	//Reset messages
    resetMessages();

    var request = new PatientDetailsViewModel();

    request.fetch({
    	success: patientDetailsFetched,
        error: requestFailed
    });

}

function patientDetailsFetched(data) {
	if (data.get("Status") == "SUCCESS")
    {
		$('#patientsTable').empty();
    	var json = data.get("patientsList");
    	thead = '<thead><tr style="background-color:white"><th>ID</th><th>First Name</th><th>Last Name</th><th>Mobile</th><th>DOB</th><th>Address</th><th>Date Of Visit</th><th>Action</th></tr></thead>';
    	$('#patientsTable').append(thead);
    	for (var i = 0; i < json.length; i++) {
            tr = $('<tr/>');
            tr.append("<td>" + json[i].patientId + "</td>");
            tr.append("<td>" + json[i].firstName + "</td>");
            tr.append("<td>" + json[i].lastName + "</td>");
            tr.append("<td>" + json[i].mobileNo + "</td>");
            tr.append("<td>" + json[i].dob + "</td>");
            tr.append("<td>" + json[i].address + "</td>");
            tr.append("<td>" + json[i].dateOfVisit + "</td>");
            
            tr.append("<td><a class='right' href='#'>"+ 'Edit Patient' + "</a></td>");
            $('#patientsTable').append(tr);
        }
    }
    /*else
    {
        showErrorMessage(data.get("Reason"));
    }*/
}

function searchPatients(){
	savePatientDetails("searchFirst");
}

function savePatientDetails(param) {
	//Reset messages
    resetMessages();
    
    var checked_option_radio = $('input:radio[name=optionsRadios]:checked').val();
    
    var request = new PatientDetailsViewModel();
    if(param != undefined){
    	request.set("param" , param);
    	request.set("firstName", $("#firstName").val());
    	if (!$("#age").val()) {
            request.set("age", -123);
        } else {
            request.set("age", $("#age").val());
        }

    	if (!$("#dob").val()) {
            request.set("dob", "");
        }
        else {
            request.set("dob", $("#dob").val());
        }
    	
    	if (!$("#emailId").val()) {
    		request.set("emailId", "xxx.xxx@xxx.com");
    	}else{
    		var email = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    	    if(!$("#emailId").val().match(email)){
    	    	showErrorMessage("Please enter valid email Id");
    	    	return;  
    	    }else{
    	    	request.set("emailId", $("#emailId").val());
    	    }
    	}
	    
    	var phoneno = /^\d{10}$/;
    	if (!$("#mobileNo").val()) {
    		request.set("mobileNo", -123);
        }else{
        	if(!$("#mobileNo").val().match(phoneno)){
            	showErrorMessage("Please enter mobile of 10 digits.");
            	return;  
            }else{
            	request.set("mobileNo", $("#mobileNo").val());
            }
        }
    
    	request.set("patientId", -123);
    }else{
    	if (!$("#firstName").val()) {
            showErrorMessage("Please specify first Name");
            return;
        }
    	if (!$("#lastName").val()) {
            showErrorMessage("Please specify Last Name");
            return;
        }
    	if (!$("#address").val()) {
            showErrorMessage("Please specify Address");
            return;
        }
    	
    	var email = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    	    if(!$("#emailId").val().match(email) && $("#emailId").val()){
    	    	showErrorMessage("Please enter valid email Id");
    	    	return;  
    	    }  
    	    
    	var phoneno = /^\d{10}$/;
    	if (!$("#mobileNo").val()) {
            showErrorMessage("Please specify Mobile No");
            return;
        }else{
        	if(!$("#mobileNo").val().match(phoneno)){
            	showErrorMessage("Please enter mobile of 10 digits.");
            	return;  
            }
        	request.set("mobileNo", $("#mobileNo").val());
        }
    	
    	if (!$("#dob").val() && !$("#age").val()) {
    		showErrorMessage("Please specify Date of Birth OR Age");
            return;
        }
    	
    	if (!$('input:radio[name=optionsRadios]:checked').val()) {
            showErrorMessage("Please specify Gender of Patient");
            return;
        }
    	
    	request.set("param" , "");
    
    	request.set("mobileNo", $("#mobileNo").val());
        
        if (!$("#dob").val()){
        	console.log("dob null"+$("#dob").val());
        	request.set("age", $("#age").val());
        	request.set("dob", 0);
        }else{
        	if (!$("#age").val()){
        		//var startDateParts = $("#dob").val().split('-');
        	    //var dob = startDateParts[2]+'-'+startDateParts[1]+'-'+ startDateParts[0];
        		request.set("age", 0);
            	request.set("dob", $("#dob").val());
        	}
        }
        
        request.set("selectTitle" , $("#selectTitle").val());
        request.set("firstName", $("#firstName").val());
        request.set("lastName", $("#lastName").val());
        request.set("emailId", $("#emailId").val());
        
        request.set("address", $("#address").val());
        request.set("gender",checked_option_radio);
        request.set("inputEnableAlerts", $("#inputEnableAlerts").is(':checked'));
        request.set("patientId", -123);
        request.set("dateOfVisit", "today");
    }
   
    request.save(null, {
        success: patientDetailsSaved,
        error: requestFailed
    });
}

function patientDetailsSaved(data) {
	$('#patientsTable').empty();
    if (data.get("Status") == "NoRecord")
    {
        showInformatioinMessage(data.get("Reason"));
    }
    else if(data.get("Status") == "Record Found")
    {
    	showErrorMessage(data.get("Reason"));
    	$('#patientsTable').empty();
    	var json = data.get("patientsList");
    	thead = '<thead><tr style="background-color:white"><th>ID</th><th>First Name</th><th>Last Name</th><th>Mobile</th><th>DOB</th><th>Address</th><th>Date Of Visit</th><th>Action</th></tr></thead>';
    	$('#patientsTable').append(thead);
    	for (var i = 0; i < json.length; i++) {
            tr = $('<tr/>');
            tr.append("<td>" + json[i].patientId + "</td>");
            tr.append("<td>" + json[i].firstName + "</td>");
            tr.append("<td>" + json[i].lastName + "</td>");
            tr.append("<td>" + json[i].mobileNo + "</td>");
            tr.append("<td>" + json[i].dob + "</td>");
            tr.append("<td>" + json[i].address + "</td>");
            tr.append("<td>" + json[i].dateOfVisit + "</td>");
            
            tr.append("<td><a class='right' href='#'>"+ 'Edit Patient' + "</a></td>");
            $('#patientsTable').append(tr);
        }
    } else if(data.get("Status") == "SUCCESS"){
    	showInformatioinMessage(data.get("Reason"));
    	showTodaysCustomer();
    }
}

$(document).on("click", "table td a", function(){
    var patientId = $(this).parents("tr").find("td:first").text();
    if($(this).text()=='Edit Patient'){
    	editPatient(patientId);
    } 
});

function editPatient(patientId){
	getPatientDetailsById(patientId);
}
function requestFailed() {
    showErrorMessage("Request failed");
}

function getPatientDetailsById(patientId){
	var request = new PatientRecord();
	request.set("patientId", patientId);
	request.save(null, {
        success: fillDetails,
        error: requestFailed
    });
}

function fillDetails(data){
	if (data.get("Status") == "SUCCESS")
    {
		var json = data.get("patientsList");
		$("#firstName").val(json[0].firstName);
		$("#lastName").val(json[0].lastName);
		$("#address").val(json[0].address);
		$("#emailId").val(json[0].emailId);
		$("#mobileNo").val(json[0].mobileNo);
		$("#dob").val(json[0].dob);
		$("#age").val(json[0].age);
		if(json[0].gender == "male"){
			$('#optMale').prop('checked', true);	
		}else if(data[0].gender == "female"){
			$('#optFemale').prop('checked', true);	
		}else if(data[0].gender == "other"){
			$('#optOther').prop('checked', true);	
		}
		
		$("#inputEnableAlerts").prop('checked', data.get("mailReport"));
		
		
    }
    else
    {
        showErrorMessage(data.get("Reason"));
    }
}