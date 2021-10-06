package za.ac.nwu.account.logic.flow;

import za.ac.nwu.account.domain.dto.AccountTransactionDto;

public interface ModifyAccountTransactionFlow {

    AccountTransactionDto updateAccountTransaction(Long transactionID, Long newAccountTransactionAmount);

}
