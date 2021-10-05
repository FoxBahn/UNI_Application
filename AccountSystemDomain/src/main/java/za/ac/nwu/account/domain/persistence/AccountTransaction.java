package za.ac.nwu.account.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

//import java.time.LocalDate;
@Entity
@Table(name = "ACCOUNT_TRANSACTION",schema = "HR")
public class AccountTransaction implements Serializable {

    private static final long serialVersionUID = 243591207966341647L;

    private Integer transactionID;
    private AccountType accountType;
    private Integer memberID;
    private Integer amount;
    private LocalDate transactionDate;


    public AccountTransaction(Integer transactionID, AccountType accountType, Integer memberID, Integer amount, LocalDate transactionDate) {
        this.transactionID = transactionID;
        this.accountType = accountType;
        this.memberID = memberID;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }


    public AccountTransaction(AccountType accountType, Integer memberID, Integer amount, LocalDate transactionDate) {
        this.accountType = accountType;
        this.memberID = memberID;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransaction() {

    }

    @Id
    @SequenceGenerator(name = "ACCOUNT_TRANSACTION_SEQ", sequenceName = "ACCOUNT_TRANSACTION_SEQNAME", allocationSize = 1)
    @GeneratedValue(strategy =GenerationType.SEQUENCE, generator = "ACCOUNT_TRANSACTION_SEQ")
    @Column(name = "ACCOUNT_TRANSACTION_ID")
    public Integer getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Integer transactionID) {
        this.transactionID = transactionID;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType() {  return accountType; }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Column(name = "ACCOUNT_MEMBER_ID")
    public Integer getMemberID() {
        return memberID;
    }

    public void setMemberID(Integer memberId) {
        this.memberID = memberID;
    }

    @Column(name = "ACCOUNT_TRANSACTION_AMOUNT")
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Column(name = "ACCOUNT_TRANSACTION_DATE")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate amount) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(transactionID, that.transactionID) && Objects.equals(accountType, that.accountType) && Objects.equals(memberID, that.memberID) &&  Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionID, accountType, memberID, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionID= " + transactionID +'\'' +
                ", accountType= "  + accountType +'\'' +
                ", memberID= " + memberID +'\'' +
                ", amount= " + amount +'\'' +
                ", transactionDate= " + transactionDate +
                '}' ;

    }
}
