import static org.junit.jupiter.api.Assertions.*;

class NextDayCalculatorTest {

    @org.junit.jupiter.api.Test
    void testFindNextDay1() {
        int day = 1;
        int month = 1;
        int year = 2018;
        int expectedDay = 2;

        int result = NextDayCalculator.findNextDay(day, month, year);
        assertEquals(expectedDay, result);
        System.out.println("Result day: " + day + " to " + result);
    }

    @org.junit.jupiter.api.Test
    void testFindNextDay2() {
        int day = 31;
        int month = 1;
        int year = 2018;
        int expectedDay = 1;
        int expectedMonth = 2;

        int resultDay = NextDayCalculator.findNextDay(day, month, year);
        int resultMonth = NextDayCalculator.findNextMonth(day, month, year);
        assertEquals(expectedDay, resultDay);
        assertEquals(expectedMonth, resultMonth);
        System.out.println("Result day: " + day + " to " + resultDay);
        System.out.println("Result month: " + month + " to " + resultMonth);
    }

    @org.junit.jupiter.api.Test
    void testFindNextDay3() {
        int day = 30;
        int month = 4;
        int year = 2018;
        int expectedDay = 1;
        int expectedMonth = 5;

        int result = NextDayCalculator.findNextDay(day, month, year);
        assertEquals(expectedDay, result);
        System.out.println("Result: " + day + " to " + result);
    }

    @org.junit.jupiter.api.Test
    void testFindNextDay4() {
        int day = 28;
        int month = 2;
        int year = 2018;
        int expectedDay = 1;
        int expectedMonth = 3;

        int result = NextDayCalculator.findNextDay(day, month, year);
        assertEquals(expectedDay, expectedMonth, result);
        System.out.println("Result: " + day + " to " + result);
    }
}