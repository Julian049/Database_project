public class Main {
    public static void main(String[] args) {
        ConnectionPostgres con = new ConnectionPostgres();
        con.connect();
        con.executeQuery("select * from artists");
    }
}