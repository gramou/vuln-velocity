
package de.gramou.wicket.example;

import java.io.Serializable;

public final class Person implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5586668445002003346L;

	private String firstName;

	private String lastName;

	/**
	 * Construct.
	 */
	public Person()
	{
	}

	/**
	 * Construct.
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		
	}

	/**
	 * Gets the firstName.
	 * 
	 * @return firstName
	 */
	public final String getFirstName()
	{
		return firstName;
	}

	/**
	 * Gets the lastName.
	 * 
	 * @return lastName
	 */
	public final String getLastName()
	{
		return lastName;
	}

	/**
	 * Sets the firstName.
	 * 
	 * @param firstName
	 *            firstName
	 */
	public final void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * Sets the lastName.
	 * 
	 * @param lastName
	 *            lastName
	 */
	public final void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
}