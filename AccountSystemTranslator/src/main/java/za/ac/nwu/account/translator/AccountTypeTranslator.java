package za.ac.nwu.account.translator;


import za.ac.nwu.account.domain.dto.AccountTypeDto;

import java.util.List;


public interface AccountTypeTranslator {
    List<AccountTypeDto> getAllAccountTypes();
}