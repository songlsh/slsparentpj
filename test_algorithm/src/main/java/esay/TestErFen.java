package esay;

public class TestErFen {

    public static void main(String[] args) {
//        nums = [-1,0,3,5,9,12], target = 9
        int search = new TestErFen().search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
        System.out.println(search);

        int searchLeft = new TestErFen().leftSearch(new int[]{-1,9,9,9,9,10,11,12,13}, 9);
        System.out.println(searchLeft);

        int searchRight = new TestErFen().RightSearch(new int[]{-1,9,9,9,9,10,11,12,13}, 9);
        System.out.println(searchRight);
    }

    /**
     *  二分法 前提是有一个排好序的数组
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        // 设置 开始结束索引
        int start = 0, end = nums.length-1;
        while (start <= end) {
            // 设置中间位置索引
            int middle =  (end + start)/2;

            if (target > nums[middle]) {
                // 目标大于中间值 说明目标值在middle的右侧 需要把开始位置置为 右加1 {+1 是为了从新的位置开始}
                start = middle+1;
            } else if (target < nums[middle]) {
                // 目标值在middle左侧  把结束位置置为 middle-1 处
                end = middle-1;
            }else {
                return middle;
            }
        }
        return -1;
    }

    /**
     *  二分法 查找做左边界
     *
     * @param nums
     * @param target
     * @return
     */
    public int leftSearch(int[] nums, int target) {
        // 设置 开始结束索引
        int start = 0, end = nums.length-1;
        // 因为等于可能出现死循环
        while (start < end) {   // 注意。。。
            // 设置中间位置索引
            int middle =  (end + start)/2;
            // 因为要查找到左边界问题所以会出现 多个值 所以 相等的时候 值可能是 nums[middle] 或者是在左边。
            if (target <= nums[middle]) {
                // 因为可能是middle是它的边界之一所以需要等于middle
                end = middle;
            }else {
                start  = middle +1;
            }
        }
        return nums[start] == target ? start : -1;
    }

    /**
     *  二分法 查找做有边界
     *
     * @param nums
     * @param target
     * @return
     */
    public int RightSearch(int[] nums, int target) {
        // 设置 开始结束索引
        int start = 0, end = nums.length-1;
        // 因为等于可能出现死循环
        while (start < end) {   // 注意。。。
            // 设置中间位置索引
            int middle =  (end + start)/2 +1 ;  // 注意 为了使得中间值靠右
            // 因为要查找到左边界问题所以会出现 多个值 所以 相等的时候 值可能是 nums[middle] 或者是在左边。
            if (target >= nums[middle]) {
                // 因为可能是middle是它的边界之一所以需要等于middle
                start = middle;
            }else {
                end  = middle -1;
            }
        }
        return nums[start] == target ? start : -1;
    }
}
