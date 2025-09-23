package org.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/exec_code")
public class App extends HttpServlet{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String classApp = AppUtil.findClass(code);
        if (classApp == null) {
            response.setContentType("text/html");
            response.getWriter().println("<html><body><h1>No decleration of class name</h1></body></html>");
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
