package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.db.ConnectorDB;
import com.example.demo.model.Pelicula;





/**
 * Esta clase agrupa todas la consultas a la tabla.
 * Consultas, insert, upd, y del
 * 
 */
public class PeliculaDAO {
 
    public List<Pelicula> listar() {
        try {
            
            Statement st=ConnectorDB.getSt();
            ResultSet rs=st.executeQuery("Select * from series");
            
            // recorro todas las filas
            // crea un objeto fila
            List<Pelicula> listPeli=new ArrayList<Pelicula>();
            while (rs.next()) {
                // orm: mapeo relacional objeto con hibernate, jpa
                Pelicula peli=new Pelicula(rs.getInt("id"), rs.getString("titulo"), rs.getDate("anio"), rs.getDouble("puntuacion"), rs.getString("portada"), rs.getString("review"));
                listPeli.add(peli);
            }         
            
            return listPeli;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
        
    }

    public Boolean add(Pelicula peli) {
        try {
            Statement st=ConnectorDB.getSt();
            Integer cantInsert=st.executeUpdate("INSERT INTO series (titulo, puntuacion, portada, review) VALUES ('"+peli.gettitulo()+"', "+peli.getPuntuacion()+", '"+peli.getPortada()+"', '"+peli.getReview()+"')");
            
            Boolean insertOk=(cantInsert==1);

            return insertOk;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Boolean del(Pelicula peli) {
        try {
            Statement st=ConnectorDB.getSt();
            Integer cantDel=st.executeUpdate("DELETE FROM series WHERE id="+peli.getId());
            
            Boolean delOk=(cantDel==1);

            return delOk;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Boolean update(Pelicula peli) {
        try {
            Statement st = ConnectorDB.getSt();
            Integer cantUpdate = st.executeUpdate(
            "UPDATE series SET titulo='" + peli.gettitulo() + 
            "', puntuacion=" + peli.getPuntuacion() + 
            ", portada='" + peli.getPortada() + 
            "', review='" + peli.getReview() + 
            "' WHERE id=" + peli.getId()
        );

            Boolean updateOk = (cantUpdate == 1);

            return updateOk;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
