package com.vikings.ragnar.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        if(session.getAttribute("userEntity") == null){ // login
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            UserEntity userEntity;
            try {
                userEntity = userService.getUser(username, password);
                System.out.println(userEntity.toString());

                session.setAttribute("userEntity", userEntity);


                System.out.println("User Entity Stored in session");

                if (session.getAttribute("userEntity") == null) response.sendRedirect("login.html");
                else response.sendRedirect("newIndex.html");
            } catch (Exception e) {
                System.out.println("User Not Found");
                response.sendRedirect("login.html");
            }
        }
        else{                                               // logout
            session.removeAttribute("userEntity");
            response.sendRedirect("login.html");
        }




    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do get");

        try{
            UserEntity userEntity = (UserEntity) session.getAttribute("userEntity");

            if(userEntity != null){
                if(!userEntity.getUsername().equals("notauser")){
                    System.out.println("Logged in: " + userEntity.getUserId());
                    response.setContentType("text/plain");
                    response.setCharacterEncoding("UTF-8");

                    ObjectMapper mapper = new ObjectMapper();
                    String json = mapper.writeValueAsString(userEntity);
                    response.getWriter().print(json);
                    System.out.println("Response containing userEntity json written");
                }

            }
            else{
                response.sendRedirect("login.html");
                System.out.println("No One logged in");
            }
        }
        catch (NullPointerException e){

        }
    }
}
