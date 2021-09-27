package za.ac.nwu.account.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.account.domain.persistence.AccountType;

public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

}