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

}
