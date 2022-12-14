/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodri
 */
public class Usuarios {

    private int idUsuario;
    private String Usuario, Pass, Nombres, Apellidos, key;
    private Conexion con;

    public Usuarios() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int validarUserPassword(String usuario, String pass, String key) {
        int retorno = 0;
        String[] caracteres={","," ","\\","=","'","(",")","-","_",";","+","*","\"","&","!"};
        for (String escape : caracteres) {
            System.out.println(escape);
          usuario=usuario.replace(escape, ".");  
          pass=pass.replace(escape, ".");  
          key=key.replace(escape, ".");  
          
        }
            System.out.println(pass);
        try {
            con = new Conexion();
            con.abrirConexion();
            PreparedStatement parametro;
            String Query = "select * from usuarios where Usuario='" + usuario + "' and Password=aes_encrypt('" + pass + "','" + key + "')";
            parametro = con.conexionbd.prepareStatement(Query);
            ResultSet rs = parametro.executeQuery();
            if (rs.next()) {

                retorno = 1;

            } else {
                return retorno = 0;
            }
            con.cerrarConexion();
        } catch (Exception ex) {
            retorno = 0;
        }
        return retorno;
    }

    public String name(String usuario) {
        String retorno = null;

        try {
            con = new Conexion();
            con.abrirConexion();
            PreparedStatement parametro;
            String Query = "select Nombre from usuarios where Usuario='" + usuario + "';";
            parametro = con.conexionbd.prepareStatement(Query);
            ResultSet rs = parametro.executeQuery();

            while (rs.next()) {
                retorno = rs.getString("Nombre");
            }
            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    public String lastName(String usuario) {
        String retorno = null;

        try {
            con = new Conexion();
            con.abrirConexion();
            PreparedStatement parametro;
            String Query = "select Apellido from usuarios where Usuario='" + usuario + "';";
            parametro = con.conexionbd.prepareStatement(Query);
            ResultSet rs = parametro.executeQuery();

            while (rs.next()) {
                retorno = rs.getString("Apellido");
            }
            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    public String accessMarcas(String usuario) throws SQLException {
        String retorno = null;

        con = new Conexion();
        con.abrirConexion();
        PreparedStatement parametro;
        String Query = "select Marcas from usuarios where Usuario='" + usuario + "';";
        parametro = con.conexionbd.prepareStatement(Query);
        ResultSet rs = parametro.executeQuery();

        while (rs.next()) {
            retorno = rs.getString("Marcas");
        }
        con.cerrarConexion();

        return retorno;
    }

    public String accessProducts(String usuario) throws SQLException {
        String retorno = null;

        con = new Conexion();
        con.abrirConexion();
        PreparedStatement parametro;
        String Query = "select Productos from usuarios where Usuario='" + usuario + "';";
        parametro = con.conexionbd.prepareStatement(Query);
        ResultSet rs = parametro.executeQuery();

        while (rs.next()) {
            retorno = rs.getString("Productos");
        }
        con.cerrarConexion();

        return retorno;
    }

    public String accessCategory(String usuario) throws SQLException {
        String retorno = null;

        con = new Conexion();
        con.abrirConexion();
        PreparedStatement parametro;
        String Query = "select Categorias from usuarios where Usuario='" + usuario + "';";
        parametro = con.conexionbd.prepareStatement(Query);
        ResultSet rs = parametro.executeQuery();

        while (rs.next()) {
            retorno = rs.getString("Categorias");
        }
        con.cerrarConexion();

        return retorno;
    }

        public String accessImages(String usuario) throws SQLException {
        String retorno = null;

        con = new Conexion();
        con.abrirConexion();
        PreparedStatement parametro;
        String Query = "select Imagenes from usuarios where Usuario='" + usuario + "';";
        parametro = con.conexionbd.prepareStatement(Query);
        ResultSet rs = parametro.executeQuery();

        while (rs.next()) {
            retorno = rs.getString("Imagenes");
        }
        con.cerrarConexion();

        return retorno;
    }

    private void procesamientoDeCadenas(String[] caracteres, String usuario, String pass, String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
