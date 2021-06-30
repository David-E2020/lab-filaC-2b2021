/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.bean;

import com.test.conexion.VariablesConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author david
 */
public class ProveedorBean {
    //atributos
    private Connection connection;
    private PreparedStatement insertProveedor;
    private VariablesConexion variable;
    //constructores
    public ProveedorBean()throws SQLException{
        //instanciando
        variable=new VariablesConexion();
        variable.inicioConexion();
        //obteniendo la conexion
        connection=variable.getConnection();
        System.out.println("Iniciando la conexion");
    }
   
    //metodos
     @PreDestroy
    public void cerrarConexion(){
        variable.cerrarConexion();
    }
    public String registrarProveedor(HttpServletRequest request){
        String mensaje="";
        if(request==null){
            return"";
        }
        if(connection!=null){
            try {
                //definiendo la consulta
                StringBuilder query=new StringBuilder();
                query.append(" insert into proveedor ");
                query.append(" values (nextval('sec_prov'),?,?,?,?)");
                //enviando la consulta
                if(insertProveedor==null){
                    insertProveedor=connection.prepareStatement(query.toString());
                }
                //rescatando los parametros del formulario jsp registrarCategoria
                String razon_social=request.getParameter("razon_social");
                String direccion=request.getParameter("direccion");
                String telefono=request.getParameter("telefono");
                String email=request.getParameter("email");
                //pasando los datos a los parametros de la consulta
                insertProveedor.setString(1,razon_social);
                insertProveedor.setString(2,direccion);
                insertProveedor.setInt(3,Integer.parseInt(telefono));
                insertProveedor.setString(4,email);
                //ejecutando la consulta
                int registro=insertProveedor.executeUpdate();
                if(registro==1){
                    mensaje="Registro realizado con exito";
                }else{
                    mensaje="Error al insertar el registro";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mensaje;
    }
    //Realizando el listado de todas las categorias que se tienen registrados
    
    
    
    //getter y setter

    
    
}
