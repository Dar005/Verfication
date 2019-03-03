package cm;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SuppressWarnings("Duplicates")
public class GahanDarranTestTask2 {

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateLessThanReducedRate() throws Exception {

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 3));
        reducedPeriods.add(new Period(10, 12));

        normalPeriods.add(new Period(4, 9));
        normalPeriods.add(new Period(13, 11));

    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateJustLessThanZero() throws Exception {

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 3));
        reducedPeriods.add(new Period(10, 12));

        normalPeriods.add(new Period(4, 9));
        normalPeriods.add(new Period(13, 16));

        BigDecimal hourlyNormalRate = new BigDecimal( -1);
        BigDecimal hourlyReducedRate = new BigDecimal( 3);

        Rate rate = new Rate(CarParkKind.STAFF, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateMuchLessThanZero() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 3));
        reducedPeriods.add(new Period(10, 12));

        normalPeriods.add(new Period(4, 9));
        normalPeriods.add(new Period(13, 16));

        BigDecimal hourlyNormalRate = new BigDecimal( -42);
        BigDecimal hourlyReducedRate = new BigDecimal( 3);

        Rate rate = new Rate(CarParkKind.STAFF, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedRateJustLessThatZero() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 3));
        reducedPeriods.add(new Period(10, 12));

        normalPeriods.add(new Period(4, 9));
        normalPeriods.add(new Period(13, 16));

        BigDecimal hourlyNormalRate = new BigDecimal( 5);
        BigDecimal hourlyReducedRate = new BigDecimal( -1);

        Rate rate = new Rate(CarParkKind.STAFF, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedRateMuchLessThanZero() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 3));
        reducedPeriods.add(new Period(10, 12));

        normalPeriods.add(new Period(4, 9));
        normalPeriods.add(new Period(13, 16));

        BigDecimal hourlyNormalRate = new BigDecimal( 5);
        BigDecimal hourlyReducedRate = new BigDecimal( -42);

        Rate rate = new Rate(CarParkKind.MANAGEMENT, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodsOverlap() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 3));
        reducedPeriods.add(new Period(2, 5));

        normalPeriods.add(new Period(4, 9));
        normalPeriods.add(new Period(13, 16));

        BigDecimal hourlyNormalRate = new BigDecimal( 5);
        BigDecimal hourlyReducedRate = new BigDecimal( 3);

        Rate rate = new Rate(CarParkKind.STAFF, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodsOverlap() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 3));
        reducedPeriods.add(new Period(10, 12));

        normalPeriods.add(new Period(4, 9));
        normalPeriods.add(new Period(8, 11));

        BigDecimal hourlyNormalRate = new BigDecimal( 5);
        BigDecimal hourlyReducedRate = new BigDecimal( 3);

        Rate rate = new Rate(CarParkKind.MANAGEMENT, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodJustLessThanZero() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(-1, 3));
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodsMuchLessThanZero() throws Exception {

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(-42, 3));
    }

    @org.junit.Test(expected= IllegalArgumentException.class)
    public void reducedPeriodJustGreaterThan24() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(4, 8));
        reducedPeriods.add(new Period(21, 25));

    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodMuchGreaterThan24() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(8, 11));
        reducedPeriods.add(new Period(20, 42));

    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodStartTimeGreaterThanEndTime() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(6, 9));
        reducedPeriods.add(new Period(14, 12));

    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodJustGreaterThat24() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(8, 11));
        reducedPeriods.add(new Period(13, 15));

        normalPeriods.add(new Period(1, 4));
        normalPeriods.add(new Period(22, 25));

    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodMuchGreaterThan24() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(6, 9));
        reducedPeriods.add(new Period(10, 12));

        normalPeriods.add(new Period(1, 4));
        normalPeriods.add(new Period(21, 42));

    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodJustLessThanZero() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(6, 9));
        reducedPeriods.add(new Period(10, 12));

        normalPeriods.add(new Period(-1, 4));

    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodMuchLessThanZero() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(6, 9));
        reducedPeriods.add(new Period(10, 12));

        normalPeriods.add(new Period(-42, 4));

    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodStartTimeGreaterThanEndTime() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(6, 9));
        reducedPeriods.add(new Period(10, 12));

        normalPeriods.add(new Period(1, 4));
        normalPeriods.add(new Period(21, 17));

    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalAndReducedRateHaveSameValue() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(6, 9));
        reducedPeriods.add(new Period(10, 12));

        normalPeriods.add(new Period(1, 4));
        normalPeriods.add(new Period(17, 21));

        BigDecimal hourlyNormalRate = new BigDecimal( 3);
        BigDecimal hourlyReducedRate = new BigDecimal( 3);

        Rate rate = new Rate(CarParkKind.STAFF, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

    }

    @org.junit.Test
    public void normalPeriodJustLessThan24(){
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(8, 11));
        reducedPeriods.add(new Period(13, 15));

        normalPeriods.add(new Period(3, 6));
        normalPeriods.add(new Period(21, 23));

        BigDecimal hourlyNormalRate = new BigDecimal( 5);
        BigDecimal hourlyReducedRate = new BigDecimal( 3);

        Rate rate = new Rate(CarParkKind.STUDENT, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertNotNull(rate);
    }

    @org.junit.Test
    public void normalPeriodEquals24(){

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(8, 11));
        reducedPeriods.add(new Period(13, 15));

        normalPeriods.add(new Period(3, 6));
        normalPeriods.add(new Period(21, 24));

        BigDecimal hourlyNormalRate = new BigDecimal( 5);
        BigDecimal hourlyReducedRate = new BigDecimal( 3);

        Rate rate = new Rate(CarParkKind.STAFF, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertNotNull(rate);
    }

    @org.junit.Test
    public void normalPeriodJustGreaterThanZero(){

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(8, 11));
        reducedPeriods.add(new Period(13, 15));

        normalPeriods.add(new Period(1, 4));
        normalPeriods.add(new Period(18, 21));

        BigDecimal hourlyNormalRate = new BigDecimal( 5);
        BigDecimal hourlyReducedRate = new BigDecimal( 3);

        Rate rate = new Rate(CarParkKind.STUDENT, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertNotNull(rate);
    }

    @org.junit.Test
    public void normalPeriodEqualsZero(){

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(8, 12));
        reducedPeriods.add(new Period(13,15));

        normalPeriods.add(new Period(0, 3));
        normalPeriods.add(new Period(17, 19));

        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);

        Rate rate = new Rate(CarParkKind.MANAGEMENT, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertNotNull(rate);
    }

    @org.junit.Test
    public void reducedPeriodJustLessThan24(){


        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(8, 11));
        reducedPeriods.add(new Period(20,23));

        normalPeriods.add(new Period(3, 5));
        normalPeriods.add(new Period(13, 15));

        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);

        Rate rate = new Rate(CarParkKind.STAFF, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertNotNull(rate);
    }

    @org.junit.Test
    public void reducedPeriodEquals24(){

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(8, 12));
        reducedPeriods.add(new Period(20,24));

        normalPeriods.add(new Period(2, 4));
        normalPeriods.add(new Period(13, 15));

        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);

        Rate rate = new Rate(CarParkKind.STAFF, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertNotNull(rate);
    }

    @org.junit.Test
    public void reducedPeriodJustGreaterThatZero(){

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 4));
        reducedPeriods.add(new Period(10,12));

        normalPeriods.add(new Period(6, 9));
        normalPeriods.add(new Period(17, 21));

        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);

        Rate rate = new Rate(CarParkKind.MANAGEMENT, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertNotNull(rate);
    }

    @org.junit.Test
    public void reducedPeriodEqualsZero() {

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(0, 3));
        reducedPeriods.add(new Period(10, 12));

        normalPeriods.add(new Period(6, 9));
        normalPeriods.add(new Period(17, 21));

        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);

        Rate rate = new Rate(CarParkKind.STUDENT, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertNotNull(rate);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodsEqualsNull() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = null;

        normalPeriods.add(new Period(6, 9));
        normalPeriods.add(new Period(17, 21));

        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);

        Rate rate = new Rate(CarParkKind.STUDENT, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodsEqualsNull()throws Exception{

        ArrayList<Period> normalPeriods = null;
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 3));
        reducedPeriods.add(new Period(10, 12));

        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);

        Rate rate = new Rate(CarParkKind.STUDENT, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);
    }

    @org.junit.Test
    public void calculatePeriod(){

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12, 14));
        reducedPeriods.add(new Period(17, 22));

        normalPeriods.add(new Period(9, 12));
        normalPeriods.add(new Period(14, 17));

        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);

        Rate rate = new Rate(CarParkKind.MANAGEMENT, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertEquals(rate.calculate(new Period(9, 15)),new BigDecimal(26.0));
    }

    @org.junit.Test
    public void calculatePeriodEqualsZero(){

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 6));
        reducedPeriods.add(new Period(19, 22));

        normalPeriods.add(new Period(6, 12));
        normalPeriods.add(new Period(13, 17));

        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);

        Rate rate = new Rate(CarParkKind.MANAGEMENT, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertEquals(rate.calculate(new Period(0, 6)), new BigDecimal(15.0));
    }

    @org.junit.Test
    public void calculatePeriodJustGreaterThanZero(){

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 6));
        reducedPeriods.add(new Period(19, 22));

        normalPeriods.add(new Period(6, 12));
        normalPeriods.add(new Period(13, 17));

        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);

        Rate rate = new Rate(CarParkKind.MANAGEMENT, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertEquals(rate.calculate(new Period(1, 9)), new BigDecimal(30.0));
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void calculatePeriodJustLessThanZero() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12, 14));
        reducedPeriods.add(new Period(17, 22));

        normalPeriods.add(new Period(9, 12));
        normalPeriods.add(new Period(14, 17));

        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);

        Rate rate = new Rate(CarParkKind.MANAGEMENT, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        rate.calculate(new Period(-1, 15));
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void calculatePeriodMuchLessThanZero() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12, 14));
        reducedPeriods.add(new Period(17, 22));

        normalPeriods.add(new Period(9, 12));
        normalPeriods.add(new Period(14, 17));

        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);

        Rate rate = new Rate(CarParkKind.MANAGEMENT, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        rate.calculate( new Period(-42, 5));
    }

    @org.junit.Test
    public void
    calculatePeriodEquals24(){

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 6));
        reducedPeriods.add(new Period(19, 23));

        normalPeriods.add(new Period(6, 12));
        normalPeriods.add(new Period(13, 17));

        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);

        Rate rate = new Rate(CarParkKind.MANAGEMENT, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertEquals(rate.calculate(new Period(19, 24)), new BigDecimal(12.0));
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void calculatePeriodJustGreaterThan24() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12, 14));
        reducedPeriods.add(new Period(17, 22));

        normalPeriods.add(new Period(9, 12));
        normalPeriods.add(new Period(14, 17));

        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);

        Rate rate = new Rate(CarParkKind.MANAGEMENT, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);
        rate.calculate(new Period(16, 25));
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void calculatePeriodMuchGreaterThat24() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12, 14));
        reducedPeriods.add(new Period(17, 22));

        normalPeriods.add(new Period(9, 12));
        normalPeriods.add(new Period(14, 17));

        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);

        Rate rate = new Rate(CarParkKind.MANAGEMENT, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        rate.calculate(new Period(18, 42));
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void calculateStartTimeGreaterThanEndTime() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 6));
        reducedPeriods.add(new Period(19, 22));

        normalPeriods.add(new Period(6, 12));
        normalPeriods.add(new Period(13, 17));

        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);

        Rate rate = new Rate(CarParkKind.MANAGEMENT, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        rate.calculate(new Period(16, 9));
    }


    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateIsNull() throws Exception {

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 3));
        reducedPeriods.add(new Period(10, 12));

        normalPeriods.add(new Period(4, 9));
        normalPeriods.add(new Period(13, 16));

        BigDecimal hourlyNormalRate = null;
        BigDecimal hourlyReducedRate = new BigDecimal( 3);

        Rate rate = new Rate(CarParkKind.STAFF, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedRateIsNull() throws Exception {

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 3));
        reducedPeriods.add(new Period(10, 12));

        normalPeriods.add(new Period(4, 9));
        normalPeriods.add(new Period(13, 16));

        BigDecimal hourlyNormalRate = new BigDecimal( 3);
        BigDecimal hourlyReducedRate = null;

        Rate rate = new Rate(CarParkKind.STAFF, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodOverlapsNormalPeriods() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 4));
        reducedPeriods.add(new Period(10, 12));

        normalPeriods.add(new Period(3, 9));
        normalPeriods.add(new Period(13, 16));

        BigDecimal hourlyNormalRate = new BigDecimal( 5);
        BigDecimal hourlyReducedRate = new BigDecimal( 3);

        Rate rate = new Rate(CarParkKind.STAFF, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);
    }


    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodOverlapsReducedPeriods() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

       // reducedPeriods.add(new Period(1, 3));
        reducedPeriods.add(new Period(10, 12));

        normalPeriods.add(new Period(4, 11));
        //normalPeriods.add(new Period(13, 16));

        BigDecimal hourlyNormalRate = new BigDecimal( 5);
        BigDecimal hourlyReducedRate = new BigDecimal( 3);;

        Rate rate = new Rate(CarParkKind.STAFF, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);
    }


    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodHasThreePeriods() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 4));
        reducedPeriods.add(new Period(3, 6));
        reducedPeriods.add(new Period(14, 17));

        normalPeriods.add(new Period(7, 9));
        normalPeriods.add(new Period(11, 13));

        BigDecimal hourlyNormalRate = new BigDecimal( 5);
        BigDecimal hourlyReducedRate = new BigDecimal( 3);

        Rate rate = new Rate(CarParkKind.STAFF, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodHasThreePeriods() throws Exception{

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(1, 3));
        reducedPeriods.add(new Period(4, 6));


        normalPeriods.add(new Period(7, 9));
        normalPeriods.add(new Period(11, 13));
        normalPeriods.add(new Period(12, 15));

        BigDecimal hourlyNormalRate = new BigDecimal( 5);
        BigDecimal hourlyReducedRate = new BigDecimal( 3);

        Rate rate = new Rate(CarParkKind.STAFF, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);
    }

    @org.junit.Test
    public void visitorCostOverEight(){

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12, 14));
        reducedPeriods.add(new Period(17, 22));

        normalPeriods.add(new Period(9, 12));
        normalPeriods.add(new Period(14, 17));

        BigDecimal hourlyNormalRate = new BigDecimal( 5.00);
        BigDecimal hourlyReducedRate = new BigDecimal( 3.00);

        Rate rate = new Rate(CarParkKind.VISITOR, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertEquals(rate.calculate(new Period(13, 17)), new BigDecimal(5.00));

    }

    @org.junit.Test
    public void visitorCostAboveEight(){

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12, 14));
        reducedPeriods.add(new Period(17, 22));

        normalPeriods.add(new Period(9, 12));
        normalPeriods.add(new Period(14, 17));

        BigDecimal hourlyNormalRate = new BigDecimal( 5.00);
        BigDecimal hourlyReducedRate = new BigDecimal( 3.00);

        Rate rate = new Rate(CarParkKind.VISITOR, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertEquals(rate.calculate(new Period(17, 22)), new BigDecimal(3.50));

    }

    @org.junit.Test
    public void visitorCostEqualsThree(){

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12, 14));
        reducedPeriods.add(new Period(17, 22));

        normalPeriods.add(new Period(9, 12));
        normalPeriods.add(new Period(14, 17));

        BigDecimal hourlyNormalRate = new BigDecimal( 5.00);
        BigDecimal hourlyReducedRate = new BigDecimal( 3.00);

        Rate rate = new Rate(CarParkKind.VISITOR, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertEquals(rate.calculate(new Period(13, 14)), new BigDecimal(0.00));

    }

    @org.junit.Test
    public void visitorCostEqualsEight(){

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12, 14));
        reducedPeriods.add(new Period(17, 22));

        normalPeriods.add(new Period(9, 12));
        normalPeriods.add(new Period(14, 17));

        BigDecimal hourlyNormalRate = new BigDecimal( 5.00);
        BigDecimal hourlyReducedRate = new BigDecimal( 3.00);

        Rate rate = new Rate(CarParkKind.VISITOR, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertEquals(rate.calculate(new Period(13, 14)), new BigDecimal(0.00));
    }

    @org.junit.Test
    public void visitorCostJustOverEight(){

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12, 14));
        reducedPeriods.add(new Period(17, 22));

        normalPeriods.add(new Period(9, 12));
        normalPeriods.add(new Period(14, 17));

        BigDecimal hourlyNormalRate = new BigDecimal( 5.00);
        BigDecimal hourlyReducedRate = new BigDecimal( 4.00);

        Rate rate = new Rate(CarParkKind.VISITOR, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertEquals(rate.calculate(new Period(13, 15)), new BigDecimal(0.50));
    }

    @org.junit.Test
    public void managerCostOverThree(){

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12, 14));
        reducedPeriods.add(new Period(17, 22));

        normalPeriods.add(new Period(9, 12));
        normalPeriods.add(new Period(14, 17));

        BigDecimal hourlyNormalRate = new BigDecimal( 5.00);
        BigDecimal hourlyReducedRate = new BigDecimal( 3.00);

        Rate rate = new Rate(CarParkKind.MANAGEMENT, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertEquals(rate.calculate(new Period(13, 15)), new BigDecimal(8.00));
    }

    @org.junit.Test
    public void managerCostWayOverThree(){

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12, 14));
        reducedPeriods.add(new Period(17, 22));

        normalPeriods.add(new Period(9, 12));
        normalPeriods.add(new Period(14, 17));

        BigDecimal hourlyNormalRate = new BigDecimal( 5.00);
        BigDecimal hourlyReducedRate = new BigDecimal( 3.00);

        Rate rate = new Rate(CarParkKind.MANAGEMENT, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertEquals(rate.calculate(new Period(13, 18)), new BigDecimal(21.00));
    }

    @org.junit.Test
    public void managerCostUnderThree(){

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12, 14));
        reducedPeriods.add(new Period(17, 22));

        normalPeriods.add(new Period(9, 12));
        normalPeriods.add(new Period(14, 17));

        BigDecimal hourlyNormalRate = new BigDecimal( 5.00);
        BigDecimal hourlyReducedRate = new BigDecimal( 2.00);

        Rate rate = new Rate(CarParkKind.MANAGEMENT, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertEquals(rate.calculate(new Period(12, 13)), new BigDecimal(3.00));
    }

    @org.junit.Test
    public void StudentCostFiveHours(){

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12, 14));
        reducedPeriods.add(new Period(17, 22));

        normalPeriods.add(new Period(9, 12));
        normalPeriods.add(new Period(14, 17));

        BigDecimal hourlyNormalRate = new BigDecimal( 5.00);
        BigDecimal hourlyReducedRate = new BigDecimal( 3.00);

        Rate rate = new Rate(CarParkKind.STUDENT, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertEquals(rate.calculate(new Period(14, 19)), new BigDecimal(17.12).setScale(2, RoundingMode.FLOOR));
    }

    @org.junit.Test
    public void StudentCostTwoHours(){

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12, 14));
        reducedPeriods.add(new Period(17, 22));

        normalPeriods.add(new Period(9, 12));
        normalPeriods.add(new Period(14, 17));

        BigDecimal hourlyNormalRate = new BigDecimal( 5.00);
        BigDecimal hourlyReducedRate = new BigDecimal( 3.00);

        Rate rate = new Rate(CarParkKind.STUDENT, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertEquals(rate.calculate(new Period(13, 15)), new BigDecimal(7.37).setScale(2, RoundingMode.FLOOR));
    }

    @org.junit.Test
    public void StudentCostOneHour(){

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12, 14));
        reducedPeriods.add(new Period(17, 22));

        normalPeriods.add(new Period(9, 12));
        normalPeriods.add(new Period(14, 17));

        BigDecimal hourlyNormalRate = new BigDecimal( 5.00);
        BigDecimal hourlyReducedRate = new BigDecimal( 3.00);

        Rate rate = new Rate(CarParkKind.STUDENT, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertEquals(rate.calculate(new Period(14, 15)), new BigDecimal(5.00));
    }

    @org.junit.Test
    public void StaffCostOneHour(){

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12, 14));
        reducedPeriods.add(new Period(17, 22));

        normalPeriods.add(new Period(9, 12));
        normalPeriods.add(new Period(14, 17));

        BigDecimal hourlyNormalRate = new BigDecimal( 5.00);
        BigDecimal hourlyReducedRate = new BigDecimal( 3.00);

        Rate rate = new Rate(CarParkKind.STAFF, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertEquals(rate.calculate(new Period(12, 13)), new BigDecimal(3.00));
    }

    @org.junit.Test
    public void StaffCostAboveSixteen(){

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12, 14));
        reducedPeriods.add(new Period(17, 22));

        normalPeriods.add(new Period(9, 12));
        normalPeriods.add(new Period(14, 17));

        BigDecimal hourlyNormalRate = new BigDecimal( 5.00);
        BigDecimal hourlyReducedRate = new BigDecimal( 3.00);

        Rate rate = new Rate(CarParkKind.STAFF, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertEquals(rate.calculate(new Period(12, 18)), new BigDecimal(16.00));
    }

    @org.junit.Test
    public void StaffCostBelowSixteen(){

        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(12, 14));
        reducedPeriods.add(new Period(17, 22));

        normalPeriods.add(new Period(9, 12));
        normalPeriods.add(new Period(14, 17));

        BigDecimal hourlyNormalRate = new BigDecimal( 5.00);
        BigDecimal hourlyReducedRate = new BigDecimal( 3.00);

        Rate rate = new Rate(CarParkKind.STAFF, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

        assertEquals(rate.calculate(new Period(12, 15)), new BigDecimal(11.00));
    }
}