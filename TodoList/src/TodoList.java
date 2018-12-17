/* TodoList.java
 * 
 * Tim Hyers
 * 
 */
import java.util.*;

public class TodoList 
{
	public static void main(String args[])
	{
		LinkedList<TodoItem> todoList = new LinkedList<TodoItem>();
		
		TodoItem item1 = new TodoItem(3, "10-29-2015", "Go to interview");
		TodoItem item2 = new TodoItem(1, "10-31-2015", "Hand in project");
		TodoItem item3 = new TodoItem(1, "10-18-2015", "sign up for classes");
		TodoItem item4 = new TodoItem(3, "10-6-2015", "Write an essay");
		TodoItem item5 = new TodoItem(2, "10-30-2015", "Meet with professor ");
		
		todoList.add(item1);
		todoList.add(item2);
		todoList.add(item3);
		todoList.add(item4);
		todoList.add(item5);
		
		System.out.println("before removal of item");
		for(int i=0; i<todoList.size(); i++)
	      {
	    	  System.out.println(todoList.get(i));
	      }
		System.out.println();
		
		System.out.println("remove item at position 1");
		todoList.remove(1); //remove item at specific location
		System.out.println();
		
		System.out.println("before sort");
		for(int i=0; i<todoList.size(); i++)
	      {
	    	  System.out.println(todoList.get(i));
	      }
		System.out.println();
		
		Collections.sort(todoList, new Comparator<TodoItem>()
		{
			/**
			 * (non-Javadoc)
			 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
			 */
			public int compare(TodoItem item1, TodoItem item2)
			{
				if(item1.getPriority() > item2.getPriority())
				{
					return -1;
				}
				else if(item1.getPriority() < item2.getPriority())
				{
					return 1;
				}else
					return 0;
				
			}
			
		});
	
		//print here
		
		//for loop
		System.out.println("for loop");
		for(int i=0; i<todoList.size(); i++)
	      {
	    	  System.out.println(todoList.get(i));
	      }
		System.out.println();
		
		//advanced for loop
		System.out.println("advanced for loop");
		for(TodoItem todoItem: todoList)
	      {
	    	  System.out.println(todoItem);
	      }
		System.out.println();
		//iterator
		System.out.println("iterator");
	      Iterator i = todoList.iterator();
	      while (i.hasNext()) {
	    	  System.out.println(i.next());
	      }
		
		
		
	}

}
