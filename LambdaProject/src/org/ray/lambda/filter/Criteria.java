package org.ray.lambda.filter;


public interface Criteria<T> {

	boolean search(T t);
	
}
