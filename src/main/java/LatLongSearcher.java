import net.sf.javaml.core.kdtree.KDTree;

import java.util.LinkedList;
import java.util.ListIterator;

public class LatLongSearcher {

    private MetQuerier mq;
    private JSONProcessor jp;
    private LinkedList<double[]> allMetLocations;
    private LinkedList<Integer> allMetIds;
    private KDTree tree;

    LatLongSearcher() {

        mq = new MetQuerier();
        jp = new JSONProcessor();
        tree = new KDTree(2);

        generateMetLocations();

        ListIterator<double[]> li = allMetLocations.listIterator();

        for (int i = 0; i < allMetLocations.size(); i++) {

            double[] tempArray = allMetLocations.get(i);
            int tempId = allMetIds.get(i);

            tree.insert(tempArray, tempId);
        }

    }

    private void generateMetLocations() {

        // Ask met for locations
        String jsonString = mq.requestMetLocations();

        // Parse JSON
        MetLocations ml = jp.parseMetLocations(jsonString);
        allMetLocations = ml.getMetLatLongs();
        allMetIds = ml.getMetIds();

    }

    public int searchMetLocations(Location currentLocation) {

        int result = 0;

        double[] search = new double[2];
        search[0] = currentLocation.getLatitudeActual();
        search[1] = currentLocation.getLongitudeActual();

        result = (int) tree.nearest(search);

        return result;
    }

}
