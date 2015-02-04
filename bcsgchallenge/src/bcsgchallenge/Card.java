//Piotr Jaskiewicz
package bcsgchallenge;

import java.util.Date;

public class Card implements Comparable<Card>
{	
	private String bankName;
	private String cardNumber;
	private Date expiryDate;
	private int maskingType;
	
	public Card(String bankName, String cardNumber, Date date, int maskingType)
	{
		this.setBankName(bankName);
		this.setCardNumber(cardNumber);
		this.setExpiryDate(date);
		this.setMaskingType(maskingType);
	}

	public String getBankName()
	{
		return bankName;
	}

	public void setBankName(String bankName)
	{
		this.bankName = bankName;
	}

	public String getCardNumber()
	{
		return cardNumber;
	}

	public void setCardNumber(String cardNumber)
	{
		this.cardNumber = cardNumber;
	}

	public Date getExpiryDate()
	{
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate)
	{
		this.expiryDate = expiryDate;
	}

	public int getMaskingType()
	{
		return maskingType;
	}

	public void setMaskingType(int maskingType)
	{
		this.maskingType = maskingType;
	}
	
	@Override
	public int compareTo(Card o)
	{
	    return getExpiryDate().compareTo(o.getExpiryDate());
	}
}
