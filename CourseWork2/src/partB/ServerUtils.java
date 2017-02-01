package partB;

public class ServerUtils {
	private static final String EOM = "a6b84ad5-5f6d-40b6-944f-28c31c1a297a"; //The magic string that signifies End Of Message. generated using UUID.randomUUID(). Probably overkill for our needs.
	
	public static String getEOM() {
		return EOM;
	}
}
