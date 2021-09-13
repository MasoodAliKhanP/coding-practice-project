package com.google.code._6_Trees;

public class A1_BSTStructureCount {
	public static void main(String[] args) {
		int arr[] = {1,2,3,4};
		System.out.println("Count: " + dynamic(arr.length));
	}
	
    
    public static int recursive(int n){
        //If I take element i as root, with root i the number of unique subtrees are
        // product of uniqu subtrees on the left and on the rigth
        if(n== 0 || n==1){
             return 1;
        }
        if(n==2){
            return 2;
        }
        int sum = 0;
        for(int i = n; i >= 1; i--){
            sum = sum + recursive(i-1) * recursive(n-i);
        }
        return sum;
    } //we can also do memoization on this
    
    public static int dynamic(int n){
        int t[] = new int[n+1];
        
        t[0] = 1; t[1] = 1;
        
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                t[i] += t[j-1] * t[i-j];
            }
            //System.out.println("Array: " + Arrays.toString(t));
        }
        return t[n];
    }
}
