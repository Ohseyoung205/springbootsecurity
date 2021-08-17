package oh.sy.springbootjdbc;


import oh.sy.springbootjdbc.account.RedisAccount;
import oh.sy.springbootjdbc.account.RedisAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RedisRunner implements ApplicationRunner {

    @Autowired
    StringRedisTemplate redisTemplate;


    @Autowired
    RedisAccountRepository redisAccountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ValueOperations<String,String>values  = redisTemplate.opsForValue();
        values.set("oh","seyoung");
        values.set("go","naver");

        RedisAccount redisAccount = new RedisAccount();
        redisAccount.setUsername("redis-ohsy");
        redisAccount.setEmail("123@naever.com");

        redisAccountRepository.save(redisAccount);

        Optional<RedisAccount> optionalRedisAccount  = redisAccountRepository.findById(redisAccount.getId());
        System.out.println(optionalRedisAccount.get().getUsername());
        System.out.println(optionalRedisAccount.get().getEmail());


    }
}
