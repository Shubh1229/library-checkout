import java.util.ArrayList;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        List<UUID> uuidList = new ArrayList<>();
        for(int i = 0; i < 25; i++){
            uuidList.add(UUID.randomUUID());
        }

        for (var id : uuidList) {
            System.out.println(id.toString());
        }
    }
}
