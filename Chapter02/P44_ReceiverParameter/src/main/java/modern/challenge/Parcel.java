package modern.challenge;

public class Parcel {
    
    public void order(@New Parcel this) {}
    
    public void shipping(@Ordered Parcel this) {}
    
    public void deliver(@Shipped Parcel this) {}
    
    public void cashit(@Delivered Parcel this) {}
    
    public void done(@Cashed Parcel this) {}
}
