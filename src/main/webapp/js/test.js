/**
 * Created by User on 14-Apr-17.
 */
$(document).ready(function() {

    var currentQuery = 0;
    var queryOpenFlag = false;

    function showCurrentQueryOnly(current){
        queryID = "";
    }


    $.ajax({
        type: "GET",
        url: "ragnar/base_data/getUniqueImsi",
        success: function (value) {
            var array = value.toString();
            var strArray = array.split(",");
            $.each(strArray, function (index, value)
            {
                var option = document.createElement("option");
                option.text = value;
                option.value = value;

                var option_us5 = document.createElement("option");
                option_us5.text = value;
                option_us5.value = value;

                var option_us6 = document.createElement("option");
                option_us6.text = value;
                option_us6.value = value;

                var select = document.getElementById("select-box");
                var select_us5 = document.getElementById("select_box_us5");
                var select_us6 = document.getElementById("select_box_us6");

                select.appendChild(option);
                select_us5.appendChild(option_us5);
                select_us6.appendChild(option_us6);
            });
        },
        error:function () {
            alert("Not found");
        }
    });

    $.ajax({
        type: "GET",
        url: "ragnar/base_data/getUniqueModels",
        success: function (value) {
            var array = value.toString();
            var strArray = array.split(",");
            $.each(strArray, function (index, value)
            {
                var optionUs8 = document.createElement("option");
                optionUs8.text = value;
                optionUs8.value = value

                var optionUs10 = document.createElement("option");
                optionUs10.text = value;
                optionUs10.value = value;

                var select_us8 = document.getElementById("select_box_us8");
                var select_us10 = document.getElementById("select_box_us10");

                select_us8.appendChild(optionUs8);
                select_us10.appendChild(optionUs10);
            });
        },
        error:function () {
            alert("Not found");
        }
    });

    $('#userstory1').click(function () {
            var x = document.getElementById('us1Div');
            if (x.style.display === 'none' /*&& queryOpenFlag === false*/) {
                x.style.display = 'block';
                //queryOpenFlag = true;
            } else if (x.style.display === 'block' /*&& queryOpenFlag === true*/) {
                x.style.display = 'none';
                //queryOpenFlag = false;
            }

    });


    $('#userstory2').click(function () {
        var x = document.getElementById('us2Div');
        if (x.style.display === 'none' /*&& queryOpenFlag === false*/) {
            x.style.display = 'block';
            queryOpenFlag = true;
        } else if(x.style.display === 'block' /*&& queryOpenFlag === true*/) {
            x.style.display = 'none';
            queryOpenFlag = false;
        }
    });


    $('#userstory4').click(function () {

        var x = document.getElementById('us4Div');
        var us4ImsiPicker =  document.getElementById('select-box');

        if (x.style.display === 'none' /*&& queryOpenFlag === false*/) {
            x.style.display = 'block';
            queryOpenFlag = true;
        } else if(x.style.display === 'block' /*&& queryOpenFlag === true*/) {
            x.style.display = 'none';
            us4ImsiPicker.value = 'Select IMSI';
            queryOpenFlag = false;
        }
    });


    $('#userstory5').click(function () {

        var x = document.getElementById('us5Div');
        var us5ImsiPicker =  document.getElementById('select_box_us5');
        var us5DateFrom =  document.getElementById('getDateFromUs5');
        var us5DateTo =  document.getElementById('getDateToUs5');
        if (x.style.display === 'none' && queryOpenFlag === false) {
            x.style.display = 'block';
            queryOpenFlag = true;
        } else if(x.style.display === 'block' && queryOpenFlag === true) {
            x.style.display = 'none';
            us5ImsiPicker.value = 'Select IMSI';
            us5DateFrom.value = '';
            us5DateTo.value = '';
            us5DateFrom.placeholder = 'Enter Date From';
            us5DateTo.placeholder = 'Enter Date To';
            queryOpenFlag = false;
        }
    });


    $('#userstory6').click(function () {

        var x = document.getElementById('us6Div');
        var us6ImsiPicker =  document.getElementById('select_box_us6');
        if (x.style.display === 'none' && queryOpenFlag === false) {
            x.style.display = 'block';
            queryOpenFlag = true;
        } else if(x.style.display === 'block' && queryOpenFlag === true) {
            x.style.display = 'none';
            us6ImsiPicker.value = 'Select IMSI';
            queryOpenFlag = false;
        }
    });


    $('#userstory7').click(function () {
        var us7DateFrom =  document.getElementById('getDateFromUs7');
        var us7DateTo =  document.getElementById('getDateToUs7');
        var x = document.getElementById('us7Div');
        if (x.style.display === 'none' && queryOpenFlag === false) {
            x.style.display = 'block';
            queryOpenFlag = true;
        } else if(x.style.display === 'block' && queryOpenFlag === true) {
            x.style.display = 'none';
            us7DateFrom.value = '';
            us7DateTo.value = '';
            us7DateFrom.placeholder = 'Enter Date From';
            us7DateTo.placeholder = 'Enter Date To';
            queryOpenFlag = false;
        }
    });


    $('#userstory8').click(function () {

        var x = document.getElementById('us8Div');
        //var us8Body = document.getElementById('tablebodyUs8');
        var us8ModelPicker =  document.getElementById('select_box_us8');
        var us8DateFrom =  document.getElementById('getDateFromUs8');
        var us8DateTo =  document.getElementById('getDateToUs8');
        if (x.style.display === 'none' && queryOpenFlag === false)
        {
            x.style.display = 'block';
            queryOpenFlag = true;
        }
        else if(x.style.display === 'block' && queryOpenFlag === true)
        {
            x.style.display = 'none';
            //us8Body.style.display = 'none';
            us8ModelPicker.value = 'Select Model';
            us8DateFrom.value = '';
            us8DateTo.value = '';
            us8DateFrom.placeholder = 'Enter Date From';
            us8DateTo.placeholder = 'Enter Date To';
            queryOpenFlag = false;
        }
    });


    $('#userstory9').click(function () {

        var x = document.getElementById('us9Div');
        var us9Body = document.getElementById('tablebodyUs9');
        var us9DateFrom =  document.getElementById('getDate1');
        var us9DateTo =  document.getElementById('getDate2');
        if (x.style.display === 'none' && queryOpenFlag === false)
        {
            x.style.display = 'block';
            queryOpenFlag = true;
        }
        else if(x.style.display === 'block' && queryOpenFlag === true)
        {
            x.style.display = 'none';
            us9Body.style.display = 'none';
            us9DateFrom.value = '';
            us9DateTo.value = '';
            us9DateFrom.placeholder = 'Enter Date From';
            us9DateTo.placeholder = 'Enter Date To';
            queryOpenFlag = false;
        }
    });


    $('#userstory10').click(function () {
        var us10ModelPicker =  document.getElementById('select_box_us10');
        var x = document.getElementById('us10Div');
        if (x.style.display === 'none' && queryOpenFlag === false) {
            x.style.display = 'block';
            queryOpenFlag = true;
        } else if(x.style.display === 'block' && queryOpenFlag === true) {
            x.style.display = 'none';
            us10ModelPicker.value = 'Select Model';
            queryOpenFlag = false;
        }
    });


    $('#userstory11').click(function () {
        var us11DateFrom =  document.getElementById('getDateFromUs11');
        var us11DateTo =  document.getElementById('getDateToUs11');
        var x = document.getElementById('us11Div');
        if (x.style.display === 'none' && queryOpenFlag === false) {
            x.style.display = 'block';
            queryOpenFlag = true;
        } else if(x.style.display === 'block' && queryOpenFlag === true) {
            x.style.display = 'none';
            us11DateFrom.value = '';
            us11DateTo.value = '';
            us11DateFrom.placeholder = 'Enter Date From';
            us11DateTo.placeholder = 'Enter Date To';
            queryOpenFlag = false;
        }
    });


    $('#userstory12').click(function () {
        var us12DateFrom =  document.getElementById('getDateFromUs12');
        var us12DateTo =  document.getElementById('getDateToUs12');
        var x = document.getElementById('us12Div');
        if (x.style.display === 'none' && queryOpenFlag === false) {
            x.style.display = 'block';
            queryOpenFlag = true;
        } else if(x.style.display === 'block' && queryOpenFlag === true) {
            x.style.display = 'none';
            us12DateFrom.value = '';
            us12DateTo.value = '';
            us12DateFrom.placeholder = 'Enter Date From';
            us12DateTo.placeholder = 'Enter Date To';
            //$('datetimepicker121').attr('placeholder', 'Enter Date From');
            //$('datetimepicker122').attr('placeholder', 'Enter Date To');

            queryOpenFlag = false;
        }
    });


    $('#userstory14').click(function () {

        var x = document.getElementById('us14Div');
        var us14FailureTypePicker =  document.getElementById('select_box_us14');
        if (x.style.display === 'none' && queryOpenFlag === false) {
            x.style.display = 'block';
            queryOpenFlag = true;
        } else if(x.style.display === 'block' && queryOpenFlag === true) {
            x.style.display = 'none';
            us14FailureTypePicker.value = 'Select Failure Type';

            queryOpenFlag = false;
        }
    });


    $('#datetimepicker51').datetimepicker({
        format: 'yyyy-MM-dd hh:mm:ss',
        language: 'Br-BR'
    });
    $('#datetimepicker52').datetimepicker({
        format: 'yyyy-MM-dd hh:mm:ss',
        language: 'Br-BR'
    });
    $('#datetimepicker71').datetimepicker({
        format: 'yyyy-MM-dd hh:mm:ss',
        language: 'Br-BR'
    });
    $('#datetimepicker72').datetimepicker({
        format: 'yyyy-MM-dd hh:mm:ss',
        language: 'Br-BR'
    });
    $('#datetimepicker81').datetimepicker({
        format: 'yyyy-MM-dd hh:mm:ss',
        language: 'Br-BR'
    });
    $('#datetimepicker82').datetimepicker({
        format: 'yyyy-MM-dd hh:mm:ss',
        language: 'Br-BR'
    });
    $('#datetimepicker91').datetimepicker({
        format: 'yyyy-MM-dd hh:mm:ss',
        language: 'Br-BR'
    });
    $('#datetimepicker92').datetimepicker({
        format: 'yyyy-MM-dd hh:mm:ss',
        language: 'Br-BR'
    });
    $('#datetimepicker111').datetimepicker({
        format: 'yyyy-MM-dd hh:mm:ss',
        language: 'Br-BR'
    });
    $('#datetimepicker112').datetimepicker({
        format: 'yyyy-MM-dd hh:mm:ss',
        language: 'Br-BR'
    });
    $('#datetimepicker121').datetimepicker({
        format: 'yyyy-MM-dd hh:mm:ss',
        language: 'Br-BR'
    });
    $('#datetimepicker122').datetimepicker({
        format: 'yyyy-MM-dd hh:mm:ss',
        language: 'Br-BR'
    });

});