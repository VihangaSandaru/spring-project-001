package com.myFirstTestingProject.POS.api;

import com.myFirstTestingProject.POS.dto.CustomerDto;
import com.myFirstTestingProject.POS.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // POST method
    @PostMapping
    public String saveCustomer(@RequestBody CustomerDto dto){
        return customerService.savecustomer(dto)+" Saved!";
    }

    // PUT method
    @PutMapping
    public String updateCustomer(@RequestBody CustomerDto dto){
        return customerService.updatecustomer(dto)+" Updated!";
    }

    //DELETE method
    @DeleteMapping
    public String deleteCustomer(@RequestParam String id){
        return customerService.deletecustomer(id);
    }

    //GET method
    @GetMapping("/{id}")
    public CustomerDto getCustomer(@PathVariable String id){
        return customerService.findcustomer(id);
    }

    //GET method
    @GetMapping("/list")
    public ArrayList<CustomerDto> getAllCustomers(@RequestParam int page,
                                                  @RequestParam int size,
                                                  @RequestParam String searchText){
        return customerService.findAllcustomers(page, size, searchText);
    }
}