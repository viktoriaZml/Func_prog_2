import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Deal {
  private final int width;
  private final int length;
  private int saleValue;

  public Deal(int width, int length, int saleValue) {
    this.width = width;
    this.length = length;
    this.saleValue = saleValue;
  }

  public int getWidth() {
    return width;
  }

  public int getLength() {
    return length;
  }

  public int getSaleValue() {
    return saleValue;
  }

  @Override
  public String toString() {
    return "Сделка{" +
            "ширина=" + width +
            ", длина=" + length +
            ", стоимость продажи=" + saleValue +
            '}';
  }

  public static Predicate<Deal> isNotFairDeal(int price) {
    return d -> (d.getSaleValue() / (d.getLength() * d.getWidth())) < price;
  }

  public static Predicate<Deal> isFairDeal(int price) {
    return d -> (d.getSaleValue() / (d.getLength() * d.getWidth())) >= price;
  }

  public static List<Deal> filterDeals(List<Deal> deals,
                                       Predicate<Deal> predicate) {
    return deals.stream()
            .filter(predicate)
            .collect(Collectors.<Deal>toList());
  }
}
