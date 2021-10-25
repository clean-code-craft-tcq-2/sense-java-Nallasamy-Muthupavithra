package statisticker;

import java.util.List;

public class Statistics 
{
  //to store computed statistics
  static class Stats {

     Float min =Float.NaN;
     Float max =Float.NaN;
     Float average =Float.NaN; 
  }
  
    public static Stats getStatistics(List<Float> numbers) {
      Statistics.Stats computedStatistics = new Stats();
      if(!numbers.isEmpty()) {
      // Calculate Min and Max Value
      calculateMinMaxValue(numbers, computedStatistics);
      // Calculate Average Value
      calculateAverageValue(numbers, computedStatistics);
      }
      return computedStatistics;     
    }

    /**
     * @param numbers
     * @param computedStatistics 
     */
    private static void calculateMinMaxValue(final List<Float> numbers, final Stats computedStatistics) {
      Float minValue = Float.MAX_VALUE;
      Float maxValue = Float.MIN_VALUE;
      for(Float number:numbers) {
        if(Float.compare(number, minValue) < 0){
          minValue = number;
        }
        if(Float.compare(number, maxValue) > 0) {
          maxValue = number;
        }
      }
      computedStatistics.min=minValue;
      computedStatistics.max=maxValue;
    }


    /**
     * @param numbers
     * @param computedStatistics 
     */
    private static void calculateAverageValue(final List<Float> numbers,final Stats computedStatistics) {
      Float sum=0.0f;
      for(Float number:numbers) {
        sum+=number;
      }
      computedStatistics.average=sum/(numbers.size());
    }
}
