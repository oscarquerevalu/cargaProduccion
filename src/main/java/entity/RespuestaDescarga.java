package entity;

import java.util.ArrayList;

public class RespuestaDescarga {
    ArrayList<DownloadItem> downloadsList;

    public RespuestaDescarga() {}

    public RespuestaDescarga(ArrayList<DownloadItem> downloadsList) {
        this.downloadsList = downloadsList;
    }

    public ArrayList<DownloadItem> getDownloadsList() {
        return this.downloadsList;
    }

    public void setDownloadsList(ArrayList<DownloadItem> downloadsList) {
        this.downloadsList = downloadsList;
    }
}
