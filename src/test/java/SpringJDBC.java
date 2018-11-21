import com.lhl.model.User;
import com.lhl.service.UserService;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SpringJDBC {
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: getUser(String username)
     *
     */
    @Test
    public void TestJDBC() throws Exception {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/web17?useUnicode=true&characterEncoding=utf8");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        String sql1 = "SELECT * " + "FROM tbl_user";
        List<User> l=jdbcTemplate.query(sql1, new RowMapper<User>() {
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user=new User();
                user.setId(resultSet.getInt("id"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                return user;
            }
        });
        System.out.println(l);

        String sql="Insert into tbl_user values(null,'testspring','spring')";
        jdbcTemplate.update(sql);
    }
}

