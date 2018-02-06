package edu.ntut.java007.farmerCoop.model;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class SuserDaoImpl extends JdbcDaoSupport implements SuserDao {
	private StringBuilder sqlBuilder;
	private RowMapper<Suser> rowMapper;

	public SuserDaoImpl() {
		super();
		this.sqlBuilder = new StringBuilder();
		this.rowMapper = new BeanPropertyRowMapper<>(Suser.class);
	}

	@Override
	public int insert(Suser suser) {
		sqlBuilder.append("INSERT INTO suser(USER_OID, USER_NAME, USER_LAST_NAME, USER_FIRST_NAME, USER_EMAIL,");
		sqlBuilder.append("USER_PASSWD, USER_STATUS, USER_ZIP_CODE, USER_ADDRESS, USER_MOBILE, ");
		sqlBuilder.append("USER_TEL, USER_TEL_EXT, FARMER_ZIP_CODE, FARMER_ADDRESS, FARMER_MOBILE, ");
		sqlBuilder.append("FARMER_TEL, FARMER_TEL_EXT, FARMER_PROFILE, FARMER_BNK_CODE, FARMER_BNK_ACCTNO, ");
		sqlBuilder.append("USER_LAST_LOGIN_TIME, USER_APPLY_DATE, USER_EMAIL_VAL_CODE) ");
		sqlBuilder.append("VALUES(null, ?, ?, ?, ?, ");
		sqlBuilder.append("?, ?, ?, ?, ?, ");
		sqlBuilder.append("?, ?, ?, ?, ?,  ");
		sqlBuilder.append("?, ?, ?, ?, ?,  ");
		sqlBuilder.append("?, ?, ?) ");
		String sql = sqlBuilder.toString();
		sqlBuilder.setLength(0);

		int count = getJdbcTemplate().update(sql, suser.getUserName(), suser.getUserLastName(),
				suser.getUserFirstName(), suser.getUserEmail(), suser.getUserPasswd(), suser.getUserStatus(),
				suser.getUserZipCode(), suser.getUserAddress(), suser.getUserMobile(), suser.getUserTel(),
				suser.getUserTelExt(), suser.getFarmerZipCode(), suser.getFarmerAddress(), suser.getFarmerMobile(),
				suser.getFarmerTel(), suser.getFarmerTelExt(), suser.getFarmerProfile(), suser.getFarmerBnkCode(),
				suser.getFarmerBnkAcctno(), suser.getUserLastLoginTime(), suser.getUserApplyDate(),
				suser.getUserEmailValCode());
		return count;
	}

	@Override
	public Suser select(Integer userOid) {
		sqlBuilder.append("SELECT * FROM suser ");
		sqlBuilder.append("WHERE USER_OID = ? ");
		String sql = sqlBuilder.toString();
		sqlBuilder.setLength(0);

		List<Suser> list = getJdbcTemplate().query(sql, new Object[] { userOid }, new int[] { Types.INTEGER },
				this.rowMapper);
		Suser suser = null;
		if (list.size() == 1) {
			suser = list.get(0);
		}
		return suser;
	}

	@Override
	public Suser select(String userEmail) {
		sqlBuilder.append("SELECT * FROM suser ");
		sqlBuilder.append("WHERE USER_EMAIL = ? ");
		String sql = sqlBuilder.toString();
		sqlBuilder.setLength(0);

		List<Suser> list = getJdbcTemplate().query(sql, new Object[] { userEmail }, new int[] { Types.VARCHAR },
				this.rowMapper);
		Suser suser = null;
		if (list.size() == 1) {
			suser = list.get(0);
		}
		return suser;
	}

	@Override
	public List<Suser> select() {
		sqlBuilder.append("SELECT * FROM suser ");
		String sql = sqlBuilder.toString();
		sqlBuilder.setLength(0);

		List<Suser> list = getJdbcTemplate().query(sql, this.rowMapper);
		return list;
	}

	@Override
	public int update(Suser suser) {
		sqlBuilder.append("UPDATE suser SET USER_NAME = ?, USER_LAST_NAME = ?, USER_FIRST_NAME = ?, USER_EMAIL = ?,");
		sqlBuilder.append("USER_PASSWD = ?, USER_STATUS = ?, USER_ZIP_CODE = ?, USER_ADDRESS = ?, USER_MOBILE = ?, ");
		sqlBuilder.append("USER_TEL = ?, USER_TEL_EXT = ?, FARMER_ZIP_CODE = ?, FARMER_ADDRESS = ?, ");
		sqlBuilder.append("FARMER_MOBILE = ?, FARMER_TEL = ?, FARMER_TEL_EXT = ?, FARMER_PROFILE = ?, ");
		sqlBuilder.append("FARMER_BNK_CODE = ?, FARMER_BNK_ACCTNO = ?, USER_LAST_LOGIN_TIME = ?, ");
		sqlBuilder.append("USER_APPLY_DATE = ?, USER_EMAIL_VAL_CODE = ? ");
		sqlBuilder.append("WHERE USER_OID = ? ");
		String sql = sqlBuilder.toString();
		sqlBuilder.setLength(0);

		int count = getJdbcTemplate().update(sql, suser.getUserName(), suser.getUserLastName(),
				suser.getUserFirstName(), suser.getUserEmail(), suser.getUserPasswd(), suser.getUserStatus(),
				suser.getUserZipCode(), suser.getUserAddress(), suser.getUserMobile(), suser.getUserTel(),
				suser.getUserTelExt(), suser.getFarmerZipCode(), suser.getFarmerAddress(), suser.getFarmerMobile(),
				suser.getFarmerTel(), suser.getFarmerTelExt(), suser.getFarmerProfile(), suser.getFarmerBnkCode(),
				suser.getFarmerBnkAcctno(), suser.getUserLastLoginTime(), suser.getUserApplyDate(),
				suser.getUserEmailValCode(), suser.getUserOid());
		return count;
	}

	@Override
	public int delete(String userEmail) {
		sqlBuilder.append("DELETE FROM suser ");
		sqlBuilder.append("WHERE USER_EMAIL = ? ");
		String sql = sqlBuilder.toString();
		sqlBuilder.setLength(0);

		int count = getJdbcTemplate().update(sql, userEmail);
		return count;
	}

}
