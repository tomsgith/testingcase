package com.mum.assignment9_1;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArrayFlattenerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ArrayFlattenerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	public int[] flattenArray(int a_in[][]) {
		if(a_in==null)
			return null;
		int [] result= Arrays.stream(a_in).flatMapToInt(Arrays::stream).toArray();
		System.out.println(Arrays.toString(result));
		return result;
	}
}
