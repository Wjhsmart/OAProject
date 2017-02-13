package com.ht.action;

import java.util.Date;
import java.util.List;

import com.ht.bean.Emp;
import com.ht.bean.Goods;
import com.ht.bean.GoodsApp;
import com.ht.bean.Pay;
import com.ht.bean.PayType;
import com.ht.bean.info.GoodsAppInfo;
import com.ht.common.DateUtil;
import com.ht.common.bean.ControllerResult;
import com.ht.common.bean.Pager4EasyUI;
import com.ht.common.web.WebUtil;
import com.ht.service.GoodsAppService;
import com.ht.service.GoodsService;
import com.ht.service.PayService;

public class GoodsAppAction extends BaseAction {
	private static final long serialVersionUID = 8154772144250490915L;
	private List<GoodsAppInfo> rows;
	private long total;
	private GoodsApp goodsApp;
	private GoodsAppService goodsAppService;
	private GoodsService goodsService;
	private ControllerResult result;
	private String id;
	private PayService payService;
	
	public void setPayService(PayService payService) {
		this.payService = payService;
	}
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public long getTotal() {
		return total;
	}

	public GoodsApp getGoodsApp() {
		return goodsApp;
	}

	public void setGoodsApp(GoodsApp goodsApp) {
		this.goodsApp = goodsApp;
	}

	public List<GoodsAppInfo> getRows() {
		return rows;
	}

	public void setGoodsAppService(GoodsAppService goodsAppService) {
		this.goodsAppService = goodsAppService;
	}

	public ControllerResult getResult() {
		return result;
	}

	public String goodsAppPager(){
		String role = WebUtil.getRole(req);
		Pager4EasyUI<GoodsAppInfo> pager = new Pager4EasyUI<GoodsAppInfo>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		if (role.equals("�ܾ���") || role.equals("У��") || role.equals("��������") || role.equals("��������")) {
			pager = goodsAppService.queryByPager(pager);
		} else {
			Emp emp = WebUtil.getEmp(req);
			pager = goodsAppService.queryBySelf(pager, emp.getEmpId());
		}
		pager.setTotal(goodsAppService.count("GoodsApp"));
		rows = pager.getRows();
		total = pager.getTotal();
		return "pager";
	}
	public String update(){
		goodsApp.setStatus(1);
		goodsAppService.update(goodsApp);
		result = ControllerResult.setSuccessResult("���³ɹ�");
		return "updateGoodsAPP";
	}
	public String addGoodsAPP(){
		goodsApp.setAppStatus(2);
		goodsApp.setStatus(1);
		goodsApp.setAppDay(DateUtil.getDate());
		System.out.println(goodsApp.getPrice());
		goodsAppService.save(goodsApp);
		result = ControllerResult.setSuccessResult("����깺�ɹ�������");
		return "GoodsAPP";
	}
	
	public String frost(){
		GoodsApp goods = goodsAppService .queryById(GoodsApp.class, id);
		if (goods.getStatus() == 1) {
			result = ControllerResult.setSuccessResult("����ɹ�");
			goodsAppService.updateStatus("GoodsApp", "goodsAppId", 0, id);
		} else {
			result = ControllerResult.setFailResult("�Ѿ��������ˣ������ٶ���");
		}
		return "frost";
	}
	
	public String activation(){
		GoodsApp goods = goodsAppService .queryById(GoodsApp.class, id);
		if (goods.getStatus() == 0) {
			result = ControllerResult.setSuccessResult("����ɹ�");
			goodsAppService.updateStatus("GoodsApp", "goodsAppId", 1, id);
		} else {
			result = ControllerResult.setFailResult("�Ѿ��������ˣ������ټ���");
		}
		return "activation";
	}
	
	public String acceptApp() {
		goodsAppService.updateAppStatus("GoodsApp", "appstatus", "goodsAppId", 1, id);
		Goods g = goodsService.queryQuantity("Goods", goodsApp.getGoodsName());
		if (g == null) {
			Goods goods = new Goods();
			goods.setGoodsTypeId(goodsApp.getGoodsTypeId());
			goods.setBuyDay(new Date());
			goods.setName(goodsApp.getGoodsName());
			goods.setQuantity(goodsApp.getQuantity());
			goods.setDes(goodsApp.getGoodsName());
			goods.setUnitPrice(goodsApp.getPrice());
			goods.setDes(goodsApp.getGoodsName());
			goods.setStatus(1);
			goodsService.save(goods);
		} else {
			goodsService.updateQuantity("Goods", goodsApp.getGoodsName(), (g.getQuantity()+goodsApp.getQuantity()));
		}
		PayType pt = payService.queryByType("�깺");
		Pay pay = new Pay();
		pay.setPt(pt);
		Emp e = new Emp();
		e.setEmpId(goodsApp.getEmpId());
		pay.setEmp(e);
		pay.setDes(goodsApp.getDes());
		pay.setPay((goodsApp.getPrice()*goodsApp.getQuantity()));
		pay.setPayDay(new Date());
		payService.save(pay);
		result = ControllerResult.setSuccessResult("���ܳɹ�");
		return "acceptApp";
	}
	
	public String refuseApp() {
		goodsAppService.updateAppStatus("GoodsApp", "appstatus", "goodsAppId", 0, id);
		result = ControllerResult.setSuccessResult("�ؾ��ɹ�");
		return "refuseApp";
	}
}
