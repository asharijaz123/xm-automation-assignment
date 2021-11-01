package pojo;

import java.util.List;
/**
 * @author MUHAMMAD ASHAR
 * Dated: 29/10/2021
 */
public class films
{
	public int getCount ()
	{
		return count;
	}

	public void setCount (int count)
	{
		this.count = count;
	}


	public List<results> getResults ()
	{
		return results;
	}

	public void setResults (List<results> results)
	{
		this.results = results;
	}

	public List<results> results;
	public int count ;

	public String getNext ()
	{
		return next;
	}

	public void setNext (String next)
	{
		this.next = next;
	}

	public String getPrevious ()
	{
		return previous;
	}

	public void setPrevious (String previous)
	{
		this.previous = previous;
	}

	public String next;
	public String previous;




}

