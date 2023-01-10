package com.bridgelabz.addressbookapplication.Service;

import com.bridgelabz.addressbookapplication.DTO.AddressBookDTO;
import com.bridgelabz.addressbookapplication.Model.AddressBook;

import java.util.List;

public interface IAddressBook {
    List<AddressBook> getAddressBookDetails();

    AddressBook getAddressBookDataById(int Id);

    AddressBook createAddressBookData(AddressBookDTO addressBookDTO);

    AddressBook updateAddressBookData(int Id,AddressBookDTO addressBookDTO);

    void deleteAddressBookData(int Id);

    List<AddressBook> findDataByCity(String city);

    List<AddressBook> findDataByName(String fullName);

    List<AddressBook> findDataByMobileNumber(String mobileNumber);

    List<AddressBook> sortingByCity();

    List<AddressBook> sortingByState();


}
