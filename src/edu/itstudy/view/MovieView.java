package edu.itstudy.view;

import edu.itstudy.model.Movie;
import edu.itstudy.services.MoviceService;
import edu.itstudy.util.RandomUtil;
import edu.itstudy.util.ScannerUtil;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MovieView {
    private MoviceService ms = new MoviceService();

    public void mainMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.影片管理\t2.查看所有影片\t3.退出系统");
            System.out.print("请选择序号:");
            char c = ScannerUtil.readMenuSelect(3);
            choose1_first(c);
        }
    }

    /**
     * 一级选择
     *
     * @param choose
     */
    public void choose1_first(char choose) {
        switch (choose) {
            case '1':
                //影片管理
                System.out.println("1.上传影片\t2.删除影片\t3.修改影片\t4.返回上一级");
                System.out.print("请选择序号:");
                char c = ScannerUtil.readMenuSelect(4);
                choose11_manageMove(c);
                break;
            case '2':
                printMovies(ms.getMovices());
                if (ms.getMovices().size() == 0) {
                    return;
                }
                System.out.println("1.按条件搜索影片\t2.影片排序\t3.返回上一级");
                System.out.print("请选择序号:");
                char c2 = ScannerUtil.readMenuSelect(3);
                choose12_selectMove(c2);
                break;
            default:
                System.exit(0);//退出系统
        }
    }

    public void choose11_manageMove(char choose) {
        switch (choose) {
            case '1':
                //上传电影
                System.out.println("请输入电影相关属性：");
                Movie movie = addMovie();
                ms.addMovie(movie);
                System.out.println("=============影片上传成功==============");
                break;
            case '2':
                printMovies(ms.getMovices());
                if (ms.getMovices().size() == 0) {
                    return;
                }
                System.out.println("请选择要删除影片的序号(INDEX)：");
                Movie m = readIndex();
                boolean r = ms.removeMovie(m.getIndex());
                if (r) {
                    System.out.println("删除成功");
                }
                break;
            case '3':
                printMovies(ms.getMovices());
                if (ms.getMovices().size() == 0) {
                    return;
                }
                System.out.println("请输入修改影片的序号(不修改直接回车)：");
                Movie m1 = readIndex();
                System.out.println("请输入要修改的属性值(不修改直接回车):");
                Movie movie_update = updateMovie(m1);
                boolean r1 = ms.updateMovieByIndex_Obj(m1.getIndex(), movie_update);
                if (r1) {
                    System.out.println("修改成功");
                    System.out.println();
                }
                break;
            default:
                break;
        }
    }
    public void choose12_selectMove(char choose){
        switch (choose){
            case '1':
                //按条件搜索影片
                List<Movie> list = choose12_search();
                if(list==null){
                    break;
                }
                System.out.println("1.影片排序\t2.观看影片\t3.推荐影片\t4.返回影院系统\t5.退出系统");
                char c=ScannerUtil.readMenuSelect(5);
                 choose121(c,list);
                break;
            case '2':
                //影片排序
                ms.sort();
                break;
            default:
                break;
        }
    }
public void choose121(char c,List<Movie> list){
switch (c){
    case '1':
        //条件搜索后的影片排序
        System.out.println("请选择排序类别：");
        System.out.println("\t1.按名称\t2.按上映时间\t3.按类型\t4.按点击率\t5.按推荐率\t6.返回上一级");
        char c1 = ScannerUtil.readMenuSelect(6);
        ms.sort(c1,list);

        break;
    case '2':
        //观看影片

        watchMovie(ms.SEARCH_TJ);
        break;
    case '3':
        //推荐影片

        break;
    case '4':
        break;
    default:
        System.exit(0);
        break;
}
}
    /**
     * 多条件查询影片
     */
    public List<Movie> choose12_search(){
    System.out.println("请输入查询条件值：");
    System.out.println("影片名称：");
    String name = ScannerUtil.readString(5,null);

    System.out.println("影片类型：");
    String type = ScannerUtil.readString(5,null);

    System.out.println("影片主演：");
    String performer = ScannerUtil.readString(5,null);
    System.out.println("输入的搜索条件为：");
    if(null!=name){
        System.out.println("\t影片名称："+name);
    }
    if(null!=type){
        System.out.println("\t影片类型："+type);
    }
    if(null!=performer){
        System.out.println("\t影片主演："+performer);
    }
    if (null==name&&null==type&&null==performer){
        System.out.println("\t你没有输入条件");
    }
    System.out.println("1.搜索\t2.返回上一级");
    char c = ScannerUtil.readMenuSelect(2);
    List<Movie> list=null;
    if('1'==c){
        list=ms.searchMovie(name,type,performer);
        printMovies(list);

    }
        return list;
}
public void watchMovie(String flag){
    System.out.println("请选择要观看影片的序号(INDEX):");
    int index=ScannerUtil.readInt();
    //修改影片点击率


}

    public Movie addMovie() {
        System.out.println("影片名称：");
        String name = ScannerUtil.readString(5);

        System.out.println("影片类型：");
        String type = ScannerUtil.readString(5);

        System.out.println("影片主演：");
        String performer = ScannerUtil.readString(5);

        System.out.println("影片导演：");
        String guider = ScannerUtil.readString(5);

        System.out.println("影片上映日期(2020-02-02)：");
        Date date = ScannerUtil.readDate("YYYY-MM-dd");

        int mid = RandomUtil.getRandomInt();
        Movie movie = new Movie(mid, name, type, performer, date, guider, 0, 0);
        return movie;
    }

    private Movie updateMovie(Movie movie) {
        System.out.println("影片名称(" + movie.getName() + ")：");
        String name = ScannerUtil.readString(5, movie.getName());

        System.out.println("影片类型(" + movie.getType() + ")：");
        String type = ScannerUtil.readString(5, movie.getType());

        System.out.println("影片主演(" + movie.getPerformer() + ")：");
        String performer = ScannerUtil.readString(5, movie.getPerformer());

        System.out.println("影片导演(" + movie.getGuider() + ")：");
        String guider = ScannerUtil.readString(5, movie.getGuider());

        System.out.println("影片上映日期(" + movie.getDateStr() + ")：");
        Date date = ScannerUtil.readDate("yyyy-MM-dd", movie.getDate());


        movie = new Movie(movie.getMid(), name, type, performer, date, guider, movie.getClickRate(), movie.getRecommendRate());
        return movie;
    }

    private Movie readIndex() {
        Movie m = null;
        while (true) {
            int index = ScannerUtil.readInt();
            m = ms.getMovieByIndex(--index);
            if (null == m) {
                System.out.println("输入的电影序号不存在，请重新输入：");
                continue;
            }
            m.setIndex(index);
            break;
        }
        return m;
    }
    private void printMovies(List<Movie> movices) {
        System.out.println("===============影片列表===============");
        System.out.println("INDEX/ID\t名称\t类型\t主演\t导演\t上映日期\t\t点击率\t推荐率");
        if(movices.size()==0){
            System.out.println("暂无影片");
        }
        int i = 1;
        for (Movie m : movices) {
            System.out.println(i + "/" + m);
            i++;
        }
    }
}

