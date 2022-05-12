import java.util.ArrayList;
import java.util.HashMap;

public class OrderProcessor<T> {
    GenericOrder orderG;
    ComputerOrder orderC;
    PartyTrayOrder orderP;

    public OrderProcessor(GenericOrder orderG) {
        this.orderG = orderG;
    }

    public OrderProcessor(ComputerOrder orderC) {
        this.orderC = orderC;
    }

    public OrderProcessor(PartyTrayOrder orderP) {
        this.orderP = orderP;
    }

    public ArrayList<T> orders = new ArrayList<>();

    // this method accepts a GenericOrder or any of its subclass objects and stores it in any internal collection of OrderProcessor.
    void accept(ArrayList<T> order) {
        orders.addAll(order);
    }

    // this method sorts all accepted orders in the internal collection of GenericOrder into collections of ComputerPart, Peripheral,
    // Cheese, Fruit, and Service.
    void process() {

        ArrayList<TwoTuple> cheeses = new ArrayList<>();
        ArrayList<TwoTuple> computerParts = new ArrayList<>();
        ArrayList<TwoTuple> fruits = new ArrayList<>();
        ArrayList<TwoTuple> peripherals = new ArrayList<>();
        ArrayList<TwoTuple> services = new ArrayList<>();

        ArrayList<TwoTuple> prices = new ArrayList<>();
        ArrayList<TwoTuple> orderNums = new ArrayList<>();

        for (int i = 0; i < orders.size(); i++) {

            TwoTuple<String, String> item = new TwoTuple<>("name", orders.get(i).getClass().getSimpleName());
            TwoTuple<String, Float> price;
            TwoTuple<String, Integer> orderNumber = new TwoTuple<>("order number", orderG.orderNum);
            orderNums.add(orderNumber);

            switch (orders.get(i).getClass().getSuperclass().getSimpleName()) {
                case "Cheese":

                    cheeses.add(item);

                    if (orders.get(i).getClass().getSimpleName().equals("Mozzarella")) {
                        price = new TwoTuple<>("price", CheeseInterface.Mozzarella.price);
                        prices.add(price);
                        System.out.println(CheeseInterface.Mozzarella.price);
                    } else if (orders.get(i).getClass().getSimpleName().equals("Cheddar")) {
                        price = new TwoTuple<>("price", CheeseInterface.Cheddar.price);
                        prices.add(price);
                    }

                    break;
                case "ComputerPart":

                    computerParts.add(item);

                    if (orders.get(i).getClass().getSimpleName().equals("Motherboard")) {
                        price = new TwoTuple<>("price", ComputerPartInterface.Motherboard.price);
                        prices.add(price);
                    } else if (orders.get(i).getClass().getSimpleName().equals("RAM")) {
                        price = new TwoTuple<>("price", ComputerPartInterface.RAM.price);
                        prices.add(price);
                    } else if (orders.get(i).getClass().getSimpleName().equals("Drive")) {
                        price = new TwoTuple<>("price", ComputerPartInterface.Drive.price);
                        prices.add(price);
                    }

                    break;
                case "Fruit":

                    fruits.add(item);

                    if (orders.get(i).getClass().getSimpleName().equals("Apple")) {
                        price = new TwoTuple<>("price", FruitInterface.Apple.price);
                        prices.add(price);
                    } else if (orders.get(i).getClass().getSimpleName().equals("Orange")) {
                        price = new TwoTuple<>("price", FruitInterface.Orange.price);
                        prices.add(price);
                    }

                    break;
                case "Peripheral":

                    peripherals.add(item);

                    if (orders.get(i).getClass().getSimpleName().equals("Printer")) {
                        price = new TwoTuple<>("price", PeripheralInterface.Printer.price);
                        prices.add(price);
                    } else if (orders.get(i).getClass().getSimpleName().equals("Monitor")) {
                        price = new TwoTuple<>("price", PeripheralInterface.Monitor.price);
                        prices.add(price);
                    }

                    break;
                case "Service":

                    services.add(item);

                    if (orders.get(i).getClass().getSimpleName().equals("DeliveryService")) {
                        price = new TwoTuple<>("price", ServiceInterface.DeliveryService.price);
                        prices.add(price);
                    } else if (orders.get(i).getClass().getSimpleName().equals("AssemblyService")) {
                        price = new TwoTuple<>("price", ServiceInterface.AssemblyService.price);
                        prices.add(price);
                    }

                    break;
                default:

                    System.out.println("Something went wrong.");

                    break;
            }
        }
        System.out.println(fruits);
        System.out.println(cheeses);
        System.out.println(peripherals);
        System.out.println(prices);
        System.out.println(orderNums);
    }

    // this method simulates the dispatch of the sorted collections.
    void dispatch() {

    }
}
