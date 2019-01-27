import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class PriceQueryTest {
    private PriceQuery priceQuery = new PriceQuery(
            ItemReference.aReference().withItemCode("APPLE").withUnitPrice(1.20).build(),
            ItemReference.aReference().withItemCode("BANANA").withUnitPrice(1.90).build());

    @Test
    @Parameters({"APPLE, 1.20",
            "BANANA, 1.90"})
    public void with_an_itemCode_should_return_its_unit_price(String itemCode, double unitPrice) {
        assertThat(priceQuery.findPrice(itemCode)).isEqualTo(Result.found(Price.valueOf(unitPrice)));
    }

    @Test
    public void search_for_unknown_item() {
        assertThat(priceQuery.findPrice("PEACH")).isEqualTo(Result.notFound("PEACH"));
    }
}
