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

    @GetMapping("/findbycity/{city}")
    public ResponseEntity<ResponseDTO> getAddressBookDataByCity(@PathVariable String city){
        List<AddressBook> addressBooks = iAddressBook.findDataByCity(city);
        ResponseDTO responseDTO = new ResponseDTO("Get all data of Address book according to city: " +city,addressBooks);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/findbyname/{fullName}")
    public ResponseEntity<ResponseDTO> getAddressBookDataByFullName(@PathVariable String fullName){
        List<AddressBook> addressBooks = iAddressBook.findDataByName(fullName);
        ResponseDTO responseDTO = new ResponseDTO("Get all data of Address book according to fullname: " +fullName,addressBooks);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/findbymobilenumber/{mobileNumber}")
    public ResponseEntity<ResponseDTO> getAddressBookDataByMobileNumber(@PathVariable String mobileNumber){
        List<AddressBook> addressBooks = iAddressBook.findDataByMobileNumber(mobileNumber);
        ResponseDTO responseDTO = new ResponseDTO("Get all data of Address book according to mobileNumber: " +mobileNumber,addressBooks);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/sortbycity")
    public ResponseEntity<ResponseDTO> getSortedAddressBookDataByCity(){
        List<AddressBook> addressBooks = iAddressBook.sortingByCity();
        ResponseDTO responseDTO = new ResponseDTO("Get all sorted data of Address book according to city: ",addressBooks);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/sortbystate")
    public ResponseEntity<ResponseDTO> getSortedAddressBookDataByState(){
        List<AddressBook> addressBooks = iAddressBook.sortingByState();
        ResponseDTO responseDTO = new ResponseDTO("Get all sorted data of Address book according to state: ",addressBooks);
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
