package ResponsiPbo.service;

import ResponsiPbo.main.DataKorona;
import ResponsiPbo.main.KoronaException;

import java.util.List;

public interface KoronaDao {

    public void insertData(DataKorona dataKorona) throws KoronaException;

    public void updateData(DataKorona dataKorona) throws KoronaException;

    public void deleteData(int idDaerah) throws KoronaException;

    public DataKorona getData(int idDaerah) throws KoronaException;

    public List<DataKorona> selectAllData() throws KoronaException;
}
