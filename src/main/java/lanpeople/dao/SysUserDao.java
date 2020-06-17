package lanpeople.dao;

import lanpeople.pojo.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserDao {
    /**
     * 根据用户名查询信息
     * @param loginName
     * @return
     */
    SysUser queryByLoginName(String loginName);
}
