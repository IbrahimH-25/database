public class user 
{
		protected String password;
	 	protected String email;
	    protected String firstName;
	    protected String lastName;
	    protected String adress_street_num;
	    protected String adress_street;
	    protected String adress_city;
	    protected String adress_state;
	    protected String adress_zip_code;
	    protected String clientID;
	    protected String creditCard;
	    protected String phoneNum;
	 
	    //constructors
	    public user() {
	    }
	 
	    public user(String email) 
	    {
	        this.email = email;
	    }
	    
	    public user(String email,String firstName, String lastName, String password,String clientID, String adress_street_num, String adress_street, String adress_city, String adress_state,String adress_zip_code, String creditCard,  String phoneNum) 
	    {
	    	this(firstName,lastName,password,clientID, adress_street_num,  adress_street,  adress_city,  adress_state,  adress_zip_code,creditCard,phoneNum);
	    	this.email = email;
	    }
	 
	
	    public user(String firstName, String lastName, String password,String clientID, String adress_street_num, String adress_street, String adress_city, String adress_state,String adress_zip_code, String creditCard,  String phoneNum) 
	    {
	    	this.firstName = firstName;
	    	this.lastName = lastName;
	    	this.password = password;
	        this.clientID = clientID;
	        this.adress_street_num = adress_street_num;
	        this.adress_street = adress_street;
	        this.adress_city= adress_city;
	        this.adress_state = adress_state;
	        this.adress_zip_code = adress_zip_code;
	        this.creditCard = creditCard;
	        this.phoneNum = phoneNum;
	    }
	    
	   //getter and setter methods
	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    
	    public String getFirstName() {
	        return firstName;
	    }
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }
	    
	    public String getLastName() {
	        return lastName;
	    }
	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }
	    
	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }
	  
	    public String getClientID() {
	    	return clientID;
	    }
	    public void setClientID(String clientID) {
	    	this.clientID = clientID;
	    }
	    
	    public String getAdress_street_num() {
	        return adress_street_num;
	    }
	    public void setAdress_street_num(String adress_street_num) {
	        this.adress_street_num = adress_street_num;
	    }
	    public String getAdress_street() {
	        return adress_street;
	    }
	    public void setAdress_street(String adress_street) {
	        this.adress_street = adress_street;
	    }
	    public String getAdress_city() {
	        return adress_city;
	    }
	    public void setAdress_city(String adress_city) {
	        this.adress_city = adress_city;
	    }
	    public String getAdress_state() {
	        return adress_state;
	    }
	    public void setAdress_state(String adress_state) {
	        this.adress_state = adress_state;
	    }
	    public String getAdress_zip_code() {
	        return adress_zip_code;
	    }
	    public void setAdress_zip_code(String adress_zip_code) {
	        this.adress_zip_code = adress_zip_code;
	    }
	    
	    public String getCreditCard() {
	    	return creditCard;
	    }
	    public void setCreditCard(String creditCard) {
	    	this.creditCard = creditCard;
	    }
	    
	    public String getPhoneNum() {
	    	return phoneNum;
	    }
	    public void setPhoneNum(String phoneNum) {
	    	this.phoneNum = phoneNum;
	    }
	}