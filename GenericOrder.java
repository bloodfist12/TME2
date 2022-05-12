import java.util.ArrayList;

public class GenericOrder<T> {
    public ArrayList<T> orderList = new ArrayList<T>();
    int orderNum;

    public ArrayList<T> getOrderList() {
        return orderList;
    }
    public GenericOrder(int orderNum) {
        this.orderNum = orderNum;
    }

    public void addToOrder(T product) {
        orderList.add(product);
    }
}