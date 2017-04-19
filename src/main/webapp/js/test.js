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
            $.each(strArray, function (index, value) {
                var option = document.createElement("option");
                option.text = value;
                option.value = value;
                var select = document.getElementById("select-box");
                select.appendChild(option);
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
});