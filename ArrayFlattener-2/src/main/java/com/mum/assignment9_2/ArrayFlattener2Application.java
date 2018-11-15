package com.mum.assignment9_2;

import java.util.stream.IntStream;

import org.mockito.Mock;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mum.assignment9_2.service.IArrayFlattnerService;

@SpringBootApplication
public class ArrayFlattener2Application implements CommandLineRunner{
	@Mock
	IArrayFlattnerService arrayFlattenerService;
	
	
	public void setArrayFlattenerService(IArrayFlattnerService arrayFlattenerService) {
		this.arrayFlattenerService = arrayFlattenerService;
	}
	public static void main(String[] args) {
		SpringApplication.run(ArrayFlattener2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public int[] reverseArray(int[][] twoDArray) {
		int flaterned[]=arrayFlattenerService.flattenArray(twoDArray);
		//int flaterned[]={1,3,0,4,5,9};
		if(flaterned==null)
			return null;
		return IntStream.rangeClosed(1, flaterned.length)
				.map(x->flaterned[flaterned.length-x])
				.toArray();
		
	}

	
	
}
