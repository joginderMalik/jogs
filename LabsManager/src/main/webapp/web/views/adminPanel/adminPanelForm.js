function loadStaffs(){
	//Reset messages
    resetMessages();

    var request = new RegisterdStaff();

    request.fetch({
        success: staffListFetched,
        error: requestFailed
    });
}

function staffListFetched(data){
	if (data.get("Status") == "SUCCESS")
    {
		var json = data.get("list");
    	//console.log(JSON.stringify(data.get("list")));
    	for (var i = 0; i < json.length; i++) {
            tr = $('<tr/>');
            tr.append("<td>" + json[i].username + "</td>");
            tr.append("<td>" + json[i].fullName + "</td>");
            tr.append("<td>" + json[i].mobileNo + "</td>");
            tr.append("<td>" + json[i].state + "</td>");
            tr.append("<td>" + json[i].distt + "</td>");
            tr.append("<td>" + json[i].role[0].role + "</td>");
            
            if(json[i].enabled){
            	tr.append("<td>" + json[i].enabled + "</td>");
            	tr.append("<td><a class='right' href='#'>"+ 'Deactivate Staff' + "</a></td>");
            }else{
            	tr.append("<td style='color:red'>" + json[i].enabled + "</td>");
            	tr.append("<td><a class='right' href='#'>"+ 'Approve Staff' + "</a></td>");
            }
            
            $('#staffsTable').append(tr);
        }
    }
    else
    {
        showErrorMessage(data.get("Reason"));
    }
}

$(document).on("click", "table td a", function(){
    var emailId = $(this).parents("tr").find("td:first").text();
    if($(this).text()=='Approve Staff'){
    	approveStaff(emailId);
    }
    if($(this).text()=='Deactivate Staff'){
    	deactivateStaff(emailId);
    } 
});

function approveStaff(emailId){
	var request = new ForUserApprove();
	request.set("emailId", emailId);
	request.save(null, {
        success: approvedDone,
        error: requestFailed
    });
}

function approvedDone(data){
	if (data.get("Status") == "SUCCESS")
    {
		showInformatioinMessage(data.get("Reason"));
		$("#staffsTable").empty();
		loadStaffs();
    }
    else
    {
        showErrorMessage(data.get("Reason"));
    }
}

function deactivateStaff(emailId){
	var request = new ForUserDeactivate();
	request.set("emailId", emailId);
	request.save(null, {
        success: deactivateDone,
        error: requestFailed
    });
}

function deactivateDone(data){
	if (data.get("Status") == "SUCCESS")
    {
		showInformatioinMessage(data.get("Reason"));
		$("#staffsTable").empty();
		loadStaffs();
    }
    else
    {
        showErrorMessage(data.get("Reason"));
    }
}

function requestFailed() {
    showErrorMessage("Request failed");
}