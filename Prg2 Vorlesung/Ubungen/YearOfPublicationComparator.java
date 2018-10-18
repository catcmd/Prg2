/*
 * Created on 	19.05.2016
 * @author  	Muehlbauer / BrM / MD
 */

import java.util.Comparator;


public class YearOfPublicationComparator implements Comparator<CompactDisc> {
 	@Override
 	public int compare(CompactDisc arg0, CompactDisc arg1) {
 		if (arg0.getYearOfPublication() < arg1.getYearOfPublication())
 			return -1;
 		else if (arg0.getYearOfPublication() > arg1.getYearOfPublication())
 			return 1;
 		else
 			return 0;


 	}
}


/*
Alternative without generics
public class YearOfPublicationComparator implements Comparator {
    @Override
    public int compare(Object o0, Object o1) {
        CompactDisc arg0 = (CompactDisc) o0;
        CompactDisc arg1 = (CompactDisc) o1;

        if (arg0.getYearOfPublication() < arg1.getYearOfPublication())
            return -1;
        else if (arg0.getYearOfPublication() > arg1.getYearOfPublication())
            return 1;
        else
            return 0;
    }
}
*/