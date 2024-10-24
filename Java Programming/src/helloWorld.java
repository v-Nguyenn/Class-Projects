import packageName.Draw; // Replace 'packageName' with the actual package name.

public class helloWorld
{
   public static void main(String[] args)
   {
      testing();
      drawing();
   }
   public static void testing()
   {
      System.out.println("Hello World");
   }

   public static void drawing()
   {
      Draw scr = new Draw();
      scr.clear(Draw.BLACK);
   }
}