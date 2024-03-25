/**Class: CMSC203 CRN 30338 

 * Program: Assignment 4 Design 

 * Instructor: Ahmed Tarek 

 * Summary of Description: The program adds the properties on the management company  

 * Due Date: @version 03/18/2024 

 * Integrity Pledge: I pledge that I have completed the programming assignment independently. 

 * I have not copied the code from a student or any source. 

 * Student: @author Mariia Leskovets 
*/


public class Property extends Object{
	/** fields of the class */
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;

	/** accessor or getter of name 
	 * @return - the name
	 */
	public String getPropertyName() {
		return propertyName;
	}
	
	/** mutator or setter  of name
	 *  @param propertyName - the new propertyName 
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	/** accessor or getter of city  
	 * @return - the city
	 */
	public String getCity() {
		return city;
	}
	/** mutator or setter of city
	 *  @param city - the new city 
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/** accessor or getter of rentAmount 
	 * @return - the rentAmount
	 */
	public double getRentAmount() {
		return rentAmount;
	}
	/** mutator or setter  rentAmount 
	 * @param rentAmount - the new rentAmount
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	/** accessor or getter of owner
	 *  @return - the  owner
	 */
	public String getOwner() {
		return owner;
	}
	/** mutator or setter of owner
	 *  @param owner - the new owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/** accessor or getter of plot 
	 * @return a deep copy of the plot 
	 */
	public Plot getPlot() {
		return new Plot(plot.getX(),plot.getY(),plot.getWidth(),plot.getDepth());
	}
	/** mutator or setter of plot 
	 * @param plot - the new plot
	 */
	public void setPlot(Plot plot) {
		this.plot = new Plot(plot.getX(),plot.getY(),plot.getWidth(),plot.getDepth());
	}
	
	
	
	/** default constructor 
	 * propertyName - empty string
	 * city - empty string
	 * rentAmount - 0
	 * owner - empty string
	 */
	public Property(){
		this.propertyName="";
		this.city="";
		this.rentAmount=0.0;
		this.owner="";
		this.plot=new Plot();
		
	}
	/** Creates a new Property object using given values. It also creates a default Plot.
	 * @param propertyName - property name
	 * @param city - city where the property is located
	 * @param rentAmount - rent amount
	 * @param owner - the owner's name
	 * 
	 */
	public Property(String propertyName, String city, double rentAmount, String owner){
		this.propertyName=propertyName; 
		this.city=city; 
		this.rentAmount=rentAmount; 
		this.owner=owner;
		this.plot=new Plot();
	}
	/** Creates a new Property object using given values. It also creates a Plot using given values of a plot.
	 * @param propertyName - the propertyName
	 * @param city - city where the property is located
	 * @param rentAmount - rent amount
	 * @param  owner - the owner's name
	 * @param x - the x coordinate of the plot
	 * @param y - the y coordinate of the plot
	 * @param width - the width coordinate of the plot
	 * @param depth - the depth coordinate of the plot 
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width,int depth) {
		this.propertyName=propertyName; 
		this.city=city; 
		this.rentAmount=rentAmount; 
		this.owner=owner;
		this.plot= new Plot(x,y,width,depth);
	}
	/** Creates a new copy of the given property object.
	 * @param otherProperty - the Property object to make a copy of
	 */
	public Property(Property otherProperty) {
		this.propertyName=otherProperty.propertyName; 
		this.city=otherProperty.city; 
		this.rentAmount=otherProperty.rentAmount; 
		this.owner=otherProperty.owner;
		this.plot= new Plot(otherProperty.getPlot().getX(),otherProperty.getPlot().getY(),otherProperty.getPlot().getWidth(),otherProperty.getPlot().getDepth());
	}
	
	/** Represents a Property object in the following String format: propertyName,city,owner,rentAmount
	 * @return - the string representation of a Property object
	 */
	public String toString() {
		return String.format("%s,%s,%s,%s",propertyName,city,owner,rentAmount);
	}
	
	

	
}
