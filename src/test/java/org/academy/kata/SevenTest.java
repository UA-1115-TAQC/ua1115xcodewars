package org.academy.kata;

import org.academy.kata.Seven;
import org.academy.kata.provider.SevenDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.expectThrows;
import static org.testng.AssertJUnit.assertEquals;

public class SevenTest extends BaseTestRunner {

    @Test(dataProvider = "newAvgSuccess", dataProviderClass = SevenDataProvider.class)
    public void findAverageOfTheNextDonationSuccess(Seven seven, double[] donations, double averageDonation, long expectedDonation) {
        assertEquals(expectedDonation, seven.newAvg(donations, averageDonation));
    }

    @Test(dataProvider = "newAvgException", dataProviderClass = SevenDataProvider.class)
    public void findAverageOfTheNextDonationException(Seven seven, double[] donations, double averageDonation) {
        expectThrows(IllegalArgumentException.class, () -> seven.newAvg(donations, averageDonation));
    }
}
