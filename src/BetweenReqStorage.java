/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dfellig
 */
public class BetweenReqStorage {

    private List<Item> filteredDataList = new ArrayList<>();

    private static BetweenReqStorage singleton = new BetweenReqStorage();

    public static BetweenReqStorage getSingleton() {
        return singleton;
    }

    public List<Item> getFilteredDataList() {
        return filteredDataList;
    }

    public void setFilteredDataList(List<Item> filteredDataList) {
        this.filteredDataList.clear();
        this.filteredDataList.addAll(filteredDataList);
    }

    public void clearAll() {
        filteredDataList.clear();
    }

}
