package com.bankinformationjobs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BankInformationJobsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankInformationJobsApplication.class, args);

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = "1234";
		String passwordDB = "Samuel2016#---";
		String encodedPassword = passwordEncoder.encode(password);
		String encodedPasswordDb = passwordEncoder.encode(encodedPassword);

		System.out.println();
		System.out.println("Password is         : " + password);
		System.out.println("Encoded Password is : " + encodedPassword);
		System.out.println("Invalid Password is : " + encodedPassword + "junk");
		System.out.println();

		System.out.println();
		System.out.println("passwordDB is         : " + passwordDB);
		System.out.println("Encoded passwordDB is : " + encodedPasswordDb);
		System.out.println("Invalid passwordDB is : " + encodedPasswordDb + "junk");
		System.out.println();

		boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword+"junk");
		System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);

		boolean isPasswordDBMatch = passwordEncoder.matches(encodedPassword, encodedPasswordDb+"junk");
		System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordDBMatch);

	}

}
