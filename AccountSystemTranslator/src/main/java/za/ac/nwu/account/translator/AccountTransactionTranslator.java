package za.ac.nwu.account.translator;

import za.ac.nwu.account.domain.dto.AccountTransactionDto;
import za.ac.nwu.account.domain.persistence.AccountTransaction;

import java.util.List;

public interface AccountTransactionTranslator {

    List<AccountTransaction> getAllAccountTransactions();

    AccountTransaction save(AccountTransaction accountTransaction);

    AccountTransaction getAccountTransactionByPk(Long transactionID);

    AccountTransaction getAccountTransactionByMemberID(Long memberID);

   AccountTransactionDto updateAccountTransaction(Long transactionID, Long newAccountTransactionAmount);

//    AccountTransactionDto save(AccountTransactionDto accountTransactionDto);
}
