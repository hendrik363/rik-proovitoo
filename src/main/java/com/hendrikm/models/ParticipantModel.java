package com.hendrikm.models;

public class ParticipantModel {
    private int id;
    private String name;
    private String personalCode;
    private String paymentMethod;
    private String information;

    @Override
    public String toString() {
        return "ParticipantModel [id=" + id + ", name=" + name + ", personalCode=" + personalCode
                + ", paymentMethod=" + paymentMethod + ", information=" + information + "]";
    }

    public ParticipantModel() {
        super();
    }

    public ParticipantModel(int id, String name, String date, String personalCode, String paymentMethod, String information) {
        super();
        this.id = id;
        this.name = name;
        this.personalCode = personalCode;
        this.paymentMethod = paymentMethod;
        this.information = information;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

}
