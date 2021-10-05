package za.ac.nwu.account.logic.flow;

import za.ac.nwu.account.domain.dto.AccountTransactionDto;

import java.util.List;

public interface FetchAccountTransactionFlow {
    List<AccountTransactionDto> getAllAccountTransactions();

    AccountTransactionDto getAccountTransactionsByID(Long transactionID);
}
