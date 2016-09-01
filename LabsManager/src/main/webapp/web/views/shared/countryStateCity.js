function setCountryNames(){
	var request = new Country();
	request.fetch({
	        success: countryFound,
	        error: requestFailed
	    });
}

function countryFound(data){
	var listItems= "";
	 if (data.get("Status") == "SUCCESS") {
		 var json = data.get("countryList");
	    	listItems+= "<option value='0'>-- Select Country --</option>";
	    	for (var i = 0; i < json.length; i++) {
	    		listItems+= "<option value='" + json[i].countryId + "'>" + json[i].countryName + "</option>";
		     }
		     $("#countryId").html(listItems); 
	 }
}

function getStateByCountryId(){
	var value=$("#countryId option:selected").val();
    var request = new State();
    request.set("countryId",value);
    
    request.save(null, {
        success: stateFound,
        error: requestFailed
    });
}

function stateFound(data){
	var listItems= "";
	 if (data.get("Status") == "SUCCESS") {
		 var json = data.get("stateList");
	    	listItems+= "<option value='0'>-- Select State --</option>";
	    	for (var i = 0; i < json.length; i++) {
	    		listItems+= "<option value='" + json[i].stateId + "'>" + json[i].stateName + "</option>";
		     }
		     $("#stateId").html(listItems); 
	 }
}

function getDistrictByStateId(){
	var value=$("#stateId option:selected").val();
    var request = new District();
    request.set("stateId",value);
    
    request.save(null, {
        success: districtFound,
        error: requestFailed
    });
}

function districtFound(data){
	var listItems= "";
	 if (data.get("Status") == "SUCCESS") {
		 var json = data.get("districtList");
	    	console.log(JSON.stringify(data.get("districtList")));
	    	listItems+= "<option value='0'>-- Select District --</option>";
	    	for (var i = 0; i < json.length; i++) {
	    		listItems+= "<option value='" + json[i].districtId + "'>" + json[i].districtName + "</option>";
		     }
		     $("#districtId").html(listItems); 
	 }
}

function getBlockByDistrictId(){
	var value=$("#districtId option:selected").val();
    var request = new Block();
    request.set("districtId",value);
    
    request.save(null, {
        success: blockFound,
        error: requestFailed
    });
}

function blockFound(data){
	var listItems= "";
	 if (data.get("Status") == "SUCCESS") {
		 var json = data.get("blockList");
	    	console.log(JSON.stringify(data.get("blockList")));
	    	listItems+= "<option value='0'>-- Select Block --</option>";
	    	for (var i = 0; i < json.length; i++) {
	    		listItems+= "<option value='" + json[i].blockId + "'>" + json[i].blockName + "</option>";
		     }
		     $("#blockId").html(listItems); 
	 }
}

function requestFailed() {
    showErrorMessage("Request failed");
}
