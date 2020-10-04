import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) throws Exception {
        Prefecture prefecture = Prefecture.getInstance();
        City city = City.getInstance();
        Scanner sc = new Scanner(System.in);

        prefecture.setPrefeNum(Integer.parseInt(sc.next()));
        city.setCityNum(Integer.parseInt(sc.next()));
        final ArrayList<Integer> listArrayYear = new ArrayList<Integer>();
        for (int iTurn = 0; iTurn < prefecture.getPrefeNum(); iTurn++) {
            final int iCityId = Integer.parseInt(sc.next());
            listArrayYear.add(Integer.parseInt(sc.next()));
            city.setMapInputYear(iCityId, listArrayYear);
            city.setMapBirthYear(iTurn, city.getMapInputYear());
        }

        for ()

    }

    static class Prefecture {

        private int m_iPrefectureNum = 0;
        private static Prefecture m_Me;

        private Prefecture() {
        }

        private static Prefecture getInstance() {
            return m_Me = new Prefecture();
        }

        public void setPrefeNum(final int iPrefeNum) {
            m_iPrefectureNum = iPrefeNum;
        }

        public int getPrefeNum() {
            return m_iPrefectureNum;
        }
    }

    static class City {

        private int m_iCityNum = 0;
        private Map<Integer, TreeMap<Integer, Integer>> m_mapBirthYear = new LinkedHashMap<Integer, TreeMap<Integer, Integer>>();

        private TreeMap<Integer, ArrayList<Integer>> m_mapInputYear = new TreeMap<Integer, ArrayList<Integer>>();
        private static City m_Me;

        private City() {
        }

        private static City getInstance() {
            return m_Me = new City();
        }

        private void setCityNum(final int iCityNum) {
            m_iCityNum = iCityNum;
        }

        private int getCityNum() {
            return m_iCityNum;
        }

        private void setMapInputYear(final int iCityId, final ArrayList listArrayYear) {
            m_mapInputYear.put(iCityId, listArrayYear);
        }

        private TreeMap<Integer, ArrayList<Integer>> getMapInputYear() {
            return m_mapInputYear;
        }

        private void setMapBirthYear(final int iInputTrun, final TreeMap<Integer, ArrayList<Integer>> mapCityBirth) {
            m_mapBirthYear.put(iInputTrun, mapCityBirth);
        }

        private Map<Integer, TreeMap<Integer, Integer>> getBirthYear() {
            return m_mapBirthYear;
        }
    }
}
