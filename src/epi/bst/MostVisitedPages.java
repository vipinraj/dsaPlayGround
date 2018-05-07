// 15.8
package epi.bst;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.NavigableSet;

public class MostVisitedPages {
	public static void main(String[] args) {
		List<String> ids = Arrays.asList("g","a","t","t","a","a","a","g","t","c","t","a","t");
		printKDistinctPages(ids.iterator(), 4);
	}

	public static void printKDistinctPages(Iterator<String> iter, int k) {
		NavigableSet<PageIdEntry> pageCounts = new TreeSet<>();
		Map<String, PageIdEntry> pageIdToEntry = new HashMap<>();

		while (iter.hasNext()) {
			String pageId = iter.next();
			if (pageIdToEntry.containsKey(pageId)) {
				PageIdEntry e = pageIdToEntry.get(pageId);
				pageCounts.remove(e);
				e.frequency += 1;
				pageCounts.add(e);
			} else {
				PageIdEntry e = new PageIdEntry(pageId, 1);
				pageIdToEntry.put(pageId, e);
				pageCounts.add(e);
			}
			Iterator<PageIdEntry> e = pageCounts.descendingIterator();
			int i = 0;

			// System.out.println(pageIdToEntry);
			// System.out.println(pageCounts);
			System.out.println();
			while (e.hasNext() && i < k) {
				System.out.print(e.next());
				i++;
			}

		}
	}
}

class PageIdEntry implements Comparable<PageIdEntry> {
	String id;
	Integer frequency;

	PageIdEntry(String id, Integer frequency) {
		this.id = id;
		this.frequency = frequency;
	}

	@Override
	public int compareTo(PageIdEntry e) {
		int result = Integer.compare(this.frequency, e.frequency);
		if (result == 0) {
			result = this.id.compareTo(e.id);
		}
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof PageIdEntry)) {
			return false;
		}

		PageIdEntry e = (PageIdEntry)o;
		return this.id == e.id;
	}

	public String toString() {
		return "(" + id + "," + frequency + ")";
	}
}