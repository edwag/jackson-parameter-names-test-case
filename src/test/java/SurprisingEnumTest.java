import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class SurprisingEnumTest {

    private static final String EXPECTED_JSON_REPRESENTATION = "\"What I Expect To See\"";

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void canRespectJsonPropertyWhenSerializingEnum() throws Exception {
        String actualSerialization = objectMapper.writeValueAsString(SurprisingEnum.WHAT_I_ACTUALLY_SEE);
        assertThat(actualSerialization, equalTo(EXPECTED_JSON_REPRESENTATION));
    }

    @Test
    public void canRespectJsonPropertyWhenDeserializingEnum() throws Exception {
        SurprisingEnum enumValue = objectMapper.readValue(EXPECTED_JSON_REPRESENTATION, SurprisingEnum.class);
        assertThat(enumValue, equalTo(SurprisingEnum.WHAT_I_ACTUALLY_SEE));
    }

    @Test
    public void canRespectJsonPropertyWhenSerializingEnumWithParameterNamesModule() throws Exception {
        objectMapper.registerModule(new ParameterNamesModule());

        String actualSerialization = objectMapper.writeValueAsString(SurprisingEnum.WHAT_I_ACTUALLY_SEE);
        assertThat(actualSerialization, equalTo(EXPECTED_JSON_REPRESENTATION));
    }

    @Test
    public void canRespectJsonPropertyWhenDeserializingEnumWithParameterNamesModule() throws Exception {
        objectMapper.registerModule(new ParameterNamesModule());

        SurprisingEnum enumValue = objectMapper.readValue(EXPECTED_JSON_REPRESENTATION, SurprisingEnum.class);
        assertThat(enumValue, equalTo(SurprisingEnum.WHAT_I_ACTUALLY_SEE));
    }
}
