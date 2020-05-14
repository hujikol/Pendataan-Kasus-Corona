/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResponsiPbo.event;

import ResponsiPbo.main.DataKorona;
import ResponsiPbo.model.KoronaModel;

/**
 *
 * @author nicolas
 */
public interface KoronaListener {

    public void onChange(KoronaModel model);

    public void onInsert(DataKorona daraKorona);

    public void onUpdate(DataKorona dataKorona);

    public void onDelete();

}
