/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Anderson
 */
public class Conexion {
    
    private static Connection cnx;
    
    //conectar
    public static Connection Conectar() throws ClassNotFoundException, SQLException{
        
        if(cnx==null){
            
            Class.forName("com.mysql.jdbc.Driver");//libreria
            cnx=(Connection)DriverManager.getConnection("jdbc:mysql://localhost/bdbiblioteca","root",""); //conecto 
            
        }
        
        return cnx;
    }
    
    //desconectar
    
    public static void Cerrar() throws SQLException{
        if(cnx!=null){
            
            cnx.close();
            
        }
    }
}
