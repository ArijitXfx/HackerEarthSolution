package com.segmenttree;

import java.util.Arrays;

public class SegmentTree {
	private int[] segmentTree;
	
	public SegmentTree(int[] arr, int n) {
		int height = (int) Math.ceil(Math.log(n)/Math.log(2));
		int maxSize = (int) (2*Math.pow(2, height)-1);
		segmentTree = new int[maxSize];
		constructTree(arr,0,n-1,0);
	}

	public void constructTree(int[] arr, int start, int end, int pos) {
		if(start==end) {
			segmentTree[pos] = arr[start];
			return;
		}
		int mid = (start+end)/2;
		constructTree(arr, start, mid, 2*pos+1);
		constructTree(arr,mid+1,end,2*pos+2);
		segmentTree[pos] = Math.max(segmentTree[2*pos+1],segmentTree[2*pos+2]);
	}
	
	public int rangeSumQuery(int qs, int qe,int start,int end, int pos) {
		//total overlap
		if(qs<=start && qe>=end)
			return segmentTree[pos];
		//no overlap
		else if(qe<start || qs>end)
			return 0;
		//partial overlap
		else {
			int mid = (start+end)/2;
			return Math.max(rangeSumQuery(qs, qe, start, mid, 2*pos+1), 
					rangeSumQuery(qs, qe, mid+1, end, 2*pos+2));
		}
	}
	
	public void updateValue(int[] arr, int n, int index, int value) {
		int diff = value-arr[index];
		arr[index] = value;
		updateValueUtil(0, n-1, index, diff, 0);
	}
	
	public void updateValueUtil(int start, int end, int index, int diff, int pos) {
		if(index<start || index>end) return;
		segmentTree[pos] += diff;
		if(start!=end) {
			int mid = (start+end)/2;
			updateValueUtil(start, mid, index, diff, 2*pos+1);
			updateValueUtil(mid+1, end, index, diff, 2*pos+2);
		}
	}
	
	public void printSegmentTree(int[] arr) {
		System.out.println("Original Array: "+Arrays.toString(arr));
		System.out.println("Segment Tree: "+Arrays.toString(segmentTree));
	}
}
