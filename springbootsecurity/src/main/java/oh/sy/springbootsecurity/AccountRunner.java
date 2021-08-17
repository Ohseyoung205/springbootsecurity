package oh.sy.springbootsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountRunner implements ApplicationRunner {

    @Autowired
    AccountService accountService;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        Account user = accountService.createAccount("seyoung","1234");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

    }
}
