/*
 * Copyright (c) Robert Bosch GmbH. All rights reserved.
 */
package statisticker;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class StatsCheckerTest {

 
  @Test
  public void reportsAlertsIfMaxIsMoreThanThreshold()
  {
      EmailAlert emailAlerter = new EmailAlert();
      LEDAlert ledAlerter = new LEDAlert();
      IAlerter[] alerters = {emailAlerter, ledAlerter};
      float maxThreshold = 10.2f;
      StatsChecker checker = new StatsChecker(maxThreshold, alerters);

      Float[] numbers = {11.5f, 6.9f, 7.5f, 6.6f};     
      List<Float> numberList = Arrays.asList(numbers);
      
      checker.checkAndAlert(numberList);
      
      assertTrue(emailAlerter.emailSent);
      assertTrue(ledAlerter.ledGlows);
  }
  
 @Test
  public void noReportsAlertsIfMaxIsLessThanThreshold()
  {
      EmailAlert emailAlerter = new EmailAlert();
      LEDAlert ledAlerter = new LEDAlert();
      IAlerter[] alerters = {emailAlerter, ledAlerter};
      float maxThreshold = 10.2f;
      StatsChecker checker = new StatsChecker(maxThreshold, alerters);

      Float[] numbers = {9.5f, 6.9f, 7.5f, 6.6f};     
      List<Float> numberList = Arrays.asList(numbers);
      
      checker.checkAndAlert(numberList);
      
      assertFalse(emailAlerter.emailSent);
      assertFalse(ledAlerter.ledGlows);
  }
}
