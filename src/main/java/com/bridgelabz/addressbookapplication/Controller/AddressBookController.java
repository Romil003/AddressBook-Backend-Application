package com.bridgelabz.addressbookapplication.Controller;

import com.bridgelabz.addressbookapplication.DTO.AddressBookDTO;
import com.bridgelabz.addressbookapplication.DTO.ResponseDTO;
import com.bridgelabz.addressbookapplication.Model.AddressBook;
import com.bridgelabz.addressbookapplication.Service.IAddressBook;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbookapp")
public class AddressBookController {

    @Autowired
    public IAddressBook iAddressBook;

    @GetMapping("/allData")
    public ResponseEntity<ResponseDTO> getAddressBookData(){
        List<AddressBook> addressBooks = iAddressBook.getAddressBookDetails();
        ResponseDTO responseDTO = new ResponseDTO("Get all data of Address book",addressBooks);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{Id}")
    public ResponseEntity<ResponseDTO> getAddressBookDataById(@PathVariable("Id") int Id){
        AddressBook addressBook = iAddressBook.getAddressBookDataById(Id);
        ResponseDTO responseDTO = new ResponseDTO("Get all data of Id : "+Id,addressBook);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/createData")
    public ResponseEntity<ResponseDTO> createAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO){
        AddressBook addressBook1 = iAddressBook.createAddressBookData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Creating data of Address book",addressBook1);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/updateData/{Id}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable int Id,@Valid @RequestBody AddressBookDTO addressBookDTO){
        AddressBook addressBook2 = iAddressBook.updateAddressBookData(Id,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updating data of Address book",addressBook2);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<ResponseDTO> deleteAddressBookDataById(@PathVariable int Id){
        iAddressBook.deleteAddressBookData(Id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted successfully","Deleted data of Id "+Id);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }



}
