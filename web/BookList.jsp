<%-- 
    Document   : BookList.jsp
    Created on : Jun 18, 2021, 3:28:24 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book List</title>
    </head>
    <body>
    <center>
        <h1>Books Management</h1>
        <h2>
            <a href="./new">Add New Book</a>
            <a href="./list">List All Books</a>
        </h2>
        <h3>List Of Books</h3>
    </center>
    <div align="center">
        <table border="1" cellspacing="0" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>title</th>
                <th>Author</th>
                <th>Price</th>Au
                <th>Actions</th>
            </tr>
            <c:if test="${listBook!=null}">
                <c:forEach var="book" items="${listBook}">
                    <tr>
                        <td><c:out value="${book.book_id}"></c:out></td>
                        <td><c:out value="${book.title}"></c:out></td>
                        <td><c:out value="${book.author}"></c:out></td>
                        <td><c:out value="${book.price}"></c:out></td>
                            <td>
                                <a href="./edit?id=<c:out value="${book.book_id}"></c:out>">Edit</a>
                            <a href="./delete?id=<c:out value="${book.book_id}"></c:out>">Delete</a>
                            </td>
                        </tr>
                </c:forEach>
            </c:if>
        </table>
    </div>


</body>
</html>
