package mathchain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DoubleMathOperationsTests {

    @Test
    public void shouldChainAddAndSubtractOperationOnDoubles() throws Exception {
        double value = MathChain.chain(3.0).add(4.0).subtract(2.0).done();
        assertThat(value).isEqualTo(5.0);
    }

    @Test
    public void shouldChainAddSubtractMultiplyOnDoubles() throws Exception {
        double value = MathChain.chain(3.0).add(4.0).multiply(2.0).done();
        assertThat(value).isEqualTo(14.0);
    }

    @Test
    public void shouldChainAbsOnDoubles() throws Exception {
        double value = MathChain.chain(3.0).add(5.0).subtract(100.0).abs().done();
        assertThat(value).isEqualTo(92.0);
    }

    @Test
    public void shouldChainIncrementOnDoubles() throws Exception {
        double value = MathChain.chain(0.0).increment().done();
        assertThat(value).isEqualTo(1.0);
    }

    @Test
    public void shouldChainDecrementOnDoubles() throws Exception {
        double value = MathChain.chain(10.0).decrement().decrement().decrement().done();
        assertThat(value).isEqualTo(7.0);
    }

    @Test
    public void shouldChainIncrementDecrementTogether() throws Exception {
        double value = MathChain.chain(0.0).increment().increment().decrement().decrement().done();
        assertThat(value).isEqualTo(0.0);
    }

    @Test
    public void shouldChainNegate() throws Exception {
        double value = MathChain.chain(10.0).negate().done();
        assertThat(value).isEqualTo(-10.0);
    }

    @Test
    public void shouldChainMax() throws Exception {
        double value = MathChain.chain(1.0).add(2.0).add(4.0).max(8.0).done();
        assertThat(value).isEqualTo(8.0);
    }

    @Test
    public void shouldChainMin() throws Exception {
        double value = MathChain.chain(1.0).add(2.0).add(4.0).max(7.0).done();
        assertThat(value).isEqualTo(7.0);
    }
}
