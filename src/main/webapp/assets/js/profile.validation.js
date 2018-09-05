$(document).ready(function() {
	$(function() {

		$.validator.setDefaults({
			errorClass: 'error',
		});
		
		$.validator.addMethod("regex", function(value, element, regexpr) {
			return regexpr.test(value);
		});

		$("#profileForm").validate({
			rules : {
				user_password : {
					required : true,
					minlength : 5,
					maxlength : 20,
					regex : /^[a-zA-Z0-9]{5,20}$/,
				},
				user_phone : {
					required : true,
					regex : /^[+]+[0-9]{12}$/,
					maxlength : 13,
				}
			},
			messages : {
				user_password : {
					required : "This field is required",
					minlength : "Password must be 5-20 characters long",
					maxlength : "Password must be 5-20 characters long",
					regex : "Password contains only eng letters and numbers"
				},
				user_phone : {
					required : "This field is required",
					regex : "Enter valid phone number",
					maxlength : "Enter valid phone number",
				}
			},
		});
		$("#profileForm").valid();
	});
});