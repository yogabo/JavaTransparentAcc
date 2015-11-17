package com.springapp.mvc.View;

import java.util.Date;

/**
 * Created by sytensky on 15/11/15.
 */
public class TransAccItem {

    private String accNumber;
    private String accBankCode;
    private Date transparencyFrom;
    private Date transparencyTo;
    private Date publicationTo;
    private Date actualizationDate;
    private String balance;
    private String currency;
    private String name;
    private String description;
    private String note;
    private String iban;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getAccBankCode() {
        return accBankCode;
    }

    public void setAccBankCode(String accBankCode) {
        this.accBankCode = accBankCode;
    }

    public Date getTransparencyFrom() {
        return transparencyFrom;
    }

    public void setTransparencyFrom(Date transparencyFrom) {
        this.transparencyFrom = transparencyFrom;
    }

    public Date getTransparencyTo() {
        return transparencyTo;
    }

    public void setTransparencyTo(Date transparencyTo) {
        this.transparencyTo = transparencyTo;
    }

    public Date getPublicationTo() {
        return publicationTo;
    }

    public void setPublicationTo(Date publicationTo) {
        this.publicationTo = publicationTo;
    }

    public Date getActualizationDate() {
        return actualizationDate;
    }

    public void setActualizationDate(Date actualizationDate) {
        this.actualizationDate = actualizationDate;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
