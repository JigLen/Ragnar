/**
 * Created by c12317616 on 16/03/2017.
 */
function checkAccess(access_lv,user_access){
    if(access_lv==user_access) {
        return true;
    }
    return false;
}
function permissions(user_access){
    var sidebar=document.getElementById("sidebar");

    //Customer Rep
    if(user_access == 1){
        document.getElementById("investigating_problems").remove();
        document.getElementById("admin").remove();
        loadCustomerRepFunctions();

    }
    //Support Eng
    else if(user_access == 2){
        document.getElementById("admin").remove();
        loadSupportEngineerFunctions();

    }
    //System Admin
    else if(user_access == 3){
        document.getElementById("investigating_problems").remove();
        document.getElementById("first_line_queries").remove();
        document.getElementById("evaluation").remove();
        loadSystemAdminFunctions();
    }
    //Network Engineer
    else if(user_access == 4) {
        document.getElementById("admin").remove();
        loadNetworkEngineerFunctions();
    }


}

function loadCustomerRepFunctions(){
    var ul = document.getElementById('firstlineQueriesUl');

    var li = document.createElement('li');
    li.setAttribute('id', 'userstory4');
    li.setAttribute('onclick','loadUS4()');
    li.innerHTML = '<a href="#">Event ID, Cause Code for all affecting failures</a>';
    ul.appendChild(li);

    var li2 = document.createElement('li');
    li2.setAttribute('id', 'userstory5');
    li2.setAttribute('onclick','loadUS5()');
    li2.innerHTML = '<a href="#">Number of call failures in the given time period </a>';
    ul.appendChild(li2);

    var ul2 = document.getElementById('evaluationUl');
    var li3 = document.createElement('li');
    li3.setAttribute('id', 'userstory6');
    li3.setAttribute('onclick','loadUS6()');
    li3.innerHTML = '<a href="#">List all Unique Cause Codes</a>';
    ul2.appendChild(li3);
}

function loadSupportEngineerFunctions(){
    loadCustomerRepFunctions();
    var ul = document.getElementById('investigatingProblemsUl');

    var li = document.createElement('li');
    li.setAttribute('id', 'userstory7');
    li.setAttribute('onclick','loadUS7()');
    li.innerHTML = '<a href="#">List of all the IMSIs with call failures in the given time period</a>';
    ul.appendChild(li);

    var li2 = document.createElement('li');
    li2.setAttribute('id', 'userstory8');
    li2.setAttribute('onclick','loadUS8()');
    li2.innerHTML = '<a href="#">Number of call failures the model of phone has in the given time period</a>';
    ul.appendChild(li2);

    var li3 = document.createElement('li');
    li3.setAttribute('id', 'userstory14');
    li3.setAttribute('onclick','loadUS14()');
    li3.innerHTML = '<a href="#">Number of IMSI that are affected</a>';
    ul.appendChild(li3);
}

function loadSystemAdminFunctions(){
    var ul = document.getElementById('adminUl');

    var li2 = document.createElement('li');
    li2.setAttribute('id', 'userstory1');
    li2.setAttribute('onclick','loadUS1()');
    li2.innerHTML = '<a href="#">Import Datasets</a>';
    ul.appendChild(li2);

    var li = document.createElement('li');
    li.setAttribute('id', 'userstory2');
    li.setAttribute('onclick','loadUS2()');
    li.innerHTML = '<a href="#">Add new user</a>';
    ul.appendChild(li);
}

function loadNetworkEngineerFunctions() {
    loadCustomerRepFunctions();

    var ul = document.getElementById('investigatingProblemsUl');

    var li = document.createElement('li');
    li.setAttribute('id', 'userstory9');
    li.setAttribute('onclick','loadUS9()');
    li.innerHTML = '<a href="#">Number of call failures and their total duration based on the IMSI code</a>';
    ul.appendChild(li);

    var ul2 = document.getElementById('evaluationUl');

    var li2 = document.createElement('li');
    li2.setAttribute('id', 'userstory10');
    li2.setAttribute('onclick','loadUS10()');
    li2.innerHTML = '<a href="#">Display all unique call failures for given model of phone</a>';
    ul2.appendChild(li2);

    var li3 = document.createElement('li');
    li3.setAttribute('id', 'userstory11');
    li3.setAttribute('onclick','loadUS11()');
    li3.innerHTML = '<a href="#">Display top ten most common market operator cell combo</a>';
    ul2.appendChild(li3);

    var li4 = document.createElement('li');
    li4.setAttribute('id', 'userstory12');
    li4.setAttribute('onclick','loadUS12()');
    li4.innerHTML = '<a href="#">Display top ten most common IMSI numbers</a>';
    ul2.appendChild(li4);
}