package mybbs;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet(name = "show", urlPatterns = { "/show" })
public class FormServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuilder articles = new StringBuilder();
        File file = new File(getServletContext().getRealPath("textlog.txt"));
        Scanner scan = new Scanner(file);

        while(scan.hasNext()){
            String line = scan.nextLine();
            articles.append(line).append(System.getProperty("line.separator"));
        }

        request.setAttribute("articles", articles);

        String view = "/WEB-INF/form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}
