package pl.koziolekweb.pwm.bdd;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ScenarioStage;
import com.tngtech.jgiven.annotation.ScenarioState;
import com.tngtech.jgiven.junit5.JGivenExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(JGivenExtension.class)
class SimpleCalculatorBddStyleTest {

	@ScenarioStage
	private GivenStage given;

	@ScenarioStage
	private WhenStage when;

	@ScenarioStage
	private ThenStage then;

	private SimpleCalculatorBddStyle sut;

	@BeforeEach
	void setUp() {
		this.sut =new  SimpleCalculatorBddStyle();
	}

	@Test
	void add2And2() {
		given.forAddends(2, 2);
		when.sut(sut).performAdd();
		then.sumIsEqualTo(4);
	}
}
//...
class GivenStage extends Stage<GivenStage> {

	@ScenarioState
	int addendA;
	@ScenarioState
	int addendB;

	public GivenStage forAddends(int addendA, int addendB) {
		this.addendA = addendA;
		this.addendB = addendB;
		return self();
	}
}

class WhenStage extends Stage<WhenStage> {

	@ScenarioState(required = true)
	int addendA;

	@ScenarioState(required = true)
	int addendB;

	@ScenarioState
	int sum;

	SimpleCalculatorBddStyle sut;

	public WhenStage sut(SimpleCalculatorBddStyle sut){
		this.sut = sut;
		return self();
	}

	public WhenStage performAdd() {
		this.sum = this.sut.sum(addendA, addendB);
		return self();
	}
}

class ThenStage extends Stage<ThenStage> {

	@ScenarioState(required = true)
	int sum;

	public ThenStage sumIsEqualTo(int expected) {
		assertThat(this.sum).isEqualTo(expected);
		return self();
	}
}