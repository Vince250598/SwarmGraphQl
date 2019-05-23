/*package com.swarm.graphql;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Test;

import lombok.val;

public class ScalarDateTest {

	@Test
    public void parseValue() {
        // Given
		val input = (val) Date.from(LocalDate.of(2019, 1, 19).atStartOfDay(ZoneId.systemDefault()).toInstant());

        // When
		ScalarDate sd = new ScalarDate();
		val parseResult = (val) sd.getCoercing().parseValue(input);

        // Then
        assertThat(parseResult).isEqualTo("19-janv.-2019");
    }

}
*/