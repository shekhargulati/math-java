package mathchain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongMathOperationsTests {

    @Test
    public void shouldChainAddAndSubtractOperationOnLongs() throws Exception {
        long value = MathChain.chain(3L).add(4L).subtract(2L).done();
        assertThat(value).isEqualTo(5L);
    }

    @Test
    public void shouldChainAddSubtractMultiplyOnLongs() throws Exception {
        long value = MathChain.chain(3L).add(4L).multiply(2L).done();
        assertThat(value).isEqualTo(14L);
    }

    @Test
    public void shouldChainAbsOnLongs() throws Exception {
        long value = MathChain.chain(3L).add(5L).subtract(100L).abs().done();
        assertThat(value).isEqualTo(92);
    }

    @Test
    public void shouldChainIncrementOnLongs() throws Exception {
        long value = MathChain.chain(0L).increment().done();
        assertThat(value).isEqualTo(1L);
    }

    @Test
    public void shouldChainDecrementOnLongs() throws Exception {
        long value = MathChain.chain(10L).decrement().decrement().decrement().done();
        assertThat(value).isEqualTo(7L);
    }

    @Test
    public void shouldChainIncrementDecrementTogether() throws Exception {
        long value = MathChain.chain(0L).increment().increment().decrement().decrement().done();
        assertThat(value).isEqualTo(0L);
    }

    @Test
    public void shouldChainNegate() throws Exception {
        long value = MathChain.chain(10L).negate().done();
        assertThat(value).isEqualTo(-10L);
    }

    @Test
    public void shouldChainMax() throws Exception {
        long value = MathChain.chain(1L).add(2L).add(4L).max(8L).done();
        assertThat(value).isEqualTo(8L);
    }

    @Test
    public void shouldChainMin() throws Exception {
        long value = MathChain.chain(1L).add(2L).add(4L).max(7L).done();
        assertThat(value).isEqualTo(7L);
    }
}
