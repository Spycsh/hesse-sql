import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyVisitor extends gBaseVisitor<Object>{
    HashMap<String, String> map = new HashMap<>();

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
                    default:
                        System.out.println("unidentified operation: "+op);
                }
                storeEntry(ctx.OP().toString(), identifier);
            }else if(ctx.target().region() != null){
                // TODO may need more logics to handle the brackets
                String startT = ctx.target().region().CHAR(0).toString();
                String endT = ctx.target().region().CHAR(1).toString();
                storeEntry("startT", startT);
                storeEntry("endT", endT);
            }else if(ctx.target().condition() != null){
                String op = ctx.OP().toString();
                if(op.equals("HAVING")){
                    dfsComputeRegion(ctx.target().condition());

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

        List<Interval> leftInterval = dfsComputeRegion(condition.condition());
        String conjunction = condition.CONJUNCTION().toString();
        List<Interval> rightInterval = getIntervals(condition.conditionStat());
        return calculateIntervals(leftInterval, conjunction, rightInterval);
    }

    private List<Interval> calculateIntervals(List<Interval> leftInterval, String conjunction, List<Interval> rightInterval) {
        List<Interval> res = new ArrayList<>();
        switch (conjunction){
            case "and":
                res = intersect(leftInterval, rightInterval);
                break;
            case "or":
                res = union(leftInterval, rightInterval);
                break;
            default:
                System.out.println("unidentified conjunction: "+conjunction);
        }
        return res;
    }

    private List<Interval> union(List<Interval> leftInterval, List<Interval> rightInterval) {
        List<Interval> list = new ArrayList<>();
        for(Interval e1:leftInterval){
            for(Interval e2:rightInterval){
                list.addAll(union(e1, e2));
            }
        }
        return list;
    }

    private List<Interval> union(Interval e1, Interval e2){
        List<Interval> intervals = new ArrayList<>();
        int rightBound2 = Integer.parseInt(e2.rightBound);
        int leftBound1 = Integer.parseInt(e1.leftBound);
        int rightBound1 = Integer.parseInt(e1.rightBound);
        int leftBound2 = Integer.parseInt(e2.leftBound);

        if(rightBound2 > leftBound1 && rightBound1 < leftBound2){
            Interval interval = new Interval(String.valueOf(Math.min(leftBound1, leftBound2)), String.valueOf(Math.max(rightBound1, rightBound2)));
            intervals.add(interval);
        }else{
            intervals.add(e1);
            intervals.add(e2);
        }
        return intervals;

    }

    private List<Interval> intersect(List<Interval> leftInterval, List<Interval> rightInterval) {
        List<Interval> list = new ArrayList<>();
        for(Interval e1:leftInterval){
            for(Interval e2:rightInterval){
                Interval intersectedInterval = intersect(e1, e2);
                if(intersectedInterval != null)
                    list.add(intersect(e1, e2));
            }
        }
        return list;
    }

    private Interval intersect(Interval e1, Interval e2){
        int rightBound2 = Integer.parseInt(e2.rightBound);
        int leftBound1 = Integer.parseInt(e1.leftBound);
        int rightBound1 = Integer.parseInt(e1.rightBound);
        int leftBound2 = Integer.parseInt(e2.leftBound);

        if(rightBound2 > leftBound1 && rightBound1 < leftBound2){
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
}

