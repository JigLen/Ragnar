/**
 * Created by C07589301 on 06/03/2017.
 */
var BaseData = function( dateTime,  eventId,  failureClass,  ueType,  market,  operator,
     cellId,  duration,  causeCode,  neVersion,  imsi,  hier3Id,  hier32Id,
     hier321Id) {
    this.dateTime = dateTime;
    this.eventId = eventId;
    this.failureClass = failureClass;
    this.ueType = ueType;
    this.market = market;
    this.operator = operator;
    this.cellId = cellId;
    this.duration = duration;
    this.causeCode = causeCode;
    this.neVersion = neVersion;
    this.imsi = imsi;
    this.hier3Id = hier3Id;
    this.hier32Id = hier32Id;
    this.hier321Id = hier321Id;
}





$(document).ready(function(){

    $("#addBaseDataButton").click(function() {

        var dateTime =  $("#Date_Time").val();
        var eventId = $("#EventId").val();
        var failureClass =  $("#FailureClass_ID").val();
        var ueType =  $("#UE_Type_ID").val();
        var market = $("#Market").val();
        var operator =  $("#Operator_ID").val();
        var cellId = $("#Cell_ID").val();
        var duration =  $("#Duration").val();
        var causeCode = $("#CauseCode_ID").val();
        var neVersion = $("#NeVersionId").val();
        var imsi =  $("#IMSI_ID").val();
        var hier3Id = $("#hier3").val();
        var hier32Id =  $("#hier32").val();
        var hier321Id = $("#hier321").val();
        var myBaseData = new BaseData( dateTime,  eventId,  failureClass,  ueType,  market,  operator,
            cellId,  duration,  causeCode,  neVersion,  imsi,  hier3Id,  hier32Id,
            hier321Id);

        $.ajax({
            type: "POST",
            url: "ragnar/allBaseDataInfo",
            success: function () {
                alert("BaseData added");
                location.reload();
            },
            error: function(){
                alert("BaseData POST failure")
            },
            data: JSON.stringify(myBaseData),
            contentType: "application/json",
        });
    });


    $("#updateBaseDataButton").click(function() {
        alert("update button pressed");

        var dateTime =  $("#failureClassID").val();
        var eventId = $("#descriptionText").val();
        var failureClass =  $("#failureClassID").val();
        var ueType =  $("#failureClassID").val();
        var market = $("#descriptionText").val();
        var operator =  $("#failureClassID").val();
        var cellId = $("#descriptionText").val();
        var duration =  $("#failureClassID").val();
        var causeCode = $("#descriptionText").val();
        var neVersion = $("#descriptionText").val();
        var imsi =  $("#failureClassID").val();
        var hier3Id = $("#descriptionText").val();
        var hier32Id =  $("#failureClassID").val();
        var hier321Id = $("#descriptionText").val();
        var myBaseData = new BaseData( dateTime,  eventId,  failureClass,  ueType,  market,  operator,
            cellId,  duration,  causeCode,  neVersion,  imsi,  hier3Id,  hier32Id,
            hier321Id);

        $.ajax({
            type: "PUT",
            url: "ragnar/base_data",
            success: function () {
                alert("BaseData updated");
                location.reload();
            },
            error: function () {
                alert("BaseData Id not found")
            },
            data: JSON.stringify(myBaseData),
            contentType: "application/json"

        });
    });


    $("#deleteBaseDataButton").click(function() {
        var id =  $("#baseDataDeleteText").val();
        $.ajax({
            type: "DELETE",
            url: "ragnar/base_data/" + id,
            success: function () {
                alert("BaseData deleted");
                location.reload();
            },
            error: function () {
                alert("BaseData not deleted");
            },
        });
    });

    $("#searchByIdBaseData").click(function() {
        var id =  $("#getDaseDataId").val();
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/" + id,
            success: function (value) {
                alert("BaseData found");
                $("#getBaseDataResultId").val(Date(value.dateTime) + " " + value.eventId );
            },
            error:function () {
                alert("Not found");
            }
        });
    });


    $("#showBaseData").click(function() {
        $.ajax({
            type: "GET",
            url: "ragnar/base_data",

            success: function (baseDataList) {
                $.each(baseDataList, function (index, value) {
                    $("#baseDataHolder").append("<li>" + Date(value.dateTime) + " " + value.eventId + " " + value.failureClass
                        + " " + value.ueType + " " + value.market + " " + value.operator + " " + value.cellId
                        + " " + value.duration + " " + value.causeCode + " " + value.neVersion + " " + value.imsi
                        + " " + value.hier3Id + " " + value.hier32Id + " " + value.hier321Id  + "</li>");
                });
            }});
    });

    $("#closeBaseData").click(function() {
        $("#baseDataHolder").empty();
    });

});