package aims;

import java.util.Arrays;
import java.util.Random;

public class Cart {
    public static final int MAX = 20;
    private DigitalVideoDisc[] items = new DigitalVideoDisc[MAX];
    private int qty = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc d) {
        if (d == null || qty >= MAX) return;
        items[qty++] = d;
    }
    public void addDigitalVideoDisc(DigitalVideoDisc d1, DigitalVideoDisc d2) { addDigitalVideoDisc(d1); addDigitalVideoDisc(d2); }
    public void addDigitalVideoDisc(DigitalVideoDisc... ds) { if (ds==null) return; for (DigitalVideoDisc d: ds) addDigitalVideoDisc(d); }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (disc==null) return;
        int i=0; while (i<qty && items[i].getId()!=disc.getId()) i++;
        if (i==qty) return;
        for (; i<qty-1; i++) items[i]=items[i+1];
        items[--qty]=null;
    }

    public float totalCost() { float s=0; for (int i=0;i<qty;i++) s+=items[i].getCost(); return s; }

    public void print() {
        System.out.println("CART ("+qty+")");
        for (int i=0;i<qty;i++) System.out.println((i+1)+". "+items[i]);
        System.out.printf("Total: %.2f%n", totalCost());
    }

    public DigitalVideoDisc searchByID(int id) {
        for (int i=0;i<qty;i++) if (items[i].getId()==id) return items[i];
        return null;
    }

    public DigitalVideoDisc[] searchByTitle(String title) {
        if (title==null || title.trim().isEmpty()) return new DigitalVideoDisc[0];
        DigitalVideoDisc[] tmp = new DigitalVideoDisc[qty];
        int f=0;
        for (int i=0;i<qty;i++) if (items[i].isMatch(title)) tmp[f++]=items[i];
        return Arrays.copyOf(tmp, f);
    }

    public void updateQuantity(DigitalVideoDisc disc, int newQty) {
        if (disc==null || newQty<0) return;
        int id=disc.getId(), cur=0;
        for (int i=0;i<qty;i++) if (items[i].getId()==id) cur++;
        if (newQty>cur) for (int k=0;k<newQty-cur && qty<MAX;k++) items[qty++]=disc;
        else if (newQty<cur) {
            int toRemove = cur-newQty;
            while (toRemove>0) {
                boolean removed=false;
                for (int i=0;i<qty;i++) if (items[i].getId()==id) { for (int j=i;j<qty-1;j++) items[j]=items[j+1]; items[--qty]=null; removed=true; toRemove--; break; }
                if (!removed) break;
            }
        }
    }

    public int getQty() { return qty; }
    public DigitalVideoDisc[] getItems() { return Arrays.copyOf(items, qty); }

    // handy small helper
    public float totalCostWithLuckyFree() {
        if (qty==0) return 0f;
        int lucky = new Random().nextInt(qty);
        float s=0; for (int i=0;i<qty;i++) if (i!=lucky) s+=items[i].getCost();
        System.out.println("Lucky free: "+items[lucky].getTitle());
        return s;
    }
}
