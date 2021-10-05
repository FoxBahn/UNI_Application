package za.ac.nwu.account.logic.flow;


import za.ac.nwu.account.domain.dto.AccountTypeDto;

public interface CreateAccountTypeFlow {

    AccountTypeDto create(AccountTypeDto accountType);
}
