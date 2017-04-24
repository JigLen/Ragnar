/**
 * Created by carlmccann2 on 20/04/2017.
 */

$(document).ready(function() {

    $("#SFSBTestButton").click(function () {
        $.ajax({
            type: "GET",
            url: "ragnar/user/current/",
            success: function (user) {
                var s = 'id: ' + user.userId +
                    '\naccess level: ' + user.accessLevel +
                    '\ndescription: ' + user.description;
                alert(s);
                alert(JSON.stringify(user));
            },

            error: function(){
                alert('Failure');
            }
        });
    });
});