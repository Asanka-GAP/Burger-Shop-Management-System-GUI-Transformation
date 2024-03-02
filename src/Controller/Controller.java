/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DB.List;
import View.Home;
import View.PlaceOrder;
import View.Search;
import View.UpdateOrder;
import View.ViewOrder;

/**
 *
 * @author asanka
 */
public class Controller {
    public static List list = new List();
	public static ViewOrder viewOrder = new ViewOrder();
	public static Search search = new Search();
	public static UpdateOrder updateOrder = new UpdateOrder();
	public static PlaceOrder placeOrder = new PlaceOrder();
	public static Home home = new Home();
        
}
