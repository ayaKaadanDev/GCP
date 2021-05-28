package org.closure.gcp.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "collages")
public class CollageEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column(nullable = false)
    private String collageName;

    @OneToMany(mappedBy = "college")
    private List<UserEntity> users;

    public CollageEntity() {
    }

    public CollageEntity(Integer id, String collageName) {
        this.id = id;
        this.collageName = collageName;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCollageName() {
        return this.collageName;
    }

    public void setCollageName(String collageName) {
        this.collageName = collageName;
    }

    public CollageEntity id(Integer id) {
        setId(id);
        return this;
    }

    public CollageEntity collageName(String collageName) {
        setCollageName(collageName);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CollageEntity)) {
            return false;
        }
        CollageEntity collageEntity = (CollageEntity) o;
        return Objects.equals(id, collageEntity.id) && Objects.equals(collageName, collageEntity.collageName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, collageName);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", collageName='" + getCollageName() + "'" +
            "}";
    }

}
