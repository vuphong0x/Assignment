package Assignment;

import java.util.Scanner;

public class TruongPhong extends NhanVien {
    private double salaryTN;
	double colection;
	Scanner sc= new Scanner(System.in);

	public TruongPhong() {
		super();
	}

	public TruongPhong(double salaryTN) {
		super();
		this.salaryTN = salaryTN;

	}

    @Override
	public void nhap() {
		super.nhap();
		sc = new Scanner(System.in);
		System.out.print("Luong trach nhiem nhan vien: ");
		salaryTN = sc.nextDouble();
	}

    @Override
	public double tinhLuong() {
		this.setColection(this.getSalary() + this.getSalaryTN());
		if (this.getColection() <= 9000000)
			this.getColection();
		else if (this.getColection() <= 15000000)
			this.setColection((this.getColection() - this.getColection() * 0.1));
		else
			this.setColection(this.getColection() - this.getColection() * 0.12);
		return (long) this.getColection();
	}

    @Override
	public String showInfo() {
		return super.showInfo() + "\nLuong trach nhiem: " + (long)this.getSalaryTN();

	}

	public double getSalaryTN() {
		return salaryTN;
	}

	public void setSalaryTN(double salaryTN) {
		this.salaryTN = salaryTN;
	}

    @Override
	public double getColection() {
		return colection;
	}

    @Override
	public void setColection(double colection) {
		this.colection = colection;
	}
}

