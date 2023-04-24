// abstract class Xe{

// abstract public void  brake();
// }

// class xemaythethao extends Xe{

//  @Override
//  public void brake(){

//      System.out.println("PHANH xe may the thao chat luong !");
//  }
// }

// class xemayleonui extends Xe{
//  @Override
//  public void brake(){

//      System.out.println("phanh xe may leo nui chat luong cao");
//  }
// }

// public class TT{

// public static void main(String[] args) {
    
//  xemaythethao xmt = new xemaythethao();
//  xmt.brake();

//  xemayleonui xmn = new xemayleonui();
//  xmn.brake();
    
// }
// }
import java.text.NumberFormat;
import java.util.Scanner;
 
class Account {
    //khai báo các thuộc tính
    private long soTK;
    private String tenTK;
    private double soTienTrongTK;
    private String trangthai;
 
    Scanner sc = new Scanner(System.in);
 
   
    public Account() {
    }
 
   
    public Account(long soTK, String tenTK, double soTienTrongTK,String trangthai) {
        this.soTK = soTK;
        this.tenTK = tenTK;
        this.soTienTrongTK = soTienTrongTK;
        this.trangthai = trangthai;
    }
 

    public long getSoTK() {
        return this.soTK;
    }
 
    public void setSoTK(long soTK) {
        this.soTK = soTK;
    }
 
    public String getTenTK() {
        return this.tenTK;
    }
 
    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }
 
    public double getSoTienTrongTK() {
        return this.soTienTrongTK;
    }
 
    public void setSoTienTrongTK(double soTienTrongTK) {
        this.soTienTrongTK = soTienTrongTK;
    }

    public String getTrangthai() {
        return this.trangthai;
    }
 
    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
 
 
    @Override
    public String toString() {
      
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(soTienTrongTK);
        return soTK + "-" + tenTK + "-" + str1;
    }
 
    public double napTien() {
        double nap;
        System.out.print("Nhap so tien can nap: ");
        nap = sc.nextDouble();
      
        if (nap >= 0) {
            soTienTrongTK = nap + soTienTrongTK;
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String str1 = currencyEN.format(nap);
            System.out.println("Ban da nap " + str1 + " vao tai khoan thanh cong!.");
        } else {
            System.out.println("So tien khong hop le!");
        }
        return nap;
    }
 
  
    public double rutTien() {
        double phi = 5;
        double rut;
        System.out.print("Nhap so tien can rut: ");
        rut = sc.nextDouble();

        if (rut <= (soTienTrongTK - phi)) {
            soTienTrongTK = soTienTrongTK - (rut + phi);
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String str1 = currencyEN.format(rut);
            System.out.println("Ban vua rut " + str1 + "Tu tai khoan Phi $5.");
        } else {
            System.out.println("So tien rut khong hop le!");
            return rutTien();
        }
        return rut;
    }
 
 
    public double daoHan() {
        double laiSuat = 0.035;
        soTienTrongTK = soTienTrongTK + soTienTrongTK * laiSuat;
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(soTienTrongTK);
        System.out.println("Ban vua duoc " + str1 + " tu 1thang ");
        return soTienTrongTK;
    }
 
   
    void inTK() {
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(soTienTrongTK);
        System.out.printf("%-10d %-20s %-20s \n", soTK, tenTK, str1);
    }
}
public class b1 {
    static Scanner sc = new Scanner(System.in);
    static void nhapTK(Account tk) {
        System.out.println("nhap so tai khoan: ");
        tk.setSoTK(sc.nextInt());
        sc.nextLine();
        System.out.println("Nhap ten tai khoan: ");
        tk.setTenTK(sc.nextLine());
        tk.setSoTienTrongTK(50000);
    }
    public static void main(String[] args) {
        Account a[] = null;
        int k, b, n = 0;
        long s, d, c, f;
        boolean flag = true;
        do {
            System.out.println("------Chuc nang cua ngan hang ABC------");
            System.out.println("1.them tai khoan.\n"+
                                "2.In thong tin khach hang\n"+
                                "3.Nap tien.\n"+
                                "4.Rut tien.\n"+
                                "5.Chuyen tien.\n"+
                                "6.Dao han\n"+
                                "7.Thoat!!!");

            b = sc.nextInt();
            switch (b) {
                case 1:
                    System.out.println("Nhap so luong khach hang muon nhap: ");
                    n = sc.nextInt();
                    a = new Account[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("khach hang so: " + (i+1));
                        a[i] = new Account();
                        nhapTK(a[i]);
                    }
                    break;
                case 2:
                    System.out.printf("%-10s %-20s %-20s\n", "Số TK", "Tên TK", "So tien trong TK");
                    for (int i = 0; i < n; i++) {
                        a[i].inTK();
                    }
                    break;
                case 3:
                    System.out.println("Nhap  so tai khoan can nap tien: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSoTK();
                        if (s == d) {
                            System.out.println("Ban chon tai khoan :" + d);
                            a[i].napTien();
                        } else {
                            System.out.println("");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Nhap so tai khoan can rut tien: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSoTK();
                        if (s == d) {
                            System.out.println("ban chon tai khoan: " + d);
                            a[i].rutTien();
                        }
                    }
                    break;
                
                case 5:
                    double chuyen,
                            nhan,
                            tienChuyen;
                    System.out.print("Nhap so tai khoan chuyen tien: ");
                    s = sc.nextLong();
                    System.out.print("Nhap so tai khoan nhan tien:");
                    c = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSoTK();
                        if (s == d) {
                            chuyen = a[i].getSoTienTrongTK();
                            for (int j = 0; j < n; j++) {
                                f = a[j].getSoTK();
                                if (c == f) {
                                    nhan = a[j].getSoTienTrongTK();
                                    System.out.println("Nhap so tien can chuyen");
                                    tienChuyen = sc.nextDouble();
                                    if (tienChuyen <= chuyen) {
                                        chuyen = chuyen - tienChuyen;
                                        nhan = nhan + tienChuyen;
                                        a[i].setSoTienTrongTK(chuyen);
                                        a[j].setSoTienTrongTK(nhan);
                                        System.out.println("Tai khoan so " + d + "vua chuyen: $" + tienChuyen);
                                        System.out.println("Tai khoan so" + f + " vua nhan: $" + tienChuyen);
                                    } else {
                                        System.out.println("nhap khong hop le!!");
                                    }
                                } else {
                                    System.out.println("");
                                }
                            }
                        } else {
                            System.out.println("");
                        }
                    }
                    break;
                case 6:
                    System.out.println("Nhap so tai khoan khach dao han: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSoTK();
                        if (s == d) {
                            System.out.println("Ban chon tai khoan: " + d);
                            a[i].daoHan();
                        } else {
                            System.out.println("");
                        }
                    }
                    break;
                default:
                    System.out.println("Xin vinh biet cu !!!!!!!!!");
                    flag = false;
                    break;
            }
        } while (flag);
    }
}
    
