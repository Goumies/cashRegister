class CashRegister {

    Price total(Price price, int quantity) {
        return price.MultiplyBy(quantity);
    }
}
