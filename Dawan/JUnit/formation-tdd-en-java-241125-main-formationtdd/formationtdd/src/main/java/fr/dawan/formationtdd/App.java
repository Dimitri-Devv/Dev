package fr.dawan.formationtdd;


public class App 
{
    public static void main( String[] args )
    {
        FizzBuzz fb=new FizzBuzz();
        for(int i=1;i<=100;i++) {
            System.out.println(fb.convert(i));
        }
    }
}
