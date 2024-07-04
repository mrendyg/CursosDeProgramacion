package com.andyg.CursosDeProgramacion.persistence.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tema")
public class TemaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "tema_curso", joinColumns = @JoinColumn(name = "id_tema"),
            inverseJoinColumns = @JoinColumn(name = "id_curso"))
    public Set<CursoEntity> cursoId = new HashSet<>();


}
