package project_pro_192;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class QuanLySinhVien implements QuanLyDanhSachSinhVien {

    private List<SinhVien> dssv;

    public QuanLySinhVien() {
        this.dssv = new ArrayList<>();
    }

    static Scanner sc = new Scanner(System.in);

    @Override
    public void nhapSinhVien() {
        System.out.println("Nhập số lượng sinh viên cần thêm vào danh sách: ");
        int soLuong = sc.nextInt();
        sc.nextLine(); // Đọc kí tự xuống dòng sau khi nhập số lượng

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập vào thông tin sinh viên thứ " + (i + 1));

            String maSinhVien = "";
            while (true) {
                try {
                    System.out.print("Mã sinh viên: ");
                    maSinhVien = sc.nextLine();
                    if (!maSinhVien.isEmpty()) {
                        break;
                    } else {
                        throw new IllegalArgumentException("Mã sinh viên không được để trống.");
                    }
                } catch (Exception e) {
                    System.out.println("Lỗi: " + e.getMessage());
                }
            }

            String hoVaTen = "";
            while (true) {
                try {
                    System.out.print("Họ và tên: ");
                    hoVaTen = sc.nextLine();
                    if (!hoVaTen.isEmpty()) {
                        break;
                    } else {
                        throw new IllegalArgumentException("Họ và tên không được để trống.");
                    }
                } catch (Exception e) {
                    System.out.println("Lỗi: " + e.getMessage());
                }
            }

            String ngaySinh = "";
            while (true) {
                try {
                    System.out.print("Nhập ngày sinh (ngày/tháng/năm): ");
                    ngaySinh = sc.nextLine();
                    if (!ngaySinh.isEmpty()) {
                        break;
                    } else {
                        throw new IllegalArgumentException("Ngày sinh không được để trống.");
                    }
                } catch (Exception e) {
                    System.out.println("Lỗi: " + e.getMessage());
                }
            }

            String queQuan = "";
            while (true) {
                try {
                    System.out.print("Quê Quán: ");
                    queQuan = sc.nextLine();
                    if (!queQuan.isEmpty()) {
                        break;
                    } else {
                        throw new IllegalArgumentException("Quê quán không được để trống.");
                    }
                } catch (Exception e) {
                    System.out.println("Lỗi: " + e.getMessage());
                }
            }

            String tenLop = "";
            while (true) {
                try {
                    System.out.print("Tên Lớp: ");
                    tenLop = sc.nextLine();
                    if (!tenLop.isEmpty()) {
                        break;
                    } else {
                        throw new IllegalArgumentException("Tên lớp không được để trống.");
                    }
                } catch (Exception e) {
                    System.out.println("Lỗi: " + e.getMessage());
                }
            }

            SinhVien sinhVienMoi = null;
            boolean validScore = false;

            while (!validScore) {
                try {
                    if (maSinhVien.substring(0, 2).equalsIgnoreCase("HE")) {
                        System.out.println("Nhập điểm của Sinh Viên Ngành Kỹ Thuật: ");
                        float pro192 = inputValidScore("PRO192");
                        float mad101 = inputValidScore("MAD101");
                        float osg104 = inputValidScore("OSG104");
                        float nwc204 = inputValidScore("NWC204");
                        float ssg104 = inputValidScore("SSG104");
                        sinhVienMoi = new SinhVienKyThuat(maSinhVien, hoVaTen, ngaySinh, queQuan, tenLop, pro192, mad101, osg104, nwc204, ssg104);
                        validScore = true;
                    } else if (maSinhVien.substring(0, 2).equalsIgnoreCase("HS")) {
                        System.out.println("Nhập điểm của Sinh Viên Ngành Kinh Tế: ");
                        float acc101 = inputValidScore("ACC101");
                        float eco121 = inputValidScore("ECO121");
                        float enm401 = inputValidScore("ENM401");
                        float obe102c = inputValidScore("OBE102c");
                        float ssg104 = inputValidScore("SSG104");
                        sinhVienMoi = new SinhVienKinhTe(maSinhVien, hoVaTen, ngaySinh, queQuan, tenLop, acc101, eco121, enm401, obe102c, ssg104);
                        validScore = true;
                    } else if (maSinhVien.substring(0, 2).equalsIgnoreCase("HA")) {
                        System.out.println("Nhập điểm của Sinh Viên Ngành Ngôn Ngữ: ");
                        float eal202c = inputValidScore("EAL202c");
                        float eaw222 = inputValidScore("EAW222");
                        float ecb101 = inputValidScore("ECB101");
                        float itg202 = inputValidScore("ITG202");
                        float ssg104 = inputValidScore("SSG104");
                        sinhVienMoi = new SinhVienNgonNgu(maSinhVien, hoVaTen, ngaySinh, queQuan, tenLop, eal202c, eaw222, ecb101, itg202, ssg104);
                        validScore = true;
                    } else {
                        System.out.println("Mã sinh viên không hợp lệ.");
                        break;
                    }

                    if (!dssv.contains(sinhVienMoi)) {
                        dssv.add(sinhVienMoi);
                        System.out.println("Sinh viên đã được thêm vào danh sách.");
                    } else {
                        System.out.println("Sinh viên đã tồn tại trong danh sách.");
                    }

                } catch (Exception e) {
                    System.out.println("Lỗi nhập điểm: " + e.getMessage());
                    sc.nextLine();
                }
            }
        }
    }

    private float inputValidScore(String subject) {
        while (true) {
            try {
                System.out.print("Điểm " + subject + ": ");
                float score = sc.nextFloat();
                sc.nextLine(); // Đọc kí tự xuống dòng sau khi nhập điểm
                if (score >= 0 && score <= 10) {
                    return score;
                } else {
                    throw new IllegalArgumentException("Điểm phải nằm trong khoảng từ 0 đến 10. Nhấn enter để nhập lại điểm.");

                }
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
                sc.nextLine(); // Đọc kí tự xuống dòng sau khi nhập sai
            }
        }
    }

    @Override
    public void hienThiDanhSachSinhVienTheoChuyenNganh() {

        System.out.println("Thông Tin Sinh Viên Kỹ Thuật.");
        System.out.printf("| %-10s | %20s | %15s | %-17s | %15s | %10s | %10s | %10s | %10s | %10s |%n", "ID Sinh Viên", "Họ Và Tên", "dd//MM//YYYY", "Quê Quán", "Tên Lớp", "PRO192", "MAD101", "OSG104", "NWC204", "SSG104");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (SinhVien sinhVien : dssv) {
            if (sinhVien instanceof SinhVienKyThuat) {
                SinhVienKyThuat sinhVienKyThuat = (SinhVienKyThuat) sinhVien;
                sinhVienKyThuat.inThongTin();
            }
        }

        System.out.println("Thông Tin Sinh Viên Kinh Tế.");
        System.out.printf("| %-10s | %20s | %15s | %-17s | %15s | %10s | %10s | %10s | %10s | %10s |%n", "ID Sinh Viên", "Họ Và Tên", "dd//MM//YYYY", "Quê Quán", "Tên Lớp", "ACC101", "ECO121", "ENM401", "OBE102c", "SSG104");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (SinhVien sinhVien : dssv) {
            if (sinhVien instanceof SinhVienKinhTe) {
                SinhVienKinhTe sinhVienKinhTe = (SinhVienKinhTe) sinhVien;
                sinhVienKinhTe.inThongTin();
            }
        }

        System.out.println("Thông Tin Sinh Viên Ngôn Ngữ.");
        System.out.printf("| %-10s | %20s | %15s | %-17s | %15s | %10s | %10s | %10s | %10s | %10s |%n", "ID Sinh Viên", "Họ Và Tên", "dd//MM//YYYY", "Quê Quán", "Tên Lớp", "EAL202c", "EAW222", "ECB101", "ITG202", "SSG104");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (SinhVien sinhVien : dssv) {
            if (sinhVien instanceof SinhVienNgonNgu) {
                SinhVienNgonNgu sinhVienNgonNgu = (SinhVienNgonNgu) sinhVien;
                sinhVienNgonNgu.inThongTin();
            }
        }
    }

    @Override
    public SinhVien timSinhVienTheoID(String id) {
        for (SinhVien sinhVien : dssv) {
            if (sinhVien.getId().equals(id)) {
                return sinhVien;
            }
        }
        return null;
    }

    @Override
    public void suaSinhVienTheoID(String id) {
        boolean found = false;
        for (SinhVien sinhVien : dssv) {
            if (sinhVien.getId().equalsIgnoreCase(id)) {
                found = true;
                System.out.println("Nhập thông tin mới cho sinh viên:");
                System.out.print("Họ và tên: ");
                String hoVaTen = sc.nextLine();
                System.out.print("Ngày sinh (ngày/tháng/năm): ");
                String ngaySinh = sc.nextLine();

                System.out.print("Quê quán: ");
                String queQuan = sc.nextLine();
                System.out.print("Tên lớp: ");
                String tenLop = sc.nextLine();

                if (sinhVien instanceof SinhVienKyThuat) {
                    SinhVienKyThuat sinhVienKyThuat = (SinhVienKyThuat) sinhVien;
                    System.out.print("Điểm PRO192: ");
                    float pro192 = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Điểm MAD101: ");
                    float mad101 = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Điểm OSG104: ");
                    float osg104 = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Điểm NWC204: ");
                    float nwc204 = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Điểm SSG104: ");
                    float ssg104 = sc.nextFloat();
                    sc.nextLine();

                    sinhVienKyThuat.setHoVaTen(hoVaTen);
                    sinhVienKyThuat.setNgaySinh(ngaySinh);
                    sinhVienKyThuat.setQueQuan(queQuan);
                    sinhVienKyThuat.setTenLop(tenLop);
                    sinhVienKyThuat.setPRO192(pro192);
                    sinhVienKyThuat.setMAD101(mad101);
                    sinhVienKyThuat.setOSG104(osg104);
                    sinhVienKyThuat.setNWC204(nwc204);
                    sinhVienKyThuat.setSSG104(ssg104);
                } else if (sinhVien instanceof SinhVienKinhTe) {
                    SinhVienKinhTe sinhVienKinhTe = (SinhVienKinhTe) sinhVien;
                    System.out.print("Điểm ACC101: ");
                    float acc101 = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Điểm ECO121: ");
                    float eco121 = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Điểm ENM401: ");
                    float enm401 = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Điểm OBE102c: ");
                    float obe102c = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Điểm SSG104: ");
                    float ssg104 = sc.nextFloat();
                    sc.nextLine();

                    sinhVienKinhTe.setHoVaTen(hoVaTen);
                    sinhVienKinhTe.setNgaySinh(ngaySinh);
                    sinhVienKinhTe.setQueQuan(queQuan);
                    sinhVienKinhTe.setTenLop(tenLop);
                    sinhVienKinhTe.setACC101(acc101);
                    sinhVienKinhTe.setECO121(eco121);
                    sinhVienKinhTe.setENM401(enm401);
                    sinhVienKinhTe.setOBE102c(obe102c);
                    sinhVienKinhTe.setSSG104(ssg104);
                } else if (sinhVien instanceof SinhVienNgonNgu) {
                    SinhVienNgonNgu sinhVienNgonNgu = (SinhVienNgonNgu) sinhVien;
                    System.out.print("Điểm EAL202c: ");
                    float eal202c = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Điểm EAW222: ");
                    float eaw222 = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Điểm ECB101: ");
                    float ecb101 = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Điểm ITG202: ");
                    float itg202 = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Điểm SSG104: ");
                    float ssg104 = sc.nextFloat();
                    sc.nextLine();

                    sinhVienNgonNgu.setHoVaTen(hoVaTen);
                    sinhVienNgonNgu.setNgaySinh(ngaySinh);
                    sinhVienNgonNgu.setQueQuan(queQuan);
                    sinhVienNgonNgu.setTenLop(tenLop);
                    sinhVienNgonNgu.setEAL202c(eal202c);
                    sinhVienNgonNgu.setEAW222(eaw222);
                    sinhVienNgonNgu.setECB101(ecb101);
                    sinhVienNgonNgu.setITG202(itg202);
                    sinhVienNgonNgu.setSSG104(ssg104);
                }
            }
        }
        
    if (!found) {
        System.out.println("Mã sinh viên không tồn tại. Vui lòng nhập lại mã sinh viên:");
        String newId = sc.nextLine();
        suaSinhVienTheoID(newId);
    }
    }

    @Override
    public void xoaSinhVienTheoID(String id) {
        Iterator<SinhVien> iterator = dssv.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            SinhVien sinhVien = iterator.next();
            if (sinhVien.getId().equalsIgnoreCase(id)) {
                iterator.remove();
                found = true;
                System.out.println("Đã xóa sinh viên có mã sinh viên: " + id);
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sinh viên có mã sinh viên: " + id);
        }
    }

    public void timKiemSinhVienTheoTen(String ten) {
    boolean found = false;
    for (SinhVien sinhVien : dssv) {
        if (sinhVien.getHoVaTen().indexOf(ten) >= 0) {
            System.out.println(sinhVien);
            found = true;
        }
    }
    if (!found) {
        System.out.println("Không tìm thấy tên sinh viên");
    }
}

    @Override
    public void sapXepSinhVienTheoGPA() {
        Collections.sort(dssv, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sv1, SinhVien sv2) {
                double gpa1 = sv1.calculateGPA();
                double gpa2 = sv2.calculateGPA();
                if (gpa1 < gpa2) {
                    return 1;
                } else if (gpa1 > gpa2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.printf(" %-10s | %20s | %15s | %10s %n", "ID", "Họ Và Tên", "Tên Lớp", "GPA");
        for (SinhVien sinhVien : dssv) {
            System.out.printf(" %-10s | %20s | %15s | %.2f %n", sinhVien.getId(), sinhVien.getHoVaTen(), sinhVien.getTenLop(), sinhVien.calculateGPA());
        }
    }

    @Override
    public void hienKetQuaHocTap(String id) {
        for (SinhVien sinhVien : dssv) {
            if (sinhVien.getId().equalsIgnoreCase(id)) {
                sinhVien.ketQuaHocTap();
            }
        }
    }

    @Override
    public void thongKeSinhVienToanKhoa() {
        sapXepSinhVienTheoGPA();
        if(dssv.get(0).calculateGPA() >= 9){
        System.out.println("----LỄ TÔN VINH----");
        System.out.println("Chúc Mừng Cóc Vàng Kỳ SUMMER 2024: " + dssv.get(0).getHoVaTen());
        System.out.println("Mang mã số sinh viên: " + dssv.get(0).getId());
        System.out.println("Với GPA: " + dssv.get(0).calculateGPA());
        }else if( dssv.get(0).calculateGPA() >= 0 && dssv.get(0).calculateGPA() < 9){
            System.out.println("Kỳ học này không có CÓC VÀNG.");
        }
        int count1 = 0;
        int count2 = 0;
        for (SinhVien sinhVien : dssv) {
            double gpa = sinhVien.calculateGPA();
            if (gpa >= 9 && gpa <= 10) {
                count1++;
            }
            if (gpa >= 8 && gpa < 9) {
                count2++;
            }
        }
        double pSVSX = (count1 * 100) / dssv.size();
        double pSVG = (count2 * 100) / dssv.size();
        System.out.printf("Toàn Trường Có Tất Cả %d SVSX chiếm %.2f%% ", count1, pSVSX);
        System.out.println("");
        System.out.printf("Toàn Trường Có Tất Cả %d SVG chiếm %.2f%% ", count2, pSVG);
        System.out.println("");
    }

    @Override
    public int laySoLuongSinhVien() {
        return this.dssv.size();
    }

    @Override
    public void ReadData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\FPT UNIVERSITY\\Duc_Hoc_Java\\Leak_Learn\\Project_PRO_192\\Data.csv"));
            String line = br.readLine();
            while (line != null) {
                String[] values = line.split(",");
                if (values.length >= 3) {
                    String maSinhVien = values[0];
                    String hoVaTen = values[1];
                    String ngaySinh = values[2];
                    String queQuan = values[3];
                    String tenLop = values[4];

                    SinhVien sinhVien = null;
                    if (maSinhVien.substring(0, 2).equalsIgnoreCase("HE")) {
                        float pro192 = Float.parseFloat(values[5]);
                        float mad101 = Float.parseFloat(values[6]);
                        float osg104 = Float.parseFloat(values[7]);
                        float nwc204 = Float.parseFloat(values[8]);
                        float ssg104 = Float.parseFloat(values[9]);
                        sinhVien = new SinhVienKyThuat(maSinhVien, hoVaTen, ngaySinh, queQuan, tenLop, pro192, mad101, osg104, nwc204, ssg104);
                    } else if (maSinhVien.substring(0, 2).equalsIgnoreCase("HS")) {
                        float acc101 = Float.parseFloat(values[5]);
                        float eco121 = Float.parseFloat(values[6]);
                        float enm401 = Float.parseFloat(values[7]);
                        float obe102c = Float.parseFloat(values[8]);
                        float ssg104 = Float.parseFloat(values[9]);
                        sinhVien = new SinhVienKinhTe(maSinhVien, hoVaTen, ngaySinh, queQuan, tenLop, acc101, eco121, enm401, obe102c, ssg104);
                    } else if (maSinhVien.substring(0, 2).equalsIgnoreCase("HA")) {
                        float eal202c = Float.parseFloat(values[5]);
                        float eaw222 = Float.parseFloat(values[6]);
                        float ecb101 = Float.parseFloat(values[7]);
                        float itg202 = Float.parseFloat(values[8]);
                        float ssg104 = Float.parseFloat(values[9]);
                        sinhVien = new SinhVienNgonNgu(maSinhVien, hoVaTen, ngaySinh, queQuan, tenLop, eal202c, eaw222, ecb101, itg202, ssg104);
                    }

                    if (sinhVien != null) {
                        dssv.add(sinhVien);
                    }
                }
                line = br.readLine();
            }
            br.close();
            System.out.println("Đọc dữ liệu thành công.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void SaveData() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\FPT UNIVERSITY\\Duc_Hoc_Java\\Leak_Learn\\Project_PRO_192\\Data.csv"));
            for (SinhVien sinhVien : dssv) {
                StringBuilder sb = new StringBuilder();
                sb.append(sinhVien.getId()).append(",");
                sb.append(sinhVien.getHoVaTen()).append(",");
                sb.append(sinhVien.getNgaySinh()).append(",");
                sb.append(sinhVien.getQueQuan()).append(",");
                sb.append(sinhVien.getTenLop()).append(",");

                if (sinhVien.getId().substring(0, 2).equalsIgnoreCase("HE")) {
                    SinhVienKyThuat svkt = (SinhVienKyThuat) sinhVien;
                    sb.append(svkt.getPRO192()).append(",");
                    sb.append(svkt.getMAD101()).append(",");
                    sb.append(svkt.getOSG104()).append(",");
                    sb.append(svkt.getNWC204()).append(",");
                    sb.append(svkt.getSSG104());
                } else if (sinhVien.getId().substring(0, 2).equalsIgnoreCase("HS")) {
                    SinhVienKinhTe svkt = (SinhVienKinhTe) sinhVien;
                    sb.append(svkt.getACC101()).append(",");
                    sb.append(svkt.getECO121()).append(",");
                    sb.append(svkt.getENM401()).append(",");
                    sb.append(svkt.getOBE102c()).append(",");
                    sb.append(svkt.getSSG104());
                } else if (sinhVien.getId().substring(0, 2).equalsIgnoreCase("HA")) {
                    SinhVienNgonNgu svnn = (SinhVienNgonNgu) sinhVien;
                    sb.append(svnn.getEAL202c()).append(",");
                    sb.append(svnn.getEAW222()).append(",");
                    sb.append(svnn.getECB101()).append(",");
                    sb.append(svnn.getITG202()).append(",");
                    sb.append(svnn.getSSG104());
                }

                writer.write(sb.toString());
                writer.newLine();
            }

            writer.close();
            System.out.println("Lưu dữ liệu thành công.");
        } catch (Exception e) {
            System.out.println("Lỗi khi lưu dữ liệu: " + e.getMessage());
        }
    }

}
