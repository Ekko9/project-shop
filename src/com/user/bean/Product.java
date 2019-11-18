package com.user.bean;



public class Product {
	private   String    pid ;// varchar(32) NOT NULL,
	private   String    pname;//` varchar(50) DEFAULT NULL,
	private   Double    market_price;//` double DEFAULT NULL,  #市场价格
	private   Double    shop_price;//` double DEFAULT NULL,    #超市销售价格
	private   String    pimage ;//` varchar(200) DEFAULT NULL,
	private   String      pdate ;//` date DEFAULT NULL,
	private   int      is_hot;//` int(11) DEFAULT NULL,         #0不是热门   1是热门
	private   String    pdesc;//` varchar(255) DEFAULT NULL,    
	private   int      pflag;//` int(11) DEFAULT NULL,         #0不下架      1商品下架
	private   String   cid;
	
	
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	private Category category; //对象关联

	

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	

	public Double getMarket_price() {
		return market_price;
	}

	public void setMarket_price(Double market_price) {
		this.market_price = market_price;
	}

	public Double getShop_price() {
		return shop_price;
	}

	public void setShop_price(Double shop_price) {
		this.shop_price = shop_price;
	}

	public String getPimage() {
		return pimage;
	}

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}



	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public int getIs_hot() {
		return is_hot;
	}

	public void setIs_hot(int is_hot) {
		this.is_hot = is_hot;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public int getPflag() {
		return pflag;
	}

	public void setPflag(int pflag) {
		this.pflag = pflag;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", market_price=" + market_price + ", shop_price="
				+ shop_price + ", pimage=" + pimage + ", pdate=" + pdate + ", is_hot=" + is_hot + ", pdesc=" + pdesc
				+ ", pflag=" + pflag + ", cid=" + cid + ", category=" + category + "]";
	}
	
}
