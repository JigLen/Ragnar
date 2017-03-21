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
            url: "ragnar/user/"+userId+"/"+password,
            success: function (value) {
                if(value.userId!=null) {
                    alert("Your Log In");
                    //var test=value.accessLevel;
                    location.href = "http://localhost:8080/Ragnar-0.0.1-SNAPSHOT#"+value.accessLevel;
                }
            },
            error:function () {
                alert("User or  Password is wrong");
            },
        });
    });
});


