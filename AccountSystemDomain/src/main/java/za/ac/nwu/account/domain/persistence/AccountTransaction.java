package za.ac.nwu.account.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

//import java.time.LocalDate;
@Entity
@Table(name = "Account_TRANSACTION",schema = "HR")
public class AccountTransaction implements Serializable {

    private static final long serialVersionUID = 243591207966341647L;

    private Long transactionID;
    private AccountType accountType;
    private Long memberID;
    private Long amount;


    public AccountTransaction(Long transactionID, AccountType accountType, Long memberID, Long amount) {
        this.transactionID = transactionID;
        this.accountType = accountType;
        this.memberID = memberID;
        this.amount = amount;
    }

    @Id
    @SequenceGenerator(name = "AccountType_ID_Seq", sequenceName = "AccountType_Seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AccountType_ID_Seq")


    @Column(name = "ACCOUNT_MILES_ID")
    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Long transactionId) {
        this.transactionID = transactionID;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    @Column(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType() {  return accountType; }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Column(name = "ACCOUNT_MEMBER_ID")
    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberId) {
        this.memberID = memberID;
    }

    @Column(name = "ACCOUNT_TRANSACTION_AMOUNT")
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(transactionID, that.transactionID) && Objects.equals(accountType, that.accountType) && Objects.equals(memberID, that.memberID) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionID, memberID, amount);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionID= " + transactionID +
                ", accountType= "  + accountType +
                ", memberID= " + memberID +
                ", amount= " + amount +
                '}' ;

    }
}
