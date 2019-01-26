class PriceQuery {
    private final ItemReference[] itemReferences;

    PriceQuery(ItemReference... itemReferences) {
        this.itemReferences = itemReferences;
    }

    Price findPrice(String soughtItemCode) {
        for (ItemReference itemReference:
             itemReferences) {
            if (itemReference.matchesSoughtItemCode(soughtItemCode)) {
                return itemReference.getUnitPrice();
            }
        };
        return Price.valueOf(0);
    }
}
