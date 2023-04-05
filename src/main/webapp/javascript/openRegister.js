function openRegister(){
	$.ajax(
										{
											type : 'POST',
											url : 'openRegister',
											
											encode : true
										})
										
										.done(function(data) {
											console.log(data);
											if(data=="success") window.location.href = "Register.html";
											else{
												alert("You need to log in");
												window.location.href = "Login.html";
											}
										})
										
										.fail(
												function(data)
													 {
														 
													
													console.log(2);
													console.log(data);
															
													$('#response').text('Error: '+ data.responseJSON.message);
															
															
																	
																			
												});
}
 