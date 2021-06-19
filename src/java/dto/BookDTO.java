/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Objects;
import javax.servlet.jsp.tagext.BodyContent;

/**
 *
 * @author LENOVO
 */
public class BookDTO {

    private int book_id;
    private String title;
    private String author;
    private float price;

    public BookDTO() {
    }
     public BookDTO(int book_id){
         this.book_id = book_id;
     }
    public BookDTO(String title, String author, float price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public BookDTO(int book_id, String title, String author, float price) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getBook_id() {
        return this.book_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Book{" + "book_id=" + book_id + ", title=" + title + ", author=" + author + ", price=" + price + '}';
    }
}
