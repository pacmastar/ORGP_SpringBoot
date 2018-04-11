package com.example.demo.domain.primary;



import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sodtrans")
public class SodTransactionPrimary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_sod_trans")
    long idSodTrans;

    @Column(name = "card_number")
    String cardNumber;

    @Column(name = "card_type")
    int cardType;

    @Column(name = "card_sub_type")
    int cardSubType;

    @Column(name = "reg_date_time")
    Date regDateTime;

    @Column(name = "kassier_kode")
    int kassierCode;

    @Column(name = "kass_kode")
    int kassCode;

    @Column(name = "sum_payment")
    int summPayment;

    @Column(name = "sum_purse")
    int summPurse;

    @Column(name = "validator_id")
    int validatorId;

    @Column(name = "id_agents")
    int agentId;

    @Column(name = "dos_flag")
    boolean dosFlag;

    @Column(name = "get_signature")
    String signature;

    public long getIdSodTrans() {
        return idSodTrans;
    }

    public void setIdSodTrans(long idSodTrans) {
        this.idSodTrans = idSodTrans;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    public int getCardSubType() {
        return cardSubType;
    }

    public void setCardSubType(int cardSubType) {
        this.cardSubType = cardSubType;
    }

    public Date getRegDateTime() {
        return regDateTime;
    }

    public void setRegDateTime(Date regDateTime) {
        this.regDateTime = regDateTime;
    }

    public int getKassierCode() {
        return kassierCode;
    }

    public void setKassierCode(int kassierCode) {
        this.kassierCode = kassierCode;
    }

    public int getKassCode() {
        return kassCode;
    }

    public void setKassCode(int kassCode) {
        this.kassCode = kassCode;
    }

    public int getSummPayment() {
        return summPayment;
    }

    public void setSummPayment(int summPayment) {
        this.summPayment = summPayment;
    }

    public int getSummPurse() {
        return summPurse;
    }

    public void setSummPurse(int summPurse) {
        this.summPurse = summPurse;
    }

    public int getValidatorId() {
        return validatorId;
    }

    public void setValidatorId(int validatorId) {
        this.validatorId = validatorId;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public boolean isDosFlag() {
        return dosFlag;
    }

    public void setDosFlag(boolean dosFlag) {
        this.dosFlag = dosFlag;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
