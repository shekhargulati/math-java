package mathchain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IntMathOperationsTests {

    @Test
    public void shouldChainAddAndSubtractOperationOnIntegers() throws Exception {
        int value = MathChain.chain(3).add(4).subtract(2).done();
        assertThat(value).isEqualTo(5);
    }

    @Test
    public void shouldChainAddSubtractMultiplyOnIntegers() throws Exception {
        int value = MathChain.chain(3).add(4).multiply(2).done();
        assertThat(value).isEqualTo(14);
    }

    @Test
    public void shouldChainAbsOnIntegers() throws Exception {
        int value = MathChain.chain(3).add(5).subtract(100).abs().done();
        assertThat(value).isEqualTo(92);
    }

    @Test
    public void shouldChainIncrementOnIntegers() throws Exception {
        int value = MathChain.chain(0).increment().done();
        assertThat(value).isEqualTo(1);
    }

    @Test
    public void shouldChainDecrementOnIntegers() throws Exception {
        int value = MathChain.chain(10).decrement().decrement().decrement().done();
        assertThat(value).isEqualTo(7);
    }

    @Test
    public void shouldChainIncrementDecrementTogether() throws Exception {
        int value = MathChain.chain(0).increment().increment().decrement().decrement().done();
        assertThat(value).isEqualTo(0);
    }

    @Test
    public void shouldChainNegate() throws Exception {
        int value = MathChain.chain(10).negate().done();
        assertThat(value).isEqualTo(-10);
    }

    @Test
    public void shouldChainMax() throws Exception {
        int value = MathChain.chain(1).add(2).add(4).max(8).done();
        assertThat(value).isEqualTo(8);
    }

    @Test
    public void shouldChainMin() throws Exception {
        int value = MathChain.chain(1).add(2).add(4).max(7).done();
        assertThat(value).isEqualTo(7);
    }
}
