package edu.ntut.java007.farmerCoop.model;

import java.util.List;

public interface SuserDao {
	/**
	 * 新增一筆記錄
	 * 
	 * @param suser
	 * @return
	 */
	public int insert(Suser suser);

	/**
	 * 以識別碼查詢使用者
	 * 
	 * @param userOid
	 * @return
	 */
	public Suser select(Integer userOid);

	/**
	 * 以電子信箱查詢使用者
	 * 
	 * @param userEmail
	 * @return
	 */
	public Suser select(String userEmail);

	/**
	 * 查詢所有使用者
	 * 
	 * @return
	 */
	public List<Suser> select();

	/**
	 * 更新使用者
	 * 
	 * @param suser
	 * @return
	 */
	public int update(Suser suser);

	/**
	 * 以電子信箱刪除使用者
	 * 
	 * @param userEmail
	 * @return
	 */
	public int delete(String userEmail);

}
