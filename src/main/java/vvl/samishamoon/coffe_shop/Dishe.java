package vvl.samishamoon.coffe_shop;

public class Dishe {
    private String name;
    private String type;
    private String adds;
    private double priceIn;
    private double priceOut;
    public int dishId;

    public Dishe(String name, String type, double priceIn, double priceOut, int dishId, String adds){
        this.name = name;
        this.type = type;
        this.priceIn = priceIn;
        this.priceOut = priceOut;
        this.dishId = dishId;
        this.adds = adds;
    }

    public Dishe(String name, String type, double priceIn, double priceOut, int dishId){
        this(name, type, priceIn, priceOut, dishId, "NoAdds");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdds() {
        return adds;
    }

    public void setAdds(String adds) {
        this.adds = adds;
    }

    public double getPriceIn() {
        return priceIn;
    }

    public void setPriceIn(double priceIn) {
        this.priceIn = priceIn;
    }

    public double getPriceOut() {
        return priceOut;
    }

    public void setPriceOut(double priceOut) {
        this.priceOut = priceOut;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    @Override
    public String toString() {
        return String.format("Dishe{%d, %s, %s, %s, inside: %f, outside: %f}", this.getDishId(), this.getName(), this.getAdds(), this.getType(), this.getPriceIn(), this.getPriceOut());
    }
}
