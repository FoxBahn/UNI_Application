package za.ac.nwu.account.domain.persistence;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

//import java.time.LocalDate;
@Entity
@Table(name = "Account_Type",schema = "HR")
public class AccountType implements Serializable {

    private static final long serialVersionUID = 243591207966341647L;

    private Long accountTypeID;
    private Long mnemonic;
    private Long accountTypeName;
    private LocalDate creationDate;

    private Set<AccountTransaction> accountTransactions;

    public AccountType() {
    }

    public AccountType(Long accountTypeID, Long mnemonic, Long accountTypeName, LocalDate creationDate) {
        this.accountTypeID = accountTypeID;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;

    }


    @Id
    @SequenceGenerator(name = "ACCOUNTTYPE_ID_SEQ", sequenceName = "ACCOUNTYPE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNTTYPE_ID_SEQ")
    @Column(name = "ACCOUNT_TYPE_ID")
    public Long getAccountTypeID() {
        return accountTypeID;
    }


    @Column(name = "MNEMONIC")
    public Long getMnemonic() {
        return mnemonic;
    }


    @Column(name = "ACCOUNT_TYPE_NAME")
    public Long getAccountTypeName() {
        return accountTypeName;
    }


    @Column(name = "CREATION_DATE")
    public LocalDate getCreationDate() { return creationDate; }



    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountType", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions(){
        return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    public void setAccountTypeID(Long accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    public void setMnemonic(Long mnemonic) {
        this.mnemonic = mnemonic;
    }

    public void setAccountTypeName(Long accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public void setCreationDate(LocalDate creationDate) { this.creationDate = creationDate; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(accountTypeID, that.accountTypeID) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeID, mnemonic, accountTypeName, creationDate);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeID=" + accountTypeID +
                ", mnemonic=" + mnemonic + '\'' +
                ", accountTypeName=" + accountTypeName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
