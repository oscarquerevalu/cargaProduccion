package entity;

import java.util.ArrayList;

public class dataDepositosNiubiz {
    String isTotalRows;

    String auditDate;

    ArrayList<depositosNiubiz> depositsDetailsItems;

    ArrayList<CabeceraNiubiz> depositsSummaryDetailsItems;

    public dataDepositosNiubiz() {}

    public dataDepositosNiubiz(String isTotalRows, String auditDate, ArrayList<depositosNiubiz> depositsDetailsItems, ArrayList<CabeceraNiubiz> depositsSummaryDetailsItems) {
        this.isTotalRows = isTotalRows;
        this.auditDate = auditDate;
        this.depositsDetailsItems = depositsDetailsItems;
        this.depositsSummaryDetailsItems = depositsSummaryDetailsItems;
    }

    public ArrayList<CabeceraNiubiz> getDepositsSummaryDetailsItems() {
        return this.depositsSummaryDetailsItems;
    }

    public void setDepositsSummaryDetailsItems(ArrayList<CabeceraNiubiz> depositsSummaryDetailsItems) {
        this.depositsSummaryDetailsItems = depositsSummaryDetailsItems;
    }

    public String getIsTotalRows() {
        return this.isTotalRows;
    }

    public void setIsTotalRows(String isTotalRows) {
        this.isTotalRows = isTotalRows;
    }

    public String getAuditDate() {
        return this.auditDate;
    }

    public void setAuditDate(String auditDate) {
        this.auditDate = auditDate;
    }

    public ArrayList<depositosNiubiz> getDepositsDetailsItems() {
        return this.depositsDetailsItems;
    }

    public void setDepositsDetailsItems(ArrayList<depositosNiubiz> depositsDetailsItems) {
        this.depositsDetailsItems = depositsDetailsItems;
    }
}
