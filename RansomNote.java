import java.util.HashMap;
import java.util.Map;

/**
Problem ->
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true

Constraints:
You may assume that both strings contain only lowercase letters.
*/


/**Solution: -----------------------------------------------------------------------------------------------------------------
1. populate a map of characters from magazine. while populating the data keep count as value.
2. loop through ransomNote and check if character is available with some count in magazine map.
	a. if yes, decrement count by 1
	b. else, return false
* @author Nishant
**/
class RansomNote {
	
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazines = new HashMap<>();
        for(int i=0; i<magazine.length(); i++){
            if(magazines.get(magazine.charAt(i)) != null){
                magazines.put(magazine.charAt(i), magazines.get(magazine.charAt(i)) + 1);
            }
            else magazines.put(magazine.charAt(i), 1);
        }
        
        for(int i=0; i<ransomNote.length(); i++){
             if(magazines.get(ransomNote.charAt(i)) == null || magazines.get(ransomNote.charAt(i)) == 0)
                return false;
             else magazines.put(ransomNote.charAt(i), magazines.get(ransomNote.charAt(i)) - 1);
        }
        return true;
    }
    
    public static void main(String...strings) {
    	System.out.println("Output: "+canConstruct("aa", "aab"));
    }
}
