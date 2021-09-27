package za.ac.nwu.account.logic.flow;

import za.ac.nwu.account.domain.dto.AccountTypeDto;

import java.util.List;

public interface FetchAccountTypeFlow {
    List<AccountTypeDto> getAllAccountTypes();
}