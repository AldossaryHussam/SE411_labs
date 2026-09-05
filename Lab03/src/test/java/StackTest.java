import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import edu.psu.se411.model.Stack;

public class StackTest {

	@Test
	public void testPushAndPop() {
		Stack<String> stack = new Stack<>();
		stack.push("A");
		stack.push("Z");
		// successful test case

		assertEquals("Z", stack.pop());

		// Fail test case

		// assertEquals("A", stack.pop());

	}

	@Test
	public void pop_empty_stack() {
		Stack<String> stringStack = new Stack<>();
		NoSuchElementException thrown = assertThrows(NoSuchElementException.class, () -> stringStack.pop(),
				"Expected pop from empty Stack to throw, but it didn't");
		// this message was written in a way that was not identical to the message in
		// the Stack class, so this test will fail
		assertTrue(thrown.getMessage().equals("Stack is empty, can’t pop"));

	}

	@Test
	public void testRevearseOrderPop() {
		Stack<String> HussamAldossary = new Stack<>();
		HussamAldossary.push("A+");
		HussamAldossary.push("please give me an ");
		HussamAldossary.push("Dr Skander ");
		assertEquals("Dr Skander ", HussamAldossary.pop());
		assertEquals("please give me an ", HussamAldossary.pop());
		assertEquals("A+", HussamAldossary.pop());
	}

	@Test
	public void defaultConstructor_createsEmptyStackAndPopThrowsExpectedException() {
		Stack<String> stack = new Stack<>();

		NoSuchElementException thrown = assertThrows(NoSuchElementException.class, stack::pop);

		assertEquals("Stack is empty, can’t pop", thrown.getMessage());
	}

	@Test
	public void capacityConstructor_withPositiveCapacityBehavesNormally() {
		Stack<Integer> stack = new Stack<>(1);

		stack.push(42);

		assertEquals(42, stack.pop());
	}

	@Test
	public void capacityConstructor_withZeroUsesDefaultInternalCapacityAndStillWorks() {
		Stack<String> stack = new Stack<>(0);

		stack.push("x");

		assertEquals("x", stack.pop());
	}

	@Test
	public void capacityConstructor_withNegativeUsesDefaultInternalCapacityAndStillWorks() {
		Stack<String> stack = new Stack<>(-5);

		stack.push("y");

		assertEquals("y", stack.pop());
	}

	@Test
	public void pushAndPop_followLifoOrderAcrossMultipleCalls() {
		Stack<String> stack = new Stack<>();

		stack.push("A");
		stack.push("B");
		stack.push("C");

		assertEquals("C", stack.pop());
		assertEquals("B", stack.pop());
		assertEquals("A", stack.pop());
	}

	@Test
	public void push_acceptsNullAndPopReturnsNull() {
		Stack<String> stack = new Stack<>();

		stack.push(null);

		assertNull(stack.pop());
	}

	@Test
	public void popAfterRemovingAllElements_throwsExpectedExceptionAgain() {
		Stack<String> stack = new Stack<>();

		stack.push("only");
		assertEquals("only", stack.pop());

		NoSuchElementException thrown = assertThrows(NoSuchElementException.class, stack::pop);

		assertEquals("Stack is empty, can’t pop", thrown.getMessage());
	}
}
