/**
 *
 *
 *  @author Kenny Peng
 *  @version 10/1/2018
 */
public class Hull {
    private int hullY;
    private int hullX;

    /**
     * creates hull object with coords of hull
     * @param gridX x location of hull
     * @param gridY y location of hull
     */
    public Hull(int gridX,int gridY){
        hullX = gridX;
        hullY = gridY;
    }

    /**
     * gets hull x coord
     * @return hull x coord
     */
    public int getHullX(){
        return hullX;
    }

    /**
     * gets hull y coord
     * @return hull y coord
     */
    public int getHullY(){
        return hullY;
    }
}
