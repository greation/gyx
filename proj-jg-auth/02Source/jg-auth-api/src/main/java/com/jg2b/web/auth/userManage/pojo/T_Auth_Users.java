package com.jg2b.web.auth.userManage.pojo;



public class T_Auth_Users{



	private String id;
    private String name;
    private String nickname;
    private String fullname;
    private String password;
    private String email;
    private String mobile;
    private String createtime;
    private String lastlogintime;
    private String lastloginhost;
    private String reghost;
    private String description;
    private String deleted;
    
    //扩展字段-盐（暂时默认公共盐）
    private String salt = "JG2B-CRM";

    public T_Auth_Users() {
    }

    public T_Auth_Users(String username, String password) {
        this.name = username;
        this.password = password;
    }

    
   

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
		return id;
	}

	public void setId(String iD) {
		id = iD;
	}
    public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getLastlogintime() {
		return lastlogintime;
	}

	public void setLastlogintime(String lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	public String getLastloginhost() {
		return lastloginhost;
	}

	public void setLastloginhost(String lastloginhost) {
		this.lastloginhost = lastloginhost;
	}

	public String getReghost() {
		return reghost;
	}

	public void setReghost(String reghost) {
		this.reghost = reghost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getSalt() {
        return salt;
    }


    public String getCredentialsSalt() {
        return name + salt;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        T_Auth_Users user = (T_Auth_Users) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    
    @Override
	public String toString() {
		return "T_Auth_Users {id=" + id + ", name=" + name + ", nickname="
				+ nickname + ", fullname=" + fullname + ", password="
				+ password + ", email=" + email + ", mobile=" + mobile
				+ ", createtime=" + createtime + ", lastlogintime="
				+ lastlogintime + ", lastloginhost=" + lastloginhost
				+ ", reghost=" + reghost + ", description=" + description
				+ ", deleted=" + deleted + "}";
	}
}
