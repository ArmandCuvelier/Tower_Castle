package model.talent;

import model.Stats;

public interface Talent {

    /*
     * Talent have 2 attributes : Time et name
     * Time values can be :
     * start
     * end
     */

    public String getName();

    public String getTime();

    public void effet_talent(Stats stats);

}
