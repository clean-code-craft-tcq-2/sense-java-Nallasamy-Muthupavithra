package statisticker;

import java.util.List;

public class StatsChecker {

  private final float maxThreshold;
  private IAlerter[] alerters;
  
  /**
   * @param maxThreshold
   * @param alerters
   */
  public StatsChecker(float maxThreshold, IAlerter[] alerters) {
    this.maxThreshold=maxThreshold;
    this.alerters = alerters;
  }

  /**
   * @param numberList
   */
  public void checkAndAlert(List<Float> numberList) {
    Statistics.Stats statistic = Statistics.getStatistics(numberList);
    if(Float.compare(statistic.max,this.maxThreshold)>0) {
      for(IAlerter alerter:alerters) {
        alerter.alert();
      }
    }
    
  }

}
