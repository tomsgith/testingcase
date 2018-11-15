package com.mum.assignment9_1;

import static org.junit.Assert.assertArrayEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrayFlattener {
	ArrayFlattenerApplication arrayFlattener=null;
	@Before
	public void setUp() throws Exception {
		this.arrayFlattener=new ArrayFlattenerApplication();
	}

	@After
	public void tearDown() throws Exception {
		arrayFlattener=null;
	}
	
//Q14 .a
	@Test
	public void testFlattenArray() {
		int result[] =arrayFlattener.flattenArray(new int[][] {{1,3},{0},{4,5,9}});
		int expected[]= {1,3,0,4,5,9};
		assertArrayEquals(expected,result);
	}
	
	
	
//Q14 .b
	@Test
	public void testnullFlattenArray() {
		int result[] =arrayFlattener.flattenArray(null);
		int expected[]= null;
		assertArrayEquals(expected,result);
	}


}
