package com.bridgelabz.addressbookapplication.DTO;

import jakarta.validation.constraints.*;
import lombok.ToString;

@ToString
public class AddressBookDTO {

    @Pattern(regexp="^[A-Z]{1}[a-zA-z\\s]{2,}$",message = "name is Invalid")
    @NotNull(message = "Name cannot be empty")
    public String fullName;

    @NotEmpty(message = "Address cannot be empty")
    public String Address;

    @NotEmpty(message = "mobile number cannot be empty")
    public String mobileNumber;

    @Email(message = "email Id cannot be empty")
    public String emailId;


    @NotEmpty(message = "city cannot be empty")
    public String city;


    @NotEmpty(message = "state cannot be empty")
    public String state;


    @NotEmpty(message = "country cannot be empty")
    public String country;

    @NotNull(message = "pin code cannot be empty")
    public long pinCode;
}
