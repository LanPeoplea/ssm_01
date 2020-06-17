import lanpeople.dao.UserDao;
import lanpeople.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserTest {

    @Autowired
    private SqlSessionTemplate template;

    @Autowired
    private UserDao userdao;

    @Test
    public void test(){
        List<User> rtnlist = template.selectList("student.queryAll",null);
        for (User user : rtnlist) {
            System.out.println(user);
        }
    }

    @Test
    public void test2(){
        List<User> rtnlist = userdao.queryAll();
        for (User user : rtnlist) {
            System.out.println(user);
        }
    }
}
