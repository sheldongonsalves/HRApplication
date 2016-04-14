package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HR_INTERVIEWTABLE database table.
 * 
 */
@Entity
@Table(name="HR_INTERVIEWTABLE")
@NamedQuery(name="HrInterviewtable.findAll", query="SELECT h FROM HrInterviewtable h")
public class HrInterviewtable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long interviewid;

	private String groupinterviewresult;

	private String groupinterviewscheduled;

	private String hminterviewresult;

	private String hminterviewscheduled;

	private String hrinterviewresult;

	private String hrinterviewscheduled;

	//bi-directional many-to-one association to HrApplicant
	@ManyToOne
	@JoinColumn(name="APPLICANTID")
	private HrApplicant hrApplicant;

	public HrInterviewtable() {
	}

	public long getInterviewid() {
		return this.interviewid;
	}

	public void setInterviewid(long interviewid) {
		this.interviewid = interviewid;
	}

	public String getGroupinterviewresult() {
		return this.groupinterviewresult;
	}

	public void setGroupinterviewresult(String groupinterviewresult) {
		this.groupinterviewresult = groupinterviewresult;
	}

	public String getGroupinterviewscheduled() {
		return this.groupinterviewscheduled;
	}

	public void setGroupinterviewscheduled(String groupinterviewscheduled) {
		this.groupinterviewscheduled = groupinterviewscheduled;
	}

	public String getHminterviewresult() {
		return this.hminterviewresult;
	}

	public void setHminterviewresult(String hminterviewresult) {
		this.hminterviewresult = hminterviewresult;
	}

	public String getHminterviewscheduled() {
		return this.hminterviewscheduled;
	}

	public void setHminterviewscheduled(String hminterviewscheduled) {
		this.hminterviewscheduled = hminterviewscheduled;
	}

	public String getHrinterviewresult() {
		return this.hrinterviewresult;
	}

	public void setHrinterviewresult(String hrinterviewresult) {
		this.hrinterviewresult = hrinterviewresult;
	}

	public String getHrinterviewscheduled() {
		return this.hrinterviewscheduled;
	}

	public void setHrinterviewscheduled(String hrinterviewscheduled) {
		this.hrinterviewscheduled = hrinterviewscheduled;
	}

	public HrApplicant getHrApplicant() {
		return this.hrApplicant;
	}

	public void setHrApplicant(HrApplicant hrApplicant) {
		this.hrApplicant = hrApplicant;
	}

}