package project_pro_192;

public class SinhVienKyThuat extends SinhVien {

    private float PRO192;
    private float MAD101;
    private float OSG104;
    private float NWC204;
    private float SSG104;

    public SinhVienKyThuat() {
    }

    public SinhVienKyThuat(String id, String hoVaTen, String ngaySinh, String queQuan, String tenLop, float PRO192, float MAD101, float OSG104, float NWC204, float SSG104) {
        super(id, hoVaTen, ngaySinh, queQuan, tenLop);
        this.PRO192 = PRO192;
        this.MAD101 = MAD101;
        this.OSG104 = OSG104;
        this.NWC204 = NWC204;
        this.SSG104 = SSG104;
    }

    public float getPRO192() {
        return PRO192;
    }

    public void setPRO192(float PRO192) {
        this.PRO192 = PRO192;
    }

    public float getMAD101() {
        return MAD101;
    }

    public void setMAD101(float MAD101) {
        this.MAD101 = MAD101;
    }

    public float getOSG104() {
        return OSG104;
    }

    public void setOSG104(float OSG104) {
        this.OSG104 = OSG104;
    }

    public float getNWC204() {
        return NWC204;
    }

    public void setNWC204(float NWC204) {
        this.NWC204 = NWC204;
    }

    public float getSSG104() {
        return SSG104;
    }

    public void setSSG104(float SSG104) {
        this.SSG104 = SSG104;
    }

    @Override
    public void inThongTin() {
        System.out.printf("| %-12s | %20s | %15s | %-17s | %15s | %10.2f | %10.2f | %10.2f | %10.2f | %10.2f |%n",
                getId(), getHoVaTen(), getNgaySinh(), getQueQuan(), getTenLop(),
                getPRO192(), getMAD101(), getOSG104(), getNWC204(), getSSG104());
    }

    @Override
    public double calculateGPA() {
        return (this.MAD101 + this.PRO192 + this.NWC204 + this.OSG104 + this.SSG104) / 5;
    }

    @Override
    public void ketQuaHocTap() {
         int count = 0;
        if (getPRO192() >= 4 && getPRO192() <= 10) {
            count++;
            System.out.println("Total PRO192: " + getPRO192() + "--PASSED--(^_^)");
        } else if (getPRO192() < 4) {
            System.out.println("Total PRO192: " + getPRO192() + "-- NOT PASSED-- (*__*)");
        }
        if (getMAD101() >= 4 && getMAD101() <= 10) {
            count++;
            System.out.println("Total MAD101: " + getMAD101() + "--PASSED--(^_^)");
        } else if (getMAD101() < 4) {
            System.out.println("Total MAD101: " + getMAD101() + "-- NOT PASSED-- (*__*)");
        }
        if (getOSG104() >= 4 && getOSG104() <= 10) {
            count++;
            System.out.println("Total OSG104: " + getOSG104() + "--PASSED--(^_^)");
        } else if (getOSG104() < 4) {
            System.out.println("Total OSG104: " + getOSG104() + "-- NOT PASSED-- (*__*)");
        }
        if (getNWC204() >= 4 && getNWC204() <= 10) {
            count++;
            System.out.println("Total NWC204: " + getNWC204() + "--PASSED--(^_^)");
        } else if (getNWC204() < 4) {
            System.out.println("Total NWC204: " + getNWC204() + "-- NOT PASSED-- (*__*)");
        }
        if (getSSG104() >= 4 && getSSG104() <= 10) {
            count++;
            System.out.println("Total SSG104: " + getSSG104() + "--PASSED--(^_^)");
        } else if (getSSG104() < 4) {
            System.out.println("Total SSG104: " + getSSG104() + "-- NOT PASSED-- (*__*)");
        }
        System.out.println("Tổng số môn vượt qua " + count + "/5 COUCRSE.");
        double gpa = calculateGPA();
        if (gpa >= 9 && gpa <= 10) {
            System.out.println("ACHIEVEMENT: SINH VIÊN XUẤT SẮC KHỐI NGÀNH KỸ THUẬT.");
        } else if (gpa >= 8 && gpa < 9) {
            System.out.println("ACHIEVEMENT: SINH VIÊN GIỎI KHỐI NGÀNH KỸ THUẬT.");
        }
    }

}
