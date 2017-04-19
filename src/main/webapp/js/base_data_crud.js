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
        var id =  $("#getBaseDataId").val();
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/"+ id,
            success: function (value) {
                alert("BaseData found");
                $("#getBaseDataResultId").val(Date(value.dateTime) + " " + value.eventId );
            },
            error:function () {
                alert("Not found");
            }
        });
    });

    /*************************** USER STORY 4 **********************************/
    $("#US4Show").click(function() {
        var imsi = $("#getImsiNum").val();
        alert(imsi);
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/userStory4/" + imsi,
            success: function (baseDataList) {
                alert("Inside");
                $.each(baseDataList, function (index, value) {
                    var array = value.toString();
                    var strArray = array.split(",");
                    var eventID = strArray[0];
                    var causecode = strArray[1];
                    var imsi = strArray[2];
                    var description = strArray[3];

                    $("#query4Holder").append("<li>"  + eventID + " " + causecode
                        + " " + imsi + " " + description + "</li>");
                });
                /*
                 $("#query4Holder").append("<li>"  + value.eventId + " " + value.causeCode
                 + " " + value.failureClass + " " + value.imsi + "</li>");
                 });*/
            },
            error: function(){
                alert("Error!");
            }
        });
    });

    $("#close").click(function() {
        $("#query4Holder").empty();
    });
    /*************************** USER STORY 5 **********************************/

    $("#searchByImsiAndDatesUS5").click(function() {
        $("#US5Output").empty();
        var imsi = ($("#imsiCodeToSearchUS5").val());
        var dateFrom = $("#getDateFromUS5").val();
        var dateTo = $("#getDateToUS5").val();
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/us5/"+imsi+"/"+dateFrom+"/"+dateTo,
            success: function (value) {
                $("#US5Output").append("Number of failures for a given IMSI and time period: " + value);
            },
            error: function(){
                $("#US5Output").append = "Error!!";
            }
        });
    });

    /*************************** USER STORY 6 **********************************/
    $("#getUniqueCauseCodes").click(function() {
        var imsi = ($("#getCauseCodeimsi").val());
        alert(imsi);
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/userStory6/"+imsi,
            success: function (value) {
                $.each(value, function(index, value) {
                    $("#UniqueCauseCodesHolder").append("<li>" + value + "</li>");
                });
            }});
    });
    /*************************** USER STORY 7 **********************************/
    $("#dateCheck").click(function() {
        var d1= $("#getDate1").val();
        var d2= $("#getDate2").val();
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/"+d1+"/"+d2,
            success: function (lst) {
                $.each(lst, function (index, value) {
                    $("#misiHolderByDate").append("<li>"+ value.imsi + "</li>");
                });
            },
            error:function () {
                alert("Date is not entered in the right format");
            }
        });
    });

    /*************************** USER STORY 9 **********************************/
    $("#showUserStory9").click(function() {
        alert("Test");
        var date1 = $("#getDate1").val();
        var date2 = $("#getDate2").val();
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/userStory9/" +date1 + "/" + date2,

            success: function (baseDataList) {
                $("#query9Holder").empty();
                alert("Inside");
                $.each(baseDataList, function (index, value) {
                    var array = value.toString();
                    var strArray = array.split(",");
                    var imsiVal = strArray[0];
                    var count = strArray[1];
                    var sum = strArray[2];
                    $("#query9Holder").append("<li>"  + imsiVal + " " + count + " " + sum +"</li>");
                });
            }});
    });

    $("#closeUserStory9").click(function() {
        $("#query9Holder").empty();
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

    /*************************** USER STORY 11 **********************************/
    $("#mostCommonMarketOperatorCellCombo").click(function() {
        var date1 = $("#US11DateFrom").val();
        var date2 = $("#US11DateTo").val();
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/userStory11/" + date1 + "/" + date2,
            success: function (lst) {
               // mostCommonMarketOperatorCellComboHolder.empty();
                $("#mostCommonMarketOperatorCellComboHolder").empty();
                $.each(lst, function (index, value) {
                    var array = value.toString();
                    var strArray = array.split(",");
                    var market = strArray[0];
                    var operator = strArray[1];
                    var cellId = strArray[2];
                    $("#mostCommonMarketOperatorCellComboHolder").append("<li>" + market + " " + operator + " " + cellId + "</li>")
                });
            },
            error:function () {
                alert("Not Found");
            }
        });
    });

    $("#closeUserStory11").click(function() {
        $("#mostCommonMarketOperatorCellComboHolder").empty();

    });
    /*************************** USER STORY 12 **********************************/
    $("#mostCommonIMSIFailsByDate").click(function() {
        var d1= $("#Date1").val();
        var d2= $("#Date2").val();
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/userStory12/"+d1+"/"+d2,
            success: function (lst) {
                //mostCommonIMSIFailsByDateHolder.empty();
                $("#mostCommonIMSIFailsByDateHolder").empty();
                $.each(lst, function (index, value) {
                    var currentRow = document.createElement('tr');
                    var imsiCell = currentRow.insertCell(0);
                    var failuresCell = currentRow.insertCell(1);
                    imsiCell.innerHTML = value[0];
                    failuresCell.innerHTML = value[1];
                    $("#mostCommonIMSIFailsByDateHolder").append(currentRow);
                });
            },
            error:function () {

                alert("Oh no, Error");
            }
        });
    });

    $("#closeUserStory12").click(function() {
        $("#mostCommonIMSIFailsByDateHolder").empty();
    });

    /*************************** USER STORY 14 **********************************/

    $("#US14SearchButton").click(function() {
        $("#US14List").empty();
        var failureClass =  $("#US14Imsi").val();
        failureClass = parseInt(failureClass);
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/UserStory14/" + failureClass,

            success: function (baseDataList) {
                $.each(baseDataList, function (index, value) {
                    $("#US14List").append("<li>" + value + "</li>");
                });
            },
            error: function(){
                alert("Error");
            }
        });
    });

    $("#US14CloseList").click(function() {
        $("#US14List").empty();
    });

});