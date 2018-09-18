$(document).ready(function() {
	$(function() {

		$.validator.setDefaults({
			errorClass: 'error',
		});
		
		$.validator.addMethod("regex", function(value, element, regexpr) {
			return regexpr.test(value);
		});

		$("#editusersForm").validate({
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
				},
				user_email : {
					required : true,
					regex : /^[a-zA-Z0-9._+-]{3,24}+@[a-zA-Z0-9.]{3,20}+.[a-zA-Z]{2,6}$/,
					maxlength : 50,
				},
				user_nickname : {
					required : true,
					minlength : 5,
					maxlength : 20,
					regex : /^[а-яА-Яa-zA-Z0-9_]{5,20}$/,
				},
				user_phone : {
					required : true,
					regex : /^[+]+[0-9]{12}$/,
					maxlength : 13,
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
				},
				user_email : {
					required : "This field is required",
					regex : "Enter valid email",
					maxlength : "Email can't be over 50 chars",
				},				
				user_nickname : {
					required : "This field is required",
					minlength : "Nickname must be 5-20 characters long",
					maxlength : "Nickname must be 5-20 characters long",
					regex : "Nickname contains only eng letters and numbers"
				},
				user_phone : {
					required : "This field is required",
					regex : "Enter valid phone number",
					maxlength : "Enter valid phone number",
				}
			},
		});
		$("#editusersForm").valid();
	});
});