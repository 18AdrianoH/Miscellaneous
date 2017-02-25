/**
* @author Harker comp sci department
* @version 12 January 2016
* This class is a rectangle
*/
public class Rectangle
{
	private int length;
	private int width;

	/**
	 * @param len length of the rectangle
	 * @param w width of the rectangle
	 * this creates a rectangle of len by w
	 */
	public Rectangle(int len, int w)
	{
		length = len;
		width = w;
	}

	/**
	 * @return length of the rectangle
	 */
	public int getLength()
	{
		return length;
	}

	/**
	 * @return width of the rectangle
	 */
	public int getWidth()
	{
		return width;
	}

	/**
	 * @return the length by the width in a string format
	 */
	public String toString()
	{
		return length + "x" + width;
	}
	/**
	 * 
	 * @param r is the reectangle we are testing
	 * @return true if this is equal to r; otherwise,
	 * 		   false.
	 */
	public boolean equals(Object or)
	{
		Rectangle r = (Rectangle)or;
		if(r.getLength() == length && r.getWidth() == width)
		{
			return true;
		}
		return false;
	}
	/**
	 * @return the hash code for a rectangle.
	 */
	public int hashCode()
	{
		return (int)((length)/(width)+0.5);
	}
}