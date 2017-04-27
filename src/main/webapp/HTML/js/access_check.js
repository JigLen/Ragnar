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
    var sidebar=document.getElementById("sidebar")
    //buttons.removeChild(log_in);
    if(user_access !=1 && user_access !=4  ){
        document.getElementById("first_line_queries").remove();;
    }
    if(user_access !=3  ){
        document.getElementById("admin").remove();;
    }

    //Customer Rep
    if(user_access ==1){
        document.getElementById("userstory7").remove();
        document.getElementById("userstory9").remove()
        document.getElementById("userstory14").remove();
    }
    //Support Eng
    if(user_access ==2){
        document.getElementById("userstory8").remove();
    }
    //System Admin
    if(user_access == 3){
        document.getElementById("investigating_problems").remove();
    }
    //Netwrok Engineer
    if(user_access !=4)
    {
        document.getElementById("evaluation").remove();
    }

}