package za.ac.nwu.account.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

//import java.time.LocalDate;
@Entity
@Table(name = "Account_Type",schema = "HR")
public class AccountTransaction implements Serializable {

    private static final long serialVersionUID = 243591207966341647L;

    private Long transactionId;
    private AccountType accountType;
    private Long memberId;
    private Long amount;

    public AccountTransaction() {
    }

    public AccountTransaction(Long transactionId, AccountType accountType, Long memberId, Long amount) {
        this.transactionId = transactionId;
        this.accountType = accountType;
        this.memberId = memberId;
        this.amount = amount;
    }

    @Id
    @SequenceGenerator(name = "AccountType_ID_Seq", sequenceName = "AccountType_Seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AccountType_ID_Seq")
    @Column(name = "ACCOUNT_MILES_ID")
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
    @Column(name = "ACCOUNT_MEMBER_ID")
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Column(name = "ACCOUNT_MILES_AMOUNT")
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
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountType, that.accountType) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountType, memberId, amount);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionId= " + transactionId +
                ", accountType= "  + accountType +
                ", memberId= " + memberId +
                ", amount= " + amount +
                '}';
    }
}
