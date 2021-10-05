package za.ac.nwu.account.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.account.domain.dto.AccountTypeDto;
import za.ac.nwu.account.domain.persistence.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {



//    AccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);


    @Query(value = "SELECT " +
            "       at" +
            "   FROM " +
            "       AccountType at" +
            "   WHERE at.mnemonic = :mnemonic ")
    AccountType getAccountTypeByMnemonic(String mnemonic);


    @Query(value = "SELECT new za.ac.nwu.account.domain.dto.AccountTypeDto(" +
            "       at.mnemonic," +
            "       at.accountTypeName," +
            "       at.creationDate )" +
            "   FROM " +
            "       AccountType at" +
            "   WHERE at.mnemonic = :mnemonic ")
    AccountTypeDto getAccountTypeByDtoMnemonic(String mnemonic);
}