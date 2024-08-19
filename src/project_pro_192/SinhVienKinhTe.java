package project_pro_192;

public class SinhVienKinhTe extends SinhVien {

    private float ACC101;
    private float ECO121;
    private float ENM401;
    private float OBE102c;
    private float SSG104;

    public SinhVienKinhTe() {
    }

    public SinhVienKinhTe(String id, String hoVaTen, String ngaySinh, String queQuan, String tenLop, float ACC101, float ECO121, float ENM401, float OBE102c, float SSG104) {
        super(id, hoVaTen, ngaySinh, queQuan, tenLop);
        this.ACC101 = ACC101;
        this.ECO121 = ECO121;
        this.ENM401 = ENM401;
        this.OBE102c = OBE102c;
        this.SSG104 = SSG104;
    }

    public float getACC101() {
        return ACC101;
    }

    public void setACC101(float ACC101) {
        this.ACC101 = ACC101;
    }

    public float getECO121() {
        return ECO121;
    }

    public void setECO121(float ECO121) {
        this.ECO121 = ECO121;
    }

    public float getENM401() {
        return ENM401;
    }

    public void setENM401(float ENM401) {
        this.ENM401 = ENM401;
    }

    public float getOBE102c() {
        return OBE102c;
    }

    public void setOBE102c(float OBE102c) {
        this.OBE102c = OBE102c;
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
                getACC101(), getENM401(), getECO121(), getOBE102c(), getSSG104());
    }

    @Override
    public double calculateGPA() {
        return (this.ACC101 + this.ENM401 + this.ECO121 + this.OBE102c + this.SSG104) / 5;
    }

    @Override
    public void ketQuaHocTap() {
        int count = 0;
        if (getACC101() >= 4 && getACC101() <= 10) {
            count++;
            System.out.println("Total ACC101: " + getACC101() + "--PASSED--(^_^)");
        } else if (getACC101() < 4) {
            System.out.println("Total ACC101: " + getACC101() + "-- NOT PASSED-- (*__*)");
        }
        if (getENM401() >= 4 && getENM401() <= 10) {
            count++;
            System.out.println("Total ENM401: " + getENM401() + "--PASSED--(^_^)");
        } else if (getENM401() < 4) {
            System.out.println("Total ENM401: " + getENM401() + "-- NOT PASSED-- (*__*)");
        }
        if (getECO121() >= 4 && getECO121() <= 10) {
            count++;
            System.out.println("Total ECO121: " + getECO121() + "--PASSED--(^_^)");
        } else if (getECO121() < 4) {
            System.out.println("Total ECO121: " + getECO121() + "-- NOT PASSED-- (*__*)");
        }
        if (getOBE102c() >= 4 && getOBE102c() <= 10) {
            count++;
            System.out.println("Total OBE102c: " + getOBE102c() + "--PASSED--(^_^)");
        } else if (getOBE102c() < 4) {
            System.out.println("Total OBE102c: " + getOBE102c() + "-- NOT PASSED-- (*__*)");
        }
        if (getSSG104() >= 4 && getSSG104() <= 10) {
            count++;
            System.out.println("Total SSG104: " + getSSG104() + "--PASSED--(^_^)");
        } else if (getSSG104() < 4) {
            System.out.println("Total SSG104: " + getSSG104() + "-- NOT PASSED-- (*__*)");
        }
        System.out.println("Tổng số môn vượt qua" + count + "/5 COUCRSE.");
        double gpa = calculateGPA();
        if (gpa >= 9 && gpa <= 10) {
            System.out.println("ACHIEVEMENT: SINH VIÊN XUẤT SẮC KHỐI NGÀNH KINH TẾ.");
        } else if (gpa >= 8 && gpa < 9) {
            System.out.println("ACHIEVEMENT: SINH VIÊN GIỎI KHỐI NGÀNH KINH TẾ.");
        }
    }

}
