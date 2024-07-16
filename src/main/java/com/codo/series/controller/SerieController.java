package com.codo.series.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codo.series.dao.SerieDAO;
import com.codo.series.model.Serie;
import com.codo.series.model.SerieRequest;

@RestController
public class SerieController {

    @CrossOrigin(origins = "*")
    @GetMapping("/listSeries")
    public List<Serie> listSeries() {
        SerieDAO serieDAO=new SerieDAO();
        System.out.println(serieDAO);
        return serieDAO.list();
    }
    
 

    @CrossOrigin(origins = "*")
    @PostMapping("/addSerie")
    public void addSerie(@RequestBody SerieRequest serieRequest) {
        Serie show = new Serie(serieRequest.getTitulo(), 
                                     Double.valueOf(serieRequest.getPuntuacion()), 
                                     serieRequest.getPortada(), serieRequest.getReview());

        SerieDAO serieDAO = new SerieDAO();
        serieDAO.add(show);
    }


    @CrossOrigin(origins = "*")
    @DeleteMapping("/delSerie/{id}")
    public void delSerie(@PathVariable("id") Integer id) {
        Serie show=new Serie(id);

        SerieDAO serieDAO=new SerieDAO();
        serieDAO.del(show);

    }

     @CrossOrigin(origins = "*")
    @PutMapping("/updateSerie/{id}")
    public void updateSerie(@PathVariable("id") Integer id, @RequestBody SerieRequest serieRequest) {
        Serie show = new Serie(id, serieRequest.getTitulo(),
                                     Double.valueOf(serieRequest.getPuntuacion()),
                                     serieRequest.getPortada(),
                                     serieRequest.getReview() );

        SerieDAO serieDAO = new SerieDAO();
        serieDAO.update(show);
    }
}
