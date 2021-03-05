public class Container_With_Most_Water {
    static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j= height.length - 1; i < j; ) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            max = Math.max(max, (j - i + 1) * minHeight);
        }
        return max;
    }
    public static void main(String[] args){
        int[] height = {5,9,95,52,21,1,0,51,0,2,56,4};
        System.out.println(maxArea(height));
    }

}