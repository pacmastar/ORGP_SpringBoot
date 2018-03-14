package com.example.demo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "payments")
public class Payment {
    public Payment() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "table_id")
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
}
