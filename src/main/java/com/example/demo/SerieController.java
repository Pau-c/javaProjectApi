package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.SerieDAO;
import com.example.demo.model.Serie;
import com.example.demo.model.SerieRequest;

@RestController
public class SerieController {

    @CrossOrigin(origins = "*")
    @GetMapping("/listarSeries")
    public List<Serie> listarSeries() {
        SerieDAO serieDAO=new SerieDAO();
        System.out.println(serieDAO);
        return serieDAO.listar();
    }
    
 

    @CrossOrigin(origins = "*")
    @PostMapping("/addSerie")
    public void addSerie(@RequestBody SerieRequest serieRequest) {
        Serie show = new Serie(serieRequest.gettitulo(), 
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
        Serie show = new Serie(id, serieRequest.gettitulo(),
                                     Double.valueOf(serieRequest.getPuntuacion()),
                                     serieRequest.getPortada(),
                                     serieRequest.getReview() );

        SerieDAO serieDAO = new SerieDAO();
        serieDAO.update(show);
    }
}
