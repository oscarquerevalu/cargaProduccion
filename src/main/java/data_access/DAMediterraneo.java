package data_access;

import conexion.OperacionSqlServerServidor;
import entity.Mediterraneo;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAMediterraneo {
    private static Logger log = Logger.getLogger(DAMediterraneo.class);
    OperacionSqlServerServidor operacion2;

    String jsonRespuesta = "";

    int total;

    public DAMediterraneo(String cadena_conexion) {
        this.operacion2 = new OperacionSqlServerServidor(cadena_conexion);
    }

    public ArrayList<Mediterraneo> listarCaja(String consultaObjetos, Object[] condiciones) {
        ArrayList<Mediterraneo> lista = new ArrayList<>();
        try {
            ResultSet rsCombo = this.operacion2.EjecutarConsulta(consultaObjetos, condiciones);
            while (rsCombo != null && rsCombo.next())
                lista.add(new Mediterraneo(rsCombo
                        .getString("CENTRO"), rsCombo
                        .getString("FECHA"), rsCombo
                        .getString("TIPODOCUMENTO"), rsCombo
                        .getString("MATERIAL_O"), rsCombo
                        .getString("CANTIDAD_O"), rsCombo
                        .getString("MATERIAL_C"), rsCombo
                        .getString("CANTIDAD_C"), rsCombo
                        .getString("SERIE"), rsCombo
                        .getString("NUMERO"), rsCombo
                        .getString("LINEA"), rsCombo
                        .getString("MODLINEA"), rsCombo
                        .getString("COMENT"), rsCombo
                        .getString("REFSERIE"), rsCombo
                        .getString("REFCORRE")));
            if (rsCombo != null)
                rsCombo.close();
            this.operacion2.cerrarConexion();
            return lista;
        } catch (SQLException ex) {
            log.info(ex.getMessage());
            this.operacion2.cerrarConexion();
            return lista;
        }
    }

    public int getTotal() {
        return this.total;
    }
}
