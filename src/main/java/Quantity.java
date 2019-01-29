import java.util.Objects;

class Quantity {
    private final double value;

    private Quantity(double value) {
        this.value = value;
    }

    static Quantity valueOf(double value) {
        return new Quantity(value);
    }

    public double MultiplyBy(double other) {
        return value * other;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity = (Quantity) o;
        return value == quantity.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
