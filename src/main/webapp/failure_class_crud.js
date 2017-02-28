var FailureClass = function(failureClass, description) {
    this.failureClass = failureClass;
    this.description = description;
}


$(document).ready(function(){

    $("#addFailureClassButton").click(function() {
        alert("add button pressed");

        var failureClass =  $("#failureClassID").val();
        var description = $("#descriptionText").val();
        var myFailureClass = new FailureClass(failureClass,description);

        $.ajax({
            type: "POST",
            url: "ragnar/ragnar",
            success: function () {
                alert("FailureClass added");
            },
            data: JSON.stringify(myFailureClass),
            contentType: "application/json"

        });
    });


    $("#updateFailureClassButton").click(function() {
        alert("update button pressed");

        var id =   $("#updateFailureClassId").val();
        var description =  $("#updateDescText").val();
        var failureClass = new FailureClass(id,description);

        $.ajax({
            type: "PUT",
            url: "ragnar/ragnar",
            success: function () {
                alert("FailureClass updated");
            },
            data: JSON.stringify(failureClass),
            contentType: "application/json"

        });
    });


    $("#deleteFailureClassButton").click(function() {
        alert("delete button pressed");

        var id =  $("#idText").val();
        $.ajax({
            type: "DELETE",
            url: "ragnar/ragnar/" + id,
            success: function () {
                alert("FailureClass deleted");
            },
        });
    });

    $("#searchById").click(function() {
        var id =  $("#getById").val();
        $.ajax({
            type: "GET",
            url: "ragnar/ragnar/failureClass/" + id,
            success: function (value) {
                alert("FailureClass found");
                $("#searchText").val(value.failureClass + " " + value.description );

            },
            error:function () {
             alert("Not found");
            }
        });
    });

    $.ajax({
        type: "GET",
        url: "ragnar/ragnar/allFailureClassInfo",

        success: function (failureClassList) {
            $.each(failureClassList, function (index, value) {
                $("#failureClassHolder").append("<li>" + value.failureClass + " " + value.description +"</li>");
            });
        }
    });


});