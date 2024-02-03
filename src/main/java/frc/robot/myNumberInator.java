package frc.robot;
import java.util.function.DoubleSupplier;

public class myNumberInator {
  double lastNum = 0.0;

  public myNumberInator() {};

  public double getNext() {
    this.advance();
    return this.get();
   }

   public void advance() {
    this.lastNum += 1e-2;
    this.lastNum %= 1.0;
   }

   public double get() {
    return this.lastNum;
   }

   public DoubleSupplier supplier = () -> this.getNext();
}
