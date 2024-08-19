package project_pro_192;

public class SinhVienNgonNgu extends SinhVien{
         private float EAL202c;
         private float EAW222;
         private float ECB101;
         private float ITG202;
         private float SSG104;

    public SinhVienNgonNgu() {
    }

    public SinhVienNgonNgu(String id, String hoVaTen, String ngaySinh, String queQuan, String tenLop,float EAL202c, float EAW222, float ECB101, float ITG202, float SSG104) {
        super(id, hoVaTen, ngaySinh, queQuan, tenLop);
        this.EAL202c = EAL202c;
        this.EAW222 = EAW222;
        this.ECB101 = ECB101;
        this.ITG202 = ITG202;
        this.SSG104 = SSG104;
    }

    

    public float getEAL202c() {
        return EAL202c;
    }

    public void setEAL202c(float EAL202c) {
        this.EAL202c = EAL202c;
    }

    public float getEAW222() {
        return EAW222;
    }

    public void setEAW222(float EAW222) {
        this.EAW222 = EAW222;
    }

    public float getECB101() {
        return ECB101;
    }

    public void setECB101(float ECB101) {
        this.ECB101 = ECB101;
    }

    public float getITG202() {
        return ITG202;
    }

    public void setITG202(float ITG202) {
        this.ITG202 = ITG202;
    }

    public float getSSG104() {
        return SSG104;
    }

    public void setSSG104(float SSG104) {
        this.SSG104 = SSG104;
    }

         @Override
    public void inThongTin() {
        System.out.printf("| %-12s | %20s | %15s | %-17s | %15s | %10.2f | %10.2f | %10.2f | %10.2f | %10.2f |%n",getId(),getHoVaTen(),getNgaySinh(),getQueQuan(),getTenLop(),getEAL202c(),getEAW222(),getECB101(),getITG202(),getSSG104());
      }

    @Override
    public double calculateGPA() {
       return (this.EAL202c + this.EAW222 + this.ECB101 + this.ITG202 + this.SSG104) / 5;
    }

    @Override
    public void ketQuaHocTap() {
         int count = 0;
        if (getEAL202c() >= 4 && getEAL202c() <= 10) {
            count++;
            System.out.println("Total EAL202c: " + getEAL202c() + "--PASSED--(^_^)");
        } else if (getEAL202c() < 4) {
            System.out.println("Total EAL202c: " + getEAL202c() + "-- NOT PASSED-- (*__*)");
        }
        if (getECB101() >= 4 && getECB101() <= 10) {
            count++;
            System.out.println("Total ECB101: " + getECB101() + "--PASSED--(^_^)");
        } else if (getECB101() < 4) {
            System.out.println("Total ECB101: " + getECB101() + "-- NOT PASSED-- (*__*)");
        }
        if (getEAW222() >= 4 && getEAW222() <= 10) {
            count++;
            System.out.println("Total EAW222: " + getEAW222() + "--PASSED--(^_^)");
        } else if (getEAW222() < 4) {
            System.out.println("Total EAW222: " + getEAW222() + "-- NOT PASSED-- (*__*)");
        }
        if (getITG202() >= 4 && getITG202() <= 10) {
            count++;
            System.out.println("Total ITG202: " + getITG202() + "--PASSED--(^_^)");
        } else if (getITG202() < 4) {
            System.out.println("Total ITG202: " + getITG202() + "-- NOT PASSED-- (*__*)");
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
            System.out.println("ACHIEVEMENT: SINH VIÊN XUẤT SẮC KHỐI NGÀNH NGÔN NGỮ.");
        } else if (gpa >= 8 && gpa < 9) {
            System.out.println("ACHIEVEMENT: SINH VIÊN GIỎI KHỐI NGÀNH NGÔN NGỮ.");
        }
    }
    
}