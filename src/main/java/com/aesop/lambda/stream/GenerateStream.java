package com.aesop.lambda.stream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenerateStream {

	/**Stream create:
	 * array method:
	 */
	//1.不能用基本类型定义:int[] arr={};
	public static void test1() {
		
		Integer[] arr={12,34,565,56};
		
		Stream.of(arr).forEach(System.out::println);
		
		Stream.of("apple","banana","orange","1").forEach(System.out::println);
		
		Stream.of(111,21,3,4,5).filter(x -> x%2==0).forEach(System.out::println);
	}
	/**Stream create:
	 * List method:
	 */
	public static void test2() {
		
		List<String> list=Arrays.asList("hello","baby","coffee");
		list.stream().forEach(System.out::println);
	}
	/**Stream create:
	 * Stream.generate() method:
	 */
	public static void test3() {
		
		Stream.generate(()->"hello world!").limit(4).forEach(System.out::println);
	}
	/**Stream create:
	 * Stream.iterate() method:
	 */
	public static void test4() {
		
		Stream.iterate(15, x -> x*2).limit(5).forEach(System.out::println);
	}
	/**Stream create:
	 * String.chars() method:
	 * return :ASCII码
	 */
	public static void test5() {
		
		String str="123abc";
		IntStream stream = str.chars();
		stream.forEach(System.out::println);
	}
	/**Stream create:
	 * Files.lines(Paths.get(path)) method:
	 * Path path=Paths.get("F:\\LoginServlet.java");
	 * return :Stream<String>
	 */
	public static void test6() throws Exception {
	
		Files.lines(Paths.get("F:/LoginServlet.java")).forEach(System.out::println);
		Files.lines(Paths.get("F:/aesoplog.txt")).forEach(System.out::println);
	}
	
	
	public static void test12() {
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "5");
		
		Optional<Integer> max = Stream.iterate(1, x->x+1).limit(200).peek(x->{
			System.out.println(x);
			System.out.println(Thread.currentThread().getName());
		}).parallel().max(Integer::compare);
		System.out.println(max.get());
	}
	
	public static void main(String[] args) throws Exception{
		
		//test1();
		//test2();
		//test3();
		//test4();
		//test5();
		test6();
		//test12();
	}

}
