package com.ht.bean;

import java.util.Date;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * Ա����
 * 
 * @author ������
 *
 */

public class Emp {

	private String empId; // Ա�����
	private String name; // ����
	private String pwd; // ����
	private String idCard; // ���֤��
	private String nation; // ����
	private String gender; // �Ա�
	private String fingerNo; // ָ�Ʊ��
	private Date birthday; // ��������
	private String email; // ����
	private String phone; // �ֻ���
	private String qq; // qq��
	private String wechat; // ΢�ź�
	private String address; // ��ͥ��ַ
	private String married; // �Ƿ���
	private String contactName; // ��ϵ������
	private String contactPhone; // ��ϵ���ֻ���
	private String college; // ��ҵԺУ
	private String major; // רҵ
	private String eduBack; // ѧ��
	private String bankName; // ����������
	private String accountName; // ���п�����
	private String accountNo; // �����˺�
	private String alipay; // ֧�����˺�
	private Date hireDay; // ��ְʱ��
	private Date resignDay; // ��ְʱ��
	private int status; // ״̬��Ĭ�Ͽ���

	private Dept dept; // ������Dept��
	private Role role;// ������Role��
	private Set<Talk> talks; // ������Talk��
	private Set<Grade> grades1; // ������Grade��
	private Set<Grade> grades2;
	private Set<Grade> grades3;
	private Set<EmpLeave> empLeaves;
	private Set<Meetting> meetting;
	private Set<EmpFeedBack> empfeedback;
	private Set<Progress> progress;

	private Set<Duty> dutys1;
	private Set<Duty> dutys2;
	private Set<Duty> dutys3;
	private Set<Duty> dutys4;
	private Set<Duty> dutys5;
	private Set<Duty> dutys6;
	private Set<Duty> dutys7;
	private Set<Duty> dutys8;

	private Set<Check> checks;

	private Set<Stu> stus;

	private Set<Summary> summarys;

	private Set<Pay> pays;
	private Set<Income> incomes;
	private Set<SalaryInfo> sis;
	
	private Set<Notice> notices;

	private Set<Report> reports;

	private Set<EmpChecking> empCheckings;
	
	
	@JSON (serialize = false)
	public Set<SalaryInfo> getSis() {
		return sis;
	}

	public void setSis(Set<SalaryInfo> sis) {
		this.sis = sis;
	}

	@JSON (serialize = false)
	public Set<Pay> getPays() {
		return pays;
	}

	public void setPays(Set<Pay> pays) {
		this.pays = pays;
	}

	@JSON (serialize = false)
	public Set<Income> getIncomes() {
		return incomes;
	}

	public void setIncomes(Set<Income> incomes) {
		this.incomes = incomes;
	}
	
	@JSON(serialize = false)
	public Set<Duty> getDutys1() {
		return dutys1;
	}

	public void setDutys1(Set<Duty> dutys1) {
		this.dutys1 = dutys1;
	}

	@JSON(serialize = false)
	public Set<Duty> getDutys2() {
		return dutys2;
	}

	public void setDutys2(Set<Duty> dutys2) {
		this.dutys2 = dutys2;
	}

	@JSON(serialize = false)
	public Set<Duty> getDutys3() {
		return dutys3;
	}

	public void setDutys3(Set<Duty> dutys3) {
		this.dutys3 = dutys3;
	}

	@JSON(serialize = false)
	public Set<Duty> getDutys4() {
		return dutys4;
	}

	public void setDutys4(Set<Duty> dutys4) {
		this.dutys4 = dutys4;
	}

	@JSON(serialize = false)
	public Set<Duty> getDutys5() {
		return dutys5;
	}

	public void setDutys5(Set<Duty> dutys5) {
		this.dutys5 = dutys5;
	}

	@JSON(serialize = false)
	public Set<Duty> getDutys6() {
		return dutys6;
	}

	public void setDutys6(Set<Duty> dutys6) {
		this.dutys6 = dutys6;
	}

