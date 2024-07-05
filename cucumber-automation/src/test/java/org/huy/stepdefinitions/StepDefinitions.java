package org.huy.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {
    private int x;
    private int y;
    private int result;

    @Given("x is {int}")
    public void x_is(Integer int1) {
        x = int1.intValue();
        System.out.println("x = " + x);
    }

    @Given("y is {int}")
    public void y_is(Integer int1) {
        y = int1.intValue();
        System.out.println("y = " + y);
    }

    @When("I add x and y")
    public void i_add_x_and_y() {
        result = x + y;
    }

    @Then("the result should be {int}")
    public void the_result_should_be(Integer int1) {
        assertEquals(int1.intValue(), result);
    }
}
