/**
 * Created by C07589301 on 08/03/2017.
 */
var User = function(userId, password,accessLevel, description ) {
    this.userId = userId;
    this.password = password;
    this.accessLevel = accessLevel;
    this.description = description;
}

$(document).ready(function()
{

    $("#addUser").click(function()
    {

        var userType =  $("#setUserType").val();
        var userId =  $("#setUserId").val();
        var password = $("#setUserPassword").val();
        var description = " ";
        var accessLevel = 0;

        if(userType == "Customer Rep")
        {
            accessLevel = 1;
            description ="Customer Rep";
        }
        if(userType == "Support Engineer")
        {
            accessLevel = 2;
            description = "Support Engineer";
        }
        if(userType == "Network Engineer")
        {
            accessLevel = 3;
            description ="Network Engineer";
        }
        if(userType == "System Admin")
        {
            accessLevel = 4;
            description ="System Admin";
        }


        alert(userId + " " + password + " " + accessLevel + " " + description);
        var myUser = new User(userId, password,accessLevel, description );


        $.ajax({
            type: "POST",
            url: "http://localhost:8080/Ragnar-0.0.1-SNAPSHOT/ragnar/user",
            success: function () {
                alert("user added");
                location.reload();
            },
            error: function(){
                alert("User POST failure")
            },
            data: JSON.stringify(myUser),
            contentType: "application/json",
        });
    });

    $("#showUserList").click(function() {
        alert("test");
        $.ajax({

            type: "GET",
            url: "http://localhost:8080/Ragnar-0.0.1-SNAPSHOT/ragnar/user",
            success: function (userList) {
                $.each(userList, function (index, value) {
                    $("#userHolder").append("<li>" + value.userId + " " + value.password +  " " + value.accessLevel + " " + value.description  +"</li>");
                });
            }});
    });

    $("#closeUserList").click(function() {
        $("#userHolder").empty();
    });


});