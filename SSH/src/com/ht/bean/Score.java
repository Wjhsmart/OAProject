package com.ht.bean;

import java.util.Date;

/**
 * ѧ�����Գɼ���
 * @author Asa
 *
 */
public class Score {

	private String scoreId; //�ɼ����
	private float score; //�ɼ�
	private Date testDay; //����ʱ��
	
	private Stu stu; // ѧ��
	private Course course; // �γ�
	
	public String getScoreId() {
		return scoreId;
	}
	public void setScoreId(String scoreId) {
		this.scoreId = scoreId;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public Date getTestDay() {
		return testDay;
	}
	public void setTestDay(Date testDay) {
		this.testDay = testDay;
	}
	public Stu getStu() {
		return stu;
	}
	public void setStu(Stu stu) {
		this.stu = stu;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
}
