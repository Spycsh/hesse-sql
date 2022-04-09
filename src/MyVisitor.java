import java.util.*;

public class MyVisitor extends gBaseVisitor<Object>{
    Map<String, Object> map = new LinkedHashMap<>();

    @Override public Object visitStat(gParser.StatContext ctx) {
        if(ctx.END() != null && ctx.END().toString().equals(";")){
            System.out.println(map);
        }else{
            if(ctx.target().identifier() != null) {
                // TODO may have multiple identifiers
                String identifier = ctx.target().identifier().CHAR().toString();
                String op = ctx.OP().toString();
                switch(op) {
                    case "SELECT":
                        map.put("aggregated_attribute", identifier);
                        break;
                    case "FROM":
                        map.put("from", identifier);
                        break;
                    case "TO":
                        map.put("to", identifier);
                        break;
                    default:
                        System.out.println("unidentified operation: "+op);
                }
            }else if(ctx.target().region() != null){
                // TODO may need more logics to handle the brackets
                String startT = ctx.target().region().CHAR(0).toString();
                String endT = ctx.target().region().CHAR(1).toString();
                storeEntry("startT", startT);
                storeEntry("endT", endT);
            }else if(ctx.target().condition() != null){
                String op = ctx.OP().toString();
                if(op.equals("HAVING")){
                    List<Interval> regions = dfsComputeRegion(ctx.target().condition());

                    map.put("conditions", regions.toString());
                }
            }
        }

        return visitChildren(ctx);
    }

    private void storeEntry(String key, String value) {
        map.put(key, value);
    }

    // pre-order traversal of the ast tree
    // union or intersect the intervals
    // TODO support different identifiers
    private List<Interval> dfsComputeRegion(gParser.ConditionContext condition){
        if(condition.condition() == null){
            return getIntervals(condition.conditionStat());
        }

        List<Interval> leftIntervals = dfsComputeRegion(condition.condition());
        String conjunction = condition.CONJUNCTION().toString();
        List<Interval> rightIntervals = getIntervals(condition.conditionStat());
        return calculateIntervals(leftIntervals, conjunction, rightIntervals);
    }

    private List<Interval> calculateIntervals(List<Interval> leftIntervals, String conjunction, List<Interval> rightIntervals) {
        List<Interval> res = new ArrayList<>();
        switch (conjunction.trim()){
            case "and":
                res = intersect(leftIntervals, rightIntervals);
                break;
            case "or":
                res = union(leftIntervals, rightIntervals);
                break;
            default:
                System.out.println("unidentified conjunction: "+conjunction);
        }
        return res;
    }

    private List<Interval> union(List<Interval> leftIntervals, List<Interval> rightIntervals) {
        List<Interval> unionList = new ArrayList<>();

        leftIntervals.addAll(rightIntervals);
        leftIntervals.sort(Comparator.comparingInt(o -> Integer.parseInt(o.leftBound)));

        for(Interval interval: leftIntervals){
            int L = Integer.parseInt(interval.leftBound);
            int R = Integer.parseInt(interval.rightBound);

            if(unionList.size() == 0 || Integer.parseInt(unionList.get(unionList.size() - 1).rightBound) < L){
                unionList.add(new Interval(String.valueOf(L), String.valueOf(R)));
            }else{
                unionList.get(unionList.size() - 1).rightBound = String.valueOf(Math.max(
                        Integer.parseInt(unionList.get(unionList.size() - 1).rightBound), R));
            }
        }

        return unionList;
    }

    private List<Interval> intersect(List<Interval> leftIntervals, List<Interval> rightIntervals) {
        List<Interval> list = new ArrayList<>();

        for(Interval e1 : leftIntervals){
            for(Interval e2 : rightIntervals){
                Interval intersectedInterval = intersect(e1, e2);
                if(intersectedInterval != null)
                    list.add(intersectedInterval);
            }
        }
        return list;
    }

    private Interval intersect(Interval e1, Interval e2){
        int rightBound2 = Integer.parseInt(e2.rightBound);
        int leftBound1 = Integer.parseInt(e1.leftBound);
        int rightBound1 = Integer.parseInt(e1.rightBound);
        int leftBound2 = Integer.parseInt(e2.leftBound);

        // check whether two intervals intersect
        if(rightBound2 > leftBound1 && rightBound1 > leftBound2){
            return new Interval(String.valueOf(Math.max(leftBound1, leftBound2)), String.valueOf(Math.min(rightBound1, rightBound2)));
        }else{
            return null;
        }
    }

    // get open intervals
    private List<Interval> getIntervals(gParser.ConditionStatContext conditionStat){
        String relation = conditionStat.RELATION().toString();
        String num = conditionStat.CHAR().toString();
        List<Interval> intervals = new ArrayList<>();
        String maxVal = String.valueOf(Integer.MAX_VALUE);
        String minVal = String.valueOf(Integer.MIN_VALUE);
        switch(relation) {
            case ">":
                intervals.add(new Interval(num, maxVal));
                break;
            case "<":
                intervals.add(new Interval(minVal, num));
                break;
            case "=":
                intervals.add(new Interval(num, num));
                break;
            case "!=":
                intervals.add(new Interval(minVal, num));
                intervals.add(new Interval(num, maxVal));
                break;
            default:
                System.out.println("unidentified relation: "+relation);
        }

        return intervals;
    }

}

class Interval{
    String leftBound;
    String rightBound;

    public Interval(String leftBound, String rightBound) {
        this.leftBound = leftBound;
        this.rightBound = rightBound;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "leftBound='" + leftBound + '\'' +
                ", rightBound='" + rightBound + '\'' +
                '}';
    }
}

