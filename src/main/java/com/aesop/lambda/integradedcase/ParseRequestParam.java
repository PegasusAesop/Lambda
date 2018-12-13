package com.aesop.lambda.integradedcase;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class ParseRequestParam {

	/**
	 * index.do?itemId=1&userId=10001&type=aseop&token=111111111111
	 */
	@Test
	public  void parseStringw() {
		
		String reqString="itemId=1&userId=10001&type=aseop&token=111111111111";
		//Stream.of(reqString.split("&")).forEach(System.out::println);
		//Stream.of(reqString.split("&")).map(str -> str.split("=")).forEach(System.out::println);
		Map<String, String> result = Stream.of(reqString.split("&"))
				.map(str -> str.split("="))
				.collect(Collectors
				.toMap(str -> str[0], str -> str[1]));
		
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		
		
	}

}
