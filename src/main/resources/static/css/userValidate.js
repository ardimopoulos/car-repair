$ (document).ready (function () {

    // window.validate = function() {
    console.log('validating...');

    $("form#userForm").uservalid({

            rules: {
                firstname: {
                    required: true,
                    minlength: 2
                },
                lastname: {
                    required: true,
                    minlength: 2
                },
                UserP: {
                    required: true,
                    minlength: 5
                },
                vat: {
                    required: true,
                    minlength: 8
                },
                ConfPass: {
                    required: true,
                    minlength: 5,
                    equalTo: "#UserP"
                },
                email: {
                    required: true,
                    email: true
                },
                messages: {
                    firstname:{
                        required:"Please enter a firstname",
                        minlength:"Firstname must consist of at least 2 characters"
                    },
                    lastname: {
                        required: "Please enter a lastname",
                        minlength: "Your lastname must consist of at least 2 characters"
                    },
                    UserP: {
                        required: "Please provide a password",
                        minlength: "Your password must be at least 5 characters long"
                    },
                    vat: {
                        required: "Please provide tax number",
                        minlength: "Tax number must be 9 digits"
                    },
                    ConfPass: {
                        required: "Please provide a password",
                        minlength: "Your password must be at least 5 characters long",
                        equalTo: "Please enter the same password as above"
                    }

                }
            }

        });
});