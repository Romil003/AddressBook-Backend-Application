package com.bridgelabz.addressbookapplication.Model;

import com.bridgelabz.addressbookapplication.DTO.AddressBookDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "AddressBook_Table")
public @Data class AddressBook {

    @Id
    @GeneratedValue
    private int Id;
    private String fullName;
    private String Address;
    private String mobileNumber;
    private String emailId;
    private String city;
    private String state;
    private String country;
    private long pinCode;

    public AddressBook() {
    }

    public AddressBook(AddressBookDTO addressBookDTO) {
        this.fullName = addressBookDTO.fullName;
        this.Address = addressBookDTO.Address;
        this.mobileNumber = addressBookDTO.mobileNumber;
        this.emailId = addressBookDTO.emailId;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.country=addressBookDTO.country;
        this.pinCode=addressBookDTO.pinCode;
    }

    public AddressBook(int Id ,AddressBookDTO addressBookDTO) {
        this.Id = Id;
        this.fullName = addressBookDTO.fullName;
        this.Address = addressBookDTO.Address;
        this.mobileNumber = addressBookDTO.mobileNumber;
        this.emailId = addressBookDTO.emailId;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.country=addressBookDTO.country;
        this.pinCode=addressBookDTO.pinCode;
    }

}
