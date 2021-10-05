package za.ac.nwu.account.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.account.domain.persistence.AccountTransaction;
import za.ac.nwu.account.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@ApiModel(value = "AccountTransaction", description = "A DTO that Represents the AccountTransaction")
public class AccountTransactionDto implements Serializable {

        private static final long serialVersionUID = 8570305150411437559L;

        private AccountType accountType;
        private Integer memberID;
        private Integer amount;
        private LocalDate transactionDate;

        public AccountTransactionDto() {
        }

        public AccountTransactionDto(AccountType accountType, Integer memberID, Integer amount, LocalDate transactionDate) {
            this.accountType = accountType;
            this.memberID = memberID;
            this.amount = amount;
            this.transactionDate = transactionDate;
        }

        public AccountTransactionDto(AccountTransaction accountTransactions) {
            this.setAccountType(accountTransactions.getAccountType());
            this.setMemberID(accountTransactions.getMemberID());
            this.setAmount(accountTransactions.getAmount());
            this.setTransactionDate(accountTransactions.getTransactionDate());
        }

        @ApiModelProperty(position = 1,
                value = "AccountType ID",
                name = "AccountTypeID",
                notes = "Uniquely identifies the AccountType linked to the transaction",
                dataType = "AccountType",
                example = "Account_Type_ID",
                required = true)
        public AccountType getAccountType() {
            return accountType;
        }

        public void setAccountType(AccountType accountType) {
            this.accountType = accountType;
        }

        @ApiModelProperty(position = 2,
                value = "AccountTransaction MemberID",
                name = "MemberID",
                notes = "Uniquely identifies the owner of the account transaction",
                dataType = "java.lang.Integer",
                example = "MEMBER_ID",
                required = true)
        public Integer getMemberID() {
            return memberID;
        }

        public void setMemberID(Integer memberID) {
            this.memberID = memberID;
        }

        @ApiModelProperty(position = 3,
                value = "AccountTransaction Amount",
                name = "TransactionAmount",
                notes = "This is the amount of units that the account type contains",
                dataType = "java.lang.Integer",
                example = "250",
                required = true)
        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        @ApiModelProperty(position = 4,
                value = "AccountTransaction Creation Date",
                name = "CreationDate",
                notes = "This is the date on which the AccountTransaction was created",
                dataType = "java.lang.LocalDate",
                example = "2020-01-01",
                allowEmptyValue = true)
        public LocalDate getTransactionDate() {
            return transactionDate;
        }

        public void setTransactionDate(LocalDate transactionDate) {
            this.transactionDate = transactionDate;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(accountType, that.accountType) && Objects.equals(memberID, that.memberID) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }


    @JsonIgnore
    public AccountTransaction getAccountTransaction() {
        return new AccountTransaction(getAccountType(), getMemberID(), getAmount(), getTransactionDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountType, memberID, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "accountType=" + accountType + '\'' +
                ", memberID=" + memberID + '\'' +
                ", amount=" + amount + '\'' +
                ", transactionDate=" + transactionDate + '\'' +
                '}';
    }
}