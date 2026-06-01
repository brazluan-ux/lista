package gpt;


class Solution17 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1, B = nums2;
        int m = A.length, n = B.length;
        if (m > n) {
            A = nums2; B = nums1;
            m = A.length; n = B.length;
        }

        int total = m + n;
        int half = (total + 1) / 2;

        int lo = 0, hi = m;
        while (lo <= hi) {
            int i = lo + (hi - lo) / 2;
            int j = half - i;

            int Aleft = (i == 0) ? Integer.MIN_VALUE : A[i - 1];
            int Aright = (i == m) ? Integer.MAX_VALUE : A[i];
            int Bleft = (j == 0) ? Integer.MIN_VALUE : B[j - 1];
            int Bright = (j == n) ? Integer.MAX_VALUE : B[j];

            if (Aleft <= Bright && Bleft <= Aright) {
                int leftMax = Math.max(Aleft, Bleft);
                if ((total & 1) == 1) return (double) leftMax;

                int rightMin = Math.min(Aright, Bright);
                return ((double) leftMax + (double) rightMin) / 2.0;
            } else if (Aleft > Bright) {
                hi = i - 1;
            } else {
                lo = i + 1;
            }
        }

        return 0.0;
    }
}