package entity;

import java.util.ArrayList;

public class PeticionExpressNet {
    String stateId;

    String numberCard;

    String starDate;

    String endDate;

    ArrayList<String> codes;

    String network;

    String ruc;

    public PeticionExpressNet() {}

    public PeticionExpressNet(String stateId, String numberCard, String starDate, String endDate, ArrayList<String> codes, String network, String ruc) {
        this.stateId = stateId;
        this.numberCard = numberCard;
        this.starDate = starDate;
        this.endDate = endDate;
        this.codes = codes;
        this.network = network;
        this.ruc = ruc;
    }

    public String getStateId() {
        return this.stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getNumberCard() {
        return this.numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public String getStarDate() {
        return this.starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public ArrayList<String> getCodes() {
        return this.codes;
    }

    public void setCodes(ArrayList<String> codes) {
        this.codes = codes;
    }

    public String getNetwork() {
        return this.network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getRuc() {
        return this.ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
}
