package array;

class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        // [0,0,1,1,1,2,2,3,3,4]
        if (nums.length == 0) return 0;

        int slow =0;
        int fast = 0;

        while (true) {
            while(fast < nums.length && nums[fast] == nums[slow]) {
                fast++;
            }

            if (fast == nums.length) return slow + 1;
            else {
                nums[++slow] = nums[fast++];
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {0,0,1,1,1,2,2,3,3,4};
        int num = removeDuplicates(input);

        for (int i=0; i<num; i++)
            System.out.print(input[i] + " ");
    }
}
