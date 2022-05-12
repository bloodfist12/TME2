import java.util.ArrayList;

public class PartyTrayOrder<T> extends GenericOrder<T> implements CheeseInterface, FruitInterface, ServiceInterface {

    T product;

    public ArrayList<T> partyOrderList = new ArrayList<T>();

    public PartyTrayOrder(int orderNum) {
        super(orderNum);
    }

    public void addToOrder(PartyTrayOrder<T> product) {
        partyOrderList.add((T) product);
    }

}
