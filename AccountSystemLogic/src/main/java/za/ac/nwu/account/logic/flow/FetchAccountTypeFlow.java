package za.ac.nwu.account.logic.flow;

import za.ac.nwu.account.domain.dto.AccountTypeDto;
import za.ac.nwu.account.domain.persistence.AccountType;

import java.util.List;

public interface FetchAccountTypeFlow {

    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);

    AccountType getAccountTypeDbEntityByMnemonic(String accountTypeMnemonic);
}