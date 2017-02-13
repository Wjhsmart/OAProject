package com.ht.bean;

import java.util.Date;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * ѧ����Ϣ��
 * @author Asa
 *
 */
public class Stu {

	private String stuId; //ѧ�����
	private String stuNo; //ѧ��
	private String name; //����
	private String pwd; //����
	private String idCard; //���֤��
	private String phone; //�ֻ���
	private String qq; //QQ��
	private String wechat; //΢�ź�
	private String school; //��ҵѧУ
	private int age; //����
	private Date birthday; //����
	private String gender; //�Ա�
	private String address; //��ͥ��ַ
	private String nation; //����
	private String residence; //��������
	private String gradeId; //�༶���
	private String parentName; //�ҳ�����
	private String parentPhone; //�ҳ��ֻ���
	private Date startDay; //��ѧʱ��
	private String des; //����
	private int status; //״̬��Ĭ�Ͽ��� 
	private String stuStatus; //ѧ��״̬������Ԥ������ʽ
	private String role; //��ɲ���ɫ
	private String roleId; // ��ɫid
	
	private Set<Talk> talks;
	private Set<StuFeedback> stuFeedbacks;
	private Set<Job> jobs;
	private Room room;
	private Set<StuChecking> stuCheckings;
	private Set<StuLeave> stuLeaves;
	private Set<Score> scores;
	private Emp emp; //��Ӧ������ʦ������ϵ
	private Set<Summary> summarys; // ��Ӧ�ܽ��
	
	private Set<Income> incomes;
	private String roomId;
	private Grade grade;
	
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	@JSON(serialize = false)
	public Set<Income> getIncomes() {
		return incomes;
	}
	public void setIncomes(Set<Income> incomes) {
		this.incomes = incomes;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
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
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getResidence() {
		return residence;
	}
	public void setResidence(String residence) {
		this.residence = residence;
	}
	public String getGradeId() {
		return gradeId;
	}
	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getParentPhone() {
		return parentPhone;
	}
	public void setParentPhone(String parentPhone) {
		this.parentPhone = parentPhone;
	}
	public Date getStartDay() {
		return startDay;
	}
	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStuStatus() {
		return stuStatus;
	}
	public void setStuStatus(String stuStatus) {
		this.stuStatus = stuStatus;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@JSON(serialize=false)
	public Set<Talk> getTalks() {
		return talks;
	}
	public void setTalks(Set<Talk> talks) {
		this.talks = talks;
	}
	@JSON(serialize=false)
	public Set<StuFeedback> getStuFeedbacks() {
		return stuFeedbacks;
	}
	public void setStuFeedbacks(Set<StuFeedback> stuFeedbacks) {
		this.stuFeedbacks = stuFeedbacks;
	}
	@JSON(serialize=false)
	public Set<Job> getJobs() {
		return jobs;
	}
	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}
	
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	@JSON(serialize=false)
	public Set<StuChecking> getStuCheckings() {
		return stuCheckings;
	}
	public void setStuCheckings(Set<StuChecking> stuCheckings) {
		this.stuCheckings = stuCheckings;
	}
	@JSON(serialize=false)
	public Set<StuLeave> getStuLeaves() {
		return stuLeaves;
	}
	public void setStuLeaves(Set<StuLeave> stuLeaves) {
		this.stuLeaves = stuLeaves;
	}
	@JSON(serialize=false)
	public Set<Score> getScores() {
		return scores;
	}
	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	@JSON(serialize=false)
	public Set<Summary> getSummarys() {
		return summarys;
	}
	public void setSummarys(Set<Summary> summarys) {
		this.summarys = summarys;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
 