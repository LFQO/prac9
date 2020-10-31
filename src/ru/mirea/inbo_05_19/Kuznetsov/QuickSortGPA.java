package ru.mirea.inbo_05_19.Kuznetsov;

public class QuickSortGPA implements Comparable<Student> {
    public void QuickSort(Student[] array, int low, int high) {
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        double root = array[middle].AverageMark;
        int i = low, j = high;
        while (i <= j) {
            while (array[i].AverageMark > root) {
                i++;
            }
            while (array[j].AverageMark < root) {
                j--;
            }
            if (i <= j) {
                double temp = array[i].AverageMark;
                array[i].AverageMark = array[j].AverageMark;
                array[j].AverageMark = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            QuickSort(array, low, j);
        if (high > i)
            QuickSort(array, i, high);
    }

    public void compareTo(Student[] elements) {
        QuickSort(elements, 0, elements.length - 1);
    }

    public static void main(String args[]) {
        Student array[] = new Student[5];
        String Names[] = new String[]{"Ivan", "Evgeniy", "Alexandr", "Veronika", "Ekaterina"};
        int IDs[] = new int[]{5, 3, 4, 1, 2};
        double AMs[] = new double[]{3.2, 4.1, 3.7, 4.8, 4.5};
        for (int i = 0; i < array.length; i++) {
            array[i] = new Student(Names[i], IDs[i], AMs[i]);
        }
        new QuickSortGPA().compareTo(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].AverageMark);
        }
    }
}