package za.ac.nwu.account.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.account.domain.persistence.AccountTransaction;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {
//  TODO: add to this class select query to view information by member id and seperate one for transaction id

//
//    @Query(value = "SELECT " +
//            "       atr" +
//            "       FROM "+
//            "       AccountTransaction atr " +
//            "WHERE atr.memeberID = :memeberID ", nativeQuery = true)
//    AccountTransaction getAccountTransactionsByMemberIDNativeQuery(Integer memberID);
}
