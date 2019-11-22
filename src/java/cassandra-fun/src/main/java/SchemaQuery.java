import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class SchemaQuery {
    public static void main(String[] args) {
        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        Session session = cluster.connect();
        try {
            session.execute("CREATE KEYSPACE cass_training " + 
                      "WITH replication = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };");
            System.out.println("Schema Created");
        }catch(Exception e){
        }

        try {
            session.execute("USE cass_training;");
            session.execute("CREATE TABLE user "
                          +" (fullName text PRIMARY KEY, email text);");
            System.out.println("Table Created");
        }catch(Exception e){
            System.out.println(e);
        }    

        try {
            session.execute("INSERT INTO user " + 
            "(fullName,email) VALUES ('Diego Pacheco','diego.pacheco@gmail.com');");
            System.out.println("row inserted.");
        }catch(Exception e){
            System.out.println(e);
        }    

        try {
            System.out.println("List data");
            ResultSet rs = session.execute("SELECT * from user;");
            for (Row row : rs) {
                System.out.println("Name: " + row.getString("fullName"));
                System.out.println("Mail: " + row.getString("email"));
            }
            System.out.println("row inserted.");
        }catch(Exception e){
            System.out.println(e);
        }    

        if (cluster != null)
            cluster.close();
    }
}

