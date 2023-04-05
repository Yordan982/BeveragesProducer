package beverageproducer;

import beverageproducer.exceptions.NegativeValueException;
import beverageproducer.products.*;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        try {
            PurchasingSoftware purchasingSoftware = new PurchasingSoftware();
            System.out.printf("Total amount (EUR): %.2f", purchasingSoftware.calculatePrice(returnById(input[0]), loadedProducts(input)));
        } catch (NegativeValueException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Map<BaseProduct, Integer> loadedProducts(int[] input) {
        Map<BaseProduct, Integer> products = new HashMap<>();
        products.put(new ProductA(), input[1]);
        products.put(new ProductB(), input[2]);
        products.put(new ProductC(), input[3]);
        products.put(new ProductD(), input[4]);
        return products;
    }

    public static Client returnById(int id) {
        List<Client> clients = new ArrayList<>();
        Client clientOne = new Client(BigDecimal.valueOf(0.05), BigDecimal.valueOf(0), BigDecimal.valueOf(0.02));
        clients.add(clientOne);
        Client clientTwo = new Client(BigDecimal.valueOf(0.04), BigDecimal.valueOf(0.01), BigDecimal.valueOf(0.02));
        clients.add(clientTwo);
        Client clientThree = new Client(BigDecimal.valueOf(0.03), BigDecimal.valueOf(0.01), BigDecimal.valueOf(0.03));
        clients.add(clientThree);
        Client clientFour = new Client(BigDecimal.valueOf(0.02), BigDecimal.valueOf(0.03), BigDecimal.valueOf(0.05));
        clients.add(clientFour);
        Client clientFive = new Client(BigDecimal.valueOf(0), BigDecimal.valueOf(0.05), BigDecimal.valueOf(0.07));
        clients.add(clientFive);
        return clients.get(id - 1);
    }
}