/**
 * Created by carlmccann2 on 26/04/2017.
 */
$(document).ready(function() {
    $(function() {
        $("#logoutButton").on("click",function(e) {
            // e.preventDefault(); // cancel the link itself
            $.post('/Ragnar-0.0.1-SNAPSHOT/UserSessionServlet');
        });
    });

});