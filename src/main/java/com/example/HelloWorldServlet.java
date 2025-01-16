package com.example;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class HelloWorldServlet extends HttpServlet {

    // Override the doGet method to handle GET requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Simulate error handling if the 'error' parameter is set to 'true' in the request
        String error = request.getParameter("error");
        if (error != null && error.equals("true")) {
            // Send HTTP 400 Bad Request if the 'error' parameter is present
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request parameter");
            return;  // Exit the method to prevent further processing
        }

        // Set the content type of the response (HTML)
        response.setContentType("text/html");

        // Set the HTTP status code (200 OK)
        response.setStatus(HttpServletResponse.SC_OK);

        // Write the response body (Hello World message)
        response.getWriter().write("Hello World");
    }
}
