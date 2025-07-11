package techniques.combinefunctionsintotransform;

public class Client {
    public static void main(String[] args) {
        DataRecord record = new DataRecord("Choi", "Min", 1999);

        EnrichedRecord eRecord = TransformService.transform(record);
        System.out.println("Name : " + eRecord.getFullName());
        System.out.println("age : " + eRecord.getAge());
    }
}
