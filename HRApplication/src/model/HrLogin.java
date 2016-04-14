package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HR_LOGIN database table.
 * 
 */
@Entity
@Table(name="HR_LOGIN")
@NamedQuery(name="HrLogin.findAll", query="SELECT h FROM HrLogin h")
public class HrLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long loginid;

	private String password;

	private String username;

	//bi-directional many-to-one association to HrRole
	@ManyToOne
	@JoinColumn(name="ROLEID")
	private HrRole hrRole;

	public HrLogin() {
	}

	public long getLoginid() {
		return this.loginid;
	}

	public void setLoginid(long loginid) {
		this.loginid = loginid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public HrRole getHrRole() {
		return this.hrRole;
	}

	public void setHrRole(HrRole hrRole) {
		this.hrRole = hrRole;
	}

}