package ru.mirea.inbo_05_19.Kuznetsov;

public class Student implements SortSearch<Student> {
    String Name;
    int iDNumber;
    double AverageMark;

    public Student() {
    }

    public Student(String Name, int iDNumber, double AverageMark) {
        this.Name = Name;
        this.iDNumber = iDNumber;
        this.AverageMark = AverageMark;
    }

    public String getName() {
        return Name;
    }

    public Student search(SortSearch[] element, String name) throws EmptyStringException {
        try {
            for (int i = 0; i < element.length; i++) {
                Student s = (Student) element[i];
                if (s.getName() == name) return (Student) element[i];
            }
            throw new StudentNotFoundException("No students with this name " + name + " was found/");
        } catch (StudentNotFoundException e) {
            if (name == "") throw new EmptyStringException("Name is empty/");
        }
        return null;
    }

    public void sort(SortSearch[] element) {
        QuickSortGPA q = new QuickSortGPA();
        Student[] s = new Student[5];
        for (int i = 0; i < element.length; i++) {
            s[i] = (Student) element[i];
        }
        q.compareTo(s);
    }

    public static void main(String[] args) {
        Student z = new Student();
        SortSearch[] elements = new SortSearch[5];
        Student array[] = new Student[5];
        String Names[] = new String[]{"Ivan", "Evgeniy", "Alexandr", "Veronika", "Ekaterina"};
        int IDs[] = new int[]{5, 3, 4, 1, 2};
        double AMs[] = new double[]{3.2, 4.1, 3.7, 4.8, 4.5};
        for (int i = 0; i < array.length; i++) {
            array[i] = new Student(Names[i], IDs[i], AMs[i]);
            elements[i] = array[i];
        }
        try {
            System.out.println(z.search(elements, "1").getName());
        } catch (NullPointerException e) {
            System.out.println("Name wasn't found/");
        }
        z.sort(elements);
        for (int i = 0; i < elements.length; i++) {
            Student f = (Student) elements[i];
            System.out.println(f.AverageMark);
        }
    }
}