/**
 * Created by carlmccann2 on 26/04/2017.
 */

var queryOpenFlag = false;

function loadUS1(){
    var x = document.getElementById('us1Div');
    if (x.style.display === 'none' /*&& queryOpenFlag === false*/) {
        x.style.display = 'block';
        //queryOpenFlag = true;
    } else if (x.style.display === 'block' /*&& queryOpenFlag === true*/) {
        x.style.display = 'none';
        //queryOpenFlag = false;
    }
}

function loadUS2(){
    var x = document.getElementById('us2Div');
    if (x.style.display === 'none' /*&& queryOpenFlag === false*/) {
        x.style.display = 'block';
        queryOpenFlag = true;
    } else if(x.style.display === 'block' /*&& queryOpenFlag === true*/) {
        x.style.display = 'none';
        queryOpenFlag = false;
    }
}

function loadUS4(){
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
}

function loadUS5(){
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
}

function loadUS6(){
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
}

function loadUS7(){
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
}

function loadUS8(){
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
}

function loadUS9(){
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
}

function loadUS10(){
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
}

function loadUS11(){
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
}

$('#userstory11').click(function () {
    clearAll();
    $("#tablebodyUs11").empty()
    var us11DateFrom =  document.getElementById('getDateFromUs11');
    var us11DateTo =  document.getElementById('getDateToUs11');
    var x = document.getElementById('us11Div');
    us11DateFrom.value = '';
    us11DateTo.value = '';
    us11DateFrom.placeholder = 'Enter Date From';
    us11DateTo.placeholder = 'Enter Date To';
    x.style.display = 'block';
});

function loadUS12(){
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
}
function loadUS14(){
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
}

function clearAll() {
    var user_story = "us";
    var div_name = "Div"
    var name = "";
    var x;
    for (var i = 1; i <= 14; i++) {
        if (i != 3 && i != 13) {
            name = user_story + i + div_name;
            x = document.getElementById(name);
            x.style.display = 'none';
        }
    }
}











