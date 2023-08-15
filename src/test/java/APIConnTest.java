import static org.junit.jupiter.api.Assertions.*;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class APIConnTest {

    @Test
    public void testGetRate() {
        try {
            JSONObject taxaInfo = APIConn.getRate("CDI");
            assertNotNull(taxaInfo);
            assertTrue(taxaInfo.has("nome"));
            assertTrue(taxaInfo.has("valor"));
            assertFalse(taxaInfo.getString("nome").isEmpty());
            assertTrue(taxaInfo.getDouble("valor") > 0);
            assertTrue(taxaInfo.getDouble("valor") == 13.15);
        } catch (APIConn.APIException e) {
            fail("Exceção inesperada: " + e.getMessage());
        }
    }
}
