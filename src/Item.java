public class Item {
    Double price;
    String serial_number;
    String name;

    public Item(String name, Double price, String serial_number) {
        this.name=name;
        this.serial_number=serial_number;
        this.price=price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
