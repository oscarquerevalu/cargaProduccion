package entity;

public class objetoKeys {
    String usuario_pos;

    String passsword_pos;

    String c;

    String p;

    public objetoKeys() {}

    public objetoKeys(String c, String p) {
        this.c = c;
        this.p = p;
    }

    public String getUsuario_pos() {
        return this.usuario_pos;
    }

    public void setUsuario_pos(String usuario_pos) {
        this.usuario_pos = usuario_pos;
    }

    public String getPasssword_pos() {
        return this.passsword_pos;
    }

    public void setPasssword_pos(String passsword_pos) {
        this.passsword_pos = passsword_pos;
    }

    public String getC() {
        return this.c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getP() {
        return this.p;
    }

    public void setP(String p) {
        this.p = p;
    }
}
