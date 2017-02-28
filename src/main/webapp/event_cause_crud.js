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
            url: "event_cause/add/",
            success: function () {
                alert("FailureClass added");
            },
            data: JSON.stringify(myFailureClass),
            contentType: "application/json"

        });
    });


    $("#updateEventCauseButton").click(function() {
        alert("update button pressed");

        var causeCode = $("#updateEventCauseCode");
        var id =  $("#updateEventCauseId").val();
        var description = $("#updateEventCauseDescription").val();

        var myEventCause = new EventCause(causeCode,id,description);

        $.ajax({
            type: "PUT",
            url: "event_cause/update/",
            success: function () {
                alert("Viking updated");
            },
            data: JSON.stringify(myViking),
            contentType: "application/json"

        });
    });


    $("#deleteEventCauseButton").click(function() {
        alert("delete button pressed");

        var causeCode = $("#updateEventCauseCode");
        var id =  $("#updateEventCauseId").val();
        $.ajax({
            type: "DELETE",
            url: "event_cause/delete/" + causeCode + "/" + id,
            success: function () {
                alert("Event Cause deleted");
            },
        });
    });

    $("#searchByIdEventCause").click(function() {
        var causeCode = $("#getEventCauseCode").val();
        var id =  $("#getEventId").val();
        $.ajax({
            type: "GET",
            url: "ragnar/ragnar/" + causeCode + "/" + id,
            success: function (value) {
                alert("EventCause found");
                $("#getEventCauseSearch").val(value.causeCode + " " + value.eventId + " " + value.description);

            },
            error:function () {
                alert("Not found");
            }
        });
    });


    $.ajax({
        type: "GET",
        url: "event_cause/allEventCauseInfo",

        success: function (failureClassList) {
            $.each(failureClassList, function (index, value) {
                ;                $("#EventCauseHolder").append("<li>" + value.failure_class + " " + value.description +"</li>");
            });
        }
    });


});