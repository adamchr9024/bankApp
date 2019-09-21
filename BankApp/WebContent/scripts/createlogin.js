
$(document).ready(function(){  //validate uses the 'name' attribute
    	$("form[id='createloginForm']").validate({
			//e.preventDefault();
			rules:{
				confirmpassword: {
					required : true,
					minlength: 6,
					equalTo: '#password',
				},
				answer: 'required',
				firstname: 'required',
				lastname: 'required', 
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
				answer: 'Please enter a security answer',
				firstname: 'Please enter your first name',
			    lastname: 'Please enter your last name',
			    userName:{
					required: 'Please enter your username',
					minlength: 'User name must be at least 6 characters',
				},
				password:{
					required: 'Please enter your password',
					minlength: 'Password must be at least 6 characters'
				},
				confirmpassword:{
					required: 'Please Confirm Password',
					minlength:'Password must be at least 6 characters',
				   	equalTo: 'Please enter the same password as above'
				}
			},
			submitHandler: function(form){
				form.submit();
			}
		});
	});
/*function validate(){
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
}*/
