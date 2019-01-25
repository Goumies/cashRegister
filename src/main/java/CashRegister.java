class CashRegister {

    Price total(Price price, Quantity quantity) {
        return price.MultiplyBy(quantity);
    }
}
