import java.util.Scanner;
import java.util.regex.Pattern;
public class KTDG {
    static Scanner sc = new Scanner(System.in);
    static String[] mssvList = new String[100];
    static int count = 0;
    static final String MSSV_REGEX = "B\\d{7}";

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            System.out.print("Nhap lua chon: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    showMSSV();
                    break;
                case 2:
                    addMSSV();
                    break;
                case 3:
                    updateMSSV();
                    break;
                case 4:
                    deleteMSSV();
                    break;
                case 5:
                    searchMSSV();
                    break;
                case 6:
                    System.out.println("Ket thuc chuong trinh");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        } while (choice != 6);
    }

    // Hiển thị menu
    static void showMenu() {
        System.out.println("\n----- MENU -----");
        System.out.println("1. Hien thi danh sach MSSV");
        System.out.println("2. Them MSSV");
        System.out.println("3. Cap nhat MSSV");
        System.out.println("4. Xoa MSSV");
        System.out.println("5. Tim kiem MSSV");
        System.out.println("6. Thoat");
    }

    // Hiển thị
    static void showMSSV() {
        if (count == 0) {
            System.out.println("Danh sach rong");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + mssvList[i]);
        }
    }

    // Thêm
    static void addMSSV() {
        if (count == 100) {
            System.out.println("Danh sach da day");
            return;
        }
        String mssv;
        while (true) {
            System.out.print("Nhap MSSV: ");
            mssv = sc.nextLine();

            if (Pattern.matches(MSSV_REGEX, mssv)) {
                break;
            }
            System.out.println("Sai dinh dang MSSV (VD: B2101234)");
        }
        mssvList[count] = mssv;
        count++;
        System.out.println("Them thanh cong");
    }

    // Cập nhật
    static void updateMSSV() {
        System.out.print("Nhap vi tri can sua (0 - " + (count - 1) + "): ");
        int index = Integer.parseInt(sc.nextLine());

        if (index < 0 || index >= count) {
            System.out.println("Vi tri khong hop le");
            return;
        }

        String newMSSV;
        while (true) {
            System.out.print("Nhap MSSV moi: ");
            newMSSV = sc.nextLine();

            if (Pattern.matches(MSSV_REGEX, newMSSV)) {
                break;
            }
            System.out.println("Sai dinh dang MSSV");
        }

        mssvList[index] = newMSSV;
        System.out.println("Cap nhat thanh cong");
    }

    // Xoa
    static void deleteMSSV() {
        System.out.print("Nhap MSSV can xoa: ");
        String deleteCode = sc.nextLine();
        int pos = -1;
        for (int i = 0; i < count; i++) {
            if (mssvList[i].equalsIgnoreCase(deleteCode)) {
                pos = i;
                break;
            }
        }
        if (pos == -1) {
            System.out.println("Khong tim thay MSSV");
            return;
        }
        for (int i = pos; i < count - 1; i++) {
            mssvList[i] = mssvList[i + 1];
        }
        mssvList[count - 1] = null;
        count--;

        System.out.println("Xoa thanh cong");
    }

    // Tim Kiem
    static void searchMSSV() {
        System.out.print("Nhap MSSV: ");
        String search = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (mssvList[i].equalsIgnoreCase(search)) {
                System.out.println("Tim thay MSSV tai vi tri: " + i);
                found = true;
                break;
            }
            if (!found) {
                System.out.println("Khong tim thay MSSV");
            }
        }
    }
}