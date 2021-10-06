package za.ac.nwu.account.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
    public AccountTransaction save(AccountTransaction accountTransaction) {
        try {
            return accountTransactionRepository.save(accountTransaction);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the DB",e);
        }
    }

    @Override
    public List<AccountTransaction> getAllAccountTransactions() {
        List<AccountTransaction> accountTransactions;
        try {
                accountTransactions= new ArrayList<>(accountTransactionRepository.findAll());
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
        return accountTransactions;
    }

    public AccountTransaction getAccountTransactionByMemberID(Long memberID){
        try{
            return accountTransactionRepository.getAccountTransactionByMemberID(memberID);
        } catch (Exception e) {

            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public AccountTransaction getAccountTransactionByPk(Long transactionID){
        try {
            return accountTransactionRepository.findById(transactionID).orElse(null);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }

//    @Override
//    public AccountTransaction getAccountTransactionByPk(Long transactionID){
//        try {
//            return accountTransactionRepository.getAccountTransactionByPk(transactionID);
//        }catch (Exception e){
//            throw new RuntimeException("Unable to read from the DB", e);
//        }


   }


}
