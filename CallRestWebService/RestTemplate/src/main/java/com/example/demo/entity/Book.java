package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookID;
    @NotNull(message = "Book Name not null")
    private String bookName;
    @NotNull(message = "Actived not null")
    private Boolean actived;
    private String image;


    @JsonIgnore
    @OneToMany(mappedBy = "bookStoreID")
    private List<Store> storeID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cateID")
    private Category cate;

    public Book() {
    }

    public Book(Integer bookID, String bookName, Boolean actived, String image, List<Store> storeID, Category cate) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.actived = actived;
        this.image = image;
        this.storeID = storeID;
        this.cate = cate;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Boolean getActived() {
        return actived;
    }

    public void setActived(Boolean actived) {
        this.actived = actived;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Store> getStoreID() {
        return storeID;
    }

    public void setStoreID(List<Store> storeID) {
        this.storeID = storeID;
    }

    public Category getCate() {
        return cate;
    }

    public void setCate(Category cate) {
        this.cate = cate;
    }
}
