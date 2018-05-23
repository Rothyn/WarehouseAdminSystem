package vo;

public class Product {
	private String pid;//产品号
	private String pname;
	private float price;
	private int pnumber;
	private String supplier;//供货商
	private String intime;//入库时间
	public Product(){}
	public Product(String pid,String pname,float price,int pnumber,String supplier,String intime){
		this.pid=pid;
		this.pname=pname;
		this.price=price;
		this.pnumber=pnumber;
		this.supplier=supplier;
		this.intime=intime;
	}
	public int getPnumber() {
		return pnumber;
	}
	public void setPnumber(int pnumber) {
		this.pnumber = pnumber;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getIntime() {
		return intime;
	}
	public void setIntime(String intime) {
		this.intime = intime;
	}
	
}
