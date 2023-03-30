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



$(document).ready(function () {
	console.log("before button click")

    $("#submitBtn").click(function (event) {
		console.log("after button click")

        //stop submit the form, we will post it manually.
        event.preventDefault();
        if(validate())
        {

        // Get form
        var form = $('#form')[0];

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
            processData: false,
            contentType: false,
            cache: false,
            success: function (data) {

                $("#result").text(data);
                console.log("SUCCESS : ", data);
                if(data=="hello")
                	$("#alreadyUser").modal('show');
                else $("#success").modal('show');
                $("#btnSubmit").prop("disabled", false);

            },
            error: function (e) {

                $("#result").text(e.responseText);
                console.log("ERROR : ", e);
                $("#btnSubmit").prop("disabled", false);

            }
        });
        }

    });

});