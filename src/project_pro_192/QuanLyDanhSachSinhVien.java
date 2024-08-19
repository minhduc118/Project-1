/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package project_pro_192;

/**
 *
 * @author LEGION
 */
public interface QuanLyDanhSachSinhVien {
    void nhapSinhVien();
    SinhVien timSinhVienTheoID(String id);
    void suaSinhVienTheoID(String id);
    void xoaSinhVienTheoID(String id);
     int laySoLuongSinhVien();
    void timKiemSinhVienTheoTen(String ten);
    void hienThiDanhSachSinhVienTheoChuyenNganh();
    void sapXepSinhVienTheoGPA();
    void hienKetQuaHocTap(String id);
    void thongKeSinhVienToanKhoa();
    void ReadData();
    void SaveData();
   
    
}
