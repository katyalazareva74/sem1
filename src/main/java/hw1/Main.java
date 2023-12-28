package hw1;

import java.util.List;

public class Main {
    /**
     * Напишите программу, которая использует Stream API для обработки списка чисел.
     * Программа должна вывести на экран среднее значение всех четных чисел в списке.
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = List.of(2, 4, 6, 10, 3, 9);
        System.out.println(list.stream()
                .filter(n -> (n % 2) == 0)
                .mapToDouble(n -> (double) n)
                .average()
                .orElse(0));
    }
}
