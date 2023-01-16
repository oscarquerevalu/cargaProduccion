package entity;

public class Papas {
    String CENTRO;

    String FECHA;

    String TIPOOPERACION;

    String REFERENCIA;

    String UNIDADESTOTAL;

    String COMPONENTE;

    String CANTIDAD;

    String NUMSERIEFAC;

    String NUMALBARAN;

    String POSTICKET1;

    String POSTICKET2;

    String CANTIDAD2;

    String ABONODE_NUMSERIE;

    String REFEREENCIA;

    public String toString() {
        return ((this.CENTRO == null) ? "" : this.CENTRO) + "," + (
                (this.FECHA == null) ? "" : this.FECHA) + "," + (
                (this.TIPOOPERACION == null) ? "" : this.TIPOOPERACION) + "," + (
                (this.REFERENCIA == null) ? "" : this.REFERENCIA) + "," + (
                (this.UNIDADESTOTAL == null) ? "" : this.UNIDADESTOTAL) + "," + (
                (this.COMPONENTE == null) ? "" : this.COMPONENTE) + "," + (
                (this.CANTIDAD == null) ? "" : this.CANTIDAD) + "," + (
                (this.NUMSERIEFAC == null) ? "" : this.NUMSERIEFAC) + "," + (
                (this.NUMALBARAN == null) ? "" : this.NUMALBARAN) + "," + (
                (this.POSTICKET1 == null) ? "" : this.POSTICKET1) + "," + (
                (this.POSTICKET2 == null) ? "" : this.POSTICKET2) + "," + (
                (this.CANTIDAD2 == null) ? "" : this.CANTIDAD2) + "," + (
                (this.ABONODE_NUMSERIE == null) ? "" : this.ABONODE_NUMSERIE) + "," + (
                (this.REFEREENCIA == null) ? "" : this.REFEREENCIA);
    }

    public Papas() {}

    public Papas(String CENTRO, String FECHA, String TIPOOPERACION, String REFERENCIA, String UNIDADESTOTAL, String COMPONENTE, String CANTIDAD, String NUMSERIEFAC, String NUMALBARAN, String POSTICKET1, String POSTICKET2, String CANTIDAD2, String ABONODE_NUMSERIE, String REFEREENCIA) {
        this.CENTRO = CENTRO;
        this.FECHA = FECHA;
        this.TIPOOPERACION = TIPOOPERACION;
        this.REFERENCIA = REFERENCIA;
        this.UNIDADESTOTAL = UNIDADESTOTAL;
        this.COMPONENTE = COMPONENTE;
        this.CANTIDAD = CANTIDAD;
        this.NUMSERIEFAC = NUMSERIEFAC;
        this.NUMALBARAN = NUMALBARAN;
        this.POSTICKET1 = POSTICKET1;
        this.POSTICKET2 = POSTICKET2;
        this.CANTIDAD2 = CANTIDAD2;
        this.ABONODE_NUMSERIE = ABONODE_NUMSERIE;
        this.REFEREENCIA = REFEREENCIA;
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

    public String getTIPOOPERACION() {
        return this.TIPOOPERACION;
    }

    public void setTIPOOPERACION(String TIPOOPERACION) {
        this.TIPOOPERACION = TIPOOPERACION;
    }

    public String getREFERENCIA() {
        return this.REFERENCIA;
    }

    public void setREFERENCIA(String REFERENCIA) {
        this.REFERENCIA = REFERENCIA;
    }

    public String getUNIDADESTOTAL() {
        return this.UNIDADESTOTAL;
    }

    public void setUNIDADESTOTAL(String UNIDADESTOTAL) {
        this.UNIDADESTOTAL = UNIDADESTOTAL;
    }

    public String getCOMPONENTE() {
        return this.COMPONENTE;
    }

    public void setCOMPONENTE(String COMPONENTE) {
        this.COMPONENTE = COMPONENTE;
    }

    public String getCANTIDAD() {
        return this.CANTIDAD;
    }

    public void setCANTIDAD(String CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public String getNUMSERIEFAC() {
        return this.NUMSERIEFAC;
    }

    public void setNUMSERIEFAC(String NUMSERIEFAC) {
        this.NUMSERIEFAC = NUMSERIEFAC;
    }

    public String getNUMALBARAN() {
        return this.NUMALBARAN;
    }

    public void setNUMALBARAN(String NUMALBARAN) {
        this.NUMALBARAN = NUMALBARAN;
    }

    public String getPOSTICKET1() {
        return this.POSTICKET1;
    }

    public void setPOSTICKET1(String POSTICKET1) {
        this.POSTICKET1 = POSTICKET1;
    }

    public String getPOSTICKET2() {
        return this.POSTICKET2;
    }

    public void setPOSTICKET2(String POSTICKET2) {
        this.POSTICKET2 = POSTICKET2;
    }

    public String getCANTIDAD2() {
        return this.CANTIDAD2;
    }

    public void setCANTIDAD2(String CANTIDAD2) {
        this.CANTIDAD2 = CANTIDAD2;
    }

    public String getABONODE_NUMSERIE() {
        return this.ABONODE_NUMSERIE;
    }

    public void setABONODE_NUMSERIE(String ABONODE_NUMSERIE) {
        this.ABONODE_NUMSERIE = ABONODE_NUMSERIE;
    }

    public String getREFEREENCIA() {
        return this.REFEREENCIA;
    }

    public void setREFEREENCIA(String REFEREENCIA) {
        this.REFEREENCIA = REFEREENCIA;
    }
}
