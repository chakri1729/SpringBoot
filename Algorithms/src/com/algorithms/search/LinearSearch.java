package com.algorithms.search;

import java.util.Collection;
import java.util.LinkedList;

public class LinearSearch<T> {

	public boolean isContains(Collection<T> collection, T searchKey) {

		// return collection.contains(searchKey);

		if (searchKey == null)
			return false;

		for (T t : collection) 
			if(searchKey.equals(t))
				return true;
		
		return false;
	}
	
	public boolean isContains(LinkedList<T> linkedList, T searchKey) {
		if(searchKey == null || linkedList == null)
			return false;
		
		// return linkedList.contains(searchKey);
		
		for(T t: linkedList)
			if(searchKey.equals(t))
				return true;
		
		return false;
	}

}
