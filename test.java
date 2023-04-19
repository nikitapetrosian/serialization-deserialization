package labsys;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import static java.lang.System.out;
public class lab{
	public static void main(String[] args){
		Set<Integer> set=new HashSet<Integer>();
		int index=0;
		Random rand=new Random();
		while(index!=200){
			set.add(rand.nextInt(1000)+1);
			index++;
		}
		print_set(set);
		out.println();
		String str=serialize(set);
		out.println(str);
		print_set(unserialize(str));
	}
	public static String serialize(Set<Integer> set){
		StringBuilder sb=new StringBuilder();
		int index=0;
		for(Integer item:set){
			sb.append(Integer.toHexString(item));
			if (index<set.size()-1)
				sb.append(":");
			index++;
		}
		return sb.toString();
	}
	public static Set<Integer> unserialize(String str){
		Set<Integer> set=new HashSet<Integer>();
		String[] ar=str.split(":");
		for(String item:ar)
			if (!item.equals(":"))
				set.add(Integer.parseInt(item,16));
		return set;
	}
	public static void print_set(Set<Integer> set){
		for(Integer item:set){
			out.print(item);
			out.print(" ");
		}
	}
}
