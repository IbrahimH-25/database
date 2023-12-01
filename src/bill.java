public class bill 
{
		protected String billId;
	 	protected String billPaid;
	    protected String billStatus;
	 
	    //constructors
	    public bill() {
	    }
	 
	    public bill(String billId) 
	    {
	        this.billId = billId;
	    }
	    
	    public bill(String billId,String billPaid, String status) 
	    {
	    	this(billPaid,status);
	    	this.billId = billId;
	    }
	 
	
	    public bill(String billPaid, String billStatus) 
	    {
	    	this.billPaid = billPaid;
	    	this.billStatus = billStatus;

	    }
	    
	   //getter and setter methods
	    public String getBillId() {
	        return billId;
	    }
	    public void setBillId(String billId) {
	        this.billId = billId;
	    }
	    
	    public String getBillPaid() {
	        return billPaid;
	    }
	    public void setBillPaid(String billPaid) {
	        this.billPaid = billPaid;
	    }
	    
	    public String getBillStatus() {
	        return billStatus;
	    }
	    public void setBillStatus(String billStatus) {
	        this.billStatus = billStatus;
	    }
	    
	}