/**
 * 
 */
package com.mavenpizza.pizzashoporder;

/**
 * @author Sonali
 *
 */
public class PizzaOutputFile implements Comparable<PizzaOutputFile>{
	String orderName;
	java.util.Date orderDate;
	
	public PizzaOutputFile(String orderName,java.util.Date orderDate) {
		this.orderName = orderName;
		this.orderDate = orderDate;
	}
	
	/**
	 * @return the orderName
	 */
	public String getOrderName() {
		return orderName;
	}
	/**
	 * @param orderName the orderName to set
	 */
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	/**
	 * @return the orderDate
	 */
	public java.util.Date getOrderDate() {
		return orderDate;
	}
	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(java.util.Date orderDate) {
		this.orderDate = orderDate;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	public int compareTo(PizzaOutputFile orderDate) {
//		// TODO Auto-generated method stub		
//		java.util.Date compareDate = ((PizzaOutputFile) orderDate).getOrderDate();
//		// ascending order
//		return this.orderDate.compareTo(compareDate);
//	}
        
        @Override
        public int compareTo(PizzaOutputFile orderName) {
		// TODO Auto-generated method stub		
		String CompareOrderName = ((PizzaOutputFile) orderName).getOrderName();
		// ascending order
		return this.orderName.compareToIgnoreCase(CompareOrderName);                                 
	}  
}
