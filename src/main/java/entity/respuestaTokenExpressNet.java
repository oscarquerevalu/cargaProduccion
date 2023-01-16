package entity;

public class respuestaTokenExpressNet {
    String access_token;

    public respuestaTokenExpressNet() {}

    public respuestaTokenExpressNet(String access_token) {
        this.access_token = access_token;
    }

    public String getAccess_token() {
        return this.access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
