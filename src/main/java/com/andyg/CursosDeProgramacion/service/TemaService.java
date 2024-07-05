package com.andyg.CursosDeProgramacion.service;

import com.andyg.CursosDeProgramacion.persistence.model.CursoEntity;
import com.andyg.CursosDeProgramacion.persistence.model.TemaEntity;
import com.andyg.CursosDeProgramacion.persistence.repository.CursoRepository;
import com.andyg.CursosDeProgramacion.persistence.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TemaService {

    @Autowired
    private TemaRepository temaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    //crear un tema y asociarlo a un curso
    public TemaEntity createsTema(TemaEntity tema){
        Set<CursoEntity> cursoExistente = new HashSet<>();

        for (CursoEntity cursoEntity : tema.getCursoId()){
            cursoExistente.add(cursoRepository.findById(cursoEntity.getId()).orElseThrow(() ->
                    new RuntimeException("Curso no encontrado")));
        }
        tema.setCursoId(cursoExistente);
        return temaRepository.save(tema);
    }

    //Todos los temas
    public List<TemaEntity> listaDeTemas(){
        return temaRepository.findAll();
    }

    public TemaEntity updatesTema(Long id, TemaEntity temaEntity) {
        TemaEntity updateTema = temaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tema no encontrado"));
        updateTema.setName(temaEntity.getName());
        updateTema.setDescription(temaEntity.getDescription());
        updateTema.setCursoId(temaEntity.getCursoId());
        return temaRepository.save(updateTema);
    }



}
