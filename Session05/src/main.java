import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class main {
    static Scanner sc = new Scanner(System.in);

    static void main() {
        int choice;

        do {
            showMainMenu();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    twoSum();
                    break;
                case 2:
                    moveZeroes();
                    break;
                case 3:
                    validPalindrome();
                    break;
                case 4:
                    reverseWords();
                    break;
                case 5:
                    happyNumber();
                    break;
                case 0:
                    System.exit(0);
            }
        } while (choice != 0);
    }

    static void showMainMenu() {
        System.out.println("\n==== MENU THUẬT TOÁN JAVA ====");
        System.out.println("1. Two Sum");
        System.out.println("2. Move Zeroes");
        System.out.println("3. Valid Palindrome");
        System.out.println("4. Reverse Words");
        System.out.println("5. Happy Number");
        System.out.println("0. Exit");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    static void twoSum() {
        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.print("Nhập target: ");
        int target = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (a[i] + a[j] == target) {
                    System.out.println("Indices: " + i + ", " + j);
                    found = true;
                    return;
                }
            }
        }

        if (!found)
            System.out.println("Không tìm thấy cặp số phù hợp.");
    }

    static void moveZeroes() {
        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Nhập các phần tử:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != 0) {
                a[index++] = a[i];
            }
        }

        for (int k = index; k < n; k++) {
            a[k] = 0;
        }

//        for (int i = 0; i < n; i++) {
//            if (a[i] != 0) {
//                int temp = a[i];
//                a[i] = a[index];
//                a[index] = temp;
//                index++;
//            }
//        }

        System.out.println("Mảng sau khi dồn số 0:");
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    static void validPalindrome() {
        System.out.print("Nhập chuỗi: ");
        String s = sc.nextLine();

        s = s.replaceAll("[^a-zA-Z0-9]", "");

        boolean isPalindrome = true;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println("Chuỗi đối xứng? " + isPalindrome);
    }

    static void reverseWords() {
        System.out.print("Nhập chuỗi: ");
        String s = sc.nextLine();

        s = s.replaceAll("\\s+", " ").trim();

        String[] words = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for(int w = words.length - 1; w >= 0; w--) {
            sb.append(words[w]);
            if(w != 0)
                sb.append(" ");
        }
        System.out.println("Chuỗi sau khi đảo từ:");
        System.out.println(sb.toString());
    }

    static void happyNumber() {
        System.out.print("Nhập số n: ");
        int n = sc.nextInt();

//        Set<Integer> set = new HashSet<>();
//
//        while(n !=1 && !set.contains(n)){
//            set.add(n);
//            n = sumOfSuares(n);
//        }

        // Thuật toán Floyd's Cycle-Finding
        int slow =n, fast =n;
        do{
            slow = sumOfSuares(slow);
            fast = sumOfSuares(sumOfSuares(fast));
        }while(slow != fast);

        if(slow == 1){
            n = slow;
        }

        if (n == 1) {
            System.out.println("Đây là số hạnh phúc.");
        } else {
            System.out.println("Đây KHÔNG phải là số hạnh phúc.");
        }
    }

    static int sumOfSuares(int n){
        int sum =0;
        while(n> 0){
            sum += (n%10)*(n%10);
            n /= 10;
        }
        return sum;
    }
}
