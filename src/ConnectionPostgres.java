import java.sql.*;

public class ConnectionPostgres {

    private Connection connection;
    private String url;
    private String user;
    private String password;

    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            //Conexion a la base de datos en la nube
//            url = "jdbc:postgresql://switchback.proxy.rlwy.net:16520/railway";
//            user = "postgres";
//            password = "bIUXYVXwPAiaWKYWtgbZQdaYjvEoIVZw";

            //Conexion a la base de datos en local
            url = "jdbc:postgresql://localhost:5432/Project";
            user = "postgres";
            password = "postgres";
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            connection.close();
            System.out.println("Conexion finalizada");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("artist_id");
                String name = resultSet.getString("artist_name");
                System.out.println("El artista es \n");
                System.out.println("ID: " + id + ", Nombre: " + name);
            }

            resultSet.close();
            statement.close();
            close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
