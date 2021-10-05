package za.ac.nwu.account.translator;


import za.ac.nwu.account.domain.dto.AccountTypeDto;
import za.ac.nwu.account.domain.persistence.AccountType;

import java.util.List;


public interface AccountTypeTranslator {

    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto create(AccountTypeDto accountType);

//    AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic);

    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);

    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);

    AccountType getAccountTypeDbEntityByMnemonic(String mnemonic);




}