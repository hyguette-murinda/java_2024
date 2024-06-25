package rw.ac.rca.bankManagement.v1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.ac.rca.bankManagement.v1.dto.requests.CreateTransfersDTO;
import rw.ac.rca.bankManagement.v1.services.TransferService;
import rw.ac.rca.bankManagement.v1.payload.ApiResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {

    private final TransferService transferService;

    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<ApiResponse> transferAmount(@Valid @RequestBody CreateTransfersDTO transferDTO) {
        try {
            transferService.transferAmount(transferDTO);
            return ResponseEntity.ok(new ApiResponse(true, "Amount transferred successfully!", null));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, e.getMessage(), null));
        }
    }
}
