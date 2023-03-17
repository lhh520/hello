package back;

public class 旅游路线 {
    public long tourismRoutePlanning (int scenicspot) {
        if(scenicspot==0||scenicspot==1){
            return 1;
        }
        return tourismRoutePlanning(scenicspot-1)+tourismRoutePlanning(scenicspot-2);
    }
}
