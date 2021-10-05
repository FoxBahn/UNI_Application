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
        private Integer transactionID;
        private String accountTypeMnemonic;
        private Integer memberID;
        private Integer amount;
        private LocalDate transactionDate;

        public AccountTransactionDto() {
        }

        public AccountTransactionDto(Integer transactionID,String accountTypeMnemonic, Integer memberID, Integer amount, LocalDate transactionDate) {
            this.transactionID = transactionID;
            this.accountTypeMnemonic = accountTypeMnemonic;
            this.memberID = memberID;
            this.amount = amount;
            this.transactionDate = transactionDate;
        }

        public AccountTransactionDto(AccountTransaction accountTransaction) {
            this.transactionID = accountTransaction.getTransactionID();
            this.accountTypeMnemonic = accountTransaction.getAccountType().getMnemonic();
            this.memberID = accountTransaction.getMemberID();
            this.amount = accountTransaction.getAmount();
            this.transactionDate = accountTransaction.getTransactionDate();
        }

    @JsonIgnore
    public AccountTransaction buildAccountTransaction(AccountType accountType) {
        return new AccountTransaction(this.getTransactionID(), accountType, this.getMemberID(), this.getAmount(), this.getTransactionDate());
    }


    @ApiModelProperty(position = 3,
            value = "AccountTransaction ID",
            name = "TransactionID",
            notes = "Uniquely identifies the account transaction",
            dataType = "java.lang.Integer",
            example = "1",
            required = true)
    public Integer getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Integer transactionID) {
        this.transactionID = transactionID;
    }

    @ApiModelProperty(position = 2,
            value = "AccountType Mnemonic",
            name = "AccountTypeMnemonic",
            notes = "States the AccountType Mnemonic linked to the transaction",
            dataType = "java.lang.String",
            example = "BUCKS",
            required = true)
    public String getAccountTypeMnemonic() {
        return accountTypeMnemonic;
    }

    public void setAccountTypeMnemonic(String accountTypeMnemonic) {
        this.accountTypeMnemonic = accountTypeMnemonic;
    }

    @ApiModelProperty(position = 3,
            value = "AccountTransaction MemberID",
            name = "MemberID",
            notes = "Uniquely identifies the owner of the account transaction",
            dataType = "java.lang.Integer",
            example = "69",
            required = true)
    public Integer getMemberID() {
        return memberID;
    }

    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }

    @ApiModelProperty(position = 4,
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

    @ApiModelProperty(position = 5,
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
        return Objects.equals(transactionID, that.transactionID) && Objects.equals(accountTypeMnemonic, that.accountTypeMnemonic) && Objects.equals(memberID, that.memberID) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionID, accountTypeMnemonic, memberID, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "transactionID=" + transactionID + '\'' +
                ", accountTypeMnemonic='" + accountTypeMnemonic + '\'' +
                ", memberID=" + memberID + '\'' +
                ", amount=" + amount + '\'' +
                ", transactionDate=" + transactionDate +
                '}';
    }
}