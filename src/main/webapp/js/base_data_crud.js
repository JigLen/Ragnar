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
    var x = document.getElementById('tabletest');
    $("#US4Show").click(function() {
        var imsi = $("#select-box").val();
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/us4/" + imsi,
            success: function (baseDataList) {
                $('#tablebody').empty();
                $.each(baseDataList, function (index, value) {
                    var array = value.toString();
                    var strArray = array.split(",");
                    var eventID = strArray[0];
                    var causecode = strArray[1];
                    var imsi = strArray[2];
                    var description = strArray[3];
                    var dateTime = new Date(parseInt(strArray[4]));
                    alert(dateTime);

                    var tr = (
                        '<tr>' +
                        '<td>'+ eventID +'</td>'+
                        '<td>'+ causecode +'</td>'+
                        '<td>'+ imsi +'</td>'+
                        '<td>'+ description +'</td>'+
                        '<td>'+ dateTime +'</td>'+
                        '</tr>'
                    );

                    $('#tablebody').append(tr);
                });

                if (x.style.display === 'none') {
                    x.style.display = 'block';
                }
            },
            error: function(){
                alert("Error!");
            }
        });
    });

    $("#close").click(function() {
        x.style.display = 'none';
        $("#tablebody").empty();

    });
    /*************************** USER STORY 5 **********************************/

    $("#searchByImsiAndDatesUS5").click(function() {
        $("#US5Output").empty();
        var imsi = ($("#select_box_us5").val());
        var dateFrom = $("#getDateFromUs5").val();
        var dateTo = $("#getDateToUs5").val();
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
    $("#closeUserStory5").click(function() {
        //x.style.display = 'none';
        $("#tablebodyUs5").empty();
    });

    /*************************** USER STORY 6 **********************************/
    var xUs6 = document.getElementById('tableUs6');
    $("#US6SearchButton").click(function() {
        var imsi = ($("#select_box_us6").val());
        alert(imsi);
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/us6/"+imsi,
            success: function (value) {
                $("#tablebodyUs6").empty();
                $.each(value, function(index, value) {
                    var tr = (
                        '<tr>' +
                        '<td>'+ value +'</td>'+
                        '</tr>'
                    );
                    $('#tablebodyUs6').append(tr);
                });
                if(xUs6.style.display === 'none') {
                    xUs6.style.display = 'block';
                }
            }});
    });
    $("#closeUserStory6").click(function() {
        xUs6.style.display = 'none';
        $("#tablebodyUs6").empty();
    });


    /*************************** USER STORY 7 **********************************/
    var xUs7 = document.getElementById('tableUs7');
    $("#searchUs7").click(function() {
        var d1= $("#getDateFromUs7").val();
        var d2= $("#getDateToUs7").val();
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/us7/"+d1+"/"+d2,
            success: function (lst) {
                //$("#tablebodyUs7").empty();
                $.each(lst, function (index, value) {
                    var tr = (
                        '<tr>' +
                        '<td>'+ value +'</td>'+
                        '</tr>'
                    );
                    $('#tablebodyUs7').append(tr);
                });
                if (xUs7.style.display === 'none') {
                    xUs7.style.display = 'block';
                }
            },
            error:function () {
                alert("Date is not entered in the right format");
            }
        });
    });
    $("#closeUserStory7").click(function() {
        xUs7.style.display = 'none';
        $("#tablebodyUs7").empty();
    });


    /*************************** USER STORY 8 **********************************/
    var xUs8 = document.getElementById('tableUs8');
    $("#openUserStory8").click(function() {
        var model =$("#select_box_us8").val();
        var d1= $("#getDateFromUs8").val();
        var d2= $("#getDateToUs8").val();
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/us8/"+model+"/"+d1+"/"+d2,
            success: function (lst) {
                //$("#tablebodyUs8").empty();
                $.each(lst, function (index, value) {
                    var array = value.toString();
                    var strArray = array.split(",");
                    var model = strArray[0];
                    var count = strArray[1];
                    var tr = (
                        '<tr>' +
                        '<td>'+ model +'</td>'+
                        '<td>'+ count +'</td>'+
                        '</tr>'
                    );

                    $('#tablebodyUs8').append(tr);
                    //$("#imsiHolderByModel").append("<li>"+ model +  " " + count + "</li>");

                });
                if (xUs8.style.display === 'none') {
                    xUs8.style.display = 'block';
                }
            },
            error:function () {
                alert("Date is not entered in the right format");
            }
        });
    });
    $("#closeUserStory8").click(function() {
        xUs8.style.display = 'none';
        $("#tablebodyUs8").empty();
    });


    /*************************** USER STORY 9 **********************************/
    var xUs9 = document.getElementById('tableUs9');
    $("#showUserStory9").click(function() {
        alert("Test");
        var date1 = $("#getDate1").val();
        var date2 = $("#getDate2").val();
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/us9/" +date1 + "/" + date2,
            success: function (baseDataList) {
                //$("#tablebodyUs9").empty();
                alert("Inside");
                $.each(baseDataList, function (index, value) {
                    var array = value.toString();
                    var strArray = array.split(",");
                    var imsiVal = strArray[0];
                    var count = strArray[1];
                    var sum = strArray[2];
                    //$("#query9Holder").append("<li>"  + imsiVal + " " + count + " " + sum +"</li>");
                    var tr = (
                        '<tr>' +
                        '<td>'+ imsiVal +'</td>'+
                        '<td>'+ count +'</td>'+
                        '<td>'+ sum +'</td>'+
                        '</tr>'
                    );
                    $('#tablebodyUs9').append(tr);
                });
                if (xUs9.style.display === 'none') {
                    xUs9.style.display = 'block';
                }
            },
            error:function () {
                alert("Date is not entered in the right format");
            }
        });
    });

    $("#closeUserStory9").click(function() {
        xUs9.style.display = 'none';
        $("#tablebodyUs9").empty();
    });


    var xUs10 = document.getElementById('tableUs10');
    $("#searchsUs10").click(function() {
        var model =$("#select_box_us10").val();
        $.ajax({
            type: "GET",

            url: "ragnar/base_data/us10/"+model,
            success: function (lst) {
                $("#tablebodyUs10").empty();
                $.each(lst, function (index, value) {
                    var array = value.toString();
                    var strArray = array.split(",");
                    var eventId = strArray[0];
                    var causeCode = strArray[1];
                    var description = strArray[2];
                    var count = strArray[3];
                    var model = strArray[4];
                    var tr = (
                        '<tr>' +
                        '<td>'+ eventId +'</td>'+
                        '<td>'+ causeCode +'</td>'+
                        '<td>'+ description +'</td>'+
                        '<td>'+ count +'</td>'+
                        '<td>'+ model +'</td>'+
                        '</tr>'
                    );

                    $('#tablebodyUs10').append(tr);
                    //$("#imsiHolderByModel").append("<li>"+ model +  " " + count + "</li>");

                });
                if (xUs10.style.display === 'none') {
                    xUs10.style.display = 'block';
                }
            },
            error:function () {
                alert("Date is not entered in the right format");
            }
        });
    });

    $("#closeUserStory10").click(function() {
        xUs10.style.display = 'none';
        $("#tablebodyUs10").empty();
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
    var xUs11 = document.getElementById('tableUs11');
    $("#mostCommonMarketOperatorCellCombo").click(function() {
        var date1 = $("#getDateFromUs11").val();
        var date2 = $("#getDateToUs11").val();
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/us11/" + date1 + "/" + date2,
            success: function (lst) {
               // mostCommonMarketOperatorCellComboHolder.empty();
                //$("#tablebodyUs11").empty();
                $.each(lst, function (index, value) {
                    var array = value.toString();
                    var strArray = array.split(",");
                    var market = strArray[0];
                    var operator = strArray[1];
                    var cellId = strArray[2];

                    var tr = (
                        '<tr>' +
                        '<td>'+ market +'</td>'+
                        '<td>'+ operator +'</td>'+
                        '<td>'+ cellId +'</td>'+
                        '</tr>'
                    );

                    $('#tablebodyUs11').append(tr);
                   // $("#mostCommonMarketOperatorCellComboHolder").append("<li>" + market + " " + operator + " " + cellId + "</li>")
                });
                if (xUs11.style.display === 'none') {
                    xUs11.style.display = 'block';
                }
            },
            error:function () {
                alert("Not Found");
            }
        });
    });

    $("#closeUserStory11").click(function() {
        xUs11.style.display = 'none';
        $("#tablebodyUs11").empty();
    });

    /*************************** USER STORY 12 **********************************/
    var xUs12 = document.getElementById('tableUs12');
    $("#mostCommonIMSIFailsByDate").click(function() {
        var d1= $("#getDateFromUs12").val();
        var d2= $("#getDateToUs12").val();
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/us12/"+d1+"/"+d2,
            success: function (lst) {
                $("#tablebodyUs12").empty();
                //mostCommonIMSIFailsByDateHolder.empty();
                //$("#mostCommonIMSIFailsByDateHolder").empty();
                $.each(lst, function (index, value) {
                    //$("#mostCommonIMSIFailsByDateHolder").append("<li>"+value+"</li>");
                    var tr = (
                        '<tr>' +
                        '<td>'+ value +'</td>'+
                        '</tr>'
                    );
                    $('#tablebodyUs12').append(tr);
                });
                if(xUs12.style.display === 'none') {
                    xUs12.style.display = 'block';
                }
            },
            error:function () {
                alert("Date is not entered in the right format");
            }
        });
    });

    $("#closeUserStory12").click(function() {
        xUs12.style.display = 'none';
        $("#tablebodyUs12").empty();
    });

    /*************************** USER STORY 14 **********************************/
    var xUs14 = document.getElementById('tableUs14');
    $("#US14SearchButton").click(function() {
        $("#tablebodyUs14").empty();
        var num;
        var failure = $("#select_box_us14").val();
        var x = failure.localeCompare("EMERGENCY");
        var y = failure.localeCompare("HIGH PRIORITY ACCESS");
        var z = failure.localeCompare("MT ACCESS");
        if(x == 1)num = 0;
        if(y == 1)num = 1;
        if(z == 1)num = 2;
        alert(num);
        //failureClass = parseInt(failureClass);
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/us14/" + num,
            success: function (baseDataList) {
                $.each(baseDataList, function (index, value) {
                    //$("#US14List").append("<li>" + value + "</
                    var tr = (
                        '<tr>' +
                        '<td>'+ value +'</td>'+
                        '</tr>'
                    );
                    $('#tablebodyUs14').append(tr);
                });
            },
            error: function(){
                alert("Error");
            }
        });
        if(xUs14.style.display === 'none') {
            xUs14.style.display = 'block';
        }
    });

    $("#closeUserStory14").click(function() {
        xUs14.style.display = 'none';
        $("#tablebodyUs14").empty();
    });

    $.ajax({
        type: "GET",
        url: "ragnar/base_data/getUniqueFailureTypes",
        success: function (value) {
            var array = value.toString();
            var strArray = array.split(",");
            $.each(strArray, function (index, value)
            {
                var option = document.createElement("option");
                option.text = value;
                option.value = value;
                var select_us14 = document.getElementById("select_box_us14");
                select_us14.appendChild(option);
            });
        },
        error:function () {
            alert("Not found");
        }
    });
});