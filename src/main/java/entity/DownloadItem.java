package entity;

public class DownloadItem {
    DownloadStatus downloadStatus;

    String respuestaId;

    String _id;

    public DownloadItem() {}

    public DownloadItem(DownloadStatus downloadStatus, String _id) {
        this.downloadStatus = downloadStatus;
        this._id = _id;
    }

    public String getRespuestaId() {
        return this.respuestaId;
    }

    public void setRespuestaId(String respuestaId) {
        this.respuestaId = respuestaId;
    }

    public DownloadStatus getDownloadStatus() {
        return this.downloadStatus;
    }

    public void setDownloadStatus(DownloadStatus downloadStatus) {
        this.downloadStatus = downloadStatus;
    }

    public String getId() {
        return this._id;
    }

    public void setId(String _id) {
        this._id = _id;
    }
}
