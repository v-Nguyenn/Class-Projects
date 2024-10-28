
/**
 * Write a description of class VincentExercise1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VincentExercise1
{
    public static void main(String[] args)
    {
        Draw scr1 = new Draw();
        scr1.clear(Draw.YELLOW);
        scr1.filledCircle(0.5, 0.5, 0.1);
        scr1.setPenColor(Draw.GREEN);
        scr1.filledCircle(0.75, 0.25, 0.1);
        scr1.filledCircle(0.95, 0.65, 0.1);
        scr1.setPenColor(Draw.BLUE);
        scr1.filledCircle(0.25, 0.75, 0.1);
        scr1.filledCircle(0.25, 0.75, 0.25);
    }
    
    public static void printExample()
    {
        Draw win = new Draw();
        win.clear( Draw.LIGHT_GRAY );
        win.text( 0.10, 0.25,"Programming is great fun! ");
        System.out.println("My program is great fun! ");
    }
}
