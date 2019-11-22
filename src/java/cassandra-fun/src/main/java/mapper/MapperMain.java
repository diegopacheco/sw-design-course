package mapper;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.datastax.driver.mapping.Result;

public class MapperMain {
    public static void main(String[] args) {
        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        Session session = cluster.connect();

        MappingManager manager = new MappingManager(session);
        Mapper<User> mapper = manager.mapper(User.class);

        String name = "" + System.currentTimeMillis();
        User u = new User("John Cat N" + name, "cat" + name + "@cats.com");
        mapper.save(u);

        u = mapper.get("Diego Pacheco");
        System.out.println("user: " + u);

        System.out.println("Getting all users... ");
        ResultSet results = session.execute("SELECT * FROM cass_training.user");
        Result<User> users = mapper.map(results);
        for (User user : users) {
            System.out.println("User : " + user);
        }
    }
}
