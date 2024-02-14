package com.java.cis;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    /***
     * Do post method which takes request and response as the parameter which are called by the server.
     * POST is used to send the information to the server.
     * we took user name and password that are requested from web page as parameter. (this is linked by name attribute in static web page)
     * now we perform some validation to check user name and password is matching or not.
     * if matched{
     *     we set the user name attribute with our username.
     *     and we use request dispatcher for dispatching the request to our jsp web page.
     *     we use forward method which sends the request from servlet to web page.
     * }
     * else{
     *     we just redirect the index web page which is a unsuccessful.
     * }
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        if(userName.equals("admin") && password.equals("admin")) {
            request.setAttribute("username", userName);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
            requestDispatcher.forward(request, response);
        }
        else {
            response.sendRedirect("index.jsp");
        }
    }

}

