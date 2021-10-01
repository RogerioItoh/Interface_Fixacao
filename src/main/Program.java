package main;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.services.ContratcService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
				
		
		System.out.println("Enter contract data : ");		
		System.out.print("Number: ");
		Integer number = sc.nextInt();		
		System.out.print("Date (dd/MM/yyyy):");
		Date date = sdf.parse(sc.next());
						
		System.out.print("Contract value: ");
		Double totalValue = sc.nextDouble();
		
		System.out.print("Enter number of installments: ");
		Integer installments = sc.nextInt();
		
		
		Contract contract = new Contract(number,date,totalValue);
		
		ContratcService service = new ContratcService(new PaypalService());
		service.proceesContract(contract, installments);
		
		
		System.out.println("Installments: ");
			 
		
		System.out.println(contract.getLstinstallment().toString());
			
				
 

	}

}
