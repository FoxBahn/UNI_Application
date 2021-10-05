package za.ac.nwu.account.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.account.domain.dto.AccountTransactionDto;
import za.ac.nwu.account.domain.persistence.AccountTransaction;
import za.ac.nwu.account.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.account.translator.AccountTransactionTranslator;

import java.util.ArrayList;
import java.util.List;


@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {

   private AccountTransactionRepository accountTransactionRepository;

   @Autowired
   public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
   }

    @Override
    public List<AccountTransactionDto> getAllAccountTransactions() {
        List<AccountTransactionDto> accounttransactionDtos = new ArrayList<>();
        try {
            for (AccountTransaction accountTransaction : accountTransactionRepository.findAll()) {
                accounttransactionDtos.add(new AccountTransactionDto(accountTransaction));
            }
        } catch (Exception e) {

            throw new RuntimeException("Unable to read from the DB", e);
        }
        return accounttransactionDtos;
    }

    public AccountTransactionDto getAccountTransactionsByMemberIDNativeQuery(Integer memberID){
        try {
            AccountTransaction accountTransaction = accountTransactionRepository.getAccountTransactionsByMemberIDNativeQuery(memberID);
            return new AccountTransactionDto(accountTransaction);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB",e);
        }
    }

    @Override
    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto) {
        try {
            AccountTransaction accountTransaction= accountTransactionRepository.save(accountTransactionDto.getAccountTransaction());
            return new AccountTransactionDto(accountTransaction);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the DB",e);
        }
    }
}
