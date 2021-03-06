$(document).ready(function() {
	$(function() {
		
		$.validator.setDefaults({
			errorClass: 'error',
		});
		
		$.validator.addMethod("regex", function(value, element, regexpr) {
			return regexpr.test(value);
		});

		$("#createadForm").validate({
			rules : {
				ad_title : {
					required : true,
					minlength : 5,
					maxlength : 45,
					regex : /^[а-яА-Яa-zA-Z0-9\-_%\s]{5,45}$/,
				},
				ad_smalldesc : {
					required : true,
					minlength : 4,
					maxlength : 100,
					regex : /^[а-яА-Яa-zA-Z0-9,.\-_%()\s]{4,100}$/,
				},
				ad_description : {
					required : true,
					minlength : 4,
					maxlength : 200,
					regex : /^[а-яА-Яa-zA-Z0-9,.\-_%()\s]{4,200}$/,
				},
				ad_price : {
					required : true,
					minlength : 1,
					maxlength : 10,
					regex : /^[0-9]{1,10}$/,
				}
			},
			messages : {
				ad_title : {
					required : "This field is required",
					minlength : "Title must be 5-45 characters long",
					maxlength : "Title must be 5-45 characters long",
					regex : "Title contains invalid characters"
				},
				ad_smalldesc : {
					required : "This field is required",
					minlength : "Small description must be 4-100 characters long",
					maxlength : "Small description must be 4-100 characters long",
					regex : "Small description contains invalid characters"
				},
				ad_description : {
					required : "This field is required",
					minlength : "Description must be 4-200 characters long",
					maxlength : "Description must be 4-200 characters long",
					regex : "Description contains invalid characters"
				},				
				ad_price : {
					required : "This field is required",
					minlength : "Price must be 1-10 characters long",
					maxlength : "Price must be 1-10 characters long",
					regex : "Price contains only numbers"
				}
			},
		});
		$("#createadForm").valid();
	});
});