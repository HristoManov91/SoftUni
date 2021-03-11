package Lab_03_Animals;

public  class Animal {
    private String name;
    private String favouriteFood;

    protected Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    protected String getName() {
        return name;
    }

    protected String getFavouriteFood() {
        return favouriteFood;
    }

    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s%n", getName() , getFavouriteFood());
    }
}
