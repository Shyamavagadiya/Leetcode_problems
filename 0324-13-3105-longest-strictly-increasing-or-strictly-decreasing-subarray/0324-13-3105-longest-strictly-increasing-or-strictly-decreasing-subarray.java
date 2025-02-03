import java.util.Scanner;

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 1) return 1; // If only one element, return 1

        int inc = 1, dec = 1; // Length of increasing and decreasing subarrays
        int maxLength = 1; // Track the maximum length

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) { 
                inc++;  // Increase inc length
                dec = 1; // Reset decreasing count
            } else if (nums[i] < nums[i - 1]) { 
                dec++;  // Increase dec length
                inc = 1; // Reset increasing count
            } else { 
                inc = 1; // Reset both counts if numbers are equal
                dec = 1;
            }
            maxLength = Math.max(maxLength, Math.max(inc, dec)); // Update max
        }
        return maxLength;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for array size
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        
        int[] nums = new int[n];

        // Taking input for array elements
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Compute and print result using Solution class
        Solution sol = new Solution();
        int result = sol.longestMonotonicSubarray(nums);
        System.out.println("Length of the longest strictly increasing or decreasing subarray: " + result);

        scanner.close(); // Close scanner
    }
}
