function fetchquestion(){
	console.log("inside update");
	url="http://localhost:1345/BankApp/pw";  /*https://github.github.io/fetch/*/
	fetch(url, {
		method: "GET",
		headers:{
			 "Accept": "application/json, text/plain",
		     "Content-type": "text/html"		 
		}, //pass the username
	})  /* end fetch balance is still not updated*/
	.then(function(response){
		document.getElementsByTagName("div").innerHtml=response.text;
	},
	function(error){
		document.getElementsByTagName("div").innerHtml=error.message;
		console.log(error.message);
	}) /* end then response*/
	
	function validate(){
		return false;
	}
	
} /* end function*/