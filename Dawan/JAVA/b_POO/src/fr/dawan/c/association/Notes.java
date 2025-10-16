package fr.dawan.c.association;

public class Notes
{
    int maths, english;
    public Notes(int maths, int english)
    {

        this.maths = maths;
        this.english = english;
    }
    @Override
    public String toString()
    {
        return "Notes{" + "maths=" + maths + ", english=" + english + '}';
    }
}
