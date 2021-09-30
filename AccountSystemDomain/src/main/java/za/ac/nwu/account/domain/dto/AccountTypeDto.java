package za.ac.nwu.account.domain.dto;

import za.ac.nwu.account.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class AccountTypeDto implements Serializable {

    private static final long serialVersionUID = -7579560883254875184L;

    private Long mnemonic;
    private Long accountTypeName;
    private LocalDate creationDate;

    public AccountTypeDto(){
    }

    public AccountTypeDto(Long mnemonic, Long accountTypeName, LocalDate creationDate) {
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }

    public AccountTypeDto(AccountType accountType){
        this.setMnemonic(accountType.getMnemonic());
        this.setAccountTypeName(accountType.getAccountTypeName());
        this.setCreationDate(accountType.getCreationDate());
    }



    public Long getMnemonic() {return mnemonic;}

    public void setMnemonic(Long mnemonic) {this.mnemonic = mnemonic;}

    public Long getAccountTypeName() {return accountTypeName;}

    public void setAccountTypeName(Long accountTypeName) {this.accountTypeName = accountTypeName;}

    public LocalDate getCreationDate() {return creationDate;}

    public void setCreationDate(LocalDate creationDate) {this.creationDate = creationDate;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTypeDto that = (AccountTypeDto) o;
        return Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mnemonic, accountTypeName, creationDate);
    }

    @Override
    public String toString() {
        return "AccountTypeDto{" +
                "mnemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }

}
