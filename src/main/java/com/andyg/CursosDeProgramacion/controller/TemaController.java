package com.andyg.CursosDeProgramacion.controller;

import com.andyg.CursosDeProgramacion.persistence.model.TemaEntity;
import com.andyg.CursosDeProgramacion.service.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tema")
public class TemaController {

    @Autowired
    private TemaService temaService;

    //2 Crear un tema y asociarlo a un curso
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public TemaEntity createTema(@RequestBody TemaEntity tema){
        return temaService.createsTema(tema);
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<TemaEntity> listTema(){
        return temaService.listaDeTemas();
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public TemaEntity updateTema(@PathVariable long id, @RequestBody TemaEntity temaEntity){
        return temaService.updatesTema(id, temaEntity);
    }
}
