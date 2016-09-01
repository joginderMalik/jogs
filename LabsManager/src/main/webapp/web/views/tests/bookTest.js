function loadPatientDetails() {
	alert("load");
	//Reset messages
    resetMessages();

    var request = new PatientDetailsViewModel();

    request.fetch({
    	data: {patientId:patientId}, //pass patient id here
        success: patientDetailsFetched,
        error: requestFailed
    });

}

function patientDetailsFetched(data) {
	
	if (data.get("Status") == "SUCCESS")
    {
    	$("#address").val(data.get("address"));
    	//TO DO put value into form elements
    }
    else
    {
        showErrorMessage(data.get("Reason"));
    }
}


function savePatientDetails() {

	//Reset messages
    resetMessages();
    
    var checked_option_radio = $('input:radio[name=optionsRadios]:checked').val();
    
    if (!$("#firstName").val()) {
         showErrorMessage("Please specify first Name");
         return;
     }    
 
    var request = new PatientDetailsViewModel();
   
    request.set("selectTitle" , $("#selectTitle").val());
    request.set("firstName", $("#firstName").val());
    request.set("lastName", $("#lastName").val());
    request.set("emailId", $("#emailId").val());
    request.set("mobileNo", $("#mobileNo").val());
    request.set("dob", $("#dob").val());
    request.set("address", $("#address").val());
    request.set("gender",checked_option_radio);
    
    request.set("inputEnableAlerts", $("#inputEnableAlerts").is(':checked'));
    
    request.save(null, {
        success: patientDetailsSaved,
        error: requestFailed
    });
}

function patientDetailsSaved(data) {

    if (data.get("Status") == "SUCCESS")
    {
        showInformatioinMessage(data.get("Reason"));
    }
    else if (data.get("Status") == "Record Found")
    {
    	showErrorMessage(data.get("Reason"));
    	var json = data.get("patientsList");
    	console.log(JSON.stringify(data.get("patientsList")));
    	for (var i = 0; i < json.length; i++) {
            tr = $('<tr/>');
            tr.append("<td>" + json[i].patientId + "</td>");
            tr.append("<td>" + json[i].firstName + "</td>");
            tr.append("<td>" + json[i].lastName + "</td>");
            tr.append("<td>" + json[i].mobileNo + "</td>");
            tr.append("<td>" + json[i].dob + "</td>");
            tr.append("<td>" + json[i].address + "</td>");
            tr.append("<td> <a href='#' onclick='getPatientId();'>" + 'Edit' + "</a>  <a class='right' href='#'>"+ 'Delete' + "</a></td>");
            $('#patientsTable').append(tr);
        }
    }
}

function getPatientId(){
	alert($(this).closest('tr').rowIndx);
	var MyRows = $('table#patientsTable').find('tbody').find('tr');
	for (var i = 0; i < MyRows.length; i++) {
	var MyIndexValue = $(MyRows[i]).find('td:eq(0)').html();
		//alert(MyIndexValue);
	}
}

function requestFailed() {
    showErrorMessage("Request failed");
}
