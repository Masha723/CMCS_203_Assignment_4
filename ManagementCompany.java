/**Class: CMSC203 CRN 30338 

 * Program: Assignment 4 Design 

 * Instructor: Ahmed Tarek 

 * Summary of Description: The program adds the properties on the management company  

 * Due Date: @version 03/18/2024 

 * Integrity Pledge: I pledge that I have completed the programming assignment independently. 

 * I have not copied the code from a student or any source. 

 * Student: @author Mariia Leskovets 
*/

public class ManagementCompany {
	
	/** fields 
	 * 
	 * */
	static final int MAX_PROPERTY=5;
	static final int MGMT_DEPTH=10;
	static final int MGMT_WIDTH=10;
	
	private String taxID; 
	private double mgmFee;
	private String name;
	private Plot plot;
	
	private Property[] properties;
	private int numberOfProperties;
	
	/** accessor or getter taxID 
	 * @return taxID - the taxID 
	 */
	public String getTaxID() {
		return taxID;
	}
	/** mutator or setter  of TaxID 
	 * @param taxID - the  new taxID
	 * */
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}
	/** accessor or getter MgmFee  
	 * @return mgmFee - the mgmFee
	 *  */
	public double getMgmFeePer() {
		return mgmFee;
	}
	/** mutator or setter  of name MgmFee 
	 * @param mgmFee - the new MgmFee 
	 *  */
	public void setMgmFeePer(double mgmFee) {
		this.mgmFee = mgmFee;
	}
	/** accessor or getter name 
	 * @return name - the name
	 */
	public String getName() {
		return name;
	}
	/** mutator or setter  of name 
	 * @param name  - the new name
	 * 
	 * */
	public void setName(String name) {
		this.name = name;
	}
	/** accessor or getter plot 
	 * @return - a deep copy of the plot 
	 * */
	public Plot getPlot() {
		return new Plot( plot.getX(),plot.getY(),plot.getWidth(),plot.getDepth());
	}
	/** mutator or setter  of plot
	 *  @param plot - the new plot
	  */
	public void setPlot(Plot plot) {
		this.plot =new Plot( plot.getX(),plot.getY(),plot.getWidth(),plot.getDepth());
	}
	/** accessor or getter of properties array  
	 * @return properties - reference to properties array
	 */
	public Property[] getProperties() {
		return properties;
	}
	/** mutator or setter  of  properties array
	 * @param properties - set reference copy to the properties field
	 * */
	public void setPropertie(Property[] properties) {
		this.properties = properties;
	}
	/** accessor or getter NumberOfProperties
	 *  @return - NumberOfProperties added to the array properties
	 *  */
	public int getNumberOfProperties() {
		return numberOfProperties;
	}
	
	/** mutator or setter  of NumberOfProperties 
	 * @param  numberOfProperties - the new numberOfProperties
	 */
	
	public void setNumberOfProperties(int numberOfProperties) {
		this.numberOfProperties = numberOfProperties;
	}
	
	
	
	/** Creates a ManagementCompany object using empty strings, 
	 *  creates a default Plot with maximum width and depth
	 *  and it initializes the properties array.
	 */
	public ManagementCompany() {
		plot=new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.properties=new Property[MAX_PROPERTY];
		this.mgmFee=0.0;
		this.name="";
		this.taxID="";
		this.numberOfProperties=0;
	}
	
	/** Creates a ManagementCompany object using the given values, 
	 * creates a default Plot with maximum 
	 * width and depth and it initializes the properties array.
	 * @param name - management Company name
	 * @param taxID - tax Id
	 * @param mgmFee - management Fee

	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name=name;
		this.taxID=taxID; 
		this.mgmFee=mgmFee;
		this.plot=new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.properties=new Property[MAX_PROPERTY];
		this.numberOfProperties=0;
	}
	/** Creates a ManagementCompany object using the given values creates 
	 * a Plot using the given values and it initializes the properties array.
	 * This constructor should call an appropriate existing constructor.
	 * @param name - management Company name
	 * @param taxID - tax Id
	 * @param mgmFee - management Fee
	 * @param x - The x coordinate of the plot
	 * @param y - The y coordinate of the plot
	 * @param width - The width coordinate of the plot
	 * @param depth - The depth coordinate of the plot
	 *  
	 *  
	 *  */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name=name;
		this.taxID=taxID; 
		this.mgmFee=mgmFee; 
		this.taxID=taxID;
		this.plot=new Plot(x,y,width,depth);
		this.properties=new Property[MAX_PROPERTY];
		this.numberOfProperties=0;
		
	}
	/** Creates  a new ManagementCompany
	 * copy of the given ManagementCompany. 
	 * This constructor should call an appropriate existing constructor.
	 * @param otherCompany - the other management Company
	 */
	public ManagementCompany(ManagementCompany otherCompany){
		this.name=otherCompany.name;
		this.taxID=otherCompany.taxID; 
		this.mgmFee=otherCompany.mgmFee; 
		this.taxID=otherCompany.taxID;
		this.plot=new Plot(otherCompany.plot.getX(),otherCompany.plot.getY(),otherCompany.plot.getWidth(),otherCompany.plot.getDepth());	
		this.properties=new Property[MAX_PROPERTY];
		this.numberOfProperties=0;
	}
	
	/** adds property to the array of properties if the received property meet all the criteria.
	 * @param received_property - property created in the one of the add_propertt methods
	 * @return -1 if the array is full, -2 if the Property object is null, -3 
	 * if management company does not encompass the property plot, -4 
	 * if property plot overlaps ANY of properties in array,
	 * otherwise return the index of the array where the property was added.
	 * 
	 */
	
	public  int helper(Property received_property) {
		int result=0;	
		Plot received_plot=received_property.getPlot();
		
		if (this.numberOfProperties==MAX_PROPERTY) 
		{
			result=-1;
		}
		else if (received_plot==null) 
		{
			result=-2;
		}
		else if (!this.plot.encompasses(received_plot)) {
			result=-3;
		}
		else	
		{
			for (int index=0;index<this.numberOfProperties;index++) 
			{
				if (this.properties[index]!=null) 
					
				{
					Plot array_plot=this.properties[index].getPlot();
			
					if (received_plot.overlaps(array_plot))
					{
						result=-4;
						return result;
					}
				}
				else
				{
					this.properties[this.numberOfProperties]=received_property;
					result=index;
					++this.numberOfProperties;
				}
			}
			this.properties[numberOfProperties]=received_property;
			result=this.numberOfProperties;
			++this.numberOfProperties;
		}
		return result;
		
		
	}
	
	/** Adds a new property to the properties array, this method calls helper method and returns its value.
	 * @param name - property name
	 * @param city - city where the property is located
	 * @param rent - rent amount
	 * @param owner - the owner's name
	 * @return index - index or negative number as mistake
	 */
	
	public int addProperty(String name, String city, double rent, String owner) 
	{
		Property property_new=new Property(name,city,rent,owner);
		int result=this.helper(property_new);
		return result;
	
	}
	
	/** Adds a new property to the properties array, this method calls helper method and returns its value.
	 * @param name - property name
	 * @param city - city where the property is located
	 * @param rent - rent amount
	 * @param owner - the owner's name
	 * @param  x - The x coordinate of the plot
	 * @param y - The y coordinate of the plot
	 * @param width - The width coordinate of the plot
	 * @param depth - The depth coordinate of the plot
	 * @return index or negative number as mistake
	 */
	public int addProperty(String name, String city, double rent, String owner, int x,int y, int width, int depth) {
		Property property_new=new Property(name,city,rent,owner,x,y,width,depth);
		int result=this.helper(property_new);
		return result;
		
	}
	/** Creates a property object by copying from another property and adds it to the properties array.
	 * this method calls helper method and returns its value.
	 * @param property  - the Property type object
	 * @return index - index or negative number as mistake
	*/
	public int addProperty(Property property) {
		int x=property.getPlot().getX();
		int y=property.getPlot().getY();
		int width=property.getPlot().getWidth();
		int depth=property.getPlot().getDepth();
		Property property_new=new Property(property.getPropertyName(),property.getCity(),property.getRentAmount(),property.getOwner(),x,y,width,depth);
		int result=this.helper(property_new);
		return result;
	}
	

	/** Removes(nullifies) the LAST property in the properties array */
	public void removeLastProperty()
	{
		this.properties[this.numberOfProperties]=null;
	}
	/** Checks if the properties array has reached the maximum capacity
	 * @return - true if properties array is full, false otherwise 
	 */
	public boolean isPropertiesFull() {
		if (this.numberOfProperties==MAX_PROPERTY-1) {
			return true;
		}
		else {return false;}
	}
	/** Gets the number of existing properties in the array
	 * @return - the number of existing properties in the array
	  */
	public  int getPropertiesCount() {
		
		return numberOfProperties;
	}
	/**
	 * Returns the total rent of the properties in the properties array
	 * @return - total rent
	 */
	public double getTotalRent() {
		double total=0.0;
		for (int index=0; index<this.numberOfProperties;index++) {
			total+=this.properties[index].getRentAmount();
			
		}
		
		return total;
	}
	/** Gets the property in the array with the maximum amount of rent
	 *  @return - the property in the array which has the highest amount of rent
	 */
	public Property getHighestRentPropperty() {
		
		Property result=new Property();
		int index_biggest=0;
		if (this.numberOfProperties==1)
		{
			result=this.properties[0];
		}
		else if (this.numberOfProperties>1)
		{
			double biggest=this.properties[0].getRentAmount();
			for (int index=1; index<this.numberOfProperties;index++) 
			{
				if (this.properties[index].getRentAmount()>biggest) 
				{
					biggest=this.properties[index].getRentAmount();
					index_biggest=index;
				}
				result=this.properties[index_biggest];
				
			}
		}

		return result;
	}
	/** Checks if the management company has a valid (between 0-100) fee 
	 * @return - true of the management fee is valid (between 0-100), false otherwise
	 * */
	public boolean isMangementFeeValid() {
		if (this.mgmFee>=0 && this.mgmFee<101)
		{return true;}
		else {return false;}
	}
	/** Represents the information of all the properties in the properties array.
	 * @return - information of ALL the properties within this management company by accessing the properties array. 
	 *         This value should include each management company's name, taxID as well each property's name,city,owner,rent Amount.
	 *  
	 */
	public String toString() {
		double total=0;

		String str=String.format("List of the properties for %s, taxID: %s\n______________________________________________________\n",this.name,this.taxID);
		for (int index=0;index<=this.numberOfProperties-1;index++)
		{
			if (this.properties[index]!=null)
			{
				str+=this.properties[index].toString()+"\n";
				total+=this.properties[index].getRentAmount();
			}

		}
		str+="______________________________________________________\n\n";
		str+=" total management Fee: "+(total*this.getMgmFeePer())/100;
		return str;
	}
	
}
