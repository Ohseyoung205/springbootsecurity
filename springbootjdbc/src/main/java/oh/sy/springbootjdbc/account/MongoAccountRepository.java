package oh.sy.springbootjdbc.account;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoAccountRepository extends MongoRepository<MongoAccount,String> {

}
