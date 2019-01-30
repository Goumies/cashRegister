import java.util.Objects;

 class Price {
    private final double value;

    Price(double value) {
        this.value = value;
    }

    static Price valueOf(double value) {
        return new Price(value);
    }

     Price multiplyBy(Quantity quantity) {
        return valueOf(quantity.MultiplyBy(value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Double.compare(price.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

     @Override
     public String toString() {
         return "Price{" +
                 "value=" + value +
                 '}';
     }
 }
