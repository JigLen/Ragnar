/**
 * Created by c12317616 on 03/03/2017.
 */

$(document).ready(function() {
    checkPermissions();
});


function checkPermissions() {
    $.get('/Ragnar-0.0.1-SNAPSHOT/UserSessionServlet', function (data) {
        var userEntity = JSON.parse(data);
        var accessLevel = 0;
        var welcome = document.getElementById('username');
        if (userEntity != null) {
            accessLevel = parseInt(userEntity.accessLevel);
            welcome.innerHTML = "Welcome " + userEntity.username;
        }
        else {
            welcome.innerHTML = "Please Login";
        }
        permissions(accessLevel);

    });
}