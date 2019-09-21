function update(){
	console.log("inside update");
	url="http://localhost:1345/BankApp/success";  /*https://github.github.io/fetch/*/
	fetch(url, {
		method: "GET",
		headers:{
			 "Accept": "application/json, text/plain",
		     "Content-type": "text/html"		 
		}, 
	})  /* end fetch*/
	.then(function(response){
		document.getElementsByTagName("body")[0].innerHtml=response.text;
	},
	function(error){
		document.getElementsByTagName("body")[0].innerHtml=error.message;
		console.log(error.message);
	}) /* end then response*/
	 
} /* end function*/