package com.bridgelabz.addressbookapplication.Service;

import com.bridgelabz.addressbookapplication.DTO.AddressBookDTO;
import com.bridgelabz.addressbookapplication.Model.AddressBook;

import java.util.List;

public interface IAddressBook {
    List<AddressBook> getAddressBookDetails();

    AddressBook getAddressBookDataById(String token);

    String createAddressBookData(AddressBookDTO addressBookDTO);

    AddressBook updateAddressBookData(String token,AddressBookDTO addressBookDTO);

    void deleteAddressBookData(String token);

    List<AddressBook> findDataByCity(String city);

    List<AddressBook> findDataByName(String fullName);

    List<AddressBook> findDataByMobileNumber(String mobileNumber);

    List<AddressBook> sortingByCity();

    List<AddressBook> sortingByState();


}
