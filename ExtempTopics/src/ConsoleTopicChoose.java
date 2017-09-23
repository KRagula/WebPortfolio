import java.util.Scanner;

public class ConsoleTopicChoose {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("How many topic areas?");
		int areas = sc.nextInt();
		System.out.println("How many topics in each?");
		int topics = sc.nextInt();
		
		String topic1 = "Area: " + ((int) (Math.random()*areas) + 1) + ", Topic: "  + ((int) (Math.random()*topics) + 1);
		String topic2 = "Area: " + ((int) (Math.random()*areas) + 1) + ", Topic: "  + ((int)(Math.random()*topics) + 1);
		String topic3 = "Area: " + ((int) (Math.random()*areas) + 1) + ", Topic: "  + ((int)(Math.random()*topics) + 1);
		System.out.println(topic1);
		System.out.println(topic2);
		System.out.println(topic3);
	}
}
