import java.util.Random;

public class Regular extends Dress{
	
	private Integer discount;

	public Regular() {
		super();
		this.discount = inputDiscount();
		super.totalPrice = calculateTotalPrice();
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	@Override
	public Integer inputFabricPrice() {
		Integer InPrice;
		do {
			System.out.print("input Fabric price [Rp 10000 to 100000 ]: ");
			try {
				InPrice = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				// TODO: handle exception
				InPrice = 0;
			}
			
		} while (InPrice < 10000 || InPrice > 100000);
		return InPrice;
	}

	@Override
	public String inputFabricType() {
		String InType;
		do {
			System.out.print("input Fabric Type [Cotton | Wool]: ");
			InType = scan.nextLine();
		} while (!(InType.equals("Cotton") || InType.equals("Wool")));
		return InType;
	}
	
	public Integer inputDiscount() {
		Integer InDicount;
		do {
			System.out.print("input discount for this dress [1..100]: ");
			InDicount = scan.nextInt();
			scan.nextLine();
		} while (InDicount < 1 || InDicount > 100);
		return InDicount;
	}

	@Override
	public String generateID() {
		Random rand = new Random();
		
		int x1 = rand.nextInt(10);
		int x2 = rand.nextInt(10);
		int x3 = rand.nextInt(10);
		
		return "RE" + x1 + x2 + x3;
	}

	@Override
	public Integer calculateTotalPrice() {
		return (int) ((super.fabricPrice + 50000) * (100 - this.discount.floatValue()) / 100);
	}
	
	

}
