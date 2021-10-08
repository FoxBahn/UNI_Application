package za.ac.nwu.account.logic.flow;

import za.ac.nwu.account.domain.dto.AccountTransactionDto;

import java.util.List;

public interface FetchAccountTransactionFlow {
    List<AccountTransactionDto> getAllAccountTransactions();

    AccountTransactionDto getAccountTransactionByMemberID (Long memberID);

    AccountTransactionDto getAccountTransactionByID(Long transactionID);
}
