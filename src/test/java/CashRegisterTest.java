import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class CashRegisterTest {

    private CashRegister cashRegister = new CashRegister();
    private double priceValue = 1.20;
    private int quantityValue = 1;
    PriceQuery priceQuery = new PriceQuery(
            ItemReference.aReference().withItemCode("APPLE").withUnitPrice(1.20).build(),
            ItemReference.aReference().withItemCode("BANANA").withUnitPrice(1.90).build());

    @Test
    public void with_a_price_and_a_quantity_should_return_the_product_of_both() {
        Result price = Result.found(Price.valueOf(priceValue));
        Quantity quantity = Quantity.valueOf(quantityValue);
        Result total = cashRegister.total(price, quantity);
        assertThat(total).isEqualTo(Result.found(Price.valueOf(priceValue)));
    }

    @Test
    @Parameters({"APPLE, 2, 1.20",
            "BANANA, 1, 1.90"})
    public void total_is_product_of_quantity_by_item_price_corresponding_to_existing_item_code(String itemCode, double quantity, double unitPrice) {
        Result total = cashRegister.total(priceQuery.findPrice(itemCode), Quantity.valueOf(quantity));
        assertThat(total).isEqualTo(Result.found(Price.valueOf(quantity * unitPrice)));
    }
}
