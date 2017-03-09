var FailureClass = function(failureClass, description) {
    this.failureClass = failureClass;
    this.description = description;
}


$(document).ready(function(){

    $("#addFailureClassButton").click(function() {

        var failureClass =  $("#failureClassID").val();
        var description = $("#descriptionText").val();
        var myFailureClass = new FailureClass(failureClass,description);

        $.ajax({
            type: "POST",
            url: "ragnar/failure_class",
            success: function () {
                alert("FailureClass added");
                location.reload();
            },
            error: function(){
                alert("Failure Class POST failure")
            },
            data: JSON.stringify(myFailureClass),
            contentType: "application/json",


    });
    });


    $("#updateFailureClassButton").click(function() {
        alert("update button pressed");

        var id =   $("#updateFailureClassId").val();
        var description =  $("#updateDescText").val();
        var failureClass = new FailureClass(id,description);
        alert("Id:" + id);

        $.ajax({
            type: "PUT",
            url: "ragnar/failure_class",
            success: function () {
                alert("FailureClass updated");
                location.reload();
            },
            error: function () {
                alert("Failure Class Id not found")
            },
            data: JSON.stringify(failureClass),
            contentType: "application/json"

        });
    });


    $("#deleteFailureClassButton").click(function() {
        var id =  $("#idText").val();
        $.ajax({
            type: "DELETE",
            url: "ragnar/failure_class/" + id,
            success: function () {
                alert("FailureClass deleted");
                location.reload();
            },
            error: function () {
                alert("FailureClass not deleted");
            },
        });
    });

    $("#searchById").click(function() {
        var id =  $("#getById").val();
        $.ajax({
            type: "GET",
            url: "ragnar/failure_class/" + id,
            success: function (value) {
                alert("FailureClass found");
                $("#searchText").val(value.failureClass + " " + value.description );
                location.reload();

            },
            error:function () {
             alert("Not found");
            }
        });
    });


    $("#showFailureList").click(function() {
        $.ajax({
            type: "GET",
            url: "ragnar/failure_class",

         success: function (failureClassList) {
            $.each(failureClassList, function (index, value) {
                    $("#failureClassHolder").append("<li>" + value.failureClass + " " + value.description +"</li>");
            });
        }});
    });

    $("#closeFailureList").click(function() {
        $("#failureClassHolder").empty();
    });

});