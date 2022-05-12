import java.util.ArrayList;

public class ComputerOrder<T> extends GenericOrder<T> implements ComputerPartInterface, PeripheralInterface, ServiceInterface{

    T product;

    public ArrayList<T> compOrderList = new ArrayList<T>();

    public ComputerOrder(int orderNum) {
        super(orderNum);
    }

    public void addToOrder(ComputerOrder<T> product) {
        compOrderList.add((T) product);
    }

}
