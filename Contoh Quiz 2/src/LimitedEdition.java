import java.util.Random;

public class LimitedEdition extends Dress{
	
	private Integer stock;
	
	
	public LimitedEdition() {
		super();
		this.stock = inputStock();
		super.totalPrice = calculateTotalPrice();
	}

	@Override
	public Integer inputFabricPrice() {
		Integer InPrice;
		do {
			System.out.print("input Fabric price [Rp 100000  to 300000  ]: ");
			InPrice = scan.nextInt();
			scan.nextLine();
		} while (InPrice < 100000  || InPrice > 300000 );
		return InPrice;
	}

	@Override
	public String inputFabricType() {
		String InType;
		do {
			System.out.print("input Fabric Type [Satin | Chiffon | Crepe]: ");
			InType = scan.nextLine();
		} while (!( InType.equals("Satin") || InType.equals("Chiffon") || InType.equals("Crepe") ));
		return InType;
	}
	
	public Integer inputStock() {
		Integer InStock;
		do {
			System.out.print("input stock for this dress [1..10]: ");
			InStock = scan.nextInt();
			scan.nextLine();
		} while (InStock < 1 || InStock > 10);
		return InStock;
	}

	@Override
	public String generateID() {
		Random rand = new Random();
		
		int x1 = rand.nextInt(10);
		int x2 = rand.nextInt(10);
		int x3 = rand.nextInt(10);
		
		return "LI" + x1 + x2 + x3;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public Integer calculateTotalPrice() {
		return super.fabricPrice + 50000 + ((10 - this.stock) * 10000);
//		return (int) ((super.fabricPrice + 50000) * (100 - this.discount.floatValue()) / 100);
	}
	
	
}
