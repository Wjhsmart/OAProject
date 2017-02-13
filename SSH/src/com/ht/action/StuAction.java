package com.ht.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.ht.bean.Emp;
import com.ht.bean.Income;
import com.ht.bean.IncomeType;
import com.ht.bean.Stu;
import com.ht.common.DateUtil;
import com.ht.common.EncryptUtil;
import com.ht.common.bean.ComboBox4EasyUI;
import com.ht.common.bean.ControllerResult;
import com.ht.common.bean.Pager4EasyUI;
import com.ht.common.web.WebUtil;
import com.ht.service.AuthorityRoleService;
import com.ht.service.IncomeService;
import com.ht.service.IncomeTypeService;
import com.ht.service.StuService;

public class StuAction extends BaseAction {

	private static final long serialVersionUID = -8815037733870248460L;
	
	private StuService stuService;
	private Stu stu;
	private List<Stu> rows;
	private long total;
	private String gradeId;
	private String roomId;
	private ControllerResult result;
	private String id;
	private String stuIds;
	private List<ComboBox4EasyUI> cobox;
	private String name;
	private String value;
	private String stuId;
	private int flag;
	private IncomeService incomeService;
	private Income income;
	private double r; //�ɷѽ��
	private IncomeType incomeType;
	private HttpSession session;
	private IncomeTypeService itService;
	private String incomeTypeId; // ��������Id
	
	private String stuEmpId; // ѧ�������ĸ� Ա�� ����jsp���ݹ���
	private String stuStatus; //ѧ��״̬����jsp����
	
	private int gradeTotalStu;
	private int roomTotalStu;
	private String abcdef;
	private AuthorityRoleService authorityRoleService;
	
	public void setAbcdef(String abcdef) {
		this.abcdef = abcdef;
	}

	public void setAuthorityRoleService(AuthorityRoleService authorityRoleService) {
		this.authorityRoleService = authorityRoleService;
	}

	public void setItService(IncomeTypeService itService) {
		this.itService = itService;
	}

	public IncomeType getIncomeType() {
		return incomeType;
	}

	public void setIncomeType(IncomeType incomeType) {
		this.incomeType = incomeType;
	}

	public Income getIncome() {
		return income;
	}

	public void setIncome(Income income) {
		this.income = income;
	}

	public void setIncomeService(IncomeService incomeService) {
		this.incomeService = incomeService;
	}

	public List<ComboBox4EasyUI> getCobox() {
		return cobox;
	}

	public Stu getStu() {
		return stu;
	}

	public void setStu(Stu stu) {
		this.stu = stu;
	}

	public List<Stu> getRows() {
		return rows;
	}

	public long getTotal() {
		return total;
	}

	public void setStuService(StuService stuService) {
		this.stuService = stuService;
	}
	
	public void setStuIds(String stuIds) {
		this.stuIds = stuIds;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public ControllerResult getResult() {
		return result;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public void setR(double r) {
		this.r = r;
	}

	public void setGradeTotalStu(int gradeTotalStu) {
		this.gradeTotalStu = gradeTotalStu;
	}

	public void setRoomTotalStu(int roomTotalStu) {
		this.roomTotalStu = roomTotalStu;
	}

	public void setStuEmpId(String stuEmpId) {
		this.stuEmpId = stuEmpId;
	}

	public void setStuStatus(String stuStatus) {
		this.stuStatus = stuStatus;
	}

	public String gradeIdByPager() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = StuAction.class.getName() + ".gradeIdByPager";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			Pager4EasyUI<Stu> pager = new Pager4EasyUI<Stu>();
			pager.setPageNo(WebUtil.getPageNo(req));
			pager.setPageSize(WebUtil.getPageSize(req));
			pager = stuService.queryByGradeIdPager(pager, gradeId);
			rows = pager.getRows();
			total = pager.getTotal();
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "gradeByPager";
	}
	
	public String gradeByPager() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = StuAction.class.getName() + ".gradeByPager";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			Pager4EasyUI<Stu> pager = new Pager4EasyUI<Stu>();
			pager.setPageNo(WebUtil.getPageNo(req));
			pager.setPageSize(WebUtil.getPageSize(req));
			pager = stuService.queryByGradePager(pager, gradeId);
			rows = pager.getRows();
			total = pager.getTotal();
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "gradeByPager";
	}
	
