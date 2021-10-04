package za.ac.nwu.account.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

//import java.time.LocalDate;
@Entity
@Table(name = "ACCOUNT_TYPE",schema = "HR")
public class AccountType implements Serializable {

    private static final long serialVersionUID = 243591207966341647L;

    private Integer accountTypeID;
    private String mnemonic;
    private String accountTypeName;
    private LocalDate creationDate;

    private Set<AccountTransaction> accountTransactions;


    public AccountType(Integer accountTypeID, String mnemonic, String accountTypeName, LocalDate creationDate) {
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

    public AccountType() {
    }


    @Id
    @Column(name = "ACCOUNT_TYPE_ID")
    @SequenceGenerator(name = "ACCOUNT_TYPE_SEQ", sequenceName = "ACCOUNT_TYPE_SEQNAME", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_TYPE_SEQ")
    public Integer getAccountTypeID() {
        return accountTypeID;
    }


    @Column(name = "MNEMONIC")
    public String getMnemonic() {
        return mnemonic;
    }


    @Column(name = "ACCOUNT_TYPE_NAME")
    public String getAccountTypeName() {
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

    public void setAccountTypeID(Integer accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public void setAccountTypeName(String accountTypeName) {
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
