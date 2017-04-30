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


var imsiArray = [];
var countArray = [];
var durationArray = [];
//JSON
var countSeries = [];
var durationSeries = [];




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
    var alert4 = document.getElementById('alert4');
    var x = document.getElementById('tabletest');
    $("#US4Show").click(function() {
        var imsi = $("#select-box").val();
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/us4/" + imsi,
            success: function (baseDataList) {
                alert4.style.display = 'none';
                $('#tablebody').empty();
                $.each(baseDataList, function (index, value) {
                    var array = value.toString();
                    var strArray = array.split(",");
                    var eventID = strArray[0];
                    var causecode = strArray[1];
                    var failClassNo = strArray[2];
                    var failClass = strArray[3];
                    var description = strArray[4];
                    var dateTime = new Date(parseInt(strArray[5]));

                    var tr = (
                        '<tr>' +
                        '<td>'+ eventID +'</td>'+
                        '<td>'+ causecode +'</td>'+
                        '<td>'+ failClassNo +'</td>'+
                        '<td>'+ failClass +'</td>'+
                        '<td>'+ description +'</td>'+
                        '<td>'+ dateTime +'</td>'+
                        '</tr>'
                    );

                    $('#tablebodyUs4').append(tr);
                });

                if (x.style.display === 'none') {
                    x.style.display = 'block';
                }
            },
            error: function(){
                alert4.style.display = 'block';
            }
        });
    });

    $("#close").click(function() {
        x.style.display = 'none';
        $("#tablebody").empty();

    });
    /*************************** USER STORY 5 **********************************/
    var alert5 = document.getElementById('alert5');

    $("#searchByImsiAndDatesUS5").click(function() {
        $("#US5Output").empty();
        var imsi = ($("#select_box_us5").val());
        var dateFrom = $("#getDateFromUs5").val();
        var dateTo = $("#getDateToUs5").val();
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/us5/"+imsi+"/"+dateFrom+"/"+dateTo,
            success: function (value) {
                alert5.style.display = 'none';
                $("#US5Output").append("Number of failures for a given IMSI and time period: " + value);
            },
            error: function(){
                alert5.style.display = 'block';
            }
        });
    });
    $("#closeUserStory5").click(function() {
        //x.style.display = 'none';
        $("#tablebodyUs5").empty();
    });

    /*************************** USER STORY 6 **********************************/
    var xUs6 = document.getElementById('tableUs6');
    var alert6 = document.getElementById('alert6');
    $("#US6SearchButton").click(function() {
        var imsi = ($("#select_box_us6").val());
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/us6/"+imsi,
            success: function (value) {
                alert6.style.display = 'none';
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
            },
        error: function(){
            alert6.style.display = 'block';
        }});
    });
    $("#closeUserStory6").click(function() {
        xUs6.style.display = 'none';
        $("#tablebodyUs6").empty();
    });


    /*************************** USER STORY 7 **********************************/
    var xUs7 = document.getElementById('tableUs7');
    var alert7 = document.getElementById('alert7');
    $("#searchUs7").click(function() {
        var d1= $("#getDateFromUs7").val();
        var d2= $("#getDateToUs7").val();
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/us7/"+d1+"/"+d2,
            success: function (lst) {
                alert7.style.display = 'none';
                $("#tablebodyUs7").empty();
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
                alert7.style.display = 'block';
            }
        });
    });
    $("#closeUserStory7").click(function() {
        xUs7.style.display = 'none';
        $("#tablebodyUs7").empty();
    });


    /*************************** USER STORY 8 **********************************/
    var alert8 = document.getElementById('alert8');
    var xUs8 = document.getElementById('tableUs8');
    $("#openUserStory8").click(function() {
        var model =$("#select_box_us8").val();
        var d1= $("#getDateFromUs8").val();
        var d2= $("#getDateToUs8").val();
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/us8/"+model+"/"+d1+"/"+d2,
            success: function (lst) {
                alert8.style.display = 'none';
                $("#tablebodyUs8").empty();
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
                alert8.style.display = 'block';
            }
        });
    });
    $("#closeUserStory8").click(function() {
        xUs8.style.display = 'none';
        $("#tablebodyUs8").empty();
    });


    /*************************** USER STORY 9 **********************************/
    var graphBt9 = document.getElementById('graph9');
    var xUs9 = document.getElementById('tableUs9');
    var us9Body = document.getElementById('tablebodyUs9');
    var alert9 = document.getElementById('alert9');
    $("#showUserStory9").click(function() {
        var date1 = $("#getDate1").val();
        var date2 = $("#getDate2").val();
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/us9/" +date1 + "/" + date2,
            success: function (baseDataList) {
                alert9.style.display = 'none';

                $("#tablebodyUs9").empty();
                imsiArray = [];
                countArray = [];
                durationArray = [];

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

                    imsiArray.push(imsiVal);
                    countArray.push(count);
                    durationArray.push(sum);
                    $('#tablebodyUs9').append(tr);
                });
                for (var i = 0; i < durationArray.length; i++) {
                    durationSeries.push([i, parseInt(durationArray[i])]);
                    countSeries.push([i, parseInt(countArray[i])]);
                }
                graphBt9.style.display = 'block';
                if (xUs9.style.display === 'none') {
                    xUs9.style.display = 'block';
                    us9Body.style.display = 'block';

                }
            },
            error: function(){
                alert9.style.display = 'block';
            }});
    });

    $("#closeUserStory9").click(function() {
        xUs9.style.display = 'none';
        $("#tablebodyUs9").empty();
    });

    /*************************** USER STORY 10 **********************************/
    var alert10 = document.getElementById('alert10');
    var xUs10 = document.getElementById('tableUs10');
    $("#searchUs10").click(function() {
        var model =$("#select_box_us10").val();

        if(model != null) {
            $.ajax({
                type: "GET",

                url: "ragnar/base_data/us10/" + model,
                success: function (lst) {
                    alert10.style.display = 'none';
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
                            '<td>' + eventId + '</td>' +
                            '<td>' + causeCode + '</td>' +
                            '<td>' + description + '</td>' +
                            '<td>' + count + '</td>' +
                            '<td>' + model + '</td>' +
                            '</tr>'
                        );

                        $('#tablebodyUs10').append(tr);

                    });

                        xUs10.style.display = 'block';
                        document.getElementById('tablebodyUs10').style.display = 'block';
                },
                error: function () {
                    alert10.style.display = 'block';
                    xUs10.style.display = 'none';
                    document.getElementById('tablebodyUs10').style.display = 'none';
                }
            });
        }
        else{
            alert10.style.display = 'block';
        }
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
    var alert11 = document.getElementById('alert11');
    var xUs11 = document.getElementById('tableUs11');
    var graphBt11 = document.getElementById('graph11');
    $("#mostCommonMarketOperatorCellCombo").click(function() {
        var date1 = $("#getDateFromUs11").val();
        var date2 = $("#getDateToUs11").val();
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/us11/" + date1 + "/" + date2,
            success: function (lst) {
               // mostCommonMarketOperatorCellComboHolder.empty();
                $("#tablebodyUs11").empty();
                $('#table11Graph').empty();                   // $("#mostCommonMarketOperatorCellComboHolder").append("<li>" + market + " " + operator + " " + cellId + "</li>")

                var first = true;
                $.each(lst, function (index, value) {
                    var array = value.toString();
                    var strArray = array.split(",");
                    var market = strArray[0];
                    var operator = strArray[1];
                    var cellId = strArray[2];
                    var count = strArray[3]
                    var tr = (
                        '<tr>' +
                        '<td>'+ market +'</td>'+
                        '<td>'+ operator +'</td>'+
                        '<td>'+ cellId +'</td>'+
                        '<td>'+ count +'</td>'+
                        '</tr>'
                    );

                    var tr2 = (
                        '<tr>' +
                        '<td>' + '"' + market  + ',' + operator + '"' + '</td>'+
                        '<td>'+ count +'</td>'+
                        '</tr>'
                    );

                    $('#tablebodyUs11').append(tr);

                    if(first){
                        $('#table11Graph').append(tr2);                   // $("#mostCommonMarketOperatorCellComboHolder").append("<li>" + market + " " + operator + " " + cellId + "</li>")
                        first = false;
                    }
                    $('#table11Graph').append(tr2);                   // $("#mostCommonMarketOperatorCellComboHolder").append("<li>" + market + " " + operator + " " + cellId + "</li>")
                });
                graphBt11.style.display = 'block';
                if (xUs11.style.display === 'none') {
                    xUs11.style.display = 'block';
                }
            },
            error:function () {
                alert11.style.display = 'block';
            }
        });
    });

    $("#closeUserStory11").click(function() {
        xUs11.style.display = 'none';
        $("#tablebodyUs11").empty();
    });

    /*************************** USER STORY 12 **********************************/
    var alert12 = document.getElementById('alert12');
    var xUs12 = document.getElementById('tableUs12');
    var graphBt12 = document.getElementById('graph12');
    $("#mostCommonIMSIFailsByDate").click(function() {
        var d1= $("#getDateFromUs12").val();
        var d2= $("#getDateToUs12").val();
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/us12/"+d1+"/"+d2,
            success: function (lst) {
                alert12.style.display = 'none';
                $("#tablebodyUs12").empty();
                $('#table12Graph').empty();                   // $("#mostCommonMarketOperatorCellComboHolder").append("<li>" + market + " " + operator + " " + cellId + "</li>")

                var first = true;
                $.each(lst, function (index, value) {
                    var array = value.toString();
                    var strArray = array.split(",");
                    var imsi = strArray[0];
                    var count = strArray[1];
                    var tr = (
                        '<tr>' +
                        '<td>'+ '"' + imsi + '"' +'</td>'+
                        '<td>'+ count +'</td>'+
                        '</tr>'
                    );
                    $('#tablebodyUs12').append(tr);
                    if(first){
                        $('#table12Graph').append(tr);
                        first = false;
                    }
                    $('#table12Graph').append(tr);
                });
                graphBt12.style.display = 'block';
                if (xUs12.style.display === 'none') {
                    xUs12.style.display = 'block';
                }
            },
            error:function () {
                alert12.style.display = 'block';
            }
        });
    });

    $("#closeUserStory12").click(function() {
        xUs12.style.display = 'none';
        $("#tablebodyUs12").empty();
    });

    /*************************** USER STORY 14 **********************************/
    var alert14 = document.getElementById('alert14');
    var xUs14 = document.getElementById('tableUs14');
    $("#US14SearchButton").click(function() {
        $("#tablebodyUs14").empty();
        var num;
        var temp = $("#select_box_us14").val();
        var failureType = new String(temp);
        if(failureType.trim() == "EMERGENCY")num = 0;
        if(failureType.trim() == "HIGH PRIORITY ACCESS")num = 1;
        if(failureType.trim() == "MT ACCESS")num = 2;
        if(failureType.trim() == "MO SIGNALLING")num = 3;
        if(failureType.trim() == "MO DATA")num = 4;
        $.ajax({
            type: "GET",
            url: "ragnar/base_data/us14/" + num,
            success: function (baseDataList) {
                alert14.style.display = 'none';
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
                alert14.style.display = 'block';
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