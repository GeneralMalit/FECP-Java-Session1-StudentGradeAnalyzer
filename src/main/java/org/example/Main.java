package org.example;

import java.util.*;


public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int students = sc.nextInt();
        sc.nextLine();
        String name;
        int score;
        int topscore = 0;
        String letterGrade;

        List<Integer> scores = new ArrayList<>();
        Map<String, Integer> letterGrades = new HashMap<>();
        List<String> topStudents = new ArrayList<>();

        //hashmap initialization:
        letterGrades.put("A", 0);
        letterGrades.put("B", 0);
        letterGrades.put("C", 0);
        letterGrades.put("D", 0);
        letterGrades.put("F", 0);

        for(int i = 1; i<=students; i++){
            System.out.printf("Enter name of student %d: ", i);
            name = sc.nextLine();
            System.out.printf("Enter score for %s: ", name);
            score = sc.nextInt();
            sc.nextLine();
            letterGrade = getLetterGrade(score);
            System.out.printf("%s got grade: %s\n\n", name, letterGrade);
            scores.add(score);

            int letterGradeScore = letterGrades.get(letterGrade);
            letterGrades.put(letterGrade, letterGradeScore + 1);
            if(score > topscore){
                topStudents.clear();
                topStudents.add(name);
                topscore = score;
                //clear topStudents ArrayList
                //append name
            }else if(score == topscore){
                topStudents.add(name);
            }
        }

        getClassSummary(scores, letterGrades, topStudents, topscore);
    }

    public static String getLetterGrade(int score) {
        String letterGrade = null;

        if(score >= 90 && score <= 100){
            letterGrade = "A";
        }else if(score >= 80 && score <= 89){
            letterGrade = "B";
        }else if(score >= 70 && score <= 79){
            letterGrade = "C";
        }else if(score >= 60 && score <= 69){
            letterGrade = "D";
        }else{
            letterGrade = "F";
        }


        return letterGrade;
    }

    public static void getClassSummary(List<Integer> scores ,Map<String, Integer> letterGrades, List<String> topstudents, int topscore){
        int totalScore = 0;
        for(int score: scores){
            totalScore += score;
        }
        double averageScore = (double) totalScore / scores.size();
        int countA = letterGrades.get("A");
        int countB = letterGrades.get("B");
        int countC = letterGrades.get("C");
        int countD = letterGrades.get("D");
        int countF = letterGrades.get("F");


        System.out.println("----- Class Summary -----");
        System.out.printf("Average Score: %.2f\n", averageScore);
        System.out.printf("Grade Counts: A:%d, B:%d, C:%d, D:%d, F:%d.\n", countA, countB, countC, countD, countF);

        String topStudentString = topstudents.toString();
        topStudentString = topStudentString.substring(1, topStudentString.length() - 1);
        System.out.printf("Top Student(s): %s (%d)", topStudentString, topscore);


    }



}
