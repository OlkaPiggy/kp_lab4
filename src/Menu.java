
/*У текстовому файлі задана інформація, яка складається з багатьох стрічок.
        Між словами в стрічці може бути один або кілька пропусків. Продемонструвати
        роботу програм для файлів з українським та англійським текстом.
        Зчитати інформацію, використавши клас Scanner. Виконати завдання
        відповідно до призначеного варіанту. Не використовувати регулярні вирази.*/

/*Варіант 7. Вилучити в окремий список всі правильні записи формул. У формулі
        можуть бути числа, ідентифікатори, дужки та операції –
        З вилучених формул утворити список ідентифікаторів, що в них зустрічаються.
        У вихідному тексті поміняти ідентифікатори в формулах в довільному порядку.*/

import java.io.File;
import java.util.Scanner;

public class Menu {

    static void menu()
    {
        while(true) {
            Scanner in=new Scanner(System.in);
            System.out.println("What do you want to do?");
            System.out.println("1) read from file\n2) print list of identificators\n3) swap identificators and print the whole text");
            System.out.println("4) write in file\n");

            int choose = in.nextInt();
            File f = new File("formula.txt");
            Formula formula=new Formula(f);
            if (choose == 1) {
                formula.print();
            }
            else if(choose==2)
            {
                formula.getIdentificators();
            }
            else if(choose==3)
            {
                formula.shuffleIdentificatorsInFormulas();
                formula.writeConsole(f);
            }
            else if(choose==4)
            {
                formula.shuffleIdentificatorsInFormulas();
                formula.writeFile(f);
            }
            else
                break;

        }
    }
}
