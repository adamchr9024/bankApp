

function validate(){
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
}
	/*$.noConflict();
    jQuery(document).ready(function(){  
	
		jQuery("#loginForm").on('submit',function(e){
			e.preventDefault();
			alert("");
			/*rules:{
				username:{
					required: true,
				    minlength: 6,
			             },
			   password:{
				   required: true,
			       minlength: 6,
			            }
			},
			messages: {
				username:{
					required: "Please enter your username",
					minlength: "user name must be at least 6 characters"
				},
				password:{
					required: "Please enter your password",
					minlength: "password must be at least 6 characters"
				}
			}
		});
	});
//}*/