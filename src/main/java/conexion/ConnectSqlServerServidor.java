package conexion;

import business_logic.BLProduccion;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectSqlServerServidor {
    private static Logger log = Logger.getLogger(OperacionSqlServerServidor.class);
    Connection conexion;

    public ConnectSqlServerServidor(String cadena_conexion) {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = cadena_conexion;
        try {
            Class.forName(driver);
            this.conexion = DriverManager.getConnection(url);
        } catch (Exception exc) {
            log.info(exc);
        }
    }

    public Connection getConexion() {
        return this.conexion;
    }
}
