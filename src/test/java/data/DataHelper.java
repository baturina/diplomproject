package data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

    private static String getCardNumber(String card) {
        switch (card.toLowerCase()) {
            case ("approved"):
                return "2222 2222 2222 2222";
            case ("declined"):
                return "4444 4444 4444 4444";
            default:
                return "4444 4444 4444 4444";
        }
    }

    @Value
    public static class RequiredFields {
        String cardNumber;
        String month;
        String year;
        String owner;
        String CVV;
    }

    public static RequiredFields getValidOwner() {
        return new RequiredFields(getCardNumber(
                "APPROVED"), "786", "245", "Ivan Ivanov", "121");
    }

    public static RequiredFields getInvalidOwnerWithNumber() {
        return new RequiredFields(getCardNumber(
                "APPROVED"), "12", "24", "007", "121");
    }

    public static RequiredFields getInvalidOwnerCyrillic() {
        return new RequiredFields(getCardNumber(
                "APPROVED"), "6", "24", "Иванов", "444");
    }

    public static RequiredFields getInValidOwnerWithSymbol() {
        return new RequiredFields(getCardNumber(
                "APPROVED"), "12", "24", "&*%*", "111");
    }

    public static RequiredFields getInValidMonth() {
        return new RequiredFields(getCardNumber(
                "APPROVED"), "15", "24", "Ivan Ivanov", "121");
    }

    public static RequiredFields getInValidLastYear() {
        return new RequiredFields(getCardNumber(
                "APPROVED"), "12", "10", "Ivan Ivanov", "121");
    }

    public static RequiredFields getInValidYear() {
        return new RequiredFields(getCardNumber(
                "APPROVED"), "12", "44", "Ivan Ibanov", "121");
    }

    public static RequiredFields getInvalidCVV() {
        return new RequiredFields(getCardNumber(
                "APPROVED"), "12", "26", "Ivan Ivanov", "abc");
    }

    public static RequiredFields getValidValueDeclinedCard() {
        return new RequiredFields(getCardNumber(
                "DECLINED"), "12", "26", "Ivan Ivanov", "121");
    }

    public static RequiredFields getInvalidOwnerWithDeclinedCard() {
        return new RequiredFields(getCardNumber(
                "DECLINED"), "12", "24", "??!!!!!", "121");
    }

    public static RequiredFields getInvalidCard() {
        return new RequiredFields(getCardNumber(
                "INVALID"), "12", "26", "Ivan Vanov", "121");
    }
}

