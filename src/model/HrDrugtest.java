package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HR_DRUGTEST database table.
 * 
 */
@Entity
@Table(name="HR_DRUGTEST")
@NamedQuery(name="HrDrugtest.findAll", query="SELECT h FROM HrDrugtest h")
public class HrDrugtest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long drugtestid;

	private String alcoholtest;

	private String dottest;

	private String standardpaneltest;

	//bi-directional many-to-one association to HrApplicant
	@ManyToOne
	@JoinColumn(name="APPLICANTID")
	private HrApplicant hrApplicant;

	public HrDrugtest() {
	}

	public long getDrugtestid() {
		return this.drugtestid;
	}

	public void setDrugtestid(long drugtestid) {
		this.drugtestid = drugtestid;
	}

	public String getAlcoholtest() {
		return this.alcoholtest;
	}

	public void setAlcoholtest(String alcoholtest) {
		this.alcoholtest = alcoholtest;
	}

	public String getDottest() {
		return this.dottest;
	}

	public void setDottest(String dottest) {
		this.dottest = dottest;
	}

	public String getStandardpaneltest() {
		return this.standardpaneltest;
	}

	public void setStandardpaneltest(String standardpaneltest) {
		this.standardpaneltest = standardpaneltest;
	}

	public HrApplicant getHrApplicant() {
		return this.hrApplicant;
	}

	public void setHrApplicant(HrApplicant hrApplicant) {
		this.hrApplicant = hrApplicant;
	}

}