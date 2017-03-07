// http://stackoverflow.com/questions/166221/how-can-i-upload-files-asynchronously

var isAcceptable = false;
$(document).ready(function () {
    $('#fileUploadB1').on('change', function() {

        var file = this.files[0];
        if (!file.name.includes(".xls") || !file.name.includes(".xls")){
            alert("Warning! Not an excel spreadsheet!");
            isAcceptable = false;
        }
        else{
            isAcceptable = true;
        }

        // Also see .name, .type
    });

    $('#fileUploadB2').on('click', function() {
        $.ajax({
            // Your server script to process the upload
            url: "ragnar/base_data/upload",
            type: 'POST',

            // Form data
            data: new FormData($('form')[0]),

            // Tell jQuery not to process data or worry about content-type
            // You *must* include these options!
            cache: false,
            contentType: false,
            processData: false,

            // Custom XMLHttpRequest
            xhr: function() {
                var myXhr = $.ajaxSettings.xhr();
                if (myXhr.upload) {
                    // For handling the progress of the upload
                    myXhr.upload.addEventListener('progress', function(e) {
                        if (e.lengthComputable) {
                            $('progress').attr({
                                value: e.loaded,
                                max: e.total,
                            });
                        }
                    } , false);
                }
                return myXhr;
            },
        });
    $.ajax({
            // Your server script to process the upload
            url: "ragnar/base_data/upload",
            type: 'POST',

            // Form data
            data: new FormData($('form')[0]),

            // Tell jQuery not to process data or worry about content-type
            // You *must* include these options!
            cache: false,
            contentType: false,
            processData: false,

            // Custom XMLHttpRequest
            xhr: function() {
                var myXhr = $.ajaxSettings.xhr();
                if (myXhr.upload) {
                    // For handling the progress of the upload
                    myXhr.upload.addEventListener('progress', function(e) {
                        if (e.lengthComputable) {
                            $('progress').attr({
                                value: e.loaded,
                                max: e.total,
                            });
                        }
                    } , false);
                }
                return myXhr;
            },
        });
    

    });
});


