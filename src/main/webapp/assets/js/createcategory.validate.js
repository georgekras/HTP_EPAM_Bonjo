$(document).ready(function() {
	$(function() {
		
		$.validator.setDefaults({
			errorClass: 'error',
		});
		
		$.validator.addMethod("regex", function(value, element, regexpr) {
			return regexpr.test(value);
		});
		
		$("#createcategoryForm").validate({
			rules : {
				category_name : {
					required : true,
					minlength : 3,
					maxlength : 40,
					regex : /^[а-яА-Яa-zA-Z0-9\-\s_]{3,40}$/,
				}
			},
			messages : {
				category_name : {
					required : "This field is required",
					minlength : "Category name must be 3-40 characters long",
					maxlength : "Category name must be 3-40 characters long",
					regex : "Category name contains invalid characters"
				},
			},
		});
		$("#createcategoryForm").valid();
	});
});