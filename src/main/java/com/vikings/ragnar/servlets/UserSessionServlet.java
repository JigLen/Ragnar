package com.vikings.ragnar.servlets;

import com.vikings.ragnar.ejb.UserService;
import com.vikings.ragnar.entities.UserEntity;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by carlmccann2 on 24/04/2017.
 */
public class UserSessionServlet extends HttpServlet {
    HttpSession session;
    @EJB UserService userService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        UserEntity userEntity = userService.getUser(Integer.parseInt(userId), password);


        System.out.println(userEntity.toString());

        session.setAttribute("userEntity", userEntity);


        System.out.println("User Entity Stored in session");

        if(session.getAttribute("userEntity") == null) response.sendRedirect("login.html");
        else response.sendRedirect("customerRep.html");

    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do get");

        UserEntity userEntity;

        try{
            userEntity = (UserEntity) session.getAttribute("userEntity");
            System.out.println("Logged in: " + userEntity.getUserId());
        }
        catch(NullPointerException e){
            System.out.println("No One Logged In");
        }
    }
}
