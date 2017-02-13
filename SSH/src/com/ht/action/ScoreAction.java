package com.ht.action;

import java.util.List;

import com.ht.bean.Score;
import com.ht.common.bean.ControllerResult;
import com.ht.common.bean.Pager4EasyUI;
import com.ht.common.web.WebUtil;
import com.ht.service.ScoreService;

/**
 * ѧ���ɼ���Action
 * @author Administrator
 *
 */
public class ScoreAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private ScoreService scoreService;
	private List<Score> rows;
	private long total;
	private ControllerResult result;
	
	private String gradeId; // �༶id
	private String courseId; // �γ�id
	private String startDay;
	private String endDay;
	
	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}

	public List<Score> getRows() {
		return rows;
	}

	public long getTotal() {
		return total;
	}

	public ControllerResult getResult() {
		return result;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String gradeByPager() {
		Pager4EasyUI<Score> pager = new Pager4EasyUI<Score>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		pager = scoreService.queryPagerByGradeId(pager, gradeId, courseId);
		rows = pager.getRows();
		if (rows != null && rows.size() > 0) {
			result = ControllerResult.setSuccessResult("���ҳɹ�");
		} else {
			result = ControllerResult.setFailResult("�ð༶��ʱ��û�п��Լ�¼��������ѡ��༶��γ�");
		}
		total = pager.getTotal();
		return "gradeByPager";
	}
	
	public String pagerByStuId() {
		setPager("pagerByStuId");
		return "pagerByStuId";
	}
	
	public String pagerByDay1() {
		setPager("pagerByDay1");
		return "pagerByDay1";
	}
	
	private void setPager(String method) {
		String stuId = WebUtil.getStuId(req);
		Pager4EasyUI<Score> pager = new Pager4EasyUI<Score>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		if (method.equals("pagerByStuId")) {
			pager = scoreService.queryByStuId(pager, stuId);
		} else if (method.equals("pagerByDay1")) {
			pager = scoreService.queryByDayAndStuId(pager, stuId, startDay, endDay);
		}
		rows = pager.getRows();
		total = pager.getTotal();
		if (rows != null && rows.size() > 0) {
			result = ControllerResult.setSuccessResult("���ҳɹ�");
		} else {
			result = ControllerResult.setFailResult("û�м�¼");
		}
		
	}
	

}
