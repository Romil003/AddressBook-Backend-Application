package com.bridgelabz.addressbookapplication.Repository;

import com.bridgelabz.addressbookapplication.Model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<AddressBook,Integer> {


    @Query(value = "select * from address_book_table where city = :city" ,nativeQuery = true)
    List<AddressBook> findByCity(String city);

    @Query(value = "select * from address_book_table where full_Name = :fullName" ,nativeQuery = true)
    List<AddressBook> findByName(String fullName);

    @Query(value = "select * from address_book_table where mobile_Number = :mobileNumber" ,nativeQuery = true)
    List<AddressBook> findByMobileNumber(String mobileNumber);

    @Query(value = "select * from address_book_table order by city" ,nativeQuery = true)
    List<AddressBook> sortByCity();

    @Query(value = "select * from address_book_table order by state desc " ,nativeQuery = true)
    List<AddressBook> sortByState();
}
