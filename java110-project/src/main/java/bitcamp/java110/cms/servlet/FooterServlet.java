package bitcamp.java110.cms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/footer")
public class FooterServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 이 서블릿을 포함하는 서블릿에서 이미  response.setContentType("text/html;charset=UTF-8");을 선언하기 때문에
        // 여기선 할 필요 없다. 해도 소용없다.
        
        PrintWriter out = response.getWriter();
        
        out.println("<footer>");
        out.println("    <p>&copy;자바110기</p>");
        out.println("</footer>");
    }
    
}




























