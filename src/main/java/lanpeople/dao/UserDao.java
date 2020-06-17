package lanpeople.dao;


import lanpeople.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<User> queryAll();//查询所有信息
    int delete(String id);//删除信息
    User queryById(String id);//删除信息
    int update(User user);
    int add(User user);
}
