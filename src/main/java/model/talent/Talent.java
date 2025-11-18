package model.talent;

public interface Talent {

    /*
     * Talent have 2 attributes : Time et name
     * Time values can be :
     * start
     * end
     */

    public String getName();

    public String getTime();

    public double[] effet_talent(double[] stats);

}
