package entity;

public class respuestaToken {
    String accesstoken;

    public respuestaToken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    public respuestaToken() {}

    public String getAccesstoken() {
        return this.accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }
}
