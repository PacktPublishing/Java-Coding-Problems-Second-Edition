package modern.challenge;

public class Main {

    public static void main(String[] args) {

        int x1 = 2, y1 = 3, z1 = 1;
        int x2 = 5, y2 = 0, z2 = 1;
        
        Integer xg1 = Integer.valueOf(2), yg1 = Integer.valueOf(3), zg1 = Integer.valueOf(1);
        Integer xg2 = Integer.valueOf(5), yg2 = Integer.valueOf(0), zg2 = Integer.valueOf(1);

        MyPointOld old1 = new MyPointOld(x1, y1, z1);
        MyPointOld old2 = new MyPointOld(x2, y2, z2);
        MyPointOld old3 = new MyPointOld(x1, y1, z1);
        
        MyPointNew new1 = new MyPointNew(x1, y1, z1);
        MyPointNew new2 = new MyPointNew(x2, y2, z2);
        MyPointNew new3 = new MyPointNew(x1, y1, z1);
        
        MyPointGenericOld oldg1 = new MyPointGenericOld<>(xg1, yg1, zg1);
        MyPointGenericOld oldg2 = new MyPointGenericOld<>(xg2, yg2, zg2);
        MyPointGenericOld oldg3 = new MyPointGenericOld<>(xg1, yg1, zg1);
        
        MyPointGenericNew newg1 = new MyPointGenericNew<>(xg1, yg1, zg1);
        MyPointGenericNew newg2 = new MyPointGenericNew<>(xg2, yg2, zg2);
        MyPointGenericNew newg3 = new MyPointGenericNew<>(xg1, yg1, zg1);
        
        System.out.println("old1 equals old2: " + old1.equals(old2));
        System.out.println("old1 equals old3: " + old1.equals(old3));
        System.out.println("old2 equals old3: " + old2.equals(old3));
        
        System.out.println();
        
        System.out.println("new1 equals new2: " + new1.equals(new2));
        System.out.println("new1 equals new3: " + new1.equals(new3));
        System.out.println("new2 equals new3: " + new2.equals(new3));
        
        System.out.println();
        
        System.out.println("oldg1 equals oldg2: " + oldg1.equals(oldg2));
        System.out.println("oldg1 equals oldg3: " + oldg1.equals(oldg3));
        System.out.println("oldg2 equals oldg3: " + oldg2.equals(oldg3));
        
        System.out.println();
        
        System.out.println("newg1 equals newg2: " + newg1.equals(newg2));
        System.out.println("newg1 equals newg3: " + newg1.equals(newg3));
        System.out.println("newg2 equals newg3: " + newg2.equals(newg3));
    }
}