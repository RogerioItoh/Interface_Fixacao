package model.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import model.entities.Contract;
import model.entities.Installment;

public class ContratcService {

	
	
	private OnlinePaymentService paymentService;
	
		
	
	public ContratcService(OnlinePaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}



	public void proceesContract(Contract contract , Integer months) 
	{
				
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Double interest = 0.0;
		Double paymentFee = 0.0;
				
		
		//GregorianCalendar gc = new GregorianCalendar();
		
		Calendar gc = Calendar.getInstance();
		
	
		
		// Calcular o valor da parcela sem juros
		double p1 = contract.getTotalValue() / months;
		
		for (int i = 1 ; i <= months ; i++)
		{
			// Calcular o mês da prestação
			gc.setTime(contract.getDate());
			gc.add(Calendar.MONTH, i); // adiciona um dia na data
			Date dueDate = gc.getTime();
			
			// Calcular o simple interest
			interest = paymentService.interest(p1, i);
						
			// calcular o paymentFee
			paymentFee = paymentService.paymentFee(interest);
			
			contract.addList(new Installment(dueDate,paymentFee));
			
		}
		
	}
	
		
	
}
