public class quote 
{
		protected String orderID;
	 	protected String quoteStatus;
	    protected String initialPrice;
	    protected String note;

	 
	    //constructors
	    public quote() {
	    	System.out.print("quote()");
	    }
	 
	    public quote(String orderID) 
	    {
	    	System.out.print("quote(Str orderID)");
	        this.orderID = orderID;
	    }
	    
	    public quote(String orderID,String quoteStatus, String initialPrice, String note)
	    {
	    	
	    	this(quoteStatus,initialPrice,note);
	    	this.orderID = orderID;
	    	System.out.print("quote (all)");
	    }
	 
	
	    public quote(String quoteStatus, String initialPrice, String note)
	    {
	    	this.quoteStatus = quoteStatus;
	    	this.initialPrice = initialPrice;
	        this.note = note;
	    	System.out.print("quote(order ID)");
	    }
	    
	   //getter and setter methods
	    public String getQuoteID() {
	        return orderID;
	    }
	    public void setQuoteOrderID(String orderID) {
	        this.orderID = orderID;
	    }
	    
	    public String getQuoteStatus() {
	        return quoteStatus;
	    }
	    public void setQuoteStatus(String quoteStatus) {
	        this.quoteStatus = quoteStatus;
	    }
	    
	    public String getInitialPrice() {
	        return initialPrice;
	    }
	    public void setInitialPrice(String initialPrice) {
	        this.initialPrice = initialPrice;
	    }
	    
	    public String getNote() {
	        return note;
	    }
	    public void setNote(String note) {
	        this.note = note;
	    }
	  
	}