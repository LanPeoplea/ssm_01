package lanpeople.pojo;

public class SysUser {
    private Integer userId;
	private String loginName;
    private String password;
    private String lastLoginTime;
    private String lastLoginIp;
	private Integer status;

    public SysUser() {
    }

    public SysUser(Integer userId, String loginName, String password, String lastLoginTime, String lastLoginIp, Integer status) {
        this.userId = userId;
        this.loginName = loginName;
        this.password = password;
        this.lastLoginTime = lastLoginTime;
        this.lastLoginIp = lastLoginIp;
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userId=" + userId +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", status=" + status +
                '}';
    }
}
