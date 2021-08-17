package oh.sy.springbootjdbc;

import oh.sy.springbootjdbc.account.MongoAccount;
import oh.sy.springbootjdbc.account.MongoAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class SpringbootjdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootjdbcApplication.class, args);
    }


    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    MongoAccountRepository mongoAccountRepository;

    @Bean
    public ApplicationRunner applicationRunner(){
        return args -> {
            MongoAccount account = new MongoAccount();
            account.setEmail("12345@naver.com");
            account.setUsername("mongo");
            //mongoTemplate.insert(account);

            System.out.println("finished");
            mongoAccountRepository.insert(account);
        };
    }


}
