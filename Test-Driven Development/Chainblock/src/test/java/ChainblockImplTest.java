import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChainblockImplTest {
    private static final Transaction TRANSACTION = new TransactionImpl(
            1,
            TransactionStatus.SUCCESSFUL,
            "Kaloyan",
            "Mariya",
            1300d
    );

    private Chainblock chainblock;

    @Before
    public void setUp() {
        this.chainblock = new ChainblockImpl();
    }


    @Test
    public void afterAddingTransactionChainblockShouldContain() {
        this.chainblock.add(TRANSACTION);
        int count = this.chainblock.getCount();

        assertEquals(1, count);
    }
}
