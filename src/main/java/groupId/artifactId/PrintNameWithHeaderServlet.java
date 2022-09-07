package groupId.artifactId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PrintNameWithHeaderServlet", urlPatterns = "/print_name_with_header")
public class PrintNameWithHeaderServlet extends HttpServlet {
    private final String nameParameterHeader = "ARRAY_NAME_PARAM";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // to solve coding issues
        resp.setContentType("text/html; charset=UTF-8"); // to solve coding issues
        PrintWriter writer = resp.getWriter();
        String header = req.getHeader(nameParameterHeader);
        String[] names = req.getParameterMap().get(header);
        if (names != null) {
            for (String str : names) {
                writer.write("<p>" + header + ": " + str + "</p>");
            }
        }
    }
}
