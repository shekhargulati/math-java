package mathchain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MathChainTests {

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
}
