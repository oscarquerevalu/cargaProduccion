package data_access;

import conexion.OperacionSqlServerServidor;
import entity.Papas;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAPapas {
    private static Logger log = Logger.getLogger(DAMediterraneo.class);
    OperacionSqlServerServidor operacion2;

    String jsonRespuesta = "";

    int total;

    public DAPapas(String cadena_conexion) {
        this.operacion2 = new OperacionSqlServerServidor(cadena_conexion);
    }

    public ArrayList<Papas> listarCaja(String consultaObjetos, Object[] condiciones) {
        ArrayList<Papas> lista = new ArrayList<>();
        try {
            ResultSet rsCombo = this.operacion2.EjecutarConsulta(consultaObjetos, condiciones);
            while (rsCombo != null && rsCombo.next())
                lista.add(new Papas(rsCombo
                        .getString("CENTRO"), rsCombo
                        .getString("FECHA"), rsCombo
                        .getString("TIPOOPERACION"), rsCombo
                        .getString("REFERENCIA"), rsCombo
                        .getString("UNIDADESTOTAL"), rsCombo
                        .getString("COMPONENTE"), rsCombo
                        .getString("CANTIDAD"), rsCombo
                        .getString("NUMSERIEFAC"), rsCombo
                        .getString("NUMALBARAN"), rsCombo
                        .getString("POSTICKET1"), rsCombo
                        .getString("POSTICKET2"), rsCombo
                        .getString("CANTIDAD"), rsCombo
                        .getString("ABONODE_NUMSERIE"), rsCombo
                        .getString("REFEREENCIA")));
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
