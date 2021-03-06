import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

abstract class Result {
    static Result found(Price price) {
        return new Found(price);
    }

    static Result notFound(String invalidItemCode) {
        return new NotFound(invalidItemCode);
    }

    abstract Result map(UnaryOperator<Price> mapper);

    abstract void ifFound(Consumer<Price> consumer);

    abstract void ifNotFound(Consumer<String> consumer);

    private static class Found extends Result {
        private final Price price;

        private Found(Price price) {
            super();
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Found found = (Found) o;
            return Objects.equals(price, found.price);
        }

        @Override
        public int hashCode() {
            return Objects.hash(price);
        }

        @Override
        Result map(UnaryOperator<Price> mapper) {
            return found(mapper.apply(price));
        }

        @Override
        void ifFound(Consumer<Price> consumer) {
            consumer.accept(price);
        }

        @Override
        void ifNotFound(Consumer<String> consumer) {
        }
    }

    private static class NotFound extends Result {
        private final String invalidItemCode;

        private NotFound(String invalidItemCode) {
            super();
            this.invalidItemCode = invalidItemCode;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NotFound notFound = (NotFound) o;
            return Objects.equals(invalidItemCode, notFound.invalidItemCode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(invalidItemCode);
        }

        @Override
        Result map(UnaryOperator<Price> mapper) {
            return this;
        }

        @Override
        void ifFound(Consumer<Price> consumer) {
        }

        @Override
        void ifNotFound(Consumer<String> consumer) {
            consumer.accept(invalidItemCode);
        }
    }
}
