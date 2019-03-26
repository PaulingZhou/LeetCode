package difficult;

/**
 * @description:
 * @author: Zhou Sihang
 * @date: 2019/03/22
 * @since: 1.0.1
 **/
public class Problem4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] list = new int[nums1.length + nums2.length];
        int start1 = 0;
        int start2 = 0;
        for (int i = 0; i < nums1.length + nums2.length; i++) {
            if (start2 == nums2.length) {
                list[i] = nums1[start1++];
            } else if (start1 == nums1.length) {
                list[i] = nums2[start2++];
            } else if(nums1[start1] <= nums2[start2]) {
                list[i] = nums1[start1++];
            } else {
                list[i] = nums2[start2++];
            }
        }
        return ((double) (list[(nums1.length + nums2.length) / 2] + list[(nums1.length + nums2.length - 1) / 2])) / 2;
    }
}
