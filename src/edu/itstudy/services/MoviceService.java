package edu.itstudy.services;

import edu.itstudy.model.Movie;

import java.text.Collator;
import java.util.*;

public class MoviceService {
    public List<Movie> getMovices() {
        return movices;
    }

    public void setMovices(List<Movie> movices) {
        this.movices = movices;
    }

    private List<Movie> movices = new ArrayList<>();
    //	1.按名称	2.按上映时间	3.按类型	4.按点击率	5.按推荐率
    private static final int SORT_BY_NAME = 1; //按名字排序
    private static final int SORT_BY_DATE = 2; //按上映时间排序
    private static final int SORT_BY_TYPE = 3; //按类型排序
    private static final int SORT_BY_CLICKRATE = 4; //按点击率排序
    private static final int SORT_BY_RECOMMENDRATE = 5; //按推荐率排序
    //搜索条件 or 非搜索条件
    public static final String SEARCH_TJ="tj";
    public static final String SEARCH_NO_TJ="no_tj";

    {
        movices.add(new Movie(121123, "囧妈", "喜剧", "徐峥", new Date(), "徐峥", 0, 0));
        movices.add(new Movie(121223, "囧妈", "喜剧", "徐峥", new Date(), "徐峥", 0, 0));
    }

    /**
     * 添加影片
     *
     * @param movie
     * @return
     */
    public boolean addMovie(Movie movie) {
        this.movices.add(movie);
        return true;
    }

    /**
     * 遍历所有电影
     */
    public void printMovies(List<Movie> movices) {
        System.out.println("===============影片列表===============");
        System.out.println("INDEX/ID\t名称\t类型\t主演\t导演\t上映日期\t\t点击率\t推荐率");
        if (movices.size() == 0) {
            System.out.println("暂无影片");
        }
        int i = 1;
        for (Movie m : movices) {
            System.out.println(i + "/" + m);
            i++;
        }
    }
    public void updateClickRage(String flag,int index){
        if(this.SEARCH_TJ.equals(flag)){

        }
    }
    public void sort(char c1, List<Movie> list) {
        int i = c1 - 48;
        if (i == this.SORT_BY_NAME) {
            Collections.sort(list, (x, y) ->
                    Collator.getInstance(Locale.CANADA).compare(x.getName(), y.getName()));
        } else if (i == this.SORT_BY_DATE) {
            Collections.sort(list, (x, y) -> x.getDate().compareTo(y.getDate()));
        } else if (i == this.SORT_BY_TYPE) {
            Collections.sort(list, (x,y)->x.getType().compareTo(y.getType()));
        } else if (i == this.SORT_BY_CLICKRATE) {
            Collections.sort(list, (x, y) -> x.getClickRate() - y.getClickRate());
        } else if (i == this.SORT_BY_RECOMMENDRATE) {
            Collections.sort(list, (x, y) -> x.getRecommendRate() - y.getRecommendRate());
        }

    }

    /**
     * 根据指定条件搜索影片
     *
     * @param name
     * @param type
     * @param performer
     * @return
     */
    public List<Movie> searchMovie(String name, String type, String performer) {
        List<Movie> list = new ArrayList<>();
        for (Movie m : movices) {
            String name1 = m.getName();
            String type1 = m.getType();
            String performer1 = m.getPerformer();
            if ((null == name ? true : name1.contains(name)) && (null == type ? true : type1.contains(type)) && (null == performer ? true : performer1.contains(performer))) {
                list.add(m);
            }
        }
        return list;
    }

    public boolean removeMovie(int index) {
        Movie m = movices.remove(index);
        return null != m ? true : false;

    }

    /**
     * 根据下标返回对应的对象
     *
     * @param index
     * @return
     */
    public Movie getMovieByIndex(int index) {
        if (index < 0 || index >= movices.size()) {
            return null;
        }
        return movices.get(index);
    }

    /**
     * 根据下标修改对象
     *
     * @param index
     * @param movie
     * @return
     */
    public boolean updateMovieByIndex_Obj(int index, Movie movie) {
        Movie m = movices.set(index, movie);
        return null == m ? false : true;
    }
}
