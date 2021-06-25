/***********************************************************************
 * Module:  Task.java
 * Author:  Dusan
 * Purpose: Defines the Class Task
 ***********************************************************************/

import java.util.*;

/** @pdOid 8148abb2-6ad0-48db-a471-29091f8918de */
public class Task {
   /** @pdOid 35c761b9-8766-4722-b2d3-2398a78906ce */
   private int taskID;
   /** @pdOid 9da4f365-108e-480b-a70e-d57801e14bc6 */
   private String taskTitle;
   /** @pdOid 081c2104-95e9-4754-9614-78a75c3f53f2 */
   private String taskDescription;
   /** @pdOid 1beb8eb8-c883-4d40-8a63-b7f70e9792a2 */
   private String taskNotes;
   /** @pdOid 82af5b18-293b-4620-b945-d89f8aedd241 */
   private String taskRoles;
   /** @pdOid 97cfc15f-370a-427f-8e37-2ec54c75c147 */
   private ArrayList<Employee> taskAssignments;
   /** @pdOid 6974e332-5cb8-4a53-b1f3-e8bc88649a7b */
   private java.util.Date taskDeadline;
   /** @pdOid c3e7f630-fb3b-4e4b-a9e0-a45a29e91cf3 */
   private java.util.Date taskStart;
   
   /** @pdRoleInfo migr=no name=Employee assc=association1 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<Employee> employee;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Employee> getEmployee() {
      if (employee == null)
         employee = new java.util.HashSet<Employee>();
      return employee;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorEmployee() {
      if (employee == null)
         employee = new java.util.HashSet<Employee>();
      return employee.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newEmployee */
   public void setEmployee(java.util.Collection<Employee> newEmployee) {
      removeAllEmployee();
      for (java.util.Iterator iter = newEmployee.iterator(); iter.hasNext();)
         addEmployee((Employee)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newEmployee */
   public void addEmployee(Employee newEmployee) {
      if (newEmployee == null)
         return;
      if (this.employee == null)
         this.employee = new java.util.HashSet<Employee>();
      if (!this.employee.contains(newEmployee))
         this.employee.add(newEmployee);
   }
   
   /** @pdGenerated default remove
     * @param oldEmployee */
   public void removeEmployee(Employee oldEmployee) {
      if (oldEmployee == null)
         return;
      if (this.employee != null)
         if (this.employee.contains(oldEmployee))
            this.employee.remove(oldEmployee);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllEmployee() {
      if (employee != null)
         employee.clear();
   }

}