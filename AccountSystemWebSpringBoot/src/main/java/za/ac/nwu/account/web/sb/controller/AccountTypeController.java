package za.ac.nwu.account.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.account.domain.dto.AccountTypeDto;
import za.ac.nwu.account.domain.service.GeneralResponse;
import za.ac.nwu.account.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.account.logic.flow.FetchAccountTypeFlow;

import java.util.List;


@RestController
@RequestMapping("account-type")
public class AccountTypeController {

    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final CreateAccountTypeFlow createAccountTypeFlow;

    @Autowired
    public AccountTypeController(FetchAccountTypeFlow fetchAccountTypeFlow,
                                 @Qualifier("createAccountTypeFlowName") CreateAccountTypeFlow createAccountTypeFlow){
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
        this.createAccountTypeFlow = createAccountTypeFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account types.", notes = "Returns a list of account types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<List<AccountTypeDto>>> getAll(){
        List<AccountTypeDto> accountTypes = fetchAccountTypeFlow.getAllAccountTypes();
        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse<>(true, accountTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("")
    @ApiOperation(value = "Creates a new AccountType.", notes = "Creates a new AccountType in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountType was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTypeDto>> create(
            @ApiParam(value = "Request body to create a new AccountType.",
            required = true)
            @RequestBody AccountTypeDto accountType) {
         AccountTypeDto accountTypeResponse = createAccountTypeFlow.create(accountType);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountTypeResponse);
        return new ResponseEntity(response, HttpStatus.CREATED);


    }

    @GetMapping("/{mnemonic}")
    @ApiOperation(value = "Gets all the specific Account type.", notes = "Returns a list of account types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account transaction found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Recource found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<AccountTypeDto>> getAccountType(
            @ApiParam(value= "The Mnemonic that is used to uniquely identifies it.",
                    example = "MILES",
                    name ="mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic) {
        AccountTypeDto accountType = fetchAccountTypeFlow.getAccountTypeByMnemonic(mnemonic);

        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountType);
        return new ResponseEntity<>(response, HttpStatus.OK);
        //TODO: *optional* Add insert and or update  Mappings of account types Mappings
    }
}
