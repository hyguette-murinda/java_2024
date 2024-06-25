package rw.ac.rca.bankManagement.v1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.ac.rca.bankManagement.v1.dto.requests.CreateSavingsDTO;
import rw.ac.rca.bankManagement.v1.payload.ApiResponse;
import rw.ac.rca.bankManagement.v1.services.SavingsService;

@RestController
@RequestMapping("/api/v1/savings")
public class SavingsController {

    private final SavingsService savingsService;
    //    private final MailService mailService;

    @Autowired
    public SavingsController(SavingsService savingsService ) {

        this.savingsService = savingsService;
        //this.mailService = mailService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createSavings(@RequestBody CreateSavingsDTO createSavingsDTO) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Savings created successfully!", savingsService.registerCustomerToSaving(createSavingsDTO)));
            //mailService.endSaving("")
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage(), null), org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
