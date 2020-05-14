package ResponsiPbo.main;

public class DataKorona {
    private int idDaerah;
    private String namaDaerah;
    private String status;
    private int odp;
    private int pdp;
    private int positif;

    public DataKorona(){}

    public DataKorona(String namaDaerah, String status, int odp, int pdp, int positif) {
        this.namaDaerah = namaDaerah;
        this.status = status;
        this.odp = odp;
        this.pdp = pdp;
        this.positif = positif;
    }

    public int getIdDaerah() {
        return idDaerah;
    }

    public void setIdDaerah(int idDaerah) {
        this.idDaerah = idDaerah;
    }

    public String getNamaDaerah() {
        return namaDaerah;
    }

    public void setNamaDaerah(String namaDaerah) {
        this.namaDaerah = namaDaerah;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOdp() {
        return odp;
    }

    public void setOdp(int odp) {
        this.odp = odp;
    }

    public int getPdp() {
        return pdp;
    }

    public void setPdp(int pdp) {
        this.pdp = pdp;
    }

    public int getPositif() {
        return positif;
    }

    public void setPositif(int positif) {
        this.positif = positif;
    }
    
}