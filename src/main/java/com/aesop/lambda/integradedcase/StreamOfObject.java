package com.aesop.lambda.integradedcase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import com.aesop.lambda.domain.Book;

public class StreamOfObject {

	public List<Book> Books(){
		
		List<Book> books=new ArrayList<>();
		books.add(new Book(1,"JAVAEE",64.5,"编程语言",LocalDate.parse("2014-09-09")));
		books.add(new Book(2,"Python",44.5,"编程语言",LocalDate.parse("2013-09-10")));
		books.add(new Book(3,"JavaSe",54.5,"编程语言",LocalDate.parse("2018-09-09")));
		books.add(new Book(4,"MySQL",54.5,"数据库",LocalDate.parse("2015-12-09")));
		books.add(new Book(5,"Tomcat",64.5,"服务器",LocalDate.parse("2015-08-12")));
		
		return books;
	}
	
	//@Test
	public void  getBookId() {
		//[1, 2, 3, 4, 5]
		//Books().stream().map(book -> book.getId()).forEach(System.out::println);
		List<Integer> ids = Books().stream().map(book -> book.getId())
				.collect(Collectors.toList());
		System.out.println(ids);
		//[1, 2, 3, 4, 5]
		ids = Books().stream().map(Book::getId)
				.collect(Collectors.toList());
		System.out.println("对象方法引用："+ids);
		
		//1,2,3,4,5
		String idsChain=Books().stream()
		.map(book -> book.getId()+"").collect(Collectors.joining(","));
		System.out.println(idsChain);
		//(1,2,3,4,5)
		String idsChain1=Books().stream()
				.map(book -> book.getId()+"").collect(Collectors.joining(",","(",")"));
				System.out.println(idsChain1);
				
		String idsChain2=Books().stream()
				.map(book -> "'"+book.getId()+"'").collect(Collectors.joining(",","(",")"));
				System.out.println(idsChain2);
	}
	
	//@Test
	public void getType() {
		//[0, 0, 0, 1, 2]
		List<String> typeCol = Books().stream()
				.map(book -> book.getType()).collect(Collectors.toList());
		System.out.println(typeCol);
		//[0, 1, 2]
		List<String> typeCol1 = Books().stream()
				.map(book -> book.getType()).distinct().collect(Collectors.toList());
		System.out.println(typeCol1);
		//[0, 1, 2]
		Set<String> typeCol2 = Books().stream()
				.map(Book::getType).collect(Collectors.toSet());
		System.out.println(typeCol2);
	}
	
	//@Test
	public void sortBooks(){
	
		Books().stream()
		.sorted((book1,book2) -> (Double.compare(book1.getPrice(), book2.getPrice()))).forEach(System.out::println);;
		
		System.out.println("**********************************");
		Comparator<Book> comp=(a,b) -> Double.compare(a.getPrice(), b.getPrice());
		Books().stream()
		.sorted(comp.reversed()).forEach(System.out::println);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		Books().stream()
		.sorted(Comparator.comparing(Book::getPrice).reversed()).forEach(System.out::println);
		
	}
	
	//@Test
	public void bookToMap() {
		
		Map<Integer, Book> result = Books().stream().collect(Collectors.toMap(book -> book.getId(), book -> book));
		System.out.println(result);
		
		Map<Integer, Book> result1 = Books().stream().collect(Collectors.toMap(Book::getId, book -> book));
		System.out.println(result1);
		
		Double aver = Books().stream().collect(Collectors.averagingDouble(Book::getPrice));
		System.out.println(aver);
		
		Optional<Book> max = Books().stream().collect(Collectors.maxBy(Comparator.comparing(Book::getPrice)));
		System.out.println(max.get());
		
		//1.先是价格，再是出版时间来区别 ；
		Comparator<Book> comp=Comparator.comparing(Book::getPrice);
		Optional<Book> max1 = Books().stream().collect(Collectors.maxBy(comp.thenComparing(Comparator.comparing(Book::getPublishDate))));
		System.out.println(max1);
	}
	@Test
	public void getTypeAll() {
		
		Map<String, List<Book>> collect = Books().stream().collect(Collectors.groupingBy(Book::getType));
		
		System.out.println(collect);
		System.out.println(collect.keySet());
		System.out.println(collect.size());
		
		collect.keySet().forEach(key ->{ 
			System.out.println(key);
			System.out.println(collect.get(key));});
		
		//1每种类型数量的汇总；
		Map<String, Long> collect2 = Books().stream().collect(Collectors.groupingBy(Book::getType,Collectors.counting()));
		System.out.println(collect2);
		//2每种类型价格总和的汇总；
		Map<String, Double> collect3 = Books().stream()
				.collect(Collectors.groupingBy(Book::getType,Collectors.summingDouble(Book::getPrice)));
		System.out.println(collect3);
		
		//3每种类型价格平均的汇总；
		Map<String, Double> collect4 = Books().stream()
				.collect(Collectors.groupingBy(Book::getType,Collectors.averagingDouble(Book::getPrice)));
		System.out.println(collect4);
		
		//4每种类型价格最大者汇总；
		Map<String, Optional<Book>> collect5 = Books().stream()
				.collect(Collectors.groupingBy(Book::getType,Collectors.maxBy(Comparator.comparing(Book::getPrice))));
		System.out.println(collect5);
	}
}
