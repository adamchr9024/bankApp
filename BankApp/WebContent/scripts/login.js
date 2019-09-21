

/*function validate(){
	//alert("inside");
	
	const username=document.getElementById("username").value;
	const password=document.getElementById("password").value;
	//alert("username = "+ username);
	//alert("password = "+ password);
	if(username=="" || password=="" || username.length<6 || password.length<6){
		//alert("inside");
		document.getElementById("errMessage").innerText = ".....Username/Password must be at least 6 characters";
		return false;
	}
	document.getElementById("errMessage").innerText = "";
	   return true;
}*/
	$(document).ready(function(){  //validate uses the 'name' attribute
    	$("form[id='loginForm']").validate({
			//e.preventDefault();
			rules:{
				userName:{
					required: true,
				    minlength: 6,
			             },
			   password:{
				   required: true,
			       minlength: 6,
			       }
			},
			
			messages: {
				userName:{
					required: 'Please enter your username',
					minlength: 'User name must be at least 6 characters',
				},
				password:{
					required: 'Please enter your password',
					minlength: 'Password must be at least 6 characters'
				}
			},
			submitHandler: function(form){
				form.submit();
			}
		});
	});
