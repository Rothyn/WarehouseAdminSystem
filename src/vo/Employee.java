package vo;

public class Employee {
	private String eid;//Ա�����
	private String password;//��¼����
	private String ename;//����
	private String sex;//�Ա�
	private String eage;//����
	private String salary;//����
	private String ismanager;//�Ƿ��ǹ���Ա
	private String tel;//�绰
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
