package za.ac.nwu.account.logic.flow.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.account.domain.dto.AccountTransactionDto;
import za.ac.nwu.account.domain.persistence.AccountTransaction;
import za.ac.nwu.account.domain.persistence.AccountType;
import za.ac.nwu.account.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.account.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.account.translator.AccountTransactionTranslator;

import java.time.LocalDate;

@Transactional
@Component
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;
    private final FetchAccountTypeFlow fetchAccountTypeFlow;

    public CreateAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator,
                                            FetchAccountTypeFlow fetchAccountTypeFlow) {
        this.accountTransactionTranslator = accountTransactionTranslator;
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
    }

    @Override
    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto) {
        accountTransactionDto.setTransactionID(null); // this is incase it was populated before running

        AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(
                accountTransactionDto.getAccountTypeMnemonic());
        AccountTransaction accountTransaction = accountTransactionDto.buildAccountTransaction(accountType);

        AccountTransaction createdAccountTransaction = accountTransactionTranslator.save(accountTransaction);

        if(null == accountTransactionDto.getTransactionDate()){
            accountTransaction.setTransactionDate(LocalDate.now());
        }
        return new AccountTransactionDto(createdAccountTransaction);
    }
}
