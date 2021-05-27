package test;

import data.DataHelper;
import data.DBHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.DashboardPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

    public class CreditBuyTest {

        @BeforeEach
        void setUp() {
            open("http://localhost:8080");
        }

        @Test
        void submittingAnEmptyForm() {
            new
                    DashboardPage().openCreditPage().submittingAnEmptyForm();
        }


        //успешная оплата
        @Test
        void successfulPayment() {
            new DashboardPage().openCreditPage()
                    .successfulPayment(DataHelper.getValidOwner());
            assertEquals("APPROVED", DBHelper.getCreditStatus());
        }

        //успешная оплата
        @Test
        void successfulPaymentCreditId() {
            new DashboardPage().openCreditPage()
                    .successfulPayment(DataHelper.getValidOwner());
            assertNotNull(DBHelper.getCreditId());
        }


        //оплата с отклоненной карты
        @Test
        void DeclinedCardPaymentErrorOrderId() {
            new DashboardPage().openCreditPage()
                    .DeclinedCardPaymentError(DataHelper.getValidValueDeclinedCard());
            assertNull(DBHelper.getOrderId());
        }

        //оплата с отклоненной карты
        @Test
        void DeclinedCardPaymentErrorCreditID() {
            new DashboardPage().openCreditPage()
                    .DeclinedCardPaymentError(DataHelper.getValidValueDeclinedCard());
            assertNotNull(DBHelper.getCreditId());
        }

        //оплата с отклоненной карты , невалидным именем владельца
        @Test
        void DeclinedCardPaymentErrorWithInvalidOwnerPaymentID() {
            new DashboardPage().openCreditPage()
                    .DeclinedCardPaymentError(DataHelper.getInvalidOwnerWithDeclinedCard());
            assertNotNull(DBHelper.getCreditId());
        }


         //оплата используя невалидное имя владельца с цифрами
        @Test
        void PaymentWithInvalidOwnerWithNumber() {
            new DashboardPage().openCreditPage()
                    .PaymentWithInvalidOwnerWithNumber(DataHelper.getInvalidOwnerWithNumber());
            assertNull(DBHelper.getOrderCreditId());
        }

        //оплата используя невалидное имя владельца соспецсимволами
        @Test
        void PaymentWithInvalidOwnerWithSymbol() {
            new DashboardPage().openCreditPage()
                    .PaymentWithSpecChar(DataHelper.getInValidOwnerWithSymbol());
            assertNull(DBHelper.getOrderCreditId());
        }

        //оплата используя невалидное имя владельца c кириллицей
        @Test
        void PaymentWithInvalidOwnerWithCyrillic() {
            new DashboardPage().openCreditPage()
                    .PaymentWithCyrillic(DataHelper.getInvalidOwnerCyrillic());
            assertNull(DBHelper.getOrderCreditId());
        }

        //оплата используя невалидное значение месяца работы карты
        @Test
        void PaymentWithInValidMonth() {
            new DashboardPage().openCreditPage()
                    .PaymentWithInValidMonth(DataHelper.getInValidMonth());
            assertNull(DBHelper.getOrderCreditId());
        }

        //оплата с невалиднымгодом карты
        @Test
        void PaymentWithInValidLastYear() {
            new DashboardPage().openCreditPage()
                    .PaymentWithInValidLastYear(DataHelper.getInValidLastYear());
            assertNull(DBHelper.getOrderCreditId());
        }

        //оплата с невалидным годом карты

        @Test
        void PaymentWithInvalidFutureYear() {
            new DashboardPage().openCreditPage()
                    .PaymentWithInValidFutureYear(DataHelper.getInValidFutureYear());
        }

        //оплата с невалидным СVV кодом
        @Test
        void PaymentWithInvalidCvc() {
            new DashboardPage().openCreditPage()
                    .PaymentWithInvalidCvc(DataHelper.getInvalidCVV());
            assertNull(DBHelper.getOrderCreditId());

        }

        //оплата с невалидной картой
        @Test
        void PaymentWithInvalidCard() {
            new DashboardPage().openCreditPage()
                    .PaymentWithInvalidCard(DataHelper.getInvalidCard());
            assertNull(DBHelper.getOrderCreditId());
        }

    }

