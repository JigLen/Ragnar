/**
 * Created by C07589301 on 03/03/2017.
 */
var MccMnc = function(mcc, mnc, country, operator) {
    this.mcc = mcc;
    this.mnc = mnc;
    this.country = country;
    this.operator = operator;
}

$(document).ready(function(){

    $("#addMCC_MNCButton").click(function() {

        var mccCode =  $("#mccCodeId").val();
        var mncCode = $("#mncId").val();
        var country = $("#addCountryDesc").val();
        var operator = $("#addOperatorDesc").val();
        var myMccMnc= new MccMnc(mccCode, mncCode, country, operator) ;

        $.ajax({
            type: "POST",
            url: "ragnar/mcc_mnc",
            success: function () {
                alert("Event Cause added");
                location.reload();
            },
            error: function () {
                alert("MccMnc not found")
            },

            data: JSON.stringify(myMccMnc),
            contentType: "application/json",

        });
    });

    $("#updateMCC_MNCButton").click(function() {
        var mccCode =  $("#updateMCCCode").val();
        var mncCode = $("#updateMNCId").val();
        var country = $("#updateCountryDescription").val();
        var operator = $("#updateOperatorDescription").val();

        var myMccMnc= new MccMnc(mccCode, mncCode, country, operator) ;

        $.ajax({
            type: "PUT",
            url: "ragnar/mcc_mnc",
            success: function () {
                alert("MCC_MNC updated");
                location.reload();
            },
            error: function () {
                alert("MCC_MNC not updated")
            },
            data: JSON.stringify(myMccMnc),
            contentType: "application/json"

        });
    });


    $("#deleteMcc_MncButton").click(function() {
        var mcc = $("#mccDeleteText").val();
        var mnc =  $("#mncDeleteText").val();

        $.ajax({
            type: "DELETE",
            url: "ragnar/mcc_mnc/" + mcc + "/" + mnc,
            success: function () {
                alert("MCC_MNC deleted");
                location.reload();
            },
            error: function () {
                alert("MCC_MNC not deleted")
            },
        });
    });

    $("#searchBy_MCC_MNC_Code").click(function() {
        var mcc = $("#getMCCCode").val();
        var mnc =  $("#getMNCId").val();
        $.ajax({
            type: "GET",
            url: "ragnar/mcc_mnc/" + mcc + "/" + mnc,
            success: function (value) {
                alert("MCC MNC found");
                $("#getMCC_MNCSearch").val(value.mcc + " " + value.country + " " + value.operator);
                location.reload();
            },
            error:function () {
                alert("MCC MNC Not found");
            }
        });
    });

    $("#showMccMNC").click(function() {
        $.ajax({
            type: "GET",
            url: "ragnar/mcc_mnc",
            success: function (mccMncList) {
                $.each(mccMncList, function (index, value) {
                    $("#mcc_mncHolder").append("<li>" + value.mcc + value.mnc + " " + value.country + " " + value.operator+ "</li>");
                });
            }
        });
    });

    $("#closeMccMnc").click(function() {
        $("#mcc_mncHolder").empty();
    });


});