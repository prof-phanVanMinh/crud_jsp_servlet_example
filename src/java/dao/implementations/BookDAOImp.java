/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementations;

import dao.interfaces.BookDAOInt;
import dto.BookDTO;
import dbconnection.ConnectDB;
import java.sql.*;
import java.util.*;

/**
 *
 * @author LENOVO
 */
public class BookDAOImp implements BookDAOInt {

    Connection conn = null;
    @Override

    public List<BookDTO> getAllBook() {
        conn = ConnectDB.getConnection();
        List<BookDTO> books = new ArrayList<>();
        Statement statement = null;
        ResultSet rs = null;
        String query = "select * from book";
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                BookDTO book = new BookDTO(rs.getInt("book_id"), rs.getString("author"), rs.getString("title"), rs.getFloat("price"));
                books.add(book);
            }
            statement.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return books;
    }

    @Override
    public boolean insertBook(BookDTO book) {
        conn = ConnectDB.getConnection();
        PreparedStatement statement = null;
        boolean rowInserted = false;
        String query = "insert into book (author, price, title) values(?,?,?)";
        try {
            statement = conn.prepareStatement(query);
            statement.setString(1, book.getAuthor());
            statement.setFloat(2, book.getPrice());
            statement.setString(3, book.getTitle());
            rowInserted = statement.executeUpdate() > 0;
            statement.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return rowInserted;
    }

    @Override
    public boolean updateBook(BookDTO book) {
        conn = ConnectDB.getConnection();
        PreparedStatement statement = null;
        boolean rowUpdated = false;
        String query = "update book set title=?, author=?, price =? where book_id=?";
        try {
            statement = conn.prepareStatement(query);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setFloat(3, book.getPrice());
            statement.setInt(4, book.getBook_id());
            rowUpdated = statement.executeUpdate()>0;
            statement.close();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return rowUpdated;
    }
    @Override
    public boolean deleteBook(BookDTO book){
        conn = ConnectDB.getConnection();
        PreparedStatement statement = null;
        boolean rowDeleted = false;
        String queString = "delete from book where book_id = ?";
        try {
            statement = conn.prepareStatement(queString);
            statement.setInt(1, book.getBook_id());
            rowDeleted = statement.executeUpdate()>0;
            statement.close();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return rowDeleted;
    }
    @Override
    public BookDTO getBookByID(int id){
        PreparedStatement statement =null;
        conn = ConnectDB.getConnection();
        BookDTO book = null;
        String queryString = "select * from book where book_id=?";
        try {
            statement = conn.prepareStatement(queryString);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                 book = new BookDTO(id,rs.getString("title"), rs.getString("author"), rs.getFloat("price"));
            }
          statement.close();
          conn.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return book;
    }
}

