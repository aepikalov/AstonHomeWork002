import Entity.Trader;
import Entity.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
        System.out.println("1. Все транзакции за 2011 год, отсортироватнные по сумме (от меньшей к большей):");
        transactions.stream().filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue)).forEach(System.out::println);

        // 2. Вывести список неповторяющихся городов, в которых работают трейдеры.
        System.out.println("\n2. Список неповторяющихся городов, в которых работают трейдеры:");
        transactions.stream().map(t -> t.getTrader().getCity()).distinct().forEach(System.out::println);

        // 3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        System.out.println("\n3. Все трейдеры из Кембриджа, отсортированные по их именам:");
        transactions.stream().map(Transaction::getTrader).distinct()
                .filter(t -> Objects.equals(t.getCity(), "Cambridge"))
                .sorted((Comparator.comparing(Trader::getName))).forEach(System.out::println);

        // 4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
        System.out.println("\n4. Строка со всеми именами трейдеров, отсортированными в алфавитном порядке:");
        transactions.stream().map(t -> t.getTrader().getName()).distinct()
                .sorted().forEach(t -> System.out.print(t + " "));

        // 5. Выяснить, существует ли хоть один трейдер из Милана.
        System.out.println("\n\n5. Поиск хоть одного трейдера из Милана:");
        transactions.stream().map(Transaction::getTrader).distinct()
                .filter(t -> Objects.equals(t.getCity(), "Milan")).forEach(System.out::println);

        // 6. Вывести суммы всех транзакций трейдеров из Кембриджа.
        System.out.println("\n6. Суммы всех транзакций трейдеров из Кембриджа:");
        transactions.stream().filter(t -> Objects.equals(t.getTrader().getCity(), "Cambridge"))
                .map(Transaction::getValue).forEach(System.out::println);

        //7. Какова максимальная сумма среди всех транзакций?
        System.out.println("\n7. Максимальная сумма среди всех транзакций:");
        System.out.println(transactions.stream().map(Transaction::getValue).max(Integer::compareTo).get());

        //8. Найти транзакцию с минимальной суммой.
        System.out.println("\n8. Транзакция с минимальной суммой:");
        System.out.println(transactions.stream().map(Transaction::getValue).min(Integer::compareTo).get());
    }
}