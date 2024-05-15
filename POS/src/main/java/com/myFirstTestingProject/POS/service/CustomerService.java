package com.myFirstTestingProject.POS.service;

import com.myFirstTestingProject.POS.dto.CustomerDto;

import java.util.ArrayList;

public interface CustomerService {
    String savecustomer(CustomerDto dto);
    String updatecustomer(CustomerDto dto);
    String deletecustomer(String id);
    CustomerDto findcustomer(String id);
    ArrayList<CustomerDto> findAllcustomers(int page, int size, String searchText);

}
