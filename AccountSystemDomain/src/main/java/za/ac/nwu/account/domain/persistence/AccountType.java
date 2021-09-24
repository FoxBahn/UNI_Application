package za.ac.nwu.account.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

//import java.time.LocalDate;
@Entity
@Table(name = "Account_Type",schema = "HR")
public class AccountType implements Serializable {

    private Long accountTypeID;
    private Long mnemonic;
    private Long accountTypeName;

    private Set<AccountTransaction> accountTransactions;

    public AccountType() {
    }

    public AccountType(Long accountTypeID, Long mnemonic, Long accountTypeName) {
        this.accountTypeID = accountTypeID;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
    }

    private static final long serialVersionUID = 243591207966341647L;
    @Id
    @SequenceGenerator(name = "AccountType_ID_Seq", sequenceName = "AccountType_Seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AccountType_ID_Seq")

    @Column(name = "ACCOUNT_TYPE_ID")
    public Long getAccountTypeID() {
        return accountTypeID;
    }

    public void setAccountTypeID(Long accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    @Column(name = "MNEMONIC")
    public Long getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(Long mnemonic) {
        this.mnemonic = mnemonic;
    }

    @Column(name = "ACCOUNT_TYPE_NAME")
    public Long getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(Long accountTypeName) {
        this.accountTypeName = accountTypeName;
    }


    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountType", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions(){
        return accountTransactions;
    }
    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(accountTypeID, that.accountTypeID) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeID, mnemonic, accountTypeName);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeID= " + accountTypeID +
                ", mnemonic= " + mnemonic +
                ", accountTypeName= " + accountTypeName +
                '}';
    }
}
