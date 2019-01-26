import java.util.Objects;

class ItemReference {
    private final String itemCode;
    private final Price unitPrice;
    static Builder aReference() {return new Builder();}

    private ItemReference(String itemCode, Price unitPrice) {
        this.itemCode = itemCode;
        this.unitPrice = unitPrice;
    }

    public String getItemCode() {
        return itemCode;
    }

    Price getUnitPrice() {
        return unitPrice;
    }

    boolean matchesSoughtItemCode(String soughtItemCode) {
        return Objects.equals(itemCode, soughtItemCode);
    }

    static final class Builder {
        private String itemCode;
        private Price unitPrice;
        private Builder() {}
        Builder withItemCode(String itemCode) {
            this.itemCode = itemCode;
            return this;
        }
        Builder withUnitPrice(double unitPrice) {
            this.unitPrice = Price.valueOf(unitPrice);
            return this;
        }

        Builder withUnitPrice(Price unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        ItemReference build() {
            return new ItemReference(itemCode, unitPrice);
        }
    }
}
