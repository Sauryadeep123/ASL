/*$( '#form' )
  .submit( function( e ) {
	  e.preventDefault();
	$.ajax( {
	  url: 'register',
	  type: 'POST',
	  data: new FormData( this ),
	  processData: false,
	  contentType: false
	} )
	.done  (function(data)        {
		 alert("Success: " + data) ; 
		 })
    
    
  } );*/



$(document).ready(function() {
	console.log("before button click")

	$("#submitBtn").click(function(event) {
		console.log("after button click")

		//stop submit the form, we will post it manually.
		event.preventDefault();
		if (validate()) {

			// Get form
			var form = $('#myform')[0];

			// Create an FormData object 
			var data = new FormData(form);

			// If you want to add an extra field for the FormData
			//data.append("CustomField", "This is some extra data, testing");

			// disabled the submit button
			//$("#btnSubmit").prop("disabled", true);
			console.log("before ajax");

			$.ajax({

				type: "POST",
				enctype: 'multipart/form-data',
				url: "register",
				data: data,
				dataType: 'json',
				processData: false,
				contentType: false,
				cache: false,
				success: function(data) {

					$("#result").text(data);
					console.log("SUCCESS : ", data);
					if (data.success == "alreadyuser") {
						$("#alreadyUser").modal('show');
					}
					else {

						$("#card").removeClass("col-xl-8");
						$("#card").addClass("col-xl-12");
						console.log(document.cookie);
						if(getCookie("insert")=="false"){
							 $("#successMessage").text("Some problem occured");
							 $("#successMessage").addClass("text-danger");
						}
						else{
							$("#successMessage").text(data[data.length-1].email+" Successfully Registered");
							 $("#successMessage").addClass("text-success");
						}
						
						buildTable(data)



						function buildTable(data) {
							var table = document.getElementById('table')
							console.log(data.length);

							for (var i = 0; i < data.length; i++) {
								var row = `<tr>
							<td>${data[i].serialNo}</td>
							<td><span class="truncate">${data[i].firstName}<span class="tooltiptext">${data[i].firstName}</span></span></td>
							<td>${data[i].email}</td>
							<td><img src="photo/${data[i].photo}" alt="" style="width: 150px;"></td>
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
						editButton.onclick = () => {

							console.log(document.getElementById("table").rows[i].cells[0].innerText);
						};

						const cell = rows[i].insertCell(4);
						cell.appendChild(editButton);
					}

				},
				error: function(e) {

					$("#result").text(e.responseText);
					console.log("ERROR : ", e);
					$("#btnSubmit").prop("disabled", false);

				}
			});
		}

	});

});

function getCookie(name) {
	var cookies = document.cookie.split(';');
	for (var i = 0; i < cookies.length; i++) {
		var cookie = cookies[i].trim();
		if (cookie.indexOf(name + '=') === 0) {
			return cookie.substring(name.length + 1, cookie.length);
		}
	}
	return null;
}
