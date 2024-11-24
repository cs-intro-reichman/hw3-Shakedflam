/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String firstStr=preProcess(str1);
		String secondStr=preProcess(str2);
		int length=firstStr.length();
		if (firstStr.length()!=secondStr.length()){
			return false;
		}
		for (int i=0;i<length;i++){
			int noMatch=0;
			char atI=firstStr.charAt(i);
			if (atI==32){
				continue;
			}
			for (int j=0; j<length;j++){
				char atJ=secondStr.charAt(j);
				if (atI!=atJ){
					noMatch++;
				}else{
					break;
				}
				if (noMatch==length){
					return false;
				}
			}

		}
		for (int i=0; i<length;i++){
			int noMatch=0;
			char atI=secondStr.charAt(i);
			if (atI==32){
				continue;
			}
			for (int j=0;j<length;j++){
				char atJ=firstStr.charAt(j);
				if (atJ!=atI){
					noMatch++;
				}else{
					break;
				}
				if (noMatch==length){
					return false;
				}
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String lowerCases= str.toLowerCase();
		String newString="";
		for (int i=0;i<str.length();i++){
			if(((lowerCases.charAt(i)>=97 && lowerCases.length()<=122) || (lowerCases.charAt(i)>=48 && lowerCases.charAt(i)<=57)) || lowerCases.charAt(i)==32 ){
				newString="" +newString+lowerCases.charAt(i);
			}else{

			}
		}
		return newString;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String randomAnagrma="";
		String str1=str;
		int length=str.length();
		while (length>0){
			int randomNumber=(int)(Math.random()*str1.length());
			randomAnagrma+=str1.charAt(randomNumber);
			String leftPart="";
			String rightPart="";
			for (int i=0;i<randomNumber;i++){
				leftPart+=str1.charAt(i);
			}
			for (int j=randomNumber+1;j<length;j++){
				rightPart+=str1.charAt(j);
			}
			str1=leftPart+rightPart;
			length--;
		}

		return randomAnagrma;
	}
}
