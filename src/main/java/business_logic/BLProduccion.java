package business_logic;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data_access.DAMediterraneo;
import data_access.DAPapas;
import entity.ArizaleArchivo;
import entity.ArizaleLocal;
import entity.CabeceraNiubiz;
import entity.ComerciosNiubiz;
import entity.DownloadItem;
import entity.Mediterraneo;
import entity.Papas;
import entity.PeticionExpressNet;
import entity.PeticionNiubiz;
import entity.RespuestaDescarga;
import entity.depositosNiubiz;
import entity.envioToken;
import entity.objetoKeys;
import entity.respuestaKeys;
import entity.respuestaNiubiz;
import entity.respuestaNiubiz2;
import entity.respuestaToken;
import entity.respuestaTokenExpressNet;
import entity.tokenNiubiz;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.swing.JOptionPane;

import net.wong.archivoproduccion.Principal;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.apache.poi.util.IOUtils;
import util.Util;

public class BLProduccion {
    private static Logger log = Logger.getLogger(BLProduccion.class);
    public void listarMediterraneo(int dias) throws FileNotFoundException, IOException {
        Object[] condiciones2 = { Integer.valueOf(dias) };
        DAMediterraneo da = new DAMediterraneo("jdbc:sqlserver://10.100.150.70:1433;databaseName=MEDITERRANEOQA;user=sa; password=masterkey");
        ArrayList<Mediterraneo> lista = da.listarCaja("{call sp_produccion77_4(?)}", condiciones2);
        String texto = "";
        for (int i = 0; i < lista.size(); i++)
            texto = texto + lista.get(i) + "\n";
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        cal.add(5, dias);
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy");
        String nombre_archivo = "4618_FileProduction_" + formatter.format(cal.getTime()) + ".txt";
        InputStream s_produccion = new ByteArrayInputStream(texto.getBytes(StandardCharsets.UTF_8));
        //envioFtp(s_produccion, "/notprod/med/" + nombre_archivo);
        envioFtp(s_produccion, nombre_archivo);
        if (texto.equals("")) {
            ArrayList<String> correos = new ArrayList<>();
            correos.add("ecaceres@wong.net.pe");
            ArrayList<String> cc = new ArrayList<>();
            cc.add("asanchez@wong.net.pe");
            cc.add("rherrera@wong.net.pe");
            cc.add("acier@wong.net.pe");
            cc.add("mdiaz@wong.net.pe");
            String asunto = "FALLO EN GENERACION DE ARCHIVO PRODUCCION MEDITERRANEO " + formatter.format(cal.getTime());
            (new Util()).sendEmailFallo(correos, cc, asunto);
        }
    }

    public void listarPapas(int dias) throws FileNotFoundException, IOException {
        Object[] condiciones2 = { Integer.valueOf(dias) };
        DAPapas da = new DAPapas("jdbc:sqlserver://10.110.21.9:1433;databaseName=MNGPAPAS;user=sa; password=masterkey");
        ArrayList<Papas> lista = da.listarCaja("{call sp_produccion_papas_4(?)}", condiciones2);
        String texto = "";
        for (int i = 0; i < lista.size(); i++)
            texto = texto + lista.get(i) + "\n";
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        cal.add(5, dias);
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy");
        String nombre_archivo = "Papas_FileProduction_" + formatter.format(cal.getTime()) + ".txt";
        InputStream s_produccion = new ByteArrayInputStream(texto.getBytes(StandardCharsets.UTF_8));
        //envioFtp(s_produccion, "/notprod/pap/" + nombre_archivo);
        envioFtp(s_produccion, nombre_archivo);
        if (texto.equals("")) {
            ArrayList<String> correos = new ArrayList<>();
            correos.add("ecaceres@wong.net.pe");
            ArrayList<String> cc = new ArrayList<>();
            cc.add("asanchez@wong.net.pe");
            cc.add("rherrera@wong.net.pe");
            cc.add("acier@wong.net.pe");
            cc.add("mdiaz@wong.net.pe");
            String asunto = "FALLO EN GENERACION DE ARCHIVO PRODUCCION PAPAS " + formatter.format(cal.getTime());
            (new Util()).sendEmailFallo(correos, cc, asunto);
        }
    }

