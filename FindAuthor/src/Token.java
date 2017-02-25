/**
 *
 */
package src;

/**
 * @author Adriano Hernandez
 * @version 28 January 2016
 * @date 28 January 2016
 *
 */
public final class Token 
{
	//INSTANCE VARIABLES
	private Scanner.TOKEN_TYPE type;
	private String value;
	
	//CONSTRUCTOR
	/**
	 * 
	 * @param ob
	 * @param value
	 */
	public Token(Scanner.TOKEN_TYPE type, String value)
	{
		this.type= type;
		this.value = value;
	}
	
	//ACCESSOR METHODS
	/**
	 * get token's type
	 * @return the type of the token
	 */
	public Scanner.TOKEN_TYPE getType()
	{
		return type;
	}
	/**
	 * get the token's value
	 * @return the value of this token
	 */
	public String getValue()
	{
		return value;
	}
	
	//OTHER METHODS
	/**
	 * print a short string describing this token
	 * @return the value of the string; type can be inferred from the value,
	 * so just the value can suffice to describe the token.
	 */
	@Override
	public String toString()
	{
		return value;
	}
	/**
	 * This is a temporary solution to equals.  It is not going to
	 * be our long term solution as it is a pretty bad way to check for
	 * equality.
	 * @param t is the token we are comparing this to
	 * @return whether t and this have the same type and value, case sensitive
	 */
	public boolean equals(Object o)
	{
		Token t = (Token) o;
		return value.equals(t.getValue());
	}
	
	public int hashCode(){
		return value.hashCode();
	}
	/**
	 * check whether two tokens are the same
	 * @param t is the token we are being compared to
	 * @return whether t and this have the same type and value, not case sensitive
	 */
	public boolean equalsIgnoreCase(Token t)
	{
		return toString().toLowerCase().equals(
				t.toString().toLowerCase());
	}
}
