/**
 * Problem: Product of Array Except Self
 * Link: https://leetcode.com/problems/product-of-array-except-self/
 * * Time Complexity: O(n) - Two independent linear passes across the array.
 * Space Complexity: O(1) - Utilizing the output array as space, no extra auxiliary arrays used.
 */

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Calculate prefix products (products of all elements to the left)
        result[0] = 1; // Nothing is to the left of the first element
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate suffix products on the fly (products of all elements to the right)
        int suffixProduct = 1; // Nothing is to the right of the last element
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * suffixProduct;
            suffixProduct *= nums[i]; // Update suffix product for the next element to the left
        }

        return result;
    }
}