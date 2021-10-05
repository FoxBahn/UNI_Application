package za.ac.nwu.account.logic.flow.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.account.domain.dto.AccountTransactionDto;
import za.ac.nwu.account.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.account.translator.AccountTransactionTranslator;

import java.time.LocalDate;

@Transactional
@Component("createAccountTransactionFlowName")
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;
    public CreateAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator) {
        this.accountTransactionTranslator = accountTransactionTranslator;

    }

    @Override
    public AccountTransactionDto create(AccountTransactionDto accountTransaction) {
        if(null == accountTransaction.getTransactionDate()){
            accountTransaction.setTransactionDate(LocalDate.now());
        }
        return accountTransactionTranslator.create(accountTransaction);
    }
}
