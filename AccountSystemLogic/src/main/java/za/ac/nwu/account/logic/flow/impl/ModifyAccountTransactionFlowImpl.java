package za.ac.nwu.account.logic.flow.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.account.domain.dto.AccountTransactionDto;
import za.ac.nwu.account.domain.persistence.AccountTransaction;
import za.ac.nwu.account.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.account.logic.flow.FetchAccountTransactionFlow;
import za.ac.nwu.account.logic.flow.ModifyAccountTransactionFlow;
import za.ac.nwu.account.translator.AccountTransactionTranslator;

@Transactional
@Component
public class ModifyAccountTransactionFlowImpl implements ModifyAccountTransactionFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;
    private final FetchAccountTransactionFlow fetchAccountTypeFlow;
    private final CreateAccountTransactionFlow createAccountTransactionFlow;


    public ModifyAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator, FetchAccountTransactionFlow fetchAccountTypeFlow, CreateAccountTransactionFlow createAccountTransactionFlow) {
        this.accountTransactionTranslator = accountTransactionTranslator;
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
        this.createAccountTransactionFlow = createAccountTransactionFlow;
    }


    @Override
    public AccountTransactionDto update(Long transactionID, Long newAccountTransactionAmount) {
        //Get
        AccountTransaction accountTransaction = accountTransactionTranslator.getAccountTransactionByPk(transactionID);
        return null != accountTransaction ? new AccountTransactionDto(accountTransaction) : null;

        //create
//        AccountTransactionDto accountTransactionDto = createAccountTransactionFlow.create(accountTransactionDto);
//        AccountType accountType = fetchAccountTypeFlow.getAccountTransactionByID(transactionID);
//        AccountTransaction accountTransaction = accountTransactionDto.buildAccountTransaction(accountType);
//
//        AccountTransaction createdAccountTransaction = accountTransactionTranslator.save(accountTransaction);
//
//        if(null == accountTransactionDto.getTransactionDate()){
//            accountTransaction.setTransactionDate(LocalDate.now());
//        }
//        return new AccountTransactionDto(createdAccountTransaction);

    }

}
