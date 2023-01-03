import java.util.ArrayList;

public class Vigenere_Decryption {
 
  // Decryption Method found at: https://rosettacode.org/wiki/Vigen%C3%A8re_cipher#D  
  public String Decrypt(String text, final String key) {
    String result = "";

    text = text.toUpperCase();

    for (int i = 0, j = 0; i < text.length(); i++) {
        char c = text.charAt(i);
        if (c < 'A' || c > 'Z') continue;
        result += (char)((c - key.charAt(j) + 26) % 26 + 'A');
        j = ++j % key.length();
    }
    return result;
}

    /* Method found at: http://www.cs.trincoll.edu/~crypto/student/emilio/IC.java */
    public double ICcalculator(String data) {
      int N = 0;
    	double sum = 0.0;
    	double total = 0.0;
    	data = data.toUpperCase();
    	
    	//initialize array of values to count frequency of each letter
    	int[] values = new int[26];
    	for(int i = 0; i < 26; i++){
    		values[i] = 0;
    	}
    	
    	//calculate frequency of each letter in data
    	int ch;
    	for(int i=0; i < data.length(); i++){
    		ch = data.charAt(i) - 65;
    		if(ch >= 0 && ch < 26){
    			values[ch]++;
    			N++;
    			}	
    	}
    	
    	//calculate the sum of each frequency
    	for(int i = 0; i < 26; i++){
    		ch = values[i];
    		sum = sum + (ch * (ch - 1));
    		}
    	
    	//divide by N(N-1)	
    	total = sum/(N*(N-1));
    	
    	//return the result
    	return total;
    }

    public String findKey(String data, int key_length) {
      String key = "";
      for (int i = 0; i < key_length; i++) {
        String Epsilon = "";
        for (int j = i; j < data.length(); j += key_length) {
          char c = data.charAt(j);
          Epsilon += c;
        }
        ArrayList<Double> chiSquaredValues = new ArrayList<Double>();


        for (int k = 0; k < 26; k++) {
          chiSquaredValues.add((chiSquaredCalc(CaesarCipher(Epsilon, k)))); // Add each chi squared value to the array for each caesar cipher possible
        }

        double min = chiSquaredValues.get(0); // Set the minimum value to the first index. It is however subjected to change depending on the other values in the ArrayList
        int index = 0; // index of the lowest chi squared value must be saved in order to determine which character is apart of the key.

        for (int l = 0; l < chiSquaredValues.size(); l++) { 
          if(min > chiSquaredValues.get(l)) {
            min = chiSquaredValues.get(l);
            index = l;
          }
        }

        switch(index) { // Add the corresponding letter to the key
          case 0:
          key += "A";
          break;

          case 1:
          key += "B";
          break;

          case 2:
          key += "C";
          break;

          case 3:
          key += "D";
          break;

          case 4:
          key += "E";
          break;

          case 5:
          key += "F";
          break;

          case 6:
          key += "G";
          break;

          case 7:
          key += "H";
          break;

          case 8:
          key += "I";
          break;

          case 9:
          key += "J";
          break;

          case 10:
          key += "K";
          break;

          case 11:
          key += "L";
          break;

          case 12:
          key += "M";
          break;

          case 13:
          key += "N";
          break;

          case 14:
          key += "O";
          break;

          case 15:
          key += "P";
          break;

          case 16:
          key += "Q";
          break;

          case 17:
          key += "R";
          break;

          case 18:
          key += "S";
          break;

          case 19:
          key += "T";
          break;

          case 20:
          key += "U";
          break;

          case 21:
          key += "V";
          break;

          case 22:
          key += "W";
          break;

          case 23:
          key += "X";
          break;

          case 24:
          key += "Y";
          break;

          case 25:
          key += "Z";
          break;

        }
      }
      return key;  
    }

