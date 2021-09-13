package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    Long id;
    String username;
    String password;
    String fullName;
    String phoneNumber;
    String address ;
    List<Store> userStoreID;
}
