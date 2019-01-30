import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

class PriceQuery {
    private final Map<String, Price> unitPriceByItemCode;

    PriceQuery(ItemReference... itemReferences) {
        this.unitPriceByItemCode = Stream.of(itemReferences)
                .collect(toMap(
                        ItemReference::getItemCode,
                        ItemReference::getUnitPrice
                ));
    }

    Result findPrice(String soughtItemCode) {
        Price price = unitPriceByItemCode.get(soughtItemCode);
        return price != null
                ? Result.found(price)
                : Result.notFound(soughtItemCode);
    }
}
