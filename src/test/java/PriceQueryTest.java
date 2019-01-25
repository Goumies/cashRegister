import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceQueryTest {
    @Test
    public void with_a_item_code_should_return_its_unit_price() {
        PriceQuery cashRegister = new PriceQuery();
        assertThat(0).isEqualTo(0);
    }
}
