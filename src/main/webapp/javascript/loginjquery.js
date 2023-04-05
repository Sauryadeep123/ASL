/**
 * 
 */
//
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
											console.log(data);
											sessionStorage.setItem("user", "admin");

                                    		console.log(sessionStorage.getItem("user"));
											
											if (data.success == "false") {

												$("#mainresponse").hide();
												$("#warning").removeClass("d-none");
											}
											else{
												
											$("#card").removeClass("col-xl-6");
											$("#card").addClass("col-xl-15");
											buildTable(data)



	function buildTable(data){
		var table = document.getElementById('table')
		console.log(data);

		for (var i = 0; i < data.length; i++){
			var row = `<tr>
							<td>${data[i].serialNo}</td>
							<td><span class="truncate">${data[i].firstName}<span class="tooltiptext">${data[i].firstName}</span></span></td>
							<td><span class="truncate">${data[i].email}<span class="tooltiptext">${data[i].email}</span></span></td>
							
							<td><img src="photo/${data[i].photo}" alt="" style="width: 50px;height:50px"></td>
							<td></td>
						
					  </tr>`
			table.innerHTML += row


		}
	}
											$("#myform").hide();
											$("#mainresponse").fadeIn();
											$("#wrong").hide();
											}
											const table = document.getElementById("table");
						                     const rows = table.rows;
						                     
						                     for (let i = 0; i < rows.length; i++) {
						                       const editButton = document.createElement("div");
						                       editButton.innerHTML = "<i class='bi bi-eye'></i>";
						                       var firstName = document.getElementById("firstName");
						                       var middleName = document.getElementById("middleName");
						                       var lastName = document.getElementById("lastName");
						                       var emailmodal = document.getElementById("emailmodal");
						                       var dob = document.getElementById("dob");
						                       var city = document.getElementById("city");
						                       editButton.onclick = () => {
												 $('#modal').modal('show');
						                         firstName.value=data[i].firstName;
						                         if (typeof data[i].middleName !== 'undefined')
						                          middleName.value=data[i].middleName;
						                        lastName.value=data[i].lastName;
						                        emailmodal.value=data[i].email;
						                        dob.value=data[i].dob;
						                        city.value=data[i].city;
						                        console.log(data[i].emailmodal);
						                       };
						                       
						                       const cell = rows[i].insertCell(4);
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
