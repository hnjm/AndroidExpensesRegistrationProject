package androidexpensesregistration.domain.types;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeInterval {		
	private Date startDate;
	private Date endDate;
	private final static SimpleDateFormat sdf 
	= new SimpleDateFormat("hh:mm:ss");
	
	public TimeInterval(String startTime, String endTime) throws ParseException, IllegalArgumentException{
		startDate = sdf.parse(endTime);
		endDate = sdf.parse(endTime);
		if (startDate.after(endDate))
			throw new IllegalArgumentException("Start Time Can't be Greater Than End Time!");
	}
		
	public String getStartTimeString() {
		return sdf.format(startDate);
	}
	public String getEndTimeString() {
		return sdf.format(endDate);
	}		
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeInterval other = (TimeInterval) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!getEndTimeString().equals(other.getEndTimeString()))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!getStartTimeString().equals(other.getStartTimeString()))
			return false;
		return true;
	}
}
