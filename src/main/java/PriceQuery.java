class PriceQuery {
    private final ItemReference[] itemReferences;

    PriceQuery(ItemReference... itemReferences) {
        this.itemReferences = itemReferences;
    }

    Result findPrice(String soughtItemCode) {
        for (ItemReference itemReference:
             itemReferences) {
            if (itemReference.matchesSoughtItemCode(soughtItemCode)) {
                return Result.found(itemReference.getUnitPrice());
            }
        }
        return Result.notFound(soughtItemCode);
    }
}
