package com.hendrikm.models;

import java.util.UUID;

public class CompanyModel {

    private UUID id;
    private String participantType = "Ettevõte";
    private String companyName;
    private String registerCode;
    private int companyParticipants;
    private String paymentMethod;
    private String information;

    public CompanyModel() {
        super();
    }

    public CompanyModel(String companyName, String registerCode, int companyParticipants, String paymentMethod,
            String information) {
        this.id = UUID.randomUUID();
        this.companyName = companyName;
        this.registerCode = registerCode;
        this.companyParticipants = companyParticipants;
        this.paymentMethod = paymentMethod;
        this.information = information;
    }

    public UUID getId() {
        return id;
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

    public String getParticipantType() {
        return participantType;
    }

    public void setParticipantType(String participantType) {
        this.participantType = participantType;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegisterCode() {
        return registerCode;
    }

    public void setRegisterCode(String registerCode) {
        this.registerCode = registerCode;
    }

    public int getCompanyParticipants() {
        return companyParticipants;
    }

    public void setCompanyParticipants(int companyParticipants) {
        this.companyParticipants = companyParticipants;
    }

    @Override
    public String toString() {
        return "CompanyModel [id=" + id + ", participantType=" + participantType + ", companyName=" + companyName
                + ", registerCode=" + registerCode + ", companyParticipants=" + companyParticipants + ", paymentMethod="
                + paymentMethod + ", information=" + information + "]";
    }

}
