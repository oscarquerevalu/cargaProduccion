package entity;

import java.util.ArrayList;

public class PeticionNiubiz {
    String ruc;

    ArrayList<String> commerceCodes;

    String currencyCode;

    String startDate;

    String endDate;

    String typeFile;

    String groupedRuc;

    String userId;

    String name;

    public PeticionNiubiz() {}

    public PeticionNiubiz(String ruc, ArrayList<String> commerceCodes, String currencyCode, String startDate, String endDate) {
        this.ruc = ruc;
        this.commerceCodes = commerceCodes;
        this.currencyCode = currencyCode;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getGroupedRuc() {
        return this.groupedRuc;
    }

    public void setGroupedRuc(String groupedRuc) {
        this.groupedRuc = groupedRuc;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeFile() {
        return this.typeFile;
    }

    public void setTypeFile(String typeFile) {
        this.typeFile = typeFile;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRuc() {
        return this.ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public ArrayList<String> getCommerceCodes() {
        return this.commerceCodes;
    }

    public void setCommerceCodes(ArrayList<String> commerceCodes) {
        this.commerceCodes = commerceCodes;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
