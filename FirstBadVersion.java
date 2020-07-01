/**
*Problem->
*You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
*
*Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
*
*You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
*
*-----------
*Example->
*Given n = 5, and version = 4 is the first bad version.
*
*call isBadVersion(3) -> false
*call isBadVersion(5) -> true
*call isBadVersion(4) -> true
*
*Then 4 is the first bad version. 
*
*/


/**Solution: -----------------------------------------------------------------------------------------------------------------
* The input array contains incremental versions. So, we can fairly assume that the array is sorted.
* thus, binary search can be leveraged by divide the array in two parts by mid element and recursively checking for the first bad version.
*
* if the mid version is bad and the mid-1 version is not bad, then return the mid version.
* else if the mid-1 version is bad, then do the same for the left half.
* else do the same for the right half.
*
* program has been written for 0th based index. For example -> at 0th index there is actually the first version present
* @author Nishant
**/
public class FirstBadVersion{
    private static int badVersion = 2;
	
    //provided method
    public static boolean isBadVersion(int n) {
	return badVersion == n;
    }
	
    public static int firstBadVersion(int n) {
        return bs(0, n-1);
    }
    
    // Algorithm implemented
    public static int bs(int l, int h){
        int mid = l + (h-l)/2;
        if(isBadVersion(mid+1) && !isBadVersion(mid))
            return mid+1;
        else if(isBadVersion(mid))
            return bs(l, mid-1);
        else
            return bs(mid+1, h);
    }
    
    public static void main(String...strings) {
    	System.out.println("First bad version is: " +firstBadVersion(5));
    }
    
}
