package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import util.DBUtil;
import vo.Employee;

public class EmployeeDao {
	private Connection conn = null;

	//���µ�Ա����Ϣ���뵽���ݿ�t_emp��
	public void save(Employee e) throws Exception {
		conn = DBUtil.getConnection();
		PreparedStatement prep = conn
				.prepareStatement("insert into t_emp(eid,password,ename,sex,eage,salary,ismanager,tel) "
						+ "values(?,?,?,?,?,?,?,?)");
		prep.setString(1, e.getEid());
		prep.setString(2, e.getPassword());
		prep.setString(3, e.getEname());
		prep.setString(4, e.getSex());
		prep.setString(5, e.getEage());
		prep.setString(6, e.getSalary());
		prep.setString(7, e.getIsmanager());
		prep.setString(8, e.getTel());
		prep.executeUpdate();
		DBUtil.close(conn);
	}
	
	//��ȡȫ��Ա����Ϣ����ϣ��洢
	public HashMap getAllEmps() throws Exception {
		HashMap hm = new HashMap();
		conn = DBUtil.getConnection();
		PreparedStatement prep = conn.prepareStatement("select * from t_emp");
		ResultSet rst = prep.executeQuery();
		while (rst.next()) {
			Employee emp = new Employee();
			emp.setEid(rst.getString("eid"));
			emp.setEname(rst.getString("ename"));
			emp.setPassword(rst.getString("password"));
			emp.setEname(rst.getString("ename"));
			emp.setSex(rst.getString("sex"));
			emp.setEage(rst.getString("eage"));
			emp.setSalary(rst.getString("salary"));
			emp.setIsmanager(rst.getString("ismanager"));
			emp.setTel(rst.getString("tel"));
			hm.put(emp.getEid(),emp);
		}
		DBUtil.close(conn);
		return hm;
	}

}
