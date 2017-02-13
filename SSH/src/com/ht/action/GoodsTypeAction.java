package com.ht.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import com.ht.bean.GoodsType;
import com.ht.common.bean.ControllerResult;
import com.ht.common.bean.Pager4EasyUI;
import com.ht.common.web.WebUtil;
import com.ht.service.AuthorityRoleService;
import com.ht.service.GoodsTypeService;

public class GoodsTypeAction extends BaseAction {

	private static final long serialVersionUID = -8141056164096745048L;
	
	private GoodsTypeService goodsTypeService;
	private HttpServletRequest req;
	private GoodsType goodsType;
	private ControllerResult result;
	private List<GoodsType> rows; // ���ظ�easyui�Ľ��
	private long total; // ���ظ�easyui����ҳ��
	private String id;
	private AuthorityRoleService authorityRoleService;
	
	public void setAuthorityRoleService(AuthorityRoleService authorityRoleService) {
		this.authorityRoleService = authorityRoleService;
	}
	public void setId(String id) {
		this.id = id;
	}

	public ControllerResult getResult() {
		return result;
	}
	
	public List<GoodsType> getRows() {
		return rows;
	}

	public long getTotal() {
		return total;
	}

	public void setGoodsTypeService(GoodsTypeService goodsTypeService) {
		this.goodsTypeService = goodsTypeService;
	}
	
	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	public GoodsType getGoodsType() {
		return goodsType;
	}

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.req = req;
	}
	
	public String goodsTypeSave(){
		String roleId = WebUtil.getRoleId(req);
		String methodName = GoodsTypeAction.class.getName() + ".goodsTypeSave";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "TypeSave";
		}
		goodsType.setStatus(1);
		goodsTypeService.save(goodsType);
		result = ControllerResult .setSuccessResult("�����Ʒ���ͳɹ�");
		return "TypeSave";
	}
	public String goodsTypePage(){
		String roleId = WebUtil.getRoleId(req);
		String methodName = GoodsTypeAction.class.getName() + ".goodsTypePage";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "pager";
		}
		Pager4EasyUI<GoodsType> pager = new Pager4EasyUI<GoodsType>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		pager = goodsTypeService.queryByPager("GoodsType", pager);
		pager.setTotal(goodsTypeService.count("GoodsType"));
		rows = pager.getRows();
		total = pager.getTotal();
		return "pager";
	}
	
	public String goodsUpdate(){
		String roleId = WebUtil.getRoleId(req);
		String methodName = GoodsTypeAction.class.getName() + ".goodsUpdate";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "update";
		}
		goodsType.setStatus(1);
		goodsTypeService.update(goodsType);
		result = ControllerResult .setSuccessResult("�޸ĳɹ�");
		return "update";
	}
	
	public String frost(){
		String roleId = WebUtil.getRoleId(req);
		String methodName = GoodsTypeAction.class.getName() + ".frost";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "id";
		}
		GoodsType goodsType = goodsTypeService.queryById(GoodsType.class, id);
		if (goodsType.getStatus() == 1) {
			result = ControllerResult.setSuccessResult("����ɹ�");
			goodsTypeService.updateStatus("GoodsType", "goodstypeid", 0, id);
		} else {
			result = ControllerResult.setFailResult("�Ѿ��������ˣ������ٶ���");
		}
		return "id";
	}
	public String activation(){
		String roleId = WebUtil.getRoleId(req);
		String methodName = GoodsTypeAction.class.getName() + ".activation";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "id";
		}
		GoodsType goodsType = goodsTypeService.queryById(GoodsType.class, id);
		if (goodsType.getStatus() == 0) {
			result = ControllerResult.setSuccessResult("����ɹ�");
			goodsTypeService.updateStatus("GoodsType", "goodstypeid", 1, id);
		} else {
			result = ControllerResult.setFailResult("�Ѿ��������ˣ������ټ���");
		}
		return "id";
	}
}
