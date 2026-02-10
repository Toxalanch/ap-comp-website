package com.toxalanch.apCompWebsite;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * The main portion of the webapp, runs code submitted through a post from the html page and outputs it to a new page
 * 
 * @author Toxlanch
 * @since 1.0
 * @version 1.0
 */
@WebServlet("/mainServlet")
public class App extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Hello world");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("user_written_code");
        String classApp = AppUtil.findClass(code);
        if (classApp == null) {
            response.setContentType("text/html");
            response.getWriter().println("<html><body><h1>No declaration of class name</h1></body></html>");
        } else {
            Runner runable = new Runner(classApp, code);
            String output = runable.run();
            if (output == null) {
                response.setContentType("text/html");
                response.getWriter().println("<html><body><h1>There was an error</h1></body></html>");
            } else {
                response.setContentType("text/html");
                response.getWriter().println("<html><body><h1>" + classApp + ".java</h1><p>" + output + "</p></body></html>");
            }
        }
    }
}
