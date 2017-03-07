var UE = function( tac,  marketingName,  manufacturer,  accessCapability,  model,  vendorName,  ueType,  os,  inputMode) {
    this.tac = tac;
    this.marketingName = marketingName;
    this.manufacturer = manufacturer;
    this.accessCapability = accessCapability;
    this.model = model;
    this.vendorName = vendorName;
    this.ueType = ueType;
    this.os = os;
    this.inputMode = inputMode;
}


$(document).ready(function(){

    $("#addUEButton").click(function() {

        var tac =  $("#Tac").val();
        var marketingName = $("#Marketing_Name").val();
        var manufacturer =  $("#Manufacturer").val();
        var accessCapability = $("#Access_Capability").val();
        var model =  $("#Model").val();
        var vendorName = $("#Vendor_Name").val();
        var ueType =  $("#UE_Type").val();
        var os = $("#OS").val();
        var inputMode = $("#Input_Mode").val();
        var myUe = new UE( tac,  marketingName,  manufacturer,  accessCapability,  model,  vendorName,  ueType,  os,  inputMode);

        $.ajax({
            type: "POST",
            url: "ragnar/ue",
            success: function () {
                alert("ue added");
                location.reload();
            },
            error: function(){
                alert("ue Class POST failure")
            },
            data: JSON.stringify(myUe),
            contentType: "application/json",


        });
    });


    $("#updateUEButton").click(function() {
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


    $("#deleteUEButton").click(function() {
        var id =  $("#ueDeleteText").val();
        $.ajax({
            type: "DELETE",
            url: "ragnar/ue/" + id,
            success: function () {
                alert("UE deleted");
                location.reload();
            },
            error: function () {
                alert("UE not deleted");
            },
        });
    });


    $("#searchByIdUe").click(function() {
        var id =  $("#tacCodeToSearch").val();
        $.ajax({
            type: "GET",
            url: "ragnar/ue/" + id,
            success: function (value) {
                alert("UE found");
                $("#getResultId").val(value.tac + " " + value.manufacturer );
            },
            error:function () {
                alert("Not found");
            }
        });
    });


    $("#showUE").click(function() {
        $.ajax({
            type: "GET",
            url: "ragnar/ue",

            success: function (ueList) {
                $.each(ueList, function (index, value) {
                    $("#ueHolder").append("<li>" + value.tac + " " + value.marketingName + value.manufacturer + " " + value.accessCapability
                        + value.model + " " + value.vendorName
                        + value.ueType + " " + value.os + " " + value.inputMode+"</li>");
                });
            }
        });
    });

    $("#closeUE").click(function() {
        $("#ueHolder").empty();
    });

});/**
 * Created by C07589301 on 02/03/2017.
 */
