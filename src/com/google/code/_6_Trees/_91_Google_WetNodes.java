package com.google.code._6_Trees;

import java.util.ArrayList;

class NArrayNode {
	ArrayList<NArrayNode> children;
	int wetTime;
}

public class _91_Google_WetNodes {
	public static void main(String[] args) {
		

	}

	public static int timeToGetTotallyWet(NArrayNode node) {
		if(node == null)
			return 0;
		if(node.children.size()==0) {
			return node.wetTime;
		}
		int maxWetTime = Integer.MIN_VALUE;
		for(NArrayNode iNode: node.children) {
			int wetTime = timeToGetTotallyWet(iNode);
			maxWetTime = Math.max(wetTime, maxWetTime);
		}
		return maxWetTime + node.wetTime;
	}

}
