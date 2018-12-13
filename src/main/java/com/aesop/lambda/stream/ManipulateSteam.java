package com.aesop.lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.aesop.lambda.domain.Book;

public class ManipulateSteam {

	/**
	 * 1求出数组中偶数或奇数，并打印在console上；
	 */
	public static void test1() {
		
		Arrays.asList(1,2,3,4,5,22,12)
		.stream()
		.filter(x -> x%2==1)
		.forEach(System.out::println);
	}
	/**
	 * 2找出数组中所有奇数或偶数的元素，并将这些元素放到另一个集合中；
	 */
	public static void test2() {
		
		List<Integer> collect = Arrays.asList(1,2,2,3,4,5,22,12)
		.stream()
		.filter(x -> x%2==0)
		.collect(Collectors.toList());
		collect.forEach(System.out::println);
		
		//1可以重复的元素；
		Arrays.asList(1,2,2,3,4,5,22,12)
		.stream()
		.filter(x -> x%2==0)
		.collect(Collectors.toSet()).forEach(System.out::println);
		
	}
	/**
	 * 3数组元素为String类型，先将元素转换为int型mapToInt()；
	 * 3.1将转换后元素按偶数过滤并求和；
	 */
	
	public static void test3() {
		
		List<String> list=Arrays.asList("1","2","3","4","5","6","7","2");
		int sum = list.stream()
		.mapToInt(x -> Integer.parseInt(x))
		.filter(x -> x%2==0)
		.sum();
		System.out.println(sum);
	}
	
	/**
	 * 4找数组元素中最大(小)数；
	 * Optional<T> max(Comparator<? super T> comparator)
	 *  41两个比较数可以调整，即可求最大(小)数；
	 */
	public static void test4() {
		
		Integer max = Arrays.asList(1,2,234,3,4,5,22,12)
		.stream()
		.max((a,b) ->a-b) //max
		//.max((a,b) -> b-a) //min
		.get();
		
		System.out.println(max);
		
		Integer min = Arrays.asList(1,2,234,3,4,5,22,12)
		.stream()
		.min((a,b) -> a-b)
		.get();
		
		System.out.println(min);
	}
	
	/**
	 * 寻找字符串数组中元素length最大(小)的元素；
	 */
	public static void test5() {
		
		Optional<String> max = Arrays.asList("hello","baby","Aesop","pegasus","diffrent","German")
		.stream()
		.max((a,b) -> (a.length()-b.length()));
		System.out.println(max.get());
	}
	/**
	 * 6查找 普通查找一个任意的偶数；
	 * 61逆序排列后查找第一个；findFirst;
	 */
	public static void test6() {
		
		Optional<Integer> findAny = Arrays.asList(1,2,234,3,4,5,22,12)
		.stream()
		.filter(x -> x%2==0)
		.findAny();
		System.out.println(findAny.get());
		
		Optional<Integer> findFirst = Arrays.asList(1,2,234,3,4,5,22,12)
		.stream()
		.filter(x -> x%2==0)
		.sorted((a,b) ->b-a )
		.findFirst();
		System.out.println(findFirst);
		
		Arrays.asList("hello","baby","Aesop","pegasus","diffrent","German")
		.stream()
		.sorted((a,b) ->-a.length()+b.length())
		.forEach(System.out::println);
		
	}
	/**
	 * 1-50中所有偶数找出来并放到一个list集合中；
	 */
	public static void test7() {
	
		List<Integer> collect = Stream.iterate(1, x -> x+1)
		.limit(50)
		.filter(x-> x%2==0)
		.collect(Collectors.toList());
		
		collect.stream().forEach(System.out::println);
	}
	/**
	 * 8两种方式的去除相同的元素；
	 */
	public static void test8() {
		
		Arrays.asList(1,2,2,3,4,5,5,12)
		.stream()
		.distinct()
		.forEach(System.out::println);
		
		Set<Integer> collect = Arrays.asList(1,2,2,3,4,5,5,12)
		.stream()
		.collect(Collectors.toSet());
		
		collect
		.stream().forEach(System.out::println);
	}
	/**
	 * 9分页制作：
	 */
	public static void test9() {
		
		Stream.iterate(1, x -> x+1)
		.limit(50)
		.sorted((a,b) ->b-a)
		.skip(4*10)
		.limit(10)
		.collect(Collectors.toList())
		.forEach(System.out::println);
	}
	/**
	 * 10字符串："1,2,3,4,5,6,7,8,9,10"转化为IntegerList并求和；
	 */
	public static void test10() {
		String str="1,2,3,4,5,6,7,8,9,10";
		int sum = Stream.of(str.split(","))
		.mapToInt(x -> Integer.parseInt(x))
		.sum();
		System.out.println("sum:"+sum);
		
		int sum2 = Stream.of(str.split(","))
		.map(Integer::valueOf)
		.mapToInt(x -> x)
		.sum();
		System.out.println("sum2="+sum2);
	}
	/**
	 * 11将字符串"java,apache,tomcat,javeee"中每
	 * 111一项赋值给一个对象中的属性值；
	 */
	public static void test11() {
		
		String str="java,apache,tomcat,javeee";
		/*Stream.of(str.split(","))
		.map(x -> new Book(x))
		.forEach(System.out::println);*/
		//1枸造方法引用；
		Stream.of(str.split(","))
		.map(Book::new)
		.forEach(System.out::println);
	}
	/**
	 * 12中间操作peek()方法的引用；
	 * 122可以做到先显示所有元素的作用；
	 */
	public static void test12() {
		
		Arrays.asList(1,2,2,3,4,5,5,12)
		.stream()
		.peek(System.out::println)
		.forEach(System.out::println);
		
		Integer max = Arrays.asList(1,2,234,3,4,5,22,12)
				.stream()
				.peek(System.out::println)
				.max((a,b) ->a-b) //max
				.get();
		
		System.out.println(max);
	}
	
	public static void main(String[] args) {
		
		//test1();
		//test2();
		//test3();
		//test4();
		//test5();
		//test6();
		//test7();
		//test8();
		//test9();
		//test10();
		//test11();
		test12();
	}
}
