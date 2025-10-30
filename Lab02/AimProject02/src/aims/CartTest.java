package aims; // Đảm bảo package này khớp với package của Cart.java và DigitalVideoDisc.java

public class CartTest {

    public static void main(String[] args) {
        
        // 1. Tạo giỏ hàng mới
        Cart cart = new Cart();

        // 2. Tạo các đối tượng DVD
        // (Giả sử bạn đã có constructor đầy đủ trong DigitalVideoDisc từ Phần 5)
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
                "Animation", "Roger Allers", 87, 19.95f);
        
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
                "Science Fiction", "George Lucas", 87, 24.95f);
        
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
                "Animation", "John Musker", 90, 18.99f);

        // --- KIỂM TRA PHẦN 2 (NẠP CHỒNG PHƯƠNG THỨC) ---
        System.out.println("--- BẮT ĐẦU KIỂM TRA NẠP CHỒNG ---");

        // A. Kiểm tra addDigitalVideoDisc(dvd1, dvd2)
        cart.addDigitalVideoDisc(dvd1, dvd2);
        
        // B. Kiểm tra addDigitalVideoDisc(DigitalVideoDisc... dvdList) (với varargs)
        cart.addDigitalVideoDisc(dvd3);
        
        System.out.println("--- KẾT THÚC KIỂM TRA NẠP CHỒNG ---");
        
        // --- KIỂM TRA PHẦN 6 (PRINT VÀ SEARCH) ---
        
        // A. Kiểm tra cart.print() [cite: 1504]
        // In giỏ hàng (sẽ có 3 đĩa DVD)
        System.out.println("\n--- KIỂM TRA PRINT ---");
        cart.print();
        
        // B. Kiểm tra searchByID()
        System.out.println("\n--- KIỂM TRA SEARCH BY ID ---");
        // Giả sử ID của dvd1 là 1, dvd2 là 2, dvd3 là 3 (do Phần 5)
        System.out.println("Tìm kiếm ID 1:");
        cart.searchByID(1);
        
        System.out.println("\nTìm kiếm ID 10 (Không tồn tại):");
        cart.searchByID(10);
        
        // C. Kiểm tra searchByTitle()
        System.out.println("\n--- KIỂM TRA SEARCH BY TITLE ---");
        System.out.println("Tìm kiếm 'Lion':");
        // (Code Cart.java chuẩn của bạn sẽ tìm 'contains')
        cart.searchByTitle("Lion"); 
        
        System.out.println("\nTìm kiếm 'Matrix' (Không tồn tại):");
        cart.searchByTitle("Matrix");
    }
}