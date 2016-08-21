/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.spi.DirStateFactory;
import javax.xml.transform.Result;

/**
 *
 * @author Anderson
 */
public class Biblioteca {
    
    private int idBiblioteca;
    private String nombre;
    private String ubicacion;
    List <Libro> libros;

    public Biblioteca() {
    }
    
    public Biblioteca(String nombre, String ubicacion) {
        
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public Biblioteca(int idBiblioteca, String nombre, String ubicacion) {
        this.idBiblioteca = idBiblioteca;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }
    
    //mysql 
    
    public static  List <Biblioteca> consultar(Connection conexion) throws SQLException{
        
        //lista 
        List <Biblioteca> bibliotecas = new ArrayList<Biblioteca> ();
        
        PreparedStatement consultar=conexion.prepareStatement("SELECT * FROM biblioteca ");
        ResultSet resultado=consultar.executeQuery();
        
        while(resultado.next()){
            
            Biblioteca b=new Biblioteca(resultado.getInt("idBiblioteca"),resultado.getString("nombre"),resultado.getString("ubicacion"));
            
            bibliotecas.add(b);
            
        }
        
        return bibliotecas;
        
    }
    
    
    //consulta por id de biblioteca
    
    public static Biblioteca consultarIdBiblioteca(Connection conexion,int id) throws SQLException{
        
        Biblioteca biblioteca=null;
        
        PreparedStatement consultar=conexion.prepareStatement("SELECT FROM biblioteca WHERE idBiblioteca="+id);
        ResultSet resultado=consultar.executeQuery();
        
        while(resultado.next()){
            
            Biblioteca b=new Biblioteca(resultado.getInt("idBiblioteca"),resultado.getString("nombre"),resultado.getString("autor"));
            biblioteca=b;  
            
        }
        
        return biblioteca;
        
    }
    
    
   

    public int getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(int idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;

    }
    
    
    
    
    
    
}
