package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @NotEmpty(message = "Category ID not empty")
    private Integer categoryID;
    @NotNull(message = "Category Name not null")
    private String categoryName;

    @JsonIgnore
    @OneToMany(mappedBy = "cate")
    private List<Book> cateID;

    public Category() {
    }

    public Category(Integer categoryID, String categoryName, List<Book> cateID) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.cateID = cateID;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Book> getCateID() {
        return cateID;
    }

    public void setCateID(List<Book> cateID) {
        this.cateID = cateID;
    }
}
