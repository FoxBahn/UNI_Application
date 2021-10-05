package za.ac.nwu.account.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.account.domain.dto.AccountTransactionDto;
import za.ac.nwu.account.logic.flow.FetchAccountTransactionFlow;
import za.ac.nwu.account.translator.AccountTransactionTranslator;

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
        return accountTransactionTranslator.getAllAccountTransactions();
    }

    @Override
    public AccountTransactionDto getAccountTransactionsByMemberID(Integer memberID) {
        return accountTransactionTranslator.getAccountTransactionsByMemberIDNativeQuery(memberID);
    }
//            @Override
//    public List<AccountTransactionDto> getAllAccountTransactions() {
//        List<AccountTransactionDto> accountTypeDtos = new ArrayList<>();
//        accountTypeDtos.add(new AccountTransactionDto(new AccountType(113,"TESTCURRENCY","Test Currency", LocalDate.now(), 113, 900,  LocalDate.now()));
//        return accountTypeDtos;
//    }
}
