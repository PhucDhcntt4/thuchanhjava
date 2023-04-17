import java.util.Arrays;
import java.util.Scanner;

class SinhVien {

	private int mssv;
	private String hoten;
	private String diachi;
	private String sdt;
     public SinhVien() {
 
    }
	public SinhVien(int mssv, String hoten, String diachi, String sdt) {
        this.mssv = mssv;
        this.hoten = hoten;
        this.diachi = diachi;
        this.sdt = sdt;
    }

    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public String tostring(){

    	return "MSSV\n"+ mssv + "Ho va ten\n"+ hoten + "dia chi\n" + diachi + "So dien thoai" + sdt;
    }   
    public void hienThi() {
        System.out.printf("%-6d %-20s %-20s %-15d \n", mssv, hoten, diachi, sdt);
    }
}

   public class bai1 {
    static Scanner sc = new Scanner(System.in);
    static void nhapThongTinh(SinhVien tt) {
        System.out.println("Nhập MSSV: ");
        tt.setMssv(sc.nextInt());
        ;
        sc.nextLine();
        System.out.println("Nhap ho ten: ");
        tt.setHoten(sc.nextLine());
        System.out.println("Nhap dia chi: ");
        tt.setDiachi(sc.nextLine());
        do {
            System.out.println("Nhap so dien thoai 10 so: ");
            tt.setSdt(sc.nextLine());
        } while (tt.getSdt().length() != 10);
    }
 
    public static void main(String[] args) {
        SinhVien sv[] = null;
        int a, n = 0;
        boolean flag = true;
        do {
            System.out.println("Bạn chon lam gi?");
            System.out.println("1.Nhap thong tin sinh vien. \n" +
                    "2.Xuat ban danh sach.\n" +
                    "3.Thoat!");
            a = sc.nextInt();
            switch (a) {
                case 1:
                    System.out.println("Nhap so luong: ");
                    n = sc.nextInt();
                    sv = new SinhVien[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("Sinh vien thu " + (i + 1)+": ");
                        sv[i] = new SinhVien();
                        nhapThongTinh(sv[i]);
 
                    }
 
                    break;
                case 2:
                    SinhVien temp = sv[0];
                    for (int i = 0; i < sv.length - 1; i++) {
                        for (int j = i + 1; j < sv.length; j++) {
                            if (sv[i].getMssv() > sv[j].getMssv()) {
                                temp = sv[j];
                                sv[j] = sv[i];
                                sv[i] = temp;
                            }
                        }
                    }
                    System.out.printf("%-5s %15s %15s %20s \n", "MSSV", "Họ và tên", "Địa chỉ", "Số điện thoại");
                    for (int i = 0; i < n; i++) {
                        sv[i].hienThi();
                    }
                    break;
                default:
                    System.out.println("bye!");
                    flag = false;
                    break;
            }
        } while (flag);
    }
}