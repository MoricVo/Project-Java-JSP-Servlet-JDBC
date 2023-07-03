	package com.duan.paging;

import com.duan.sort.sorter;

public class page_request implements pageble {
	private Integer page;
	private Integer maxPageItem;
	private sorter sorter1;
     public page_request(Integer page,Integer maxPageItem,sorter sorter1)
    {
    	 this.page=page;
    	 this.maxPageItem=maxPageItem;
		 this.sorter1=sorter1;
	}
	@Override
	public Integer getPage() {
		
		return this.page;
	}

	@Override
	public Integer getOffset() {
		if(this.page!=null&&this.maxPageItem!=null)
		{
			return (this.page-1)*this.maxPageItem;
		}
		return null;
	
	}

	@Override
	public Integer getLimit() {
		// TODO Auto-generated method stub
		return this.maxPageItem;
	}
	@Override
	public sorter getSorter() {
		if(this.sorter1!=null)
		{
			return this.sorter1;
		}
		return null;
	}
	

}
