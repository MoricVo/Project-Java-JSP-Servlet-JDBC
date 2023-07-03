package com.duan.paging;

import com.duan.sort.sorter;

public interface pageble {
	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	sorter getSorter();
}
