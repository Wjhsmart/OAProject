package com.ht.dao;

import com.ht.bean.Room;
import com.ht.common.bean.Pager4EasyUI;

public interface RoomDAO extends BaseDAO<Room> {
	
	/**
	 * ������������ģ������
	 * @param pager
	 * @param roomName
	 * @return
	 */
	public Pager4EasyUI<Room> queryByRoomName(Pager4EasyUI<Room> pager, String roomName);

}
