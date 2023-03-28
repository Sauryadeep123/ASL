$( '#form' )
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
    
    
  } );



/*$(document)
	.ready(
		function() {
			$('#submitBtn')
				.click(
					function(event) {
						event.preventDefault();
						if (validate()) {
							var formData = {
								email: $('#email')
									.val(),
								password: $(
									'#password')
									.val()
							};

							$
								.ajax(
									{
										type: 'POST',
										url: 'Login',
										data: formData,
										dataType: 'json',
										encode: true
									})

								.done(
									function(
										data) {

										$(
											"#myform")
											.hide();

										$(
											"#mainresponse")
											.fadeIn();

										if (data.success == "false") {

											$(
												"#mainresponse")
												.hide();

											$(
												"#warning")
												.removeClass(
													"d-none");

										}
										$(
											'table')
											.bootstrapTable(
												{
													data: data
												});

									})
								.fail(
									function(
										data) {
										console
											.log(2);
										console
											.log(data);
										$(
											'#response')
											.text(
												'Error: '
												+ data.responseJSON.message);
									});
						}
					});

		});*/