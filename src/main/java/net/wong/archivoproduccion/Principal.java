package net.wong.archivoproduccion;

import business_logic.BLProduccion;
import org.apache.log4j.Logger;
import util.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principal {
    private static Logger log = Logger.getLogger(Principal.class);
    public static void main(String[] args) throws Exception {
        String data = "";
        try {
            File myObj = new File("token_arisale.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                log.info(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            log.info("An error occurred.");
            e.printStackTrace();
        }
        (new BLProduccion()).listarArisale(-1, data);
        (new BLProduccion()).listarDonBuffet(-1);
        (new BLProduccion()).listarPapas(-1);
        (new BLProduccion()).listarMediterraneo(-1);
    }
}
