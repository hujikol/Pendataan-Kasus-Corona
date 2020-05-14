/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResponsiPbo.model;

import ResponsiPbo.main.DataKorona;
import ResponsiPbo.main.KoronaException;
import java.sql.SQLException;
import ResponsiPbo.database.Database;
import ResponsiPbo.service.KoronaDao;
import ResponsiPbo.event.KoronaListener;

/**
 *
 * @author nicolas
 */
public class KoronaModel {

    private int idDaerah;
    private String namaDaerah;
    private String status;
    private int odp;
    private int pdp;
    private int positif;

    private KoronaListener listener;

    public KoronaListener getListener() {
        return listener;
    }

    public void setListener(KoronaListener listener) {
        this.listener = listener;
    }

    public int getIdDaerah() {
        return idDaerah;
    }

    public void setIdDaerah(int idDaerah) {
        this.idDaerah = idDaerah;
        fireOnChange();
    }

    public String getNamaDaerah() {
        return namaDaerah;
    }

    public void setNamaDaerah(String namaDaerah) {
        this.namaDaerah = namaDaerah;
        fireOnChange();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        fireOnChange();
    }

    public int getOdp() {
        return odp;
    }

    public void setOdp(int odp) {
        this.odp = odp;
        fireOnChange();
    }

    public int getPdp() {
        return pdp;
    }

    public void setPdp(int pdp) {
        this.pdp = pdp;
        fireOnChange();
    }

    public int getPositif() {
        return positif;
    }

    public void setPositif(int positif) {
        this.positif = positif;
        fireOnChange();
    }

    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    protected void fireOnInsert(DataKorona dataKorona) {
        if (listener != null) {
            listener.onInsert(dataKorona);
        }
    }

    protected void fireOnUpdate(DataKorona dataKorona) {
        if (listener != null) {
            listener.onUpdate(dataKorona);
        }
    }

    protected void fireOnDelete() {
        if (listener != null) {
            listener.onDelete();
        }
    }

    public void insertData() throws SQLException, KoronaException {
        KoronaDao dao = Database.getKoronaDao();
        DataKorona dataKorona = new DataKorona();
        dataKorona.setNamaDaerah(namaDaerah);
        dataKorona.setStatus(status);
        dataKorona.setOdp(odp);
        dataKorona.setPdp(pdp);
        dataKorona.setPositif(positif);

        dao.insertData(dataKorona);
        fireOnInsert(dataKorona);
    }

    public void updateData() throws SQLException, KoronaException {
        KoronaDao dao = Database.getKoronaDao();
        DataKorona dataKorona = new DataKorona();
        dataKorona.setNamaDaerah(namaDaerah);
        dataKorona.setStatus(status);
        dataKorona.setOdp(odp);
        dataKorona.setPdp(pdp);
        dataKorona.setPositif(positif);
        dataKorona.setIdDaerah(idDaerah);

        dao.updateData(dataKorona);
        fireOnUpdate(dataKorona);
    }

    public void deleteData() throws SQLException, KoronaException {
        KoronaDao dao = Database.getKoronaDao();
        dao.deleteData(getIdDaerah());
        fireOnDelete();
    }

    public void resetData() {
        setIdDaerah(0);
        setNamaDaerah("");
        setOdp(0);
        setPdp(0);
        setPositif(0);
    }

}
