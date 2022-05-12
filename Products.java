
/******************************************************************
 * COMP308 Java for Programmer,
 * SCIS, Athabasca University
 *
 * Edited by: Steven Hamilton, Apr 19, 2022
 *
 * Assignment: TME2
 * @author: Steve Leung
 * @author: Steven Hamilton
 * @date  : Oct 21, 2005
 * @date  : Feb 23, 2022
 *
 ******************************************************************/

abstract class Product {
    protected static float price;

    // return the price of a particular product
    abstract float price();
}

//------------------------------------------------------------
interface ComputerPartInterface {

    class ComputerPart extends Product {
        public ComputerPart(float p) {
            price = p;
        }

        public float price() {
            return price;
        }
    }

    class Motherboard extends ComputerPart {
        protected String manufacturer;

        public Motherboard(String mfg, float p) {
            super(p);
            manufacturer = mfg;
        }

        public String getManufacturer() {
            return manufacturer;
        }
    }

    class RAM extends ComputerPart {
        protected int size;
        protected String manufacturer;

        public RAM(String mfg, int size, float p) {
            super(p);
            this.manufacturer = mfg;
            this.size = size;
        }

        public String getManufacturer() {
            return manufacturer;
        }
    }

    class Drive extends ComputerPart {
        protected String type;
        protected int speed;

        public Drive(String type, int speed, float p) {
            super(p);
            this.type = type;
            this.speed = speed;
        }

        public String getType() {
            return type;
        }

        public int getSpeed() {
            return speed;
        }
    }
}

interface  PeripheralInterface {

    class Peripheral extends Product {
        public Peripheral(float p) {
            price = p;
        }

        public float price() {
            return price;
        }
    }

    class Printer extends Peripheral {
        protected String model;

        public Printer(String model, float p) {
            super(p);
            this.model = model;
        }

        public String getModel() {
            return model;
        }
    }

    class Monitor extends Peripheral {
        protected String model;

        public Monitor(String model, float p) {
            super(p);
            this.model = model;
        }

        public String getModel() {
            return model;
        }
    }
}

interface ServiceInterface {

    class Service extends Product {
        public Service(float p) {
            price = p;
        }

        public float price() {
            return price;
        }
    }

    class AssemblyService extends Service {
        String provider;

        public AssemblyService(String pv, float p) {
            super(p);
            provider = pv;
        }

        public String getProvider() {
            return provider;
        }
    }

    class DeliveryService extends Service {
        String courier;

        public DeliveryService(String c, float p) {
            super(p);
            courier = c;
        }

        public String getCourier() {
            return courier;
        }
    }
}
//-------------------------------------------------------

interface CheeseInterface {

    class Cheese extends Product {
        public Cheese(float p) {
            price = p;
        }

        public float price() {
            return price;
        }
    }

    class Cheddar extends Cheese {
        public Cheddar(float p) {
            super(p);
        }
    }

    class Mozzarella extends Cheese {
        public Mozzarella(float p) {
            super(p);
        }
    }
}

interface FruitInterface {

    class Fruit extends Product {
        public Fruit(float p) {
            price = p;
        }

        public float price() {
            return price;
        }
    }

    class Apple extends Fruit {
        public Apple(float p) {
            super(p);
        }
    }

    class Orange extends Fruit {
        public Orange(float p) {
            super(p);
        }
    }
}

public class Products {

    public static void main(String[] args) {

        FruitInterface.Fruit apple = new FruitInterface.Apple(1.25F);
        FruitInterface.Fruit orange = new FruitInterface.Orange(1.50F);
        CheeseInterface.Cheese cheddar = new CheeseInterface.Cheddar(2.67F);
        CheeseInterface.Cheese mozzarella = new CheeseInterface.Mozzarella(3.45F);
        PeripheralInterface.Peripheral monitorBenq = new PeripheralInterface.Monitor("BENQ 1920", 149.99F);
        ServiceInterface.Service assemblePC = new ServiceInterface.AssemblyService("Assemble4u", 50.00F);
        ServiceInterface.Service deliver = new ServiceInterface.DeliveryService("Deliver2u", 20.00F);
        ComputerPartInterface.ComputerPart motherboardAsus = new ComputerPartInterface.Motherboard("Asus", 37.50F);
        ComputerPartInterface.ComputerPart ramKing = new ComputerPartInterface.RAM("Kingston", 512, 25.00F);

//-------------------------------------------------------

        GenericOrder<Product> orderList1 = new GenericOrder<>(174574);

        orderList1.addToOrder(apple);
        orderList1.addToOrder(orange);
        orderList1.addToOrder(orange);
        orderList1.addToOrder(cheddar);
        orderList1.addToOrder(mozzarella);
        orderList1.addToOrder(mozzarella);
        orderList1.addToOrder(monitorBenq);

//-------------------------------------------------------

        ComputerOrder<Product> computerOrder1 = new ComputerOrder<>(123456);

        computerOrder1.addToOrder(motherboardAsus);
        /*computerOrder1.addToOrder(monitorBenq);
        computerOrder1.addToOrder(assemblePC);*/

//-------------------------------------------------------

        ComputerOrder<Product> computerOrder2 = new ComputerOrder<>(987654);

        computerOrder2.addToOrder(motherboardAsus);
        computerOrder2.addToOrder(ramKing);


//-------------------------------------------------------

        PartyTrayOrder<Product> partyTrayOrder1 = new PartyTrayOrder<>(994557);

        partyTrayOrder1.addToOrder(mozzarella);
        partyTrayOrder1.addToOrder(orange);
        partyTrayOrder1.addToOrder(deliver);

        OrderProcessor processor = new OrderProcessor(orderList1);
        processor.accept(orderList1.getOrderList());
        //processor.accept(computerOrder1); <-- did nothing
        processor.process();
    }
}