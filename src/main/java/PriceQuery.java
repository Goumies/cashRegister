import java.util.Arrays;
import java.util.function.BiFunction;

class PriceQuery {
    private final ItemReference[] itemReferences;

    PriceQuery(ItemReference... itemReferences) {
        this.itemReferences = itemReferences;
    }

    Result findPrice(String soughtItemCode) {
        return reduce(Result.notFound(soughtItemCode),
                (result, itemReference) -> {
                    if (itemReference.matchesSoughtItemCode(soughtItemCode)) {
                        return Result.found(itemReference.getUnitPrice());
                    } else {
                        return result;
                    }
                },
                Arrays.asList(itemReferences));
    }

    private <R, T> R reduce(R identity,
                            BiFunction<R, T, R> reducer,
                            Iterable<T> values) {
        R accumulator = identity;
        for (T value :
                values) {
            accumulator = reducer.apply(accumulator, value);
        }
        return accumulator;
    }
}
