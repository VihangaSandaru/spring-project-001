package com.myFirstTestingProject.POS.service.impl;

import com.myFirstTestingProject.POS.dto.CustomerDto;
import com.myFirstTestingProject.POS.entity.Customer;
import com.myFirstTestingProject.POS.repo.CustomerRepo;
import com.myFirstTestingProject.POS.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class CustomerserviceImpl implements CustomerService {

    private final CustomerRepo repo;

    public CustomerserviceImpl(CustomerRepo repo) {
        this.repo = repo;
    }

    @Override
    public String savecustomer(CustomerDto dto) {
        return repo.save(new Customer(dto.getId(),dto.getName(),dto.getAddress(),dto.getSalary()))
                .getName();
    }

    @Override
    public String updatecustomer(CustomerDto dto) {
       Optional<Customer> tempCustomer =  repo.findById(dto.getId());

       if (tempCustomer.isPresent()){
           tempCustomer.get().setName(dto.getName());
           tempCustomer.get().setAddress(dto.getAddress());
           tempCustomer.get().setSalary(dto.getSalary());
           return repo.save(tempCustomer.get()).getName();
       }
       return "Customer Not Found";
    }

    @Override
    public String deletecustomer(String id) {
        Optional<Customer> tempCustomer = repo.findById(id);
        if(tempCustomer.isPresent()){
            repo.delete(tempCustomer.get());
            return id+" Deleted!";
        }
        return "Customer Not Found";
    }

    @Override
    public CustomerDto findcustomer(String id) {
        Optional<Customer> customerData = repo.findById(id);
        if (customerData.isPresent()){
            return new CustomerDto(
              customerData.get().getId(),
              customerData.get().getName(),
              customerData.get().getAddress(),
              customerData.get().getSalary()
            );
        }
        else {
            return null;
        }
    }

    @Override
    public ArrayList<CustomerDto> findAllcustomers(int page, int size, String searchText) {
        List<Customer> all = repo.findAll();
        ArrayList<CustomerDto> dtos = new ArrayList<>();

        for (Customer c:all){
            dtos.add(new CustomerDto(
                    c.getId(),
                    c.getName(),
                    c.getAddress(),
                    c.getSalary()
            ));
        }
        return dtos;

    }
}
