package modern.challenge;

public class Main {

    public static void main(String[] args) {

        int x1 = 2, y1 = 3, z1 = 1;
        int x2 = 5, y2 = 0, z2 = 1;

        MyPointOld old1 = new MyPointOld(x1, y1, z1);
        MyPointOld old2 = new MyPointOld(x2, y2, z2);
        MyPointOld old3 = new MyPointOld(x1, y1, z1);
        
        MyPointNew new1 = new MyPointNew(x1, y1, z1);
        MyPointNew new2 = new MyPointNew(x2, y2, z2);
        MyPointNew new3 = new MyPointNew(x1, y1, z1);
        
        System.out.println("old1 equals old2: " + old1.equals(old2));
        System.out.println("old1 equals old3: " + old1.equals(old3));
        System.out.println("old2 equals old3: " + old2.equals(old3));
        
        System.out.println();
        
        System.out.println("new1 equals new2: " + new1.equals(new2));
        System.out.println("new1 equals new3: " + new1.equals(new3));
        System.out.println("new2 equals new3: " + new2.equals(new3));
    }
}