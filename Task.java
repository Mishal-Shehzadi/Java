package com.ai.student.task;

import java.util.Scanner;

public class Task {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter no of the students: ");
        int students = input.nextInt();

        System.out.print("Enter the number of subjects: ");
        int subjects = input.nextInt();

        input.nextLine(); // clear buffer

        String[] name = new String[students];
        int[][] marks = new int[students][subjects];

        // Input student names
        for (int i = 0; i < students; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            name[i] = input.nextLine();
        }

        // Input marks
        for (int i = 0; i < students; i++) {
            System.out.println("Enter marks for " + name[i]);
            for (int j = 0; j < subjects; j++) {
                System.out.print("Subject " + (j + 1) + ": ");
                marks[i][j] = input.nextInt();
            }
        }

        int choice;

        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Display all students");
            System.out.println("2. Show result of specific student");
            System.out.println("3. Show topper");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    for (int i = 0; i < students; i++) {
                        int total = 0;
                        System.out.println("\nStudent Name: " + name[i]);
                        System.out.print("Marks: ");
                        for (int j = 0; j < subjects; j++) {
                            System.out.print(marks[i][j] + " ");
                            total += marks[i][j];
                        }
                        float percentage = (float) total / subjects;
                        System.out.println("\nTotal Marks: " + total);
                        System.out.println("Percentage: " + percentage + "%");

                        if (percentage >= 80)
                            System.out.println("Grade: A");
                        else if (percentage >= 70)
                            System.out.println("Grade: B");
                        else if (percentage >= 60)
                            System.out.println("Grade: C");
                        else
                            System.out.println("Grade: Fail");
                    }
                    break;

                case 2:
                    input.nextLine(); // clear buffer
                    System.out.print("Enter student name: ");
                    String choose = input.nextLine();
                    boolean found = false;

                    for (int i = 0; i < students; i++) {
                        if (name[i].equalsIgnoreCase(choose)) {
                            found = true;
                            int total = 0;
                            System.out.print("Marks: ");
                            for (int j = 0; j < subjects; j++) {
                                System.out.print(marks[i][j] + " ");
                                total += marks[i][j];
                            }
                            float percent = (float) total / subjects;
                            System.out.println("\nTotal Marks: " + total);
                            System.out.println("Percentage: " + percent + "%");
                        }
                    }

                    if (!found)
                        System.out.println("Student not found!");
                    break;

                case 3:
                    int maxTotal = 0;
                    int topperIndex = 0;

                    for (int i = 0; i < students; i++) {
                        int total = 0;
                        for (int j = 0; j < subjects; j++) {
                            total += marks[i][j];
                        }
                        if (total > maxTotal) {
                            maxTotal = total;
                            topperIndex = i;
                        }
                    }

                    System.out.println("Topper Name: " + name[topperIndex]);
                    System.out.println("Topper Total Marks: " + maxTotal);
                    break;

                case 4:
                    System.out.println("Program exited.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }
}
