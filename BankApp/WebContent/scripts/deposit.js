$(document).ready(function(){  //validate uses the 'name' attribute
    	$("form[id='depositForm']").validate({
			//e.preventDefault();
			rules:{
				
			   amount:{
				   number: true,
				   required: true,
			       minlength: 4,
			      
			       
			    }
			},
			
			messages: {
				
				amount:{
					required: 'Please enter a valid decimal value #.##',
					minlength: 'Acceptable format is #.## example 25.01 / 0.99',
					number: 'Please Enter a Decimal Value',
				}
			},
			submitHandler: function(form){
				form.submit();
			}
			
		});
    	
	});