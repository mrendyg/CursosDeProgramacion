package com.andyg.CursosDeProgramacion.controller;

import com.andyg.CursosDeProgramacion.persistence.DTO.CursoTemaDTO;
import com.andyg.CursosDeProgramacion.persistence.model.CursoEntity;
import com.andyg.CursosDeProgramacion.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    //1 Crear un curso
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CursoEntity createCurso(@RequestBody CursoEntity curso){
        return cursoService.createsCurso(curso);
    }

    //3 lista de todos los cursos
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<CursoEntity> ListCurso(){
        return cursoService.findsAll();
    }

    @GetMapping("/list/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CursoEntity cursoId(@PathVariable Long id){
        return cursoService.cursosId(id);
    }

    //Temas del curso
    @GetMapping("/temas/{cursoId}")
    @ResponseStatus(HttpStatus.OK)
    public CursoTemaDTO listaDeTemasPorCurso(@PathVariable Long cursoId) {
        return cursoService.temasPorCurso(cursoId);
    }

    // busqueda por palabara Java en el nombre
    @GetMapping("/java")
    @ResponseStatus(HttpStatus.OK)
    public List<CursoEntity> getCursoJava(){
        return cursoService.getsCursoJava();
    }

    //Actualizacion de cursos
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CursoEntity updateCurso(@PathVariable long id, @RequestBody CursoEntity cursoEntity){
        return cursoService.updatesCurso(id, cursoEntity);
    }

}
