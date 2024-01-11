package org.dylee;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class InspectorTest {
    @Test
    public void inspectOneConditionEvaluatesTrue() {

        final Facts facts = new Facts();
        facts.addFact("jobTitle", "CEO");
        final ConditionalAction conditionalAction = new JobTitleCondition();
        final Inspector inspector = new Inspector(conditionalAction);

        final List<Diagnosis> diagnosisList = inspector.inspect(facts);

        assertEquals(1, diagnosisList.size());
        assertEquals(true, diagnosisList.get(0).isPositive());


    }

    private static class JobTitleCondition implements ConditionalAction {

        @Override
        public void execute(Facts facts) {

        }

        @Override
        public boolean evaluate(Facts facts) {
            return "CEO".equals(facts.getFact("jobTitle"));
        }
    }
}
