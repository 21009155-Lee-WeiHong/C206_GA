//DONE BY LILIANNE TAN SHINYUE 21009379
import java.util.ArrayList;

public class Tuition {
	private String tuitioncode;
	private String tuitiontitle;
	private String groupname;
	private String tuitiondescription;
	private int tuitionduration;
	private boolean prerequisite;
	
		public Tuition(String tuitioncode, String tuitiontitle, String groupname, String tuitiondescription,
			int tuitionduration, boolean prerequisite) {
		this.tuitioncode = tuitioncode;
		this.tuitiontitle = tuitiontitle;
		this.groupname = groupname;
		this.tuitiondescription = tuitiondescription;
		this.tuitionduration = tuitionduration;
		this.prerequisite = prerequisite;
	}
	
		public static void setHeader(String string) {
			
		}
		public String getTuitioncode() {
			return tuitioncode;
		}


		public String getTuitiontitle() {
			return tuitiontitle;
		}


		public String getGroupname() {
			return groupname;
		}


		public String getTuitiondescription() {
			return tuitiondescription;
		}


		public int getTuitionduration() {
			return tuitionduration;
		}


		public boolean isPrerequisite() {
			return prerequisite;
		}

		@Override
		public String toString() {
			return "Tuition [tuitioncode=" + tuitioncode + ", tuitiontitle=" + tuitiontitle + ", groupname=" + groupname
					+ ", tuitiondescription=" + tuitiondescription + ", tuitionduration=" + tuitionduration
					+ ", prerequisite=" + prerequisite + "]";
		}
}
		

	


