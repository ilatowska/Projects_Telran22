package de.telran;

import java.util.Arrays;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String string3 = new String("Hello world");
        // constructor from char array
        String stringFromChars = new String(new char[]{'H', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'});
        String string = "Hello world";
        String string2 = "Hello world";

        System.out.println(string == string2);//true
        System.out.println(string == string3);//false
        System.out.println(string == stringFromChars);//false
        System.out.println(string3 == stringFromChars);//false

        System.out.println(string.equals(string2));//true
        System.out.println(string.equals(string3));//true
        System.out.println(string.equals(stringFromChars));//true
        System.out.println(string3.equals(stringFromChars));//true

        // char
        char a = 'a';
        System.out.println(a);//'a'
        System.out.println(a + 0);//97
        System.out.println(string + a);//Hello worlda
        System.out.println(string + a + 0);//Hello worlda0

        // charAt() -> char
        System.out.println(string.charAt(2));//'l'

        // concat -> str
        System.out.println(string.concat(" ").concat(string2));// Hello worldHello world
        System.out.println(string + string2);// Hello worldHello world

        // contains() -> boolean
        System.out.println(string.contains("llo"));//true

        // startsWith(), endsWith() -> boolean
        System.out.println(string.startsWith("Hell"));

        // equalsIgnoreCase() -> boolean
        String hello1 = "HeLlO";
        String hello2 = "hellO";
        System.out.println(hello1.equalsIgnoreCase(hello2));//true

        // indexOf() -> int - returns the first index of the pattern in the string
        System.out.println(string.indexOf("lo"));//3
        System.out.println(string.indexOf("llo"));//2
        System.out.println(string.indexOf("l", 4));//9

        // lastIndexOf() -> int - returns the last index of the pattern
        System.out.println(string.lastIndexOf("l"));//9
        System.out.println(string.lastIndexOf("l", 8));//3

        // length() -> int
        System.out.println(string.length());//11

        // split() -> String[] формирует массив строк, деля изначальную строку по разделителю
        String[] fromString = string.split("l");
        System.out.println(Arrays.toString(fromString));
        System.out.println(Arrays.toString(string.split(" ")));

        // toCharArray() -> char[]
        char[] chars = string.toCharArray();// {'H', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'}
        System.out.println(Arrays.toString(chars));

        // toLowerCase(), toUpperCase() -> String
        String upperString = string.toUpperCase();
        System.out.println(string);
        System.out.println(upperString);

        // substring() -> String, the second argument, which is the index of the end, applies exclusively
        String substring1 = string.substring(2);// llo world
        String substring2 = string.substring(2, 8);// llo wo
        System.out.println(substring1);
        System.out.println(substring2);

        // reverse()
        System.out.println(reverse(string));
        System.out.println(reverse2(string));

        //Palindrome
        System.out.println(isPalindrome1("hAllah"));
        System.out.println(countOccurrences("Hello world", "ll"));
        //System.out.println("Hello world".substring(0, 10));
        System.out.println(getString("Hello world guys", 5));
    }

    //(*) Дана строка, состоящая только из слов и пробелов, и число N.
    // Вернуть новую строку максимальной длины, состоящую из начала исходной строки,
    // содержащую ТОЛЬКО слова целиком, при этом длины не больше чем N.
    // Пример: (Hello world guys, 8 ) -> Hello. (Hello world guys, 12 )
    // -> Hello world. (Hello world guys, 16+ ) -> Hello world guys.

    static String getString(String str, int n) {
        if (n >= str.length())
            return str;

        if (str.charAt(n) == ' ')
            return str.substring(0, n - 1);

        else
            return str.substring(0, str.lastIndexOf(" " , n));

    }
    //Написать метод, который принимает строку, а возвразает boolean - является ли строка палиндромом (игнорируя регистр).
    // Пример: Алла. "А роза упала на лапу Азора" - не палиндром в рамках указанной задачи.
    // Пробелы не игнорируются. (Использовать метод с урока по развороту строки)

    static boolean isPalindrome1(String str) {
        return str.equalsIgnoreCase(reverse(str));
    }

    static boolean isPalindrome2(String str) {
        str = str.toLowerCase();
        for (int i = 0; i < str.length() / 2; i++) {
            if (!(str.charAt(i) == str.charAt(str.length() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    //Написать метод, который принимает строку и паттерн, и возвращает количество
    // вхождений паттерна в строку. Пример: ("Hello world", "l") -> 3

    static int countOccurrences(String str, String pattern) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            i = str.indexOf(pattern, i);
            if (i == -1)
                return count;
            count++;
        }
        return count;
    }

    static String reverse(String str) {
        char[] chars = new char[str.length()];

        for (int i = 0; i < chars.length; i++) {
            chars[i] = str.charAt(chars.length - 1 - i);
        }

        return new String(chars);
    }

    // very slow variant
    static String reverse2(String str) {
        String res = "";

        for (int i = 0; i < str.length(); i++) {
            res += str.charAt(str.length() - 1 - i);
        }

        return res;
    }


}