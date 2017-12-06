package AdditionalHelper;

import java.security.SecureRandom;

import core.helpers.Element;
import core.webElement.EnhancedBy;
import core.webElement.EnhancedWebElement;

public class AdditionalHelpers {

	
    /**
     * gets specified attribute of the element
     * @param byValue
     * @param index
     * @param attribute
     */
	public static String getAttribute(EnhancedBy byValue, String attribute) {
		return getAttribute(byValue, 0, attribute);
	}
	
    /**
     * gets specified attribute of the element based on index
     * @param byValue
     * @param index
     * @param attribute
     */
	public static String getAttribute(EnhancedBy byValue, int index, String attribute) {
		EnhancedWebElement element = Element.findElements(byValue);
		return element.getAttribute(attribute, index);
	}
	
	/**
	 * generates random int of length len
	 * @param len
	 * @return
	 */
	public static String generateRandomInteger(int len) {
		String AB = "0123456789";
		SecureRandom rnd = new SecureRandom();

		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}
}