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
    })
    $('#datetimepicker121').datetimepicker({
        format: 'yyyy-MM-dd hh:mm:ss',
        language: 'Br-BR'
    });
    $('#datetimepicker122').datetimepicker({
        format: 'yyyy-MM-dd hh:mm:ss',
        language: 'Br-BR'
    });

});


