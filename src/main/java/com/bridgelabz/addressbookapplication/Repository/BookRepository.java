package com.bridgelabz.addressbookapplication.Repository;

import com.bridgelabz.addressbookapplication.Model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<AddressBook,Integer> {


    @Query(value = "select * from AddressBook_Table where city = :city" ,nativeQuery = true)
    AddressBook findByCity(String city);
}
