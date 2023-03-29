/**
 * 
 */

 $(document).ready(function() {
                     $('#submitBtn').click(function(event) {
							event.preventDefault();
							if (validate()) {
								var formData = {
									email : $('#email')
											.val(),
									password : $(
											'#password')
											.val()
								};
								$
								.ajax(
										{
											type : 'POST',
											url : 'Login',
											data : formData,
											dataType : 'json',
											encode : true
										})
										
										.done(function(data) {
											
											if (data.success == "false") {

												$("#mainresponse").hide();
												$("#warning").removeClass("d-none");
											}
											else{
												
											
											
											$('table').bootstrapTable(

													{
														data : data
														
													});
											$("#myform").hide();
											$("#mainresponse").fadeIn();
											$("#wrong").hide();
											}
											const table = document.getElementById("table");
						                     const rows = table.rows;
						                     
						                     for (let i = 1; i < rows.length; i++) {
						                       const editButton = document.createElement("div");
						                       editButton.innerHTML = "<i class='bi bi-pen'></i>";
						                       editButton.onclick = () => {
						                         
						                         console.log(document.getElementById("table").rows[i].cells[0]);
						                       };
						                       
						                       const cell = rows[i].insertCell(-1);
						                       cell.appendChild(editButton);
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
						});
		});

