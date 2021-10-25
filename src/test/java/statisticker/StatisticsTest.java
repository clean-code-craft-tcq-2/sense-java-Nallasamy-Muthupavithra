package statisticker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class StatisticsTest 
{
    @Test
    public void reportsAverageMinMaxx()
    {
        Float[] numbers = {1.5f, 8.9f, 3.2f, 4.5f};
        List<Float> numberList = Arrays.asList(numbers);

        Statistics.Stats s = Statistics.getStatistics(numberList);
        
        assertFalse(Float.isNaN(s.average));
        assertFalse(Float.isNaN(s.min));
        assertFalse(Float.isNaN(s.max));
        
       float epsilon = 0.001f;
       assertEquals(4.525f,s.average, epsilon);
       assertEquals(1.5f,s.min, epsilon);
       assertEquals(8.9f,s.max, epsilon);

    }
    
    @Test
    public void reportsNaNForEmptyInput()
    {
        List<Float> emptyList = new ArrayList<Float>();

        Statistics.Stats s = Statistics.getStatistics(emptyList);
       
       float epsilon = 0.0f;
       assertEquals(Float.NaN,s.average, epsilon);
       assertEquals(Float.NaN,s.min, epsilon);
       assertEquals(Float.NaN,s.max, epsilon);
       
       assertTrue(Float.isNaN(s.average));
       assertTrue(Float.isNaN(s.min));
       assertTrue(Float.isNaN(s.max));
        //All fields of computedStats (average, max, min) must be
        //Float.NaN (not-a-number), as described in
        //https://www.geeksforgeeks.org/nan-not-number-java/
        //Design the asserts here and implement accordingly.
    }
    
}
