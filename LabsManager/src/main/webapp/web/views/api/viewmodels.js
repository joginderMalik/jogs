var baseURL ='/LabsManager/';

var PatientDetailsViewModel = Backbone.Model.extend({
    urlRoot: baseURL + 'staff/patientDetails',
    defaults: {
    	patientId: '',
    	selectTitle: '',
    	firstName: '',
    	lastName: '',
    	loginId: '',
    	password: '',
    	emailId: '',
    	mobileNo: '',
    	dob: '',
    	age: '',
    	address: '',
    	gender: '',
    	dateOfVisit:'',
    	inputEnableAlerts: '',
    	param:'',
    	Status: '',
        Reason: ''
    }
});

var RegisterdStaff = Backbone.Model.extend({
    urlRoot: baseURL + 'staff/registerStaff',
    defaults: {
    	fullName:'',
    	fatherName:'',
    	mobileNo:'',
    	locateNo:'',
    	emailId:'',
    	inputPassword:'',
    	confirmPassword:'',
    	countryName:'',
    	state:'',
    	distt:'',
    	dob:'',
    	role:'',
    	address:'',
    	gender:'',
    	Status: '',
        Reason: ''
    }
});

var ForUserApprove = Backbone.Model.extend({
    urlRoot: baseURL + 'staff/approveStaff',
    defaults: {
    	emailId:'',
    	Status: '',
        Reason: ''
    }
});

var ForUserDeactivate = Backbone.Model.extend({
urlRoot: baseURL + 'staff/deactivateStaff',
defaults: {
	emailId:'',
	Status: '',
    Reason: ''
}
});

var Country = Backbone.Model.extend({
    urlRoot: baseURL + 'user/getCountryList',
    defaults: {
    	Status: '',
        Reason: ''
    }
});

var State = Backbone.Model.extend({
    urlRoot: baseURL + 'user/getStateByCountryId',
    defaults: {
    	countryId:'',
    	Status: '',
        Reason: ''
    }
});
var District = Backbone.Model.extend({
    urlRoot: baseURL + 'user/getDistrictByStateId',
    defaults: {
    	stateId:'',
    	Status: '',
        Reason: ''
    }
});

var PatientRecord  = Backbone.Model.extend({
    urlRoot: baseURL + 'staff/fillPatientRecord',
    defaults: {
    	emailId:'',
    	Status: '',
        Reason: ''
    }
});
