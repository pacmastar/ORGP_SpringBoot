package com.example.demo.domain.secondary;

import com.example.demo.domain.primary.Payment;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "modifiedpayments")
public class PaymentBackup {
    public PaymentBackup() {
    }
    public PaymentBackup(Payment payment) {
        this.tableId = payment.tableId;
        this.systemId = payment.systemId;
        this.accept = payment.accept;
        this.agentTime = payment.agentTime;
        this.changeStatusTime = payment.changeStatusTime;
        this.cardNumber = payment.cardNumber;
        this.status = payment.status;
        this.summ = payment.summ;
        this.paymentId = payment.paymentId;
    }
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_Id")
    public long tableId;

    @Column(name = "systemid")
    public int systemId;

    @Column(name = "paymentid")
    public String paymentId;

    @Column(name = "cardnumber")
    public String cardNumber;

    @Column(name = "Summ")
    public int summ;

    @Column(name = "agenttime")
    public Date agentTime;

    @Column(name = "Status")
    public int status;

    @Column(name = "Accept")
    public byte accept;

    @Column(name = "changestatustime")
    public Date changeStatusTime;
    @Column(name = "username")
    String userName;

    @Column(name = "description")
    String description;


    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getSumm() {
        return summ;
    }

    public void setSumm(int summ) {
        this.summ = summ;
    }

    public Date getAgentTime() {
        return agentTime;
    }

    public void setAgentTime(Date agentTime) {
        this.agentTime = agentTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public byte getAccept() {
        return accept;
    }

    public void setAccept(byte accept) {
        this.accept = accept;
    }

    public Date getChangeStatusTime() {
        return changeStatusTime;
    }

    public void setChangeStatusTime(Date changeStatusTime) {
        this.changeStatusTime = changeStatusTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PaymentBackup{" +
                "tableId=" + tableId +
                ", systemId=" + systemId +
                ", paymentId='" + paymentId + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", summ=" + summ +
                ", agentTime=" + agentTime +
                ", status=" + status +
                ", accept=" + accept +
                ", changeStatusTime=" + changeStatusTime +
                ", userName='" + userName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
