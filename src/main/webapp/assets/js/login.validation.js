$(document).ready(function() {
	$(function() {
		
		$.validator.addMethod("regex", function(value, element, regexpr) {
			return regexpr.test(value);
		});
		
		$("#loginForm").validate({
			rules : {
				user_login : {
					required : true,
					minlength : 5,
					maxlength : 20,
					regex : /^[a-zA-Z0-9]{5,20}$/,
				},
				user_password : {
					required : true,
					minlength : 5,
					maxlength : 20,
					regex : /^[a-zA-Z0-9]{5,20}$/,
				}
			},
			messages : {
				user_login : {
					required : "This field is required",
					minlength : "Login must be 5-20 characters long",
					maxlength : "Login must be 5-20 characters long",
					regex : "Login contains only eng letters and numbers"
				},
				user_password : {
					required : "This field is required",
					minlength : "Password must be 5-20 characters long",
					maxlength : "Password must be 5-20 characters long",
					regex : "Password contains only eng letters and numbers"
				}
			},
		});
		$("#loginForm").valid();
	});
});