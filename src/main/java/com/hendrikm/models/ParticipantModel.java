package com.hendrikm.models;

import java.util.UUID;

public class ParticipantModel {

    private UUID id;
    private String participantType;
    private String firstName;
    private String lastName;
    private String personalCode;
    private String paymentMethod;
    private String information;

    public ParticipantModel() {
        super();
    }

    public ParticipantModel(String firstName, String participantType, String lastName, String personalCode, String paymentMethod,
            String information) {
        this.id = UUID.randomUUID();
        this.participantType = participantType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalCode = personalCode;
        this.paymentMethod = paymentMethod;
        this.information = information;
    }

    public UUID getId() {
        return id;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "ParticipantModel [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", personalCode="
                + personalCode + ", paymentMethod=" + paymentMethod + ", information=" + information + "]";
    }



    public String getParticipantType() {
        return participantType;
    }

    public void setParticipantType(String participantType) {
        this.participantType = participantType;
    }

}
