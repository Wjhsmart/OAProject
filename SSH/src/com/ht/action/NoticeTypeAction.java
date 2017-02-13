package com.ht.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ht.bean.NoticeType;
import com.ht.common.bean.ComboBox4EasyUI;
import com.ht.common.bean.ControllerResult;
import com.ht.common.bean.Pager4EasyUI;
import com.ht.common.web.WebUtil;
import com.ht.service.NoticeTypeService;

public class NoticeTypeAction extends BaseAction {

	private static final long serialVersionUID = 5836919387623216015L;

	private NoticeTypeService noticeTypeService;
	private HttpServletRequest req;
	private NoticeType noticeType;
	private List<NoticeType> rows; // ���ظ�easyui�Ľ��
	private long total; // ���ظ�easyui����ҳ��
	private ControllerResult result;
	private String id;
	private String name;
	private String value;
	private List<ComboBox4EasyUI> request;

	public List<ComboBox4EasyUI> getRequest() {
		return request;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setNoticeTypeService(NoticeTypeService noticeTypeService) {
		this.noticeTypeService = noticeTypeService;
	}

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.req = req;
	}

	public NoticeType getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(NoticeType noticeType) {
		this.noticeType = noticeType;
	}
	
	public List<NoticeType> getRows() {
		return rows;
	}

	public ControllerResult getResult() {
		return result;
	}
	
	public long getTotal() {
		return total;
	}

	public String querypager() {
		System.out.println("����queryPage...");
		Pager4EasyUI<NoticeType> pager = new Pager4EasyUI<NoticeType>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		pager = noticeTypeService.queryByPager("NoticeType", pager);
		rows = pager.getRows();
		total = pager.getTotal();
		return "querypager";
	}
	
	public String add() {
		noticeType.setStatus(1);
		System.out.println("����add����..."+noticeType.getDes()+"--"+noticeType.getName()+"---"+noticeType.getStatus());
		noticeTypeService.save(noticeType);
		result = ControllerResult.setSuccessResult("��ӳɹ�");
		return "add";
	}
	
	public String update() {
		System.out.println("����update����...");
		noticeTypeService.update(noticeType);
		result = ControllerResult.setSuccessResult("�޸ĳɹ�");
		return "update";
	}
	
	public String frost() {
		NoticeType noticeType = noticeTypeService.queryById(NoticeType.class, id);
		if (noticeType.getStatus() == 1) {
			result = ControllerResult.setSuccessResult("����ɹ�");
			noticeTypeService.updateStatus("NoticeType", "noticetypeid", 0, id);
		} else {
			result = ControllerResult.setFailResult("�Ѿ��������ˣ������ٶ���");
		}
		return "status";
	}
	
	public String activation() {
		NoticeType noticeType = noticeTypeService.queryById(NoticeType.class, id);
		if (noticeType.getStatus() == 0) {
			result = ControllerResult.setSuccessResult("����ɹ�");
			noticeTypeService.updateStatus("NoticeType", "noticetypeid", 1, id);
		} else {
			result = ControllerResult.setFailResult("�Ѿ������ˣ������ټ���");
		}
		return "status";
	}
	//��������
		public String type(){
			List<NoticeType> list = noticeTypeService.queryAll("NoticeType");
			request = new ArrayList<ComboBox4EasyUI>();
			for(NoticeType type: list){
				ComboBox4EasyUI combox = new ComboBox4EasyUI(); 
				combox.setId(type.getNoticeTypeId());
				if(type.getNoticeTypeId().equals(req.getParameter("rowID"))){
					combox.setSelected(true);
				}
				combox.setText(type.getName());
				request.add(combox);
			}
			return "type";
		}
		//��������ģ������
		public String fuzzySearch() {
			System.out.println("����queryBynoticeTypeName������");
			Pager4EasyUI<NoticeType> pager = new Pager4EasyUI<NoticeType>();
			pager.setPageNo(WebUtil.getPageNo(req));
			pager.setPageSize(WebUtil.getPageSize(req));
			if (name.equals("noticeTypeName")) {
				pager = noticeTypeService.queryBynoticeTypeName(pager, value);
			}
			rows = pager.getRows();
			total = pager.getTotal();
			if (rows != null) {
				result = ControllerResult.setSuccessResult("���ҳɹ�");
			} else {
				result = ControllerResult.setFailResult("û�м�¼");
			}
			return "fuzzySearch";
		}
}
