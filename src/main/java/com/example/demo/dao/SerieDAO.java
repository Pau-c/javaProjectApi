package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.db.ConnectorDB;
import com.example.demo.model.Serie;





/**
 * Esta clase agrupa todas la consultas a la tabla.
 * Consultas, insert, upd, y del
 * 
 */
public class SerieDAO {
 
    public List<Serie> listar() {
        try {
            
            Statement st=ConnectorDB.getSt();
            ResultSet rs=st.executeQuery("Select * from series");
            
            // recorro todas las filas
            // crea un objeto fila
            List<Serie> listShow=new ArrayList<Serie>();
            while (rs.next()) {
                // orm: mapeo relacional objeto con hibernate, jpa
                Serie show=new Serie(rs.getInt("id"), rs.getString("titulo"), rs.getDate("anio"), rs.getDouble("puntuacion"), rs.getString("portada"), rs.getString("review"));
                listShow.add(show);
            }         
            
            return listShow;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
        
    }

    public Boolean add(Serie show) {
        try {
            Statement st=ConnectorDB.getSt();
            Integer cantInsert=st.executeUpdate("INSERT INTO series (titulo, puntuacion, portada, review) VALUES ('"+show.gettitulo()+"', "+show.getPuntuacion()+", '"+show.getPortada()+"', '"+show.getReview()+"')");
            
            Boolean insertOk=(cantInsert==1);

            return insertOk;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Boolean del(Serie show) {
        try {
            Statement st=ConnectorDB.getSt();
            Integer cantDel=st.executeUpdate("DELETE FROM series WHERE id="+show.getId());
            
            Boolean delOk=(cantDel==1);

            return delOk;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Boolean update(Serie show) {
        try {
            Statement st = ConnectorDB.getSt();
            Integer cantUpdate = st.executeUpdate(
            "UPDATE series SET titulo='" + show.gettitulo() + 
            "', puntuacion=" + show.getPuntuacion() + 
            ", portada='" + show.getPortada() + 
            "', review='" + show.getReview() + 
            "' WHERE id=" + show.getId()
        );

            Boolean updateOk = (cantUpdate == 1);

            return updateOk;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
