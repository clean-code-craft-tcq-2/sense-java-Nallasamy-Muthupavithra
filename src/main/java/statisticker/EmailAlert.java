package statisticker;

public class EmailAlert implements IAlerter{

  /**
   * true, if email is sent
   */
  public boolean emailSent;
  
  /** 
   * {@inheritDoc}
   */
  @Override
  public void alert() {
    this.emailSent = true; 
  }
}
