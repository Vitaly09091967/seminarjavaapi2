/**2) Реализуйте алгоритм сортировки пузырьком числового массива, результат 
после каждой итерации запишите в лог-файл.
1 3 4 2
1 3 2 4
1 2 3 4*/

import java.io.FileWriter;
import java.io.IOException;

public class zadacha2 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2};
        sortArray(arr, "log.txt");
        printArray(arr);
    }

    public static void sortArray(int[] arr, String filename) {
        int len = arr.length;
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < len - 1; i++) {
                for (int j = 0; j < len - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
                writer.write("After iteration " + (i + 1) + ": ");
                for (int k : arr) {
                    writer.write(k + " ");
                }
                writer.write("\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }
}
