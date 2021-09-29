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


@Entity
@Table(name = "Account_Type",schema = "HR")
public class   AccountType implements Serializable {

    private static final long serialVersionUID = 243591207966341647L;
    private Long accountTypeID;
    private String mnemonic;
    private String accountTypeName;
    private LocalDate creationDate;

    private Set<AccountTransaction> accountTransactions;

    public AccountType() {

    }

    public AccountType(Long accountTypeID, String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.accountTypeID = accountTypeID;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }
    public AccountType(String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }

    @Id
    @SequenceGenerator(name = "AccountType_ID_Seq", sequenceName = "AccountType_Seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AccountType_ID_Seq")

    @Column(name = "ACCOUNT_TYPE_ID")
    public long getAccountTypeID() {
        return accountTypeID;
    }

    public void setAccountTypeID(Long accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    @Column(name = "MNEMONIC")
    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @Column(name = "ACCOUNT_TYPE_NAME")
    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @Column(name = "CREATION_DATE")
    public LocalDate getCreationDate() { return creationDate; }

    public void setCreationDate(LocalDate creationDate) { this.creationDate = creationDate; }


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
        return Objects.equals(accountTypeID, that.accountTypeID) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(creationDate, that.creationDate) && Objects.equals(accountTransactions, that.accountTransactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeID, mnemonic, accountTypeName, creationDate, accountTransactions);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeID=" + accountTypeID +
                ", mnemonic=" + mnemonic +
                ", accountTypeName=" + accountTypeName +
                ", creationDate=" + creationDate +
                ", accountTransactions=" + accountTransactions +
                '}';
    }
}
