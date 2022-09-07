package groupId.artifactId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "PrintWithConditionServlet",urlPatterns = "/print_condition")
public class PrintWithConditionServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // to solve coding issues
        resp.setContentType("text/html; charset=UTF-8"); // to solve coding issues
        PrintWriter writer = resp.getWriter();
        Enumeration<String> params = req.getParameterNames(); // all params that have passed to servlet
        while (params.hasMoreElements()) {
            String paramName = params.nextElement();
            if (req.getParameter(paramName).toLowerCase().matches(".*[a-z].*")) {
                writer.write("<p>" + paramName + ": " + req.getParameter(paramName) + "</p>");
            }
        }
    }
}
