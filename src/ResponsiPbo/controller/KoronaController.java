/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResponsiPbo.controller;

import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ResponsiPbo.main.KoronaException;
import ResponsiPbo.model.KoronaModel;
import ResponsiPbo.view.KoronaView;

/**
 *
 * @author nicolas
 */
public class KoronaController {

    private KoronaModel model;

    public void setModel(KoronaModel model) {
        this.model = model;
    }

    public void resetData(KoronaView view) {
        model.resetData();
    }

    public void insertData(KoronaView view) {
        String namaDaerah = view.getInputNamaDaerah().getText();
        int odp = (int) view.getInputODP().getValue();
        int pdp = (int) view.getInputPDP().getValue();
        int positif = (int) view.getInputPositif().getValue();
        String status = "Zona Hijau";
        if (positif >= 1) {
            status = "Zona Merah";
        }

        if (namaDaerah.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Mohon Mengisi Nama Daerah!");
        } else if (namaDaerah.length() > 50) {
            JOptionPane.showMessageDialog(view, "Nama Daerah Tidak Bolah Lebih Dari 50 Karakter!");
        } else {
            model.setNamaDaerah(namaDaerah);
            model.setOdp(odp);
            model.setPdp(pdp);
            model.setPositif(positif);
            model.setStatus(status);
            
            try {
                model.insertData();
                JOptionPane.showMessageDialog(view, "Data Berhasil di Tambahkan!");
                model.resetData();
            } catch (HeadlessException | SQLException | KoronaException e) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error pada Database", e.getMessage()});
            }
        }
    }

    public void updateData(KoronaView view) {

        if (view.getTabelStatistik().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Mohon Pilih Data dari Tabel Terlebih Dahulu!");
            return;
        }
        
        int idDaerah = Integer.parseInt(view.getInputID().getText());
        String namaDaerah = view.getInputNamaDaerah().getText();
        int odp = (int) view.getInputODP().getValue();
        int pdp = (int) view.getInputPDP().getValue();
        int positif = (int) view.getInputPositif().getValue();
        String status = "Zona Hijau";
        if (positif >= 1) {
            status = "Zona Merah";
        }

        if (namaDaerah.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Mohon Mengisi Nama Daerah!");
        } else if (namaDaerah.length() > 50) {
            JOptionPane.showMessageDialog(view, "Nama Daerah Tidak Bolah Lebih Dari 50 Karakter!");
        } else {
            model.setIdDaerah(idDaerah);
            model.setNamaDaerah(namaDaerah);
            model.setOdp(odp);
            model.setPdp(pdp);
            model.setPositif(positif);
            model.setStatus(status);
            
            try {
                model.updateData();
                JOptionPane.showMessageDialog(view, "Data Berhasil di Perbarui!");
                model.resetData();
            } catch (HeadlessException | SQLException | KoronaException e) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error pada Database", e.getMessage()});
            }
        }
    }

    public void deleteData(KoronaView view) {

        if (view.getTabelStatistik().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Mohon Pilih Data dari Tabel Terlebih Dahulu!");
            return;
        }

        if (JOptionPane.showConfirmDialog(view, "Anda Yakin Akan Menghapus Data Ini?") == JOptionPane.OK_OPTION) {
            int idDaerah = Integer.parseInt(view.getInputID().getText());
            model.setIdDaerah(idDaerah);
            try {
                model.deleteData();
                JOptionPane.showMessageDialog(view, "Data Berhasil di Hapus!");
                model.resetData();
            } catch (HeadlessException | SQLException | KoronaException e) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error pada Database", e.getMessage()});
            }
        }
    }
}
