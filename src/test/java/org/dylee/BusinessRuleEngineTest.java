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
        var evn = new Facts();
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(evn);

        businessRuleEngine.addAction(facts -> {
            var jobTitle = facts.getFact("jobTitle");
            if ("CEO".equals(jobTitle)) {
                var name = facts.getFact("name");
                Mailer.sendEmail("sales@company.com", "Relevant customer: " + name);
            }
        });

        businessRuleEngine.addAction(facts -> {
            var dealStage = Stage.valueOf(facts.getFact("stage"));
            var amount = Double.parseDouble(facts.getFact("amount"));
            var forecastedAmount = amount * switch (dealStage) {
                case LEAD -> 0.2;
                case EVALUATING -> 0.5;
                case INTERESTED -> 0.8;
                case CLOSED -> 1;
            };
            facts.addFact("forecastedAmount", String.valueOf(forecastedAmount));
        });

        assertEquals(2, businessRuleEngine.count());
    }

    @Test
    void shouldExecuteOneAction() {
        var evn = new Facts();
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(evn);
        final Action mockAction = mock(Action.class);

        businessRuleEngine.addAction(mockAction);
        businessRuleEngine.run();

        verify(mockAction).execute(evn);
    }

    @Test
    public void shouldPerformAnActionWithFacts() {
        final Action mockAction = mock(Action.class);
        final Facts mockFacts = mock(Facts.class);
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

        businessRuleEngine.addAction(mockAction);
        businessRuleEngine.run();;

        verify(mockAction).execute(mockFacts);
    }
}