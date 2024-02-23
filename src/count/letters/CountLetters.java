
package count.letters;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class CountLetters {
    public static int countVietnameseCharacters(String input) {
        Map<String, String> vietnameseCharacters = new HashMap<>();
        vietnameseCharacters.put("aw", "ă");
        vietnameseCharacters.put("aa", "â");
        vietnameseCharacters.put("dd", "đ");
        vietnameseCharacters.put("ee", "ê");
        vietnameseCharacters.put("oo", "ô");
        vietnameseCharacters.put("ow", "ơ");
        vietnameseCharacters.put("w", "ư");

        int count = 0;
        StringBuilder result = new StringBuilder();
        String current = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            current += ch;
            if (vietnameseCharacters.containsKey(current)) {
                result.append(current).append(", ");
                current = "";
                count++;
            } else if (!vietnameseCharacters.containsKey(current) && current.length() > 1) {
                current = "" + ch;
            }
        }

        if (result.length() > 0) {
            result.delete(result.length() - 2, result.length()); // Xóa dấu phẩy và khoảng trắng cuối cùng
        }

        System.out.println( result.toString());
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        int result = countVietnameseCharacters(inputString);
        System.out.println( result);
    }
}
