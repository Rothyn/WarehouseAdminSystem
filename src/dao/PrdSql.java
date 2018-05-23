package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBUtil;

public class PrdSql {
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;

	public PrdSql() throws Exception {
		conn = DBUtil.getConnection();
	}

	public String getMess(String qname) throws Exception {
		String s = "";
		String sql = "select * from t_prd where pid=? or pname=?";
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, qname);
		preparedStatement.setString(2, qname);
//		 System.out.println("1prdsqldao:"+s);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			s = rs.getInt(1) + "," + rs.getString(2) + "," + rs.getFloat(3)+","
					+ rs.getInt(4) + "," + rs.getString(5) + ","
					+ rs.getString(6);
		}
//		 System.out.println("2prdsqldao:"+s);
		return s;

	}

	// public String getMhMess(String qname) throws Exception {
	// String mess = "";
	// String sql = "select * from t_prd where pid=? or pname=?";
	// preparedStatement = conn.prepareStatement(sql);
	// preparedStatement.setString(1, "%" + qname + "%");
	// preparedStatement.setString(2, "%" + qname + "%");
	// ResultSet rs = preparedStatement.executeQuery();
	// while (rs.next()) {
	// String s = rs.getInt(1) + "," + rs.getString(2);
	// mess += s + ",,";
	// }
	// return mess;
	// }

}
