package entity;

public class respuestaNiubiz {
    String message;

    dataDepositosNiubiz data;

    String error;

    public respuestaNiubiz() {}

    public respuestaNiubiz(String message, dataDepositosNiubiz data, String error) {
        this.message = message;
        this.data = data;
        this.error = error;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public dataDepositosNiubiz getData() {
        return this.data;
    }

    public void setData(dataDepositosNiubiz data) {
        this.data = data;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
