package ResponsiPbo.main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import ResponsiPbo.service.KoronaDao;

public class KoronaDaoImpl implements KoronaDao {

    private Connection connection;

    private final String insertDaerah = "INSERT INTO daerah (Nama,Status) VALUES (?,?)";

    private final String insertStatistik = "INSERT INTO statistik (ID_daerah,Positif,ODP,PDP) VALUES ((SELECT MAX(ID_daerah) FROM daerah),?,?,?)";

    private final String updateDaerah = "UPDATE daerah SET Nama=?, Status=? WHERE ID_daerah=?";

    private final String updateStatistik = "UPDATE statistik SET Positif=?, ODP=?, PDP=? WHERE ID_daerah=?";

    private final String deleteDaerah = "DELETE FROM daerah WHERE ID_daerah=?";

    private final String deleteStatistik = "DELETE FROM statistik WHERE ID_daerah=?";

    private final String getByIdDaerah = "SELECT daerah.ID_daerah, daerah.Nama, daerah.Status, statistik.Positif, statistik.ODP, statistik.PDP FROM daerah"
            + " LEFT JOIN statistik ON daerah.ID_daerah = statistik.ID_daerah WHERE daerah.ID_daerah=?";

    private final String selectAll = "SELECT * FROM daerah LEFT JOIN statistik ON daerah.ID_daerah = statistik.ID_daerah";

    public KoronaDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertData(DataKorona dataKorona) throws KoronaException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(insertDaerah, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, dataKorona.getNamaDaerah());
            statement.setString(2, dataKorona.getStatus());
            statement.executeUpdate();
            
            ResultSet result = statement.getGeneratedKeys();
            if(result.next()){
                dataKorona.setIdDaerah(result.getInt(1));
            }
            
            statement = connection.prepareStatement(insertStatistik);
            statement.setInt(1, dataKorona.getPositif());
            statement.setInt(2, dataKorona.getOdp());
            statement.setInt(3, dataKorona.getPdp());
            statement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new KoronaException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }

    }

    @Override
    public void updateData(DataKorona dataKorona) throws KoronaException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(updateDaerah);
            statement.setString(1, dataKorona.getNamaDaerah());
            statement.setString(2, dataKorona.getStatus());
            statement.setInt(3, dataKorona.getIdDaerah());
            statement.executeUpdate();
            
            statement = connection.prepareStatement(updateStatistik);
            statement.setInt(1, dataKorona.getPositif());
            statement.setInt(2, dataKorona.getOdp());
            statement.setInt(3, dataKorona.getPdp());
            statement.setInt(4, dataKorona.getIdDaerah());
            statement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new KoronaException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public void deleteData(int idDaerah) throws KoronaException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteDaerah);
            statement.setInt(1, idDaerah);
            statement.executeUpdate();
            
            statement = connection.prepareStatement(deleteStatistik);
            statement.setInt(1, idDaerah);
            statement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new KoronaException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public DataKorona getData(int idDaerah) throws KoronaException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(getByIdDaerah);
            statement.setInt(1, idDaerah);

            ResultSet result = statement.executeQuery();
            DataKorona dataKorona = null;

            if (result.next()) {
                dataKorona = new DataKorona();
                dataKorona.setNamaDaerah(result.getString("Nama"));
                dataKorona.setStatus(result.getString("Status"));
                dataKorona.setPositif(result.getInt("Positif"));
                dataKorona.setOdp(result.getInt("ODP"));
                dataKorona.setPdp(result.getInt("PDP"));

            } else {
                throw new KoronaException("Data " + idDaerah + " Tidak Ditemukan!");
            }
            connection.commit();

            return dataKorona;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new KoronaException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public List<DataKorona> selectAllData() throws KoronaException {
        Statement statement = null;
        List<DataKorona> list = new ArrayList<DataKorona>();
        try {
            connection.setAutoCommit(false);

            statement = connection.createStatement();

            ResultSet result = statement.executeQuery(selectAll);
            DataKorona dataKorona;

            while (result.next()) {
                dataKorona = new DataKorona();
                dataKorona.setIdDaerah(result.getInt("ID_daerah"));
                dataKorona.setNamaDaerah(result.getString("Nama"));
                dataKorona.setStatus(result.getString("Status"));
                dataKorona.setPositif(result.getInt("Positif"));
                dataKorona.setOdp(result.getInt("ODP"));
                dataKorona.setPdp(result.getInt("PDP"));
                list.add(dataKorona);
            }
            connection.commit();

            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new KoronaException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}
