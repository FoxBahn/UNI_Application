package za.ac.nwu.account.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.account.domain.dto.AccountTypeDto;
import za.ac.nwu.account.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.account.translator.AccountTypeTranslator;

import java.util.List;


@Transactional
@Component
public class FetchAccountTypeFlowImpl implements FetchAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator){
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes() {
       return accountTypeTranslator.getAllAccountTypes();
    }

//        @Override
//    public List<AccountTypeDto> getAllAccountTypes1() {
//        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
//        accountTypeDtos.add(new AccountTypeDto("PLAYS", "Plays", LocalDate.now()));
//        return accountTypeDtos;
//    }


}