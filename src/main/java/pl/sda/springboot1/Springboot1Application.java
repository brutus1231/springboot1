package pl.sda.springboot1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

@SpringBootApplication
public class Springboot1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Springboot1Application.class, args);
		System.out.println("Hello world !!");

		WorkDayCalculator workDayCalculator = (WorkDayCalculator) context.getBean("workDayCalculator");
		boolean isWorkDay = workDayCalculator.check(new Date());
		System.out.println(isWorkDay ? "dzien nie przypada w weekend" : "dzien przypada w weekend");


		workDayCalculator.print();
	}

}
