package entity;

public class CabeceraNiubiz {
    int operationNumbers;

    String ruc;

    public CabeceraNiubiz() {}

    public CabeceraNiubiz(int operationNumbers) {
        this.operationNumbers = operationNumbers;
    }

    public String getRuc() {
        return this.ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public int getOperationNumbers() {
        return this.operationNumbers;
    }

    public void setOperationNumbers(int operationNumbers) {
        this.operationNumbers = operationNumbers;
    }
}
