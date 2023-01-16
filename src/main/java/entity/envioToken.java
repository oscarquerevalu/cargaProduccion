package entity;

public class envioToken {
    String hashRequest;

    String data;

    public envioToken() {}

    public envioToken(String hashRequest, String data) {
        this.hashRequest = hashRequest;
        this.data = data;
    }

    public String getHashRequest() {
        return this.hashRequest;
    }

    public void setHashRequest(String hashRequest) {
        this.hashRequest = hashRequest;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
