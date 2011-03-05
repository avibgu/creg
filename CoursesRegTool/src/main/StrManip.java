/**
 * 
 */
package main;

/**
 * @author Avi Digmi
 *
 */
public class StrManip {

	
	public static String[] filterOutParamsForNextMessage(String textToFilter, String theFunctionOwnTheParams) {

		String[] splittedText = textToFilter.split(" ");
		
		String relevantString = "";
		
		for(int i=0; i < splittedText.length; i++){

			if( 0 == splittedText[i].compareTo(theFunctionOwnTheParams) ){

				relevantString = splittedText[i];
				break;
			}
		}
		
		int start = relevantString.indexOf("(");
		int end = relevantString.indexOf(")");

		relevantString = relevantString.substring(start+1, end);
		
		splittedText = relevantString.split("\'");
		
		return null;
	}

	public static String filterOutTheValueOf(String textToFilter, String whatToFind) {

		String value = "";

		String[] splittedText = textToFilter.split(" ");

		for(int i=0; i < splittedText.length; i++){

			if( 0 == splittedText[i].compareTo("name=" + whatToFind) ){

				value = splittedText[i+1];
				break;
			}
		}

		int start = value.indexOf("\"");
		int end = value.lastIndexOf("\"");

		return value.substring(start+1, end);		
	}
}
