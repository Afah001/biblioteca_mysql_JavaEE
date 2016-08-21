<%-- 
    Document   : rLibro
    Created on : 21/08/2016, 04:39:16 PM
    Author     : Anderson
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Biblioteca"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de Libros</h1>
        
        <form action="sLibro?action=registrar" method="post">
            
            Nombre <input name="nombre"><br>
            
            Autor<input name="autor"><br>
            
            Biblioteca 
            <select name="idBiblioteca">
                <% for(Biblioteca b:(List<Biblioteca>)request.getAttribute("listaBibliotecas")){ %>
                            
                        <option value="<%= b.getIdBiblioteca() %>"><%= b.getNombre() %></option>
                             
                 <% } %>
             </select><br>
            
            <input type="submit" value="registrar">
            
        </form>
             
        <a href="sLibro?action=consultar">Lista de libros</a>
        
        
    </body>
</html>
