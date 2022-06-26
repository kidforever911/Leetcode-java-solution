/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long left = 0, right = n;
        while(left < right) {
            long mid = left + right >> 1;
            if(isBadVersion((int)mid)) right = mid;
            else left = mid + 1;
        }
        return (int)left;
    }
}