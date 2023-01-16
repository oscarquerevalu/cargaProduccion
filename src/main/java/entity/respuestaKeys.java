package entity;

public class respuestaKeys {
    objetoKeys keys;

    String hash;

    public respuestaKeys() {}

    public respuestaKeys(objetoKeys keys, String hash) {
        this.keys = keys;
        this.hash = hash;
    }

    public objetoKeys getKeys() {
        return this.keys;
    }

    public void setKeys(objetoKeys keys) {
        this.keys = keys;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
