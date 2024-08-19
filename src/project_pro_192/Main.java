package project_pro_192;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLyDanhSachSinhVien danhSach = new QuanLySinhVien();
        int luaChon;
        do {
            do {
                System.out.println("---------------MENU-------------");
                System.out.println("Vui Long Lựa Chọn Chức Năng.");
                System.out.println(
                    "1. Nhập sinh viên vào danh sách.\n" +
                    "2. Tìm sinh viên theo mã sinh viên.\n" +
                    "3. Tìm sinh viên theo tên sinh viên.\n" +
                    "4. Lấy số lượng sinh viên có trong danh sách tạm thời.\n" +
                    "5. Xóa sinh viên theo mã sinh viên.\n" +
                    "6. Sửa thông tin sinh viên dựa theo mã sinh viên.\n" +
                    "7. Kiểm tra kết quả học tập của sinh viên.\n" +
                    "8. Sắp xếp sinh viên dựa trên GPA.\n" +
                    "9. Hiển thị danh sách sinh viên theo từng chuyên ngành.\n" +
                    "10. Thống kê sinh viên toàn trường kỳ học SUMMER 2024.\n" +
                    "11. Đọc dữ liệu sinh viên từ file DATA.\n" +
                    "12. Lưu thông tin sinh viên vào file.\n" +
                    "0. Thoát khỏi chương trình!!!"
                );
                System.out.print("Nhập lựa chọn của bạn: ");
                while (!sc.hasNextInt()) {
                    System.out.print("Vui lòng nhập một số từ 0 đến 12: ");
                    sc.next(); // Đọc bỏ giá trị không hợp lệ
                }
                luaChon = sc.nextInt();
                sc.nextLine(); // Đọc bỏ ký tự xuống dòng
                if (luaChon < 0 || luaChon > 12) {
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                }
            } while (luaChon < 0 || luaChon > 12);

            switch (luaChon) {
                case 1:
                    danhSach.nhapSinhVien();
                    break;
                case 2:
                    System.out.println("Nhập mã sinh viên cần tìm.");
                    String idTim = sc.nextLine();
                    SinhVien singVienTimDuoc = danhSach.timSinhVienTheoID(idTim);
                    if (singVienTimDuoc != null) {
                        System.out.println("Sinh viên có ID " + idTim + " đã được tìm thấy.");
                        System.out.println(singVienTimDuoc);
                    } else {
                        System.out.println("Không tìm thấy sinh viên có ID " + idTim);
                    }
                    break;
                case 3:
                    System.out.println("Nhập tên sinh viên cần tìm.");
                    String tenTim = sc.nextLine();
                    danhSach.timKiemSinhVienTheoTen(tenTim);
                    break;
                case 4:
                    System.out.println("Số lượng sinh viên có trong danh sách là: " + danhSach.laySoLuongSinhVien());
                    break;
                case 5:
                    System.out.println("Nhập vào mã sinh viên cần xóa.");
                    String maXoa = sc.nextLine();
                    danhSach.xoaSinhVienTheoID(maXoa);
                    break;
                case 6:
                    System.out.println("Nhập vào mã sinh viên cần sửa thông tin : ");
                    String maSua = sc.nextLine();
                    danhSach.suaSinhVienTheoID(maSua);
                    break;
                case 7:
                    System.out.println("Nhập mã thí sinh cần kiểm tra thông tin.");
                    String maKetQua = sc.nextLine();
                    danhSach.hienKetQuaHocTap(maKetQua);
                    break;
                case 8:
                    danhSach.sapXepSinhVienTheoGPA();
                    break;
                case 9:
                    danhSach.hienThiDanhSachSinhVienTheoChuyenNganh();
                    break;
                case 10:
                    danhSach.thongKeSinhVienToanKhoa();
                    break;
                case 11:
                    danhSach.ReadData();
                    break;
                case 12:
                    danhSach.SaveData();
                    break;
                case 0:
                    System.out.println("Chương trình đã thoát.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while (luaChon != 0);
    }
}