package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HR_ROLE database table.
 * 
 */
@Entity
@Table(name="HR_ROLE")
@NamedQuery(name="HrRole.findAll", query="SELECT h FROM HrRole h")
public class HrRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long roleid;

	private String rolename;

	//bi-directional many-to-one association to HrLogin
	@OneToMany(mappedBy="hrRole")
	private List<HrLogin> hrLogins;

	public HrRole() {
	}

	public long getRoleid() {
		return this.roleid;
	}

	public void setRoleid(long roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public List<HrLogin> getHrLogins() {
		return this.hrLogins;
	}

	public void setHrLogins(List<HrLogin> hrLogins) {
		this.hrLogins = hrLogins;
	}

	public HrLogin addHrLogin(HrLogin hrLogin) {
		getHrLogins().add(hrLogin);
		hrLogin.setHrRole(this);

		return hrLogin;
	}

	public HrLogin removeHrLogin(HrLogin hrLogin) {
		getHrLogins().remove(hrLogin);
		hrLogin.setHrRole(null);

		return hrLogin;
	}

}