package aims; 

public class Store {
    
    
    public static final int MAX_ITEMS_IN_STORE = 1000;
    
   
    private DigitalVideoDisc itemsInStore[];
    
    
    private int qtyItems; 

   
    public Store() {
        itemsInStore = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
        qtyItems = 0;
    }

    
    public void addDVD(DigitalVideoDisc disc) {
        if (qtyItems >= MAX_ITEMS_IN_STORE) {
            System.out.println("Cua hang da day. Khong the them DVD.");
            return;
        }
        
        itemsInStore[qtyItems] = disc;
        qtyItems++;
        System.out.println("Da them DVD '" + disc.getTitle() + "' vao cua hang.");
    }

    
    public void removeDVD(DigitalVideoDisc disc) {
        if (disc == null) {
            System.out.println("DVD khong hop le.");
            return;
        }

        int idx = -1;
       
        for (int i = 0; i < qtyItems; i++) {
            if (itemsInStore[i].getId() == disc.getId()) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            System.out.println("Khong tim thay DVD '" + disc.getTitle() + "' trong cua hang.");
            return;
        }

        
        for (int i = idx; i < qtyItems - 1; i++) {
            itemsInStore[i] = itemsInStore[i + 1];
        }
        
        itemsInStore[qtyItems - 1] = null; 
        qtyItems--; 
        
        System.out.println("Da xoa DVD '" + disc.getTitle() + "' khoi cua hang.");
    }
    
    
    public void printStore() {
        System.out.println("**********CUA HANG**********");
        if (qtyItems == 0) {
            System.out.println("Cua hang trong.");
            System.out.println("******************************");
            return;
        }
        
        for (int i = 0; i < qtyItems; i++) {
            System.out.println( (i+1) + ". " + itemsInStore[i].toString() );
        }
        System.out.println("******************************");
    }
}