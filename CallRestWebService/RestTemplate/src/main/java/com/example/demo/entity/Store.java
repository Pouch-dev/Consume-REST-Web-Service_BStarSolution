package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "store")
public class Store implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storeID;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userStoreID")
    private Customer store;

    @ManyToOne
    @JoinColumn(name = "bookID")
    private Store bookStoreID;

    public Store() {
    }

    public Store(int storeID, Customer store, Store bookStoreID) {
        this.storeID = storeID;
        this.store = store;
        this.bookStoreID = bookStoreID;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public Customer getStore() {
        return store;
    }

    public void setStore(Customer store) {
        this.store = store;
    }

    public Store getBookStoreID() {
        return bookStoreID;
    }

    public void setBookStoreID(Store bookStoreID) {
        this.bookStoreID = bookStoreID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store1 = (Store) o;
        return storeID == store1.storeID && store.equals(store1.store) && bookStoreID.equals(store1.bookStoreID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeID, store, bookStoreID);
    }
}
