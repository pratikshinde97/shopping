package com.example.shopping.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

final public class PageUtil {
	
	public static final int DEFAULT_CURRENT_PAGE_NO = 1;
	public static final int DEFAULT_PAGE_SIZE = 10;

	public static Pageable defaultPage(Optional<Integer> page, Optional<Integer> size){
		int currentPage = page.orElse(DEFAULT_CURRENT_PAGE_NO);
		int pageSize = size.orElse(DEFAULT_PAGE_SIZE);
		return PageRequest.of(currentPage - 1, pageSize);
	}

}
