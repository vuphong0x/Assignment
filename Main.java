package Assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static ArrayList<NhanVien> nhanVien = new ArrayList<NhanVien>();
	static Scanner sc = new Scanner(System.in);
	static NhanVien nv = null;

	public static void main(String[] args) {
		byte chose;
		while (true) {
			menu();
			chose = sc.nextByte();
			switch (chose) {
			case 1:
				System.out.println("\n>>Nhap danh sach nhan vien<<\n");
				input();
				break;
			case 2:
				System.out.println("\n>>Xuat danh sach nhan vien<<\n");
				output();
				break;
			case 3:
				System.out.println("\n>>Tim nhan vien<<\n");
				timkiem();
				break;
			case 4:
				System.out.println("\n>>Xoa nhan vien<<\n");
				xoaNhanVien();
				break;
			case 5:
				System.out.println("\n>>Cap nhat thong tin nhan vien<<\n");
				capNhatNhanVien();
				break;
			case 6:
				System.out.println("\n>>Tim theo khoang luong<<\n");
				timKiemTheoKhoangLuong();
				break;
			case 7:
				System.out.println("\n>>Sap xep theo ten<<\n");
				sapXepNhanVienTheoHoTen();
				break;
			case 8:
				System.out.println("\n>>Sap xep theo luong<<\n");
				sapXepNhanVienTheoLuong();
				break;
			case 9:
				System.out.println("\n>>5 nhan vien co thu nhap cao nhat<<\n");
				namNVCoThuNhapMax();
				break;
			case 0:
				System.out.println("\n>>Thoat chuong trinh<<\n");
				System.exit(0);
				break;
			default:
				System.out.println("\n>>Chuc nang khong hop le!<<\n");
				break;

			}
		}
	}

	static void menu() {
		System.out.println("++------------------ MENU -------------------++");
		System.out.println("| 1. Nhap danh sach nhan vien                 |");
		System.out.println("| 2. Xuat danh sach nhan vien                 |");
		System.out.println("| 3. Tim nhan vien theo ma nhan vien          |");
		System.out.println("| 4. Xoa nhan vien                            |");
		System.out.println("| 5. Cap nhat thong tin nhan vien             |");
		System.out.println("| 6. Tim theo khoang luong                    |");
		System.out.println("| 7. Sap xep theo ten                         |");
		System.out.println("| 8. Sap xep theo luong                       |");
		System.out.println("| 9. 5 nhan vien co thu nhap cao nhat         |");
		System.out.println("| 0. Thoat chuong trinh                       |");
		System.out.println("++-------------------------------------------++");
		System.out.print("Chon chuc nang: ");
	}

	public static void input() {
		int soNv;
		int loaiNV;
		System.out.print("Nhap so nhan vien: ");
		soNv = sc.nextInt();
		for (int i = 0; i < soNv; i++) {
			System.out.print("\nNhap loai nhan vien(1-NVT, 2-NVTT, 3-NVTP): ");
			loaiNV = sc.nextInt();
			switch (loaiNV) {
			case 1:
				nv = new NhanVien();
				break;
			case 2:
				nv = new TiepThi();
				break;
			case 3:
				nv = new TruongPhong();
				break;
			default:
				break;
			}
			nv.nhap();
			nhanVien.add(nv);
		}

	}

	public static void output() {
		for (int i = 0; i < nhanVien.size(); i++) {
			System.out.printf("\nThong tin nhan vien thu %d : ", i+1);
			System.out.println(nhanVien.get(i).showInfo());
		}
	}

	public static void timkiem() {
		sc = new Scanner(System.in);
		System.out.print("Nhap ma code can tim kiem: ");
		String timCode = sc.nextLine();

		for (int i = 0; i < nhanVien.size(); i++) {
			if (nhanVien.get(i).getCode().equals(timCode)) {
				System.out.println(nhanVien.get(i).showInfo());
			}
		}
	}

	public static void xoaNhanVien() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma nhan vien can xoa: ");
		String xoaCode = sc.nextLine();
		for (int i = 0; i < nhanVien.size(); i++) {
			if (nhanVien.get(i).getCode().equals(xoaCode)) {
				nhanVien.remove(i);
				System.out.println("Xoa thanh cong.");
			}
		}
	}

	public static void capNhatNhanVien() {
		sc = new Scanner(System.in);
		System.out.print("Nhap ma nhan vien can cap nhat: ");
		String capNhatCode = sc.nextLine();
		for (int i = 0; i < nhanVien.size(); i++) {
			if (nhanVien.get(i).getCode().equals(capNhatCode)) {
				System.out.println(nhanVien.get(i).showInfo());
				if (nhanVien.get(i) instanceof TiepThi) {
					System.out.print("Nhap ten moi: ");
					nhanVien.get(i).setName(sc.nextLine());
					System.out.print("Nhap ma code moi: ");
					nhanVien.get(i).setCode(sc.nextLine());
					System.out.print("Nhap luong moi: ");
					nhanVien.get(i).setSalary(sc.nextDouble());
					System.out.print("Nhap doanh so moi: ");
					((TiepThi) nhanVien.get(i)).setSale(sc.nextDouble());
					System.out.print("Nhap ty le hoa hong moi: ");
					((TiepThi) nhanVien.get(i)).setBonus(sc.nextDouble());

				} else if (nv instanceof TruongPhong) {
					System.out.print("Nhap ten moi: ");
					nhanVien.get(i).setName(sc.nextLine());
					System.out.print("Nhap ma code moi: ");
					nhanVien.get(i).setCode(sc.nextLine());
					System.out.print("Nhap luong moi: ");
					nhanVien.get(i).setSalary(sc.nextDouble());
					System.out.print("Nhap luong trach nhiem moi: ");
					((TruongPhong) nhanVien.get(i)).setSalaryTN(sc.nextDouble());
				} else if (nhanVien.get(i) instanceof NhanVien) {
					System.out.print("Nhap ten moi: ");
					nhanVien.get(i).setName(sc.nextLine());
					System.out.print("Nhap ma code moi: ");
					nhanVien.get(i).setCode(sc.nextLine());
					System.out.print("Nhap luong moi: ");
					nhanVien.get(i).setSalary(sc.nextDouble());
				}
				System.out.println("Cap nhat thong tin thanh cong");
			}
		}
	}

	public static void timKiemTheoKhoangLuong() {
		sc = new Scanner(System.in);
		System.out.print("Nhap so luong nho nhat: ");
		double timLuongMin = sc.nextDouble();
		System.out.print("Nhap so luong lon nhat: ");
		double timLuongMax = sc.nextDouble();
		for (int i = 0; i < nhanVien.size(); i++) {
			if (nhanVien.get(i).getSalary() <= timLuongMax && nhanVien.get(i).getSalary() >= timLuongMin) {
				System.out.println(nhanVien.get(i).showInfo());
				System.out.println("Tim kiem thanh cong!!!");
			}
		}
	}

	public static void sapXepNhanVienTheoHoTen() {
		ArrayList<String> mangTen = new ArrayList<>();
		for (int i = 0; i < nhanVien.size(); i++) {
			mangTen.add(nhanVien.get(i).getName());
		}
		Collections.sort(mangTen);
		System.out.println("Sap xep thanh cong!!!");
		for (int i = 0; i < mangTen.size(); i++) {
			for (int j = 0; j < nhanVien.size(); j++) {
				if (mangTen.get(i).equals(nhanVien.get(j).getName())) {
					System.out.println((i + 1) + ". " + nhanVien.get(j).showInfo());
				}
			}

		}
	}

	public static void sapXepNhanVienTheoLuong() {
		ArrayList<Double> mangLuong = new ArrayList<>();
		for (int i = 0; i < nhanVien.size(); i++) {
			mangLuong.add(nhanVien.get(i).getSalary());
		}
		Collections.sort(mangLuong);
		System.out.println("Sap xep thanh cong!!!");
		for (int i = 0; i < mangLuong.size(); i++) {
			for (int j = 0; j < nhanVien.size(); j++) {
				if (mangLuong.get(i) == nhanVien.get(j).getSalary()) {
					System.out.println((i + 1) + ". " + nhanVien.get(j).showInfo());
				}
			}

		}
	}

	public static void namNVCoThuNhapMax() {
		ArrayList<Double> mangTN = new ArrayList<>();
		for (int i = 0; i < nhanVien.size(); i++) {
			mangTN.add(nhanVien.get(i).getColection());
			Collections.sort(mangTN);
			Collections.reverse(mangTN);

		}
		mangTN.forEach((double1) -> {
			System.out.println(double1);
		});
		if (mangTN.size() > 5) {
			for (int i = 0; i < 5; i++) {

				System.out.println((i + 1) + ". " + nhanVien.get(i).showInfo());

			}
		} else {
			for (int i = 0; i < mangTN.size(); i++) {
				for (int j = 0; j < nhanVien.size(); j++) {
					if (mangTN.get(i).equals(nhanVien.get(j).getColection())) {
						System.out.println((i + 1) + ". " + nhanVien.get(j).showInfo());
					}
				}
			}
		}
	}
}
