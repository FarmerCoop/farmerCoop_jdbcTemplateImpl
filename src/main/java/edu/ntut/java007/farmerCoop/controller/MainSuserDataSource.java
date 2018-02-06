package edu.ntut.java007.farmerCoop.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.ntut.java007.farmerCoop.model.SuserDao;
import edu.ntut.java007.farmerCoop.model.Suser;

public class MainSuserDataSource {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"edu/ntut/java007/farmerCoop/model/BeansFcdbJdbcDaoSupport.xml");
		SuserDao dao = context.getBean("SuserJdbcDaoSupport", SuserDao.class);

		Suser suser = null;
		String email = null;
		String emailHost = "@gmail.com";
		// a12345678
		String passwd = "b978efdd3f45e4121551e920efb246a7ee1f780f";
		Timestamp applyDate = Timestamp.valueOf("2018-02-05 15:32:52");

		System.out.println("--------新增記錄--------");
		for (int i = 'a'; i <= 'z'; i++) {
			email = (char) i + emailHost;
			suser = new Suser(email, email, passwd, applyDate);
			dao.insert(suser);
		}
		System.out.println("--------顯示多筆記錄--------");
		List<Suser> susers = dao.select();
		showSusers(susers);

		System.out.println("--------更新紀錄--------");
		suser = dao.select(email);
		suser.setUserLastLoginTime(new Timestamp(System.currentTimeMillis()));
		suser.setUserLastName("關");
		suser.setUserFirstName("羽");
		dao.update(suser);

		System.out.println("--------顯示單筆記錄--------");
		suser = dao.select(email);
		if (suser != null) {
			showSuser(suser);
		} else {
			System.out.println(String.format("查無此筆記錄(UserEmail = %s)", email));
		}
		System.out.println("--------刪除紀錄--------");
		// dao.delete(email);

		System.out.println("--------刪除後再顯示多筆記錄--------");
		susers = dao.select();
		showSusers(susers);
		context.close();
	}

	static void showSusers(List<Suser> susers) {
		for (Suser suser : susers) {
			showSuser(suser);
		}
	}

	static void showSuser(Suser suser) {
		System.out.println(String.format(
				"userOid: %-10d, userName: %-10s, userEmail: %s, userPasswd: %s, userApplyDate: %5$tF %5$tT, userLastLoginTime: %6$tF %6$tT ",
				suser.getUserOid(), suser.getUserName(), suser.getUserEmail(), suser.getUserPasswd(),
				suser.getUserApplyDate(), suser.getUserLastLoginTime()));
	}
}
