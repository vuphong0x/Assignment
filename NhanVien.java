package Assignment;
import java.util.Scanner;
class NhanVien {
    String name;
	String code;
	double salary;
	double colection;
	Scanner sc = new Scanner(System.in);

	public NhanVien() {
		super();
	}

	public NhanVien(String name, String code, double salary) {

		this.code = code;
		this.name = name;
		this.salary = salary;
	}

	public double tinhLuong() {
		this.setColection(this.getSalary());
		if (this.getColection() <= 9000000)
			this.getColection();
		else if (this.getColection() <= 15000000)
			this.setColection((this.getColection() - this.getColection() * 0.1));
		else
			this.setColection(this.getColection() - this.getColection() * 0.12);
		return (long) this.getColection();
	}

	public void nhap() {

		System.out.print("Moi nhap ten: ");
		this.setName(sc.nextLine());
		System.out.print("Moi nhap ma nhan vien: ");
		this.setCode(sc.nextLine());
		System.out.print("Moi nhap luong nhan vien: ");
		this.setSalary(sc.nextDouble());
	}

	public String showInfo() {
		return String.format("Ten nhan vien: %s\nMa so nhan vien: %s \nLuong nhan vien: %s", this.getName(),
				this.getCode(), this.getSalary());
	}

	public double getColection() {
		return colection;
	}

	public void setColection(double colection) {
		tinhLuong();
		this.colection = colection;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

    void nhapThongTin() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    void xuatThongTin() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    void findByID() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
