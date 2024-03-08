<%-- 
    Document   : ShowCart
    Created on : Mar 7, 2024, 3:43:52 PM
    Author     : HuynhDuong
--%>

<%@page import="java.util.List"%>
<%@page import="models.bookCartDTO"%>
<%@page import="models.cartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS/styleSaleMNG.css" rel="stylesheet" type="text/CSS"/>
    </head>
    <body>
        <form action="" method="">
            <h1>Your Cart Items</h1>
            <table border='1'>
            <tr>
                <th>No</th>
                <th>Title</th>
                <th>Quantity</th>
                <th>Actions</th>
            </tr>
            <% 
                int no = 0;
                cartDTO cart = (cartDTO) session.getAttribute("CART");
                List<bookCartDTO> list = cart.getList();
                for(bookCartDTO b: list) {
            %>
            <tr>
                <td><%= ++no %></td> 
                <td><%= b.getTitle() %></td>
                <td><%= b.getQuantity() %></td>
                <td><input type="checkbox"></td>
            <% } %>  
            </tr>
            <tr>
                <td colspan="3">
                    <a href="BookStore.jsp">Add More Items To Cart</a>
                </td>
                <td colspan="1">
                    <Input type="submit" value="Remove" />
                </td>
            </tr>

            </table>
            
            <div class="box">
                <button><a href="MainController?action=LogOut">Logout</a></button>
            </div>
            <div class="box">
                <button><a href="MainController?action=Payment">Payment</a></button>
            </div>
        </form>
        
    </body>
</html>
