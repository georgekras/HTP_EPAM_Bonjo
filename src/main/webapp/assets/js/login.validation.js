$(function() {
	$("#loginForm").validate({
		rules : {
			user_login : {
				required : true,
				minlength : 5,
				maxlength : 20,
			},
			user_password : {
				required : true,
				minlength : 5,
				maxlength : 20,
			}
		},
		messages : {
			user_login : {
				required :	"This field is required",
				minlength : "Password must be at least 5 characters long",
				maxlength : "Password must be less then 20 characters long"
			},
			user_password : {
				required :	"This field is required",
				minlength : "Password must be at least 5 characters long",
				maxlength : "Password must be less then 20 characters long"
			}
		},
	});
	$("#loginForm").valid();
});