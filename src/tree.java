public class tree 
{
		public tree(String treeID, String size, String height, String location, String photo1, String photo2, String photo3) {
		super();
		this.treeID = treeID;
		this.size = size;
		this.height = height;
		this.location = location;
		this.photo1=photo1;
		this.photo2=photo2;
		this.photo3=photo3;
	}
		public String getTreeID() {
			return treeID;
		}

		public void setTreeID(String treeID) {
			this.treeID = treeID;
		}

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}

		public String getHeight() {
			return height;
		}

		public void setHeight(String height) {
			this.height = height;
		}
		public String getLocation() {
			return location;
		}
		public String getPhoto1() {
			return photo1;
		}
		public String getPhoto2() {
			return photo2;
		}
		public String getPhoto3() {
			return photo3;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public void setPhoto1(String photo1) {
			this.photo1=photo1;
		}
		public void setPhoto2(String photo2) {
			this.photo2=photo2;
		}
		public void setPhoto3(String photo3) {
			this.photo3=photo3;
		}
		
		protected String treeID;
	 	protected String size;
	    protected String height;
	    protected String location;
	    protected String photo1;
	    protected String photo2;
	    protected String photo3;
	    
	  
	}
