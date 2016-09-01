function showLogin () {
	$("#container").empty();
    $("#container").load("web/views/login/loginForm.html");
    $("#header").empty();
}

function showRegisterPatientPage() {
    $("#container").empty();
    $("#container").load("web/views/patient/patientForm.html");
    $("#header").load("web/views/shared/Header.html");
}

function showBookTestPage(){
	$("#container").empty();
    $("#container").load("web/views/tests/bookTestForm.html");
    $("#header").load("web/views/shared/patientHeader.html");
}

function updateTestsPage(){
	$("#container").empty();
    $("#container").load("web/views/tests/updateTestsForm.html");
    $("#header").load("web/views/shared/Header.html");
}

function showRegisterStaffPage(){
	$("#container").empty();
    $("#container").load("web/views/staffManagement/signUpStaffForm.html");
    $("#header").load("web/views/shared/Header.html");
}

function showAdminPanelPage(){
	$("#container").empty();
    $("#container").load("web/views/adminPanel/adminPanelForm.html");
    $("#header").load("web/views/shared/Header.html");
}