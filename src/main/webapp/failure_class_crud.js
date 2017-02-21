var FailureClass = function(failure_class, description) {
    this.failure_class = failure_class;
    this.description = description;
}

var MyCharacter = function(id,name, age) {
    this.id = id;
    this.name = name;
    this.age = age;
}

$(document).ready(function(){

    $("#addFailureClassButton").click(function() {
        alert("add button pressed");

        var failure_class =  $("#idText").val();
        var description = $("#descriptionText").val();
        var myFailureClass = new FailureClass(failure_class,description);

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

        var id =   $("#idUpdateText").val();
        var name =  $("#nameUpdateText").val();
        var age = $("#ageUpdateText").val();

        var myViking = new MyCharacter(id,name,age);

        $.ajax({
            type: "PUT",
            url: "ragnar/ragnar",
            success: function () {
                alert("Viking updated");
            },
            data: JSON.stringify(myViking),
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


    $.ajax({
        type: "GET",
        url: "ragnar/ragnar",

        success: function (failureClassList) {
            $.each(failureClassList, function (index, value) {
                ;                $("#failureClassHolder").append("<li>" + value.failure_class + " " + value.description +"</li>");
            });
        }
    });


});