    public void listarDonBuffet(int dias) throws FileNotFoundException, IOException {
        Object[] condiciones2 = { Integer.valueOf(dias) };
        DAPapas da = new DAPapas("jdbc:sqlserver://10.100.150.70:1433;databaseName=MEDITERRANEOQA;user=sa; password=masterkey");
        ArrayList<Papas> lista = da.listarCaja("{call sp_produccion_donbuffet_4(?)}", condiciones2);
        String texto = "";
        for (int i = 0; i < lista.size(); i++)
            texto = texto + lista.get(i) + "\n";
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        cal.add(5, dias);
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy");
        String nombre_archivo = "DonBuffet_FileProduction_" + formatter.format(cal.getTime()) + ".txt";
        InputStream s_produccion = new ByteArrayInputStream(texto.getBytes(StandardCharsets.UTF_8));
        //envioFtp(s_produccion, "/notprod/buf/" + nombre_archivo);
        envioFtp(s_produccion, nombre_archivo);
        if (texto.equals("")) {
            ArrayList<String> correos = new ArrayList<>();
            correos.add("ecaceres@wong.net.pe");
            ArrayList<String> cc = new ArrayList<>();
            cc.add("asanchez@wong.net.pe");
            cc.add("rherrera@wong.net.pe");
            cc.add("acier@wong.net.pe");
            cc.add("mdiaz@wong.net.pe");
            String asunto = "FALLO EN GENERACION DE ARCHIVO PRODUCCION DON BUFFET " + formatter.format(cal.getTime());
            (new Util()).sendEmailFallo(correos, cc, asunto);
        }
    }

