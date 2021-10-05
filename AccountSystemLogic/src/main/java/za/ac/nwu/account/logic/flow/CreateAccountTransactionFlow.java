package za.ac.nwu.account.logic.flow;


import za.ac.nwu.account.domain.dto.AccountTransactionDto;

public interface CreateAccountTransactionFlow {

    AccountTransactionDto create(AccountTransactionDto accountTransaction);
}
