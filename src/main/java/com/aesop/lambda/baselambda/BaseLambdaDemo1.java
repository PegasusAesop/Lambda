package com.aesop.lambda.baselambda;

import java.util.function.Function;

import org.junit.Test;

public class BaseLambdaDemo1 {

	@Test
	public void invokeFunction() {
		
		String str="yesterday";
		Function<String,String> f0= a -> {return a+"@zset.com";};
		String r1 = f0.apply(str);
		System.out.println(r1);
		
		
		String str1="34";
		//Function<String,Integer> f1 = b -> Integer.parseInt(b);
		Function<String,Integer> f1 = Integer::parseInt;
		Integer r2=f1.apply(str1);
		System.out.println(r2);
	}
}
