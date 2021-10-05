package za.ac.nwu.account.web.sb.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.account.domain.dto.AccountTransactionDto;
import za.ac.nwu.account.domain.service.GeneralResponse;
import za.ac.nwu.account.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.account.logic.flow.FetchAccountTransactionFlow;

import java.util.List;

@RestController
@RequestMapping("account-transaction")
public class AccountTransactionController {

    private final CreateAccountTransactionFlow createAccountTransactionFlow;
    private final FetchAccountTransactionFlow fetchAccountTransactionFlow;

    @Autowired
    public AccountTransactionController(CreateAccountTransactionFlow createAccountTransactionFlow,
                                        FetchAccountTransactionFlow fetchAccountTransactionFlow) {

        this.createAccountTransactionFlow = createAccountTransactionFlow;
        this.fetchAccountTransactionFlow = fetchAccountTransactionFlow;
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new AccountTransaction.", notes = "Creates a new AccountTransaction in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The Accountransaction was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> create(
            @ApiParam(value = "Request body to create a new AccountTransaction.",
                    required = true)
            @RequestBody AccountTransactionDto AccountTransaction) {
        AccountTransactionDto AccountTransactionResponse = createAccountTransactionFlow.create(AccountTransaction);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, AccountTransactionResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the made Account transactions.", notes = "Returns a list of account transactions")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account transaction returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<List<AccountTransactionDto>>> getAll(){
        List<AccountTransactionDto> AccountTransactions = fetchAccountTransactionFlow.getAllAccountTransactions();
        GeneralResponse<List<AccountTransactionDto>> response = new GeneralResponse<>(true, AccountTransactions);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/{transactionID}")
    @ApiOperation(value = "Gets all the specific Account transaction.", notes = "Returns a list of account transactions")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account transaction found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Recource found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<AccountTransactionDto>> getAccountTransaction(
            @ApiParam(value= "The Transaction id that is used to uniquely identify it.",
                    example = "1245",
                    name ="transactionID",
                    required = true)
            @PathVariable("transactionID") final Long transactionID) {

        AccountTransactionDto AccountTransaction = fetchAccountTransactionFlow.getAccountTransactionsByID(transactionID);

        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, AccountTransaction);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //TODO: *MUST HAVE* Add insert and or update Mappings of account transactions
}
