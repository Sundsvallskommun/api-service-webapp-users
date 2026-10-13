package se.sundsvall.users.api.validation.impl;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class MunicipalityNameValidatorTest {

	private final MunicipalityNameValidator validator = new MunicipalityNameValidator();

	@ParameterizedTest
	@ValueSource(strings = {
		"Sundsvall", "sundsvall", "SUNDSVALL", "2281"
	})
	void validValues(final String value) {
		assertThat(validator.isValid(value, null)).isTrue();
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {
		" ", "Gotham", "9999", "Sundsvall kommun"
	})
	void invalidValues(final String value) {
		assertThat(validator.isValid(value, null)).isFalse();
	}
}
