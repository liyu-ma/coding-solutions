package array;

public class HeightChecker {

    public static int heightChecker(int[] heights) {
        int[] counts = new int[101];
        for (int h : heights) {
            counts[h]++;
        }

        int ret = 0;
        int j = 0;
        for (int i=1; i<counts.length; i++) {
            int count = counts[i];
            if (count > 0) {
                for (int k=0; k<count; k++) {
                    if (heights[j++] != i)
                        ret++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] heights = new int[] { 1,2,3,4,5 };
        int[] expected = new int[]{ 1,2,3,4,5 };

        int ret = heightChecker(heights);
        System.out.print(ret);
    }
}
