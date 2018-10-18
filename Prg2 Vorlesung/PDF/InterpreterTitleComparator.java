/*
 * Created on 	19.05.2016
 * @author  	Muehlbauer / BrM / MD
 */
import java.util.Comparator;


public class InterpreterTitleComparator implements Comparator<CompactDisc> {

 	@Override
 	public int compare(CompactDisc o1, CompactDisc o2) {
 		int naturalOrder = o1.compareTo(o2);
 		if(naturalOrder != 0) // different interpreters
 			return naturalOrder;
 	    else {                // same interpreters
            return(o1.getTitle().compareTo(o2.getTitle()));
        }
 	}

}