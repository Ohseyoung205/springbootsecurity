package oh.sy.springbootjdbc.account;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisAccountRepository extends CrudRepository<RedisAccount,String> {

}
