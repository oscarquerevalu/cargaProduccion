package entity;

public class Mediterraneo {
    String CENTRO;

    String FECHA;

    String TIPODOCUMENTO;

    String MATERIAL_O;

    String CANTIDAD_O;

    String MATERIAL_C;

    String CANTIDAD_C;

    String SERIE;

    String NUMERO;

    String LINEA;

    String MODLINEA;

    String COMENT;

    String REFSERIE;

    String REFCORRE;

    public String toString() {
        return ((this.CENTRO == null) ? "" : this.CENTRO) + "," + (
                (this.FECHA == null) ? "" : this.FECHA) + "," + (
                (this.TIPODOCUMENTO == null) ? "" : this.TIPODOCUMENTO) + "," + (
                (this.MATERIAL_O == null) ? "" : this.MATERIAL_O) + "," + (
                (this.CANTIDAD_O == null) ? "" : this.CANTIDAD_O) + "," + (
                (this.MATERIAL_C == null) ? "" : this.MATERIAL_C) + "," + (
                (this.CANTIDAD_C == null) ? "" : this.CANTIDAD_C) + "," + (
                (this.SERIE == null) ? "" : this.SERIE) + "," + (
                (this.NUMERO == null) ? "" : this.NUMERO) + "," + (
                (this.LINEA == null) ? "" : this.LINEA) + "," + (
                (this.MODLINEA == null) ? "" : this.MODLINEA) + "," + (
                (this.COMENT == null) ? "" : this.COMENT) + "," + (
                (this.REFSERIE == null) ? "" : this.REFSERIE) + "," + (
                (this.REFCORRE == null) ? "" : this.REFCORRE);
    }

    public Mediterraneo() {}

    public Mediterraneo(String CENTRO, String FECHA, String TIPODOCUMENTO, String MATERIAL_O, String CANTIDAD_O, String MATERIAL_C, String CANTIDAD_C, String SERIE, String NUMERO, String LINEA, String MODLINEA, String COMENT, String REFSERIE, String REFCORRE) {
        this.CENTRO = CENTRO;
        this.FECHA = FECHA;
        this.TIPODOCUMENTO = TIPODOCUMENTO;
        this.MATERIAL_O = MATERIAL_O;
        this.CANTIDAD_O = CANTIDAD_O;
        this.MATERIAL_C = MATERIAL_C;
        this.CANTIDAD_C = CANTIDAD_C;
        this.SERIE = SERIE;
        this.NUMERO = NUMERO;
        this.LINEA = LINEA;
        this.MODLINEA = MODLINEA;
        this.COMENT = COMENT;
        this.REFSERIE = REFSERIE;
        this.REFCORRE = REFCORRE;
    }

    public String getCENTRO() {
        return this.CENTRO;
    }

    public void setCENTRO(String CENTRO) {
        this.CENTRO = CENTRO;
    }

    public String getFECHA() {
        return this.FECHA;
    }

    public void setFECHA(String FECHA) {
        this.FECHA = FECHA;
    }

    public String getTIPODOCUMENTO() {
        return this.TIPODOCUMENTO;
    }

    public void setTIPODOCUMENTO(String TIPODOCUMENTO) {
        this.TIPODOCUMENTO = TIPODOCUMENTO;
    }

    public String getMATERIAL_O() {
        return this.MATERIAL_O;
    }

    public void setMATERIAL_O(String MATERIAL_O) {
        this.MATERIAL_O = MATERIAL_O;
    }

    public String getCANTIDAD_O() {
        return this.CANTIDAD_O;
    }

    public void setCANTIDAD_O(String CANTIDAD_O) {
        this.CANTIDAD_O = CANTIDAD_O;
    }

    public String getMATERIAL_C() {
        return this.MATERIAL_C;
    }

    public void setMATERIAL_C(String MATERIAL_C) {
        this.MATERIAL_C = MATERIAL_C;
    }

    public String getCANTIDAD_C() {
        return this.CANTIDAD_C;
    }

    public void setCANTIDAD_C(String CANTIDAD_C) {
        this.CANTIDAD_C = CANTIDAD_C;
    }

    public String getSERIE() {
        return this.SERIE;
    }

    public void setSERIE(String SERIE) {
        this.SERIE = SERIE;
    }

    public String getNUMERO() {
        return this.NUMERO;
    }

    public void setNUMERO(String NUMERO) {
        this.NUMERO = NUMERO;
    }

    public String getLINEA() {
        return this.LINEA;
    }

    public void setLINEA(String LINEA) {
        this.LINEA = LINEA;
    }

    public String getMODLINEA() {
        return this.MODLINEA;
    }

    public void setMODLINEA(String MODLINEA) {
        this.MODLINEA = MODLINEA;
    }

    public String getCOMENT() {
        return this.COMENT;
    }

    public void setCOMENT(String COMENT) {
        this.COMENT = COMENT;
    }

    public String getREFSERIE() {
        return this.REFSERIE;
    }

    public void setREFSERIE(String REFSERIE) {
        this.REFSERIE = REFSERIE;
    }

    public String getREFCORRE() {
        return this.REFCORRE;
    }

    public void setREFCORRE(String REFCORRE) {
        this.REFCORRE = REFCORRE;
    }
}
