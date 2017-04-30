/**
 * Created by C07589301 on 08/03/2017.
 */
var User = function(username, password, accessLevel, description) {
    this.username = username;
    this.password = password;
    this.accessLevel = accessLevel;
    this.description = description;
}

$(document).ready(function()
{

    $("#addUser").click(function()
    {

        var userType =  $("#setUserType").val();
        var username =  $("#setUsername").val();
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
        if(userType == "System Admin")
        {
            accessLevel = 3;
            description ="System Admin";
        }
        if(userType == "Network Engineer")
        {
            accessLevel = 4;
            description ="Network Engineer";
        }

        if(username && password){
            document.getElementById('alert2').style.display = 'none';
            var myUser = new User(username, password,accessLevel, description );


            $.ajax({
                type: "POST",
                url: "ragnar/user",
                success: function () {
                    document.getElementById('alert2').innerHTML = 'User Added';
                    document.getElementById('alert2').style.display = 'block';
                },
                error: function(){
                    document.getElementById('alert2').innerHTML = '<strong>Warning!</strong> User Post Failure';
                    document.getElementById('alert2').style.display = 'block';
                },
                data: JSON.stringify(myUser),
                contentType: "application/json",
            });
        }
        else{
            document.getElementById('alert2').innerHTML = '<strong>Warning!</strong> Please enter username and password';
            document.getElementById('alert2').style.display = 'block';
        }


    });

    $("#showUserList").click(function() {
        alert("test");
        $.ajax({

            type: "GET",
            url: "ragnar/user",
            success: function (userList) {
                $.each(userList, function (index, value) {
                    $("#userHolder").append("<li>" + value.username + " " + value.password +  " " + value.accessLevel + " " + value.description  +"</li>");
                });
            }});
    });

    $("#closeUserList").click(function() {
        $("#userHolder").empty();
    });


});