$("#loginForm").submit(function(e)
		{
		  $.ajax({
				type: "post",
				url: '/MyApp/ajaxLogin',
				cache: false,				
				data:$(this).serializeArray(),
				async: false,
				success: function(response){
					if(response=='serversidevalidationfailed'){
						$('#result').html("<br />Could not login. Please try again.");
						e.preventDefault();
					}
				}
		});
		});