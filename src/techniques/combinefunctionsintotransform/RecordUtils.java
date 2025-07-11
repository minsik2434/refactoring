package techniques.combinefunctionsintotransform;

import java.time.LocalDateTime;

public class RecordUtils {
    public static String getFullName(DataRecord record){
        return record.getFirstName() + " " + record.getLastName();
    }

    public static int calculateAge(DataRecord record){
        return LocalDateTime.now().getYear() - record.getBirthYear();
    }
}
