package org.puzre.adapter.repository.entity;

import jakarta.persistence.*;
import lombok.*;
import org.puzre.core.domain.Type;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
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

    public Type toType() {
        return Type.builder()
                .id(this.id)
                .name(this.name).build();
    }

}
