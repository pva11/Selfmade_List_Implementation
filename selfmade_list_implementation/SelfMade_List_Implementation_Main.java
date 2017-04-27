package selfmade_list_implementation;

public class SelfMade_List_Implementation_Main {

	//different tests
	public static void main(String[] args) {

		List<Integer> arlist = new ArrayList<Integer>();
		arlist.add(1);
		arlist.add(3);
		arlist.add(0, 0);
		arlist.add(4);
		arlist.add(2,2);

		System.out.println(arlist.toString());
//
//		int a1 = arlist.get(1);
//		System.out.println(a1);
//
//		int a2 = arlist.get(3);
//		System.out.println(a2);
//
//		int aset = arlist.set(2, 11);
//		System.out.println(aset);
//
//		System.out.println(arlist.toString());
//
//		int arem = arlist.remove(2);
//		System.out.println(arem);
//
//		System.out.println(arlist.toString());
//
//		arlist.add(2, 4);
//
//		System.out.println(arlist.toString());
//
//		System.out.println(arlist.indexOf(4));
//		System.out.println(arlist.lastIndexOf(4));
//
//		System.out.println(arlist.contains(3));
//		System.out.println(arlist.contains(77));
//
//		List<Integer> subArList = arlist.subList(1, 3);
//		System.out.println(subArList.toString());
//
////		subArList.clear();
////		System.out.println(subArList);
//
//		if (arlist.addAll(subArList)){
//			System.out.println(arlist);
//		}
//
//
//		if (arlist.addAll(0,subArList)){
//			System.out.println(arlist);
//		}
//		System.out.println(arlist.size());
//		System.out.println(arlist.isEmpty());
//
//		List<Integer> stock = new ArrayList<Integer>();
//		if (arlist.getAll(stock)) {
//			System.out.println(stock);
//		}
//
//		//////////////////////////////////////////////////////
//
//		List<Integer> lnlist = new LinkedList<Integer>();
//		lnlist.add(1);
//		lnlist.add(3);
//		lnlist.add(0, 0);
//		lnlist.add(4);
//		lnlist.add(2,2);
//
//		System.out.println(lnlist.toString());
//
//		int a3 = lnlist.get(1);
//		System.out.println(a3);
//
//		int a4 = lnlist.get(3);
//		System.out.println(a4);
//
//		int lset = lnlist.set(2, 11);
//		System.out.println(lset);
//
//		System.out.println(lnlist.toString());
//
//		int lrem = lnlist.remove(2);
//		System.out.println(lrem);
//
//		System.out.println(lnlist.toString());
//
//		lnlist.add(2, 4);
//
//		System.out.println(lnlist.toString());
//
//		System.out.println(lnlist.indexOf(4));
//		System.out.println(lnlist.lastIndexOf(4));
//
//		System.out.println(lnlist.contains(3));
//		System.out.println(lnlist.contains(77));
//
//		List<Integer> subLnList = lnlist.subList(1, 3);
//		System.out.println(subLnList.toString());
//
////		subLnList.clear();
////		System.out.println(subLnList);
//
//		if (lnlist.addAll(subLnList)) {;
//			System.out.println(lnlist);
//		}
//		if (lnlist.addAll(0,subLnList)) {;
//			System.out.println(lnlist);
//		}
//
//		System.out.println(lnlist.size());
//		System.out.println(lnlist.isEmpty());
//
//		List<Integer> stockLn = new LinkedList<Integer>();
//		if (lnlist.getAll(stockLn)) {
//			System.out.println(stockLn);
//		}

//				LinkedList<Integer> list = new LinkedList<Integer>();
//
//				list.add(5);
//				list.add(1);
//				list.add(3);
//
//
//
//				Iterator<Integer> iter = list.iterator();
//				iter.remove();
////				if (iter.hasNext()) {
//////					System.out.println(iter.next());
////					iter.next();
//////					iter.remove();
//////					iter.remove();
////				}
//
//				Iterator<Integer> iter1 = list.iterator();
//				while (iter1.hasNext()) {
//					System.out.println(iter1.next());
//				}

//				for (Integer i : list) {
//					System.out.println(i);
//				}


	}

}
