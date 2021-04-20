import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
  public static void main(String[] agrs) {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите цену за квадратный метр:");
    // цена за квадратный метр
    int price = scanner.nextInt();
    scanner.close();
    // количество генерируемых сделок
    int countDeal = random.nextInt(10);
    // список сделок
    List<Deal> list = new ArrayList<Deal>();
    for (int i = 0; i < countDeal; i++) {
      list.add(new Deal(random.nextInt(100) + 1, random.nextInt(100) + 1, random.nextInt(500000000)));
    }

    System.out.println("Нечестные сделки: " + Deal.filterDeals(list, Deal.isNotFairDeal(price)));
    System.out.println("Честные сделки: " + Deal.filterDeals(list, Deal.isFairDeal(price)));
  }
}
