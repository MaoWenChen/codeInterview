package leetCode.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Leet56 {
	static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	class Solution {
		public List<Interval> merge(List<Interval> intervals) {
			List<Interval> list = new ArrayList<Interval>();
			if (intervals.isEmpty()) {
				return list;
			}
			Collections.sort(intervals,new Comparator<Interval>() {

				@Override
				public int compare(Interval o1, Interval o2) {
					
					return o1.start-o2.start;
				}
			});
			Interval tmp = intervals.get(0);
			for (int i = 1; i < intervals.size(); i++) {
				Interval interval = intervals.get(i);
				if (tmp.end<interval.start) {
					list.add(tmp);
					tmp = interval;
				}else {
					tmp.start = Math.min(tmp.start, interval.start);
					tmp.end = Math.max(tmp.end, interval.end);
				}
			}
			list.add(tmp);
			return list;
		}
	}
}
