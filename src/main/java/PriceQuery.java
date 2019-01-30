import java.util.stream.Stream;

class PriceQuery {
    private final ItemReference[] itemReferences;

    PriceQuery(ItemReference... itemReferences) {
        this.itemReferences = itemReferences;
    }

    Result findPrice(String soughtItemCode) {
        return Stream.of(itemReferences)
                .filter(itemReference -> itemReference.matchesSoughtItemCode(soughtItemCode))
                .map(ItemReference::getUnitPrice)
                .map(Result::found)
                .findFirst()
                .orElseGet(() -> Result.notFound(soughtItemCode));
    }
}
