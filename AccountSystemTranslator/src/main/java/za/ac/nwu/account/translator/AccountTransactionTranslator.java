package za.ac.nwu.account.translator;

import za.ac.nwu.account.domain.dto.AccountTransactionDto;

import java.util.List;

public interface AccountTransactionTranslator {
    List<AccountTransactionDto> getAllAccountTransactions();

    AccountTransactionDto create(AccountTransactionDto accountTransaction);

    AccountTransactionDto getAccountTransactionsByMemberIDNativeQuery(Integer memberID);


}
