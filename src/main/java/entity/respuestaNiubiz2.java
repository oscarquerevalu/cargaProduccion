package entity;

public class respuestaNiubiz2 {
    String message;

    RespuestaId data;

    String error;

    public respuestaNiubiz2() {}

    public respuestaNiubiz2(String message, RespuestaId data, String error) {
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

    public RespuestaId getData() {
        return this.data;
    }

    public void setData(RespuestaId data) {
        this.data = data;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
