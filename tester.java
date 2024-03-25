
public class tester {
	public static void main(String[]args) {

		ManagementCompany mnm=new ManagementCompany("AmericanFamily","12345",2000.0);  

		Property property_one=new Property("MashaCo","DC",2000.0,"Joe",5,5,1,1);  

		Property property_two=new Property("Jean","Seattle",3000.0,"Julie",0,0,9,9); 

		Property property_three=new Property("Emy","Tacoma",3000.0,"Tyler",4,4,3,3);  

		 

		

		 

		System.out.println();  

		System.out.println("overlaps plot-one with received plot-two "+property_one.getPlot().overlaps(property_two.getPlot())); 

		System.out.println("overlaps plot-one with received plot-three "+property_one.getPlot().overlaps(property_three.getPlot())); 

		System.out.println();  

		System.out.println("overlaps plot-two with received plot-one "+property_two.getPlot().overlaps(property_one.getPlot())); 

		System.out.println("overlaps plot-two with received plot-three "+property_two.getPlot().overlaps(property_three.getPlot())); 

		System.out.println();  

		System.out.println("overlaps plot-three with received plot-one "+property_three.getPlot().overlaps(property_one.getPlot())); 

		System.out.println("overlaps plot-three with received plot-two "+property_three.getPlot().overlaps(property_two.getPlot())); 

		System.out.println();  

		System.out.println("encompasses plot-one with received plot-two "+property_one.getPlot().encompasses(property_two.getPlot())); 

		System.out.println("encompasses plot-one with received plot-three "+property_one.getPlot().encompasses(property_three.getPlot()));  

		System.out.println();  

		System.out.println("encompasses plot-two with received plot-one "+property_two.getPlot().encompasses(property_one.getPlot())); 

		System.out.println("encompasses plot-two with received plot-three "+property_two.getPlot().encompasses(property_three.getPlot())); 

		System.out.println();  

		System.out.println("encompasses plot-three with received plot-one "+property_three.getPlot().encompasses(property_one.getPlot()));  

		System.out.println("encompasses plot-three with received plot-two "+property_three.getPlot().encompasses(property_two.getPlot()));  

		System.out.println();  

		System.out.println("overlaps mnm company with plot-one "+mnm.getPlot().overlaps(property_one.getPlot())); 

		System.out.println("overlaps mnm company with plot-two "+mnm.getPlot().overlaps(property_two.getPlot())); 

		System.out.println("overlaps mnm company with plot-three "+mnm.getPlot().overlaps(property_three.getPlot())); 

		System.out.println();  

		System.out.println("encompasses mnm with received plot-one "+mnm.getPlot().encompasses(property_one.getPlot()));  

		System.out.println("encompasses mnm with received plot-two "+mnm.getPlot().encompasses(property_two.getPlot()));  

		System.out.println("encompasses mnm with received plot-three "+mnm.getPlot().encompasses(property_three.getPlot()));  

		System.out.println();  

		 

		System.out.println("\nAdd property one to the mnm;\n"); 

		int first_return=mnm.addProperty(property_one);  

		System.out.println("first return of addition "+first_return);  

		 

		System.out.println("\nAdd property two to mnm \n"); 

		int second_return=mnm.addProperty(property_two);  

		System.out.println("second return of addition "+second_return);  

		 

		System.out.println("\nAdd property three to mnm\n"); 

		int third_return=mnm.addProperty(property_three);  

		System.out.println("second return of addition "+third_return+"\n\n");  

		 

		 

		 

		 

		System.out.println("number of properties "+mnm.getPropertiesCount()); 

		 
		

		 
	}

}
