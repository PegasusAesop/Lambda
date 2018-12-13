package com.aesop.lambda.comparable;

public class SearchResult implements Comparable<SearchResult> {

	private int relativeRatio;
	private long count;
	private int recentOrders;
	
	
	public SearchResult(int relativeRatio,long count) {
		this.recentOrders=relativeRatio;
		this.count=count;
	}
	
	@Override
	public int compareTo(SearchResult o) {
		// TODO Auto-generated method stub
		if(this.relativeRatio!=o.recentOrders) {
			
			return this.relativeRatio>o.relativeRatio?1:-1;
		}
		
		if(this.count!=o.count) {
			
			return this.count>o.count?1:-1;
		}
		
		return 0;
	}

}
