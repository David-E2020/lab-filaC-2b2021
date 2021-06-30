<%-- 
    Document   : registrarProveedor
    Created on : 26-05-2021, 07:30:10 PM
    Author     : Melissa Ibañez Lopez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>registrar Proveedor</title>
    </head>
    <body>
        <jsp:useBean id="proveedor" scope="session" class="com.test.bean.ProveedorBean"/>
        <%
            if(request.getParameter("guardar")!=null){
                String mensaje=proveedor.registrarProveedor(request);
                out.print(mensaje);
            }
        %>
        <h1>PROVEEDOR</h1>
        <form method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th colspan="2"> REGISTRAR PROVEEDOR</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>RAZON SOCIAL: </td>
                        <td><input type="text" name="razon_social" value="" /></td>
                    </tr>
                    <tr>
                        <td>DIRECCION:</td>
                        <td><input type="text" name="direccion" value="" /></td>
                    </tr>
                    <tr>
                        <td>TELEFONO:</td>
                        <td><input type="number" name="telefono" value="" /></td>
                    </tr>
                    <tr>
                        <td>EMAIL:</td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="REGISTRAR" name="guardar" /></td>
                    </tr>
                </tbody>
            </table>

        </form>
        <a href="index.jsp">INICIO</a>
        
    </body>
</html>
