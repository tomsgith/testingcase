package com.mum.assignment9_2;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.mum.assignment9_2.service.IArrayFlattnerService;

public class ArrayReversorTestCases {
	
	ArrayFlattener2Application arrayFlattener2Application=null;
	IArrayFlattnerService arrayFlattnerService;
	
	
	@Before
	public void setUp() throws Exception {
		arrayFlattener2Application = new ArrayFlattener2Application();
		arrayFlattnerService = mock(IArrayFlattnerService.class);
		arrayFlattener2Application.setArrayFlattenerService(arrayFlattnerService);
		
		}


	@After
	public void tearDown() throws Exception {
		arrayFlattener2Application=null;
		
	}

	
	@Test
	public void test() {
		
		int inputArray[][]=new int[][] {{1,3},{0},{4,5,9}};
		when(arrayFlattnerService.flattenArray(inputArray)).thenReturn(new int[] {1,3,0,4,5,9});
		int result[]=arrayFlattener2Application.reverseArray(inputArray);
		int expected[]= {9,5,4,0,3,1};
		Assert.assertArrayEquals(result,expected);
		verify(arrayFlattnerService).flattenArray(inputArray);
		
	}
	@Test
	public void testnull() {
		
		int inputArray[][]=null;
		when(arrayFlattnerService.flattenArray(inputArray)).thenReturn(null);
		int result[]=arrayFlattener2Application.reverseArray(inputArray);
		int expected[]= null;
		Assert.assertArrayEquals(result,expected);
		verify(arrayFlattnerService).flattenArray(inputArray);
		
	}

}
