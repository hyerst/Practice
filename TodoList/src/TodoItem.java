
public class TodoItem implements Comparable <TodoItem> 
{
	public final static int High = 3;
	public final static int Medium = 2;
	public final static int Low = 1;

	public String task;
	public int priority;
	public String dueDate;

	TodoItem()
	{
		task = "blank";
		priority = Medium;
		dueDate = "01-01-2015";	
	}

	/**
	 * 
	 * @param task
	 * @param priority
	 * @param dueDate
	 */
	TodoItem(int priority, String dueDate, String task)
	{
		this.task = task;
		this.priority = priority;
		this.dueDate = dueDate;
	}

	/**
	 * 
	 * @return
	 */
	public String getTask() 
	{
		return task;
	}

	/**
	 * 
	 * @param task
	 */
	public void setTask(String task) 
	{
		this.task = task;
	}

	/**
	 * 
	 * @return priority
	 */
	public int getPriority() 
	{
		return priority;
	}

	/**
	 * 
	 * @param priority
	 */
	public void setPriority(int priority) 
	{
		this.priority = priority;
	}

	/**
	 * 
	 * @return
	 */
	public String getDueDate() 
	{
		return dueDate;
	}

	/**
	 * 
	 * @param dueDate
	 */
	public void setDueDate(String dueDate) 
	{
		this.dueDate = dueDate;
	}
	
	@Override
	/**
	 * 
	 */
	public String toString()
	{
		String itemPriority = null;
		switch (priority)
		{
		case High:
			itemPriority = "High";
			break;
		case Medium:
			itemPriority = "Medium";
			break;
		case Low:
			itemPriority = "Low";
			break;

		default:
			break;

		}
		return itemPriority + "\t" + this.dueDate + "\t" + this.task ;
	}

	@Override
	public int compareTo(TodoItem arg0) {
		// TODO Auto-generated method stub
		return 0;
	}



}
