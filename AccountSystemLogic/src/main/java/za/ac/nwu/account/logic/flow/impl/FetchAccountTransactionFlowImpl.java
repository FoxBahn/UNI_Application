package za.ac.nwu.account.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.account.domain.dto.AccountTransactionDto;
import za.ac.nwu.account.domain.persistence.AccountTransaction;
import za.ac.nwu.account.logic.flow.FetchAccountTransactionFlow;
import za.ac.nwu.account.translator.AccountTransactionTranslator;

import java.util.ArrayList;
import java.util.List;


@Transactional
@Component

public class FetchAccountTransactionFlowImpl implements FetchAccountTransactionFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;

    @Autowired
    public FetchAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator) {
        this.accountTransactionTranslator = accountTransactionTranslator;
    }

    @Override
    public List<AccountTransactionDto> getAllAccountTransactions() {
        List<AccountTransactionDto> accountTransactionDtos = new ArrayList<>();
        for(AccountTransaction accountTransaction: accountTransactionTranslator.getAllAccountTransactions()){
            accountTransactionDtos.add(new AccountTransactionDto(accountTransaction));
        }
        return accountTransactionDtos;
    }


    @Override
    public AccountTransactionDto getAccountTransactionsByID(Long transactionID) {
        AccountTransaction accountTransaction = accountTransactionTranslator.getAccountTransactionByPk(transactionID);
        return null != accountTransaction ? new AccountTransactionDto(accountTransaction) : null;
    }
//            @Override
//    public List<AccountTransactionDto> getAllAccountTransactions() {
//        List<AccountTransactionDto> accountTypeDtos = new ArrayList<>();
//        accountTypeDtos.add(new AccountTransactionDto(new AccountType(113,"TESTCURRENCY","Test Currency", LocalDate.now(), 113, 900,  LocalDate.now()));
//        return accountTypeDtos;
//    }
}
