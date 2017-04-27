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
	}

}
