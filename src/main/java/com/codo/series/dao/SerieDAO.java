package com.codo.series.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codo.series.db.ConnectorDB;
import com.codo.series.model.Serie;

public class SerieDAO {

    public List<Serie> list() {
        try {
            Statement st = ConnectorDB.getInstance().getStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM series");
            
            List<Serie> listShow = new ArrayList<Serie>();
            while (rs.next()) {
                Serie show = new Serie(
                    rs.getInt("id"), 
                    rs.getString("titulo"), 
                    rs.getDate("anio"), 
                    rs.getDouble("puntuacion"), 
                    rs.getString("portada"), 
                    rs.getString("review")
                );
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
            Statement st = ConnectorDB.getInstance().getStatement();
            Integer rowsInserted = st.executeUpdate(
                "INSERT INTO series (titulo, puntuacion, portada, review) VALUES ('" +
                show.getTitulo() + "', " + show.getPuntuacion() + ", '" + show.getPortada() + "', '" + show.getReview() + "')"
            );

            return isOperationSuccessful(rowsInserted);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Boolean del(Serie show) {
        try {
            Statement st = ConnectorDB.getInstance().getStatement();
            Integer rowsDeleted = st.executeUpdate("DELETE FROM series WHERE id=" + show.getId());

            return isOperationSuccessful(rowsDeleted);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Boolean update(Serie show) {
        try {
            Statement st = ConnectorDB.getInstance().getStatement();
            Integer rowsUpdated = st.executeUpdate(
                "UPDATE series SET titulo='" + show.getTitulo() + 
                "', puntuacion=" + show.getPuntuacion() + 
                ", portada='" + show.getPortada() + 
                "', review='" + show.getReview() + 
                "' WHERE id=" + show.getId()
            );

            return isOperationSuccessful(rowsUpdated);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Boolean isOperationSuccessful(int rowsAffected) {
        return rowsAffected == 1;
    }
}