	public String roomByPager() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = StuAction.class.getName() + ".roomByPager";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			Pager4EasyUI<Stu> pager = new Pager4EasyUI<Stu>();
			pager.setPageNo(WebUtil.getPageNo(req));
			pager.setPageSize(WebUtil.getPageSize(req));
			pager = stuService.queryByRoomIdPager(pager, roomId);
			rows = pager.getRows();
			total = pager.getTotal();
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "roomByPager";
	}
	
	public String intentionStuByPager() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = StuAction.class.getName() + ".intentionStuByPager";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			String role = WebUtil.getRole(req);
			Emp emp = WebUtil.getEmp(req);
			Pager4EasyUI<Stu> pager = new Pager4EasyUI<Stu>();
			pager.setPageNo(WebUtil.getPageNo(req));
			pager.setPageSize(WebUtil.getPageSize(req));
			if (role.equals("�ܾ���") || role.equals("��������")) {
				pager = stuService.stuStatusByPager(pager, "intention");
				pager.setTotal(stuService.stuStatusCount("intention"));
			} else {
				pager = stuService.queryBySelf(pager, "intention", emp.getEmpId());
				pager.setTotal(stuService.stuStatusCount("intention", emp.getEmpId()));
			}
			rows = pager.getRows();
			total = pager.getTotal();
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "stuStatusByPager";
	}

	public String reserveStuByPager() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = StuAction.class.getName() + ".reserveStuByPager";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			String role = WebUtil.getRole(req);
			Emp emp = WebUtil.getEmp(req);
			Pager4EasyUI<Stu> pager = new Pager4EasyUI<Stu>();
			pager.setPageNo(WebUtil.getPageNo(req));
			pager.setPageSize(WebUtil.getPageSize(req));
			if (role.equals("�ܾ���") || role.equals("��������")) {
				pager = stuService.stuStatusByPager(pager, "reserve");
				pager.setTotal(stuService.stuStatusCount("reserve"));
			} else {
				pager = stuService.queryBySelf(pager, "reserve", emp.getEmpId());
				pager.setTotal(stuService.stuStatusCount("reserve", emp.getEmpId()));
			}
			rows = pager.getRows();
			total = pager.getTotal();
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "stuStatusByPager";
	}
	
	public String officialStuByPager() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = StuAction.class.getName() + ".officialStuByPager";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			Pager4EasyUI<Stu> pager = new Pager4EasyUI<Stu>();
			pager.setPageNo(WebUtil.getPageNo(req));
			pager.setPageSize(WebUtil.getPageSize(req));
			pager = stuService.stuStatusByPager(pager, "official");
			pager.setTotal(stuService.stuStatusCount("official"));
			rows = pager.getRows();
			total = pager.getTotal();
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "stuStatusByPager";
	}
	
	public String officialStuByPager1() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = StuAction.class.getName() + ".officialStuByPager1";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			Pager4EasyUI<Stu> pager = new Pager4EasyUI<Stu>();
			pager.setPageNo(WebUtil.getPageNo(req));
			pager.setPageSize(WebUtil.getPageSize(req));
			pager = stuService.stuStatusByPager1(pager, "official");
			pager.setTotal(stuService.stuStatusCount1("official"));
			rows = pager.getRows();
			total = pager.getTotal();
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "stuStatusByPager";
	}
	
	public String save() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = StuAction.class.getName() + ".save";
		session = req.getSession();
		Emp emp = new Emp();
		Emp e = (Emp) session.getAttribute("emp");
		emp.setEmpId(e.getEmpId());
		if (flag == 1) {
			if (authorityRoleService.queryByRole(methodName+"?flag=1", roleId)) {
				stu.setStuStatus("intention"); // ���ó�����ѧ��
				stu.setEmp(emp);
				stu.setStatus(1);
				try {
					stu.setAge(DateUtil.getAge(stu.getBirthday()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				stu.setRoleId("4028da265981b09d015981d91d6f0001");
				stuService.save(stu);
			} else {
				result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			}
		} else if (flag == 2) {
				// ����һ���ɷѼ�¼
			if (authorityRoleService.queryByRole(methodName+"?flag=2", roleId)) {
				income = new Income();
				incomeTypeId = itService.queryByName("Ԥ��������"); // ��ȡ��Ԥ�������ѵ�Id
				income.setDes("Ԥ��������"); // ��ӽɷ�����
				
				IncomeType it = new IncomeType();
				it.setIncomeTypeId(incomeTypeId);;
				income.setIt(it);
				income.setIncomeDay(DateUtil.getDate()); // �ɷ�ʱ��
				income.setIncome(r); // �ɷѽ��
				income.setEmp(emp); // �շ���
				stu.setStuStatus("reserve"); // Ԥ��ѧ��
				stu.setEmp(emp);
				stu.setStatus(1);
				try {
					stu.setAge(DateUtil.getAge(stu.getBirthday()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				stu.setRoleId("4028da265981b09d015981d91d6f0001");
				stuService.save(stu);
				String stuId = stu.getStuId();
				Stu s = new Stu();
				s.setStuId(stuId);
				income.setStu(s); // �ɷѵ�ѧ��
				incomeService.save(income); // �����ɷѼ�¼
			} else {
				result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			}
		} else if (flag == 3) {
			if (authorityRoleService.queryByRole(methodName+"?flag=3", roleId)) {
				income = new Income();
				incomeTypeId = itService.queryByName("ѧ��");
				income.setDes("ѧ��");
				IncomeType it = new IncomeType();
				it.setIncomeTypeId(incomeTypeId);;
				income.setIt(it);
				income.setIncomeDay(DateUtil.getDate());
				income.setIncome(r);
				income.setEmp(emp);
				stu.setStuStatus("official"); // ��ʽѧ��
				stu.setEmp(emp);
				stu.setStatus(1);
				stu.setPwd(EncryptUtil.encrypt("123456"));
				stu.setRole("ѧ��");
				stu.setRoleId("4028da265981b09d015981d91d6f0001");
				stu.setStuNo(stuService.generateStuNo());
				try {
					stu.setAge(DateUtil.getAge(stu.getBirthday()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				stuService.save(stu);
				String stuId = stu.getStuId();
				Stu s = new Stu();
				s.setStuId(stuId);
				income.setStu(s); // �ɷѵ�ѧ��
				incomeService.save(income); // �����ɷѼ�¼
			} else {
				result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			}
		}
		result = ControllerResult.setSuccessResult("��ӳɹ�");
		return "save";
	}
	
	public String update() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = StuAction.class.getName() + ".update";
		if (flag == 1) {
			if (authorityRoleService.queryByRole(methodName+"?flag=1", roleId)) {
				stu.setStuStatus("intention"); // ���ó�����ѧ��
				stu.setStatus(1);
				try {
					stu.setAge(DateUtil.getAge(stu.getBirthday()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				stu.setRoleId("4028da265981b09d015981d91d6f0001");
				stuService.update(stu);
				result = ControllerResult.setSuccessResult("���³ɹ�");
			} else {
				result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			}
		} else if (flag == 2) {
			if (authorityRoleService.queryByRole(methodName+"?flag=2", roleId)) {
				stu.setStuStatus("reserve"); // Ԥ��ѧ��
				stu.setStatus(1);
				try {
					stu.setAge(DateUtil.getAge(stu.getBirthday()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				stu.setRoleId("4028da265981b09d015981d91d6f0001");
				stuService.update(stu);
				result = ControllerResult.setSuccessResult("���³ɹ�");
			} else {
				result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			}
		} else if (flag == 3) {
			if (authorityRoleService.queryByRole(methodName+"?flag=3", roleId)) {
				stu.setStuStatus("official"); // ��ʽѧ��
				stu.setPwd(abcdef);
				stu.setStatus(1);
				if (stu.getGradeId().equals("")) {
					stu.setGradeId(null);
				}
				if (stu.getRoomId().equals("")) {
					stu.setRoomId(null);
				}
				try {
					stu.setAge(DateUtil.getAge(stu.getBirthday()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				stu.setRoleId("4028da265981b09d015981d91d6f0001");
				stuService.update(stu);
				result = ControllerResult.setSuccessResult("���³ɹ�");
			} else {
				result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			}
		}
		
		return "update";
	}
	
	public String updateStuStatus() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = StuAction.class.getName() + ".updateStuStatus";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			session = req.getSession();
			Emp emp = new Emp();
			Emp e = (Emp) session.getAttribute("emp");
			emp.setEmpId(e.getEmpId());
			if (flag == 2) {
				income = new Income();
				incomeTypeId = itService.queryByName("Ԥ��������");
				income.setDes("Ԥ��������");
				IncomeType it = new IncomeType();
				it.setIncomeTypeId(incomeTypeId);
				income.setIt(it);
				income.setIncomeDay(DateUtil.getDate());
				income.setIncome(r);
				income.setEmp(emp);
				stu = new Stu();
				stu.setStuId(stuId);
				income.setStu(stu); // �ɷѵ�ѧ��
				incomeService.save(income); // �����ɷѼ�¼
				stu.setStuStatus("reserve"); // Ԥ��ѧ��
				stu.setRoleId("4028da265981b09d015981d91d6f0001");
				stu.setStartDay(DateUtil.getDate());
			} else if (flag == 3) {
				income = new Income();
				incomeTypeId = itService.queryByName("ѧ��");
				income.setDes("ѧ��");
				IncomeType it = new IncomeType();
				it.setIncomeTypeId(incomeTypeId);;
				income.setIt(it);
				income.setIncomeDay(DateUtil.getDate());
				income.setIncome(r);
				income.setEmp(emp);
				stu = new Stu();
				stu.setStuId(stuId);
				income.setStu(stu); // �ɷѵ�ѧ��
				incomeService.save(income); // �����ɷѼ�¼
				stu.setStuStatus("official"); // ��ʽѧ��
				stu.setRole("ѧ��");
				stu.setRoleId("4028da265981b09d015981d91d6f0001");
				stu.setPwd(EncryptUtil.encrypt("123456"));
				stu.setStartDay(DateUtil.getDate());
				stu.setStuNo(stuService.generateStuNo());
			}
			stu.setEmp(emp);
			stuService.updateStuStatus(stu);
			result = ControllerResult.setSuccessResult("���³ɹ�");
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "update";
	}
	
	public String id() {
		stu = stuService.queryById(Stu.class, id);
		return "id";
	}
	
	public String all() {
		stuService.queryAll("Stu");
		return "all";
	}
	
	public String pager() {
		Pager4EasyUI<Stu> pager = new Pager4EasyUI<Stu>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		pager = stuService.queryByPager("Stu", pager);
		pager.setTotal(stuService.count("Stu"));
		rows = pager.getRows();
		total = pager.getTotal();
		return "pager";
	}
	
	public String frost() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = StuAction.class.getName() + ".frost";
		String roleName = WebUtil.getRole(req);
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			if (roleName.equals("�ܾ���") || roleName.equals("У��") || roleName.equals("������")
					|| (stuEmpId.equals(WebUtil.getEmp(req).getEmpId()) && !stuStatus.equals("official"))) {
				Stu stu = stuService.queryById(Stu.class, id);
				if (stu.getStatus() == 1) {
					result = ControllerResult.setSuccessResult("����ɹ�");
					stuService.updateStatus("Stu", "stuId", 0, id);
				} else {
					result = ControllerResult.setFailResult("�Ѿ��������ˣ������ٶ���");
				}
			} else {
				result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			}
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "status";
	}
	
	public String activation() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = StuAction.class.getName() + ".activation";
		String roleName = WebUtil.getRole(req);
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			if (roleName.equals("�ܾ���") || roleName.equals("У��") || roleName.equals("������")
					|| (stuEmpId.equals(WebUtil.getEmp(req).getEmpId()) && !stuStatus.equals("official"))) {
				Stu stu = stuService.queryById(Stu.class, id);
				if (stu.getStatus() == 0) {
					result = ControllerResult.setSuccessResult("����ɹ�");
					stuService.updateStatus("Stu", "stuId", 1, id);
				} else {
					result = ControllerResult.setFailResult("�Ѿ������ˣ������ټ���");
				}
			} else {
				result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			}
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "status";
	}
	
	public String addStusToGrade() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = StuAction.class.getName() + ".addStusToGrade";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			if (stuIds != null) {
				String[] stuIdArray = stuIds.split(",");
				int count = stuService.getGradeStuCount(gradeId); // �༶�Ѿ��ж�����
				if (gradeTotalStu >= count + stuIdArray.length) {
					stuService.addStusToGrade(gradeId, stuIdArray);
					result = ControllerResult.setSuccessResult("���ѧ���ɹ�");
				}  else {
					result = ControllerResult.setFailResult("����ѧ������������" + (count + stuIdArray.length - gradeTotalStu) + "��");
				}
				
			}
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "addStus";
	}
	
	public String addStusToRoom() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = StuAction.class.getName() + ".addStusToRoom";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			if (stuIds != null) {
				String[] stuIdArray = stuIds.split(",");
				int count = stuService.getRoomStuCount(roomId); // �༶�Ѿ��ж�����
				if (roomTotalStu >= count + stuIdArray.length) {
					stuService.addStusToRoom(roomId, stuIdArray);
					result = ControllerResult.setSuccessResult("���ѧ���ɹ�");
				}  else {
					result = ControllerResult.setFailResult("����ѧ������������" + (count + stuIdArray.length - roomTotalStu) + "��");
				}
			}
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "addStus";
	}
	
	public String query_type() {
		List<Stu> emps = stuService.queryType(1);
		cobox = new ArrayList<ComboBox4EasyUI>();
		for(Stu p : emps) {
			ComboBox4EasyUI co = new ComboBox4EasyUI();
			co.setId(p.getStuId());
			co.setText(p.getName());
			String stuid = req.getParameter("stuId");
			if(p.getStuId().equals(stuid)) {
				co.setSelected(true);
			}
			cobox.add(co);
		}
		return "query_type";
	}
	
	public String fuzzySearch1() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = StuAction.class.getName() + ".fuzzySearch1";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			Pager4EasyUI<Stu> pager = new Pager4EasyUI<Stu>();
			pager.setPageNo(WebUtil.getPageNo(req));
			pager.setPageSize(WebUtil.getPageSize(req));
			if (name.equals("stuName")) {
				pager = stuService.queryByStuName(pager, value, "intention");
			}
			rows = pager.getRows();
			total = pager.getTotal();
			if (rows != null) {
				result = ControllerResult.setSuccessResult("���ҳɹ�");
			} else {
				result = ControllerResult.setFailResult("û�м�¼");
			}
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "fuzzySearch";
	}
	
	public String fuzzySearch2() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = StuAction.class.getName() + ".fuzzySearch2";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			Pager4EasyUI<Stu> pager = new Pager4EasyUI<Stu>();
			pager.setPageNo(WebUtil.getPageNo(req));
			pager.setPageSize(WebUtil.getPageSize(req));
			if (name.equals("stuName")) {
				pager = stuService.queryByStuName(pager, value, "reserve");
			}
			rows = pager.getRows();
			total = pager.getTotal();
			if (rows != null) {
				result = ControllerResult.setSuccessResult("���ҳɹ�");
			} else {
				result = ControllerResult.setFailResult("û�м�¼");
			}
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "fuzzySearch";
	}
	
	public String fuzzySearch3() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = StuAction.class.getName() + ".fuzzySearch3";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			Pager4EasyUI<Stu> pager = new Pager4EasyUI<Stu>();
			pager.setPageNo(WebUtil.getPageNo(req));
			pager.setPageSize(WebUtil.getPageSize(req));
			if (name.equals("stuName")) {
				pager = stuService.queryByStuName(pager, value, "official");
			}
			rows = pager.getRows();
			total = pager.getTotal();
			if (rows != null) {
				result = ControllerResult.setSuccessResult("���ҳɹ�");
			} else {
				result = ControllerResult.setFailResult("û�м�¼");
			}
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "fuzzySearch";
	}
	
	
	public String details() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = StuAction.class.getName() + ".details";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			stu = stuService.queryById(Stu.class, stuId);
			req.setAttribute("stu", stu);
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "details";
	}

	
}
