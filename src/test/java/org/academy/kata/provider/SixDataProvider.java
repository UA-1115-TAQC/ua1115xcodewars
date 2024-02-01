package org.academy.kata.provider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SixDataProvider extends AbstractDataProvider{

    @DataProvider(name = "floatingPoint")
    private Iterator<Object[]> floatingPoint(){
        List<Object[]> testData = new ArrayList<>();
        testData.add(new Object[] {2.6e-08, 1.29999999155e-08});
        testData.add(new Object[] {0,0});
        testData.add(new Object[] {-1,-1});
        testData.add(new Object[] {-1.4e-09,-(2.499996875007812e-06)});
        testData.add(new Object[] {5.0e-06, 2.499996875007812e-06});
        testData.add(new Object[] {1.4e-09,6.999999997549999e-10});
        testData.add(new Object[] {2.4e-07, 1.1999999280000085e-07});
        return combineData(testData, SIXES);
    }

    @DataProvider(name = "helpBookseller")
    public Iterator<Object[]> helpBookseller(){
        List<Object[]> inputs = new ArrayList<>();

        inputs.add(new Object[]{new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"},
                new String[] {"A", "B"},
                "(A : 200) - (B : 1140)"});
        inputs.add(new Object[]{new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"},
                new String[] {"A", "B", "W"},
                "(A : 200) - (B : 1140) - (W : 0)"});

        inputs.add(new Object[]{new String[]{}, new String[] {"A", "B"}, ""});
        inputs.add(new Object[]{new String[]{"ABAR 200", "CDXE 500"}, new String[]{}, ""});
        inputs.add(new Object[]{new String[]{"ABAR %200", "CDXE 500", "BKWR 250", "BTSQ 890"}, new String[] {"A", "B"}, "(A : 200) - (B : 1140)"});
        inputs.add(new Object[]{new String[]{"%ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890"}, new String[] {"A", "B"}, "(A : 0) - (B : 1140)"});
        inputs.add(new Object[]{new String[]{"ABAR", "CDXE 500", "BKWR 250", "BTSQ 890"}, new String[] {"A", "B"}, "(A : 0) - (B : 1140)"});
        inputs.add(new Object[]{new String[]{"200", "CDXE 500", "BKWR 250", "BTSQ 890"}, new String[] {"A", "B"}, "(A : 0) - (B : 1140)"});
        inputs.add(new Object[]{new String[]{"", "CDXE 500", "BKWR 250", "BTSQ 890"}, new String[] {"A", "B"}, "(A : 0) - (B : 1140)"});

        inputs.add(new Object[]{new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890"}, new String[] {"%A", "B"}, "(A : 0) - (B : 1140)"});
        inputs.add(new Object[]{new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890"}, new String[] {"", "B"}, "(B : 1140)"});

        return combineData(inputs, SIXES);
    }

    @DataProvider(name = "balance_test")
    public static Iterator<Object[]> balanceData() {
        List<Object[]> inputs = new ArrayList<>();
        String b1 = "1000.00!=\n125 Market !=:125.45\n126 Hardware =34.95\n127 Video! 7.45\n128 Book :14.32\n129 Gasoline ::16.10";
//        String b1sol = "Original Balance: 1000,00\\r\\n125 Market 125,45 Balance 874,55\\r\\n126 Hardware 34,95 Balance 839,60\\r\\n127 Video 7,45 Balance 832,15\\r\\n128 Book 14,32 Balance 817,83\\r\\n129 Gasoline 16,10 Balance 801,73\\r\\nTotal expense  198,27\\r\\nAverage expense  39,65";
        String b1sol = "Original Balance: 1000.00\\r\\n125 Market 125.45 Balance 874.55\\r\\n126 Hardware 34.95 Balance 839.60\\r\\n127 Video 7.45 Balance 832.15\\r\\n128 Book 14.32 Balance 817.83\\r\\n129 Gasoline 16.10 Balance 801.73\\r\\nTotal expense  198.27\\r\\nAverage expense  39.65";

        String b2 = "1233.00\n125 Hardware;! 24.80?\n123 Flowers 93.50;\n127 Meat 120.90\n120 Picture 34.00\n124 Gasoline 11.00\n" +
                "123 Photos;! 71.40?\n122 Picture 93.50\n132 Tyres;! 19.00,?;\n129 Stamps; 13.60\n129 Fruits{} 17.60\n129 Market;! 128.00?\n121 Gasoline;! 13.60?";
        String b2sol = "Original Balance: 1233.00\\r\\n125 Hardware 24.80 Balance 1208.20\\r\\n123 Flowers 93.50 Balance 1114.70\\r\\n127 Meat 120.90 Balance 993.80\\r\\n120 Picture 34.00 Balance 959.80\\r\\n124 Gasoline 11.00 Balance 948.80\\r\\n123 Photos 71.40 Balance 877.40\\r\\n122 Picture 93.50 Balance 783.90\\r\\n132 Tyres 19.00 Balance 764.90\\r\\n129 Stamps 13.60 Balance 751.30\\r\\n129 Fruits 17.60 Balance 733.70\\r\\n129 Market 128.00 Balance 605.70\\r\\n121 Gasoline 13.60 Balance 592.10\\r\\nTotal expense  640.90\\r\\nAverage expense  53.41";

        inputs.add(new Object[]{b1, b1sol}); // input1, result
        inputs.add(new Object[]{b2, b2sol});  // input1, result
        return combineData(inputs, SIXES);
    }

    @DataProvider(name = "nbaCup")
    public Iterator<Object[]> nbaCup(){
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{
                "Los Angeles Clippers 104 Dallas Mavericks 88,New York Knicks 101 Atlanta Hawks 112,Indiana Pacers 103 Memphis Grizzlies 112,"
                    + "Los Angeles Lakers 111 Minnesota Timberwolves 112,Phoenix Suns 95 Dallas Mavericks 111,Portland Trail Blazers 112 New Orleans Pelicans 94,"
                    + "Sacramento Kings 104 Los Angeles Clippers 111,Houston Rockets 85 Denver Nuggets 105,Memphis Grizzlies 76 Cleveland Cavaliers 106,"
                    + "Milwaukee Bucks 97 New York Knicks 122,Oklahoma City Thunder 112 San Antonio Spurs 106,Boston Celtics 112 Philadelphia 76ers 95,"
                    + "Brooklyn Nets 100 Chicago Bulls 115,Detroit Pistons 92 Utah Jazz 87,Miami Heat 104 Charlotte Hornets 94,"
                    + "Toronto Raptors 106 Indiana Pacers 99,Orlando Magic 87 Washington Wizards 88,Golden State Warriors 111 New Orleans Pelicans 95,"
                    + "Atlanta Hawks 94 Detroit Pistons 106,Chicago Bulls 97 Cleveland Cavaliers 95,",
                "San Antonio Spurs 111 Houston Rockets 86,Chicago Bulls 103 Dallas Mavericks 102,Minnesota Timberwolves 112 Milwaukee Bucks 108,"
                        + "New Orleans Pelicans 93 Miami Heat 90,Boston Celtics 81 Philadelphia 76ers 65,Detroit Pistons 115 Atlanta Hawks 87,"
                        + "Toronto Raptors 92 Washington Wizards 82,Orlando Magic 86 Memphis Grizzlies 76,Los Angeles Clippers 115 Portland Trail Blazers 109,"
                        + "Los Angeles Lakers 97 Golden State Warriors 136,Utah Jazz 98 Denver Nuggets 78,Boston Celtics 99 New York Knicks 85,"
                        + "Indiana Pacers 98 Charlotte Hornets 86,Dallas Mavericks 87 Phoenix Suns 99,Atlanta Hawks 81 Memphis Grizzlies 82,"
                        + "Miami Heat 110 Washington Wizards 105,Detroit Pistons 94 Charlotte Hornets 99,Orlando Magic 110 New Orleans Pelicans 107,"
                        + "Los Angeles Clippers 130 Golden State Warriors 95,Utah Jazz 102 Oklahoma City Thunder 113,San Antonio Spurs 84 Phoenix Suns 104,"
                        + "Chicago Bulls 103 Indiana Pacers 94,Milwaukee Bucks 106 Minnesota Timberwolves 88,Los Angeles Lakers 104 Portland Trail Blazers 102,"
                        + "Houston Rockets 120 New Orleans Pelicans 100,Boston Celtics 111 Brooklyn Nets 105,Charlotte Hornets 94 Chicago Bulls 86,Cleveland Cavaliers 103 Dallas Mavericks 97",
                "Boston Celtics", "Boston Celtics:W=4;D=0;L=0;Scored=403;Conceded=350;Points=12"});
        inputs.add(new Object[]{
                "Los Angeles Clippers 104 Dallas Mavericks 88,New York Knicks 101 Atlanta Hawks 112,Indiana Pacers 103 Memphis Grizzlies 112,"
                        + "Los Angeles Lakers 111 Minnesota Timberwolves 112,Phoenix Suns 95 Dallas Mavericks 111,Portland Trail Blazers 112 New Orleans Pelicans 94,"
                        + "Sacramento Kings 104 Los Angeles Clippers 111,Houston Rockets 85 Denver Nuggets 105,Memphis Grizzlies 76 Cleveland Cavaliers 106,"
                        + "Milwaukee Bucks 97 New York Knicks 122,Oklahoma City Thunder 112 San Antonio Spurs 106,Boston Celtics 112 Philadelphia 76ers 95,"
                        + "Brooklyn Nets 100 Chicago Bulls 115,Detroit Pistons 92 Utah Jazz 87,Miami Heat 104 Charlotte Hornets 94,"
                        + "Toronto Raptors 106 Indiana Pacers 99,Orlando Magic 87 Washington Wizards 88,Golden State Warriors 111 New Orleans Pelicans 95,"
                        + "Atlanta Hawks 94 Detroit Pistons 106,Chicago Bulls 97 Cleveland Cavaliers 95,",
                "San Antonio Spurs 111 Houston Rockets 86,Chicago Bulls 103 Dallas Mavericks 102,Minnesota Timberwolves 112 Milwaukee Bucks 108,"
                        + "New Orleans Pelicans 93 Miami Heat 90,Boston Celtics 81 Philadelphia 76ers 65,Detroit Pistons 115 Atlanta Hawks 87,"
                        + "Toronto Raptors 92 Washington Wizards 82,Orlando Magic 86 Memphis Grizzlies 76,Los Angeles Clippers 115 Portland Trail Blazers 109,"
                        + "Los Angeles Lakers 97 Golden State Warriors 136,Utah Jazz 98 Denver Nuggets 78,Boston Celtics 99 New York Knicks 85,"
                        + "Indiana Pacers 98 Charlotte Hornets 86,Dallas Mavericks 87 Phoenix Suns 99,Atlanta Hawks 81 Memphis Grizzlies 82,"
                        + "Miami Heat 110 Washington Wizards 105,Detroit Pistons 94 Charlotte Hornets 99,Orlando Magic 110 New Orleans Pelicans 107,"
                        + "Los Angeles Clippers 130 Golden State Warriors 95,Utah Jazz 102 Oklahoma City Thunder 113,San Antonio Spurs 84 Phoenix Suns 104,"
                        + "Chicago Bulls 103 Indiana Pacers 94,Milwaukee Bucks 106 Minnesota Timberwolves 88,Los Angeles Lakers 104 Portland Trail Blazers 102,"
                        + "Houston Rockets 120 New Orleans Pelicans 100,Boston Celtics 111 Brooklyn Nets 105,Charlotte Hornets 94 Chicago Bulls 86,Cleveland Cavaliers 103 Dallas Mavericks 97",
                "Boston Celt", "Boston Celt:This team didn't play!"});
        return combineData(inputs, SIXES);
    }
}

