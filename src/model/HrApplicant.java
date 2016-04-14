package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the HR_APPLICANT database table.
 * 
 */
@Entity
@Table(name="HR_APPLICANT")
@NamedQuery(name="HrApplicant.findAll", query="SELECT h FROM HrApplicant h")
public class HrApplicant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long applicantid;

	private String address;

	private String applicantname;

	@Temporal(TemporalType.DATE)
	private Date birthdate;

	private String citizenstatus;

	private String drugtestresult;

	private String education;

	private String jobhistory;

	private String jobreference;

	private String veteranstatus;

	//bi-directional many-to-one association to HrDrugtest
	@OneToMany(mappedBy="hrApplicant")
	private List<HrDrugtest> hrDrugtests;

	//bi-directional many-to-one association to HrInterviewtable
	@OneToMany(mappedBy="hrApplicant")
	private List<HrInterviewtable> hrInterviewtables;

	public HrApplicant() {
	}

	public long getApplicantid() {
		return this.applicantid;
	}

	public void setApplicantid(long applicantid) {
		this.applicantid = applicantid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getApplicantname() {
		return this.applicantname;
	}

	public void setApplicantname(String applicantname) {
		this.applicantname = applicantname;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getCitizenstatus() {
		return this.citizenstatus;
	}

	public void setCitizenstatus(String citizenstatus) {
		this.citizenstatus = citizenstatus;
	}

	public String getDrugtestresult() {
		return this.drugtestresult;
	}

	public void setDrugtestresult(String drugtestresult) {
		this.drugtestresult = drugtestresult;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getJobhistory() {
		return this.jobhistory;
	}

	public void setJobhistory(String jobhistory) {
		this.jobhistory = jobhistory;
	}

	public String getJobreference() {
		return this.jobreference;
	}

	public void setJobreference(String jobreference) {
		this.jobreference = jobreference;
	}

	public String getVeteranstatus() {
		return this.veteranstatus;
	}

	public void setVeteranstatus(String veteranstatus) {
		this.veteranstatus = veteranstatus;
	}

	public List<HrDrugtest> getHrDrugtests() {
		return this.hrDrugtests;
	}

	public void setHrDrugtests(List<HrDrugtest> hrDrugtests) {
		this.hrDrugtests = hrDrugtests;
	}

	public HrDrugtest addHrDrugtest(HrDrugtest hrDrugtest) {
		getHrDrugtests().add(hrDrugtest);
		hrDrugtest.setHrApplicant(this);

		return hrDrugtest;
	}

	public HrDrugtest removeHrDrugtest(HrDrugtest hrDrugtest) {
		getHrDrugtests().remove(hrDrugtest);
		hrDrugtest.setHrApplicant(null);

		return hrDrugtest;
	}

	public List<HrInterviewtable> getHrInterviewtables() {
		return this.hrInterviewtables;
	}

	public void setHrInterviewtables(List<HrInterviewtable> hrInterviewtables) {
		this.hrInterviewtables = hrInterviewtables;
	}

	public HrInterviewtable addHrInterviewtable(HrInterviewtable hrInterviewtable) {
		getHrInterviewtables().add(hrInterviewtable);
		hrInterviewtable.setHrApplicant(this);

		return hrInterviewtable;
	}

	public HrInterviewtable removeHrInterviewtable(HrInterviewtable hrInterviewtable) {
		getHrInterviewtables().remove(hrInterviewtable);
		hrInterviewtable.setHrApplicant(null);

		return hrInterviewtable;
	}

}