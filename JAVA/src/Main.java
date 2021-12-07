import myNewPackage.LoanIssuer;
import myNewPackage.LoanUser;

public class Main {

    public static void main(String[] args) {

        //credits(18);
        //printBehavior(6, -10);

        //Если работник ленивый, он одобрит кредит в случае, если у клиента зп больше 20000 в год.
        //Если работник неленивый и добрый, он оформит кредит, если зп больше 20000 и клиенту не больше 70
        //Если работник неленивый и злой, он оформит кредит, если зп больше 20000 и клиенту не больше 50.
        LoanUser youngUser = new LoanUser("Vasya", "Vasin", 60, 40000);
        LoanIssuer lazyAndKindIssuer = new LoanIssuer("Maria", "Petrovna", false, false);
        System.out.println(lazyAndKindIssuer.toProvide(youngUser));// the result tells whether the issuer provides a loan to the user

        System.out.println(ModifiedBinarySearch(new int[]{1, 5, 7, 12, 15}, 7));//2
        System.out.println(ModifiedBinarySearch(new int[]{1, 5, 7, 12, 15}, 6));//-3
        System.out.println(ModifiedBinarySearch(new int[]{1, 5, 7, 12, 15}, 0));//-1
        System.out.println(ModifiedBinarySearch(new int[]{1, 5, 7, 12, 15}, 20));//-6
    }

        /* Binary Search
        Написать метод, который принимает отсортированный массив и число, и возвращает либо реальный индекс,
        по которому находится число, либо число, равное индексу, на который можно поставить элемент,
        не нарушая порядка, плюс 1 и с минусом.
        Пример 1: func({1, 5, 7, 12, 15}, 7) -> 2
        Пример 2: func({1, 5, 7, 12, 15}, 6) -> -3
        Пример 2: func({1, 5, 7, 12, 15}, 0) -> -1 */

    static int ModifiedBinarySearch(int[] array, int number) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (array[middle] < number) {
                left = middle + 1;
            } else if (array[middle] > number) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (number < array[i]) {
                return -(i + 1);
            }
        }

        return -(array.length + 1);
    }

    /* Маша выдает 50 кредитов в месяц, каждый месяц улучшая производительность на 1 шт.
        Петя - 40 в месяц, улучшая производительность каждые 2 месяца на 1.
        Вася первые 10 месяцев выдает 50 кредитов в месяц, каждый месяц ухудшая производительность на 1 шт,
        но потом берет себя в руки, работая стабильно по 50 кредитов в месяц.
        Сколько они сделают за полтора года?
        --> Полтора года - это 18 месяцев*/

    public static void credits(int numOfMonths) {
        int mariaCredits = 50;
        int petrCredits = 40;
        int vasilCredits = 50;
        int result = 0;

        for (int i = 0; i < numOfMonths; i++) {

            if (i < 10) {
                result += mariaCredits + petrCredits + vasilCredits; //+i-i
            } else {
                result += mariaCredits + i + petrCredits + vasilCredits;
            }
            if (i % 2 == 0) {
                petrCredits++;
            }
        }

        System.out.println(result);
    }


    /*Решить задачу про дядю Васю через switch
    (Дядя Вася пойдет на рыбалку в субботу, если температура ваздуха
    будет от 23 до 29 включительно. На буднях он ходит на работу.
    А в воскресенье он пойдет к соседу в баню, если температура воздуха будет не выше -5.
    Написать функцию, которая принимает номер дня недели (1 - 7) и температуру,
    и распечатывает в консоль поведение дяди Васи.)*/
    public static void printBehavior(int day, int temperature) {
        switch (day) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("he goes to work");
                break;
            case 6:
                if (temperature < 23 || temperature > 29) {
                    System.out.println("he stays at home");
                } else {
                    System.out.println("he goes to fishing");
                }
                break;
            case 7:
                if (temperature <= -5) {
                    System.out.println("he goes to sauna");
                    break;
                }
            default:
                System.out.println("he stays at home");
                break;
        }
    }

    public static double calculateCircleLength(double r) {
        return 2 * Math.PI * r;
    }

    public static double calculateCircleArea(double r) {
        return Math.PI * r * r;
    }

    public static double calculateCompoundInterest(double d, double r, int t) {
        return d * Math.pow((1 + r / 100), t);
    }

}
