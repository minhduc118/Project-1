package project_pro_192;

import java.util.Objects;

public abstract class SinhVien {

    private String id;
    private String hoVaTen;
    private String ngaySinh;
    private String queQuan;
    private String tenLop;
    
    public SinhVien() {
    }
    
    public SinhVien(String id, String hoVaTen, String ngaySinh, String queQuan, String tenLop) {
        this.id = id.substring(0, 2).toUpperCase() + id.substring(2);
        String[] s = hoVaTen.split("\\s+");
        for (int i = 0; i < s.length; i++) {
            s[i] = Character.toUpperCase(s[i].charAt(0)) + s[i].substring(1).toLowerCase();
        }
        this.hoVaTen = String.join(" ", s);
        this.ngaySinh = ngaySinh;
        String[] s1 = queQuan.split("\\s+");
        for (int i = 0; i < s1.length; i++) {
            s1[i] = Character.toUpperCase(s1[i].charAt(0)) + s1[i].substring(1).toLowerCase();
        }
        this.queQuan = String.join(" ", s1);
        this.tenLop = tenLop.substring(0, 2).toUpperCase() + tenLop.substring(2);
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getHoVaTen() {
        return hoVaTen;
    }
    
    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }
    
    public String getNgaySinh() {
        return ngaySinh;
    }
    
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
    public String getQueQuan() {
        return queQuan;
    }
    
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }
    
    public String getTenLop() {
        return tenLop;
    }
    
    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }
    
    public abstract void inThongTin();

    public abstract double calculateGPA();

    public abstract void ketQuaHocTap();

    @Override
    public String toString() {
        return String.format("| %-12s | %-22s | %-12s | %-17s | %-10s |",
        id,
        hoVaTen,
        ngaySinh,
        queQuan,
        tenLop
    );
    }

    @Override
    public int hashCode() {   
        int hash = 5;   
        hash = 13 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) { 
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SinhVien other = (SinhVien) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
