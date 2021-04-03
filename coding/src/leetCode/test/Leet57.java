package leetCode.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Leet57 {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		intervals.add(newInterval);
		List<Interval> res = new ArrayList<Interval>();
		Collections.sort(intervals,new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start-o2.start;
			}
		});
		int i = 1;
		newInterval = intervals.get(0);
		for(;i<intervals.size();i++) {
			Interval tmp = intervals.get(i);
			if (tmp.start>newInterval.end) {
				res.add(newInterval);
				newInterval = tmp;
			}else {
				newInterval.start = Math.min(newInterval.start, tmp.start);
				newInterval.end = Math.max(newInterval.end, tmp.end);
			}
		}
		res.add(newInterval);
		
		return res;
	}
}
