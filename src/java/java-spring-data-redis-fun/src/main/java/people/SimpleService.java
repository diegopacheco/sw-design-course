package people;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SimpleService {

    @Autowired
    RedisTemplate<String,String> redis;
  
    public Set<String> getAllPeople(String key) {
        return redis.opsForSet().members(key);
    }

}
