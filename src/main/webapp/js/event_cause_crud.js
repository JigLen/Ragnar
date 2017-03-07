var EventCause = function(causeCode, eventId, description) {
    this.causeCode = causeCode;
    this.eventId = eventId;
    this.description = description;
}

$(document).ready(function(){

    $("#addEventCauseButton").click(function() {

        var causeCode =  $("#causeCodeId").val();
        var eventId = $("#addEventId").val();
        var description = $("#addEventCauseDesc").val();
        var myEventCause = new EventCause(causeCode,eventId,description);

        $.ajax({
            type: "POST",
            url: "ragnar/event_cause",
            success: function () {
                alert("Event Cause added");
                location.reload();
            },
            error: function () {
                alert("Event Cause not found")
            },

            data: JSON.stringify(myEventCause),
            contentType: "application/json",

        });
    });

    $("#updateEventCauseButton").click(function() {
        var causeCode = $("#updateEventCauseCode").val();
        var id =  $("#updateEventCauseId").val();
        var description = $("#updateEventCauseDescription").val();

        var myEventCause = new EventCause(causeCode,id,description);

        $.ajax({
            type: "PUT",
            url: "ragnar/event_cause",
            success: function () {
                alert("Event Cause updated");
                location.reload();
            },
            error: function () {
                alert("Event Cause not updated")
            },
            data: JSON.stringify(myEventCause),
            contentType: "application/json"

        });
    });


    $("#deleteEventCauseButton").click(function() {
        var causeCode = $("#causeCodeDeleteText").val();
        var id =  $("#eventIdDeleteText").val();

        $.ajax({
            type: "DELETE",
            url: "ragnar/event_cause/" + causeCode + "/" + id,
            success: function () {
                alert("Event Cause deleted");
                location.reload();
            },
            error: function () {
                alert("Event Cause not deleted")
            },
        });
    });

    $("#searchByIdEventCause").click(function() {
        var causeCode = $("#getEventCauseCode").val();
        var id =  $("#getEventId").val();
        $.ajax({
            type: "GET",
            url: "ragnar/event_cause/" + causeCode + "/" + id,
            success: function (value) {
                alert("Event Cause found");
                $("#getEventCauseSearch").val(value.causeCode + " " + value.eventId + " " + value.description);
                location.reload();
            },
            error:function () {
                alert("Event Cause Not found");
            }
        });
    });

    $("#showEventCause").click(function() {
        $.ajax({
            type: "GET",
            url: "ragnar/event_cause",

            success: function (eventCauseList) {
                $.each(eventCauseList, function (index, value) {
                    $("#eventCauseHolder").append("<li>" + value.causeCode + " " + value.eventId + " " + value.description + "</li>");
                });
            }
        });
    });

    $("#closeEventCause").click(function() {
        $("#eventCauseHolder").empty();
    });
});