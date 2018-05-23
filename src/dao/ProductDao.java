package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import util.DBUtil;
import vo.Product;

public class ProductDao {
	private Connection conn = null;

	// 将新的员工信息加入到数据库t_prd中
	public void save(Product p) throws Exception {
		conn = DBUtil.getConnection();
		PreparedStatement prep = conn.prepareStatement(
				"insert into t_prd(pid,panme,price,pnumber,supplier,intime) "
				+ "values(?,?,?,?,?,?)");
		prep.setString(1, p.getPid());
		prep.setString(2, p.getPname());
		prep.setFloat(3, p.getPrice());
		prep.setInt(4, p.getPnumber());
		prep.setString(5, p.getSupplier());
		prep.setString(6, p.getIntime());
		prep.executeUpdate();
		DBUtil.close(conn);
	}

	// 提取全部员工信息，哈希表存储
	public HashMap getAllPrds() throws Exception {
		HashMap hm = new HashMap();
		conn = DBUtil.getConnection();
		PreparedStatement prep = conn.prepareStatement("select * from t_prd");
		ResultSet rst = prep.executeQuery();
		while (rst.next()) {
			Product prod = new Product();
			prod.setPid(rst.getString("pid"));
			prod.setPname(rst.getString("pname"));
			prod.setPrice(Float.parseFloat(rst.getString("price")));
			prod.setPnumber(Integer.parseInt(rst.getString("pnumber")));
			prod.setSupplier(rst.getString("supplier"));
			prod.setIntime(rst.getString("intime"));
			hm.put(prod.getPid(), prod);
		}
		DBUtil.close(conn);
		return hm;
	}
}
