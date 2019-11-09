import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@Named("buyer") // or @ManagedBean(name="user")
@SessionScoped

public class BuyerBean implements Serializable{

    List<Item> buyers_cart;
    Map<Item, Integer> quantity ;
    String actual_quantity ="0";

    public BuyerBean() {
        //DataBaseBean dbInstance = (DataBaseBean) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("DataBaseBean");
        buyers_cart = new ArrayList<Item>(DataBaseBean.total_items);
        quantity = new HashMap<Item, Integer>(DataBaseBean.total_items_quantity);

    }

   public void actualize_quantity(Item a, String v){
       FacesContext facesContext=FacesContext.getCurrentInstance();
       try{
        Integer value = Integer.valueOf(v);
        if(value>quantity.get(a))
            facesContext.addMessage("numberFormatExMessage", new FacesMessage("Cantidad no valida"));
        else
            quantity.put(a, quantity.get(a) - value);

       }
       catch (NumberFormatException e){
           System.out.println(e);
           facesContext.addMessage("numberFormatExMessage", new FacesMessage("Ingrese solo numeros"));
       }

   }

    public void setActual_quantity(String actual_quantity) {
        this.actual_quantity = actual_quantity;
    }

    public String getActual_quantity() {
        return actual_quantity;
    }

    public String sortItemsbyPrice(final int dir) {

        Collections.sort(buyers_cart, new Comparator <Item>() {
            @Override
            public int compare(Item key_1, Item key_2) {
                return dir * (int)(key_1.getPrice() - key_2.getPrice());
            }
        });
        return null;
    }

    public String sortItemsByName(final String dir) {

        Collections.sort(buyers_cart, new Comparator<Item>() {
            @Override
            public int compare(Item key_1, Item key_2) {
                if (dir.equals("asc")) {
                    return key_1.getName().compareTo(key_2.getName());
                } else {
                    return key_2.getName().compareTo(key_1.getName());
                }
            }
        });
        return null;
    }
    
    public String sortItemsByCode(final String dir) {

        Collections.sort(buyers_cart, new Comparator<Item>() {
            @Override
            public int compare(Item key_1, Item key_2) {
                if (dir.equals("asc")) {
                    return key_1.getSerial_number().compareTo(key_2.getSerial_number());
                } else {
                    return key_2.getSerial_number().compareTo(key_1.getSerial_number());
                }
            }
        });
        return null;
    }

    public List<Item> getBuyers_cart() {
        return buyers_cart;
    }

    public void setBuyers_cart(List<Item> buyers_cart) {
        this.buyers_cart = buyers_cart;
    }


    public Map<Item, Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(Map<Item, Integer> quantity) {
        this.quantity = quantity;
    }


    public Double itemTotalPrice(Item i){
        Integer v=Integer.valueOf(actual_quantity);
        return v*i.getPrice();
    }
}
