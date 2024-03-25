/**Class: CMSC203 CRN 30338 

 * Program: Assignment 4 Design 

 * Instructor: Ahmed Tarek 

 * Summary of Description: The program adds the properties on the management company  

 * Due Date: @version 03/18/2024 

 * Integrity Pledge: I pledge that I have completed the programming assignment independently. 

 * I have not copied the code from a student or any source. 

 * Student: @author Mariia Leskovets 
*/


public class Plot extends Object{
	/** fields of the class */
	private int x;
	private int y;
	private int width;
	private int depth;
	
	/**accessor or getter of x 
	 * @return x - the new x
	 *  */
	public int getX() {
		return this.x;
	}
	/** mutator or setter of x 
	 * @param x - the x
	 * */
	public void setX(int x) {
		this.x = x;
	}
	/** accessor or getter of y 
	 * @return y - the new y 
	 * */
	public int getY() {
		return y;
	}
	/** mutator or setter of y 
	 * @param y - the y
	 *  */
	public void setY(int y) {
		this.y = y;
	}
	/** accessor or getter of width
	 *  @return width - the new width 
	 *  */
	public int getWidth() {
		return width;
	}
	/** mutator or setter of width 
	 * @param width - the width
	 * */
	public void setWidth(int width) {
		this.width = width;
	}
	/** accessor or getter of depth 
	 * @return depth - the new depth
	 */
	public int getDepth() {
		return depth;
	}
	/** mutator or setter of depth 
	 * @param depth - the depth 
	 **/
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/** default constructor  
	 * x - the x coordinate of the plot set to 0
	 * y - the y coordinate of the plot set to 0 
	 *  width - the width coordinate of the plot set to 1
	 * depth - the depth coordinate of the plot set to 1
	 */
	public Plot(){
		this.x=0;
		this.y=0;
		this.width=1;
		this.depth=1;
	}
	/**constructor 
	 * @param x - the x coordinate of the plot
	 * @param 	y - the y coordinate of the plot
	 * @param width - the width coordinate of the plot
	 * @param depth - the depth coordinate of the plot
	 * */
	public Plot(int x,int y,int width,int depth){
		this.x=x;
		this.y=y;
		this.width=width;
		this.depth=depth;
	}
	/** Creates a new plot given another plot. This constructor must call an appropriate existing constructor.
	 * @param otherPlot - the plot to make a copy of
	 */
	public Plot(Plot otherPlot){
		this.x=otherPlot.x;
		this.y=otherPlot.y;
		this.width=otherPlot.width;
		this.depth=otherPlot.depth;
	}
	/** returns field of the class 
	 * @return string - the string representation of a plot.
	 */
	public String toString() {
		return String.format("%s,%s,%s,%s",this.x,this.y,this.width,this.depth );
	}
	/** Determines if the given plot instance is overlapped by the current plot.
	 * @param plot - the plot to test against and check if overlaps
	 * @return  true - if the two plots overlap, false otherwise
	 *  */
	public boolean overlaps(Plot plot) {

		boolean hor_this_vs_received=((this.x>plot.x) && (this.x<(plot.x+plot.width)));
		boolean ver_this_vs_received=(((this.y+this.depth)>plot.y) && ((this.y+this.depth)>(plot.y+plot.depth)));
		
		boolean hor_received_vs_this=((plot.x>this.x) && (plot.x<(this.x+this.width)));
		boolean ver_received_vs_this=(((plot.y+plot.depth)>this.y) && ((plot.y+plot.depth)>(this.y+this.depth)));
		boolean encomapsses=this.encompasses(plot);

	
		boolean result=(hor_this_vs_received && ver_this_vs_received) || (hor_received_vs_this && ver_received_vs_this)  ;
		
		return (result || encomapsses);
	
	}
	/** Determines if the given plot is encompassed by (is contained by) this plot. Note that the determination should be inclusive, in other words, if an edge lies on the edge of the current plot, this is acceptable.
	 * @param plot - the plot to test against and check if encompasses
	 * @return true - if the given plot is encompassed by this plot, false otherwise
	 */
	public boolean encompasses(Plot plot) {
		int this_plot_right_x=this.x+this.width;
		int this_plot_right_y=this.y+this.depth;
		int given_plot_right_x=plot.x+plot.width;
		int given_plot_right_y=plot.y+plot.depth;
		
		boolean result=this.x<= plot.x && this.y <= plot.y && this_plot_right_x>=given_plot_right_x && this_plot_right_y>=given_plot_right_y;
		boolean reverse=plot.x<=this.x && plot.y<=this.y && given_plot_right_x>=this_plot_right_x && given_plot_right_y>= this_plot_right_y;
		
		return (result || reverse);
	}
	
	

}
