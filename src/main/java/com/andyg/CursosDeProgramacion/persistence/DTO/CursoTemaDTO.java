package com.andyg.CursosDeProgramacion.persistence.DTO;

import com.andyg.CursosDeProgramacion.persistence.model.TemaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CursoTemaDTO {

    private String nombreCurso;
    private List<TemaEntity> listaTemas;

}
