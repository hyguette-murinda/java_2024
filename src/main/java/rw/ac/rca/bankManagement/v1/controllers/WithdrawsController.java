package rw.ac.rca.bankManagement.v1.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.ac.rca.bankManagement.v1.dto.requests.*;
import rw.ac.rca.bankManagement.v1.payload.ApiResponse;
import rw.ac.rca.bankManagement.v1.services.WithdrawsService;
@RestController
@RequestMapping("/api/v1/withdraws")
@RequiredArgsConstructor
public class WithdrawsController {

    private final WithdrawsService withdrawsService;
    private final CreateSavingsDTO createSavingsDTO;
    //create student
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createWithdraws(@RequestBody CreateWithdrawsDTO createWithdrawsDTO) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Student created successfully!", withdrawsService.registerCustomerToWithdraw(createWithdrawsDTO)));
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage(), null), org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
