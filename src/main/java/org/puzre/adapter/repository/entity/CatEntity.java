package org.puzre.adapter.repository.entity;

import jakarta.persistence.*;

@Entity(name = "cats")
public class CatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "image_path", nullable = false)
    private String imagePath;

    @Column(name = "message", nullable = false)
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private TypeEntity type;

}
