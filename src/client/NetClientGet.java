package client;




public class NetClientGet {

	// http://localhost:8080/RESTfulExample/json/product/get
	public static void main(String[] args) {
		//ApacheHttpRest res= new ApacheHttpRest();
		//ExcelWriter xl= new ExcelWriter();
		//xl.writeexcel();
		//res.getrequest();
		NetRest nr= new NetRest();
		nr.NetRestGet();
	 
	}

}