package org.puzre.adapter.repository.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "types")
public class TypeEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private List<CatEntity> cats;

}
