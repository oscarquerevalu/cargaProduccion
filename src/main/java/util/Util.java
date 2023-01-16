package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.log4j.Logger;

public class Util {
    private static Logger log = Logger.getLogger(Util.class);
    DataFormat format;

    public String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1)
            sb.append((char)cp);
        return sb.toString();
    }

    public void grabarArchivo(BufferedReader reader, BufferedWriter writer) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            log.info(line);
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }

    public void sendEmailFallo(ArrayList<String> correos, ArrayList<String> cc, String asunto) {
        try {
            if (correos.size() > 0) {
                MultiPartEmail email = new MultiPartEmail();
                email.setHostName("smtp.gmail.com");
                email.setSmtpPort(587);
                email.setStartTLSEnabled(true);
                email.setAuthentication("helpdesk@wong.net.pe", "P@ssword2021");
                email.setFrom("helpdesk@wong.net.pe");
                int i;
                for (i = 0; i < correos.size(); i++)
                    email.addTo(correos.get(i));
                for (i = 0; i < cc.size(); i++)
                    email.addCc(cc.get(i));
                email.setSubject(asunto);
                email.setMsg("Mensaje Automatico, no responder a este correo");
                email.send();
            }
        } catch (EmailException ex) {
            log.error(ex);
        }
    }
}
