/**
 * Created by carlmccann2 on 26/04/2017.
 */


function loadUS1(){
    clearAll();
    document.getElementById('alert1').style.display = 'none';
    var x = document.getElementById('us1Div');
    x.style.display = 'block';
}

function loadUS2(){
    clearAll();
    document.getElementById('alert2').style.display = 'none';
    var x = document.getElementById('us2Div');
    x.style.display = 'block';
}

function loadUS4(){
    clearAll();
    document.getElementById('tabletest').style.display = 'none';
    var x = document.getElementById('us4Div');
    var table = document.getElementById('tablebodyUs4');
    while(table.hasChildNodes()){
        table.removeChild(table.lastChild);
    }
    var us4ImsiPicker =  document.getElementById('select-box');
    us4ImsiPicker.value = 'Select IMSI';
    x.style.display = 'block';
}

function loadUS5(){
    clearAll();
    var output = document.getElementById('US5Output');
    while(output.hasChildNodes()){
        output.removeChild(output.lastChild);
    }

    var x = document.getElementById('us5Div');
    var us5ImsiPicker =  document.getElementById('select_box_us5');
    var us5DateFrom =  document.getElementById('getDateFromUs5');
    var us5DateTo =  document.getElementById('getDateToUs5');
    us5ImsiPicker.value = 'Select IMSI';
    us5DateFrom.value = '';
    us5DateTo.value = '';
    us5DateFrom.placeholder = 'Enter Date From';
    us5DateTo.placeholder = 'Enter Date To';
    x.style.display = 'block';
}

function loadUS6(){
    clearAll();
    document.getElementById('tableUs6').style.display = 'none';

    var table = document.getElementById('tablebodyUs6');
    while(table.hasChildNodes()){
        table.removeChild(table.lastChild);
    }

    var x = document.getElementById('us6Div');
    var us6ImsiPicker =  document.getElementById('select_box_us6');
    us6ImsiPicker.value = 'Select IMSI';
    x.style.display = 'block';
}

function loadUS7(){
    clearAll();
    document.getElementById('tableUs7').style.display = 'none';

    var table = document.getElementById('tablebodyUs7');
    while(table.hasChildNodes()){
        table.removeChild(table.lastChild);
    }

    var us7DateFrom =  document.getElementById('getDateFromUs7');
    var us7DateTo =  document.getElementById('getDateToUs7');
    var x = document.getElementById('us7Div');
    us7DateFrom.value = '';
    us7DateTo.value = '';
    us7DateFrom.placeholder = 'Enter Date From';
    us7DateTo.placeholder = 'Enter Date To';
    x.style.display = 'block';
}

function loadUS8(){
    clearAll();
    document.getElementById('tableUs8').style.display = 'none';

    var table = document.getElementById('tablebodyUs8');
    while(table.hasChildNodes()){
        table.removeChild(table.lastChild);
    }
    var x = document.getElementById('us8Div');
    //var us8Body = document.getElementById('tablebodyUs8');
    var us8ModelPicker =  document.getElementById('select_box_us8');
    var us8DateFrom =  document.getElementById('getDateFromUs8');
    var us8DateTo =  document.getElementById('getDateToUs8');
    us8ModelPicker.value = 'Select Model';
    us8DateFrom.value = '';
    us8DateTo.value = '';
    us8DateFrom.placeholder = 'Enter Date From';
    us8DateTo.placeholder = 'Enter Date To';
    x.style.display = 'block';
}

function loadUS9(){
    clearAll();
    document.getElementById('tableUs9').style.display = 'none';

    var table = document.getElementById('tablebodyUs9');
    while(table.hasChildNodes()){
        table.removeChild(table.lastChild);
    }
    document.getElementById('table9Graph').style.display = 'none';
    document.getElementById('graphContainer9').style.display = 'none';
    document.getElementById('graph9').style.display = 'none';
    var x = document.getElementById('us9Div');
     // var us9Body = document.getElementById('tablebodyUs9');
    var us9DateFrom =  document.getElementById('getDate1');
    var us9DateTo =  document.getElementById('getDate2');
    // us9Body.style.display = 'none';
    us9DateFrom.value = '';
    us9DateTo.value = '';
    us9DateFrom.placeholder = 'Enter Date From';
    us9DateTo.placeholder = 'Enter Date To';
    x.style.display = 'block';
}

function loadUS10(){
    clearAll();
    document.getElementById('tableUs10').style.display = 'none';
    var table = document.getElementById('tablebodyUs10');
    while(table.hasChildNodes()){
        table.removeChild(table.lastChild);
    }
    var us10ModelPicker =  document.getElementById('select_box_us10');
    var x = document.getElementById('us10Div');
    us10ModelPicker.value = 'Select Model';
    x.style.display = 'block';
}

function loadUS11(){
    clearAll();
    document.getElementById('tableUs11').style.display = 'none';

    var table = document.getElementById('tablebodyUs11');
    while(table.hasChildNodes()){
        table.removeChild(table.lastChild);
    }
    document.getElementById('table11Graph').style.display = 'none';
    document.getElementById('graphContainer11').style.display = 'none';
    document.getElementById('graph11').style.display = 'none';
    var us11DateFrom =  document.getElementById('getDateFromUs11');
    var us11DateTo =  document.getElementById('getDateToUs11');
    var x = document.getElementById('us11Div');
    us11DateFrom.value = '';
    us11DateTo.value = '';
    us11DateFrom.placeholder = 'Enter Date From';
    us11DateTo.placeholder = 'Enter Date To';
    x.style.display = 'block';
}


function loadUS12(){
    clearAll();
    document.getElementById('tableUs12').style.display = 'none';
    var table = document.getElementById('tablebodyUs12');
    while(table.hasChildNodes()){
        table.removeChild(table.lastChild);
    }

    document.getElementById('table12Graph').style.display = 'none';
    document.getElementById('graphContainer12').style.display = 'none';
    document.getElementById('graph12').style.display = 'none';
    var us12DateFrom =  document.getElementById('getDateFromUs12');
    var us12DateTo =  document.getElementById('getDateToUs12');
    var x = document.getElementById('us12Div');
    us12DateFrom.value = '';
    us12DateTo.value = '';
    us12DateFrom.placeholder = 'Enter Date From';
    us12DateTo.placeholder = 'Enter Date To';
    x.style.display = 'block';
}

function loadUS14(){
    clearAll();
    document.getElementById('tableUs14').style.display = 'none';
    var table = document.getElementById('tablebodyUs14');
    while(table.hasChildNodes()){
        table.removeChild(table.lastChild);
    }
    var x = document.getElementById('us14Div');
    var us14FailureTypePicker =  document.getElementById('select_box_us14');
    us14FailureTypePicker.value = 'Select Failure Type';
    x.style.display = 'block';
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