	@JSON(serialize = false)
	public Set<Duty> getDutys7() {
		return dutys7;
	}

	public void setDutys7(Set<Duty> dutys7) {
		this.dutys7 = dutys7;
	}

	@JSON(serialize = false)
	public Set<Duty> getDutys8() {
		return dutys8;
	}

	public void setDutys8(Set<Duty> dutys8) {
		this.dutys8 = dutys8;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFingerNo() {
		return fingerNo;
	}

	public void setFingerNo(String fingerNo) {
		this.fingerNo = fingerNo;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMarried() {
		return married;
	}

	public void setMarried(String married) {
		this.married = married;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getEduBack() {
		return eduBack;
	}

	public void setEduBack(String eduBack) {
		this.eduBack = eduBack;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAlipay() {
		return alipay;
	}

	public void setAlipay(String alipay) {
		this.alipay = alipay;
	}

	public Date getHireDay() {
		return hireDay;
	}

	public void setHireDay(Date hireDay) {
		this.hireDay = hireDay;
	}

	public Date getResignDay() {
		return resignDay;
	}

	public void setResignDay(Date resignDay) {
		this.resignDay = resignDay;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@JSON(serialize = false)
	public Set<Talk> getTalks() {
		return talks;
	}

	public void setTalks(Set<Talk> talks) {
		this.talks = talks;
	}

	@JSON(serialize = false)
	public Set<Grade> getGrades1() {
		return grades1;
	}

	public void setGrades1(Set<Grade> grades1) {
		this.grades1 = grades1;
	}

	@JSON(serialize = false)
	public Set<Grade> getGrades2() {
		return grades2;
	}

	public void setGrades2(Set<Grade> grades2) {
		this.grades2 = grades2;
	}

	@JSON(serialize = false)
	public Set<Grade> getGrades3() {
		return grades3;
	}

	public void setGrades3(Set<Grade> grades3) {
		this.grades3 = grades3;
	}

	@JSON(serialize = false)
	public Set<EmpLeave> getEmpLeaves() {
		return empLeaves;
	}

	public void setEmpLeaves(Set<EmpLeave> empLeaves) {
		this.empLeaves = empLeaves;
	}

	@JSON(serialize = false)
	public Set<Meetting> getMeetting() {
		return meetting;
	}

	public void setMeetting(Set<Meetting> meetting) {
		this.meetting = meetting;
	}

	@JSON(serialize = false)
	public Set<EmpFeedBack> getEmpfeedback() {
		return empfeedback;
	}

	public void setEmpfeedback(Set<EmpFeedBack> empfeedback) {
		this.empfeedback = empfeedback;
	}

	@JSON (serialize = false)
	public Set<Check> getChecks() {
		return checks;
	}

	public void setChecks(Set<Check> checks) {
		this.checks = checks;
	}

	@JSON (serialize = false)
	public Set<Stu> getStus() {
		return stus;
	}

	public void setStus(Set<Stu> stus) {
		this.stus = stus;
	}

	@JSON(serialize = false)
	public Set<Summary> getSummarys() {
		return summarys;
	}

	public void setSummarys(Set<Summary> summarys) {
		this.summarys = summarys;
	}
	@JSON(serialize=false)
	public Set<Notice> getNotices() {
		return notices;
	}

	@JSON (serialize = false)
	public Set<Report> getReports() {
		return reports;
	}

	public void setReports(Set<Report> reports) {
		this.reports = reports;
	}

	public void setNotices(Set<Notice> notices) {
		this.notices = notices;
	}

	@JSON (serialize = false)
	public Set<Progress> getProgress() {
		return progress;
	}

	public void setProgress(Set<Progress> progress) {
		this.progress = progress;
	}
	@JSON (serialize = false)
	public Set<EmpChecking> getEmpCheckings() {
		return empCheckings;
	}

	public void setEmpCheckings(Set<EmpChecking> empCheckings) {
		this.empCheckings = empCheckings;
	}

}
