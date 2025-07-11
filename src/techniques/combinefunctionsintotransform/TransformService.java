package techniques.combinefunctionsintotransform;

import java.time.LocalDateTime;

public class TransformService {
    public static EnrichedRecord transform(DataRecord record){
        EnrichedRecord enrichedRecord = new EnrichedRecord(record.getFirstName(), record.getLastName(), record.getBirthYear());

        enrichedRecord.setFullName(record.getFirstName() + " " + record.getLastName());
        enrichedRecord.setAge(LocalDateTime.now().getYear() - record.getBirthYear());

        return enrichedRecord;
    }
}

