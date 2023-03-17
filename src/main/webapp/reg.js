/**
 * 
 */


function validate() {
	let x = document.getElementById("firstName").value;
	if (x == "") {
		alert("Name must be filled out"); return false;
	}
	
	x = document.getElementById("lastName").value;
	if (x == "") {
		alert("Name must be filled out"); return false;
	}
	
	x = document.getElementById("email").value;
	if (!x.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)) {

		alert("Enter valid email id");
		return false;
	}
	
	x = document.getElementById("dob").value;
	if (x=="") {
		alert("Please enter your date of birth")
		return false;
	}
	
	x=document.getElementById("city").value;
	if(x=="")
	{
		alert("please enter your city");
		return false;
	}
	
	x=document.getElementById("resume").value;
	if(x=="")
	{
		alert("please upoad your resume");
		return false;
	}
	
	x=document.getElementById("pic").value;
	if(x=="")
	{
		alert("please upoad your resume");
		return false;
	}
	return true;
}