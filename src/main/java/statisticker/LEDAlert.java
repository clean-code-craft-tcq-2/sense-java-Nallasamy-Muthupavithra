package statisticker;

public class LEDAlert implements IAlerter{

  /**
   * true, if LED glows
   */
  public boolean ledGlows;
   
  /** 
   * {@inheritDoc}
   */
  @Override
  public void alert() {
    this.ledGlows= true;  
  }
}
