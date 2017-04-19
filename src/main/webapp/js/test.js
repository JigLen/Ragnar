/**
 * Created by User on 14-Apr-17.
 */
$(document).ready(function() {

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

                var select = document.getElementById("select-box");
                var select_us5 = document.getElementById("select_box_us5");

                select.appendChild(option);
                select_us5.appendChild(option_us5);
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
            $.each(strArray, function (index, value) {
                var option = document.createElement("option");
                option.text = value;
                option.value = value;
                var select_us8 = document.getElementById("select_box_us8");
                select_us8.appendChild(option);
            });
        },
        error:function () {
            alert("Not found");
        }
    });



    $('#userstory4').click(function () {

        var x = document.getElementById('us4Div');
        if (x.style.display === 'none') {
            x.style.display = 'block';
        } else {
            x.style.display = 'none';
        }
    });

    $('#userstory5').click(function () {

        var x = document.getElementById('us5Div');
        if (x.style.display === 'none') {
            x.style.display = 'block';
        } else {
            x.style.display = 'none';
        }
    });

    $('#userstory7').click(function () {

        var x = document.getElementById('us7Div');
        if (x.style.display === 'none') {
            x.style.display = 'block';
        } else {
            x.style.display = 'none';
        }
    });

    $('#userstory8').click(function () {

        var x = document.getElementById('us8Div');
        if (x.style.display === 'none') {
            x.style.display = 'block';
        } else {
            x.style.display = 'none';
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
});