package org.dylee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * BBusinessRuleEngine 테스트코드
 */
class BusinessRuleEngineTest {

    @Test
    void shouldHaveNoRulesInitially() {
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();

        assertEquals(0, businessRuleEngine.count());
    }

    @Test
    void shouldAddTwoActions() {
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();

        businessRuleEngine.addAction(() -> {});
        businessRuleEngine.addAction(() -> {});

        assertEquals(2, businessRuleEngine.count());
    }

    @Test
    void shouldExecuteOneAction() {
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();
        final Action mockAction = mock(Action.class);

        businessRuleEngine.addAction(mockAction);
        businessRuleEngine.run();

        verify(mockAction).execute();
    }
}