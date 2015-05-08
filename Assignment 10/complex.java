//Kate Maher

import java.util.*;
import java.lang.*;

public class Complex
{
   private double real;
   private double imaginary;
   
   public double getReal()
   {
      return real;
   }
   
   public void setReal(double newReal)
   {
      real = newReal;
   }
   
   public double getImaginary()
   {
      return imaginary;
   }
   
   public void setImaginary(double newImaginary)
   {
      imaginary = newImaginary;
   }
   
   public Complex(double real, double imaginary)
   {
      this.real = real;
      this.imaginary = imaginary;
   }
   
   public Complex()
   {
      this(0.0, 0.0);
   }
   
   public double magnitude()
   {
      return Math.hypot(imaginary, real);
   }
   
   public double argument()
   {
      return Math.atan2(imaginary, real);
   }
   
   public boolean equals()
   {
      return Math.abs(imaginary - real) < .01;
   }
   
   public Complex sum(Complex z)
   {
      return new Complex(this.real + z.real, this.imaginary + z.imaginary);
   }
   
   public String toString()
   {
      String retval = String.format("%.2f + %.2fi", real, imaginary);
      return retval;
   }

}