    private static class SSLUtil {
        protected static SSLConnectionSocketFactory getInsecureSSLConnectionSocketFactory() throws KeyManagementException, NoSuchAlgorithmException {
            TrustManager[] trustAllCerts = { new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}

                public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}
            } };
            SSLContext sslcontext = SSLContext.getInstance("SSL");
            sslcontext.init(null, trustAllCerts, new SecureRandom());
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            return sslsf;
        }
    }

    public void listarArisale(int dias, String token_origen) {
        String archivo_cliente = "";
        String archivo_ventas = "";
        String archivo_produccion = "";
        CloseableHttpClient client = HttpClients.createDefault();
        String token = token_origen;
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            String data = readJsonFromUrlGet(client, "https://sale.arisale.com.pe/api/locals", "", token);
            log.info("paso 0");
            if (data.contains("Unauthorized")) {
                JOptionPane.showMessageDialog(null, "Token Vencido Arisale");
                ArrayList<String> correos = new ArrayList<>();
                correos.add("ecaceres@wong.net.pe");
                ArrayList<String> cc = new ArrayList<>();
                cc.add("rherrera@wong.net.pe");
                cc.add("cdelrio@wong.net.pe");
                String asunto = "TOKEN VENCIDO " + formatter.format(cal.getTime());
                (new Util()).sendEmailFallo(correos, cc, asunto);
                return;
            }
            log.info(data);
            Type listTypeNegocioArizale = (new TypeToken<ArrayList<ArizaleLocal>>() {

            }).getType();
            ArrayList<ArizaleLocal> negocios = (ArrayList<ArizaleLocal>)(new Gson()).fromJson(data, listTypeNegocioArizale);
            cal = Calendar.getInstance();
            formatter = new SimpleDateFormat("yyyyMMdd");
            cal.setTime(new Date());
            cal.set(11, 0);
            cal.set(12, 0);
            cal.set(13, 0);
            cal.set(14, 0);
            cal.add(5, dias);
            long startdate = cal.getTime().getTime();
            long endDate = cal.getTime().getTime() + 86399999L;
            boolean primera_cliente = true;
            int i;
            log.info("negocios.size:"+negocios.size());
            for (i = 0; i < negocios.size(); i++) {
                String body = "{\n\"startDate\": " + startdate + ",\n\"endDate\": " + endDate + ",\n\"invoiceType\": null,\n\"establishmentId\": \"" + ((ArizaleLocal)negocios.get(i)).getLocalId() + "\",\n\"deviceId\": null,\n\"billingStatus\": null,\n\"documentExtensionType\": \"txt\",\n\"documentTypeDownload\": \"client\"\n}";
                log.info("body:"+body);
                String data2 = readJsonFromUrlPost("https://sale.arisale.com.pe/api/cpe/export", body, token);
                log.info("data2:"+data2);
                ArizaleArchivo archivo = new ArizaleArchivo();
                archivo = (ArizaleArchivo)(new Gson()).fromJson(data2, archivo.getClass());
                URL url = new URL(archivo.getUrl());
                BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
                int contador = 1;
                String ij;
                while ((ij = read.readLine()) != null) {
                    if (contador > 1 || primera_cliente) {
                        archivo_cliente = archivo_cliente + ij + "\n";
                        primera_cliente = false;
                    }
                    contador++;
                }
                read.close();
            }
            primera_cliente = true;
            for (i = 0; i < negocios.size(); i++) {
                String body = "{\n\"startDate\": " + startdate + ",\n\"endDate\": " + endDate + ",\n\"invoiceType\": null,\n\"establishmentId\": \"" + ((ArizaleLocal)negocios.get(i)).getLocalId() + "\",\n\"deviceId\": null,\n\"billingStatus\": null,\n\"documentExtensionType\": \"txt\",\n\"documentTypeDownload\": \"sale\"\n}";
                String data2 = readJsonFromUrlPost("https://sale.arisale.com.pe/api/cpe/export", body, token);
                log.info("data3:"+data2);
                ArizaleArchivo archivo = new ArizaleArchivo();
                archivo = (ArizaleArchivo)(new Gson()).fromJson(data2, archivo.getClass());
                URL url = new URL(archivo.getUrl());
                BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
                int contador = 1;
                String ij;
                while ((ij = read.readLine()) != null) {
                    if (contador > 1 || primera_cliente) {
                        archivo_ventas = archivo_ventas + ij + "\n";
                        primera_cliente = false;
                    }
                    contador++;
                }
                read.close();
            }
            primera_cliente = true;
            for (i = 0; i < negocios.size(); i++) {
                String body = "{\n\"startDate\": " + startdate + ",\n\"endDate\": " + endDate + ",\n\"invoiceType\": \"B\",\n\"establishmentId\": \"" + ((ArizaleLocal)negocios.get(i)).getLocalId() + "\",\n\"deviceId\": null,\n\"billingStatus\": null,\n\"documentExtensionType\": \"txt\",\n\"documentTypeDownload\": \"production\"\n}";
                String data2 = readJsonFromUrlPost("https://sale.arisale.com.pe/api/cpe/export", body, token);
                log.info("data4:"+data2);
                ArizaleArchivo archivo = new ArizaleArchivo();
                archivo = (ArizaleArchivo)(new Gson()).fromJson(data2, archivo.getClass());
                URL url = new URL(archivo.getUrl());
                BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
                int contador = 1;
                String ij;
                while ((ij = read.readLine()) != null) {
                    archivo_produccion = archivo_produccion + ij + "\n";
                    contador++;
                }
                read.close();
            }
            for (i = 0; i < negocios.size(); i++) {
                String body = "{\n\"startDate\": " + startdate + ",\n\"endDate\": " + endDate + ",\n\"invoiceType\": \"F\",\n\"establishmentId\": \"" + ((ArizaleLocal)negocios.get(i)).getLocalId() + "\",\n\"deviceId\": null,\n\"billingStatus\": null,\n\"documentExtensionType\": \"txt\",\n\"documentTypeDownload\": \"production\"\n}";
                String data2 = readJsonFromUrlPost("https://sale.arisale.com.pe/api/cpe/export", body, token);
                log.info("data5:"+data2);
                ArizaleArchivo archivo = new ArizaleArchivo();
                archivo = (ArizaleArchivo)(new Gson()).fromJson(data2, archivo.getClass());
                URL url = new URL(archivo.getUrl());
                BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
                int contador = 1;
                String ij;
                while ((ij = read.readLine()) != null) {
                    archivo_produccion = archivo_produccion + ij + "\n";
                    contador++;
                }
                read.close();
            }
            for (i = 0; i < negocios.size(); i++) {
                String body = "{\n\"startDate\": " + startdate + ",\n\"endDate\": " + endDate + ",\n\"invoiceType\": \"NC\",\n\"establishmentId\": \"" + ((ArizaleLocal)negocios.get(i)).getLocalId() + "\",\n\"deviceId\": null,\n\"billingStatus\": null,\n\"documentExtensionType\": \"txt\",\n\"documentTypeDownload\": \"production\"\n}";
                String data2 = readJsonFromUrlPost("https://sale.arisale.com.pe/api/cpe/export", body, token);
                ArizaleArchivo archivo = new ArizaleArchivo();
                archivo = (ArizaleArchivo)(new Gson()).fromJson(data2, archivo.getClass());
                log.info("data5:"+data2);
                URL url = new URL(archivo.getUrl());
                BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
                int contador = 1;
                String ij;
                while ((ij = read.readLine()) != null) {
                    archivo_produccion = archivo_produccion + ij + "\n";
                    contador++;
                }
                read.close();
            }
            for (i = 0; i < negocios.size(); i++) {
                String body = "{\n\"startDate\": " + startdate + ",\n\"endDate\": " + endDate + ",\n\"invoiceType\": \"ND\",\n\"establishmentId\": \"" + ((ArizaleLocal)negocios.get(i)).getLocalId() + "\",\n\"deviceId\": null,\n\"billingStatus\": null,\n\"documentExtensionType\": \"txt\",\n\"documentTypeDownload\": \"production\"\n}";
                String data2 = readJsonFromUrlPost("https://sale.arisale.com.pe/api/cpe/export", body, token);
                ArizaleArchivo archivo = new ArizaleArchivo();
                log.info("data6:"+data2);
                archivo = (ArizaleArchivo)(new Gson()).fromJson(data2, archivo.getClass());
                URL url = new URL(archivo.getUrl());
                BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
                int contador = 1;
                String ij;
                while ((ij = read.readLine()) != null) {
                    archivo_produccion = archivo_produccion + ij + "\n";
                    contador++;
                }
                read.close();
            }
            String nombre_archivo = "lista-de-produccion-comprobantes-electronicos-" + formatter.format(cal.getTime()) + ".txt";
            InputStream s_produccion = new ByteArrayInputStream(archivo_produccion.getBytes(StandardCharsets.UTF_8));
            //envioFtp(s_produccion, "/notprod/tot/" + nombre_archivo);
            envioFtp(s_produccion, nombre_archivo);
            nombre_archivo = "lista-de-clientes-comprobantes-electronicos-" + formatter.format(cal.getTime()) + ".txt";
            s_produccion = new ByteArrayInputStream(archivo_cliente.getBytes(StandardCharsets.UTF_8));
            //envioFtp(s_produccion, "/medtot/cli/" + nombre_archivo);
            envioFtp(s_produccion, nombre_archivo);
            nombre_archivo = "lista-de-ventas-comprobantes-electronicos-" + formatter.format(cal.getTime()) + ".txt";
            s_produccion = new ByteArrayInputStream(archivo_ventas.getBytes(StandardCharsets.UTF_8));
            //envioFtp(s_produccion, "/medtot/ven/" + nombre_archivo);
            envioFtp(s_produccion, nombre_archivo);
            if (archivo_ventas.equals("") || archivo_cliente.equals("") || archivo_produccion.equals("")) {
                ArrayList<String> correos = new ArrayList<>();
                correos.add("ecaceres@wong.net.pe");
                ArrayList<String> cc = new ArrayList<>();
                cc.add("asanchez@wong.net.pe");
                cc.add("rherrera@wong.net.pe");
                cc.add("acier@wong.net.pe");
                cc.add("mdiaz@wong.net.pe");
                String str = "FALLO EN GENERACION DE ARCHIVO PRODUCCION TOTEM " + formatter.format(cal.getTime());
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    public void listarNiubiz(String correo, String password, int dias, String identificador, String ruc, String user_id, String negocio) {
        try {
            TrustManager[] trustAllCerts = { new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String authType) {}

                public void checkServerTrusted(X509Certificate[] chain, String authType) {}

                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            } };
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new SecureRandom());
            OkHttpClient.Builder newBuilder = new OkHttpClient.Builder();
            newBuilder.sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager)trustAllCerts[0]);
            newBuilder.hostnameVerifier((hostname, session) -> true);
            OkHttpClient client2 = newBuilder.build();
            CloseableHttpClient client = HttpClients.custom().setSSLContext((new SSLContextBuilder()).loadTrustMaterial(null, (TrustStrategy)TrustAllStrategy.INSTANCE).build()).setSSLHostnameVerifier((HostnameVerifier)NoopHostnameVerifier.INSTANCE).setSSLSocketFactory((LayeredConnectionSocketFactory)SSLUtil.getInsecureSSLConnectionSocketFactory()).build();
            respuestaKeys reskey = new respuestaKeys();
            log.info("paso 1");
            String daf = readJsonFromUrlNiubizGet2(client2, "https://www.niubizenlinea.com.pe/api/users/login/keys", user_id);
            respuestaKeys keys = (respuestaKeys)(new Gson()).fromJson(daf, reskey.getClass());
            log.info("paso 11");
            objetoKeys solicitud = new objetoKeys();
            solicitud.setC(keys.getKeys().getC());
            solicitud.setP(keys.getKeys().getP());
            solicitud.setPasssword_pos(password);
            solicitud.setUsuario_pos(correo);
            tokenNiubiz objetod = new tokenNiubiz();
            log.info("paso 2");
            objetod = (tokenNiubiz)(new Gson()).fromJson(readJsonFromUrlNiubizPost2(client2, "http://localhost:8000", (new Gson()).toJson(solicitud), user_id), objetod.getClass());
            envioToken envio = new envioToken();
            envio.setData(objetod.getToken());
            envio.setHashRequest(keys.getHash());
            respuestaToken rpta = new respuestaToken();
            log.info("paso 3");
            rpta = (respuestaToken)(new Gson()).fromJson(readJsonFromUrlNiubizPost2(client2, "https://www.niubizenlinea.com.pe/api/users/login", (new Gson()).toJson(envio), user_id), rpta.getClass());
            log.info("paso 4");
            String data = readJsonFromUrlGetNiubiz(client2, "https://www.niubizenlinea.com.pe/api/commerces?userId=" + identificador + "&ruc=" + ruc + "&currencyCode=604", rpta.getAccesstoken(), user_id);
            Type listTypeComerciosNiubiz = (new TypeToken<Collection<ComerciosNiubiz>>() {

            }).getType();
            ArrayList<ComerciosNiubiz> negocios = (ArrayList<ComerciosNiubiz>)(new Gson()).fromJson(data, listTypeComerciosNiubiz);
            ArrayList<String> lista_negocios = new ArrayList<>();
            for (int i = 0; i < negocios.size(); i++)
                lista_negocios.add(((ComerciosNiubiz)negocios.get(i)).getCode());
            PeticionNiubiz jsonPeticion = new PeticionNiubiz();
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatter3 = new SimpleDateFormat("dd/MM/yyyy hh:mm aaa");
            cal.setTime(new Date());
            cal.set(11, 0);
            cal.set(12, 0);
            cal.set(13, 0);
            cal.set(14, 0);
            cal.add(5, dias);
            jsonPeticion.setRuc(ruc);
            jsonPeticion.setCurrencyCode("604");
            jsonPeticion.setStartDate(formatter.format(cal.getTime()));
            jsonPeticion.setEndDate(formatter.format(cal.getTime()));
            jsonPeticion.setCommerceCodes(lista_negocios);
            jsonPeticion.setGroupedRuc("S");
            String body = (new Gson()).toJson(jsonPeticion);
            log.info("paso 5");
            log.info(body);
            log.info(rpta.getAccesstoken());
            log.info(user_id);
            String datax = readJsonFromUrlPostNiubiz(client2, "https://www.niubizenlinea.com.pe/api/deposits/summary/details", body, rpta.getAccesstoken(), user_id);
            log.info("paso 51");
            log.info(datax);
            respuestaNiubiz respuesta = new respuestaNiubiz();
            respuesta = (respuestaNiubiz)(new Gson()).fromJson(datax, respuesta.getClass());
            boolean corto = false;
            ArrayList<CabeceraNiubiz> lista_cabeceras = respuesta.getData().getDepositsSummaryDetailsItems();
            int nro_operaciones = 0;
            for (int j = 0; j < lista_cabeceras.size(); j++)
                nro_operaciones += ((CabeceraNiubiz)lista_cabeceras.get(j)).getOperationNumbers();
            if (nro_operaciones > 1000) {
                corto = false;
            } else {
                corto = true;
                log.info("paso 6");
                String data2 = readJsonFromUrlPostNiubiz(client2, "https://www.niubizenlinea.com.pe/api/deposits/details", body, rpta.getAccesstoken(), user_id);
                respuesta = new respuestaNiubiz();
                respuesta = (respuestaNiubiz)(new Gson()).fromJson(data2, respuesta.getClass());
            }
            if (corto) {
                String linea = "Reporte:Reporte Mis dep\nFecha desde:" + formatter2.format(cal.getTime()) + "\nFecha hasta:" + formatter2.format(cal.getTime()) + "\nGenerado el:" + formatter3.format(new Date()) + "\nMoneda:Soles\nRUC:" + ruc + "\n\n";
                linea = linea + "RUC,RazSocial,CComercio,Nombre Comercial,Fecha y Hora de Operacide depde OperaciTarjeta,Tipo de Tarjeta,Marca de Tarjeta,Moneda,Importe de OperaciDCC,Monto DCC,ComisiTotal,ComisiNiubiz,IGV,Suma Depositada,Estado,ID OperaciBanco Pagador,Banco Pagador,\n";
                ArrayList<depositosNiubiz> depositos = respuesta.getData().getDepositsDetailsItems();
                for (int k = 0; k < depositos.size(); k++)
                    linea = linea + ((depositosNiubiz)depositos.get(k)).getRuc() + "," + ((depositosNiubiz)depositos.get(k)).getBusinessName() + "," + ((depositosNiubiz)depositos.get(k)).getCommerceCode() + "," + ((depositosNiubiz)depositos.get(k)).getTradename() + "," + ((depositosNiubiz)depositos.get(k)).getOperationDate() + "," + ((depositosNiubiz)depositos.get(k)).getDepositDate() + "," + ((depositosNiubiz)depositos.get(k)).getProduct() + "," + ((depositosNiubiz)depositos.get(k)).getDescription() + "," + ((depositosNiubiz)depositos.get(k)).getCardNumber() + "," + ((depositosNiubiz)depositos.get(k)).getCardOrigin() + "," + ((depositosNiubiz)depositos.get(k)).getTypeCard() + "," + ((depositosNiubiz)depositos.get(k)).getBrandCard() + "," + ((depositosNiubiz)depositos.get(k)).getCurrency() + "," + ((depositosNiubiz)depositos.get(k)).getSales() + "," + ((depositosNiubiz)depositos.get(k)).getEsDcc() + "," + ((depositosNiubiz)depositos.get(k)).getAmountDcc() + "," + ((depositosNiubiz)depositos.get(k)).getCommissions() + "," + ((depositosNiubiz)depositos.get(k)).getNiubizCommision() + "," + ((depositosNiubiz)depositos.get(k)).getIgv() + "," + ((depositosNiubiz)depositos.get(k)).getResult() + "," + ((depositosNiubiz)depositos.get(k)).getState() + "," + ((depositosNiubiz)depositos.get(k)).getOperationId() + "," + ((depositosNiubiz)depositos.get(k)).getPayingBankAccount() + "," + ((depositosNiubiz)depositos.get(k)).getPayingBank() + ",\n";
                SimpleDateFormat formatter_nombre = new SimpleDateFormat("yyyyMMdd");
                String nombre_archivo = formatter_nombre.format(cal.getTime()) + "-" + negocio + ".txt";
                InputStream s_produccion = new ByteArrayInputStream(linea.getBytes(StandardCharsets.UTF_8));
                //envioFtp(s_produccion, "/liqtarjetas/niubiz/" + nombre_archivo);
                envioFtp(s_produccion, nombre_archivo);
            } else {
                jsonPeticion.setTypeFile("TXT");
                jsonPeticion.setUserId(identificador);
                jsonPeticion.setGroupedRuc(null);
                body = (new Gson()).toJson(jsonPeticion);
                log.info("paso 7");
                datax = readJsonFromUrlPostNiubiz(client2, "https://www.niubizenlinea.com.pe/api/deposits/details/download/schedule", body, rpta.getAccesstoken(), user_id);
                Thread.sleep(5000L);
                respuestaNiubiz2 respuesta2 = new respuestaNiubiz2();
                respuesta2 = (respuestaNiubiz2)(new Gson()).fromJson(datax, respuesta2.getClass());
                respuesta2.getData().getIdProcess();
                jsonPeticion = new PeticionNiubiz();
                jsonPeticion.setUserId(identificador);
                jsonPeticion.setName("");
                body = (new Gson()).toJson(jsonPeticion);
                String codigo_respuesta = "I";
                DownloadItem item = new DownloadItem();
                while (!codigo_respuesta.equals("T")) {
                    log.info("paso 8");
                    datax = readJsonFromUrlPostNiubiz(client2, "https://www.niubizenlinea.com.pe/api/downloads/filters", body, rpta.getAccesstoken(), user_id);
                    RespuestaDescarga respuesta3 = new RespuestaDescarga();
                    respuesta3 = (RespuestaDescarga)(new Gson()).fromJson(datax, respuesta3.getClass());
                    for (int k = 0; k < respuesta3.getDownloadsList().size(); k++) {
                        if (respuesta2.getData().getIdProcess().equals(((DownloadItem)respuesta3.getDownloadsList().get(k)).getRespuestaId())) {
                            item = respuesta3.getDownloadsList().get(k);
                            codigo_respuesta = ((DownloadItem)respuesta3.getDownloadsList().get(k)).getDownloadStatus().getCode();
                            break;
                        }
                    }
                    if (respuesta3.getDownloadsList().size() == 0)
                        break;
                    Thread.sleep(60000L);
                }
                log.info("paso 9");
                log.info("Descargando https://www.niubizenlinea.com.pe/api/downloads/file/" + item.getId());
                InputStream is = download(client, "https://www.niubizenlinea.com.pe/api/downloads/file/" + item.getId(), rpta.getAccesstoken(), user_id);
                log.info("Descargo" + item.getId());
                SimpleDateFormat formatter_nombre = new SimpleDateFormat("yyyyMMdd");
                String nombre_archivo = formatter_nombre.format(cal.getTime()) + "-" + negocio + ".txt";
                //envioFtp(is, "/liqtarjetas/niubiz/" + nombre_archivo);
                envioFtp(is, nombre_archivo);
                log.info("fin");
            }
            client.close();
        } catch (Exception e) {
            log.info(e.getMessage());
            log.info(e.getMessage());
        }
    }

    public void listarExpressNet(int meses, String ruc, String usuario, String password, String negocio) {
        try {
            PeticionExpressNet jsonPeticion = new PeticionExpressNet();
            Calendar cal = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatter_nombre = new SimpleDateFormat("yyyyMMdd");
            SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatter3 = new SimpleDateFormat("dd/MM/yyyy hh:mm aaa");
            cal.setTime(new Date());
            cal.set(11, 0);
            cal.set(12, 0);
            cal.set(13, 0);
            cal.set(14, 0);
            cal.add(2, meses);
            cal2.setTime(new Date());
            cal2.set(11, 0);
            cal2.set(12, 0);
            cal2.set(13, 0);
            cal2.set(14, 0);
            cal2.add(5, meses);
            jsonPeticion.setStateId("0");
            jsonPeticion.setNumberCard("");
            jsonPeticion.setStarDate(formatter.format(cal.getTime()));
            jsonPeticion.setEndDate(formatter.format(new Date()));
            ArrayList<String> codigos = new ArrayList<>();
            jsonPeticion.setCodes(codigos);
            jsonPeticion.setNetwork("-1");
            jsonPeticion.setRuc(ruc);
            String body = (new Gson()).toJson(jsonPeticion);
            InputStream is = readJsonFromUrlPostExpressNet("https://sales.expressnet.pe/api/v1/Sales/export?pageSize=10000&pageIndex=1&type=xlsx", body, usuario, password);
            String nombre_archivo = formatter_nombre.format(cal2.getTime()) + "-" + negocio + ".xlsx";
            //envioFtp(is, "/liqtarjetas/amex/" + nombre_archivo);
            envioFtp(is, nombre_archivo);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    public void envioFtp(InputStream archivo, String ruta) {
        String server = "10.100.150.25";
        int port = 21;
        String user = "Generador";
        String pass = "GenSap2021!$%";
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(2);
            log.info("Subiendo archivo");
            boolean done = ftpClient.storeFile(ruta, archivo);
            archivo.close();
            if (done)
                log.info("Archivo a sido subido.");
        } catch (IOException ex) {
            log.info("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public String readJsonFromUrlPost(String url, String Jsonbody, String token) throws IOException {
        CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(url);
        StringEntity requestEntity = new StringEntity(Jsonbody, ContentType.APPLICATION_JSON);
        request.setEntity((HttpEntity)requestEntity);
        request.setHeader("Authorization", "Bearer " + token);
        HttpResponse response = closeableHttpClient.execute((HttpUriRequest)request);
        HttpEntity entity = response.getEntity();
        InputStream is = entity.getContent();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = (new Util()).readAll(rd);
            return jsonText;
        } finally {
            is.close();
        }
    }

    public String readJsonFromUrlPostTokenExpressNet(String url, String usuario, String password) throws IOException {
        CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(url);
        List<NameValuePair> params = new ArrayList<>(6);
        params.add(new BasicNameValuePair("grant_type", "password"));
        params.add(new BasicNameValuePair("username", usuario));
        params.add(new BasicNameValuePair("password", password));
        params.add(new BasicNameValuePair("client_id", "vue"));
        params.add(new BasicNameValuePair("client_secret", "secret"));
        params.add(new BasicNameValuePair("scope", "openid profiles sales report roles data state helpcenter cms"));
        request.setEntity((HttpEntity)new UrlEncodedFormEntity(params, "UTF-8"));
        HttpResponse response = closeableHttpClient.execute((HttpUriRequest)request);
        HttpEntity entity = response.getEntity();
        InputStream is = entity.getContent();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = (new Util()).readAll(rd);
            respuestaTokenExpressNet llave = new respuestaTokenExpressNet();
            llave = (respuestaTokenExpressNet)(new Gson()).fromJson(jsonText, llave.getClass());
            return llave.getAccess_token();
        } finally {
            is.close();
        }
    }

    public String readJsonFromUrlGet(CloseableHttpClient client, String url, String Jsonbody, String token) throws IOException {
        HttpGet request = new HttpGet(url);
        request.setHeader("Authorization", "Bearer " + token);
        CloseableHttpResponse closeableHttpResponse = client.execute((HttpUriRequest)request);
        HttpEntity entity = closeableHttpResponse.getEntity();
        InputStream is = entity.getContent();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = (new Util()).readAll(rd);
            return jsonText;
        } finally {
            is.close();
        }
    }

    public String readJsonFromUrlPost2(CloseableHttpClient client, String url, String Jsonbody, String cripto) throws IOException {
        HttpPost request = new HttpPost(url);
        StringEntity requestEntity = new StringEntity(Jsonbody, ContentType.APPLICATION_JSON);
        request.setEntity((HttpEntity)requestEntity);
        request.setHeader("x-app-id", "bafbbd946ade11ea98e20ee7c6890289");
        request.setHeader("x-crypto-id", cripto);
        CloseableHttpResponse closeableHttpResponse = client.execute((HttpUriRequest)request);
        HttpEntity entity = closeableHttpResponse.getEntity();
        InputStream is = entity.getContent();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = (new Util()).readAll(rd);
            return jsonText;
        } finally {
            is.close();
        }
    }

    public String readJsonFromUrlHead(CloseableHttpClient client, String url) throws IOException {
        HttpHead request = new HttpHead(url);
        request.setHeader("x-app-id", "bafbbd946ade11ea98e20ee7c6890289");
        CloseableHttpResponse closeableHttpResponse = client.execute((HttpUriRequest)request);
        Header[] cabeceras = closeableHttpResponse.getAllHeaders();
        Header[] cab = closeableHttpResponse.getHeaders("x-crypto-id");
        return cab[0].getValue();
    }

    public String readJsonFromUrlGetNiubiz(OkHttpClient client, String url, String autorizacion, String user_key) throws Exception {
        Request request = (new Request.Builder()).url(url).addHeader("user-key", user_key).addHeader("Authorization", "Bearer " + autorizacion).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String readJsonFromUrlNiubizGet2(OkHttpClient client, String url, String user_key) throws Exception {
        Request request = (new Request.Builder()).url(url).addHeader("user-key", user_key).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String readJsonFromUrlNiubizPost2(OkHttpClient client, String url, String Jsonbody, String user_key) throws IOException {
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"), Jsonbody);
        Request request = (new Request.Builder()).url(url).addHeader("user-key", user_key).post(body).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String readJsonFromUrlPostNiubiz(OkHttpClient client, String url, String autorizacion, String user_key) throws Exception {
        Request request = (new Request.Builder()).url(url).addHeader("user-key", user_key).addHeader("Authorization", "Bearer " + autorizacion).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String readJsonFromUrlPostNiubiz(OkHttpClient client, String url, String Jsonbody, String autorizacion, String user_key) throws Exception {
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"), Jsonbody);
        Request request = (new Request.Builder()).url(url).addHeader("Authorization", "Bearer " + autorizacion).addHeader("user-key", user_key).post(body).build();
        Response response = client.newCall(request).execute();
        String res = response.body().string();
        return res;
    }

    public InputStream readJsonFromUrlPostExpressNet(String url, String Jsonbody, String usuario, String password) throws IOException {
        CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(url);
        String autorizacion = readJsonFromUrlPostTokenExpressNet("https://identity.expressnet.pe/connect/token", usuario, password);
        StringEntity requestEntity = new StringEntity(Jsonbody, ContentType.APPLICATION_JSON);
        request.setEntity((HttpEntity)requestEntity);
        request.setHeader("Authorization", "Bearer " + autorizacion);
        HttpResponse response = closeableHttpClient.execute((HttpUriRequest)request);
        HttpEntity entity = response.getEntity();
        InputStream is = entity.getContent();
        return is;
    }

    public InputStream readJsonFromUrlGetFileNiubiz(String url, String Jsonbody, String autorizacion, String user_key) throws Exception {
        CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        request.setHeader("Authorization", "Bearer " + autorizacion);
        request.setHeader("user-key", user_key);
        HttpResponse response = closeableHttpClient.execute((HttpUriRequest)request);
        Thread.sleep(5000L);
        HttpEntity entity = response.getEntity();
        InputStream is = entity.getContent();
        return is;
    }

    public InputStream download(CloseableHttpClient client, String url, String autorizacion, String user_key) {
        InputStream is_respuesta = null;
        InputStream is = null;
        try {
            HttpGet request = new HttpGet(url);
            request.setHeader("Authorization", "Bearer " + autorizacion);
            request.setHeader("user-key", user_key);
            CloseableHttpResponse closeableHttpResponse = client.execute((HttpUriRequest)request);
            HttpEntity entity = closeableHttpResponse.getEntity();
            int responseCode = closeableHttpResponse.getStatusLine().getStatusCode();
            is = entity.getContent();
            String filePath = "file.zip";
            FileOutputStream fos = new FileOutputStream(new File(filePath));
            int inByte;
            while ((inByte = is.read()) != -1)
                fos.write(inByte);
            is.close();
            fos.close();
            client.close();
            ZipFile zipFile = new ZipFile(filePath);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                is_respuesta = zipFile.getInputStream(entry);
            }
            log.info("File Download Completed!!!");
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return is_respuesta;
    }

    public void copiarArchivo(InputStream s_produccion, String nombre_archivo){
        try {
            IOUtils.copy(s_produccion, new FileOutputStream("E:\\archivosprod\\" + nombre_archivo));
        } catch (IOException e) {
            log.error(e);
        }
    }
}
