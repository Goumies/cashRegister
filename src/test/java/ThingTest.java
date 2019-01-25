import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ThingTest {
    @Test
    public void with_a_price_and_a_quantity_should_return_the_product_of_both() {
        CashRegister cashRegister = new CashRegister();
        final double value = 1.20;
        Price price = Price.valueOf(value);
        int quantity = 1;
        Price total = cashRegister.total(price, quantity);
        assertThat(total).isEqualTo(Price.valueOf(value));
    }
}
