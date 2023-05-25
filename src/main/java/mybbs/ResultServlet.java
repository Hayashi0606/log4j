package mybbs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet(name = "result", urlPatterns = { "/result" })


public class ResultServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String article = request.getParameter("article");
        String userName = request.getParameter("userName");

        File file = new File(getServletContext().getRealPath("textlog.txt"));
        FileWriter filewriter = new FileWriter(file, true);

        filewriter.write(article + "," + userName + System.getProperty("line.separator"));
        filewriter.close();


        Logger logger = LogManager.getLogger(ResultServlet.class);


        logger.info(article);
        logger.info(userName);


        request.setAttribute("message", "投稿しました！");
        request.setAttribute("article", article);
        request.setAttribute("userName", userName);

        String view = "/WEB-INF/result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}