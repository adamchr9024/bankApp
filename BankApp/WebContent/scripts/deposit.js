function validate(){
	const num = document.getElementById('num').value;
	

	if (num <= 0 || num.length==0){
		document.getElementById('msg').innerText = "Deposit must be entered and > 0";	
	    return false;
	}
	document.getElementById('msg').innerText = "";
		return true;
}