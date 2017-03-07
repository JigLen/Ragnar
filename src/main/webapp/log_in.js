/**
 * Created by c12317616 on 03/03/2017.
 */

$(document).ready(function() {
    $("#logIn").click(function () {
        var userId= $("#getUser").val();
        var password= $("#getPassword").val();
        //location.href = "http://localhost:8080/Ragnar-0.0.1-SNAPSHOT/ragnar/ragnar/userLogin";
        $.ajax({
            type: "GET",
            url: "ragnar/userLogin/"+userId+"/"+password,//not done yet
            //url: "ragnar",//not done yet
            success: function () {
                alert("Your Log In");
                //location.href = "http://localhost:8080/Ragnar-0.0.1-SNAPSHOT";
            },
            error:function () {
                alert("Not found");
            }
        });
    });
});
/*function getLog() {
    var userId = $("#getUser").var();
    var password = $("#getPassword").var();
    location.href = "http://localhost:8080/Ragnar-0.0.1-SNAPSHOT/ragnar/ragnar/userLogin";
    $.ajax({
        type: "GET",
        url: "ragnar/userLogin" + userId + password,//not done yet
        success: function () {
            alert("Your Log In");
        },
        error: function () {
            alert("Not found");
        }
    });
}*/
