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

                    if(value.accessLevel==1 || value.accessLevel==2 || value.accessLevel==3 || value.accessLevel==4){
                        location.href ="http://localhost:8080/Ragnar-0.0.1-SNAPSHOT/newIndex.html#";

                    }
                    /*

                    if(value.accessLevel==1){
                        location.href ="http://localhost:8080/Ragnar-0.0.1-SNAPSHOT/customerRep.html#"+value.accessLeve;
                    }
                    else if(value.accessLevel==2){
                        location.href ="http://localhost:8080/Ragnar-0.0.1-SNAPSHOT/supportEngineer.html#"+value.accessLeve;
                    }
                    else if(value.accessLevel==3){
                        location.href ="http://localhost:8080/Ragnar-0.0.1-SNAPSHOT/NetworkEngineer.html#"+value.accessLeve;
                    }
                    else if(value.accessLevel==4){
                        location.href ="http://localhost:8080/Ragnar-0.0.1-SNAPSHOT/systemAdmin.html#"+value.accessLeve;
                    }
                    //location.href = "http://localhost:8080/Ragnar-0.0.1-SNAPSHOT#"+value.accessLevel";

                    */
                }
            },
            error:function () {
                alert("User or  Password is wrong");
            },
        });
    });
});


