import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;

public class SimpleLettuceMain {
    public static void main(String[] args) {
        RedisClient redisClient = RedisClient.create("redis://localhost/0");
        StatefulRedisConnection<String, String> connection = redisClient.connect();

        System.out.println("Connected to Redis");
        connection.sync().set("k1", "Hello World");
        System.out.println("Key from redis k1: " + connection.sync().get("k1"));

        connection.close();
        redisClient.shutdown();
    }
}
