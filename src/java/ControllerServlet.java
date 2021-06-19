/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.implementations.BookDAOImp;
import dto.BookDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;

/**
 *
 * @author LENOVO
 */
@WebServlet(urlPatterns = "/")
public class ControllerServlet extends HttpServlet {

    private BookDAOImp bookDAO = new BookDAOImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertBook(request, response);
                    break;
                case "/delete":
                    deleteBook(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateBook(request, response);
                    break;
                default:
                    listBook(request, response);
                    break;
            }
        } catch (ServletException ex) {
            System.err.print(ex.toString());
        }
    }

    private void listBook(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<BookDTO> listBook = bookDAO.getAllBook();
        request.setAttribute("listBook", listBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("BookList.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        BookDTO existingBook = bookDAO.getBookByID(id);
        request.setAttribute("book", existingBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");

        dispatcher.forward(request, response);

    }

    private void insertBook(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        float price = Float.parseFloat(request.getParameter("price"));

        BookDTO newBook = new BookDTO(title, author, price);
        bookDAO.insertBook(newBook);
        response.sendRedirect("list");//Trả về Servlet /list
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("book_id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        float price = Float.parseFloat(request.getParameter("price"));

        BookDTO book = new BookDTO(id, title, author, price);
        bookDAO.updateBook(book);
        response.sendRedirect("list");
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        BookDTO book = new BookDTO(id);
        bookDAO.deleteBook(book);
        response.sendRedirect("list");
    }

}
