import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CashRegisterTest {

    private CashRegister cashRegister = new CashRegister();
    private double priceValue = 1.20;
    private int quantityValue = 1;

    @Test
    public void with_a_price_and_a_quantity_should_return_the_product_of_both() {
        Price price = Price.valueOf(priceValue);
        Quantity quantity = Quantity.valueOf(quantityValue);
        Price total = cashRegister.total(price, quantity);
        assertThat(total).isEqualTo(Price.valueOf(priceValue));
    }
}
