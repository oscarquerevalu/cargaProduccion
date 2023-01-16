package entity;

public class respuestaFinalKeys {
    respuestaKeys loginKeys;

    public respuestaFinalKeys() {}

    public respuestaFinalKeys(respuestaKeys loginKeys) {
        this.loginKeys = loginKeys;
    }

    public respuestaKeys getLoginKeys() {
        return this.loginKeys;
    }

    public void setLoginKeys(respuestaKeys loginKeys) {
        this.loginKeys = loginKeys;
    }
}
