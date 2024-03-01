import java.util.ArrayList;

public class Play {
    public static void main(String[] args) {
        // Tạo danh sách các đoạn đường
        ArrayList<Way> listWay = new ArrayList<>();
        listWay.add(new Way("A", "B", 10));
        listWay.add(new Way("B", "C", 15));
        listWay.add(new Way("A", "D", 5));
        listWay.add(new Way("D", "E", 20));
        listWay.add(new Way("C", "E", 30));

        String startPoint = "A";
        String endPoint = "E";

        FindShortestWay shortestWayFinder = new FindShortestWay(listWay, startPoint, endPoint);

        String shortestPath = shortestWayFinder.findTheShortest();
        System.out.println(shortestPath);
    }

}
