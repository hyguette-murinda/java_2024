package rw.ac.rca.bankManagement.v1.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.ac.rca.bankManagement.v1.dto.requests.CreateCustomerDTO;
import rw.ac.rca.bankManagement.v1.payload.ApiResponse;
import rw.ac.rca.bankManagement.v1.services.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CreateCustomerDTO createCustomerDTO;
    //create student
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCustomer(@RequestBody CreateCustomerDTO createCustomerDTO) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Student created successfully!", customerService.saveCustomer(createCustomerDTO)));
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage(), null), org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    // get all students registered
    @GetMapping("/get-all")
    public ResponseEntity<ApiResponse> getAllCustomers(){
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Students retrieved successfully!", customerService.getAllCustomers()));
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage(), null), org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
