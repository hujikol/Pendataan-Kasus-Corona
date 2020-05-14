package ResponsiPbo.database;

import com.mysql.cj.jdbc.MysqlDataSource;
import ResponsiPbo.main.KoronaDaoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import ResponsiPbo.service.KoronaDao;

public class Database {

    private static Connection connection;
    private static KoronaDao koronaDao;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/responsidb");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
        }

        return connection;
    }

    public static KoronaDao getKoronaDao() throws SQLException {

        if (koronaDao == null) {
            koronaDao = new KoronaDaoImpl(getConnection());
        }

        return koronaDao;
    }

}
