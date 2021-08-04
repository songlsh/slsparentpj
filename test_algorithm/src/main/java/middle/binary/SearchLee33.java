package middle.binary;

/**
 * 33. 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class SearchLee33 {

    public int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {

                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[0] > nums[mid]) {
                if (target > nums[mid] && target <= nums[length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }
}
