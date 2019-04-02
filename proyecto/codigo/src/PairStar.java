public class PairStar implements Comparable{

    long id;
    Double distance;

    PairStar(long id, Double distance){
        this.id = id;
        this.distance = distance;
    }

    @Override
    public int compareTo(Object pair) {
        PairStar pair2 = (PairStar) pair;
        return Double.compare(distance, pair2.distance);
    }

    @Override
    public boolean equals(Object obj) {
        PairStar pair2 = (PairStar) obj;
        return id == pair2.id;
    }
}
