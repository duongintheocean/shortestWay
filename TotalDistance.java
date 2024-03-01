import java.util.ArrayList;

public class TotalDistance {
    ArrayList<Way> ways;
    public String startPoint;
    public String endPoint;
    public long totalDistance = 0l;
    public String theWay;
    public void setTheWay(){
        theWay =startPoint;
        for (int i=0;i<ways.size();i++){
            theWay.concat(ways.get(i).secondPoint);
        }

    }
    public void setWay(ArrayList<Way> newWays){
        boolean eligibleWay = true;
        long currentDistance = newWays.getFirst().distance;
            if (newWays.size()==1){
                return;
            }

        for (int i = 0; i< newWays.size()-1;i++ ){
            if (newWays.get(i).secondPoint.equals(newWays.get(i+1).firstPoint)){
                currentDistance = currentDistance + newWays.get(i+1).distance;
            }else {
                eligibleWay = false;
                return ;
            }
        }
        if (eligibleWay){
            ways =newWays;
            totalDistance=currentDistance;
        }
    };
    public TotalDistance(String startPoint, String endPoint,ArrayList<Way> newWay){
        this.startPoint=startPoint;
        this.endPoint=endPoint;
        setWay(newWay);
        setTheWay();
    };
}
