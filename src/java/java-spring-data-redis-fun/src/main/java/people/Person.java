package people;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("players")
public class Person{
    @Id String id;
    String name;

    public Person(){}

    public Person(String id,String name){
        this.id=id;
        this.name=name;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "id: " + id + " name: " + name;
    }
}

