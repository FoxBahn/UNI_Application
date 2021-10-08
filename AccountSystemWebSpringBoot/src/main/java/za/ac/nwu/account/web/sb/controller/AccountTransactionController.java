package za.ac.nwu.account.web.sb.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.account.domain.dto.AccountTransactionDto;
import za.ac.nwu.account.domain.service.GeneralResponse;
import za.ac.nwu.account.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.account.logic.flow.FetchAccountTransactionFlow;
import za.ac.nwu.account.logic.flow.ModifyAccountTransactionFlow;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("account-transaction")
public class AccountTransactionController {

    private final CreateAccountTransactionFlow createAccountTransactionFlow;
    private final FetchAccountTransactionFlow fetchAccountTransactionFlow;
    private final ModifyAccountTransactionFlow modifyAccountTransactionFlow;

    @Autowired
    public AccountTransactionController(CreateAccountTransactionFlow createAccountTransactionFlow,
                                        FetchAccountTransactionFlow fetchAccountTransactionFlow,
                                        ModifyAccountTransactionFlow modifyAccountTransactionFlow) {

        this.createAccountTransactionFlow = createAccountTransactionFlow;
        this.fetchAccountTransactionFlow = fetchAccountTransactionFlow;
        this.modifyAccountTransactionFlow = modifyAccountTransactionFlow;
    }
////////////////////////////post new and create
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
////////////////get all
    @GetMapping("/all")
    @ApiOperation(value = "Gets all the made Account transactions.", notes = "Returns a list of account transactions")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account transaction returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class),})

    public ResponseEntity<GeneralResponse<List<AccountTransactionDto>>> getAll(){
        List<AccountTransactionDto> AccountTransactions = fetchAccountTransactionFlow.getAllAccountTransactions();
        GeneralResponse<List<AccountTransactionDto>> response = new GeneralResponse<>(true, AccountTransactions);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

///////////////////////////Get transaction ID
    @GetMapping("{transactionID}")
    @ApiOperation(value = "Gets all the specific Account transaction.", notes = "Returns a list of account transactions")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account transaction found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Recource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class),})

    public ResponseEntity<GeneralResponse<AccountTransactionDto>> getAccountTransaction(
            @ApiParam(value= "The Transaction id that is used to uniquely identify it.",
                    example = "10",
                    name ="transactionID",
                    required = true)
            @PathVariable("transactionID") final Long transactionID) {

        AccountTransactionDto AccountTransaction = fetchAccountTransactionFlow.getAccountTransactionByID(transactionID);

        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, AccountTransaction);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
/////////////////////////GEt memberID
    @GetMapping("{memberID}") //can't fetch only one memeber id so added +mneumonic to specify the type of account
    @ApiOperation(value = "Gets the specific Account transactions linked to a single member.", notes = "Returns a list of transactions for a single member")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account transaction Member Found found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Recource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class),})

    public ResponseEntity<GeneralResponse<AccountTransactionDto>> getAccountTransactionMember(
            @ApiParam(value= "The Member id that is linked to the transaction.",
                    example = "69",
                    name ="memberID",
                    required = true)
            @PathVariable("memberID") final Long memberID) {

        AccountTransactionDto AccountTransaction = fetchAccountTransactionFlow.getAccountTransactionByMemberID(memberID);

        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, AccountTransaction);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }
//////////////////////////////////////Put (Update)
        @PutMapping("{transactionID}")
        @ApiOperation(value = "Updates the specific Account transaction amount of units.", notes = "Updates the accountTransaction amount according to the given transaction ID")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Account transaction Updates", response = GeneralResponse.class),
                @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
                @ApiResponse(code = 404, message = "Recource not found", response = GeneralResponse.class),
                @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class),})

        public ResponseEntity<GeneralResponse<AccountTransactionDto>> updateAccountTransaction(
        @ApiParam(value= "The Transaction id that is used to uniquely identify it.",
                example = "10",
                name ="transactionID",
                required = true)
        @PathVariable("transactionID") final Long transactionID,

        @ApiParam(value = "The new Account Transaction Amount that the member has and should be shown on their account",
                    name = "newAccountTransactionAmount",
                    required = true)
        @RequestParam(value = "newAccountTransactionAmount") final Long newAccountTransactionAmount,

        @ApiParam(value = "The optional new date the transaction can be updated with in ISO date format (yyyy-mm-dd)\r\n if empty/null the date will not be altered.",
                    name = "newCreationDate")
                @RequestParam(value = "newCreationDate", required = false)
                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate newCreationDate)
            {

            AccountTransactionDto AccountTransaction = modifyAccountTransactionFlow.update(transactionID, newAccountTransactionAmount, newCreationDate);

            GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, AccountTransaction);

            return new ResponseEntity<>(response, HttpStatus.OK);
        }


        /////Delete
//        @DeleteMapping("{transactionID}")
//        @ApiOperation(value = "Deletes the specific Account transaction.", notes = "Deletes the accountTransaction according to the given transaction ID")
//        @ApiResponses(value = {
//                @ApiResponse(code = 200, message = "Account transaction Deleted", response = GeneralResponse.class),
//                @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//                @ApiResponse(code = 404, message = "Recource not found", response = GeneralResponse.class),
//                @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
//
//        public ResponseEntity<GeneralResponse<AccountTransactionDto>> getAccountTransaction(
//        @ApiParam(value= "The Transaction id that is used to uniquely identify it.",
//                example = "10",
//                name ="transactionID",
//                required = true)
//        @PathVariable("transactionID") final Long transactionID) {
//
//            AccountTransactionDto AccountTransaction = fetchAccountTransactionFlow.getAccountTransactionByID(transactionID);
//
//            GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, AccountTransaction);
//
//            return new ResponseEntity<>(response, HttpStatus.OK);
//    }

    //TODO: *MUST HAVE* I can insert account trnasactions, i have added controller for modify
    // i cannot delete and view or update Mappings of account transactions
}
