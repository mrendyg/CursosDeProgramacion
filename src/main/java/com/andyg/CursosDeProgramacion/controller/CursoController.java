package com.andyg.CursosDeProgramacion.controller;

import com.andyg.CursosDeProgramacion.persistence.DTO.CursoTemaDTO;
import com.andyg.CursosDeProgramacion.persistence.model.CursoEntity;
import com.andyg.CursosDeProgramacion.persistence.model.TemaEntity;
import com.andyg.CursosDeProgramacion.persistence.repository.CursoRepository;
import com.andyg.CursosDeProgramacion.persistence.repository.TemaRepository;
import com.andyg.CursosDeProgramacion.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TemaRepository temaRepository;

    //1 Crear un curso
    @PostMapping("/create")
    public CursoEntity createCurso(@RequestBody CursoEntity curso){
        return cursoService.createsCurso(curso);
    }

    //3 lista de todos los cursos
    @GetMapping("/list")
    public List<CursoEntity> ListCurso(){
        return cursoService.findsAll();
    }

    @GetMapping("/list/{id}")
    public CursoEntity cursoId(@PathVariable Long id){
        return cursoService.cursosId(id);
    }

    //Temas del curso
    @GetMapping("/temas/{cursoId}")
    public CursoTemaDTO listaDeTemasPorCurso(@PathVariable Long cursoId) {
        return cursoService.temasPorCurso(cursoId);
    }

    // busqueda por palabara Java en el nombre
    @GetMapping("/java")
    public List<CursoEntity> getCursoJava(){
        return cursoService.getsCursoJava();
    }

    //Actualizacion de cursos
    @PutMapping("/update/{id}")
    public CursoEntity updateCurso(@PathVariable long id, @RequestBody CursoEntity cursoEntity){
        return cursoService.updatesCurso(id, cursoEntity);
    }

}
