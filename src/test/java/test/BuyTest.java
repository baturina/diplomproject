package test;

import data.DBHelper;
import data.DataHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.DashboardPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BuyTest {


        @BeforeEach
        void setUp() {
            open("http://localhost:8080");
        }

        @Test
        void submittingAnEmptyForm() {
            new DashboardPage().openDebitPage().submittingAnEmptyForm();
        }


        //успешная оплата
        @Test
        void successfulPayment() {
            new DashboardPage().openDebitPage()
                    .successfulPayment(DataHelper.getValidOwner());
            assertEquals("APPROVED", DBHelper.getPaymentStatus());
        }

        //проверка успешной оплаты
        @Test
        void shouldInsertPaymentAmount() {
            int expectedAmount = 45_000_00;
            new DashboardPage().openDebitPage()
                    .successfulPayment(DataHelper.getValidOwner());
            assertEquals(expectedAmount, DBHelper.getPaymentAmount());
        }

        //Declined Payment
        //проверка оплаты c отклноненной картой
        @Test
        void DeclinedCardPaymentError() {
            new DashboardPage().openDebitPage()
                    .DeclinedCardPaymentError(DataHelper.getValidValueDeclinedCard());
            assertNull(DBHelper.getOrderCreditId());

        }

        //проверка оплаты c отклноненной картой
        @Test
        void DeclinedCardPaymentErrorPaymentID() {
            new DashboardPage().openDebitPage()
                    .DeclinedCardPaymentError(DataHelper.getValidValueDeclinedCard());
            assertNotNull(DBHelper.getPaymentId());
        }

        //проверка оплаты c отклноненной картой и с не правильным именем владельца
        @Test
        void DeclinedCardPaymentErrorWithInvalidOwnerPaymentID() {
            new DashboardPage().openDebitPage()
                    .DeclinedCardPaymentError(DataHelper.getInvalidOwnerWithDeclinedCard());
            assertNotNull(DBHelper.getPaymentId());
        }

        //Negative Test
//Проверка оплаты используя невалидное имя владельца с цифрами
        @Test
        void PaymentWithInvalidOwnerWithNumber() {
            new DashboardPage().openDebitPage()
                    .PaymentWithInvalidOwnerWithNumber(DataHelper.getInvalidOwnerWithNumber());
            assertNull(DBHelper.getOrderCreditId());
        }

        //Проверка оплаты используя невалидное имя владельца соспецсимволами
        @Test
        void PaymentWithInvalidOwnerWithSymbol() {
            new DashboardPage().openDebitPage()
                    .PaymentWithSpecSymbol(DataHelper.getInValidOwnerWithSymbol());
            assertNull(DBHelper.getOrderCreditId());
        }

        //Проверка оплаты используя невалидное имя владельца c кириллицей
        @Test
        void PaymentWithInvalidOwnerWithCyrillic() {
            new DashboardPage().openDebitPage()
                    .PaymentWithCyrillic(DataHelper.getInvalidOwnerCyrillic());
            assertNull(DBHelper.getOrderCreditId());
        }

        //Проверка оплаты используя невалидное значение месяца работы карты
        @Test
        void PaymentWithInValidMonth() {
            new DashboardPage().openDebitPage()
                    .PaymentWithInValidMonth(DataHelper.getInValidMonth());
            assertNull(DBHelper.getOrderCreditId());
        }

        //Проверка оплаты используя невалидное значение года работы карты дальнего будущего
        @Test
        void PaymentWithInValidLastYear() {
            new DashboardPage().openDebitPage()
                    .PaymentWithInValidLastYear(DataHelper.getInValidLastYear());
            assertNull(DBHelper.getOrderCreditId());
        }

        //Проверка оплаты используя невалидное значение года срока действия карты
        @Test
        void PaymentWithInValidFutureYear() {
            new DashboardPage().openDebitPage()
                    .PaymentWithInValidFutureYear(DataHelper.getInValidFutureYear());
            assertNull(DBHelper.getOrderCreditId());
        }

        // Невалидный CVV
        @Test
        void PaymentWithInvalidCvc() {
            new DashboardPage().openDebitPage()
                    .PaymentWithInvalidCvc(DataHelper.getInvalidCVV());
            assertNull(DBHelper.getOrderCreditId());

        }

        //Проверка оплаты с невалидной картой
        @Test
        void PaymentWithInvalidCard() {
            new DashboardPage().openDebitPage()
                    .PaymentWithInvalidCard(DataHelper.getInvalidCard());
            assertNull(DBHelper.getOrderCreditId());
        }
    }


