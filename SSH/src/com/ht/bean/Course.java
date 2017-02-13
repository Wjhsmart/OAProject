package com.ht.bean;

import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * ��Ӧ�γ̱�
 * 
 * @author xiaoqiang
 *
 */
public class Course {

	private String courseId; // �γ̱��
	private String name; // �γ���
	private String des; // ����
	private int totalHour; // �ܿ�ʱ��
	private int term; // ѧ��
	private int courseOrder; // �γ�˳��
	private int status; // ״̬��Ĭ��Ϊ����
	
	private Set<Score> scores; // �ɼ�

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public int getTotalHour() {
		return totalHour;
	}

	public void setTotalHour(int totalHour) {
		this.totalHour = totalHour;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public int getCourseOrder() {
		return courseOrder;
	}

	public void setCourseOrder(int courseOrder) {
		this.courseOrder = courseOrder;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	@JSON(serialize=false)
	public Set<Score> getScores() {
		return scores;
	}

	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}

}
