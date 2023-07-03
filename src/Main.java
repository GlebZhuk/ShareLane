import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        class Group { String name;  float mark; }

        //Вводим количество студентов
        System.out.println("Введите количество студентов:");
        Scanner input1=new Scanner (System.in);
        int n=input1.nextInt();

        //Даем имена студентам
      Group[] student = new Group[n];
            for (int i=0;i<n;i++) {
            student[i]=new Group();
            System.out.println("Введите имя студента "+(i+1));
            Scanner input2=new Scanner (System.in);
            String name= input2.nextLine();
            student[i].name= name;
            //Присваем средний балл
            student [i].mark= (float) Math.random()*10;
        }

        //создаем меню
        boolean run = true;
        while (run) {
            System.out.println("Выберете действие:");
            System.out.println("1.Просмотр студентов");
            System.out.println("2.Генерация оценок");
            System.out.println("3.Просмотр лучшего студента");
            System.out.println("4.выход");
            Scanner input4 = new Scanner(System.in);
            int f = input4.nextInt();
            switch (f) {

                case 1:
                    for (int i=0;i<n;i++) {
                        System.out.println(student[i].name);}
                    break;

                case 2:
                    for (int i=0;i<n;i++) {
                    System.out.println(student[i].mark);}break;

                case 3:
                    String nameMax=student[0].name;
                    float markMax=student[0].mark;
                    for (int i=0;i<n;i++) {
                   if (markMax<student[i].mark) {
                       markMax=student[i].mark;
                       nameMax=student[i].name;
                        }
                        }
                    System.out.println("Лучший ученик:");
                    System.out.println(nameMax);
                    System.out.println("Средний балл:");
                    System.out.println(markMax);break;

                case 4:
                    run = false;break;
                default:     System.out.println("Некорректный ввод");break;
            }
        }
    }
}




