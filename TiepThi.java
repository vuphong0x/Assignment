package Assignment;
import java.util.Scanner;
public class TiepThi extends NhanVien{
    private double sale;
	private double bonus;
	double colection;
	Scanner sc = new Scanner(System.in);

	public TiepThi() {
		super();
	}

	public TiepThi(double sale, double bonus) {

		super();
		this.sale = sale;
		this.bonus = bonus;
		this.colection = colection;
	}

    @Override
	public void nhap() {
		super.nhap();
		sc = new Scanner(System.in);
		System.out.print("Doanh so: ");
		sale = sc.nextDouble();
		System.out.print("Ti le hoa hong: ");
		bonus = sc.nextDouble();
	}

	
    @Override
	  public double tinhLuong() { this.setColection(this.getSalary() +
	  this.getSale() * this.getBonus()); if (this.getColection() <= 9000000)
	  this.getColection(); else if (this.getColection() <= 15000000)
	  this.setColection((this.getColection() - this.getColection() * 0.1)); else
	 this.setColection(this.getColection() - this.getColection() * 0.12); return
	  (long) this.getColection(); }
	
    @Override
	public String showInfo() {
		return super.showInfo() + "\nDoanh so: " + (long) this.getSale() + "\nHoa hong: " + this.getBonus();

	}

    @Override
	public double getColection() {
		return colection;
	}
    @Override
	public void setColection(double colection) {
		this.colection = colection;
	}

	public double getSale() {
		return sale;
	}

	public void setSale(double sale) {
		this.sale = sale;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

}
