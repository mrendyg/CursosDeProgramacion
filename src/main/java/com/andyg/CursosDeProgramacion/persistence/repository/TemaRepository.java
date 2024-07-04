package com.andyg.CursosDeProgramacion.persistence.repository;

import com.andyg.CursosDeProgramacion.persistence.model.CursoEntity;
import com.andyg.CursosDeProgramacion.persistence.model.TemaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TemaRepository extends JpaRepository<TemaEntity, Long> {

    List<TemaEntity> findByCursoId_Id(Long cursoId);

}
