import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceQueryTest {
    private String itemCode = "APPLE";
    private final double unitPriceValue = 1.20;
    private Price unitPrice = Price.valueOf(unitPriceValue);

    private PriceQuery priceQuery = new PriceQuery(
            ItemReference.aReference().withItemCode(itemCode).withUnitPrice(unitPrice).build());

    @Test
    public void with_an_itemCode_should_return_its_unit_price() {
        assertThat(priceQuery.findPrice(itemCode)).isEqualTo(unitPrice);
    }

    @Test
    public void search_for_unknown_item() {
        assertThat(priceQuery.findPrice("PEACH")).isEqualTo(Price.valueOf(0));
    }
}
