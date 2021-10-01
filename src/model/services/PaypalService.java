package model.services;

public class PaypalService implements OnlinePaymentService{
	
	@Override	
	public Double interest(Double amount , Integer months)
	{
		Double juros  = (amount * 0.01);
		return amount + juros * months ;
	}
	
	
	@Override
	public Double paymentFee(Double amount) {
		return amount + (amount * 0.02);
	}
	
	

}
