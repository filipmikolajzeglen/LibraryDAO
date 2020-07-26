package pl.filipzeglen.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.filipzeglen.dao.BookDao;
import pl.filipzeglen.model.Book;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String option = request.getParameter("option");
        try {
            BookDao dao = new BookDao();
            Book book = null;
            String operation = null;
            if ("search".equals(option)) {
                book = dao.read(isbn);
                operation = "search";
            } else if ("add".equals(option)) {
                book = new Book(isbn, title, description);
                dao.create(book);
                operation = "add";
            } else if ("update".equals(option)) {
                book = new Book(isbn, title, description);
                dao.update(book);
                operation = "update";
            } else if ("delete".equals(option)) {
                book = new Book(isbn, title, description);
                dao.delete(book);
                operation = "delete";
            }
            request.setAttribute("option", operation);
            request.setAttribute("book", book);
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}