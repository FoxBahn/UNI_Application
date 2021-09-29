package za.ac.nwu.account.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.account.domain.persistence.AccountType;


@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {
}