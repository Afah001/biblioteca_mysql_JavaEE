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

/**
 *
 * @author Anderson
 */
public class Libro {
    
    private int idLibro;
    private String nombre;
    private String autor;
    private Biblioteca biblioteca;

    public Libro() {
    }

    public Libro(String nombre, String autor, Biblioteca biblioteca) {
 
        this.nombre = nombre;
        this.autor = autor;
        this.biblioteca = biblioteca;
    }

    public Libro(int idLibro, String nombre, String autor/*, Biblioteca biblioteca*/) {
        this.idLibro = idLibro;
        this.nombre = nombre;
        this.autor = autor;
        this.biblioteca = biblioteca;
    }

    //Sql 
    
    //registrar 
    
    public static void registrar(Connection conexion,Libro libro) throws SQLException{
        
        PreparedStatement registrar=conexion.prepareStatement("INSERT INTO libro(nombre,ubicacion)VALUES(?,?)");
        
        registrar.setString(1, libro.getNombre());
        registrar.setString(2, libro.getAutor());
        registrar.executeUpdate();
        
            
    }
    
    public static List<Libro> consultar(Connection conexion) throws SQLException{
        
        //lista 
        List <Libro> libros = new ArrayList<Libro>();
        
        PreparedStatement consultar=conexion.prepareStatement("SELECT * FROM libro");
        ResultSet resultado=consultar.executeQuery();
        
        while(resultado.next()){
            
            Libro libro=new Libro(resultado.getInt("idLibro"),resultado.getString("nombre"),resultado.getString("autor")/*,resultado.getObject("biblioteca", Biblioteca)*/);
            libros.add(libro);
        
        }
        
        return libros;
    }
    
    public static void eliminar(Connection conexion,Libro libro) throws SQLException{
        
        PreparedStatement eliminar=conexion.prepareStatement("DELETE FROM libro WHERE idLibro="+libro.getIdLibro());
        eliminar.executeUpdate();
        
    }
            
    
    
    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    
    
    
  
    
    

}
