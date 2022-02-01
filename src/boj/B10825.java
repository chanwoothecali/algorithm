package boj;

import java.util.Arrays;

public class B10825 {

    static int N;
    static Student[] students;
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static class Student implements Comparable<Student>{
        String name;
        int kor, eng, math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Student o) {
            
            // 국어 내림차순
            if(this.kor != o.kor) {
                return o.kor - this.kor;
            // 영어 오름차순
            } else if (this.eng != o.eng) {
                return this.eng - o.eng;
            // 수학 내림차순
            } else if (this.math != o.math) {
                return o.math - this.math;
            // 이름 알파벳순
            } else {
                return this.name.compareTo(o.name);
            }
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", kor=" + kor +
                    ", eng=" + eng +
                    ", math=" + math +
                    '}';
        }
    }

    static void input() {
        N = scan.nextInt();
        students = new Student[N];
        for (int i = 0; i < N; i++) {
            String student = scan.nextLine();
            String[] text = student.split(" ");
            students[i] = new Student(text[0], Integer.parseInt(text[1]),
                    Integer.parseInt(text[2]), Integer.parseInt(text[3]));
        }
    }

    static void reqFunc() {
        Arrays.sort(students);
        for (int i = 0; i < N; i++) {
            sb.append(students[i].getName()).append('\n');
        }
    }

    public static void main(String[] args) {
        input();

        reqFunc();
        System.out.println(sb.toString());
    }
}
