package com.andyg.CursosDeProgramacion.service;

import com.andyg.CursosDeProgramacion.persistence.DTO.CursoTemaDTO;
import com.andyg.CursosDeProgramacion.persistence.model.CursoEntity;
import com.andyg.CursosDeProgramacion.persistence.model.TemaEntity;
import com.andyg.CursosDeProgramacion.persistence.repository.CursoRepository;
import com.andyg.CursosDeProgramacion.persistence.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TemaRepository temaRepository;

    //Creacion de un curso
    public CursoEntity createsCurso(@RequestBody CursoEntity curso){
        return cursoRepository.save(curso);
    }

    //Lista de cursos
    public List<CursoEntity> findsAll(){
        return cursoRepository.findAll();
    }

    //cursos por ID
    public CursoEntity cursosId(Long id){
        return cursoRepository.findById(id).orElse(null);
    }

    //Temas por curso
    public CursoTemaDTO temasPorCurso(@PathVariable Long cursoId){
        //manejo de la entidad curso, buscado por id
        CursoEntity cursoEntity = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso not found with id " + cursoId));

        //manejo de la entidad Tema, buscando por el cursoId
        List<TemaEntity> listaTemas = temaRepository.findByCursoId_Id(cursoId);

        //devuelvo a traves de DTO el nombre del curso y sus temas asociados
        return new CursoTemaDTO(cursoEntity.getName(), listaTemas);
    }

    //Buscar la palabra Java en los titulos de los cursos
    public List<CursoEntity> getsCursoJava(){
        String keyword = "Java";
        String keywordCompare;

        List<CursoEntity> listaCursos = this.findsAll();
        List<CursoEntity> listaCursoJava = new ArrayList<CursoEntity>();

        for(CursoEntity cursoEntity : listaCursos){
            keywordCompare = cursoEntity.getName();
            boolean contieneJava = keywordCompare.contains(keyword);
            if (contieneJava == true){
                listaCursoJava.add(cursoEntity);
            }
        }
        return listaCursoJava;
    }

    //Actualizar un curso
    public CursoEntity updatesCurso(long id, CursoEntity cursoEntity){
        CursoEntity updatedCurso = cursoRepository.findById(id).get();
        updatedCurso.setName(cursoEntity.getName());
        updatedCurso.setModalidad(cursoEntity.getModalidad());
        updatedCurso.setFecha_finalizacion(cursoEntity.getFecha_finalizacion());
        return cursoRepository.save(updatedCurso);
    }

}
