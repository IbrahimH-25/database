public class tree 
{
		public tree(String treeID, String size, String height, String location) {
		super();
		this.treeID = treeID;
		this.size = size;
		this.height = height;
		this.location = location;
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

		public void setLocation(String location) {
			this.location = location;
		}
		protected String treeID;
	 	protected String size;
	    protected String height;
	    protected String location;
	  
	}