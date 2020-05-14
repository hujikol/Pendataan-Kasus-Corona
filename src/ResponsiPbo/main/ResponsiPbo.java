/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResponsiPbo.main;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import ResponsiPbo.view.MainView;

/**
 *
 * @author nicolas
 */
public class ResponsiPbo {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws ResponsiPbo.main.KoronaException
     */
    public static void main(String[] args) throws SQLException, KoronaException{
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainView penduduk = new MainView();
                    penduduk.loadDatabase();
                    penduduk.setVisible(true);
                } catch (SQLException e){
                    
                } catch (KoronaException ex) {
                    Logger.getLogger(ResponsiPbo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
