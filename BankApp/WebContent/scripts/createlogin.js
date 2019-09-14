
function validate(){
	//alert("inside");
	
	const username=document.getElementById("username").value;
	const password=document.getElementById("password").value;
	const password2=document.getElementById("password2").value;
	const firstname = document.getElementById("firstname").value;
	const lastname = document.getElementById("lastname").value;
	//alert("username = "+ username);
	//alert("password = "+ password);
	if(username.length<6 || password.length<6 || firstname=="" || lastname == ""){
		//alert("inside");
		document.getElementById("errMessage").innerText = ".....Username/Password must be at least 6 characters"+
		"\nfirst and last name cannot be empty";
		return false;
	}
	if(password !== password2){
		document.getElementById("errMessage").innerText = "Passwords do not match. Please re-enter";
		return false;
	}
	document.getElementById("errMessage").innerText = "";
	   return true;
}