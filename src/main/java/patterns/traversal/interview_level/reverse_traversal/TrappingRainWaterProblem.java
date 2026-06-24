package patterns.traversal.interview_level.reverse_traversal;

public class TrappingRainWaterProblem {
    public static void main(String[] args) {

        int[] height={4,2,0,3,2,5};


        int left=0; //left pointer starting at beginning
        int leftMax=0;//maximum height seen from left
        int right=height.length-1;//right pointer starting at end
        int rightMax=0;  //maximum height seen from right
        int water=0; //total trapped water

        while (left<right){
            if(height[left]<height[right]){
                if(height[left]>=leftMax){
                    leftMax=height[left];
                }else{
                    water+=leftMax-height[left];
                }
                left++;
            }else{
                if(height[right]>=rightMax){
                    rightMax=height[right];
                }else{
                    water+=rightMax-height[right];
                }
                right--;
            }
        }
        System.out.println("The water value is:"+water);




    }
}

/**
 * Index:  0  1  2  3  4  5
 * Height: 4  2  0  3  2  5
 *          |  |  |  |  |  |
 *          |  |  |  |  |  |
 *     |    |  |  |  |  |  |
 *     |    |  |  |  |  |  |
 * |  |    |  |  |  |  |  |
 * |  |    |  |  |  |  |  |
 * |  |  |  |  |  |  |  |  |
 * |  |  |  |  |  |  |  |  |
 * */
