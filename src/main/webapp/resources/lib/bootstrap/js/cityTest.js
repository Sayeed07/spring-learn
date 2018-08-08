
// State lists
var states = new Array();

states['Bangladesh'] = new Array('Dhaka','Khulna','Sylhet');
states['Australia'] = new Array('Sydney','Victoria','Queensland');
states['UnitedStates'] = new Array('California','Florida','New York');


function setThana() {
	cntrySel = document.getElementById('district');
	stateList =  states[cntrySel.value];
	changeSelect('thana',stateList,stateList);
	setCities();
}



function changeSelect(fieldId, newOptions, newValues){
	selectField = document.getElementById(fieldId);
	selectField.options.length = 0;
	for(i=0; i<newOptions.length; i++){
		selectField.options[selectField.length] = new Option(newOptions[i],newValues[i]);
	}
}

function addLoadEvent(func) {
	var oldonload = window.onload;
	
	if(typeof window.onload !='function') {
		window.onload = func;
	} else {
		window.onload = function () {
			if (oldonload) {
				oldonload();
			}
		}
		func();
	}
}

addLoadEvent(function () {
	setStates();
})

















