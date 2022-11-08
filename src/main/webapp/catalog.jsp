<%@ page language="java" %>
<%@ page import="com.webshoppe.ecommerce.entity.Toy"%>
<%@ page import="java.util.List"%>

<%
List<Toy> catalog = (List<Toy>) request.getAttribute("catalog");
%>
<html>
    <head>
        <title>Webshoppe::Toy Catalog</title>
        <style type="text/css">
            body {
                margin: 50px;
            }
        </style>
    </head>
    <body>
        <h2>Toy Catalog</h2>
        <hr/>
        <%
        if(catalog.isEmpty()) {
        %>
            <b>Empty Catalog!</b>
        <%
        }
        %>
        
         <%
        if(!catalog.isEmpty()) {
        %>
        <table>
            <thead>
                <tr>
	                <td>ID</td>
	                <td>Name</td>
	                <td>Description</td>
	                <td>Price</td>
	                <td>Action</td>
                </tr>
            </thead>
            <tbody>
                <%
                for(Toy toy: catalog) {
                %>
                    <form action="./cart?action=add" method="POST">
                    <tr>
	                    <td><%= toy.getId() %></td>
	                    <td><%= toy.getName() %></td>
	                    <td><%= toy.getDescription() %></td>
	                    <td><%= toy.getPrice() %></td>
	                    <td>
	                       
	                           <input type="hidden" name="id" value="<%= toy.getId() %>">
	                           <input type="hidden" name="name" value="<%= toy.getName() %>">
	                           <input type="hidden" name="description" value="<%= toy.getDescription() %>">
	                           <input type="hidden" name="price" value="<%= toy.getPrice() %>">
	                           <input type="submit" value="Add to cart">
	                    </td>
                    </tr>
                    </form>
                <%
                }
                %>
            </tbody>
        </table>
        <%
        }
        %>
    </body>
</html>