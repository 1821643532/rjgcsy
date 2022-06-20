import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n;
		n = in.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = in.nextInt();
		}
		for(int i=1;i<n;i++) {
			b[i] = a[i] - a[i-1];
		}
		b[0] = 0;
		int[] result = subarray(b,1,n);
		for(int e:result)
			System.out.print(e+" ");
	}
	public static int[] crossSubarray(int[] a,int p,int q,int r) {
		int left_sum = -100000;
		int sum = 0;
		int left_max=p;
		for(int i=q-1;i>=p-1;i--) {
			sum = sum+a[i];
			if(sum>left_sum) {
				left_sum = sum;
				left_max = i;
			}
		}
		int right_sum = -100000;
		sum = 0;
		int right_max=q;
		for(int i=q;i<=r-1;i++) {
			sum = sum+a[i];
			if(sum>right_sum) {
				right_sum = sum;
				right_max = i;
			}
		}
		int[] result = {left_max,right_max,left_sum+right_sum};
		return result;
	}
	public static int[] subarray(int[] a,int p,int r) {
		if(p==r) {
				int[] x = {p,r,a[r-1]};
				return x;
		}
		else {
			int q = (p+r)/2;
			int[] x1 = subarray(a,p,q);
			int[] x2 = subarray(a,q+1,r);
			int[] x3 = crossSubarray(a,p,q,r);
			if(x1[2]>=x2[2]&&x1[2]>=x3[2])
				return x1;
			if(x2[2]>=x1[2]&&x2[2]>=x3[2])
				return x2;
			else
				return x3;
		}
	}
}