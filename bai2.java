import java.util.Scanner;

class ThongTinDangKy {
    private int maXe,dungTich;
    private double triGia;
    private String chuXe,loaixe;
 
    public ThongTinDangKy(int maXe, int dungTich, double triGia, String chuXe, String loaixe) {
        this.maXe = maXe;
        this.dungTich = dungTich;
        this.triGia = triGia;
        this.chuXe = chuXe;
        this.loaixe = loaixe;
    }
    public ThongTinDangKy(){
 
    }
    public int getMaXe() {
        return maXe;
    }
 
    public void setMaXe(int maXe) {
        this.maXe = maXe;
    }
 
    public int getDungTich() {
        return dungTich;
    }
 
    public void setDungTich(int dungTich) {
        this.dungTich = dungTich;
    }
 
    public double getTriGia() {
        return triGia;
    }
 
    public void setTriGia(double triGia) {
        this.triGia = triGia;
    }
 
    public String getChuXe() {
        return chuXe;
    }
 
    public void setChuXe(String chuXe) {
        this.chuXe = chuXe;
    }
 
    public String getLoaixe() {
        return loaixe;
    }
 
    public void setLoaixe(String loaixe) {
        this.loaixe = loaixe;
    }
 
    public double tinhThue(){
        double thue;
        if(dungTich<100) thue=triGia*0.01;
        else if (dungTich >= 100 && dungTich<=200) thue = triGia * 0.03;
        else thue = triGia * 0.05;
        return thue;
    }
 
    @Override
    public String toString() {
        return maXe + "-"+chuXe + "-"+dungTich + "-"+triGia + "-"+loaixe;
}
 
    void inThue(){
        System.out.printf("%5d %-10s %2d %10.2f %10s %8.5f \n ",maXe,chuXe,dungTich,triGia,loaixe,tinhThue());
    }
}


public class bai2 {
    static Scanner sc = new Scanner(System.in);
    
      static void nhapXe(ThongTinDangKy xe){
            System.out.print("Nhap ma xe: ");
            xe.setMaXe(sc.nextInt());sc.nextLine();
            System.out.print("Nhap ten chu xe: ");
            xe.setChuXe(sc.nextLine());
            System.out.print("Nhap dung tich xe: ");
            xe.setDungTich(sc.nextInt());
            System.out.print("Nhap tri gia xe: ");
            xe.setTriGia(sc.nextDouble());;sc.nextLine();
            System.out.print("loai xe: ");
            xe.setLoaixe(sc.nextLine());
        }
        
    public static void main(String[] args) {
       ThongTinDangKy v[]= null;
        int a,n=0;
        boolean flag = true;
     
        do{
            System.out.println("nhap lua chon!!!");
            System.out.println("1.Tao thong tin xe \n"+
                    "2.Xuat bang ke khai thue.\n"+
                    "3.Thoat");
            a =sc.nextInt();
            switch (a){
                case 1:
                    System.out.print("Nhap so luong xe can tao: ");
                    n=sc.nextInt();
               
                    v= new ThongTinDangKy[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("Xe thu " + (i+1));
                        v[i] = new ThongTinDangKy();
                        nhapXe(v[i]);
                    }
                    break;
                case 2:
                    System.out.printf("%5s %5s %7s %10s %10s %8s \n","Ma xe","Chu xe","Dung tich","Tri gia","loai xe","Thue");
                    for (int i = 0; i < n; i++) {
                        v[i].inThue();
                    }
                    break;
                default:
                    System.out.println("Tam biet!!!");
                    flag=false;
                    break;
            }
        }while (flag);
    }
}