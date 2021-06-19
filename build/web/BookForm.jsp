<%-- 
    Document   : BookForm.jsp
    Created on : Jun 18, 2021, 3:48:18 PM
    Author     : LENOVO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Form</title>
    </head>
    <body>
    <center>
        <h1> Books Management </h1>
        <h1> Books Management</h1>
        <h2>
            <a href="./new">Add new book</a>
            <a href="./list">List all books</a>
        </h2>
    </center>
    <div align="center">
        <c:if test ="${book!=null}">
            <form action="update" method="post">
            </c:if>
            <c:if test ="${book==null}">
                <form action="insert" method="post">
                </c:if>    
                <table border ="1" cellspacing = "0" cellpadding = "5">
                    <caption>
                        <h2>
                            <c:if test ="${book!=null}">Edit Book</c:if>
                            <c:if test ="${book==null}">Add New Book</c:if>
                            </h2>    
                        </caption>
                        
                           <c:if test ="${book!=null}">
                                <input type="hidden" name ="book_id" value="<c:out value ="${book.book_id}"/>"/>
                            </c:if>
                    <tr>
                            <th>Title</th>
                            <td><input type="text" name="title" size="45" value="<c:out value="${book.title}"/>"></td>
                    </tr>
                    <tr>
                        <th>Author</th>
                        <td>
                            <input type="text" name="author" size="45" value="<c:out value="${book.author}"></c:out>">
                            </td>
                        </tr>
                        <tr>
                            <th>Price</th>
                            <td>
                                <input type="text" name ="price" size="5" value="<c:out value="${book.price}"></c:out>">
                        </td>
                    </tr>
                    
                    <tr><td colspan="2" align ="center">
                            <input type="submit" value="Save"/>  
                    </tr>
                </table>
            </form>          
    </div>

</body>
</html>
