package vo;

public class Employee {
	private String eid;//员工编号
	private String password;//登录密码
	private String ename;//姓名
	private String sex;//性别
	private String eage;//年龄
	private String salary;//工资
	private String ismanager;//是否是管理员
	private String tel;//电话
	public Employee(){}
	public Employee(String eid,String password,String ename,String sex,String eage,String salary,String ismanager,String tel){
		this.eid=eid;
		this.password=password;
		this.ename=ename;
		this.sex=sex;
		this.eage=eage;
		this.salary=salary;
		this.ismanager=ismanager;
		this.tel=tel;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEage() {
		return eage;
	}
	public void setEage(String eage) {
		this.eage = eage;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getIsmanager() {
		return ismanager;
	}
	public void setIsmanager(String ismanager) {
		this.ismanager = ismanager;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
