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
						if (getCookie("insert") == "false") {
							$("#successMessage").text("Some problem occured");
							$("#successMessage").addClass("text-danger");
						}
						else {
							$("#successMessage").text(data[data.length - 1].email + " Successfully Registered");
							$("#successMessage").addClass("text-success");
						}

						buildTable(data)



						
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
					//highlight recent add rows


					// Add the class to highlight the row
					$(document).scrollTop($(document).height());
					console.log("highlight");
					 // Get the table rows
      var rowss = document.getElementsByTagName('tr');
      
      // Set the row number to highlight
      var rowNumber = data.length;
      
      // Get the row to highlight
      var rowToHighlight = rowss[rowNumber];
      
      // Add the class to highlight the row
      rowToHighlight.classList.add('highlighted');
					// Remove the class after 30 seconds
					setTimeout(function() {
						rowToHighlight.classList.remove('highlighted');
					}, 30000);

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
function buildTable(data) {
							var table = document.getElementById('table')
							console.log(data.length);

							for (var i = 0; i < data.length; i++) {
								var row = `<tr>
							<td>${data[i].serialNo}</td>
							<td><span class="truncate">${data[i].firstName}<span class="tooltiptext">${data[i].firstName}</span></span></td>
						<td><span class="truncate">${data[i].email}<span class="tooltiptext">${data[i].email}</span></span></td>
							<td><img src="photo/${data[i].photo}" alt="" style="width:50px;height:50px"></td>
							<td></td>
						
					  </tr>`
								table.innerHTML += row


							}
						}

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
$(document).ready(function() {
        $("#pic").on('change', function() {
          //Get count of selected files
          var countFiles = $(this)[0].files.length;
          var imgPath = $(this)[0].value;
          var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
          var image_holder = $("#image-holder");
          image_holder.empty();
          if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg") {
            if (typeof(FileReader) != "undefined") {
              //loop for each file selected for uploaded.
              for (var i = 0; i < countFiles; i++) 
              {
                var reader = new FileReader();
                reader.onload = function(e) {
                  $("<img />", {
                    "src": e.target.result,
                    "class": "thumb-image",
                    "height":"50px"
                  }).appendTo(image_holder);
                }
                image_holder.show();
                reader.readAsDataURL($(this)[0].files[i]);
              }
            } else {
              alert("This browser does not support FileReader.");
            }
          } else {
            alert("Pls select only images");
          }
        });
      });