package com.bridgelabz.addressbookapplication.Service;

import com.bridgelabz.addressbookapplication.DTO.AddressBookDTO;
import com.bridgelabz.addressbookapplication.Exception.AddressBookException;
import com.bridgelabz.addressbookapplication.Model.AddressBook;
import com.bridgelabz.addressbookapplication.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService implements IAddressBook{
    @Autowired
    public BookRepository bookRepository;

    @Override
    public List<AddressBook> getAddressBookDetails() {
        return bookRepository.findAll();
    }

    @Override
    public AddressBook getAddressBookDataById(int Id) {
        return bookRepository.findById(Id).orElseThrow(() -> new AddressBookException("Data Not Found"));
    }

    @Override
    public AddressBook createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook(addressBookDTO);
        bookRepository.save(addressBook);
        return addressBook;
    }

    @Override
    public AddressBook updateAddressBookData(int Id, AddressBookDTO addressBookDTO) {
        AddressBook addressBook = this.getAddressBookDataById(Id);
        if(addressBook != null){
            addressBook.setFullName(addressBookDTO.fullName);
            addressBook.setAddress(addressBookDTO.Address);
            addressBook.setMobileNumber(addressBookDTO.mobileNumber);
            addressBook.setEmailId(addressBookDTO.emailId);
            addressBook.setCity(addressBookDTO.city);
            addressBook.setState(addressBookDTO.state);
            addressBook.setCountry(addressBookDTO.country);
            addressBook.setPinCode(addressBookDTO.pinCode);
            bookRepository.save(addressBook);
            return addressBook;
        }
        return null;
    }

    @Override
    public void deleteAddressBookData(int Id) {
        bookRepository.deleteById(Id);
    }


}
