import java.util.ArrayList;

public class FindShortestWay {
    public ArrayList<Way> listWay= new ArrayList<>();
    public String startPoint;
    public String endPoint;

    ArrayList<TotalDistance>findThePossibleWay(){
        ArrayList<TotalDistance> possibleWay= new ArrayList<>();
        for (int i=0;i<listWay.size();i++){
            ArrayList<Way> newWay =new ArrayList<>();
            if (listWay.get(i).firstPoint.equals(startPoint)){
                newWay.add(listWay.get(i));
                if (listWay.get(i).secondPoint.equals(endPoint)){
                    TotalDistance totalDistance = new TotalDistance(startPoint,endPoint,newWay);
                    possibleWay.add(totalDistance);
                }else {
                    String currentPoint = startPoint;
                    for (int j = 0; j < listWay.size();j++){
                        if (j == i){
                            continue;
                        }
                        if (listWay.get(i).secondPoint.equals(listWay.get(j).firstPoint)){
                            currentPoint = listWay.get(j).secondPoint;
                            newWay.add(listWay.get(j));
                        }else {
                            break;
                        }
                        if (currentPoint.equals(endPoint)){
                            break;
                        }
                    }
                    if (newWay.getFirst().firstPoint.equals(startPoint) && newWay.getLast().equals(endPoint)){
                        TotalDistance totalDistance = new TotalDistance(startPoint,endPoint,newWay);
                        possibleWay.add(totalDistance);
                    }
                }
            }
        }
        return possibleWay;
    }
    String findTheShortest(){
        ArrayList<TotalDistance> possibleWay = findThePossibleWay();
        String result ="";
        if (possibleWay.size() == 0){
            return result= "no way lead us from "+ startPoint + " to "+endPoint;
        }else {
            for (int i=0;i<possibleWay.size();i++){
                TotalDistance theBestWay =possibleWay.get(i);
                if (theBestWay.totalDistance > possibleWay.get(i+1).totalDistance){
                    theBestWay =possibleWay.get(i+1);
                }
                if (i==possibleWay.size()-1){
                    return result= "the best shortest way is" + theBestWay.theWay + " with distance is : "+ theBestWay.totalDistance;
                }
            }
        }
        return result;
    }


    public FindShortestWay(ArrayList<Way> listWay, String startPoint, String endPoint) {
        this.listWay = listWay;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
}
