package com.andyg.CursosDeProgramacion.controller;

import com.andyg.CursosDeProgramacion.persistence.model.CursoEntity;
import com.andyg.CursosDeProgramacion.persistence.model.TemaEntity;
import com.andyg.CursosDeProgramacion.persistence.repository.CursoRepository;
import com.andyg.CursosDeProgramacion.persistence.repository.TemaRepository;
import com.andyg.CursosDeProgramacion.service.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/api/tema")
public class TemaController {

    @Autowired
    private TemaRepository temaRepository;

    @Autowired
    private TemaService temaService;

    @Autowired
    private CursoRepository cursoRepository;

    //2 Crear un tema y asociarlo a un curso
    @PostMapping("/create")
    public TemaEntity createTema(@RequestBody TemaEntity tema){
        return temaService.createsTema(tema);
    }

    @GetMapping("/list")
    public List<TemaEntity> listTema(){
        return temaService.listaDeTemas();
    }

    @PutMapping("/update/{id}")
    public TemaEntity updateTema(@PathVariable long id, @RequestBody TemaEntity temaEntity){
        return temaService.updatesTema(id, temaEntity);
    }
}
