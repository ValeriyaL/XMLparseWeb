package by.liudchyk.parsing.servlet;


import by.liudchyk.parsing.command.ActionCommand;
import by.liudchyk.parsing.creator.ActionFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/candyaction")
public class CandyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        Map<String, String[]> requestParameters = new HashMap<String, String[]>();
        if (isMultipart) {
            ServerFileCreator fileCreator = new ServerFileCreator();
            requestParameters = fileCreator.createServerFile(request);
        }

        SessionRequestContent sessionRequestContent = new SessionRequestContent();
        sessionRequestContent.extractValues(request);
        if (isMultipart) {
            sessionRequestContent.setRequestParameters(requestParameters);
        }

        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(sessionRequestContent);

        page = command.execute(sessionRequestContent);

        sessionRequestContent.insertAttributes(request);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

}
