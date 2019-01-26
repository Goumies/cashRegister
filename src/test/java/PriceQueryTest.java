import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceQueryTest {
    @Test
    public void with_an_itemCode_should_return_its_unit_price() {
        String itemCode = "APPLE";
        final double unitPriceValue = 1.20;
        Price unitPrice = Price.valueOf(unitPriceValue);
        PriceQuery priceQuery = new PriceQuery(
                ItemReference.aReference().withItemCode(itemCode).withUnitPrice(unitPrice).build());
        assertThat(priceQuery.findPrice(itemCode)).isEqualTo(unitPrice);
    }
}
