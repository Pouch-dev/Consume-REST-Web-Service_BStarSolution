package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    int bookID;
    String bookName;
    Boolean actived;
    String image;
    List<Store> storeID;
    Category cate;
}
