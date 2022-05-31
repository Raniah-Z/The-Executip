import java.util.Scanner;

public abstract class Dress {

	Scanner scan = new Scanner(System.in);
	
	protected String name;
	protected Integer fabricPrice;
	protected String fabricType;
	protected String ID;
	protected Integer totalPrice;
	
	public Dress() {
		this.name = inputName();
		this.fabricPrice = inputFabricPrice();
		this.fabricType = inputFabricType();
		this.ID = generateID();
	}

	public String inputName() {
		String InName;
		do {
			System.out.print("input dress name [5-20 character]: ");
			InName = scan.nextLine();
		} while (InName.length() < 5 || InName.length() > 20);
		return InName;
	}
	
	public abstract Integer inputFabricPrice();
	public abstract String inputFabricType();
	public abstract String generateID();
	public abstract Integer calculateTotalPrice();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFabricPrice() {
		return fabricPrice;
	}

	public void setFabricPrice(Integer fabricPrice) {
		this.fabricPrice = fabricPrice;
	}

	public String getFabricType() {
		return fabricType;
	}

	public void setFabricType(String fabricType) {
		this.fabricType = fabricType;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
