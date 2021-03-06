package shopping.product;

/**
 * @author colsen91
 */
public class SingleProduct extends Product {

    private float price;
    private int kcal;

    public SingleProduct() {
        super();
        this.price = -1.0f;
        this.kcal = -1;
    }

    public SingleProduct(int id, String name, String description, float price, int kcal) {
        super(id, name, description);
        this.price = price;
        this.kcal = kcal;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    @Override
    public String toString() {
        return "SingleProduct{" + "price=" + price + ", kcal=" + kcal + ", " + super.toString() + '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}