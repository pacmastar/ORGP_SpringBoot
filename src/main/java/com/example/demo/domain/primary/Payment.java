package com.example.demo.domain.primary;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sendpayment")
public class Payment {
    public Payment(int systemId, String paymentId, String cardNumber, int summ, Date agentTime, int status) {
        this.systemId = systemId;
        this.paymentId = paymentId;
        this.cardNumber = cardNumber;
        this.summ = summ;
        this.agentTime = agentTime;
        this.status = status;
        this.changeStatusTime = this.agentTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public String  getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String  paymentId) {
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

    @Override
    public String toString() {
        return "Payment{" +
                "tableId=" + tableId +
                ", systemId=" + systemId +
                ", paymentId='" + paymentId + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", summ=" + summ +
                ", agentTime=" + agentTime +
                ", status=" + status +
                ", accept=" + accept +
                ", changeStatusTime=" + changeStatusTime +
                '}';
    }
}
