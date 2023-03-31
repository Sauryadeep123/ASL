
function validate() {
	
	
	x = document.getElementById("email").value;
	if (!x.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)) {

		alert("Enter valid email id");
		return false;
	}
	x = document.getElementById("password").value;
	if (x=="") {
		alert("Please enter your pasword")
		return false;
	}
	
	return true;
}