    // Finding the Chi squared statistic of a given string
    public double chiSquaredCalc(String data) {
      double result = 0.0;
      double occurenceOfletter;
      double chiSquared;
      double expectToAppear;

      for (int i = 0; i < data.length(); i++) {
        int occurence = 0;
        char c = data.charAt(i);
        for (int j = 0; j < data.length(); j++) {
          if(data.charAt(j) == c) { // finding how many of a certain character exist in the string and incrementing occurence for each one found
            occurence++; 
          }
        }

        switch(c) {

          case 'A':
          occurenceOfletter = 0.082;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear; 
          result += chiSquared;
          break;

          case 'B':
          occurenceOfletter = 0.015;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;

          case 'C':
          occurenceOfletter = 0.028;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;

          case 'D':
          occurenceOfletter = 0.043;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;

          case 'E':
          occurenceOfletter = 0.130;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;

          case 'F':
          occurenceOfletter = 0.022;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;

          case 'G':
          occurenceOfletter = 0.020;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;

          case 'H':
          occurenceOfletter = 0.061;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;

          case 'I':
          occurenceOfletter = 0.070;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;

          case 'J':
          occurenceOfletter = 0.0015;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;

          case 'K':
          occurenceOfletter = 0.0077;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;

          case 'L':
          occurenceOfletter = 0.040;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;

          case 'M':
          occurenceOfletter = 0.024;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;

          case 'N':
          occurenceOfletter = 0.067;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;

          case 'O':
          occurenceOfletter = 0.075;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;

          case 'P':
          occurenceOfletter = 0.019;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;
          case 'Q':
          occurenceOfletter = 0.0095;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;

          case 'R':
          occurenceOfletter = 0.060;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;

          case 'S':
          occurenceOfletter = 0.063;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;

          case 'T':
          occurenceOfletter = 0.091;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;

          case 'U':
          occurenceOfletter = 0.028;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;

          case 'V':
          occurenceOfletter = 0.0098;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;

          case 'W':
          occurenceOfletter = 0.024;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;

          case 'X':
          occurenceOfletter = 0.0015;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;

          case 'Y':
          occurenceOfletter = 0.020;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;

          case 'Z':
          occurenceOfletter = 0.0074;
          expectToAppear = occurenceOfletter * data.length();
          chiSquared = ((occurence - expectToAppear) * (occurence - expectToAppear)) / expectToAppear;
          result += chiSquared;
          break;
        }
      }
      return result;
    }

    // Ceasar cipher method that shifts backwards in the alphabet instead of forwards
    public String CaesarCipher(String data, int shift) {
      String result = "";
      for (int i = 0; i < data.length(); i++) {
        if(Character.isUpperCase(data.charAt(i))) {
          char c = (char)(data.charAt(i) - shift);
          if (c > 'Z') {
            c = (char) (c - 26);
        } else if (c < 'A') {
            c = (char) (c + 26);
        }
          result += c;
        }
        else {
          System.out.println("Only upper case characters are accepted. Please change the file.");
        }
      }
      return result;
    }

    // Method for finding the key length. Only works for keys of length 2 - 4
    public int FindKeyLength(String data) {
      
      ArrayList<Double> ICvaluesForLength2 = new ArrayList<Double>();
      ArrayList<Double> ICvaluesForLength3 = new ArrayList<Double>();
      ArrayList<Double> ICvaluesForLength4 = new ArrayList<Double>();

      for (int x = 2; x <= 4; x++) {
        if(x == 2) {
          for (int i = 0; i < 2; i++) {
            String result = "";
            for (int j = i; j < data.length(); j += 2) {
              char c = data.charAt(j);
              result += c;
            }
            ICvaluesForLength2.add(ICcalculator(result));
          }
      }

      else if(x == 3) {
        for (int i = 0; i < 3; i++) {
          String result = "";
          for (int j = i; j < data.length(); j += 3) {
            char c = data.charAt(j);
            result += c;
          }
          ICvaluesForLength3.add(ICcalculator(result));
        }
      }

      else if(x == 4){ 
        for (int i = 0; i < 4; i++) {
          String result = "";
          for (int j = i; j < data.length(); j += 4) {
            char c = data.charAt(j);
            result += c;
          }
          ICvaluesForLength4.add(ICcalculator(result));
        }
      }
    }

    double avgICLength2 = (ICvaluesForLength2.get(0) + ICvaluesForLength2.get(1)) / 2;
    double avgICLength3 = (ICvaluesForLength3.get(0) + ICvaluesForLength3.get(1) + ICvaluesForLength3.get(2)) / 3;
    double avgICLength4 = (ICvaluesForLength4.get(0) + ICvaluesForLength4.get(1) + ICvaluesForLength4.get(2) + ICvaluesForLength4.get(3)) / 4;

    if(avgICLength2 >= avgICLength3 && avgICLength2 >= avgICLength4) {
      return 2;
    }

    else if(avgICLength3 >= avgICLength2 && avgICLength3 >= avgICLength4) {
      return 3;
    }

    else {
      return 4;
    }
  }
}
