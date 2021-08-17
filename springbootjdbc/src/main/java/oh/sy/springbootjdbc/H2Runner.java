package oh.sy.springbootjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;


@Component
public class H2Runner implements ApplicationRunner {

    @Autowired
    DataSource dataSource;

    @Autowired // 사용하길 권장
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
    try(
        Connection connection = dataSource.getConnection()) {
        System.out.println(connection.getMetaData().getURL());
        System.out.println(connection.getMetaData().getUserName());
        Statement statement = connection.createStatement();
        //String sql = "CREATE TABLE USER (ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))";

        //statement.executeUpdate(sql);
         //   connection.close();
        }

        //jdbcTemplate.execute("insert into user values (1, 'seyoung')");

    }
}
