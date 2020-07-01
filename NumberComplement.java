/**
Problem ->
Given a positive integer num, output its complement number. The complement strategy is to flip the bits of its binary representation.

Example 1:
Input: num = 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

Example 2:
Input: num = 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 

Constraints:
The given integer num is guaranteed to fit within the range of a 32-bit signed integer.
num >= 1
You could assume no leading zero bit in the integer’s binary representation.
*/


/**Solution: -----------------------------------------------------------------------------------------------------------------
1. Get the binary string of the number.
2. create a new StringBuilder of same length.
3. loop through all the characters of the binary string
	a. if character is 1, then append 0
	b. else append 1
4. return the Integer value of the output binary string.
* @author Nishant
**/
class NumberComplement {
	
    public static int findComplement(int num) {
        String s = Integer.toBinaryString(num); 
        System.out.println(s);
        StringBuilder sb = new StringBuilder(s.length());
        for(int i=0; i<s.length(); i++){
            if('1' == s.charAt(i)){
                sb.append('0');
            }else{
                sb.append('1');
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }
   
    public static void main(String...strings) {
    	System.out.println("Output: "+findComplement(5));
    }
	
}
