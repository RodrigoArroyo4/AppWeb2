import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named("dataBase")
@ApplicationScoped

public class DataBaseBean implements Serializable {
    static List<Item> total_items = new ArrayList<Item>();
    static Map<Item, Integer> total_items_quantity = new HashMap<Item, Integer>();
    ArrayList<Integer> stock = new ArrayList<Integer>();

    //Pagination
    private HtmlDataTable table;
    private int rowsOnPage;
    private String criteria = "all";
    private BetweenReqStorage betweenReqStorage;

    public DataBaseBean() {
        //Pagination
        betweenReqStorage = BetweenReqStorage.getSingleton();
        rowsOnPage = 5;

        total_items.add(new Item("brown shirts", 34.43,"00000100"));
        total_items.add(new Item("green shorts", 32.41,"10000011"));
        total_items.add(new Item("shaving cream", 14.23,"02234344"));
        total_items.add(new Item("green beer", 4.43,"12341233"));
        total_items.add(new Item("black shoes", 67.41, "12100222"));
        total_items.add(new Item("coffee", 10.23,"12231222"));
        total_items.add(new Item("black combs", 1.43, "10001222"));
        total_items.add(new Item("printer red ink", 43.43, "14311222"));
        total_items.add(new Item("scissors", 24.55, "02111222"));
        total_items.add(new Item("red tape", 4.03, "13111222"));
        total_items.add(new Item("black pens", 3.43, "14111222"));
        total_items.add(new Item("red pens", 1.43, "15111222"));
        total_items.add(new Item("pencils", 0.43, "16111222"));
        total_items.add(new Item("hard drives", 50.54, "17111222"));
        total_items.add(new Item("sofas", 400.43, "18111222"));
        total_items.add(new Item("chairs", 31.43, "19111222"));
        total_items.add(new Item("mp3 players", 20.43, "12001222"));
        total_items.add(new Item("white shoes", 44.53, "12111222"));
        total_items.add(new Item("pen drives", 19.43, "12121222"));
        total_items.add(new Item("tooth paste", 4.43, "12131222"));
        total_items.add(new Item("dental floss", 4.53, "12141222"));
        total_items.add(new Item("hair brushes", 36.43, "12151222"));
        total_items.add(new Item("alarm clocks", 9.43, "12161222"));
        total_items.add(new Item("watches", 87.43, "12171222"));
        total_items.add(new Item("tires", 78.98, "12181222"));
        total_items.add(new Item("car oil", 34.34, "12191222"));
        total_items.add(new Item("cooking oil", 19.88, "12111223"));
        total_items.add(new Item("note books", 6.25, "12111224"));
        total_items.add(new Item("vitamin A", 18.99, "12111225"));
        total_items.add(new Item("vitamin C", 21.87, "12111222"));
        total_items.add(new Item("vitamin B", 17.83, "12119222"));
        total_items.add(new Item("vitamin D", 12.32, "12911222"));
        total_items.add(new Item("zinc", 20.56, "12118222"));
        total_items.add(new Item("coke", 1.23, "12711222"));
        total_items.add(new Item("pepsi", 1.23, "12111292"));
        total_items.add(new Item("scotch", 60.43, "12511222"));
        total_items.add(new Item("bourbon", 40.44, "12311222"));
        total_items.add(new Item("rum", 32.43, "12191222"));
        total_items.add(new Item("dark beer", 10.43, "12181222"));
        total_items.add(new Item("light beer", 7.43, "12171222"));
        total_items.add(new Item("hats", 21.44, "12161222"));
        total_items.add(new Item("capes", 34.78, "12151222"));
        total_items.add(new Item("umbrellas", 4.21, "12131222"));
        stock.add(300);
        stock.add(231);
        stock.add(443);
        stock.add(29);
        stock.add(94);
        stock.add(99);
        stock.add(23);
        stock.add(745);
        stock.add(12);
        stock.add(45);
        stock.add(32);
        stock.add(134);
        stock.add(231);
        stock.add(222);
        stock.add(3);
        stock.add(32);
        stock.add(67);
        stock.add(62);
        stock.add(33);
        stock.add(54);
        stock.add(12);
        stock.add(44);
        stock.add(56);
        stock.add(11);
        stock.add(78);
        stock.add(21);
        stock.add(225);
        stock.add(21);
        stock.add(4);
        stock.add(55);
        stock.add(3);
        stock.add(12);
        stock.add(56);
        stock.add(11);
        stock.add(76);
        stock.add(33);
        stock.add(10);
        stock.add(30);
        stock.add(67);
        stock.add(22);
        stock.add(12);
        stock.add(78);
        stock.add(22);
        add_start_quantity();
    }


    public void add_start_quantity(){
        for (Item i:total_items) {
            total_items_quantity.put(i,stock.get(total_items.indexOf(i)));
        }
    }
    public List<Item> getTotal_items() {
        return total_items;
    }

    public void setTotal_items(List<Item> total_items) {
        this.total_items = total_items;
    }

    public Map<Item, Integer> getTotal_items_quantity() {
        return total_items_quantity;
    }

    public void setTotal_items_quantity(Map<Item, Integer> total_items_quantity) {
        this.total_items_quantity = total_items_quantity;
    }

    //Pagination Methods
    private void getDataBetweenReq() {

        if (betweenReqStorage.getFilteredDataList().size() > 0 && !criteria.equals("all")) {
            total_items.clear();
            total_items.addAll(betweenReqStorage.getFilteredDataList());
        }
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public List<Item> getDataList() {
        return total_items;
    }

    public void setDataList(List<Item> total_items) {
        this.total_items = total_items;
    }

    public HtmlDataTable getTable() {
        return table;
    }

    public void setTable(HtmlDataTable table) {
        this.table = table;
    }

    public int getRowsOnPage() {
        return rowsOnPage;
    }

    public void setRowsOnPage(int rowsOnPage) {
        this.rowsOnPage = rowsOnPage;
    }

    public void goToFirstPage() {
        getDataBetweenReq();
        table.setFirst(0);
    }

    public void goToPreviousPage() {
        getDataBetweenReq();
        table.setFirst(table.getFirst() - table.getRows());
    }

    public void goToNextPage() {
        getDataBetweenReq();
        table.setFirst(table.getFirst() + table.getRows());

    }

    public void goToLastPage() {
        getDataBetweenReq();
        int totalRows = table.getRowCount();
        int displayRows = table.getRows();
        int full = totalRows / displayRows;
        int modulo = totalRows % displayRows;

        if (modulo > 0) {
            table.setFirst(full * displayRows);
        } else {
            table.setFirst((full - 1) * displayRows);
        }
    }
}

