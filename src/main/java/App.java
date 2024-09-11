import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import java.math.BigDecimal;

public class App {
  public static void main (String [] args) {
    JsonNodeFactory f = JsonNodeFactory.withExactBigDecimals(true);
    ObjectMapper mapper = new ObjectMapper();
    mapper.findAndRegisterModules()
        .setNodeFactory(f)
        .configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true)
        .configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
    String str = "-11000.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
    try {
      BigDecimal num = mapper.readValue(str, BigDecimal.class);
      System.out.println(num);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
