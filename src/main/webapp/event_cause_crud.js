var EventCause = function(causeCode, eventId, description) {
    this.causeCode = causeCode;
    this.eventId = eventId;
    this.description = description;
}

$(document).ready(function(){

    $("#addEventCauseButton").click(function() {
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


    $("#updateEventCauseButton").click(function() {
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


    $("#deleteEventCauseButton").click(function() {
        alert("delete button pressed");

        var id =  $("#idText").val();
        $.ajax({
            type: "DELETE",
            url: "ragnar/ragnar/" + id,
            success: function () {
                alert("Event Cause deleted");
            },
        });
    });


    $.ajax({
        type: "GET",
        url: "ragnar/ragnar/allEventCauseInfo",

        success: function (failureClassList) {
            $.each(failureClassList, function (index, value) {
                ;                $("#EventCauseHolder").append("<li>" + value.failure_class + " " + value.description +"</li>");
            });
        }
    });


});

