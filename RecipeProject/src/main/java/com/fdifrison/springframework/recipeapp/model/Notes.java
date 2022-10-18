package com.fdifrison.springframework.recipeapp.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    https://stackoverflow.com/questions/20603638/what-is-the-use-of-annotations-id-and-generatedvaluestrategy-generationtype
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob // Large Object Field
    /*
     Lob: We want the recipe Notes to be able to store more than the default 255 characters, so we
     are telling the db to expect something bigger
    */
    private String recipeNotes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Notes notes = (Notes) o;
        return id != null && Objects.equals(id, notes.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
