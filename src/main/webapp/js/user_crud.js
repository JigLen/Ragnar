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
    $("#addUser").click(function() {

        alert("TEST");
        var accessLevel =  $("#setUserType").val();
        var userId =  $("#setUserId").val();
        var password = $("#setUserPassword").val();
        var description = "";

        if(accessLevel == 1){
             description ="Administrator";
        }if(accessLevel == 2){
             description ="Network Management";
        }if(accessLevel == 3){
             description ="Support Engineer";
        }if(accessLevel == 4){
             description ="Customer Rep";
        }else{
            alert("Incorrect access type");
        }

        var myUser = new User(userId, password,accessLevel, description );



        $.ajax({
            type: "POST",
            url: "ragnar/user",
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
            url: "ragnar/user",
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